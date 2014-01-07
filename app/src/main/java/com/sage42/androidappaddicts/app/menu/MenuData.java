package com.sage42.androidappaddicts.app.menu;

import java.util.ArrayList;

import com.sage42.androidappaddicts.R;

public class MenuData
{
    public static final ArrayList<MenuItem> MENU_ITEMS;

    public static final int                 FRAGMENT_CATEGORY       = 1;
    public static final int                 FRAGMENT_EPISODE        = 2;
    public static final int                 FRAGMENT_APP_SUGGESTION = 3;
    public static final int                 FRAGMENT_HOST           = 4;

    static
    {
        MENU_ITEMS = new ArrayList<MenuItem>();
        MenuData.MENU_ITEMS.add(new MenuItem(null, R.string.fragment_title, true, false));
        MenuData.MENU_ITEMS.add(new MenuItem(null, R.string.fragment_episode_title, false, true));
        MenuData.MENU_ITEMS.add(new MenuItem(null, R.string.fragment_category_title, false, true));
        MenuData.MENU_ITEMS.add(new MenuItem(null, R.string.fragment_suggest_title, true, true));
        MenuData.MENU_ITEMS.add(new MenuItem(null, R.string.fragment_host_title, true, true));
    }
}
