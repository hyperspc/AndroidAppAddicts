package com.sage42.androidappaddicts.app.main;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;

import android.app.Activity;
import android.widget.Toast;

import com.sage42.androidappaddicts.R;

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
@EActivity(R.layout.main_activity)
@OptionsMenu(R.menu.main)
public class MainActivity extends Activity
{
    /**
     * Click event of the "Click me" button
     */
    @Click(R.id.main_click_me)
    protected void onClickClickMe()
    {
        Toast.makeText(this, R.string.main_ouch, Toast.LENGTH_LONG).show();
    }
}
