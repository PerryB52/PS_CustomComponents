package com.example.alexandrup.ps_customcomponents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        VersionView view = new VersionView(this);

        setContentView(view);

        //setContentView(R.layout.activity_main);

//        TextView txtView = (TextView) findViewById(R.id.ma_txtview);
//
//        try {
//            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
//            txtView.setText(packageInfo.versionName);
//
//        } catch (PackageManager.NameNotFoundException e) {
//            Log.v("catch ERR: ", e.getMessage());
//        }

    }
}
