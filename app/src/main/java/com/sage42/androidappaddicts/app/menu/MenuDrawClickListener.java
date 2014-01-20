/**
 * Copyright (C) 2013-2014 Sage 42 Apps Sdn Bhd Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 */
package com.sage42.androidappaddicts.app.menu;

import android.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.sage42.androidappaddicts.app.applist.ByCategoryFragment_;
import com.sage42.androidappaddicts.app.hosts.HostsFragment_;
import com.sage42.androidappaddicts.app.main.HomeFragment_;
import com.sage42.androidappaddicts.app.suggestion.SuggestionFragment_;

/**
 * Response to menu list click events.
 */
public class MenuDrawClickListener implements OnItemClickListener
{
    private final IMenuDrawCallbacks mCallback;

    /**
     * Default constructor.
     * 
     * @param callback
     */
    public MenuDrawClickListener(final IMenuDrawCallbacks callback)
    {
        super();
        this.mCallback = callback;
    }

    /**
     * Process side menu items.
     */
    @Override
    public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long viewId)
    {
        // switch the fragment content to match the selected menu item
        switch (position)
        {
            case MenuData.FRAGMENT_SHOW:
                this.mCallback.showFragment(new HomeFragment_(), false);
                break;

            case MenuData.FRAGMENT_CATEGORY:
                this.mCallback.showFragment(new ByCategoryFragment_(), false);
                break;

            case MenuData.FRAGMENT_APP_SUGGESTION:
                this.mCallback.showFragment(new SuggestionFragment_(), false);
                break;

            case MenuData.FRAGMENT_HOSTS:
                this.mCallback.showFragment(new HostsFragment_(), false);
                break;

            default:
                // do nothing
                break;
        }

    }

    /**
     * Interface to allow callbacks from this listener to it parent.
     */
    public interface IMenuDrawCallbacks
    {
        /**
         * Change main content view to new fragment.
         * 
         * @param fragment
         * @param addToBackstack
         */
        void showFragment(final Fragment fragment, final boolean addToBackstack);
    }
}
