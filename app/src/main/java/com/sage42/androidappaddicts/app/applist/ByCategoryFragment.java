/**
 * Copyright (C) 2013-2014 Sage 42 Apps Sdn Bhd Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 */
package com.sage42.androidappaddicts.app.applist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import android.app.Fragment;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.sage42.androidappaddicts.R;

/**
 * Fragment to display the list of app categories.
 */
@OptionsMenu(R.menu.general)
@EFragment(R.layout.applist_by_category_fragment)
public class ByCategoryFragment extends Fragment
{
    @ViewById(R.id.app_by_category_listview)
    ListView mListView;

    /**
     * Wire the data to the UI
     */
    @AfterViews
    void init()
    {

        this.getActivity().getActionBar().setTitle(R.string.applist_by_category_title);
        final String[] listviewItemCollectionDesc = new String[]
        { "title_1" }; //$NON-NLS-1$ 

        final int[] listviewItemCollection = new int[]
        { R.id.list_title };

        final List<HashMap<String, String>> data = this.getData();
        final SimpleAdapter adapter = new SimpleAdapter(this.getActivity(), data, R.layout.listview_category,
                        listviewItemCollectionDesc, listviewItemCollection);

        this.mListView.setAdapter(adapter);

    }

    public List<HashMap<String, String>> getData()
    {
        int count = 0;
        final List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
        for (int loop = 0; loop < 20; loop++)
        {
            final HashMap<String, String> map = new HashMap<String, String>();
            count += 1;

            map.put("title_1", "Title No :" + count); //$NON-NLS-1$ //$NON-NLS-2$

            fillMaps.add(map);

        }
        return fillMaps;
    }
}
