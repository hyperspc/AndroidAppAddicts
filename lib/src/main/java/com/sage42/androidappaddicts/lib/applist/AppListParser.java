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
package com.sage42.androidappaddicts.lib.applist;

import com.sage42.androidappaddicts.lib.applist.data.AppList;

public class AppListParser
{
    private static final String URL = "https://spreadsheets.google.com/feeds/cells/0AlOCAOm6LNzndDEtdDJPZFFJdFdDdmNCLUphNTZZcUE/od6/public/values?alt=json"; //$NON-NLS-1$

    /**
     * @return
     */
    public AppList getApplications()
    {
        // TODO: add check for last updated
        // TODO: add ability to pull only the update

        // pull the data from the web.

        // parse it (gson).

        // second pass over the data to put into the format we want.

        return null;
    }
}
