package com.sage42.androidappaddicts.app.settings;

/**
 * Please note: categoryResId when it is not null it will render a category
 * title. This means to add "sections" to the menu you only need to add this to
 * the first item in the section.
 */
public class SettingsMenuItem
{
    private Integer       mTitleResId;
    private boolean       mIsSelectable;
    private final boolean mCheckable;

    /**
     * Default constructor.
     * 
     * @param titleResId
     * @param categoryMarker
     */
    public SettingsMenuItem(final Integer titleResId, final boolean isSelectable, final boolean checkable)
    {
        super();
        this.mTitleResId = titleResId;
        this.mIsSelectable = isSelectable;
        this.mCheckable = checkable;
    }

    /**
     * retrieve the menu item title.
     * 
     * @return
     */
    public Integer getTitleResId()
    {
        return this.mTitleResId;
    }

    /**
     * set the menu item title.
     * 
     * @param titleResId
     */
    public void setTitleResId(final Integer titleResId)
    {
        this.mTitleResId = titleResId;
    }

    /**
     * check the menu item contain a checkbox .
     * 
     * @return
     */
    public boolean isClickable()
    {
        return this.mCheckable;
    }

    /**
     * check the menu item has a check box .
     * 
     * @return
     */
    public boolean isCheckable()
    {
        return this.mIsSelectable;
    }

    /**
     * @param categoryMarker
     */
    public void setCheckable(final boolean checkable)
    {
        this.mIsSelectable = checkable;
    }

}
