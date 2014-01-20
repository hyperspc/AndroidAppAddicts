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