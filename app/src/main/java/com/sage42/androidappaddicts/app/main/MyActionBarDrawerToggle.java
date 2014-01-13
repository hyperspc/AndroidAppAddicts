package com.sage42.androidappaddicts.app.main;

import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

public class MyActionBarDrawerToggle extends ActionBarDrawerToggle
{
    private final Activity mActivity;

    public MyActionBarDrawerToggle(final Activity activity, final DrawerLayout drawerLayout, final int drawerImageRes,
                    final int openDrawerContentDescRes, final int closeDrawerContentDescRes)
    {
        super(activity, drawerLayout, drawerImageRes, openDrawerContentDescRes, closeDrawerContentDescRes);
        this.mActivity = activity;
    }

    /**
     * Called when a drawer has settled in a completely closed state.
     *
     * @see android.support.v4.app.ActionBarDrawerToggle#onDrawerClosed(View)
     */
    @Override
    public void onDrawerClosed(final View view)
    {
        // getActionBar().setTitle(mTitle);
        // creates call to onPrepareOptionsMenu()
        this.mActivity.invalidateOptionsMenu();
    }

    /**
     * Called when a drawer has settled in a completely open state.
     *
     * @see android.support.v4.app.ActionBarDrawerToggle#onDrawerOpened(View)
     */
    @Override
    public void onDrawerOpened(final View drawerView)
    {
        // creates call to onPrepareOptionsMenu()
        this.mActivity.invalidateOptionsMenu();
    }
}