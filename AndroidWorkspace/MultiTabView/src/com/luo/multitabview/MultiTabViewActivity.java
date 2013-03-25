package com.luo.multitabview;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class MultiTabViewActivity extends TabActivity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
        
        TabHost host = getTabHost();
        host.addTab(host.newTabSpec("one")
        		.setIndicator("Ã‘±¶")
        		.setContent(new Intent(this,BocBrowser.class)));
        host.addTab(host.newTabSpec("two")
        		.setIndicator("∞Ÿ∂»")
        		.setContent(new Intent(this,BaiduBrowser.class)));
        	
    }
}