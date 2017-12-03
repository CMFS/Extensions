package com.cmfs.extension.activity;

import android.app.Activity;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * @author cmfs
 */

public interface ActivityExtensionHost {

    WeakReference<Activity> getActivityWR();

    @Nullable
    Activity getActivity();

    boolean isRecycled();
}
