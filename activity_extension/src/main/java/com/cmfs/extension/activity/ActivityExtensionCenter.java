package com.cmfs.extension.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.MotionEvent;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author cmfs
 */

public class ActivityExtensionCenter implements ActivityExtensionManager, ActivityExtensionHost {

    private static List<ActivityExtensionInterceptor> mInterceptorList = new ArrayList<>();

    @NonNull
    private List<ActivityExtension> mActivityExtensionList;
    private WeakReference<Activity> mHostWR;

    private ActivityExtensionCenter(@NonNull final Activity activity, int capacity) {
        mHostWR = new WeakReference<>(activity);
        mActivityExtensionList = new ArrayList<>(capacity);
        Collections.foreach(mInterceptorList, new Consumer<ActivityExtensionInterceptor>() {
            @Override
            public void apply(ActivityExtensionInterceptor interceptor) {
                interceptor.intercept(activity, mActivityExtensionList);
            }
        });
    }

    public static void addCommonInterceptor(@NonNull ActivityExtensionInterceptor interceptor) {
        mInterceptorList.add(interceptor);
    }

    public static void addCommonInterceptors(@NonNull List<ActivityExtensionInterceptor> interceptors) {
        mInterceptorList.addAll(interceptors);
    }

    public static void removeCommonInterceptor(@NonNull ActivityExtensionInterceptor interpolator) {
        mInterceptorList.remove(interpolator);
    }

    public static void removeCommonInterceptors(@NonNull List<ActivityExtensionInterceptor> interceptors) {
        mInterceptorList.removeAll(interceptors);
    }

    public static Iterator<ActivityExtensionInterceptor> commonInterceptorIterator() {
        return mInterceptorList.iterator();
    }

    public static ActivityExtensionCenter newInstance(Activity activity, int capacity) {
        return new ActivityExtensionCenter(activity, capacity);
    }

    public static ActivityExtensionCenter newInstance(Activity activity) {
        return new ActivityExtensionCenter(activity, 5);
    }

    public void applyInterceptor(@NonNull ActivityExtensionInterceptor interceptor) {
        Activity activity = getActivity();
        if (activity == null) {
            throw new IllegalStateException("Activity already destroyed");
        }
        interceptor.intercept(getActivity(), mActivityExtensionList);
    }

    @Override
    public int getExtensionSize() {
        return mActivityExtensionList.size();
    }

    @Override
    public boolean hasExtension() {
        return mActivityExtensionList.isEmpty();
    }

    @Override
    public boolean containExtension(ActivityExtension e) {
        return mActivityExtensionList.contains(e);
    }

    @Override
    public boolean addExtension(ActivityExtension e) {
        return mActivityExtensionList.add(e);
    }

    @Override
    public boolean addExtensions(Collection<? extends ActivityExtension> c) {
        return mActivityExtensionList.addAll(c);
    }

    @Override
    public boolean removeExtension(ActivityExtension e) {
        return mActivityExtensionList.remove(e);
    }

    @Override
    public Iterator<ActivityExtension> extensionIterator() {
        return mActivityExtensionList.iterator();
    }

    @Override
    public void clearExtensions() {
        mActivityExtensionList.clear();
    }

    public void onCreate(@Nullable final Bundle savedInstanceState) {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onCreate(savedInstanceState);
            }
        });
    }

    public void onPostCreate(@Nullable final Bundle savedInstanceState) {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onPostCreate(savedInstanceState);
            }
        });
    }

    public void onRestart() {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onRestart();
            }
        });
    }

    public void onStart() {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onStart();
            }
        });
    }

    public void onResume() {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onResume();
            }
        });
    }

    public void onPostResume() {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onPostResume();
            }
        });
    }

    public void onPause() {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onPause();
            }
        });
    }

    public void onStop() {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onStop();
            }
        });
    }

    public void onDestroy() {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onDestroy();
            }
        });
    }

    public void onRestoreInstanceState(final Bundle savedInstanceState) {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onRestoreInstanceState(savedInstanceState);
            }
        });
    }

    public void onSaveInstanceState(final Bundle outState) {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onSaveInstanceState(outState);
            }
        });
    }

    public void onAttachToWindow() {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onAttachToWindow();
            }
        });
    }

    public void onDetachedFromWindow() {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onDetachedFromWindow();
            }
        });
    }

    public void onNewIntent(final Intent intent) {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onNewIntent(intent);
            }
        });
    }

    public void onWindowFocusChanged(final boolean hasFocus) {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onWindowFocusChanged(hasFocus);
            }
        });
    }

    public void onConfigurationChanged(final Configuration newConfig) {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onConfigurationChanged(newConfig);
            }
        });
    }

    public void onUserInteraction() {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onUserInteraction();
            }
        });
    }

    public void onUserLeaveHint() {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onUserLeaveHint();
            }
        });
    }

    public void onLowMemory() {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onLowMemory();
            }
        });
    }

    public void onTrimMemory(final int level) {
        Collections.foreach(mActivityExtensionList, new Consumer<ActivityExtension>() {
            @Override
            public void apply(ActivityExtension activityExtension) {
                activityExtension.onTrimMemory(level);
            }
        });
    }

    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        return Collections.foreach(mActivityExtensionList, new Predicate<ActivityExtension>() {
            @Override
            public boolean apply(ActivityExtension activityExtension) {
                return activityExtension.onKeyDown(keyCode, event);
            }
        });
    }

    public boolean onKeyLongPress(final int keyCode, final KeyEvent event) {
        return Collections.foreach(mActivityExtensionList, new Predicate<ActivityExtension>() {
            @Override
            public boolean apply(ActivityExtension activityExtension) {
                return activityExtension.onKeyLongPress(keyCode, event);
            }
        });
    }

    public boolean onKeyUp(final int keyCode, final KeyEvent event) {
        return Collections.foreach(mActivityExtensionList, new Predicate<ActivityExtension>() {
            @Override
            public boolean apply(ActivityExtension activityExtension) {
                return activityExtension.onKeyUp(keyCode, event);
            }
        });
    }

    public boolean onKeyMultiple(final int keyCode, final int repeatCount, final KeyEvent event) {
        return Collections.foreach(mActivityExtensionList, new Predicate<ActivityExtension>() {
            @Override
            public boolean apply(ActivityExtension activityExtension) {
                return activityExtension.onKeyMultiple(keyCode, repeatCount, event);
            }
        });
    }

    public boolean onKeyShortcut(final int keyCode, final KeyEvent event) {
        return Collections.foreach(mActivityExtensionList, new Predicate<ActivityExtension>() {
            @Override
            public boolean apply(ActivityExtension activityExtension) {
                return activityExtension.onKeyShortcut(keyCode, event);
            }
        });
    }

    public boolean onTouchEvent(final MotionEvent event) {
        return Collections.foreach(mActivityExtensionList, new Predicate<ActivityExtension>() {
            @Override
            public boolean apply(ActivityExtension activityExtension) {
                return activityExtension.onTouchEvent(event);
            }
        });
    }

    public boolean onTrackballEvent(final MotionEvent event) {
        return Collections.foreach(mActivityExtensionList, new Predicate<ActivityExtension>() {
            @Override
            public boolean apply(ActivityExtension activityExtension) {
                return activityExtension.onTrackballEvent(event);
            }
        });
    }

    public boolean onGenericMotionEvent(final MotionEvent event) {
        return Collections.foreach(mActivityExtensionList, new Predicate<ActivityExtension>() {
            @Override
            public boolean apply(ActivityExtension activityExtension) {
                return activityExtension.onGenericMotionEvent(event);
            }
        });
    }

    @Override
    public WeakReference<Activity> getActivityWR() {
        return mHostWR;
    }

    @Nullable
    @Override
    public Activity getActivity() {
        return mHostWR.get();
    }

    @Override
    public boolean isRecycled() {
        return mHostWR.get() == null;
    }
}
