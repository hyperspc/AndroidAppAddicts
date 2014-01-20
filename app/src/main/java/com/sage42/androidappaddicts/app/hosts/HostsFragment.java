/**
 * Copyright (C) 2013-2014 Sage 42 Apps Sdn Bhd Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 */
package com.sage42.androidappaddicts.app.hosts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import android.app.Fragment;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.sage42.androidappaddicts.R;

/**
 * Hosts fragment.
 */
@OptionsMenu(R.menu.general)
@EFragment(R.layout.hosts_fragment)
public class HostsFragment extends Fragment
{
    @ViewById(R.id.hosts_grid)
    protected GridView mGridView;

    /**
     * Wire the data to the UI
     */
    @AfterViews
    void init()
    {

        final String[] listviewItemCollectionDesc = new String[]
        { "grid_item_image", "grid_item_title", "grid_item_desc" }; //$NON-NLS-1$ //$NON-NLS-2$

        final int[] listviewItemCollection = new int[]
        { R.id.grid_item_image, R.id.grid_item_title, R.id.grid_item_desc };

        final List<HashMap<String, String>> data = this.getData();
        final SimpleAdapter adapter = new SimpleAdapter(this.getActivity(), data, R.layout.grid_content,
                        listviewItemCollectionDesc, listviewItemCollection);

        this.mGridView.setAdapter(adapter);
    }

    @ItemClick(R.id.hosts_grid)
    void onClickShowGooglePlusPage()
    {
        Toast.makeText(this.getActivity(), "not yet implemented", Toast.LENGTH_LONG).show(); //$NON-NLS-1$
    }

    /**
     * Set the screen title.
     */
    @Override
    public void onStart()
    {
        super.onStart();

        this.getActivity().getActionBar().setTitle(R.string.hosts_hosts_title);
    }

    public List<HashMap<String, String>> getData()
    {

        final List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
        for (int loop = 0; loop < 20; loop++)
        {
            final HashMap<String, String> map = new HashMap<String, String>();

            map.put("grid_item_image", Integer.toString(R.drawable.list_activated_holo)); //$NON-NLS-1$
            map.put("grid_item_title", "Title No :" + loop); //$NON-NLS-1$ //$NON-NLS-2$
            map.put("grid_item_desc", "Description :" + loop); //$NON-NLS-1$ //$NON-NLS-2$

            fillMaps.add(map);

        }
        return fillMaps;
    }
}
