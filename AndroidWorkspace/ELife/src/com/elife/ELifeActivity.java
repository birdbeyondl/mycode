package com.elife;

import com.phonegap.DroidGap;

import android.os.Bundle;

public class ELifeActivity extends DroidGap {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");
       // setContentView(R.layout.main);
    }
}