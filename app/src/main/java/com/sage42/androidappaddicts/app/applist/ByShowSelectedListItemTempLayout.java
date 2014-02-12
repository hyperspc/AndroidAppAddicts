package com.sage42.androidappaddicts.app.applist;

import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.apache.commons.lang3.StringUtils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sage42.androidappaddicts.app.R;
import com.sage42.androidappaddicts.app.model.data.App;
import com.squareup.picasso.Picasso;

@EViewGroup(R.layout.applist_row_of_3_temp)
public class ByShowSelectedListItemTempLayout extends RelativeLayout
{
    @ViewById(R.id.applist_row_item_image_1)
    protected ImageView          mCardImage1;

    @ViewById(R.id.applist_row_item_title_1)
    protected TextView           mCardTitle1;

    @ViewById(R.id.applist_row_item_desc_1)
    protected TextView           mCardDesc1;

    @ViewById(R.id.applist_row_item_price_1)
    protected TextView           mCardPrice1;

    @ViewById(R.id.applist_row_item_image_2)
    protected ImageView          mCardImage2;

    @ViewById(R.id.applist_row_item_title_2)
    protected TextView           mCardTitle2;

    @ViewById(R.id.applist_row_item_desc_2)
    protected TextView           mCardDesc2;

    @ViewById(R.id.applist_row_item_price_2)
    protected TextView           mCardPrice2;

    @ViewById(R.id.applist_row_item_image_3)
    protected ImageView          mCardImage3;

    @ViewById(R.id.applist_row_item_title_3)
    protected TextView           mCardTitle3;

    @ViewById(R.id.applist_row_item_desc_3)
    protected TextView           mCardDesc3;

    @ViewById(R.id.applist_row_item_price_3)
    protected TextView           mCardPrice3;

    ByShowSelectedAppCardLayout_ appCard;
    private List<App>            mData;

    /**
     * Default constructor.
     * 
     * @param context
     */
    public ByShowSelectedListItemTempLayout(final Context context)
    {
        super(context);
    }

    @AfterViews()
    protected void init()
    {
        this.initUi();
    }

    public void bind(final List<App> data)
    {
        this.mData = data;
        this.initUi();
    }

    public void initUi()
    {

        if (this.mCardImage1 != null && this.mData != null)
        {
            this.setupUi();
        }
    }

    public void setupUi()
    {

        final String imageUrl = this.mData.get(0).getLogoUri();
        if (StringUtils.isNotEmpty(imageUrl))
        {
            Picasso.with(this.getContext()).load(imageUrl).error(R.drawable.ic_launcher).fit().into(this.mCardImage1);
        }

        final String name = this.mData.get(0).getName();
        if (StringUtils.isNotEmpty(name))
        {
            this.mCardTitle1.setText(name);
        }
        final String desc = this.mData.get(0).getUri();
        if (StringUtils.isNotEmpty(desc))
        {
            this.mCardDesc1.setText(desc);
        }
        final String cost = this.mData.get(0).getCost();
        if (StringUtils.isNotEmpty(cost))
        {
            this.mCardPrice1.setText(cost);
        }
    }
}
