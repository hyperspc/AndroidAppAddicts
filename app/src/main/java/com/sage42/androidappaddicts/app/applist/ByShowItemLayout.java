package com.sage42.androidappaddicts.app.applist;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.apache.commons.lang3.StringUtils;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sage42.androidappaddicts.app.R;
import com.sage42.androidappaddicts.app.model.data.Episode;

@EViewGroup(R.layout.applist_by_show_listview_item)
public class ByShowItemLayout extends RelativeLayout
{
    @ViewById(R.id.applist_by_show_number)
    protected TextView mEpisodeId;

    @ViewById(R.id.applist_by_show_title)
    protected TextView mEpisodeTitle;

    @ViewById(R.id.applist_by_show_duration_length)
    protected TextView mEpisodeDuration;

    @ViewById(R.id.applist_by_show_add_date)
    protected TextView mEpisodeDate;

    /**
     * Default constructor.
     * 
     * @param context
     */
    public ByShowItemLayout(final Context context)
    {
        super(context);
    }

    public void bind(final Episode data)
    {
        if (this.mEpisodeId != null && data != null)
        {
            this.mEpisodeId.setText(Long.toString(data.getId()));
            final String name = data.getName();
            if (StringUtils.isNotEmpty(name))
            {
                this.mEpisodeTitle.setText(name);
            }
            final String duration = data.getDuration();
            if (StringUtils.isNotEmpty(duration))
            {
                this.mEpisodeDuration.setText(duration);
            }

            if (StringUtils.isNotEmpty(data.getDateAdded().toString()))
            {
                final SimpleDateFormat simpleDate = new SimpleDateFormat("dd LLL yy", Locale.US); //$NON-NLS-1$
                final String date = simpleDate.format(data.getDateAdded()).toString();

                this.mEpisodeDate.setText(date);
            }
        }
    }

}
