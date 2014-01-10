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
package com.sage42.androidappaddicts.app.menu;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sage42.androidappaddicts.R;

@EViewGroup(R.layout.main_menu_item)
public class MenuItemLayout extends RelativeLayout
{
    @ViewById(R.id.menu_item_header)
    protected TextView mHeader;

    @ViewById(R.id.menu_item_content)
    protected TextView mContent;

    /**
     * Default constructor.
     * 
     * @param context
     */
    public MenuItemLayout(final Context context)
    {
        super(context);
    }

    /**
     * Bind the data to the UI.
     * 
     * @param data
     */
    public void renderItem(final MenuItem data)
    {
        // toggle between header and item display
        if (data.isCategoryMarker())
        {
            this.mHeader.setText(data.getTitleResId());
            this.mHeader.setVisibility(View.VISIBLE);
            this.mContent.setVisibility(View.GONE);
        }
        else
        {
            this.mContent.setText(data.getTitleResId());
            this.mHeader.setVisibility(View.GONE);
            this.mContent.setVisibility(View.VISIBLE);
        }

        if (data.getIconResId() != null)
        {
            // assign icon
            this.mContent.setCompoundDrawablesWithIntrinsicBounds(data.getIconResId(), 0, 0, 0);
        }
        else
        {
            // hide the icon
            this.mContent.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

}
