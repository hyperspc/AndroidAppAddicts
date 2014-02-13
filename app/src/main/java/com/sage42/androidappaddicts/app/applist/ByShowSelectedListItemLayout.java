package com.sage42.androidappaddicts.app.applist;

import java.util.List;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.sage42.androidappaddicts.app.R;
import com.sage42.androidappaddicts.app.model.data.App;

@EViewGroup(R.layout.applist_row_of_3)
public class ByShowSelectedListItemLayout extends RelativeLayout
{
    @ViewById(R.id.grid_item_1)
    protected ByShowSelectedAppCardLayout mGrid1;

    @ViewById(R.id.grid_item_2)
    protected ByShowSelectedAppCardLayout mGrid2;

    @ViewById(R.id.grid_item_3)
    protected ByShowSelectedAppCardLayout mGrid3;

    private List<App>                     mData;

    /**
     * Default constructor.
     * 
     * @param context
     */
    public ByShowSelectedListItemLayout(final Context context)
    {
        super(context);
    }

    public void bind(final List<App> data)
    {
        this.mData = data;

        this.buildUi();
    }

    private void buildUi()
    {

        if (this.mGrid1 != null && this.mData != null)
        {
            this.mGrid1.setVisibility(View.INVISIBLE);
            this.mGrid2.setVisibility(View.INVISIBLE);
            this.mGrid3.setVisibility(View.INVISIBLE);
            this.invalidate();
            this.setupUi();
        }
    }

    private void setupUi()
    {

        for (int loop = 0; loop < this.mData.size(); loop++)
        {
            if (loop == 0)
            {
                this.mGrid1.setVisibility(View.VISIBLE);
                this.mGrid1.bind(this.mData.get(0));
                this.invalidate();
            }

            if (loop == 1)
            {

                this.mGrid2.setVisibility(View.VISIBLE);
                this.mGrid2.bind(this.mData.get(1));
                this.invalidate();
            }

            if (loop == 2)
            {

                this.mGrid3.setVisibility(View.VISIBLE);
                this.mGrid3.bind(this.mData.get(2));
                this.invalidate();
            }

        }

    }
}
