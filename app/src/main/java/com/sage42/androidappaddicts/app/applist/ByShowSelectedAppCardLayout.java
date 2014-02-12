package com.sage42.androidappaddicts.app.applist;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sage42.androidappaddicts.app.R;
import com.sage42.androidappaddicts.app.model.data.App;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.apache.commons.lang3.StringUtils;

@EViewGroup(R.layout.applist_row_of_item)
public class ByShowSelectedAppCardLayout extends RelativeLayout
{
    @ViewById(R.id.applist_row_item_image)
    protected ImageView mCardImage;

    @ViewById(R.id.applist_row_item_title)
    protected TextView  mCardTitle;

    @ViewById(R.id.applist_row_item_desc)
    protected TextView  mCardDesc;

    @ViewById(R.id.applist_row_item_price)
    protected TextView  mCardPrice;

    private App         mApp;

    public ByShowSelectedAppCardLayout(final Context context)
    {
        super(context);
    }

    @AfterViews()
    protected void init()
    {
        this.initUi();
    }

    public void bind(final App app)
    {
        this.mApp = app;
        this.initUi();
    }

    public void initUi()
    {

        if (this.mCardTitle != null && this.mApp != null)
        {
            final String imageUrl = this.mApp.getLogoUri();
            if (StringUtils.isNotEmpty(imageUrl))
            {
                Picasso.with(this.getContext()).load(imageUrl).error(R.drawable.ic_launcher).fit()
                                .into(this.mCardImage);
            }

            final String name = this.mApp.getName();
            if (StringUtils.isNotEmpty(name))
            {
                this.mCardTitle.setText(name);
            }
            final String desc = this.mApp.getUri();
            if (StringUtils.isNotEmpty(desc))
            {
                this.mCardDesc.setText(desc);
            }
            final String cost = this.mApp.getCost();
            if (StringUtils.isNotEmpty(cost))
            {
                this.mCardPrice.setText(cost);
            }

        }

    }
}
