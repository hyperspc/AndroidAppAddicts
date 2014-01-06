package com.sage42.androidappaddicts.app.menu;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sage42.androidappaddicts.R;

@EViewGroup(R.layout.main_menu_item)
public class MenuItemLayout extends RelativeLayout
{
    @ViewById(R.id.menu_item_header)
    protected TextView mHeader;

    @ViewById(R.id.menu_item_content)
    protected TextView mContent;

    @ViewById(R.id.menu_item_header_underline)
    protected View     mUnderline;

    @ViewById(R.id.menu_item_content_underline)
    protected View     mContentUnderline;

    /**
     * Default constructor.
     * 
     * @param context
     */
    public MenuItemLayout(final Context context)
    {
        super(context);
    }

    /**
     * Bind the data to the UI.
     * 
     * @param data
     */
    public void renderItem(final MenuItem data)
    {
        // toggle between header and item display
        if (data.isCategoryMarker())
        {
            this.mHeader.setText(data.getTitleResId());
            this.mHeader.setVisibility(View.VISIBLE);
            this.mUnderline.setVisibility(View.VISIBLE);
            this.mContent.setVisibility(View.GONE);
            this.mContentUnderline.setVisibility(View.GONE);
        }
        else
        {
            this.mContent.setText(data.getTitleResId());
            this.mHeader.setVisibility(View.GONE);
            this.mUnderline.setVisibility(View.GONE);
            this.mContent.setVisibility(View.VISIBLE);
            this.mContentUnderline.setVisibility(View.VISIBLE);
        }

        if (data.getIconResId() != null)
        {
            // assign icon
            this.mContent.setCompoundDrawablesWithIntrinsicBounds(data.getIconResId(), 0, 0, 0);
        }
        else
        {
            // hide the icon
            this.mContent.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

}
