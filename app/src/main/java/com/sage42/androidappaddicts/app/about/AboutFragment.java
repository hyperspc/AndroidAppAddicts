package com.sage42.androidappaddicts.app.about;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import android.app.Fragment;
import android.content.pm.PackageManager.NameNotFoundException;
import android.widget.TextView;

import com.sage42.androidappaddicts.R;
import com.sage42.androidappaddicts.app.util.IntentUtils;

/**
 * The "About" page for the app. With lots of clickable links to call, email,
 * etc.
 */
@EFragment(resName = "about_fragment")
public class AboutFragment extends Fragment
{
    private static final String TAG = AboutFragment.class.getSimpleName();

    @ViewById(R.id.about_version)
    protected TextView          mVersion;

    /**
     * Set the page title and add version into the display.
     */
    @AfterViews
    void init()
    {
        // add page title
        this.getActivity().getActionBar().setTitle(R.string.about_title);

        try
        {
            // pull version name from manifest and add to display
            this.mVersion.setText(this.getActivity().getPackageManager()
                            .getPackageInfo(this.getActivity().getPackageName(), 0).versionName);
        }
        catch (final NameNotFoundException e)
        {
            // this should not happen

        }
    }

    /**
     * Click handler for the call button.
     */
    @Click(R.id.about_hotline)
    void onClickCall()
    {
        IntentUtils.doCall(this.getActivity(), this.getString(R.string.about_call_number));
    }

    /**
     * Click handler for the email button.
     */
    @Click(R.id.about_email)
    void onClickEmail()
    {
        IntentUtils.doEmail(this.getActivity(), this.getString(R.string.about_email_address));
    }

    /**
     * Click handler for the website button.
     */
    @Click(R.id.about_web)
    void onClickWeb()
    {
        IntentUtils.doShowUri(this.getActivity(), "http://" + this.getString(R.string.about_follow_us_address)); //$NON-NLS-1$
    }

    /**
     * Click handler for the facebook button.
     */
    @Click(R.id.about_facebook)
    void onClickFacebook()
    {
        // TODO:change to google+
        IntentUtils.doShowFacebook(this.getActivity(), this.getString(R.string.about_participate_address),
                        "http://" + this.getString(R.string.about_participate_address)); //$NON-NLS-1$
    }

}