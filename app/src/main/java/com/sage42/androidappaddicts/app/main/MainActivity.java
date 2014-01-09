package com.sage42.androidappaddicts.app.main;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.OptionsMenu;
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
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.sage42.androidappaddicts.R;
import com.sage42.androidappaddicts.app.about.*;
import com.sage42.androidappaddicts.app.applist.*;
import com.sage42.androidappaddicts.app.search.*;
import com.sage42.androidappaddicts.app.settings.*;

import com.sage42.androidappaddicts.app.menu.MenuDrawClickListener;
import com.sage42.androidappaddicts.app.menu.MenuDrawClickListener.IMenuDrawCallbacks;
import com.sage42.androidappaddicts.app.menu.MenuListAdapter;

import com.sage42.androidappaddicts.app.suggestion.AppSuggestionFragment;
import com.sage42.androidappaddicts.app.util.IntentUtils;

/**
 * Copyright (C) 2013- Sage 42 App Sdn Bhd Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 */
@EActivity(R.layout.main_activity)
@OptionsMenu(R.menu.main)
public class MainActivity extends Activity implements IMenuDrawCallbacks
{

    @ViewById(R.id.main_drawer_layout)
    protected DrawerLayout        mDrawerLayout;

    @ViewById(R.id.main_menu_layout)
    protected ListView            mMenuList;

    @InstanceState
    protected boolean             mIsSuggestion = false;

    private ActionBarDrawerToggle mDrawerToggle;

    private SearchView            mSearchView;
    private MenuItem              mSearchViewMenuItem;

    @InstanceState
    protected boolean             mNotFirstRun;

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
                // MainActivity.this.getActionBar().setTitle(MainActivity.this.mTitle);
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

        // show default content (events)
        if (this.mNotFirstRun == false)
        {
            this.showFragment(new EpisodeFragment_(), R.string.fragment_episode_title, false);
            this.mNotFirstRun = true;
        }

        this.getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu)
    {
        // final MenuInflater inflater = new
        // MenuInflater(this.getActionBar().getThemedContext());
        // inflater.inflate(R.menu.main_menu, menu);
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
            case R.id.action_search:
                this.showFragment(new SearchResultFragment_(), R.string.fragment_search_title, true);
                break;
            case R.id.action_about:
                this.showFragment(new AboutFragment_(), R.string.fragment_episode_title, true);
                break;
            case R.id.action_share:
                IntentUtils.doShare(this, this.getResources().getString(R.string.app_name)
                                + this.getResources().getString(R.string.app_market_address));
                break;
            case R.id.action_settings:
                this.showFragment(new SettingsFragment_(), R.string.fragment_episode_title, true);
                break;
            default:
                break;
        }

        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

    /*
     * (non-Javadoc)
     * @see com.actionbarsherlock.app.SherlockFragmentActivity#onPrepareOptionsMenu (android.view.Menu)
     */
    @Override
    public boolean onPrepareOptionsMenu(final Menu menu)
    {

        if (this.mIsSuggestion)
        {
            menu.findItem(R.id.action_submit_suggestion).setVisible(true);
            menu.findItem(R.id.action_search).setVisible(false);
            menu.findItem(R.id.action_about).setVisible(false);
            menu.findItem(R.id.action_share).setVisible(false);
            menu.findItem(R.id.action_settings).setVisible(false);
            return super.onPrepareOptionsMenu(menu);
        }
        // If the nav drawer is open, hide action items related to the content
        // view
        final boolean drawerOpen = this.mDrawerLayout.isDrawerOpen(this.mMenuList);
        menu.findItem(R.id.action_submit_suggestion).setVisible(false);
        menu.findItem(R.id.action_search).setVisible(!drawerOpen);
        menu.findItem(R.id.action_about).setVisible(!drawerOpen);
        menu.findItem(R.id.action_share).setVisible(!drawerOpen);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
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

    @Override
    public void showFragment(final Fragment fragment, final int titleResId, final boolean addToBackstack)
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

        this.mIsSuggestion = fragment instanceof AppSuggestionFragment;
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

    private void initSearchView(final Menu menu)
    {
        final Context context = this;
        final SearchManager searchManager = (SearchManager) this.getSystemService(Context.SEARCH_SERVICE);
        this.mSearchViewMenuItem = menu.findItem(R.id.action_search);
        this.mSearchView = (SearchView) this.mSearchViewMenuItem.getActionView();
        this.mSearchView.setSearchableInfo(searchManager.getSearchableInfo(this.getComponentName()));
        this.mSearchView.setIconifiedByDefault(true);
        this.mSearchViewMenuItem.setOnActionExpandListener(new OnActionExpandListener()
        {

            @Override
            public boolean onMenuItemActionCollapse(final MenuItem item)
            {
                Toast.makeText(context, "CLOSING", Toast.LENGTH_LONG).show(); //$NON-NLS-1$
                MainActivity.this.getAvailableBackStack();
                return true;
            }

            @Override
            public boolean onMenuItemActionExpand(final MenuItem item)
            {
                //  Toast.makeText(context, "SEARCHVIEW START", Toast.LENGTH_LONG).show(); //$NON-NLS-1$
                return true;
            }

        });
        // this.mSearchView.setOnSuggestionListener(new OnSuggestionListener()
        // {
        //
        // @Override
        // public boolean onSuggestionSelect(int position)
        // {
        // return false;
        // }
        //
        // /*
        // * (non-Javadoc)
        // * @see
        // * com.actionbarsherlock.widget.SearchView.OnSuggestionListener#
        // * onSuggestionClick(int)
        // */
        // @SuppressWarnings("resource")
        // @Override
        // public boolean onSuggestionClick(int position)
        // {
        // final CursorAdapter c = searchView.getSuggestionsAdapter();
        // final Cursor cur = c.getCursor();
        // cur.moveToPosition(position);
        // return false;
        // }
        // });
    }
}
