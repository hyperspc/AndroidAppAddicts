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
package com.sage42.androidappaddicts.app.test;

import android.app.Activity;
import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.jayway.android.robotium.solo.Solo;

public abstract class ARobotiumBase<ActivityUnderTest extends Activity> extends
                ActivityInstrumentationTestCase2<ActivityUnderTest>
{
    public static final int UI_WAIT_DELAY = 200;

    private Solo            mSolo;

    public ARobotiumBase(final Class<ActivityUnderTest> activityClass)
    {
        super(activityClass);
    }

    @Override
    public void setUp() throws Exception
    {
        // start up the activity
        final Activity activity = this.getActivity();
        this.mSolo = new Solo(this.getInstrumentation(), activity);
        super.setUp();

        // make sure the activity loaded
        assertTrue(this.getSolo().waitForActivity(activity.getClass().getSimpleName()));
    }

    @Override
    public void tearDown() throws Exception
    {
        super.tearDown();

        // close any dialogs
        this.mSolo.goBack();

        // close any activities
        this.mSolo.finishOpenedActivities();
    }

    /**
     * Click on a view with supplied resourceId.
     * 
     * @param resId
     */
    protected void clickViewByResId(final int resId)
    {
        final Solo solo = this.mSolo;
        solo.clickOnView(solo.getCurrentActivity().findViewById(resId));
    }

    /**
     * Enter text into the specified EditText component
     * 
     * @return
     */
    public void enterText(final int resId, final String text)
    {
        this.mSolo.enterText((EditText) this.getActivity().findViewById(resId), text);
    }

    /**
     * Returns an instance of Robotium (aka solo).
     * 
     * @return
     */
    public Solo getSolo()
    {
        return this.mSolo;
    }

    /**
     * Convenience method that returns the context for the test.
     * 
     * @return
     */
    public Context getContext()
    {
        return this.getInstrumentation().getTargetContext();
    }

}
