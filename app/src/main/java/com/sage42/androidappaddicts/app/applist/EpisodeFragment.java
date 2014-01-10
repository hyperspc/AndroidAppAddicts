package com.sage42.androidappaddicts.app.applist;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import android.app.Fragment;

import com.sage42.androidappaddicts.R;

/**
 * Fragment to display the current events.
 */
@EFragment(R.layout.app_by_episode)
public class EpisodeFragment extends Fragment
{

    /**
     * Set page title and wire the data to the UI
     */
    @AfterViews
    void init()
    {
        this.getActivity().getActionBar().setTitle(R.string.fragment_episode_title);
    }

}
