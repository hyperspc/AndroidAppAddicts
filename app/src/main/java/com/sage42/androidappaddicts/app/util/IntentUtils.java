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
package com.sage42.androidappaddicts.app.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * Intent related utility functions.
 */
public final class IntentUtils
{
    private static final String TAG = IntentUtils.class.getSimpleName();

    private IntentUtils()
    {
        // enforcing singleton
        super();
    }

    /**
     * Trigger the dialer with the supplied number already populated.
     * 
     * @param context
     * @param phone
     */
    public static void doCall(final Context context, final String phone)
    {
        try
        {
            final Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phone)); //$NON-NLS-1$
            context.startActivity(intent);
        }
        catch (final ActivityNotFoundException e)
        {
            Log.w(IntentUtils.TAG, "Call failed"); //$NON-NLS-1$
        }
    }

    /**
     * Trigger the sms with the supplied number already populated.
     * 
     * @param context
     * @param phone
     * @param message
     */
    public static void doSms(final Context context, final String phone, final String message)
    {
        try
        {
            final Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:" + phone)); //$NON-NLS-1$
            intent.putExtra("sms_body", message); //$NON-NLS-1$
            context.startActivity(intent);
        }
        catch (final ActivityNotFoundException e)
        {
            Log.w(IntentUtils.TAG, "Sms failed"); //$NON-NLS-1$
        }
    }

    /**
     * Trigger an email program with the supplied address pre-filled.
     * 
     * @param context
     * @param email
     */
    public static void doEmail(final Context context, final String email)
    {
        try
        {
            final Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("mailto:" + email)); //$NON-NLS-1$
            context.startActivity(intent);
        }
        catch (final ActivityNotFoundException e)
        {
            Log.w(IntentUtils.TAG, "Email failed"); //$NON-NLS-1$
        }
    }

    /**
     * Show Google Maps with the specified location displayed.
     * 
     * @param context
     * @param geoString
     */
    public static void doShowMap(final Context context, final String geoString)
    {
        try
        {
            final Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:" + geoString)); //$NON-NLS-1$
            context.startActivity(intent);
        }
        catch (final ActivityNotFoundException e)
        {
            Log.w(IntentUtils.TAG, "Show map failed"); //$NON-NLS-1$
        }
    }

    /**
     * Trigger an web browser with the supplied address pre-filled.
     * 
     * @param context
     * @param url
     */
    public static void doShowUri(final Context context, final String url)
    {
        try
        {
            final Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            context.startActivity(intent);
        }
        catch (final ActivityNotFoundException e)
        {
            Log.w(IntentUtils.TAG, "Show URL failed"); //$NON-NLS-1$
        }
    }

    /**
     * So the specified FB page in either the FB app or via the web.
     * 
     * @param context
     * @param fbPageViaApp
     *            url in the form fb://page/12341234
     * @param url
     *            url in the form http://www.facebook.com/SomePage
     */
    public static void doShowFacebook(final Context context, final String fbPageViaApp, final String url)
    {
        try
        {
            // attempt to display in the facebook app
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(fbPageViaApp)));
        }
        catch (final Exception e)
        {
            // no facebook app installed, use website instead
            Log.w(IntentUtils.TAG, "Show via FB app failed"); //$NON-NLS-1$

            // showing via url instead
            IntentUtils.doShowUri(context, url);
        }
    }

    /**
     * Trigger an external intent.
     * 
     * @param context
     * @param intentDest
     */
    public static void doIntent(final Context context, final Uri intentDest)
    {
        try
        {
            final Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(intentDest);
            context.startActivity(intent);
        }
        catch (final ActivityNotFoundException e)
        {
            Log.w(IntentUtils.TAG, "Intent failed"); //$NON-NLS-1$\
        }
    }

    /**
     * Trigger the standard android share dialog with the supplied title and payload.
     * 
     * @param context
     *            standard android context
     * @param title
     *            title to be displayed on the share dialog
     * @param data
     *            data to be shared NOTE: sharing via facebook is broken by facebook and therefore the data payload will
     *            be ignored in that case.
     */
    public static void doShare(final Context context, final String data)
    {
        final Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, data);
        sendIntent.setType("text/plain"); //$NON-NLS-1$
        context.startActivity(Intent.createChooser(sendIntent, data));
    }

}
