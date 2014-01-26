package com.sage42.androidappaddicts.lib.applist.data;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

/**
 * Feed record in the AppList json.
 */
public class Feed
{
    @SerializedName("gs$rowCount")
    private RowCountData mRowCount;

    @SerializedName("entry")
    private Entry[]      mEntries;

    /**
     * @return the entries
     */
    public Entry[] getEntries()
    {
        return this.mEntries;
    }

    /**
     * @param entries
     *            the entries to set
     */
    public void setEntries(Entry[] entries)
    {
        this.mEntries = entries;
    }

    /**
     * @return the rowCount
     */
    public RowCountData getRowCount()
    {
        return this.mRowCount;
    }

    /**
     * @param rowCount
     *            the rowCount to set
     */
    public void setRowCount(RowCountData rowCount)
    {
        this.mRowCount = rowCount;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("nls")
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Feed [mRowCount=");
        builder.append(this.mRowCount);
        builder.append(", mEntries=");
        builder.append(Arrays.toString(this.mEntries));
        builder.append("]");
        return builder.toString();
    }
}
