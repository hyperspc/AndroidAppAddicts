package com.sage42.androidappaddicts.app.applist;

import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.sage42.androidappaddicts.app.R;
import com.sage42.androidappaddicts.app.model.data.App;

@EViewGroup(R.layout.applist_row_of_3)
public class ByShowSelectedListItemLayout extends RelativeLayout
{
    @ViewById(R.id.applist_base_of_row_of_3)
    protected LinearLayout       mBase;

    ByShowSelectedAppCardLayout_ appCard;
    private List<App>            mData;

    /**
     * Default constructor.
     * 
     * @param context
     */
    public ByShowSelectedListItemLayout(final Context context)
    {
        super(context);
    }

    @AfterViews()
    protected void init()
    {
        this.mBase.setWeightSum(3);
        this.initUi();
    }

    public void bind(final List<App> data)
    {
        this.mData = data;
        this.initUi();
    }

    public void initUi()
    {

        if (this.mBase != null && this.mData != null)
        {

            for (final App app : this.mData)
            {
                this.appCard = (ByShowSelectedAppCardLayout_) ByShowSelectedAppCardLayout_.build(this.getContext());
                final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.weight = 1;
                this.appCard.bind(app);
                this.mBase.addView(this.appCard, layoutParams);
                this.mBase.invalidate();
            }
        }
    }

}
