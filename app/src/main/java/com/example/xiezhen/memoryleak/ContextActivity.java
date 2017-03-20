package com.example.xiezhen.memoryleak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContextActivity extends AppCompatActivity {

    private TextView tvVersionName;
    private TextView tvVersionCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context);
        tvVersionName = (TextView) findViewById(R.id.tv_version_name);
        tvVersionCode = (TextView) findViewById(R.id.tv_version_code);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setVersionCode(CommonHelper.getCommonHelper(this).getVersionCode());
        setVersionName(CommonHelper.getCommonHelper(this).getVersionName());
    }

    private void setVersionName(String versionName) {
        tvVersionName.setText(versionName);
    }

    private void setVersionCode(int versionCode) {
        tvVersionCode.setText(String.valueOf(versionCode));
    }

    public void closeActivity(View view) {
        this.finish();
    }

}
