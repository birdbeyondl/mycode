/**
 * 
 */
package com.luo.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * @author birdbeyondl
 *
 */
public class MyReceiver extends BroadcastReceiver {

	/* (non-Javadoc)
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent)
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String msg = intent.getStringExtra("MSG");
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
		Log.i("tag", "ÒÑ¾­Toast");
	}

}
