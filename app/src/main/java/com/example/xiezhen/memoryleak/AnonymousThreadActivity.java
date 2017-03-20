package com.example.xiezhen.memoryleak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AnonymousThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anonymous_thread);
        Thread anonymousThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    //do something
                    try {
                        Thread.sleep(60 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return;
                }
            }
        };
        anonymousThread.start();
    }

    public void closeActivity(View view) {
        this.finish();
    }
}
