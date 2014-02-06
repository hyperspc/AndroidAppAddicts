package com.sage42.androidappaddicts.app.model.data;

import com.google.gson.annotations.SerializedName;

public class RowCountData
{
    @SerializedName("$t")
    private String mValue;

    /**
     * @return the value
     */
    public String getValue()
    {
        return this.mValue;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(final String value)
    {
        this.mValue = value;
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
        builder.append("RowCountData [mValue=");
        builder.append(this.mValue);
        builder.append("]");
        return builder.toString();
    }

}
