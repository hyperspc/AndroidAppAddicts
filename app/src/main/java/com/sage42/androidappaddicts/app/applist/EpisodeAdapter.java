package com.sage42.androidappaddicts.app.applist;

import com.sage42.androidappaddicts.app.model.data.Episode;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import se.emilsjolander.sprinkles.CursorList;

public class EpisodeAdapter extends BaseAdapter
{

    private final Context       mContext;
    private CursorList<Episode> mEpisode;

    public EpisodeAdapter(final Context context)
    {
        this.mContext = context;

    }

    public void swapNotes(final CursorList<Episode> notes)
    {
        if (this.mEpisode != null)
        {
            this.mEpisode.close();
        }
        this.mEpisode = notes;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount()
    {
        return this.mEpisode == null ? 0 : this.mEpisode.size();
    }

    @Override
    public Episode getItem(final int position)
    {
        return this.mEpisode.get(position);
    }

    @Override
    public long getItemId(final int position)
    {
        return this.mEpisode.get(position).getId();
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent)
    {
        EpisodeItemLayout_ itemLayout;

        if (convertView == null)
        {
            itemLayout = (EpisodeItemLayout_) EpisodeItemLayout_.build(this.mContext);
        }
        else
        {
            itemLayout = (EpisodeItemLayout_) convertView;
        }
        itemLayout.bind(this.mEpisode.get(position));

        return itemLayout;
    }

}
