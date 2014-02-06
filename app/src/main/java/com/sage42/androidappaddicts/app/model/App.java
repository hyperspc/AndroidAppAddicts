package com.sage42.androidappaddicts.app.model;

import java.util.Date;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.AutoIncrementPrimaryKey;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Table;

@Table("App")
public class App extends Model
{

    @AutoIncrementPrimaryKey
    @Column("id")
    public long   id;

    @Column("name")
    public String name;

    @Column("description")
    public String description;

    @Column("rate")
    public String rate;

    @Column("price")
    public double price;

    @Column("imageUrl")
    public String img;

    @Column("category")
    public String category;

    @Column("show_id")
    public long   showId;

    @Column("date_added")
    private Date  dateAdded = new Date();

    @Column("updated_at")
    private Date  updatedAt = new Date();

    public long getId()
    {
        return this.id;
    }

    public void setId(final long id)
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

    public String getRate()
    {
        return this.rate;
    }

    public void setRate(final String rate)
    {
        this.rate = rate;
    }

    public double getPrice()
    {
        return this.price;
    }

    public void setPrice(final double price)
    {
        this.price = price;
    }

    public String getImg()
    {
        return this.img;
    }

    public void setImg(final String imgUrl)
    {
        this.img = imgUrl;
    }

    public String getCategory()
    {
        return this.category;
    }

    public void setCategory(final String category)
    {
        this.category = category;
    }

    public long getShowId()
    {
        return this.showId;
    }

    public void setShowId(final long showId)
    {
        this.showId = showId;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public Date getDateAdded()
    {
        return this.dateAdded;
    }

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setDateAdded(final Date date)
    {
        this.dateAdded = date;
    }

    public void SetUpdatedAt(final Date date)
    {
        this.updatedAt = date;
    }

}
