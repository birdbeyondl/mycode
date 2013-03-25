package com.luo.backup;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.luo.backup.util.FileHelper;
import com.luo.backup.util.XMLFileCreator;

import android.os.Bundle;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class BackUp extends Activity {
	
	private Socket mSocket;
	private String mIP = "10.0.2.2";
	private int mPort = 9999;
	private DataInputStream mDIS;
	private DataOutputStream mDOS;
	private Button mBtnUpLoad;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        mBtnUpLoad = (Button) findViewById(R.id.file_upload);
        Log.i("test", mBtnUpLoad.toString());
        mBtnUpLoad.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				new Thread(){
					public void run(){
						XMLFileCreator newxmlFile = new XMLFileCreator(BackUp.this);
						newxmlFile.createXMLFile();
						newxmlFile.writeData();
						startUpLoad("contacts.xml");
					}
				}.start();
				
			}});
    }

   
	private void startUpLoad(String path){
    	FileHelper helper = new FileHelper(getApplicationContext());
    	String filePath = helper.getSDPath() + File.separator + path;
    	File file = new File(filePath);
    	try{
    		mSocket = new Socket(mIP,mPort);
    		mDIS = new DataInputStream(new BufferedInputStream(
    				new FileInputStream(filePath)));
    		mDOS = new DataOutputStream(mSocket.getOutputStream());
    	} catch (UnknownHostException e){
    		e.printStackTrace();
    	} catch (IOException e){
    		e.printStackTrace();
    	} 
    	
    	try {
    		mDOS.writeUTF(file.getName());
    		mDOS.flush();
    		mDOS.writeLong((long)file.length());
    		mDOS.flush();
    	} catch (IOException e){
    		e.printStackTrace();
    	}
    	
    	int bufSize = 8192;
    	byte[] buf = new byte[bufSize];
    	
    	while(true) {
    		int read = 0;
    		if(mDIS != null ){
    			try{
    				read = mDIS.read(buf);
    			} catch(IOException e){
    				e.printStackTrace();
    			}
    		}
    		if(read == -1){
    			break;
    		}
    		
    		try {
    			mDOS.write(buf, 0, read);
    			mDOS.flush();
    		} catch (IOException e){
    			e.printStackTrace();
    		}
    	}
    	
    	try{
    		mDIS.close();
    		mDOS.close();
    		mSocket.close();
    	} catch (IOException e){
    		e.printStackTrace();
    	}
    }
    


    
    
    public void testOrg(){
    	
    }

}
