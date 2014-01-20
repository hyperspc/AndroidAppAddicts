package com.sage42.androidappaddicts.lib.applist.data;

public class App
{
    private int    mEpisode;
    private String mName;
    private String mUri;
    private String mSource;
    private String mCost;
    private String mLogoUri;

    /**
     * @return the episode
     */
    public int getEpisode()
    {
        return this.mEpisode;
    }

    /**
     * @param episode the episode to set
     */
    public void setEpisode(int episode)
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
     * @param name the name to set
     */
    public void setName(String name)
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
     * @param uri the uri to set
     */
    public void setUri(String uri)
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
     * @param source the source to set
     */
    public void setSource(String source)
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
     * @param cost the cost to set
     */
    public void setCost(String cost)
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
     * @param logoUri the logoUri to set
     */
    public void setLogoUri(String logoUri)
    {
        this.mLogoUri = logoUri;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("nls")
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
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
        builder.append("]");
        return builder.toString();
    }

}
