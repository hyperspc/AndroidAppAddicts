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
