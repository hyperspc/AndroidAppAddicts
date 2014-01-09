package com.sage42.androidappaddicts.app.menu;

/**
 * Please note: categoryResId when it is not null it will render a category title. This means to add "sections" to the
 * menu you only need to add this to the first item in the section.
 */
public class MenuItem
{
    private Integer mIconResId;
    private Integer mTitleResId;
    private boolean mCategoryMarker;

    /**
     * Default constructor.
     * 
     * @param iconResId
     * @param titleResId
     * @param categoryMarker
     */
    public MenuItem(final Integer iconResId, final Integer titleResId, final boolean categoryMarker)
    {
        super();
        this.mIconResId = iconResId;
        this.mTitleResId = titleResId;
        this.mCategoryMarker = categoryMarker;

    }

    /**
     * retrieve the icon id.
     * 
     * @return
     */
    public Integer getIconResId()
    {
        return this.mIconResId;
    }

    /**
     * initialise the icon id.
     * 
     * @param iconResId
     */
    public void setIconResId(final Integer iconResId)
    {
        this.mIconResId = iconResId;
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
     * check the menu item a catergory .
     * 
     * @return
     */
    public boolean isCategoryMarker()
    {
        return this.mCategoryMarker;
    }

    /**
     * set whatever the menu item a category or not.
     * 
     * @param categoryMarker
     */
    public void setCategoryMarker(final boolean categoryMarker)
    {
        this.mCategoryMarker = categoryMarker;
    }

}
