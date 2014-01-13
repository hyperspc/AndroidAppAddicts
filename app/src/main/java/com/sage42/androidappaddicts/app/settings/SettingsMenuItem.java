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
