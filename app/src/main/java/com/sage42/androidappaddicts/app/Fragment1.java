package com.sage42.androidappaddicts.app;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import com.sage42.androidappaddicts.R;

import android.app.Fragment;

/**
 * Fragment to display the current events.
 */
@EFragment(R.layout.fragment1)
public class Fragment1 extends Fragment 
{

    /**
     * Set page title and wire the data to the UI
     */
    @AfterViews
    void init()
    {

    }

}
