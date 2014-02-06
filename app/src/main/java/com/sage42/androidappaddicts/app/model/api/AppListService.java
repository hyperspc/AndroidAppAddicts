package com.sage42.androidappaddicts.app.model.api;

import retrofit.http.GET;

import com.sage42.androidappaddicts.app.model.data.RawAppList;

public interface AppListService
{
    @GET("/od6/public/values?alt=json")
    RawAppList loadAppList();
}
