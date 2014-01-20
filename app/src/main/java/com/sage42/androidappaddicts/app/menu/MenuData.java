/**
 * Copyright (C) 2013-2014 Sage 42 Apps Sdn Bhd Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 */
package com.sage42.androidappaddicts.app.menu;

import java.util.ArrayList;
import com.sage42.androidappaddicts.R;

public class MenuData
{
    public static final ArrayList<MenuItem> MENU_ITEMS;

    public static final int                 FRAGMENT_HOME           = 0;
    public static final int                 FRAGMENT_SHOW           = 1;
    public static final int                 FRAGMENT_CATEGORY       = 2;
    public static final int                 FRAGMENT_APP_SUGGESTION = 3;
    public static final int                 FRAGMENT_HOSTS          = 4;

    static
    {
        MENU_ITEMS = new ArrayList<MenuItem>();

        MenuData.MENU_ITEMS.add(new MenuItem(R.drawable.ic_latest, R.string.applist_latest, false));
        MenuData.MENU_ITEMS.add(new MenuItem(R.drawable.ic_storage, R.string.applist_by_show_title, false));
        MenuData.MENU_ITEMS.add(new MenuItem(R.drawable.ic_grid, R.string.applist_by_category_title, false));
        MenuData.MENU_ITEMS.add(new MenuItem(R.drawable.ic_rating_good, R.string.suggest_suggest_title, false));
        MenuData.MENU_ITEMS.add(new MenuItem(R.drawable.ic_mic, R.string.hosts_hosts_title, false));

    }
}
