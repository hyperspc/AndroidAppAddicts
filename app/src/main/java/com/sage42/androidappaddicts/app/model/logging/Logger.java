package com.sage42.androidappaddicts.app.model.logging;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

/**
 * Util class that wraps around the standard android logger.
 */
public enum Logger
{
    INSTANCE;

    // TODO: disable before release
    private static final boolean DEBUG = true;

    /**
     * Convenience method.
     * 
     * @see Logger#debug(String, String, Throwable, boolean)
     */
    public static void debug(final String tag, final String message)
    {
        Logger.debug(tag, message, null, false);
    }

    /**
     * Abstraction of the standard android logging mechanics that can account for build/deploy target.
     * 
     * @param tag
     *            log message tag
     * @param message
     *            log message
     * @param throwable
     *            cause of the problem
     * @param forceLog
     *            flag, true will cause the message to always be logged, false will not be logged in production
     */
    public static void debug(final String tag, final String message, final Throwable throwable, final boolean forceLog)
    {
        if (forceLog || DEBUG)
        {
            Log.d(tag, message, throwable);
        }
    }

    /**
     * Convenience method.
     * 
     * @see Logger#info(String, String, Throwable, boolean)
     */
    public static void info(final String tag, final String message)
    {
        Logger.info(tag, message, null, false);
    }

    /**
     * Abstraction of the standard android logging mechanics that can account for build/deploy target.
     * 
     * @param tag
     *            log message tag
     * @param message
     *            log message
     * @param throwable
     *            cause of the problem
     * @param forceLog
     *            flag, true will cause the message to always be logged, false will not be logged in production
     */
    public static void info(final String tag, final String message, final Throwable throwable, final boolean forceLog)
    {
        if (forceLog || DEBUG)
        {
            Log.i(tag, message, throwable);
        }
    }

    /**
     * Convenience method.
     * 
     * @see Logger#warn(String, String, Throwable, boolean)
     */
    public static void warn(final String tag, final String message)
    {
        Logger.warn(tag, message, null, false);
    }

    /**
     * Abstraction of the standard android logging mechanics that can account for build/deploy target (Will log
     * exceptions to Crashlytics if in LIVE mode).
     * 
     * @param tag
     *            log message tag
     * @param message
     *            log message
     * @param throwable
     *            cause of the problem
     * @param forceLog
     *            flag, true will cause the message to always be logged, false will not be logged in production
     */
    public static void warn(final String tag, final String message, final Throwable throwable, final boolean forceLog)
    {
        if (forceLog || DEBUG)
        {
            Log.w(tag, message, throwable);
        }

        // dont log dev bugs
        if (throwable != null)
        {
            Crashlytics.logException(throwable);
        }
        else
        {
            Crashlytics.log(message);
        }
    }

    /**
     * Convenience method.
     * 
     * @see Logger#error(String, String, Throwable, boolean)
     */
    public static void error(final String tag, final String message)
    {
        Logger.error(tag, message, null, false);
    }

    /**
     * Abstraction of the standard android logging mechanics that can account for build/deploy target (Will log
     * exceptions to Crashlytics if in LIVE mode).
     * 
     * @param tag
     *            log message tag
     * @param message
     *            log message
     * @param throwable
     *            cause of the problem
     * @param forceLog
     *            flag, true will cause the message to always be logged, false will not be logged in production
     */
    public static void error(final String tag, final String message, final Throwable throwable, final boolean forceLog)
    {
        if (forceLog || DEBUG)
        {
            Log.e(tag, message, throwable);
        }
        // dont log dev bugs
        if (throwable != null)
        {
            Crashlytics.logException(throwable);
        }
        else
        {
            Crashlytics.log(message);
        }
    }

}
