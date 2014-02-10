package com.sage42.androidappaddicts.app.model.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import se.emilsjolander.sprinkles.Query;

import com.sage42.androidappaddicts.app.model.data.App;
import com.sage42.androidappaddicts.app.model.data.Cell;
import com.sage42.androidappaddicts.app.model.data.Entry;
import com.sage42.androidappaddicts.app.model.data.Episode;
import com.sage42.androidappaddicts.app.model.data.HostRatingEnum;
import com.sage42.androidappaddicts.app.model.data.RawAppList;

/**
 * Convert from parses JSON to the object format we actually want.
 */
public class JsonConverter
{
    // column indexes
    private static final int    COLUMN_EPISODE_NO = 1;
    private static final int    COLUMN_APP_NAME   = 2;
    private static final int    COLUMN_URI        = 3;
    private static final int    COLUMN_SOURCE     = 4;
    private static final int    COLUMN_COST       = 5;
    private static final int    COLUMN_LOGO_URL   = 6;
    private static final int    COLUMN_RATING     = 7;

    // accepted rating values
    private static final Object RATING_UP         = "up";  //$NON-NLS-1$
    private static final Object RATING_DOWN       = "down"; //$NON-NLS-1$

    public List<App> convert(final RawAppList rawData)
    {
        // second pass over the data to put into the format we want.
        if (rawData == null || rawData.isEmpty())
        {
            // no valid data
            return new ArrayList<App>();
        }

        // loop through all the entries and create all list
        final List<App> output = new ArrayList<App>();
        int lastRow = 0;
        App currentApp = new App();
        Episode currentEpi = new Episode();
        final List<Integer> episodes = new ArrayList<Integer>();

        for (final Entry entry : rawData.getFeed().getEntries())
        {
            final Cell cell = entry.getCell();
            final int thisRow = Integer.valueOf(cell.getRow());
            if (lastRow != thisRow)
            {
                // add app to the list 1 time per episode
                for (final Integer episodeNo : episodes)
                {
                    // TODO:move to EpisodeTable

                    currentEpi = Query.one(Episode.class, "SELECT * FROM episode where episode_id = ?", new int[] //$NON-NLS-1$
                                    { episodeNo }).get();
                    if (currentEpi == null)
                    {
                        currentEpi = new Episode();
                        currentEpi.setId(episodeNo);
                        currentEpi.SetDateAdded(new Date());
                        currentEpi.setName("Stupid things"); //$NON-NLS-1$
                        currentEpi.setDuration("1.11.11"); //$NON-NLS-1$
                        currentEpi.save();
                    }

                    // currentApp.setEpisode(episodeNo);
                    output.add(currentApp.clone());
                }

                // start a new app
                currentApp = new App();
                lastRow = thisRow;
            }

            switch (Integer.valueOf(cell.getCol()))
            {
                case COLUMN_EPISODE_NO:
                    // parse out extra chars caused by the duplicates
                    final String value = cell.getValue().replace("'", "").replace("&", ","); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$
                    final String[] episodesList = value.split(","); //$NON-NLS-1$
                    episodes.clear();
                    for (final String episodeString : episodesList)
                    {
                        episodes.add(Integer.parseInt(episodeString.trim()));
                    }
                    break;

                case COLUMN_APP_NAME:
                    currentApp.setName(cell.getValue());
                    break;

                case COLUMN_URI:
                    currentApp.setUri(cell.getValue());
                    break;
                case COLUMN_COST:
                    currentApp.setCost(cell.getValue());
                    break;

                case COLUMN_LOGO_URL:
                    currentApp.setLogoUri(cell.getValue());
                    break;

                case COLUMN_RATING:
                    final String rating = cell.getValue();
                    HostRatingEnum ratingEnum = HostRatingEnum.UNKNOWN;
                    if (rating != null)
                    {
                        if (rating.equals(RATING_UP))
                        {
                            ratingEnum = HostRatingEnum.THUMBS_UP;
                        }
                        else if (rating.equals(RATING_DOWN))
                        {
                            ratingEnum = HostRatingEnum.THUMBS_DOWN;
                        }
                    }
                    currentApp.setRating(ratingEnum.ordinal());

                    currentApp.save();
                    break;

                default:
                    // anything else we don't care about
                    continue;
            }

        }

        return output;
    }
}