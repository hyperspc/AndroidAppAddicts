package com.sage42.androidappaddicts.app.applist;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import com.sage42.androidappaddicts.R;

import android.app.Fragment;

/**
 * Fragment to display the current events.
 */
@EFragment(R.layout.category_fragment)
public class CategoryFragment extends Fragment 
{

    /**
     * Set page title and wire the data to the UI
     */
    @AfterViews
    void init()
    {

    }

}
