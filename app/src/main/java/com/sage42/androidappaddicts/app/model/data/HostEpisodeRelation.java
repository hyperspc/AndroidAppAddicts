package com.sage42.androidappaddicts.app.model.data;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Table;

@Table("Show")
public class HostEpisodeRelation extends Model
{

    @Column("episode_id")
    public long mEpisodeId;

    @Column("host_id")
    public long mHostId;

    public long getEpisodeId()
    {
        return this.mEpisodeId;
    }

    public void setEpisodeId(final long id)
    {
        this.mEpisodeId = id;
    }

    public long getHostId()
    {
        return this.mHostId;
    }

    public void setHostId(final long hostId)
    {
        this.mHostId = hostId;
    }

}
