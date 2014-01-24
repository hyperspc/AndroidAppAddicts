/**
 *  Copyright (C) 2013-2014 Sage 42 Apps Sdn Bhd
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.sage42.androidappaddicts.app.about;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsMenu;
import android.app.Fragment;
import com.sage42.androidappaddicts.R;
import com.sage42.androidappaddicts.app.util.IntentUtils;

/**
 * The "About" page for the app. With lots of clickable links to call, email,
 * etc.
 */
@OptionsMenu(R.menu.general)
@EFragment(resName = "about_fragment")
public class AboutFragment extends Fragment
{
    private static final String TAG = AboutFragment.class.getSimpleName();

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
    protected void onClickCall()
    {
        IntentUtils.doCall(this.getActivity(), this.getString(R.string.about_call_number));
    }

    /**
     * Click handler for the email button.
     */
    @Click(R.id.about_email)
    protected void onClickEmail()
    {
        IntentUtils.doEmail(this.getActivity(), this.getString(R.string.about_email_address));
    }

    /**
     * Click handler for the G+ button.
     */
    @Click(R.id.about_gplus)
    protected void onClickGPlus()
    {
        IntentUtils.doShowUri(this.getActivity(), this.getString(R.string.about_follow_us_url));
    }

    /**
     * Click handler for the participate button.
     */
    @Click(R.id.about_participate)
    protected void onClickParticipate()
    {
        IntentUtils.doShowUri(this.getActivity(), this.getString(R.string.about_participate_url));
    }

}
