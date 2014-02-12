package com.sage42.androidappaddicts.app.applist;

import java.text.SimpleDateFormat;
import java.util.Locale;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sage42.androidappaddicts.app.R;
import com.sage42.androidappaddicts.app.model.data.Episode;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.apache.commons.lang3.StringUtils;

@EViewGroup(R.layout.applist_by_show_selected_list_header)
public class ByShowSelectedListHeader extends RelativeLayout
{
    @ViewById(R.id.applist_by_show_number)
    protected TextView mHeaderNumber;

    @ViewById(R.id.applist_by_show_title)
    protected TextView mHeaderTitle;

    @ViewById(R.id.applist_by_show_duration_length)
    protected TextView mHeaderDuration;

    @ViewById(R.id.applist_by_show_add_date)
    protected TextView mHeaderDate;

    @ViewById(R.id.applist_by_show_author)
    protected TextView mHeaderAuthor;

    private Episode    mEpisode;

    public ByShowSelectedListHeader(final Context context)
    {
        super(context);
    }

    @AfterViews()
    protected void init()
    {
        this.setTexts();
    }

    public void bind(final Episode episode)
    {
        this.mEpisode = episode;
        this.setTexts();
    }

    public void setTexts()
    {

        if (this.mHeaderNumber != null && this.mEpisode != null)
        {
            this.mHeaderNumber.setText(Long.toString(this.mEpisode.getId()));
            final String name = this.mEpisode.getName();
            if (StringUtils.isNotEmpty(name))
            {
                this.mHeaderTitle.setText(name);
            }
            final String duration = this.mEpisode.getDuration();
            if (StringUtils.isNotEmpty(duration))
            {
                this.mHeaderDuration.setText(duration);
            }

            if (StringUtils.isNotEmpty(this.mEpisode.getDateAdded().toString()))
            {
                final SimpleDateFormat simpleDate = new SimpleDateFormat("dd LLL yy", Locale.US); //$NON-NLS-1$
                final String date = simpleDate.format(this.mEpisode.getDateAdded()).toString();

                this.mHeaderDate.setText(date);
            }
            final StringBuilder author = new StringBuilder("Steve Cherubino"); //$NON-NLS-1$
            author.append(System.getProperty("line.separator")); //$NON-NLS-1$
            author.append("Steve McLaughlin"); //$NON-NLS-1$
            author.append(System.getProperty("line.separator")); //$NON-NLS-1$
            author.append("Eric Arduini"); //$NON-NLS-1$
            author.append(System.getProperty("line.separator")); //$NON-NLS-1$
            author.append("Sean 'Dirty Thumbs' Johnson"); //$NON-NLS-1$

            this.mHeaderAuthor.setText(author.toString());
        }

    }
}
