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
