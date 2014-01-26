/**
 *  Copyright (C) 2013-2014 Sage 42 Apps Sdn Bhd
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.sage42.androidappaddicts.lib.applist;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.sage42.androidappaddicts.lib.applist.data.App;
import com.sage42.androidappaddicts.lib.applist.data.Entry;
import com.sage42.androidappaddicts.lib.applist.data.Feed;
import com.sage42.androidappaddicts.lib.applist.data.RawAppList;

/**
 * Test conversion from json string to list.
 */
public class JsonConverterTest
{
    @Test
    public void testJsonParserSample() throws IOException
    {
        // load file to test
        final String text = this.loadSampleFile();

        final JsonConverter converter = new JsonConverter();
        final RawAppList rawAppList = converter.parseJson(text);

        assertThat(rawAppList, is(notNullValue()));

        final Feed feed = rawAppList.getFeed();
        assertThat(feed, is(notNullValue()));
        assertThat(feed.getRowCount(), is(notNullValue()));
        assertThat(feed.getRowCount().getValue(), is("2")); //$NON-NLS-1$

        final Entry[] entries = feed.getEntries();
        assertThat(entries, is(notNullValue()));
        assertThat(entries.length, is(14));
    }

    @Test
    public void testConvertSample() throws IOException
    {
        // load file to test
        final String text = this.loadSampleFile();

        final JsonConverter converter = new JsonConverter();
        List<App> appList = converter.convert(text);
        assertThat(appList, is(notNullValue()));
        assertThat(appList.size(), is(2));

        // verfy app details
        App app1 = appList.get(0);
        assertThat(app1, is(notNullValue()));
        assertThat(app1.getEpisode(), is(163));
        assertThat(app1.getName(), is("Caustic 3")); //$NON-NLS-1$
        assertThat(app1.getUri(), is("https://play.google.com/store/apps/details?id=com.singlecellsoftware.caustic")); //$NON-NLS-1$
        assertThat(app1.getSource(), is("Email/Josh")); //$NON-NLS-1$
        assertThat(app1.getCost(), is("Free")); //$NON-NLS-1$
        assertThat(app1.getLogoUri(),
                        is("https://lh4.ggpht.com/HXTquR1zI3hs6O6oX2TZx3rv0NRkaESKSa4Px7d2GqAxKmI18XOdgxoj-RPhfnUx7w=w300-rw")); //$NON-NLS-1$

        App app2 = appList.get(1);
        assertThat(app2, is(notNullValue()));
        assertThat(app2.getEpisode(), is(163));
        assertThat(app2.getName(), is("Gun Club 3: Virtual Weapon Sim")); //$NON-NLS-1$
        assertThat(app2.getUri(), is("https://play.google.com/store/apps/details?id=com.nextgenreality.gunclub3")); //$NON-NLS-1$
        assertThat(app2.getSource(), is("Email/Jesse")); //$NON-NLS-1$
        assertThat(app2.getCost(), is("Free")); //$NON-NLS-1$
        assertThat(app2.getLogoUri(),
                        is("https://lh6.ggpht.com/HFMvx6io0hu4ctDJBzhOw8aMOkv7hTR_fs6_kh7usJiH6a1q73LZj7ej7HOT0B5Akr0=w300-rw")); //$NON-NLS-1$

    }

    private String loadSampleFile() throws IOException
    {
        final URL url = Resources.getResource("sample_applist.json"); //$NON-NLS-1$
        final String text = Resources.toString(url, Charsets.UTF_8);

        assertThat(text, is(notNullValue()));

        return text;
    }

}
