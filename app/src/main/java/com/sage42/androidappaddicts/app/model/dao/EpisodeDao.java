package com.sage42.androidappaddicts.app.model.dao;

import org.apache.commons.lang3.StringUtils;

import se.emilsjolander.sprinkles.CursorList;
import se.emilsjolander.sprinkles.ManyQuery;
import se.emilsjolander.sprinkles.Query;

import android.app.LoaderManager;
import com.sage42.androidappaddicts.app.model.data.Episode;

public class EpisodeDao
{
    private EpisodeDao()
    {
        // enforcing singleton
        super();
    }

    @SuppressWarnings("unchecked")
    public static void retrieveData(final LoaderManager loaderManager, final String whereCondition,
                    final Object[] whereArgs, final String order, final CursorListAdapter adapter)
    {
        final ManyQuery.ResultHandler<Episode> onLoad = new ManyQuery.ResultHandler<Episode>()
        {
            @Override
            public boolean handleResult(final CursorList<Episode> result)
            {
                adapter.swapNotes(result);
                return true;
            }
        };
        final StringBuilder string = new StringBuilder("select * From episode"); //$NON-NLS-1$
        if (StringUtils.isNotEmpty(whereCondition))
        {
            string.append(" where ").append(whereCondition).append(" = ?"); //$NON-NLS-1$//$NON-NLS-2$
        }
        if (StringUtils.isNotEmpty(order))
        {
            string.append(" order by ").append(order); //$NON-NLS-1$
        }
        Query.many(Episode.class, string.toString(), whereArgs).getAsync(loaderManager, onLoad, Episode.class);

    }

    public static Object retrieveSingleData(final String whereCondition, final Object[] whereArgs)
    {

        final StringBuilder string = new StringBuilder("select * From episode"); //$NON-NLS-1$
        if (StringUtils.isNotEmpty(whereCondition))
        {
            string.append(" where ").append(whereCondition).append(" = ?"); //$NON-NLS-1$//$NON-NLS-2$
        }
        return Query.one(Episode.class, string.toString(), whereArgs).get();

    }
}
