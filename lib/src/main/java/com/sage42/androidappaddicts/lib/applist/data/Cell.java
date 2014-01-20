package com.sage42.androidappaddicts.lib.applist.data;

import com.google.gson.annotations.SerializedName;

/**
 * A data cell from the AppList json.
 */
public class Cell
{
    private int    mRow;

    private int    mCol;

    @SerializedName("$t")
    private String mValue;

    /**
     * @return the row
     */
    public int getRow()
    {
        return this.mRow;
    }

    /**
     * @param row the row to set
     */
    public void setRow(final int row)
    {
        this.mRow = row;
    }

    /**
     * @return the col
     */
    public int getCol()
    {
        return this.mCol;
    }

    /**
     * @param col the col to set
     */
    public void setCol(final int col)
    {
        this.mCol = col;
    }

    /**
     * @return the value
     */
    public String getValue()
    {
        return this.mValue;
    }

    /**
     * @param value the value to set
     */
    public void setValue(final String value)
    {
        this.mValue = value;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("nls")
    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder();
        builder.append("Cell [mRow=");
        builder.append(this.mRow);
        builder.append(", mCol=");
        builder.append(this.mCol);
        builder.append(", mValue=");
        builder.append(this.mValue);
        builder.append("]");
        return builder.toString();
    }

}
