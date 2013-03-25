package com.luo.eventtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class EventTestActivity extends Activity {
	
	private EditText mEditUser,mEditPassword;
	private CheckBox mAutoLogin;
	private Button mLogin,mCancel;
	
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mEditUser = (EditText) findViewById(R.id.edittext_username);
        mEditPassword = (EditText) findViewById(R.id.edittext_pass);
        mAutoLogin = (CheckBox) findViewById(R.id.checkbox_autologin);
        mLogin = (Button) findViewById(R.id.btn_login);
        mCancel = (Button) findViewById(R.id.btn_cancel);
        
        mEditUser.setOnKeyListener(new OnKeyListener(){

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				mEditUser.setText("");
				return false;
			}
        	
        });
        
        mEditPassword.setOnKeyListener(new OnKeyListener(){

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				mEditPassword.setText("");
				return false;
			}
        	
        });
        
        mEditUser.setOnFocusChangeListener(new OnFocusChangeListener(){

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				Toast.makeText(getApplicationContext(), mEditUser.getText(), Toast.LENGTH_LONG)
					.show();
			}
        });
        
        mAutoLogin.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Toast.makeText(getApplicationContext(), mAutoLogin.isChecked()+"", Toast.LENGTH_LONG)
					.show();	
			}
		});
        
        
    }
}