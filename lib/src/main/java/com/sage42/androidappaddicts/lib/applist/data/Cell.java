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
