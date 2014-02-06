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
 * Data object needed to parse the AppList JSON.
 */
public class RawAppList
{
    @SerializedName("feed")
    private Feed mFeed;

    public boolean isEmpty()
    {
        if (this.mFeed == null)
        {
            return true;
        }
        final RowCountData rowCount = this.mFeed.getRowCount();
        if ((rowCount == null) || rowCount.getValue().equals("0")) //$NON-NLS-1$
        {
            return true;
        }

        return false;
    }

    /**
     * @return the feed
     */
    public Feed getFeed()
    {
        return this.mFeed;
    }

    /**
     * @param feed
     *            the feed to set
     */
    public void setFeed(final Feed feed)
    {
        this.mFeed = feed;
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
        builder.append("RawAppList [mFeed=");
        builder.append(this.mFeed);
        builder.append("]");
        return builder.toString();
    }

}
