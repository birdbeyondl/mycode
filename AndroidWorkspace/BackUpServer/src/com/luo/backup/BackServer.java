package com.luo.backup;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BackServer {
	private int port = 9999;
	private ServerSocket mSerSoc;
	private DataInputStream mDIS;
	private DataOutputStream mDOS;
	private String savePath = "E:\\";
	private Socket socket;
	
	public void startServer() {
		int passedLenth = 0;
		long length = 0;
		int bufferSize = 8192;
		byte[] buf = new byte[bufferSize];
		
		try {
			mSerSoc = new ServerSocket(port);
			socket = mSerSoc.accept();
			mDIS = new DataInputStream(new BufferedInputStream(
					socket.getInputStream()));
		} catch (IOException e){
			e.printStackTrace();
		}
		
		try {
			savePath += mDIS.readUTF();
			length = mDIS.readLong();
			
		} catch ( IOException e){
			e.printStackTrace();
		}
		
		try {
			mDOS = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(savePath)));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		while(true){
			int read = 0;
			if(mDIS != null){
				try {
					read = mDIS.read(buf);
				} catch(IOException e){
					e.printStackTrace();
				}
			}
			
			passedLenth += read;
			
			if(read == -1){
				break;
			}
			
			System.out.println("文件接收了" + 
			(passedLenth * 100 / length) + "%\n");
			
			try{
				mDOS.write(buf, 0, read);
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		
		if(mDOS != null ){
			try{
				mDOS.close();
			} catch (IOException e){
				e.printStackTrace();
			}
			mDOS = null;
		}
		
		if(mDIS != null ){
			try{
				mDIS.close();
			} catch (IOException e){
				e.printStackTrace();
			}
			mDIS = null;
		}
		
		if(socket != null ){
			try{
				socket.close();
			} catch (IOException e){
				e.printStackTrace();
			}
			socket = null;
		}
		
		if(mSerSoc != null ){
			try{
				mSerSoc.close();
			} catch (IOException e){
				e.printStackTrace();
			}
			mSerSoc = null;
		}
		
		System.out.println("接收完成，文件另存为" + 
		savePath + "\n");
		
	}
	
	public static void main(String []args){
		BackServer back = new BackServer();
		back.startServer();
	}
}
