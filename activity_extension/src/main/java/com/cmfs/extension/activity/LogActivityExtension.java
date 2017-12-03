package com.cmfs.extension.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.LogPrinter;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 * @author cmfs
 */

public final class LogActivityExtension extends SimpleActivityExtension {

    private LogPrinter mLogPrinter;
    private boolean mEnable;

    private LogActivityExtension(Activity activity, LogPrinter logPrinter, boolean enable) {
        super(activity);
        this.mLogPrinter = logPrinter;
        this.mEnable = enable;
    }

    public static LogActivityExtension newInstance(Activity activity, LogPrinter logPrinter, boolean enable) {
        return new LogActivityExtension(activity, logPrinter, enable);
    }

    public static LogActivityExtension newInstance(Activity activity, LogPrinter logPrinter) {
        return new LogActivityExtension(activity, logPrinter, true);
    }

    public static LogActivityExtension newInstance(Activity activity, String tag, boolean enable) {
        return new LogActivityExtension(activity, new AndroidLogPrinter(tag), enable);
    }

    public static LogActivityExtension newInstance(Activity activity, String tag) {
        return new LogActivityExtension(activity, new AndroidLogPrinter(tag), true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        println("onCreate: ");
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        println("onPostCreate: ");
    }

    @Override
    public void onRestart() {
        println("onRestart: ");
    }

    @Override
    public void onStart() {
        println("onStart: ");
    }

    @Override
    public void onResume() {
        println("onResume: ");
    }

    @Override
    public void onPostResume() {
        println("onPostResume: ");
    }

    @Override
    public void onPause() {
        println("onPause: ");
    }

    @Override
    public void onStop() {
        println("onStop: ");
    }

    @Override
    public void onDestroy() {
        println("onDestroy: ");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        println("onRestoreInstanceState: ");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        println("onSaveInstanceState: ");
    }

    @Override
    public void onAttachToWindow() {
        println("onAttachToWindow: ");
    }

    @Override
    public void onDetachedFromWindow() {
        println("onDetachedFromWindow: ");
    }

    @Override
    public void onNewIntent(Intent intent) {
        println("onNewIntent: ");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        println("onWindowFocusChanged: hasFocus = " + hasFocus);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        println("onConfigurationChanged: ");
    }

    @Override
    public void onUserInteraction() {
        println("onUserInteraction: ");
    }

    @Override
    public void onUserLeaveHint() {
        println("onUserLeaveHint: ");
    }

    @Override
    public void onLowMemory() {
        println("onLowMemory: ");
    }

    @Override
    public void onTrimMemory(int level) {
        println("onTrimMemory: level = " + level);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        println("onKeyDown: ");
        return false;
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        println("onKeyLongPress: ");
        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        println("onKeyUp: ");
        return false;
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        println("onKeyMultiple: ");
        return false;
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        println("onKeyShortcut: ");
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        println("onTouchEvent: ");
        return false;
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        println("onTrackballEvent: ");
        return false;
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        println("onGenericMotionEvent: ");
        return false;
    }

    private void println(String s) {
        if (mEnable) {
            mLogPrinter.println(s);
        }
    }

    static class AndroidLogPrinter extends LogPrinter {

        AndroidLogPrinter(String tag) {
            super(Log.DEBUG, tag);
        }
    }
}
