package com.sage42.androidappaddicts.app.applist;

import com.sage42.androidappaddicts.app.model.dao.CursorListAdapter;
import com.sage42.androidappaddicts.app.model.data.Episode;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import se.emilsjolander.sprinkles.CursorList;
import se.emilsjolander.sprinkles.QueryResult;

public class ByShowAdapter extends CursorListAdapter
{

    private CursorList<Episode> mEpisode;

    public ByShowAdapter(final Context context)
    {
        super(context);
    }

    @Override
    public void swapNotes(final CursorList<? extends QueryResult> notes)
    {
        this.mEpisode = (CursorList<Episode>) notes;
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
        ByShowItemLayout_ itemLayout;

        if (convertView == null)
        {
            itemLayout = (ByShowItemLayout_) ByShowItemLayout_.build(this.mContext);
        }
        else
        {
            itemLayout = (ByShowItemLayout_) convertView;
        }
        itemLayout.bind(this.mEpisode.get(position));

        return itemLayout;
    }

}
