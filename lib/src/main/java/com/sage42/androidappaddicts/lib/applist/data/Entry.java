package com.sage42.androidappaddicts.lib.applist.data;

import com.google.gson.annotations.SerializedName;

/**
 * An Entry in the AppList json.
 */
public class Entry
{
    @SerializedName("gs$cell")
    private Cell mCell;

    /**
     * @return the cell
     */
    public Cell getCell()
    {
        return this.mCell;
    }

    /**
     * @param cell the cell to set
     */
    public void setCell(final Cell cell)
    {
        this.mCell = cell;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("nls")
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Entry [mCell=");
        builder.append(this.mCell);
        builder.append("]");
        return builder.toString();
    }

}
