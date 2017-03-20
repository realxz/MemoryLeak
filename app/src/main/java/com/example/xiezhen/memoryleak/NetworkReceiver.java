package com.example.xiezhen.memoryleak;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

/**
 * Created by xiezhen on 2017/3/16.
 */

public class NetworkReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(action)) {
            NetworkInfo networkInfo = intent.getParcelableExtra(
                    WifiManager.EXTRA_NETWORK_INFO);
            //判断当前wifi连接状态
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.DISCONNECTED) {
                Log.d("xiezhen", "DISCONNECTED");
            } else if (state == NetworkInfo.State.CONNECTING) {
                Log.d("xiezhen", "CONNECTING");
            } else if (state == NetworkInfo.State.CONNECTED) {
                Log.d("xiezhen", "CONNECTED");
            }
        }
    }
}
