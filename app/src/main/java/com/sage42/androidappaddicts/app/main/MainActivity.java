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

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Context;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.widget.ListView;
import android.widget.SearchView;

import com.sage42.androidappaddicts.R;
import com.sage42.androidappaddicts.app.menu.MenuData;
import com.sage42.androidappaddicts.app.menu.MenuListAdapter;
import com.sage42.androidappaddicts.app.util.IntentUtils;

@EActivity(R.layout.main_activity)
public class MainActivity extends Activity
{
    @ViewById(R.id.main_drawer_layout)
    protected DrawerLayout        mDrawerLayout;

    @ViewById(R.id.main_menu_layout)
    protected ListView            mMenuDrawerList;

    private ActionBarDrawerToggle mDrawerToggle;

    private SearchView            mSearchView;
    private MenuItem              mSearchViewMenuItem;

    @InstanceState
    protected boolean             mNotFirstRun;

    /**
     * Initialize the title, drawer, menu drawer and ActionBar.
     */
    @AfterViews
    protected void init()
    {
        this.mDrawerToggle = new MyActionBarDrawerToggle(this, this.mDrawerLayout, R.drawable.ic_drawer,
                        R.string.drawer_open, R.string.drawer_close);

        // Set the drawer toggle as the DrawerListener
        this.mDrawerLayout.setDrawerListener(this.mDrawerToggle);

        // setup the menu list
        this.mMenuDrawerList.setAdapter(new MenuListAdapter(this));

        // show default content (events)
        if (!this.mNotFirstRun)
        {
            this.showFragment(new HomeFragment_(), false);
            this.mNotFirstRun = true;
        }

        this.getActionBar().setDisplayHomeAsUpEnabled(true);
        this.mDrawerToggle.syncState();
    }

    @ItemClick(R.id.main_menu_layout)
    protected void onDrawerItemClick(final int position)
    {
        switch (position)
        {
            case MenuData.FRAGMENT_HOME:
                this.showFragment(new HomeFragment_(), false);
                break;

            case MenuData.FRAGMENT_SHOW:
                this.showFragment(new ByShowFragment_(), false);
                break;

            case MenuData.FRAGMENT_CATEGORY:
                this.showFragment(new ByCategoryFragment_(), false);
                break;

            case MenuData.FRAGMENT_APP_SUGGESTION:
                this.showFragment(new SuggestionFragment_(), false);
                break;

            case MenuData.FRAGMENT_HOSTS:
                this.showFragment(new HostsFragment_(), false);
                break;

            default:
                // do nothing
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu)
    {
        this.initSearchView(menu);
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
                    if (this.mDrawerLayout.isDrawerOpen(this.mMenuDrawerList))
                    {
                        this.mDrawerLayout.closeDrawer(this.mMenuDrawerList);
                    }
                    else
                    {
                        this.mDrawerLayout.openDrawer(this.mMenuDrawerList);
                    }
                }
                return true;

            case R.id.action_search:
                this.showFragment(new SearchResultFragment_(), true);
                break;

            case R.id.action_about:
                this.showFragment(new AboutFragment_(), true);
                break;

            case R.id.action_share:
                IntentUtils.doShare(this, this.getResources().getString(R.string.app_name)
                                + this.getResources().getString(R.string.app_market_address));
                break;
            case R.id.action_settings:
                this.showFragment(new SettingsFragment_(), true);
                break;
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
    protected boolean getAvailableBackStack()
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

    public void showFragment(final Fragment fragment, final boolean addToBackstack)
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
        this.mDrawerLayout.closeDrawer(this.mMenuDrawerList);
    }

    /**
     * Remove all back stack to avoid missing flow on back pressed.
     */
    private void clearAllBackStack()
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

    private void initSearchView(final Menu menu)
    {
        final SearchManager searchManager = (SearchManager) this.getSystemService(Context.SEARCH_SERVICE);
        this.mSearchViewMenuItem = menu.findItem(R.id.action_search);
        if (this.mSearchViewMenuItem != null)
        {
            this.mSearchView = (SearchView) this.mSearchViewMenuItem.getActionView();
            this.mSearchView.setSearchableInfo(searchManager.getSearchableInfo(this.getComponentName()));
            this.mSearchView.setIconifiedByDefault(true);
            this.mSearchViewMenuItem.setOnActionExpandListener(new OnActionExpandListener()
            {

                @Override
                public boolean onMenuItemActionCollapse(final MenuItem item)
                {
                    MainActivity.this.getAvailableBackStack();
                    return true;
                }

                @Override
                public boolean onMenuItemActionExpand(final MenuItem item)
                {
                    return true;
                }

            });
        }
    }
}