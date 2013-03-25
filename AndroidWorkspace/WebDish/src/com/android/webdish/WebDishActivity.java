package com.android.webdish;

import org.apache.cordova.DroidGap;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class WebDishActivity extends DroidGap {
	final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
	private final String server_phone="07138413965";
	BroadcastReceiver SMSbr = new BroadcastReceiver() {
	        @Override
	        public void onReceive(Context context, Intent intent) {
	                // Called every time a new sms is received
	                Bundle bundle = intent.getExtras();
	                if (bundle != null) {
	                        // This will put every new message into a array of
	                        // SmsMessages. The message is received as a pdu,
	                        // and needs to be converted to a SmsMessage, if you want to
	                        // get information about the message.
	                        Object[] pdus = (Object[]) bundle.get("pdus");
	                        final SmsMessage[] messages = new SmsMessage[pdus.length];
	                        for (int i = 0; i < pdus.length; i++)
	                                messages[i] = SmsMessage
	                                                .createFromPdu((byte[]) pdus[i]);
	                        if (messages.length > -1) {
	                                // Shows a Toast with the phone number of the sender,
	                                // and the message.
	                        	/*
	                                String smsToast = "New SMS received from "
	                                                + messages[0].getOriginatingAddress() + "\n'"
	                                                + messages[0].getMessageBody() + "'";
	                              //  Toast.makeText(context, smsToast, Toast.LENGTH_LONG).show();
	                               */
	                        	   //Toast.makeText(context, messages[0].getMessageBody(), Toast.LENGTH_LONG).show();
	                               if(messages[0].getOriginatingAddress().startsWith("0713"))
	                               {
	                            	    sendmsg(messages[0].getMessageBody());
	                               }
	                        }  
	                }
	        }
	};

private void sendmsg(String msg){
	msg=msg.replaceAll("\n\r","");
	msg=msg.replaceAll("\n","");
	msg=msg.replaceAll("'","");
	
	this.sendJavascript("window.onCallReceived('"+msg+"');"); 
}

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    	// The BroadcastReceiver needs to be registered before use.
    	IntentFilter SMSfilter = new IntentFilter(SMS_RECEIVED);
    	this.registerReceiver(SMSbr, SMSfilter); 
        //tContentView(R.layout.main);
        //
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //super.loadUrlTimeoutValue(60000);
        super.setIntegerProperty("loadUrlTimeoutValue", 60000);
        super.setIntegerProperty("splashscreen", R.drawable.logo);
        //super.loadUrl("http://www.0713.me/mobile/mobile_search.php?ac=index");
        super.loadUrl("file:///android_asset/www/main.html");
        //super.loadUrl("http://122.205.129.39:8081/0713.me/trunk/home/mobile_search.php?ac=index");
        
      //自动识别SIM类型
       
        TelephonyManager sim = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String simID = sim.getSubscriberId();
        
        //根据SIM卡类型,如果不是电信自动退出
//       if(!simID.startsWith("46003"))
//        {
//        	Toast toast=Toast.makeText(this, "请使用电信SIM卡"+simID, Toast.LENGTH_LONG);
//        	toast.show();
//        	this.finish();
//        }

    }
 // 点击Menu时，系统调用当前Activity的onCreateOptionsMenu方法，并传一个实现了一个Menu接口的menu对象供你使用
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            menu.add(Menu.NONE, Menu.FIRST , 1, "退出").setIcon(
                    android.R.drawable.ic_menu_close_clear_cancel);
            // setIcon()方法为菜单设置图标，这里使用的是系统自带的图标，同学们留意一下,以
            // android.R开头的资源是系统提供的，我们自己提供的资源是以R开头的
            menu.add(Menu.NONE, Menu.FIRST + 1, 2, "关于").setIcon(
                    android.R.drawable.ic_menu_info_details);
            // return true才会起作用
            return true;
        }
      //菜单项被选择事件
            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                case Menu.FIRST:
                	//退出程序
                	showTips();
                    break;
                case Menu.FIRST+1:
                	break;
                }
                return false;
            }
      //提示是否退出
            private void showTips(){

            	AlertDialog alertDialog = new AlertDialog.Builder(this)

            	.setTitle("退出程序")

            	.setMessage("是否退出程序")

            	.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            	public void onClick(DialogInterface dialog, int which){
                    finish();
                    System.exit(0);
            	}

            	}).setNegativeButton("取消",

            	new DialogInterface.OnClickListener() {

            	public void onClick(DialogInterface dialog, int which){

            	return;

            	}}).create();  //创建对话框

            	alertDialog.show(); // 显示对话框

            	}
}