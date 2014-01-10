package com.sage42.androidappaddicts.app.settings;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import android.app.Fragment;
import android.widget.ListView;

import com.sage42.androidappaddicts.R;

/**
 * The "About" page for the app. With lots of clickable links to call, email,
 * etc.
 */
@EFragment(resName = "settings_fragment")
public class SettingsFragment extends Fragment
{
    private static final String TAG = SettingsFragment.class.getSimpleName();

    @ViewById(R.id.settings_list)
    protected ListView          mList;

    /**
     * Set the page title and add version into the display.
     */
    @AfterViews
    void init()
    {
        // add page title
        this.getActivity().getActionBar().setTitle(R.string.settings_title);

        this.mList.setAdapter(new SettingsMenuListAdapter(this.getActivity()));
        this.mList.setOnItemClickListener(new SettingsMenuDrawClickListener());

    }

}