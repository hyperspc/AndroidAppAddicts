package com.sage42.androidappaddicts.app.settings;

import java.util.ArrayList;

import com.sage42.androidappaddicts.R;

public class SettingsMenuData
{
    public static final ArrayList<SettingsMenuItem> MENU_ITEMS;

    public static final int                         SETTING1 = 1;
    public static final int                         SETTING2 = 2;
    public static final int                         SETTING3 = 3;
    public static final int                         SETTING4 = 4;
    public static final int                         SETTING5 = 5;
    public static final int                         SETTING6 = 6;
    public static final int                         SETTING7 = 7;
    public static final int                         SETTING8 = 8;
    static
    {
        MENU_ITEMS = new ArrayList<SettingsMenuItem>();
        SettingsMenuData.MENU_ITEMS.add(new SettingsMenuItem(R.string.settings_1, true, false));
        SettingsMenuData.MENU_ITEMS.add(new SettingsMenuItem(R.string.settings_2, true, true));
        SettingsMenuData.MENU_ITEMS.add(new SettingsMenuItem(R.string.settings_3, true, true));
        SettingsMenuData.MENU_ITEMS.add(new SettingsMenuItem(R.string.settings_4, true, true));
        SettingsMenuData.MENU_ITEMS.add(new SettingsMenuItem(R.string.settings_5, true, true));
        SettingsMenuData.MENU_ITEMS.add(new SettingsMenuItem(R.string.settings_6, true, false));
        SettingsMenuData.MENU_ITEMS.add(new SettingsMenuItem(R.string.settings_7, true, true));
        SettingsMenuData.MENU_ITEMS.add(new SettingsMenuItem(R.string.settings_8, true, true));
    }
}
