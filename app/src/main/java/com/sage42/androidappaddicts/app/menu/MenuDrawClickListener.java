package com.sage42.androidappaddicts.app.menu;

import android.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.sage42.androidappaddicts.R;
import com.sage42.androidappaddicts.app.Fragment1_;
import com.sage42.androidappaddicts.app.Fragment2_;
import com.sage42.androidappaddicts.app.Fragment3_;
import com.sage42.androidappaddicts.app.Fragment4_;

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
            case MenuData.MENU_FRAGMENT1:
                this.mCallback.showFragment(new Fragment1_(), R.string.fragment1, false);
                break;

            case MenuData.MENU_FRAGMENT2:
                this.mCallback.showFragment(new Fragment2_(), R.string.fragment2, false);
                break;

            case MenuData.MENU_FRAGMENT3:
                this.mCallback.showFragment(new Fragment3_(), R.string.fragment3, false);
                break;

            case MenuData.MENU_FRAGMENT4:
                this.mCallback.showFragment(new Fragment4_(), R.string.fragment4, false);
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
