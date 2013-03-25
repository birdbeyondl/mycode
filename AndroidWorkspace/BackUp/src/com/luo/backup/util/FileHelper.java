package com.luo.backup.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.content.Context;
import android.os.Environment;

/**
 * @author Dillan.Luo
 *
 */
public class FileHelper {
	private Context context;
	private boolean hasSD = false;
	private String SDPath;
	private String FilesPath;
	
	public FileHelper(Context context){
		this.context = context;
		hasSD = Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED);
		SDPath = Environment.getExternalStorageDirectory().getPath();
		FilesPath = this.context.getFilesDir().getPath();
	}

	public File createFile(String fileName) throws IOException{
		File file = new File(SDPath + File.separator + fileName);
		if(!file.exists()){
			file.createNewFile();
		}
		return file;
	}
	
	
	
	public String readFile(String fileName) {
		StringBuffer sb = new StringBuffer();
		File file = new File(SDPath + File.separator + fileName);
		try{
			FileInputStream fis = new FileInputStream(file);
			int c;
			while((c = fis.read()) != -1){
				sb.append((char) c);
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public boolean isHasSD() {
		return hasSD;
	}

	public String getSDPath() {
		return SDPath;
	}

	public String getFilesPath() {
		return FilesPath;
	}
	
	
}
