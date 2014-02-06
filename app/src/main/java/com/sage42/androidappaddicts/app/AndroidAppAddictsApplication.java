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

package com.sage42.androidappaddicts.app;

import java.util.Date;

import org.androidannotations.annotations.EApplication;

import com.sage42.androidappaddicts.app.model.App;
import com.sage42.androidappaddicts.app.model.Host;
import com.sage42.androidappaddicts.app.model.Show;

import se.emilsjolander.sprinkles.Migration;
import se.emilsjolander.sprinkles.Sprinkles;
import android.app.Application;

@EApplication
public class AndroidAppAddictsApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        final Sprinkles sprinkles = Sprinkles.init(this.getApplicationContext());

        final Migration initialMigration = new Migration();
        initialMigration.createTable(Host.class);
        initialMigration.createTable(Show.class);
        initialMigration.createTable(App.class);
        sprinkles.addMigration(initialMigration);

        this.addData();
    }

    public void addData()
    {
        final App a1 = new App();
        final Date date = new Date();
        a1.name = date.toString();
        a1.id = 222;
        a1.save();
    }
}
