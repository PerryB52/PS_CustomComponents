package com.example.alexandrup.ps_customcomponents;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by alexandrup on 1/24/2017.
 */

public class VersionView extends TextView {


    public VersionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setVersion();
    }

    public VersionView(Context context) {
        super(context);
        setVersion();
    }

    public VersionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setVersion();
    }

    private void setVersion(){
        try {
            PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
            setText(packageInfo.versionName);

        } catch (PackageManager.NameNotFoundException e) {
            Log.v("catch ERR: ", e.getMessage());
        }

    }
}
