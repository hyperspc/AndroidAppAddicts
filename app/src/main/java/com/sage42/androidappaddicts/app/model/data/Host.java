package com.sage42.androidappaddicts.app.model.data;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.AutoIncrementPrimaryKey;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Table;

@Table("Shows")
public class Host extends Model
{

    @AutoIncrementPrimaryKey
    @Column("id")
    public int    mId;

    @Column("name")
    public String mName;

    @Column("profile_url")
    public String mProfileUrl;

    @Column("url")
    public String mUrl;

    @Column("category_id")
    public int    categoryId;

    public int getId()
    {
        return this.mId;
    }

    public void setId(final int id)
    {
        this.mId = id;
    }

    public int getCategoryId()
    {
        return this.mId;
    }

    public void setCategoryId(final int categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getName()
    {
        return this.mName;
    }

    public void setName(final String name)
    {
        this.mName = name;
    }

    public String getUrl()
    {
        return this.mUrl;
    }

    public void setUrl(final String url)
    {
        this.mUrl = url;
    }

    public String getProfileUrl()
    {
        return this.mProfileUrl;
    }

    public void setProfileUrl(final String profileUrl)
    {
        this.mProfileUrl = profileUrl;
    }

}
