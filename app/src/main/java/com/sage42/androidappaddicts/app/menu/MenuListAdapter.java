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
