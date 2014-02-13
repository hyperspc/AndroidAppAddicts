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

package com.sage42.androidappaddicts.app.main;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import se.emilsjolander.sprinkles.CursorList;
import se.emilsjolander.sprinkles.ManyQuery;
import se.emilsjolander.sprinkles.Query;

import android.app.Fragment;
import android.widget.ListView;
import com.sage42.androidappaddicts.app.R;

import com.sage42.androidappaddicts.app.applist.ByShowSelectedListAdapter;
import com.sage42.androidappaddicts.app.model.data.App;
import com.sage42.androidappaddicts.app.model.data.Episode;

/**
 * Fragment to display the list of shows.
 */

@OptionsMenu(R.menu.general)
@EFragment(R.layout.home_fragment)
public class HomeFragment extends Fragment
{
    @ViewById(R.id.home_listview)
    protected ListView                     mListView;

    public final List<List<App>>           mListApp = new ArrayList<List<App>>();
    public ByShowSelectedListAdapter mAdapter;

    /**
     * Wire the data to the UI
     */
    @AfterViews
    protected void init()
    {

        this.buildUi();

    }

    public void buildUi()
    {
        if (this.mListView != null)
        {
            final HomeListHeader_ header = (HomeListHeader_) HomeListHeader_.build(this.getActivity());

            final Episode episode = Query.one(Episode.class, " select * , max(episode_id) as episode_id From Episode") //$NON-NLS-1$
                            .get();

            header.bind(episode);
            this.mListView.addHeaderView(header, null, false);
            this.mAdapter = new ByShowSelectedListAdapter(this.getActivity());
            Query.many(App.class,
                            "select * from app as A join  app_episode_relation as aer on a.app_id = aer.app_id AND aer.episode_id = ?", //$NON-NLS-1$
                            new Long[]
                            { episode.getId() }).getAsync(this.getLoaderManager(), this.onAppLoaded, App.class);

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

                                                                       HomeFragment.this.mListApp.add(templist);

                                                                   }
                                                                   HomeFragment.this.mAdapter
                                                                                   .swapList(HomeFragment.this.mListApp);
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

        this.getActivity().getActionBar().setTitle(R.string.home_title);
    }

}
