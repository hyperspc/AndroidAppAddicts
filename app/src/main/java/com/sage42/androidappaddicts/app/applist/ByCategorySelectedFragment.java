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

import android.app.Fragment;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.sage42.androidappaddicts.R;

/**
 * Fragment to display the list of apps by the category selected.
 */
@OptionsMenu(R.menu.general)
@EFragment(R.layout.applist_by_category_selected_fragment)
public class ByCategorySelectedFragment extends Fragment
{
    @ViewById(R.id.app_by_category_selected_listview)
    ListView mListView;

    /**
     * Wire the data to the UI
     */
    @AfterViews
    void init()
    {

        this.getActivity().getActionBar().setTitle(R.string.applist_by_category_title);
        final String[] listviewItemCollectionDesc = new String[]
        { "image_1", "title_1", "desc_1", "type_1" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

        final int[] listviewItemCollection = new int[]
        { R.id.category_list_image, R.id.category_list_title, R.id.category_list_desc, R.id.category_type };

        final List<HashMap<String, String>> data = this.getData();
        final SimpleAdapter adapter = new SimpleAdapter(this.getActivity(), data,
                        R.layout.applist_by_category_selected_list_item, listviewItemCollectionDesc,
                        listviewItemCollection);

        this.mListView.setAdapter(adapter);

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
            map.put("image_1", Integer.toString(R.drawable.list_activated_holo)); //$NON-NLS-1$
            map.put("title_1", "Title No :" + count); //$NON-NLS-1$ //$NON-NLS-2$
            map.put("desc_1", "Item description No :" + count); //$NON-NLS-1$ //$NON-NLS-2$
            map.put("type_1", "FREE"); //$NON-NLS-1$//$NON-NLS-2$
            count += 1;
            fillMaps.add(map);
        }
        return fillMaps;
    }
}
