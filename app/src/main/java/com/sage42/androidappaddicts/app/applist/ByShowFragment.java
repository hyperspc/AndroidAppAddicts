/**
 *  Copyright (C) 2013-2014 Sage 42 Apps Sdn Bhd
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.sage42.androidappaddicts.app.applist;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import se.emilsjolander.sprinkles.CursorList;
import se.emilsjolander.sprinkles.ManyQuery;
import se.emilsjolander.sprinkles.Query;

import android.app.Fragment;
import android.widget.ListView;

import com.sage42.androidappaddicts.app.R;
import com.sage42.androidappaddicts.app.main.MainActivity;
import com.sage42.androidappaddicts.app.model.data.Episode;

/**
 * Fragment to display the list of shows.
 */

@OptionsMenu(R.menu.general)
@EFragment(R.layout.applist_by_show_fragment)
public class ByShowFragment extends Fragment
{

    public ByShowEpisodeAdapter mAdapter;

    @ViewById(R.id.by_show_list)
    protected ListView    mListView;

    @ItemClick(R.id.by_show_list)
    public void onListClick(final int position)
    {
        final ByShowSelectedFragment_ detailsPage = new ByShowSelectedFragment_();
        ((MainActivity) this.getActivity()).showFragment(detailsPage, true);
        detailsPage.bind(this.mAdapter.getItem(position));

    }

    /**
     * Wire the data to the UI
     */
    @SuppressWarnings("unchecked")
    @AfterViews
    void init()
    {
        this.getActivity().getActionBar().setTitle(R.string.applist_by_show_title);

        if (this.mAdapter == null)
        {
            this.mAdapter = new ByShowEpisodeAdapter(this.getActivity());
            Query.many(Episode.class, "select * From Episode order by episode_id desc").getAsync(this.getLoaderManager(), this.onNotesLoaded, Episode.class); //$NON-NLS-1$

        }

        this.mListView.setAdapter(this.mAdapter);

    }

    private final ManyQuery.ResultHandler<Episode> onNotesLoaded = new ManyQuery.ResultHandler<Episode>()
                                                                 {

                                                                     @Override
                                                                     public boolean handleResult(
                                                                                     final CursorList<Episode> result)
                                                                     {
                                                                         ByShowFragment.this.mAdapter.swapNotes(result);
                                                                         return true;
                                                                     }
                                                                 };
}
