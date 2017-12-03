package com.cmfs.extensions;

import android.os.Bundle;
import android.util.Log;

import com.cmfs.extension.activity.ActivityExtension;
import com.cmfs.extension.activity.ActivityExtensionCenter;
import com.cmfs.extension.activity.ExtensionAppCompatActivity;

import java.util.Iterator;

public class MainActivity extends ExtensionAppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: " + hashCode());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onCreateActivityExtensionCenter(ActivityExtensionCenter center) {
        Log.d(TAG, "onCreateActivityExtensionCenter: ");
        NetworkMonitorExtension monitorExtension = new NetworkMonitorExtension(this);
        center.addExtension(monitorExtension);

        Iterator<ActivityExtension> iterator = center.extensionIterator();
        Log.d(TAG, "onCreateActivityExtensionCenter: size = " + center.getExtensionSize());
        while (iterator.hasNext()) {
            ActivityExtension next = iterator.next();
            Log.d(TAG, "onCreateActivityExtensionCenter: " + next);
        }

        monitorExtension.add(new NetworkMonitorExtension.OnNetworkChangeListener() {
            @Override
            public void onNetworkConnectionChanged() {
                Log.d(TAG, "onNetworkConnectionChanged: ");
            }
        });
    }
}
