package com.luo.alarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AlarmManagerActivity extends Activity {
	
	private Button mSetAlarm,mCancelAlarm;
	private static final String BC_Action = "com.luo.alarmmanager.action.BC_Action";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mSetAlarm = (Button) findViewById(R.id.set_alarm);
        mCancelAlarm = (Button) findViewById(R.id.cancel_alarm);
        
        final AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        
        Intent intent = new Intent();
        intent.setAction(BC_Action);
        intent.putExtra("MSG", "起床啦");
        
        final PendingIntent pintent = PendingIntent.getBroadcast(AlarmManagerActivity.this, 0, intent, 0);
        final long time = System.currentTimeMillis();
        mSetAlarm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				am.setRepeating(AlarmManager.RTC_WAKEUP, time, 1000, pintent);
				Log.i("Test", "已经点击");
			}
		});
        
        mCancelAlarm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				am.cancel(pintent);
				Log.i("Test", "取消");
			}
		});
    }
}