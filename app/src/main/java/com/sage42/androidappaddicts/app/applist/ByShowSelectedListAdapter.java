package com.sage42.androidappaddicts.app.applist;

import com.sage42.androidappaddicts.app.model.data.App;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import se.emilsjolander.sprinkles.CursorList;

public class ByShowSelectedListAdapter extends BaseAdapter
{

    private final Context   mContext;
    private CursorList<App> mApp;

    public ByShowSelectedListAdapter(final Context context)
    {
        this.mContext = context;

    }

    public void swapList(final CursorList<App> notes)
    {
        if (this.mApp != null)
        {
            this.mApp.close();
        }
        this.mApp = notes;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount()
    {
        return this.mApp == null ? 0 : this.mApp.size();
    }

    @Override
    public App getItem(final int position)
    {
        return this.mApp.get(position);
    }

    @Override
    public long getItemId(final int position)
    {
        return this.mApp.get(position).getId();
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent)
    {
        ByShowSelectedListItemLayout_ itemLayout;

        if (convertView == null)
        {
            itemLayout = (ByShowSelectedListItemLayout_) ByShowSelectedListItemLayout_.build(this.mContext);
        }
        else
        {
            itemLayout = (ByShowSelectedListItemLayout_) convertView;
        }

        // itemLayout.bind(this.mApp.get(position));

        return itemLayout;
    }

}
