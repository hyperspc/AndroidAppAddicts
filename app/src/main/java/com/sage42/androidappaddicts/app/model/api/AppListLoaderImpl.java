package com.sage42.androidappaddicts.app.model.api;

import java.util.List;

import retrofit.RestAdapter;

import com.sage42.androidappaddicts.app.model.data.App;
import com.sage42.androidappaddicts.app.model.data.RawAppList;
import com.sage42.androidappaddicts.app.model.logging.Logger;

public class AppListLoaderImpl
{
    private static final String  TAG      = AppListLoaderImpl.class.getSimpleName();

    private static String        BASE_URL = "https://spreadsheets.google.com/feeds/cells/0AlOCAOm6LNzndDEtdDJPZFFJdFdDdmNCLUphNTZZcUE"; //$NON-NLS-1$

    private final AppListService mService;

    /**
     * Default Constructor.
     */
    public AppListLoaderImpl()
    {
        super();

        // define and build a rest service
        final RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(BASE_URL)
                        .setConverter(new MyGsonConverter()).setErrorHandler(new MyErrorHandler()).build();
        this.mService = restAdapter.create(AppListService.class);
    }

    public void loadAppList()
    {
        final RawAppList rawAppList = this.mService.loadAppList();

        final List<App> apps = new JsonConverter().convert(rawAppList);
        if ((apps == null) || (apps.size() == 0))
        {
            Logger.info(TAG, "Failed to load app list"); //$NON-NLS-1$
            return;
        }

        for (final App app : apps)
        {
            Logger.debug(TAG, app.toString());
        }
    }
}
