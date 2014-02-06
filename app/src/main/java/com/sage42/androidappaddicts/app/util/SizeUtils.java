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

import android.content.res.Resources;
import android.util.TypedValue;

public class SizeUtils
{

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
