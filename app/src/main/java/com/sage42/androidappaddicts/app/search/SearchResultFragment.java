package com.sage42.androidappaddicts.app.search;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import android.app.Fragment;

import com.sage42.androidappaddicts.R;

/**
 * Fragment to display the current events.
 */
@EFragment(R.layout.search_result_fragment)
public class SearchResultFragment extends Fragment
{

    /**
     * Set page title and wire the data to the UI
     */
    @AfterViews
    void init()
    {

    }

}