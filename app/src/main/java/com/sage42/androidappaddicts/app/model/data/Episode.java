package com.sage42.androidappaddicts.app.model.data;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.PrimaryKey;
import se.emilsjolander.sprinkles.annotations.Table;

@Table("episode")
public class Episode extends Model implements Parcelable
{
    @PrimaryKey
    @Column("episode_id")
    public long   mEpisodeId;

    @Column("name")
    public String mName;

    @Column("duration")
    public String mDuration;

    @Column("date_added")
    private Date  mDateAdded = new Date();

    public long getId()
    {
        return this.mEpisodeId;
    }

    public void setId(final long id)
    {
        this.mEpisodeId = id;
    }

    public String getName()
    {
        return this.mName;
    }

    public void setName(final String name)
    {
        this.mName = name;
    }

    public String getDuration()
    {
        return this.mDuration;
    }

    public void setDuration(final String duration)
    {
        this.mDuration = duration;
    }

    public Date getDateAdded()
    {
        return this.mDateAdded;
    }

    public void SetDateAdded(final Date date)
    {
        this.mDateAdded = date;
    }

    @Override
    public int describeContents()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags)
    {
        // TODO Auto-generated method stub

    }

}
