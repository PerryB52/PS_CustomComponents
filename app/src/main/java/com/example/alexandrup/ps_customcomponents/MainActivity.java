package com.example.alexandrup.ps_customcomponents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.alexandrup.ps_customcomponents.CustomViews.VersionView;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_main, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i;

        switch(item.getItemId()){
            case R.id.menu_goToCompound:
                i = new Intent(MainActivity.this, Mod2CompoundControl.class);
                startActivity(i);
                break;

            case R.id.menu_goToOnDraw:
                i = new Intent(MainActivity.this, PS_OnDraw.class);
                startActivity(i);
                break;

            case R.id.menu_goToDispatch:
                i = new Intent(MainActivity.this, PS_dispatchDraw.class);
                startActivity(i);
                break;
        }

        return true;
    }
}
