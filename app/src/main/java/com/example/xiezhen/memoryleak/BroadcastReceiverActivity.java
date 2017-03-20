package com.example.xiezhen.memoryleak;

import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BroadcastReceiverActivity extends AppCompatActivity {
    NetworkReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
        wifiListener();
    }

    private void wifiListener() {
        IntentFilter intentFilter = new IntentFilter();
        //添加的action就是我们要监听的广播，wifi开关的时候，系统都会发送这条广播。
        intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        receiver = new NetworkReceiver();
        //通过registerReceiver方法，将我们创建的Receiver以及 InterFilter传入，完成注册。
        this.registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(receiver);
    }

    public void closeActivity(View view) {
        this.finish();
    }
}
