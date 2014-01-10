package com.sage42.androidappaddicts.app.menu;

import android.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.sage42.androidappaddicts.R;
import com.sage42.androidappaddicts.app.applist.CategoryFragment_;
import com.sage42.androidappaddicts.app.applist.EpisodeFragment_;
import com.sage42.androidappaddicts.app.host.HostFragment_;
import com.sage42.androidappaddicts.app.suggestion.AppSuggestionFragment_;

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
            case MenuData.FRAGMENT_CATEGORY:
                this.mCallback.showFragment(new EpisodeFragment_(), R.string.fragment_episode_title, false);
                break;

            case MenuData.FRAGMENT_EPISODE:
                this.mCallback.showFragment(new CategoryFragment_(), R.string.fragment_category_title, false);
                break;

            case MenuData.FRAGMENT_APP_SUGGESTION:
                this.mCallback.showFragment(new AppSuggestionFragment_(), R.string.fragment_suggest_title, false);
                break;

            case MenuData.FRAGMENT_HOST:
                this.mCallback.showFragment(new HostFragment_(), R.string.fragment_host_title, false);
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
         * @param titleResId
         * @param addToBackstack
         */
        void showFragment(final Fragment fragment, final int titleResId, final boolean addToBackstack);
    }
}
