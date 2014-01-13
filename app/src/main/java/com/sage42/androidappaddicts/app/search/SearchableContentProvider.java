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
package com.sage42.androidappaddicts.app.search;

import org.androidannotations.annotations.EProvider;

import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

@EProvider
public class SearchableContentProvider extends ContentProvider
{

    private static final String mTableName     = "table";                                                                                                   //$NON-NLS-1$
    public static final String  AUTHORITY      = SearchableContentProvider.class.getCanonicalName();
    public static final Uri     CONTENT_URI    = Uri.parse("content://" + SearchableContentProvider.AUTHORITY + "/" + SearchableContentProvider.mTableName); //$NON-NLS-1$//$NON-NLS-2$

    // For matching different URI
    private static final int    SEARCH_TESTS   = 0;
    private static final int    GET_TEST       = 1;
    private static final int    SEARCH_SUGGEST = 2;

    private SearchDBHelper      dbHelper;

    public static UriMatcher    mUriMatcher;
    static
    {
        SearchableContentProvider.mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        SearchableContentProvider.mUriMatcher.addURI(SearchableContentProvider.AUTHORITY,
                        SearchableContentProvider.mTableName, SearchableContentProvider.SEARCH_TESTS);
        SearchableContentProvider.mUriMatcher.addURI(SearchableContentProvider.AUTHORITY,
                        SearchableContentProvider.mTableName + "/#", SearchableContentProvider.GET_TEST); //$NON-NLS-1$          
        SearchableContentProvider.mUriMatcher
                        .addURI(SearchableContentProvider.AUTHORITY,
                                        SearchableContentProvider.mTableName
                                                        + "/" + SearchManager.SUGGEST_URI_PATH_QUERY, SearchableContentProvider.SEARCH_SUGGEST); //$NON-NLS-1$
        SearchableContentProvider.mUriMatcher
                        .addURI(SearchableContentProvider.AUTHORITY,
                                        SearchableContentProvider.mTableName
                                                        + "/" + SearchManager.SUGGEST_URI_PATH_QUERY + "/*", SearchableContentProvider.SEARCH_SUGGEST); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    public boolean onCreate()
    {
        this.dbHelper = new SearchDBHelper(this.getContext());
        return this.dbHelper != null;
    }

    @Override
    public Cursor query(final Uri uri, final String[] projection, final String selection, final String[] selectionArgs,
                    final String sortOrder)
    {

        this.dbHelper.getReadableDatabase();
        return this.dbHelper.search("", selectionArgs[0]); //$NON-NLS-1$

    }

    //    /**
    //     * @param query
    //     * @return
    //     */
    //    private Cursor getSuggestions(final String query)
    //    {
    //        // query = query.toLowerCase();
    //        // String[] columns = new String[]
    //        // { BaseColumns._ID, DatabaseHelper.KEY_DATA,
    //        // SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID };
    //        // return this.dbHelper.getRecordMatches(query, columns);
    //        return null;
    //    }

    @Override
    public int delete(final Uri uri, final String selection, final String[] selectionArgs)
    {
        return 0;
    }

    // Required method (inherited from class ContentProvider)
    @Override
    public String getType(final Uri uri)
    {
        return null;

    }

    @Override
    public Uri insert(final Uri uri, final ContentValues values)
    {
        return null;
    }

    @Override
    public int update(final Uri uri, final ContentValues values, final String selection, final String[] selectionArgs)
    {
        return 0;
    }

}