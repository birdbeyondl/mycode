/**
 * 
 */
package com.luo.multitabview;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * @author birdbeyondl
 *
 */
public class BaiduBrowser extends Activity {
	WebView browser;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		browser = new WebView(this);
		setContentView(browser);
		browser.loadUrl("http://www.baidu.com");
	}

}
