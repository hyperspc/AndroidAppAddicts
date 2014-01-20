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
