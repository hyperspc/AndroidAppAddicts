package com.sage42.androidappaddicts.app.model.dao;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import se.emilsjolander.sprinkles.CursorList;
import se.emilsjolander.sprinkles.QueryResult;

public class CursorListAdapter extends BaseAdapter
{

    protected final Context                   mContext;
    private CursorList<? extends QueryResult> mEpisode;

    public CursorListAdapter(final Context context)
    {
        this.mContext = context;
    }

    public void swapNotes(final CursorList<? extends QueryResult> notes)
    {
        this.mEpisode = notes;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object getItem(final int position)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(final int position)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
