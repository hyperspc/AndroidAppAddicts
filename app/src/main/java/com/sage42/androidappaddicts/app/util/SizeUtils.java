package com.sage42.androidappaddicts.app.util;

import android.content.res.Resources;
import android.util.TypedValue;

public class SizeUtils
{
    private static final String TAG = SizeUtils.class.getSimpleName();

    private SizeUtils()
    {
        // enforcing singleton
        super();
    }

    /**
     * Calculate the dpi Size on the given pixels value.
     * 
     * @param Resources
     *            , pixelValue
     * @return dpi
     */
    public static int getDpi(final Resources resources, final int pixelValue)
    {

        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, pixelValue, resources.getDisplayMetrics());
    }
}
