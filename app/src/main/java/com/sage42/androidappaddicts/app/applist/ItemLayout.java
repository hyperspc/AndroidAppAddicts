package com.sage42.androidappaddicts.app.applist;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import com.sage42.androidappaddicts.app.model.App;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sage42.androidappaddicts.app.R;

@EViewGroup(R.layout.list_item)
public class ItemLayout extends RelativeLayout
{
    @ViewById(R.id.category_text)
    protected TextView mTitle;

    /**
     * Default constructor.
     * 
     * @param context
     */
    public ItemLayout(final Context context)
    {
        super(context);
    }

    public void bind(final App data)
    {
        if (this.mTitle != null)
        {
            this.mTitle.setText(data.getName());
        }
    }

}
