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

public class App implements Cloneable
{
    private int            mEpisode;
    private String         mName;
    private String         mUri;
    private String         mSource;
    private String         mCost;
    private String         mLogoUri;
    private HostRatingEnum mRating;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    public App clone()
    {
        try
        {
            return (App) super.clone();
        }
        catch (final CloneNotSupportedException e)
        {
            // should not happen
            return null;
        }
    }

    /**
     * @return the episode
     */
    public int getEpisode()
    {
        return this.mEpisode;
    }

    /**
     * @param episode
     *            the episode to set
     */
    public void setEpisode(final int episode)
    {
        this.mEpisode = episode;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return this.mName;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name)
    {
        this.mName = name;
    }

    /**
     * @return the uri
     */
    public String getUri()
    {
        return this.mUri;
    }

    /**
     * @param uri
     *            the uri to set
     */
    public void setUri(final String uri)
    {
        this.mUri = uri;
    }

    /**
     * @return the source
     */
    public String getSource()
    {
        return this.mSource;
    }

    /**
     * @param source
     *            the source to set
     */
    public void setSource(final String source)
    {
        this.mSource = source;
    }

    /**
     * @return the cost
     */
    public String getCost()
    {
        return this.mCost;
    }

    /**
     * @param cost
     *            the cost to set
     */
    public void setCost(final String cost)
    {
        this.mCost = cost;
    }

    /**
     * @return the logoUri
     */
    public String getLogoUri()
    {
        return this.mLogoUri;
    }

    /**
     * @param logoUri
     *            the logoUri to set
     */
    public void setLogoUri(final String logoUri)
    {
        this.mLogoUri = logoUri;
    }

    /**
     * @return the rating
     */
    public HostRatingEnum getRating()
    {
        return this.mRating;
    }

    /**
     * @param rating
     *            the rating to set
     */
    public void setRating(final HostRatingEnum rating)
    {
        this.mRating = rating;
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
        builder.append("App [mEpisode=");
        builder.append(this.mEpisode);
        builder.append(", mName=");
        builder.append(this.mName);
        builder.append(", mUri=");
        builder.append(this.mUri);
        builder.append(", mSource=");
        builder.append(this.mSource);
        builder.append(", mCost=");
        builder.append(this.mCost);
        builder.append(", mLogoUri=");
        builder.append(this.mLogoUri);
        builder.append(", mRating=");
        builder.append(this.mRating);
        builder.append("]");
        return builder.toString();
    }

}
