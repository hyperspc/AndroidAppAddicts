package com.sage42.androidappaddicts.app.applist;

import com.sage42.androidappaddicts.app.model.dao.CursorListAdapter;
import com.sage42.androidappaddicts.app.model.data.App;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import se.emilsjolander.sprinkles.CursorList;
import se.emilsjolander.sprinkles.QueryResult;

public class ByCategoryAdapter extends CursorListAdapter
{
    private CursorList<App> mApp;

    public ByCategoryAdapter(final Context context)
    {
        super(context);
    }

    @Override
    public void swapNotes(final CursorList<? extends QueryResult> notes)
    {
        if (this.mApp != null)
        {
            this.mApp.close();
        }
        this.mApp = (CursorList<App>) notes;
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
        ByCategoryItemLayout_ itemLayout;

        if (convertView == null)
        {
            itemLayout = (ByCategoryItemLayout_) ByCategoryItemLayout_.build(this.mContext);
        }
        else
        {
            itemLayout = (ByCategoryItemLayout_) convertView;
        }
        itemLayout.bind(this.mApp.get(position));

        return itemLayout;
    }

}
