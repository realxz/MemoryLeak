package com.example.xiezhen.memoryleak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jumpToInnerThread(View view) {
        startActivity(new Intent(this, InnerThreadActivity.class));
    }

    public void jumpToAnonymousThread(View view) {
        startActivity(new Intent(this, AnonymousThreadActivity.class));
    }

    public void jumpToHandler(View view){
        startActivity(new Intent(this,HandlerActivity.class));
    }
    public void jumpToEventBus(View view){
        startActivity(new Intent(this,EventBusActivity.class));
    }
    public void jumpToContext(View view){
        startActivity(new Intent(this,ContextActivity.class));
    }

    public void jumpToReceiver(View view){
        startActivity(new Intent(this,BroadcastReceiverActivity.class));
    }

}
