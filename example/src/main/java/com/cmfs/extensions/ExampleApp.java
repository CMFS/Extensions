package com.cmfs.extensions;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.NonNull;

import com.cmfs.extension.activity.ActivityExtension;
import com.cmfs.extension.activity.ActivityExtensionCenter;
import com.cmfs.extension.activity.ActivityExtensionInterceptor;
import com.cmfs.extension.activity.LogActivityExtension;

import java.util.List;

/**
 * @author cmfs
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActivityExtensionCenter.addCommonInterceptor(new ActivityExtensionInterceptor() {
            @Override
            public void intercept(@NonNull Activity activity, @NonNull List<ActivityExtension> activityExtensionList) {
                activityExtensionList.add(LogActivityExtension.newInstance(activity, "LogExtension"));
            }
        });
    }
}
