package com.sage42.androidappaddicts.app.applist;

import java.util.List;

import com.sage42.androidappaddicts.app.model.dao.CursorListAdapter;
import com.sage42.androidappaddicts.app.model.data.App;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class ByShowSelectedListAdapter extends CursorListAdapter
{

    private List<List<App>> mApp;

    public ByShowSelectedListAdapter(final Context context)
    {
        super(context);
    }

    public void swapList(final List<List<App>> app)
    {
        this.mApp = app;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount()
    {
        return this.mApp == null ? 0 : this.mApp.size();
    }

    @Override
    public List<App> getItem(final int position)
    {
        return this.mApp.get(position);
    }

    @Override
    public long getItemId(final int position)
    {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent)
    {
        ByShowSelectedListItemLayout itemLayout;

        if (convertView == null)
        {
            itemLayout = ByShowSelectedListItemLayout_.build(this.mContext);
        }
        else
        {
            itemLayout = (ByShowSelectedListItemLayout_) convertView;
        }

        itemLayout.bind(this.mApp.get(position));

        return itemLayout;
    }

}
