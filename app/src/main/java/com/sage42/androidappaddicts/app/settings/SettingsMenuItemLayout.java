package com.sage42.androidappaddicts.app.settings;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sage42.androidappaddicts.R;

@EViewGroup(R.layout.settings_menu_item)
public class SettingsMenuItemLayout extends RelativeLayout
{
    @ViewById(R.id.setting_menu_item_header)
    protected TextView mHeader;

    @ViewById(R.id.setting_menu_check_box)
    protected CheckBox mCheckBox;

    /**
     * Default constructor.
     * 
     * @param context
     */
    public SettingsMenuItemLayout(final Context context)
    {
        super(context);
    }

    /**
     * Bind the data to the UI.
     * 
     * @param data
     */
    public void renderItem(final SettingsMenuItem data)
    {
        // toggle between header and item display
        this.mHeader.setText(data.getTitleResId());
        if (data.isCheckable())
        {
            this.mCheckBox.setVisibility(View.VISIBLE);
        }
        else
        {
            this.mCheckBox.setVisibility(View.GONE);
        }
    }

}
