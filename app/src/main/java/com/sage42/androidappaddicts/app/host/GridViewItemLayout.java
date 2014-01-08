package com.sage42.androidappaddicts.app.host;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sage42.androidappaddicts.R;

/**
 * a custom layout class that hold the gridview UI structure and used it as
 * ContentViewHolder for adapters.
 */
@EViewGroup(R.layout.grid_content)
public class GridViewItemLayout extends RelativeLayout
{

    @ViewById(R.id.promo_item_menu)
    protected ImageView mGridMenu;

    @ViewById(R.id.promo_item_image)
    protected ImageView mGridViewImg;

    @ViewById(R.id.promo_item_desc)
    protected TextView  mTitle;

    /**
     * constructor.
     * 
     * @param context
     */
    public GridViewItemLayout(final Context context)
    {
        super(context);
    }

    /**
     * fire up the Popupmenu and provide the routing selection.
     */
    @Click(R.id.promo_item_menu)
    void OpenMenu()
    {

        // not yet implement.
    }
}
