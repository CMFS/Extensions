package com.cmfs.extension.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author cmfs
 */

public class ExtensionAppCompatActivity extends AppCompatActivity implements ActivityExtensionManager {

    private ActivityExtensionCenter mActivityExtensionCenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mActivityExtensionCenter = ActivityExtensionCenter.newInstance(this);
        onCreateActivityExtensionCenter(mActivityExtensionCenter);
        super.onCreate(savedInstanceState);
        mActivityExtensionCenter.onCreate(savedInstanceState);
    }

    protected void onCreateActivityExtensionCenter(ActivityExtensionCenter center) {
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mActivityExtensionCenter.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActivityExtensionCenter.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mActivityExtensionCenter.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mActivityExtensionCenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mActivityExtensionCenter.onResume();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mActivityExtensionCenter.onPostResume();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mActivityExtensionCenter.onNewIntent(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mActivityExtensionCenter.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        mActivityExtensionCenter.onPause();
        super.onPause();
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        mActivityExtensionCenter.onUserInteraction();
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        mActivityExtensionCenter.onUserLeaveHint();
    }

    @Override
    protected void onStop() {
        mActivityExtensionCenter.onStop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mActivityExtensionCenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        mActivityExtensionCenter.onAttachToWindow();
    }

    @Override
    public void onDetachedFromWindow() {
        mActivityExtensionCenter.onDetachedFromWindow();
        super.onDetachedFromWindow();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        mActivityExtensionCenter.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActivityExtensionCenter.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        mActivityExtensionCenter.onLowMemory();
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        mActivityExtensionCenter.onTrimMemory(level);
        super.onTrimMemory(level);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return mActivityExtensionCenter.onKeyDown(keyCode, event)
                || super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return mActivityExtensionCenter.onKeyLongPress(keyCode, event)
                || super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return mActivityExtensionCenter.onKeyUp(keyCode, event)
                || super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return mActivityExtensionCenter.onKeyMultiple(keyCode, repeatCount, event)
                || super.onKeyMultiple(keyCode, repeatCount, event);
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        return mActivityExtensionCenter.onKeyShortcut(keyCode, event)
                || super.onKeyShortcut(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mActivityExtensionCenter.onTouchEvent(event)
                || super.onTouchEvent(event);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        return mActivityExtensionCenter.onTrackballEvent(event)
                || super.onTrackballEvent(event);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        return mActivityExtensionCenter.onGenericMotionEvent(event)
                || super.onGenericMotionEvent(event);
    }

    @Override
    public int getExtensionSize() {
        return mActivityExtensionCenter.getExtensionSize();
    }

    @Override
    public boolean hasExtension() {
        return mActivityExtensionCenter.hasExtension();
    }

    @Override
    public boolean containExtension(ActivityExtension e) {
        return mActivityExtensionCenter.containExtension(e);
    }

    @Override
    public boolean addExtension(ActivityExtension e) {
        return mActivityExtensionCenter.addExtension(e);
    }

    @Override
    public boolean addExtensions(Collection<? extends ActivityExtension> c) {
        return mActivityExtensionCenter.addExtensions(c);
    }

    @Override
    public boolean removeExtension(ActivityExtension e) {
        return mActivityExtensionCenter.removeExtension(e);
    }

    @Override
    public Iterator<ActivityExtension> extensionIterator() {
        return mActivityExtensionCenter.extensionIterator();
    }

    @Override
    public void clearExtensions() {
        mActivityExtensionCenter.clearExtensions();
    }
}
