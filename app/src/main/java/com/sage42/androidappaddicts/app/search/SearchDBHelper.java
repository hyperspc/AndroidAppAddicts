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

import java.util.HashMap;

import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;

public class SearchDBHelper extends SQLiteOpenHelper
{

    private static final String COLUMN_TITLE     = "";
    private static final String COLUMN_TYPE      = "";
    private static final String COLUMN_KEYWORD   = "";

    private static final String mTableName       = "";

    private static final String DATABASE_NAME    = "map72.db";                     //$NON-NLS-1$
    private static final int    DATABASE_VERSION = 1;
    public String[]             columns          = new String[]
                                                 { SearchManager.SUGGEST_COLUMN_TEXT_1,
                                                 // SearchManager.SUGGEST_COLUMN_TEXT_2,LocationTable.COLUMN_RESOURCE_URI,
                                                 // SearchManager.SUGGEST_COLUMN_ICON_1,
                    BaseColumns._ID, SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID };

    public SearchDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final HashMap<String, String> SEARCH_SUGGEST_PROJECTION_MAP;
    static
    {
        SEARCH_SUGGEST_PROJECTION_MAP = new HashMap<String, String>();
        SEARCH_SUGGEST_PROJECTION_MAP.put(BaseColumns._ID, BaseColumns._ID);
        SEARCH_SUGGEST_PROJECTION_MAP.put(SearchManager.SUGGEST_COLUMN_TEXT_1, COLUMN_TITLE
                        + " AS " + SearchManager.SUGGEST_COLUMN_TEXT_1); //$NON-NLS-1$
        SEARCH_SUGGEST_PROJECTION_MAP.put(SearchManager.SUGGEST_COLUMN_TEXT_2, COLUMN_TYPE
                        + " AS " + SearchManager.SUGGEST_COLUMN_TEXT_2); //$NON-NLS-1$
        SEARCH_SUGGEST_PROJECTION_MAP.put(SearchManager.SUGGEST_COLUMN_ICON_1, COLUMN_KEYWORD
                        + " AS " + SearchManager.SUGGEST_COLUMN_TEXT_2); //$NON-NLS-1$
        SEARCH_SUGGEST_PROJECTION_MAP.put(SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID, BaseColumns._ID
                        + " AS " + SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID); //$NON-NLS-1$
    }

    /**  
     * 
     */
    public Cursor search(String timestamp, String keyWord)
    {

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(mTableName);
        final String selection1 = "" + " like ? "; //$NON-NLS-1$ //$NON-NLS-2$
        final String[] selectionArgs1 = new String[]
        { timestamp, "%" + keyWord + "%" }; //$NON-NLS-1$ //$NON-NLS-2$ 
        queryBuilder.setProjectionMap(SEARCH_SUGGEST_PROJECTION_MAP);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = queryBuilder.query(db, this.columns, selection1, selectionArgs1, null, null, null);

        return cursor;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //
    }
}