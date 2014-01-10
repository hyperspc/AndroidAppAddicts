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

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Adapter to drive the side menu.
 */
public class MenuListAdapter extends ArrayAdapter<MenuItem>
{
    public MenuListAdapter(final Context context)
    {
        super(context, android.R.layout.simple_list_item_1, MenuData.MENU_ITEMS);
    }

    /*
     * (non-Javadoc)
     * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
     */
    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent)
    {
        MenuItemLayout menuItemLayout;
        // create or recycle adapter
        if (convertView == null)
        {
            menuItemLayout = MenuItemLayout_.build(this.getContext());
        }
        else
        {
            menuItemLayout = (MenuItemLayout) convertView;
        }

        menuItemLayout.renderItem(this.getItem(position));
        return menuItemLayout;
    }

    /**
     * Make some (category titles) not clickable.
     */
    @Override
    public boolean isEnabled(final int position)
    {
        final MenuItem data = this.getItem(position);
        if (data == null || data.isCategoryMarker())
        {
            return false;
        }
        return true;
    }

}
