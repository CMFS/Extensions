package com.cmfs.extension.activity;

import android.app.Activity;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * @author cmfs
 */

public interface ActivityExtensionInterceptor {

    void intercept(@NonNull Activity activity, @NonNull List<ActivityExtension> activityExtensionList);
}
