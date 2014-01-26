package com.sage42.androidappaddicts.lib.applist;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.sage42.androidappaddicts.lib.applist.data.App;
import com.sage42.androidappaddicts.lib.applist.data.Cell;
import com.sage42.androidappaddicts.lib.applist.data.Entry;
import com.sage42.androidappaddicts.lib.applist.data.RawAppList;

public class JsonConverter
{
    // column indexes
    private static final int COLUMN_EPISODE_NO = 1;
    private static final int COLUMN_APP_NAME   = 2;
    private static final int COLUMN_URI        = 3;
    private static final int COLUMN_SOURCE     = 4;
    private static final int COLUMN_COST       = 5;
    private static final int COLUMN_LOGO_URL   = 6;

    public List<App> convert(final String inputJson)
    {
        // parse it (gson)
        final RawAppList rawData = this.parseJson(inputJson);

        // second pass over the data to put into the format we want.
        if ((rawData == null) || (rawData.isEmpty()))
        {
            // no valid data
            return new ArrayList<App>();
        }

        // loop through all the entries and create all list
        final List<App> output = new ArrayList<App>();
        int lastRow = 0;
        App currentApp = new App();
        for (final Entry entry : rawData.getFeed().getEntries())
        {
            final Cell cell = entry.getCell();
            int thisRow = Integer.valueOf(cell.getRow());
            if (lastRow != thisRow)
            {
                // start a new app
                currentApp = new App();
                output.add(currentApp);
                lastRow = thisRow;
            }

            switch (Integer.valueOf(cell.getCol()))
            {
                case COLUMN_EPISODE_NO:
                    currentApp.setEpisode(Integer.valueOf(cell.getValue().replace("'", ""))); //$NON-NLS-1$//$NON-NLS-2$
                    break;

                case COLUMN_APP_NAME:
                    currentApp.setName(cell.getValue());
                    break;

                case COLUMN_URI:
                    currentApp.setUri(cell.getValue());
                    break;

                case COLUMN_SOURCE:
                    currentApp.setSource(cell.getValue());
                    break;

                case COLUMN_COST:
                    currentApp.setCost(cell.getValue());
                    break;

                case COLUMN_LOGO_URL:
                    currentApp.setLogoUri(cell.getValue());
                    break;

                default:
                    // anything else we don't care about
                    continue;
            }

        }

        return output;
    }

    RawAppList parseJson(final String inputJson)
    {
        return new Gson().fromJson(inputJson, RawAppList.class);
    }

}
