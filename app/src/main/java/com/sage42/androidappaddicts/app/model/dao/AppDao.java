package com.sage42.androidappaddicts.app.model.dao;

import org.apache.commons.lang3.StringUtils;

import se.emilsjolander.sprinkles.CursorList;
import se.emilsjolander.sprinkles.ManyQuery;
import se.emilsjolander.sprinkles.Query;

import android.app.LoaderManager;
import com.sage42.androidappaddicts.app.model.data.App;

public class AppDao
{
    private AppDao()
    {
        // enforcing singleton
        super();
    }

    @SuppressWarnings("unchecked")
    public static void retrieveData(final LoaderManager loaderManager, final String whereCondition,
                    final Object[] whereArgs, final CursorListAdapter adapter)
    {
        final ManyQuery.ResultHandler<App> onLoad = new ManyQuery.ResultHandler<App>()
        {
            @Override
            public boolean handleResult(final CursorList<App> result)
            {
                adapter.swapNotes(result);
                return true;
            }
        };
        final StringBuilder string = new StringBuilder("select * From app"); //$NON-NLS-1$
        if (StringUtils.isNotEmpty(whereCondition))
        {
            string.append(" where ").append(whereCondition).append(" = ?"); //$NON-NLS-1$//$NON-NLS-2$
        }
        Query.many(App.class, string.toString(), whereArgs).getAsync(loaderManager, onLoad, App.class);

    }

    @SuppressWarnings("unchecked")
    public static void retrieveDataCustomRawQuery(final LoaderManager loaderManager, final String sqlQuery,
                    final Object[] whereArgs, final ManyQuery.ResultHandler<App> onAppLoaded,
                    final CursorListAdapter adapter)
    {

        Query.many(App.class, sqlQuery, whereArgs).getAsync(loaderManager, onAppLoaded, App.class);

    }

    public static Object retrieveSingleData(final String whereCondition, final Object[] whereArgs)
    {

        final StringBuilder string = new StringBuilder("select * From app"); //$NON-NLS-1$
        if (StringUtils.isNotEmpty(whereCondition))
        {
            string.append(" where ").append(whereCondition).append(" = ?"); //$NON-NLS-1$//$NON-NLS-2$
        }
        return Query.one(App.class, string.toString(), whereArgs).get();

    }
}
