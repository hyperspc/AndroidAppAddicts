package com.sage42.androidappaddicts.app.model.data;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.AutoIncrementPrimaryKey;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Table;

@Table("app_episode_relation")
public class AppEpisodeRelation extends Model
{
    @AutoIncrementPrimaryKey
    @Column("app_episode_id")
    private long mId;

    @Column("episode_id")
    public long  mEpisodeId;

    @Column("app_id")
    public long  mAppId;

    public long getId()
    {
        return this.mId;
    }

    public void setId(final long id)
    {
        this.mId = id;
    }

    public long getEpisodeId()
    {
        return this.mEpisodeId;
    }

    public void setEpisodeId(final long id)
    {
        this.mEpisodeId = id;
    }

    public long getAppId()
    {
        return this.mAppId;
    }

    public void setAppId(final long appId)
    {
        this.mAppId = appId;
    }

}
