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
import java.util.HashMap;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import se.emilsjolander.sprinkles.CursorList;
import se.emilsjolander.sprinkles.ManyQuery;
import se.emilsjolander.sprinkles.Query;
import android.app.Fragment;
import android.util.Log;
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
    protected ListView                     mListView;

    private Episode                        mEpisode;
    private final List<List<App>>          mListApp = new ArrayList<List<App>>();
    public ByShowSelectedListCursorAdapter mAdapter;

    /**
     * Wire the data to the UI
     */
    @AfterViews
    protected void init()
    {
        this.getActivity().getActionBar().setTitle(R.string.applist_by_show_selected_title);
        this.buildUi();
        // Dummy code.
        // final String[] listviewItemCollectionDesc = new String[]
        //        { "applist_row_item_image1", //$NON-NLS-1$
        //                        "applist_row_item_title1", //$NON-NLS-1$
        //                        "applist_row_item_desc1", //$NON-NLS-1$
        //                        "applist_row_item_price1" //$NON-NLS-1$
        //
        // };
        // final int[] listviewItemCollection = new int[]
        // { R.id.applist_row_item_image, R.id.applist_row_item_title, R.id.applist_row_item_desc,
        // R.id.applist_row_item_price };
        //
        // final View header = this.getActivity().getLayoutInflater()
        // .inflate(R.layout.applist_by_show_selected_list_header, null);
        //
        // this.mListView.addHeaderView(header, null, false);
        // final List<HashMap<String, String>> data = this.getData();
        // final SimpleAdapter adapter = new SimpleAdapter(this.getActivity(), data, R.layout.applist_row_of_3,
        // listviewItemCollectionDesc, listviewItemCollection);
        //
        // this.mListView.setAdapter(adapter);

    }

    public void bind(final Episode episode)
    {
        this.mEpisode = episode;
    }

    public void buildUi()
    {
        if (this.mEpisode != null && this.mListView != null)
        {
            final ByShowSelectedListHeader_ header = (ByShowSelectedListHeader_) ByShowSelectedListHeader_.build(this
                            .getActivity());
            header.bind(this.mEpisode);
            this.mListView.addHeaderView(header, null, false);

            Query.many(App.class,
                            "select * from app as A join  app_episode_relation as aer on a.app_id = aer.app_id AND aer.episode_id = ?",
                            new Long[]
                            { this.mEpisode.getId() }).getAsync(this.getLoaderManager(), this.onAppLoaded, App.class);

            this.mAdapter = new ByShowSelectedListCursorAdapter(this.getActivity());
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

                                                                       Log.w("LIST", result.get(loop).getName() + " = "
                                                                                       + result.get(loop + 1).getName()
                                                                                       + " = "
                                                                                       + result.get(loop + 2).getName());

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

    /**
     * Dummy code just for display purpose.
     * 
     * @return
     */
    public List<HashMap<String, String>> getData()
    {
        int count = 0;
        final List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
        for (int loop = 0; loop < 20; loop++)
        {
            final HashMap<String, String> map = new HashMap<String, String>();
            count += 1;
            map.put("applist_row_item_image1", Integer.toString(R.drawable.santa)); //$NON-NLS-1$
            map.put("applist_row_item_title1", "Santa No :" + count); //$NON-NLS-1$ //$NON-NLS-2$
            map.put("applist_row_item_desc1", "App Maker No :" + count); //$NON-NLS-1$ //$NON-NLS-2$
            map.put("applist_row_item_price1", "FREE"); //$NON-NLS-1$//$NON-NLS-2$

            fillMaps.add(map);

        }
        return fillMaps;
    }
}
