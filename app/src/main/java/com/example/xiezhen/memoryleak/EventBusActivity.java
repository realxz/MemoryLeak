package com.example.xiezhen.memoryleak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        EventBus.getDefault().register(this);
        EventBusThread thread=new EventBusThread();
        thread.start();

    }

    public void closeActivity(View view) {
        this.finish();
    }

    private static class EventBusThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            EventBus.getDefault().post("eventbus");
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
