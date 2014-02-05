package com.sage42.androidappaddicts.app.model;

import java.util.List;

import org.androidannotations.annotations.EService;

import android.app.IntentService;
import android.content.Intent;

import com.sage42.androidappaddicts.app.model.api.MyApiFactory;
import com.sage42.androidappaddicts.app.model.logging.Logger;
import com.sage42.androidappaddicts.lib.applist.data.App;

@EService
public class AppListLoaderService extends IntentService
{
    private static final String WORKER_THREAD_NAME = AppListLoaderService.class.getSimpleName();
    private static final String TAG                = AppListLoaderService.class.getSimpleName();

    /**
     * Default Constructor.
     */
    public AppListLoaderService()
    {
        super(WORKER_THREAD_NAME);
    }

    /*
     * (non-Javadoc)
     * @see android.app.IntentService#onHandleIntent(android.content.Intent)
     */
    @Override
    protected void onHandleIntent(final Intent intent)
    {
        // download and parse app list
        List<App> apps = MyApiFactory.getApiInstance().loadAppList();
        if ((apps == null) || (apps.size() == 0))
        {
            Logger.info(TAG, "Failed to load any apps"); //$NON-NLS-1$
            return;
        }

        // save list into db

    }

}
