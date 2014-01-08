package com.sage42.androidappaddicts.app.host;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import android.app.Fragment;
import android.widget.GridView;
import android.widget.Toast;

import com.sage42.androidappaddicts.R;

/**
 * Host fragment base.
 */
@EFragment(R.layout.host_fragment)
public class HostFragment extends Fragment
{

    @ViewById(R.id.host_grid)
    protected GridView mGridView;

    /**
     * Set page title and wire the data to the UI
     */
    @AfterViews
    void init()
    {
        this.getActivity().getActionBar().setTitle(R.string.fragment_host_title);
    }

    @ItemClick(R.id.host_grid)
    void OpenGooglePage()
    {
        Toast.makeText(this.getActivity(), "not yet implement", Toast.LENGTH_LONG).show(); //$NON-NLS-1$
    }
}
