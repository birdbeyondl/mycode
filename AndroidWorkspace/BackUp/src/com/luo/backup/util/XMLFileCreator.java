package com.luo.backup.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.xmlpull.v1.XmlSerializer;

import android.content.Context;
import android.util.Xml;

public class XMLFileCreator {
	private Context mCtx;
	private File xmlfile;
	
	public XMLFileCreator(Context context){
		this.mCtx = context;
		xmlfile = null;
	}
	
	/**
	 * 創建XML文件
	 */
	public void createXMLFile(){
		FileHelper helper = new FileHelper(mCtx);
		String backpath = "contacts.xml";
		try {
			xmlfile = helper.createFile(backpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 想XML文件寫入數據
	 * @return
	 */
	public int writeData(){
		if(xmlfile == null)
			return -1;
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(xmlfile);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		XmlSerializer serializer = Xml.newSerializer();
		try{
			serializer.setOutput(fos,"UTF-8");
			serializer.startDocument(null, true);
			serializer.startTag(null, "users");
			for(int i = 0; i < 3; i++){
				serializer.startTag(null, "user");
				serializer.startTag(null, "name");
				serializer.text("Dillan " + i);
				serializer.endTag(null, "name");
				serializer.startTag(null, "Phone");
				serializer.text("18317140243" + i);
				serializer.endTag(null, "Phone");
				serializer.endTag(null, "user");
				
			}
			serializer.endTag(null, "users");
			serializer.endDocument();
			serializer.flush();
			fos.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
}
