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
package com.sage42.androidappaddicts.app.suggestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import android.app.Fragment;
import android.widget.AutoCompleteTextView;
import android.widget.SimpleAdapter;
import com.sage42.androidappaddicts.R;

/**
 * Fragment to display the suggest an app form.
 */
@OptionsMenu(R.menu.suggestion)
@EFragment(R.layout.suggestion_fragment)
public class SuggestionFragment extends Fragment
{
    @ViewById(R.id.suggestion_app_name)
    protected AutoCompleteTextView mAppText;

    /**
     * Wire the data to the UI
     */
    @AfterViews
    protected void init()
    {
        // Dummy code for autocompleteText.
        final String[] listviewItemCollectionDesc = new String[]
        { "suggestion_applist_title" }; //$NON-NLS-1$ 

        final int[] listviewItemCollection = new int[]
        { R.id.suggestion_applist_title };

        final List<HashMap<String, String>> data = this.getData();
        final SimpleAdapter adapter = new SimpleAdapter(this.getActivity(), data, R.layout.suggestion_applist_item,
                        listviewItemCollectionDesc, listviewItemCollection);

        this.mAppText.setAdapter(adapter);
    }

    /**
     * Set the screen title.
     */
    @Override
    public void onStart()
    {
        super.onStart();

        this.getActivity().getActionBar().setTitle(R.string.suggest_suggest_title);
    }

    /**
     * Dummy code just for display the autocompleteText result. TODO: remove this method
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
            map.put("suggestion_applist_title", "App No :" + count); //$NON-NLS-1$ //$NON-NLS-2$
            fillMaps.add(map);
        }
        return fillMaps;
    }
}
