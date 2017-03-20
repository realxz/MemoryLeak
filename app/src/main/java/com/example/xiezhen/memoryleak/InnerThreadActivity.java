package com.example.xiezhen.memoryleak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InnerThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_thread);

        RunningThread runningThread = new RunningThread();
        runningThread.start();
    }

    class RunningThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000*5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void closeActivity(View view) {
        this.finish();
    }

}
