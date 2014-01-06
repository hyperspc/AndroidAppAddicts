package com.sage42.androidappaddicts.app.main;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.sage42.androidappaddicts.R;
import com.sage42.androidappaddicts.app.Fragment1_;
import com.sage42.androidappaddicts.app.menu.MenuDrawClickListener;
import com.sage42.androidappaddicts.app.menu.MenuDrawClickListener.IMenuDrawCallbacks;
import com.sage42.androidappaddicts.app.menu.MenuListAdapter;

/**
 * Copyright (C) 2013- Sage 42 App Sdn Bhd Licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
@EActivity(R.layout.main_activity)
@OptionsMenu(R.menu.main)
public class MainActivity extends Activity implements IMenuDrawCallbacks
{

    @ViewById(R.id.main_drawer_layout)
    protected DrawerLayout        mDrawerLayout;

    @ViewById(R.id.main_menu_layout)
    protected ListView            mMenuList;

    private ActionBarDrawerToggle mDrawerToggle;

    /**
     * Initialize the title, drawer, menu drawer and ActionBar.
     */
    @AfterViews
    void init()
    {

        this.mDrawerToggle = new ActionBarDrawerToggle(this, this.mDrawerLayout, R.drawable.ic_drawer_light,
                        R.string.drawer_open, R.string.drawer_close)
        {
            /**
             * Called when a drawer has settled in a completely closed state.
             * 
             * @see android.support.v4.app.ActionBarDrawerToggle#onDrawerClosed(android.view.View)
             */
            @Override
            public void onDrawerClosed(final View view)
            {
                // MainActivity.this.getSherlock().getActionBar().setTitle(MainActivity.this.mTitle);
                // creates call to onPrepareOptionsMenu()
                MainActivity.this.invalidateOptionsMenu();
            }

            /**
             * Called when a drawer has settled in a completely open state.
             * 
             * @see android.support.v4.app.ActionBarDrawerToggle#onDrawerOpened(android.view.View)
             */
            @Override
            public void onDrawerOpened(final View drawerView)
            {
                // creates call to onPrepareOptionsMenu()
                MainActivity.this.invalidateOptionsMenu();
            }
        };

        // Set the drawer toggle as the DrawerListener
        this.mDrawerLayout.setDrawerListener(this.mDrawerToggle);

        // setup the menu list
        this.mMenuList.setAdapter(new MenuListAdapter(this));
        this.mMenuList.setOnItemClickListener(new MenuDrawClickListener(this));

        this.showFragment(new Fragment1_(), R.string.fragment1, false);

        this.getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu)
    {
        // final MenuInflater inflater = new
        // MenuInflater(this.getActionBar().getThemedContext());
        // inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                // home btn
                if (!this.getAvailableBackStack())
                {
                    if (this.mDrawerLayout.isDrawerOpen(this.mMenuList))
                    {
                        this.mDrawerLayout.closeDrawer(this.mMenuList);
                    }
                    else
                    {
                        this.mDrawerLayout.openDrawer(this.mMenuList);
                    }
                }
                return true;
            default:
                break;
        }

        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

    /**
     * Show the previous fragment which is stored in the fragment transaction.
     * 
     * @return
     */
    public boolean getAvailableBackStack()
    {
        final FragmentManager fragmentManager = this.getFragmentManager();

        // check the fragmentManager and show the previous fragment

        if (fragmentManager.getBackStackEntryCount() != 0)
        {
            fragmentManager.popBackStack();

            if (fragmentManager.getBackStackEntryCount() == 1)
            {
                this.mDrawerToggle.syncState();
            }
            return true;
        }

        return false;
    }

    // /**
    // * Click event of the "Click me" button
    // */
    // @Click(R.id.main_click_me)
    // protected void onClickClickMe()
    // {
    // Toast.makeText(this, R.string.main_ouch, Toast.LENGTH_LONG).show();
    // }

    @Override
    public void showFragment(Fragment fragment, int titleResId, boolean addToBackstack)
    {
        final FragmentManager fragmentManager = this.getFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content_fragment, fragment);
        if (addToBackstack)
        {
            transaction.addToBackStack(null);

        }
        else
        {
            this.clearAllBackStack();

            this.mDrawerToggle.syncState();
        }
        transaction.commit();

        // close the drawer
        this.mDrawerLayout.closeDrawer(this.mMenuList);
    }

    /**
     * Remove all back stack to avoid missing flow on back pressed.
     */
    public void clearAllBackStack()
    {
        final FragmentManager fragmentManager = this.getFragmentManager();

        final int backStackCount = fragmentManager.getBackStackEntryCount();
        for (int i = 0; i < backStackCount; i++)
        {
            // removing all the stored backstack
            final int backStackId = fragmentManager.getBackStackEntryAt(i).getId();
            fragmentManager.popBackStack(backStackId, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

    }
}
