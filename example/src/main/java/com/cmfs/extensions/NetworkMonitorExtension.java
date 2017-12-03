package com.cmfs.extensions;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cmfs.extension.activity.SimpleActivityExtension;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cmfs
 */

public class NetworkMonitorExtension extends SimpleActivityExtension {

    private NetworkStateChangeReceiver mNetworkStateChangeReceiver;
    private IntentFilter mIntentFilter;

    public NetworkMonitorExtension(Activity activity) {
        super(activity);
        mNetworkStateChangeReceiver = new NetworkStateChangeReceiver(new ListenerProxy());
        mIntentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
    }

    public void add(OnNetworkChangeListener listener) {
        mNetworkStateChangeReceiver.addListener(listener);
    }

    public void remove(OnNetworkChangeListener listener) {
        mNetworkStateChangeReceiver.removeListener(listener);
    }

    @Override
    public void onResume() {
        //noinspection ConstantConditions
        getActivity().registerReceiver(mNetworkStateChangeReceiver, mIntentFilter);
    }

    @Override
    public void onPause() {
        //noinspection ConstantConditions
        getActivity().unregisterReceiver(mNetworkStateChangeReceiver);
    }

    public interface OnNetworkChangeListener {
        void onNetworkConnectionChanged();
    }

    static class NetworkStateChangeReceiver extends BroadcastReceiver {

        private WeakReference<ListenerProxy> listenerWR;

        public NetworkStateChangeReceiver(ListenerProxy listener) {
            listenerWR = new WeakReference<>(listener);
        }

        public void addListener(OnNetworkChangeListener listener) {
            ListenerProxy listenerProxy = listenerWR.get();
            if (listenerProxy == null) {
                return;
            }
            listenerProxy.addListener(listener);
        }

        public void removeListener(OnNetworkChangeListener listener) {
            ListenerProxy listenerProxy = listenerWR.get();
            if (listenerProxy == null) {
                return;
            }
            listenerProxy.removeListener(listener);
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            ListenerProxy listenerProxy = listenerWR.get();
            if (listenerProxy == null) {
                return;
            }
            String action = intent.getAction();
            Log.d("NetworkMonitorExtension", "onReceive: " + action);
            listenerProxy.onNetworkConnectionChanged();
        }
    }

    static final class ListenerProxy implements OnNetworkChangeListener {

        private List<OnNetworkChangeListener> mListeners;

        ListenerProxy() {
            mListeners = new ArrayList<>();
        }

        void addListener(OnNetworkChangeListener listener) {
            mListeners.add(listener);
        }

        void removeListener(OnNetworkChangeListener listener) {
            mListeners.remove(listener);
        }

        @Override
        public void onNetworkConnectionChanged() {
            for (OnNetworkChangeListener listener : mListeners) {
                listener.onNetworkConnectionChanged();
            }
        }
    }

}
