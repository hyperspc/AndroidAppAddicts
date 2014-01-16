/**
 * Copyright (C) 2013-2014 Sage 42 Apps Sdn Bhd Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 */
package com.sage42.androidappaddicts.app.hosts;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sage42.androidappaddicts.R;

/**
 * a custom layout class that hold the gridview UI structure and used it as ContentViewHolder for adapters.
 */
@EViewGroup(R.layout.grid_content)
public class GridViewItemLayout extends RelativeLayout
{

    @ViewById(R.id.grid_item_menu)
    protected ImageView mGridMenu;

    @ViewById(R.id.grid_item_image)
    protected ImageView mGridViewImg;

    @ViewById(R.id.grid_item_title)
    protected TextView  mTitle;

    @ViewById(R.id.grid_item_desc)
    protected TextView  mDesc;

    /**
     * constructor.
     * 
     * @param context
     */
    public GridViewItemLayout(final Context context)
    {
        super(context);
    }

    /**
     * fire up the Popupmenu and provide the routing selection.
     */
    @Click(R.id.grid_item_menu)
    void OpenMenu()
    {

        // not yet implement.
    }
}
