package com.sage42.androidappaddicts.app.model.data;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Table;

@Table("Show")
public class AppEpisodeRelation extends Model
{

    @Column("episode_id")
    public long mEpisodeId;

    @Column("app_id")
    public long mAppId;

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
