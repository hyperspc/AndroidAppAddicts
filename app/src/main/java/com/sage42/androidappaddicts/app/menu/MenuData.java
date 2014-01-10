package com.sage42.androidappaddicts.app.menu;

import java.util.ArrayList;

import com.sage42.androidappaddicts.R;

public class MenuData
{
    public static final ArrayList<MenuItem> MENU_ITEMS;

    public static final int                 FRAGMENT_CATEGORY       = 0;
    public static final int                 FRAGMENT_EPISODE        = 1;
    public static final int                 FRAGMENT_APP_SUGGESTION = 2;
    public static final int                 FRAGMENT_HOST           = 3;

    static
    {
        MENU_ITEMS = new ArrayList<MenuItem>();
        // MenuData.MENU_ITEMS.add(new MenuItem(R.drawable.ic_drawer, R.string.fragment_title, true));
        MenuData.MENU_ITEMS.add(new MenuItem(R.drawable.ic_storage, R.string.fragment_episode_title, false));
        MenuData.MENU_ITEMS.add(new MenuItem(R.drawable.ic_grid, R.string.fragment_category_title, false));
        MenuData.MENU_ITEMS.add(new MenuItem(R.drawable.ic_rating_good, R.string.fragment_suggest_title, false));
        MenuData.MENU_ITEMS.add(new MenuItem(R.drawable.ic_mic, R.string.fragment_host_title, false));
    }
}
