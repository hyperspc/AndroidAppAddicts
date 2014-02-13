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

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import se.emilsjolander.sprinkles.CursorList;
import se.emilsjolander.sprinkles.ManyQuery;
import se.emilsjolander.sprinkles.Query;
import android.app.Fragment;
import android.widget.ListView;

import com.sage42.androidappaddicts.app.R;
import com.sage42.androidappaddicts.app.model.data.App;
import com.sage42.androidappaddicts.app.model.data.Episode;

/**
 * Display list of apps by the selected show.
 */
@OptionsMenu(R.menu.general)
@EFragment(R.layout.applist_by_show_selected_fragment)
public class ByShowSelectedFragment extends Fragment
{
    @ViewById(R.id.app_by_show_selected_listview)
    protected ListView               mListView;

    @InstanceState
    protected Episode                mEpisode;

    public final List<List<App>>     mListApp = new ArrayList<List<App>>();
    public ByShowSelectedListAdapter mAdapter;

    /**
     * Wire the data to the UI
     */
    @AfterViews
    protected void init()
    {
        this.getActivity().getActionBar().setTitle(R.string.applist_by_show_selected_title);
        this.buildUi();

    }

    public void bind(final Episode episode)
    {
        this.mEpisode = episode;
    }

    private void buildUi()
    {
        if (this.mEpisode != null && this.mListView != null)
        {
            final ByShowSelectedListHeader_ header = (ByShowSelectedListHeader_) ByShowSelectedListHeader_.build(this
                            .getActivity());
            header.bind(this.mEpisode);
            this.mListView.addHeaderView(header, null, false);
            this.mAdapter = new ByShowSelectedListAdapter(this.getActivity());
            Query.many(App.class,
                            "select * from app as A join  app_episode_relation as aer on a.app_id = aer.app_id AND aer.episode_id = ?", //$NON-NLS-1$
                            new Long[]
                            { this.mEpisode.getId() }).getAsync(this.getLoaderManager(), this.onAppLoaded, App.class);

            this.mListView.setAdapter(this.mAdapter);
        }
    }

    private final ManyQuery.ResultHandler<App> onAppLoaded = new ManyQuery.ResultHandler<App>()
                                                           {

                                                               @Override
                                                               public boolean handleResult(final CursorList<App> result)
                                                               {

                                                                   for (int loop = 0; loop < result.size(); loop += 3)
                                                                   {

                                                                       final List<App> templist = new ArrayList<App>();

                                                                       templist.add(result.get(loop));
                                                                       if (loop + 1 < result.size())
                                                                       {
                                                                           templist.add(result.get(loop + 1));
                                                                       }
                                                                       if (loop + 2 < result.size())
                                                                       {
                                                                           templist.add(result.get(loop + 2));
                                                                       }

                                                                       ByShowSelectedFragment.this.mListApp
                                                                                       .add(templist);

                                                                   }
                                                                   ByShowSelectedFragment.this.mAdapter
                                                                                   .swapList(ByShowSelectedFragment.this.mListApp);
                                                                   return true;
                                                               }
                                                           };

    /**
     * Set the screen title.
     */
    @Override
    public void onStart()
    {
        super.onStart();

        this.getActivity().getActionBar().setTitle(R.string.applist_by_show_title);
    }

}
