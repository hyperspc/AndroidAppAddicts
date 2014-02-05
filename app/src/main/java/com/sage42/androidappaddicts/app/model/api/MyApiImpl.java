package com.sage42.androidappaddicts.app.model.api;

import java.util.List;

import org.androidannotations.annotations.EBean;

import com.sage42.androidappaddicts.app.model.http.AAAHttpClient;
import com.sage42.androidappaddicts.lib.applist.JsonConverter;
import com.sage42.androidappaddicts.lib.applist.data.App;

/**
 * Actual implementation of the API.
 */
@EBean
public class MyApiImpl implements MyApi
{
    private static String APPLIST_URL = "https://spreadsheets.google.com/feeds/cells/0AlOCAOm6LNzndDEtdDJPZFFJdFdDdmNCLUphNTZZcUE/od6/public/values?alt=json"; //$NON-NLS-1$

    /*
     * (non-Javadoc)
     * @see com.sage42.androidappaddicts.app.model.api.MyApi#loadAppList()
     */
    @Override
    public List<App> loadAppList()
    {
        // load data from web
        final String inputJson = AAAHttpClient.doGet(APPLIST_URL);
        if (inputJson == null)
        {
            return null;
        }

        // parse and return
        final JsonConverter converter = new JsonConverter();
        return converter.convert(inputJson);
    }

}
