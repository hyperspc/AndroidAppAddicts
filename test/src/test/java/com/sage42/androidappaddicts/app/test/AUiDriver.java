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

/**
 * This class should contain any code that is common between tests.
 * Code that is able to interact with the UI (read and write). 
 */
public abstract class AUiDriver<ActivityUnderTest extends Activity> extends ARobotiumBase<ActivityUnderTest>
{
    // amount of time we sometimes need to wait for transitions, screen animations and the like.
    public static final int DEFAULT_WAIT_TIME = 300;

    public AUiDriver(final Class<ActivityUnderTest> activityClass)
    {
        super(activityClass);

        // NOTE: this code can used to customize the intent that is used to start the test activity
        //        final Intent intent = new Intent();
        //        intent.putExtra("extraName", "extraValue"); //$NON-NLS-1$ //$NON-NLS-2$
        //        this.setActivityIntent(intent);
    }

    @Override
    public void setUp() throws Exception
    {
        // Add code here that needs to run before the test activity is started

        super.setUp();
    }

    @Override
    public void tearDown() throws Exception
    {
        super.tearDown();

        // clean up after the tests
    }

}
