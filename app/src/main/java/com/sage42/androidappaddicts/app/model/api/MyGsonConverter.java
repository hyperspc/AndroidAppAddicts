package com.sage42.androidappaddicts.app.model.api;

import retrofit.converter.GsonConverter;

import com.google.gson.Gson;

/**
 * Custom implementation to work around crazy gson classpath issues.
 */
public class MyGsonConverter extends GsonConverter
{
    /**
     * @param gson
     */
    public MyGsonConverter()
    {
        super(new Gson());
    }

}
