package com.sage42.androidappaddicts.lib.applist.data;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

/**
 * Data object needed to parse the AppList JSON.
 */
public class AppList
{
    @SerializedName("entry")
    private Entry[] mEntries;

    /**
     * @return the entries
     */
    public Entry[] getEntries()
    {
        return this.mEntries;
    }

    /**
     * @param entries the entries to set
     */
    public void setEntries(Entry[] entries)
    {
        this.mEntries = entries;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("nls")
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("AppList [mEntries=");
        builder.append(Arrays.toString(this.mEntries));
        builder.append("]");
        return builder.toString();
    }

}
