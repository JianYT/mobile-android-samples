package com.carto.advancedmap.baseactivities;

import android.app.Activity;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

/**
 * Created by aareundo on 20/09/16.
 */
public class BaseActivity extends Activity {

    protected static final int MARSHMALLOW = 23;

    protected  boolean isMarshmallow() {
        return Build.VERSION.SDK_INT >= MARSHMALLOW;
    }

    protected void requestPermission(String permission) {
        ActivityCompat.requestPermissions(this, new String[]{ permission }, 1);
    }

    protected void alert(final String message)
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BaseActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
