package com.sage42.androidappaddicts.app.model;

import java.util.Date;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.AutoIncrementPrimaryKey;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Table;

@Table("Shows")
public class Show extends Model
{

    @AutoIncrementPrimaryKey
    @Column("id")
    public int    id;

    @Column("name")
    public String name;

    @Column("number")
    public String number;

    @Column("duration")
    public String duration;

    @Column("date_added")
    public String dateAdded;

    @Column("created_at")
    private Date  createdAt = new Date();
    @Column("updated_at")
    private Date  updatedAt = new Date();

    public long getId()
    {
        return this.id;
    }

    public void setId(final int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getDateAdded()
    {
        return this.duration;
    }

    public void setDateAdded(final String duration)
    {
        this.duration = duration;
    }

    public String getDuration()
    {
        return this.duration;
    }

    public void setDuration(final String duration)
    {
        this.duration = duration;
    }

    public String getNumber()
    {
        return this.number;
    }

    public void setNumber(final String number)
    {
        this.number = number;
    }

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void SetCreatedAt(final Date date)
    {
        this.createdAt = date;
    }

    public void SetUpdatedAt(final Date date)
    {
        this.updatedAt = date;
    }

}
