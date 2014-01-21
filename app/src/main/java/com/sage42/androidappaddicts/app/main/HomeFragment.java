/**
 * Copyright (C) 2013-2014 Sage 42 Apps Sdn Bhd Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 */
package com.sage42.androidappaddicts.app.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import android.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.sage42.androidappaddicts.R;
import com.sage42.androidappaddicts.app.applist.*;
import com.sage42.androidappaddicts.app.main.MainActivity;

/**
 * Fragment to display the list of shows.
 */

@OptionsMenu(R.menu.general)
@EFragment(R.layout.home_fragment)
public class HomeFragment extends Fragment
{

    @ViewById(R.id.home_listview)
    ListView mListView;

    /**
     * Wire the data to the UI
     */
    @AfterViews
    void init()
    {

        this.getActivity().getActionBar().setTitle(R.string.main_home_title);
        final String[] listviewItemCollectionDesc = new String[]
        { "applist_row_item_image", "applist_row_item_title", "applist_row_item_desc", "applist_row_item_price" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

        final int[] listviewItemCollection = new int[]
        { R.id.applist_row_item_image, R.id.applist_row_item_title, R.id.applist_row_item_desc,
                        R.id.applist_row_item_price };

        final View header = this.getActivity().getLayoutInflater().inflate(R.layout.applist_show_listview_header, null);
        final TextView showAll = (TextView) header.findViewById(R.id.applist_show_all);
        showAll.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(final View v)
            {
                HomeFragment.this.showAllShows();
            }

        });
        this.mListView.addHeaderView(header, null, false);
        final List<HashMap<String, String>> data = this.getData();
        final SimpleAdapter adapter = new SimpleAdapter(this.getActivity(), data, R.layout.applist_row_of_3,
                        listviewItemCollectionDesc, listviewItemCollection);

        this.mListView.setAdapter(adapter);

    }

    public void showAllShows()
    {
        final ByShowFragment_ detailsPage = new ByShowFragment_();
        ((MainActivity) this.getActivity()).showFragment(detailsPage, true);
    }

    /**
     * Set the screen title.
     */
    @Override
    public void onStart()
    {
        super.onStart();

        this.getActivity().getActionBar().setTitle(R.string.applist_by_show_title);
    }

    public List<HashMap<String, String>> getData()
    {
        int count = 0;
        final List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
        for (int loop = 0; loop < 20; loop++)
        {
            final HashMap<String, String> map = new HashMap<String, String>();
            count += 1;
            map.put("applist_row_item_image", Integer.toString(R.drawable.list_activated_holo)); //$NON-NLS-1$
            map.put("applist_row_item_title", "Title No :" + count); //$NON-NLS-1$ //$NON-NLS-2$
            map.put("applist_row_item_desc", "Item description No :" + count); //$NON-NLS-1$ //$NON-NLS-2$
            map.put("applist_row_item_price", "FREE"); //$NON-NLS-1$//$NON-NLS-2$
            count += 1;
            map.put("applist_row_item_image", Integer.toString(R.drawable.list_activated_holo)); //$NON-NLS-1$
            map.put("applist_row_item_title", "Title No :" + count); //$NON-NLS-1$ //$NON-NLS-2$
            map.put("applist_row_item_desc", "Item description No :" + count); //$NON-NLS-1$ //$NON-NLS-2$
            map.put("applist_row_item_price", "FREE"); //$NON-NLS-1$//$NON-NLS-2$
            count += 1;
            map.put("applist_row_item_image", Integer.toString(R.drawable.list_activated_holo)); //$NON-NLS-1$
            map.put("applist_row_item_title", "Title No :" + count); //$NON-NLS-1$ //$NON-NLS-2$
            map.put("applist_row_item_desc", "Item description No :" + count); //$NON-NLS-1$ //$NON-NLS-2$
            map.put("applist_row_item_price", "FREE"); //$NON-NLS-1$//$NON-NLS-2$
            fillMaps.add(map);

        }
        return fillMaps;
    }
}
