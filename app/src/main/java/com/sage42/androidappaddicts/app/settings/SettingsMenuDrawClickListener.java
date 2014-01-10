package com.sage42.androidappaddicts.app.settings;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * Response to menu list click events.
 */
public class SettingsMenuDrawClickListener implements OnItemClickListener
{

    /**
     * Process side menu items.
     */
    @Override
    public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long viewId)
    {
        // switch the fragment content to match the selected menu item
        switch (position)
        {
            case SettingsMenuData.SETTING1:

                break;

            case SettingsMenuData.SETTING2:

                break;

            case SettingsMenuData.SETTING3:

                break;

            case SettingsMenuData.SETTING4:

                break;
            case SettingsMenuData.SETTING5:

                break;

            case SettingsMenuData.SETTING6:

                break;

            case SettingsMenuData.SETTING7:

                break;

            case SettingsMenuData.SETTING8:

                break;
            default:
                // do nothing
                break;
        }

    }

}
