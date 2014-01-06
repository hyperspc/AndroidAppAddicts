package com.sage42.androidappaddicts.app.menu;

import java.util.ArrayList;

import com.sage42.androidappaddicts.R;

public class MenuData
{
    public static final ArrayList<MenuItem> MENU_ITEMS;

    public static final int                 MENU_FRAGMENT1 = 1;
    public static final int                 MENU_FRAGMENT2 = 2;
    public static final int                 MENU_FRAGMENT3 = 3;
    public static final int                 MENU_FRAGMENT4 = 4;

    static
    {
        MENU_ITEMS = new ArrayList<MenuItem>();
        MenuData.MENU_ITEMS.add(new MenuItem(null, R.string.fragment_title, true));
        MenuData.MENU_ITEMS.add(new MenuItem(R.drawable.ic_launcher, R.string.fragment1, false));
        MenuData.MENU_ITEMS.add(new MenuItem(R.drawable.ic_launcher, R.string.fragment2, false));
        MenuData.MENU_ITEMS.add(new MenuItem(R.drawable.ic_launcher, R.string.fragment3, false));
        MenuData.MENU_ITEMS.add(new MenuItem(R.drawable.ic_launcher, R.string.fragment4, false));
    }
}
