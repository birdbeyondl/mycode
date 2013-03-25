package com.luo.contact;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;

import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.Contacts.People;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ContactProviderActivity extends Activity {
	private EditText mUsername,mNotes;
	private Button mAdd;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mUsername = (EditText) findViewById(R.id.username);
        mNotes = (EditText) findViewById(R.id.user_notes);
        mAdd = (Button) findViewById(R.id.btnAddUser);
        mAdd.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String user = mUsername.getText().toString();
				String notes = mNotes.getText().toString();
				
				ContentResolver cr = getContentResolver();
				ContentValues cv = new ContentValues();
				Uri uri = Contacts.People.CONTENT_URI;
				
				cv.put(People.NAME, user);
				cv.put(People.NOTES, notes);
				cr.insert(uri, cv);
				Log.i("Test", "≤Â»Î≥…π¶");
				
			}
		});
    }
}