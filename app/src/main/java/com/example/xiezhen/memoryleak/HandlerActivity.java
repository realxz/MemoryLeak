package com.example.xiezhen.memoryleak;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class HandlerActivity extends AppCompatActivity {
    private TextView tvShowMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        tvShowMessage = (TextView) findViewById(R.id.tv_show_message);
        MemoryLeakHandler handler = new MemoryLeakHandler();
        handler.sendMessageDelayed(Message.obtain(), 1000 * 10);
    }

    private class MemoryLeakHandler extends Handler {


        @Override
        public void handleMessage(Message msg) {
            tvShowMessage.setText("MemoryLeak");
            Toast.makeText(HandlerActivity.this, "memory leak", Toast.LENGTH_SHORT).show();
        }
    }


    public void closeActivity(View view) {
        this.finish();
    }
}
