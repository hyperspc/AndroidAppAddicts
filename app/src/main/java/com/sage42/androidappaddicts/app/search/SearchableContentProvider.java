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

    private static final String mTableName     = "table";                                                                         //$NON-NLS-1$
    public static final String  AUTHORITY      = SearchableContentProvider.class.getCanonicalName();
    public static final Uri     CONTENT_URI    = Uri.parse("content://" + SearchableContentProvider.AUTHORITY + "/" + mTableName); //$NON-NLS-1$//$NON-NLS-2$

    // For matching different URI
    private static final int    SEARCH_TESTS   = 0;
    private static final int    GET_TEST       = 1;
    private static final int    SEARCH_SUGGEST = 2;

    private SearchDBHelper      dbHelper;

    public static UriMatcher    mUriMatcher;
    static
    {
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        mUriMatcher.addURI(SearchableContentProvider.AUTHORITY, mTableName, SEARCH_TESTS);
        mUriMatcher.addURI(SearchableContentProvider.AUTHORITY, mTableName + "/#", GET_TEST); //$NON-NLS-1$          
        mUriMatcher.addURI(SearchableContentProvider.AUTHORITY,
                        mTableName + "/" + SearchManager.SUGGEST_URI_PATH_QUERY, SEARCH_SUGGEST); //$NON-NLS-1$
        mUriMatcher.addURI(SearchableContentProvider.AUTHORITY, mTableName
                        + "/" + SearchManager.SUGGEST_URI_PATH_QUERY + "/*", SEARCH_SUGGEST); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    public boolean onCreate()
    {
        this.dbHelper = new SearchDBHelper(getContext());
        return this.dbHelper != null;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
    {

        this.dbHelper.getReadableDatabase();
        return this.dbHelper.search("", selectionArgs[0]); //$NON-NLS-1$

    }

    private Cursor getSuggestions(String query)
    {
        // query = query.toLowerCase();
        // String[] columns = new String[]
        // { BaseColumns._ID, DatabaseHelper.KEY_DATA,
        // SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID };
        // return this.dbHelper.getRecordMatches(query, columns);
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    // Required method (inherited from class ContentProvider)
    @Override
    public String getType(Uri uri)
    {
        return null;

    }

    @Override
    public Uri insert(Uri uri, ContentValues values)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs)
    {
        // TODO Auto-generated method stub
        return 0;
    }

}