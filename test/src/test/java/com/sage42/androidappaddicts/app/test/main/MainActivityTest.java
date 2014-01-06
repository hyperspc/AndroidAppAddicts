package com.sage42.androidappaddicts.app.test.main;

import com.jayway.android.robotium.solo.Solo;
import com.sage42.androidappaddicts.R;
import com.sage42.androidappaddicts.app.main.MainActivity_;
import com.sage42.androidappaddicts.app.test.AUiDriver;

/**
 * Copyright (C) 2013- Sage 42 App Sdn Bhd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
public class MainActivityTest extends AUiDriver<MainActivity_>
{
    public MainActivityTest()
    {
        super(MainActivity_.class);
    }

    /**
     * Simple sanity test to check that content is displayed
     */
    public void testSanity()
    {
        final Solo solo = this.getSolo();

        // check for "Hello world"
        assertTrue(solo.searchText(this.getContext().getString(R.string.main_hello_world), true));
    }

    /**
     * Verify that clicking the button shows a toast with "Ouch"
     */
    public void testOnClickMe()
    {
        final Solo solo = this.getSolo();

        // click the button
        solo.clickOnButton(this.getContext().getString(R.string.main_click_me));

        // verify the toast shows
        solo.searchText(this.getContext().getString(R.string.main_ouch), true);
    }

}