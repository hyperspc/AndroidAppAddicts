/**
 * Copyright (C) 2013-2014 Sage 42 Apps Sdn Bhd Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 */
package com.sage42.androidappaddicts.app.about;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import android.app.Fragment;
import android.content.pm.PackageManager.NameNotFoundException;
import android.widget.TextView;

import com.sage42.androidappaddicts.R;
import com.sage42.androidappaddicts.app.util.IntentUtils;

/**
 * The "About" page for the app. With lots of clickable links to call, email, etc.
 */
@OptionsMenu(R.menu.general)
@EFragment(resName = "about_fragment")
public class AboutFragment extends Fragment
{
    @ViewById(R.id.about_version)
    protected TextView mVersion;

    /**
     * Add data into the display.
     */
    @AfterViews
    void init()
    {
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
     * Set the screen title.
     */
    @Override
    public void onStart()
    {
        super.onStart();

        this.getActivity().getActionBar().setTitle(R.string.about_about_title);
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
    @Click(R.id.about_gplus)
    void onClickFacebook()
    {
        IntentUtils.doShowFacebook(this.getActivity(), this.getString(R.string.about_participate_address),
                        "http://" + this.getString(R.string.about_participate_address)); //$NON-NLS-1$
    }

}