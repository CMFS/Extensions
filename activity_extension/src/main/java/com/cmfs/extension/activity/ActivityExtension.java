package com.cmfs.extension.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 * {@link android.app.Activity}插件接口
 *
 * @author cmfs
 */

public interface ActivityExtension {

    void onCreate(@Nullable Bundle savedInstanceState);

    void onPostCreate(@Nullable Bundle savedInstanceState);

    void onRestart();

    void onStart();

    void onResume();

    void onPostResume();

    void onPause();

    void onStop();

    void onDestroy();

    void onRestoreInstanceState(Bundle savedInstanceState);

    void onSaveInstanceState(Bundle outState);

    void onNewIntent(Intent intent);

    void onAttachToWindow();

    void onDetachedFromWindow();

    void onWindowFocusChanged(boolean hasFocus);

    void onConfigurationChanged(Configuration newConfig);

    void onUserInteraction();

    void onUserLeaveHint();

    void onLowMemory();

    void onTrimMemory(int level);

    boolean onKeyDown(int keyCode, KeyEvent event);

    boolean onKeyLongPress(int keyCode, KeyEvent event);

    boolean onKeyUp(int keyCode, KeyEvent event);

    boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event);

    boolean onKeyShortcut(int keyCode, KeyEvent event);

    boolean onTouchEvent(MotionEvent event);

    boolean onTrackballEvent(MotionEvent event);

    boolean onGenericMotionEvent(MotionEvent event);
}
