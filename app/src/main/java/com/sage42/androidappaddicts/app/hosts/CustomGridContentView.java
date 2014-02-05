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

package com.sage42.androidappaddicts.app.hosts;

import com.sage42.androidappaddicts.app.util.SizeUtils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class CustomGridContentView extends RelativeLayout
{

    /**
     * @param context
     */
    public CustomGridContentView(final Context context)
    {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public CustomGridContentView(final Context context, final AttributeSet attrs)
    {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    public CustomGridContentView(final Context context, final AttributeSet attrs, final int defStyle)
    {
        super(context, attrs, defStyle);
    }

    /*
     * (non-Javadoc)
     * @see android.widget.ImageView#onMeasure(int, int)
     */
    @Override
    public void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec)
    {
        final int fixHeight = widthMeasureSpec + SizeUtils.getDpi(this.getResources(), 60);
        super.onMeasure(widthMeasureSpec, fixHeight);
    }

    /*
     * (non-Javadoc)
     * @see android.view.View#onSizeChanged(int, int, int, int)
     */
    @Override
    protected void onSizeChanged(final int width, final int height, final int oldWidth,
            final int oldHeight)
    {
        super.onSizeChanged(width, height, oldWidth, oldHeight);

        if (this.getLayoutParams() != null && width != height)
        {
            this.getLayoutParams().height = width + SizeUtils.getDpi(this.getResources(), 60);

            this.setLayoutParams(this.getLayoutParams());
        }
    }

}
