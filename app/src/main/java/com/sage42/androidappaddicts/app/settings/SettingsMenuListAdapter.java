package com.sage42.androidappaddicts.app.settings;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Adapter to drive the side menu.
 */
public class SettingsMenuListAdapter extends ArrayAdapter<SettingsMenuItem>
{
    public SettingsMenuListAdapter(final Context context)
    {
        super(context, android.R.layout.simple_list_item_1, SettingsMenuData.MENU_ITEMS);
    }

    /*
     * (non-Javadoc)
     * @see android.widget.ArrayAdapter#getView(int, android.view.View,
     * android.view.ViewGroup)
     */
    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent)
    {
        SettingsMenuItemLayout menuItemLayout;
        // create or recycle adapter
        if (convertView == null)
        {
            menuItemLayout = SettingsMenuItemLayout_.build(this.getContext());
        }
        else
        {
            menuItemLayout = (SettingsMenuItemLayout) convertView;
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
        final SettingsMenuItem data = this.getItem(position);
        if ((data == null) || data.isClickable())
        {
            return false;
        }
        return true;
    }

}
