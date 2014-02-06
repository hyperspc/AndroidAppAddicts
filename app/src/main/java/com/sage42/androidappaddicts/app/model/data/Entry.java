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
package com.sage42.androidappaddicts.app.model.data;

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
     * @param cell
     *            the cell to set
     */
    public void setCell(final Cell cell)
    {
        this.mCell = cell;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("nls")
    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder();
        builder.append("Entry [mCell=");
        builder.append(this.mCell);
        builder.append("]");
        return builder.toString();
    }

}
