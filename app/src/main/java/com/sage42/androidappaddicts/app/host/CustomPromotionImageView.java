package com.sage42.androidappaddicts.app.host;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CustomPromotionImageView extends ImageView
{

    /**
     * @param context
     */
    public CustomPromotionImageView(final Context context)
    {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public CustomPromotionImageView(final Context context, final AttributeSet attrs)
    {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    public CustomPromotionImageView(final Context context, final AttributeSet attrs, final int defStyle)
    {
        super(context, attrs, defStyle);
    }

    /* (non-Javadoc)
     * @see android.widget.ImageView#onMeasure(int, int)
     */
    @Override
    public void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    /* (non-Javadoc)
     * @see android.view.View#onSizeChanged(int, int, int, int)
     */
    @Override
    protected void onSizeChanged(final int width, final int height, final int oldWidth, final int oldHeight)
    {
        super.onSizeChanged(width, height, oldWidth, oldHeight);

        if ((this.getLayoutParams() != null) && (width != height))
        {
            this.getLayoutParams().height = width;
            this.setLayoutParams(this.getLayoutParams());
        }
    }

}