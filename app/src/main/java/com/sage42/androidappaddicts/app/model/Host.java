package com.sage42.androidappaddicts.app.model;

import java.util.Date;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.AutoIncrementPrimaryKey;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Table;

@Table("Shows")
public class Host extends Model
{

    @AutoIncrementPrimaryKey
    @Column("id")
    public int    id;

    @Column("name")
    public String name;

    @Column("contact")
    public String contact;

    @Column("email")
    public String email;

    @Column("category_id")
    public int    categoryId;

    @Column("date_added")
    private Date  dateAdded = new Date();

    @Column("updated_at")
    private Date  updatedAt = new Date();

    public int getId()
    {
        return this.id;
    }

    public void setId(final int id)
    {
        this.id = id;
    }

    public int getCategoryId()
    {
        return this.id;
    }

    public void setCategoryId(final int categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    public String getContact()
    {
        return this.contact;
    }

    public void setContact(final String contact)
    {
        this.contact = contact;
    }

    public Date getDateAdded()
    {
        return this.dateAdded;
    }

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void SetDateAdded(final Date date)
    {
        this.dateAdded = date;
    }

    public void SetUpdatedAt(final Date date)
    {
        this.updatedAt = date;
    }

}
