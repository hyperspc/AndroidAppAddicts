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

import android.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sage42.androidappaddicts.app.R;
import com.sage42.androidappaddicts.app.main.MainActivity;

/**
 * Fragment to display the list of app categories.
 */
@OptionsMenu(R.menu.general)
@EFragment(R.layout.applist_by_category_fragment)
public class ByCategoryFragment extends Fragment
{
    @ViewById(R.id.app_by_category_listview)
    protected ListView mListView;

    @ItemClick(R.id.app_by_category_listview)
    protected void onItemSelect()
    {
        final ByCategorySelectedFragment_ detailsPage = new ByCategorySelectedFragment_();
        ((MainActivity) this.getActivity()).showFragment(detailsPage, true);
    }

    /**
     * Wire the data to the UI
     */
    @AfterViews
    void init()
    {
        this.getActivity().getActionBar().setTitle(R.string.applist_by_category_title);

        // Dummy Code for displaying list of category
        final ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                        R.array.applist_by_category_array, R.layout.applist_by_category_list_item);
        this.mListView.setAdapter(adapter);
    }

}
