package com.sage42.androidappaddicts.app.model.api;

import java.util.List;

import com.sage42.androidappaddicts.lib.applist.data.App;

/**
 * Interface that defines all access to the DB, SharedPreferences and Web endpoints.
 */
public interface MyApi
{
    /**
     * Load list of applications from the web.
     * 
     * @return list of applications
     */
    List<App> loadAppList();

}