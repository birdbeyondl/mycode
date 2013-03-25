import java.awt.Graphics;
import java.awt.Font;
import java.util.ArrayList;
import java.io.IOException;
import java.util.*;
public class InterControl extends Thread{
	MainFrame mf;
	private frames msg;
	private frames msg1;
	Host node[]=new Host[2];
	boolean start1;
	String add0="127.0.0.1";
	String add1="127.0.0.2";
	String add2="127.0.0.3";
	String add3="127.0.0.4";
	public ArrayList sharemessagequeue=new ArrayList();
	public ArrayList messagequeue[]=new ArrayList[3];
	public Router route[]=new Router[2];
	
	public void run()
	{
		
		msg=new frames();
		if(mf.choose==1)
		{
			mf.text1.setText("");
		    mf.text2.setText("");
		    
		    initframes(1,msg);
	        msg.x=1;
		    node[0]=new Host(msg,sharemessagequeue,add0,1);
		    node[0].outqueue.add(msg);
		    System.out.println("PC1可以向PC2发送数据：");
		    mf.text1.append("发送数据\n");
	        mf.text1.append("目的IP：127.0.0.2\n" );
	        mf.text1.append("目的端口：4\n" );
	        mf.text2.append("主机IP：127.0.0.1\n");
	        mf.text2.append("端口port[4]==-1\n");
	        
		   
		    Datamove dm=new Datamove(mf,mf.width/15+70,mf.width/2+30,mf.height/5+10);
	        dm.movex();
	        
	        node[0].run();
		    
	
		    node[1]=new Host(msg,sharemessagequeue,add1,-1);
		    if(!sharemessagequeue.isEmpty()){
		    	frames temp=(frames)sharemessagequeue.get(0);
		    	node[1].inqueue.add(temp);
		        node[1].run();
		        mf.text1.setText("");
		        mf.text1.append("主机IP:127.0.0.1\n");
		        mf.text2.setText("");
		        mf.text2.append("端口不可用\n" );
		        mf.text2.append("发回端口不可达报文\n" );
		        System.out.println("向PC1发回端口不可达报文");
		        initframes(2,msg);
		        msg.x=2;
		        node[1].outqueue.add(msg);
		        node[1].run();
		       
		        try{
		        	Thread.sleep(1000);
		        }catch(Exception e){
		        	e.printStackTrace();
		        }
		        mf.text2.setText("");		        
		        mf.text2.append("发送端口不可达报文\n");
		        mf.text2.append("目的IP:127.0.0.1\n");
		        
		        Datamove dm1=new Datamove(mf,mf.width/15+70,mf.width/2+30,mf.height/5+10);
		        dm1.movey();
		        if(!sharemessagequeue.isEmpty())
		        {
		        	frames temp1=(frames)sharemessagequeue.get(0);
			        node[0].inqueue.add(temp1);
			        node[0].run();
			        mf.text1.setText("");
			        mf.text1.append("IP正确\n");
			        mf.text1.append("检验和正确\n");
			        mf.text1.append("接受报文\n");
			
		        }
		
		
		    }
		    
		
		}
		else if(mf.choose==2)
		{
		    mf.text1.setText("");
		    mf.text2.setText("");
			initframes(3,msg);
			msg.x=3;
			
			node[0]=new Host(msg,sharemessagequeue,add0,1);
		    node[0].outqueue.add(msg);
		    node[0].run();
		    mf.text1.append("发送ICMP请求报文\n");
	        mf.text1.append("目的IP：127.0.0.2\n" );
	        
	        mf.text2.append("主机IP：127.0.0.1\n");
	       
		    
		    
		    try{
				Thread.sleep(1000);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    Datamove dm=new Datamove(mf,mf.width/15+70,mf.width/2+30,mf.height/5+10);
		    dm.movex();	
		    
		    node[1]=new Host(msg,sharemessagequeue,add1,-1);
		    if(!sharemessagequeue.isEmpty()){
		    	frames temp=(frames)sharemessagequeue.get(0);
		        node[1].inqueue.add(temp);
		        node[1].run();
		        mf.text1.setText("");
		        mf.text1.append("主机IP:127.0.0.1\n");
		        mf.text2.setText("");
		        mf.text2.append("ICMP类型：08\n" );
		        mf.text2.append("ICMP代码: 00\n");
		        mf.text2.append("接受到请求报文\n" );
		        try{
		        	Thread.sleep(1000);
		        	
		        }catch(Exception e){
		        	e.printStackTrace();
		        }
		        
		        initframes(4,msg);
		        msg.x=4;
		        node[1].outqueue.add(msg);
		        node[1].run();
		   //     mf.text1.setText("");
		     //   mf.text1.append("主机IP:127.0.0.1\n");
		        mf.text2.setText("");
		        mf.text2.append("发送ICMP应答报文\n" );
		        mf.text2.append("目的IP: 127.0.0.1\n" );
		        try{
					Thread.sleep(1000);
				}
			    catch(Exception e){
					e.printStackTrace();
				}
		        Datamove dm1=new Datamove(mf,mf.width/15+70,mf.width/2+30,mf.height/5+10);
		        dm1.movey();
		        if(!sharemessagequeue.isEmpty())
		        {
		        	frames temp2=(frames)sharemessagequeue.get(0);
		        	node[0]=new Host(msg,sharemessagequeue,add0,1);
			        node[0].inqueue.add(temp2);
			        node[0].run();
			        mf.text1.setText("");
			        mf.text1.append("IP正确\n");
			        mf.text1.append("校验和正确\n");
			        mf.text1.append("接受该数据报文\n");
			       
			
		        }
			
		    }
		}
		else if (mf.choose==3)
		{
			mf.router1.setText("");
		    mf.router2.setText("");
		    mf.pc1.setText("");
		    mf.pc1.setText("");
			
			Host node[] =new Host[2];			
			msg1=new frames();
			initframes(5,msg1);
			
			messagequeue[0]=new ArrayList();
			messagequeue[1]=new ArrayList();
			messagequeue[2]=new ArrayList();
			route[0]=new Router(messagequeue[0],messagequeue[1],add2);
		//	route[0].run();
			
			route[1]=new Router(messagequeue[1],messagequeue[2],add3);
			//route[1].start();
			
			node[0]=new Host(msg1,messagequeue[0],add0,-1);
			node[1]=new Host(msg1,messagequeue[2],add1,-1);
		    for (int i=1;i<=3;i++)
		    {	
		    	mf.router1.setText("");
			    mf.router2.setText("");
		    	System.out.println("PC1向PC2发送IP数据报(TTL="+i+")");
		    	try{
					Thread.sleep(1000);
				}
			    catch(Exception e){
					e.printStackTrace();
					
				}
			    //System.out.println("发送第"+i+"条数据报文");
		    	String temp=Integer.toHexString(i);
		    	 {
		    		StringBuffer s2=new StringBuffer();		    	
				    s2.append(temp);
				    if(temp.length()<2)
				    {
					    for(int j=0;j<2-temp.length();j++)
						    s2.insert(0, "0");
				    }
							
				    String s3;	
				    s3=s2.substring(0,s2.length());
		    	 
		    	msg1.IPPackage.replace(16, 18, s3);
		    	 }//改变ttl的值  并第一位加0；
		    	 msg1.x=5;
		    	
			    node[0].outqueue.add(msg1);
			    node[0].run();
			    mf.pc1.setText("");
		        mf.pc1.append("发送第" +i+"个报文\n");
		        mf.pc1.append("报文TTL:"+i+"\n");
		        mf.pc1.append("目的端口: 4\n");
		        mf.pc1.append("目的IP：127.0.0.2\n");
		        mf.pc2.setText("");
		        mf.pc2.append("主机IP： 127.0.0.2\n" );
		        mf.pc2.append("端口4不可用\n");
		        mf.router1.append("IP：127.0.0.4");
		        mf.router2.append("IP：127.0.0.3");
		        //mf.pc2.append("接受到请求报文\n" );
			    Datamove dm=new Datamove(mf,mf.width/15+70,mf.width/2+30,mf.height/5+10);
			    dm.move1();	
			   // dm.move2();
			    route[0].run();
			    
			    if(!messagequeue[1].isEmpty())
			    	dm.move3();
			    route[1].run();
			   
			    
			    if(!messagequeue[2].isEmpty()) {
			    	dm.move5();
			    	System.out.println("向PC1发回端口不可达报文");
			    node[1].inqueue.add(msg1);
			    node[1].run();
			    mf.pc2.setText("");
		        mf.pc2.append("端口4不可用\n" );
		        mf.pc2.append("发回端口不可达报文\n");
			    dm.move6();
			    dm.move4();
			    dm.move2();
			    initframes(2,msg1);
		        msg1.x=2;
		        node[1].outqueue.add(msg1);
		        node[1].run();
		        route[1].run1();
		        route[0].run1();
		        if(!messagequeue[0].isEmpty()){
		        	//System.out.println("000000");
		        	
		        	node[0].inqueue.add(msg1);
		        	msg1.x=2;
		        	node[0].run();
		        }
			    }
			    
			    
			  //  Datamove dm=new Datamove(mf,mf.width/15+70,mf.width/2+30,mf.height/5+150);
			    //dm.movex();
			    if(i==1)
			    {
			    	//System.out.println("PC1接收到TTL超时报文");
			    	
			    	initframes(6,msg1);
			    	route[0].send0(msg1);
			    	mf.router2.setText("");
			        mf.router2.append("报文TTL为1\n");
			        mf.router2.append("发回TTL超时报文");
			        try{
			        	Thread.sleep(500);
			        	
			        }catch(Exception e){
			        	e.printStackTrace();
			        }
			        mf.router2.setText("");
			        mf.router1.append("IP：127.0.0.3");
			        
			       
			    	dm.move2();
			    	messagequeue[0].remove(0);
			    	node[0].inqueue.add(msg1);
			    	msg1.x=6;
			    	node[0].run();
			    	mf.pc1.setText("");
			    	mf.pc1.append("IP正确" );
				    mf.pc1.append("校验和正确 \n");
				    mf.pc1.append("接受到超时报文\n" );
				    try{
				    	Thread.sleep(500);				    	
				    }catch(Exception e){
				    	e.printStackTrace();
				    }
			    	
			    }
			    if(i==2)
			    {
			    	//dm.move3();
			    	msg1.ttl=2;
			    	route[1].send0(msg1);
			    	mf.router1.setText("");
			        mf.router1.append("报文TTL为1\n");
			        mf.router1.append("发回TTL超时报文");
			        try{
			        	Thread.sleep(500);
			        	
			        }catch(Exception e){
			        	e.printStackTrace();
			        }
			        mf.router1.setText("");
			        mf.router1.append("IP：127.0.0.4");
			    	dm.move4();
			    	dm.move2();
			    	//messagequeue[1].remove(0);
			    	route[0].run1();
			    	if(!messagequeue[0].isEmpty()){
			    		node[0].inqueue.add(msg1);
			    		msg1.x=6;
			    		node[0].run();
			    		mf.pc1.setText("");
				    	mf.pc1.append("IP正确" );
					    mf.pc1.append("校验和正确 \n");
					    mf.pc1.append("接受到超时报文\n" );
					    try{
					    	Thread.sleep(500);				    	
					    }catch(Exception e){
					    	e.printStackTrace();
					    }
			    		
			    	}
			    	
			    }
			    
			    System.out.println("-------------------------------------------------------------------------------");
		    }
		  
		   
		    	
		}
		
		
	}
	public InterControl(MainFrame mf)
	{
		this.mf=mf;
		
	}
	public void initframes(int x,frames m)//初始化数据帧
	{
		if(x==1)
		{
			m.IPPackage.replace(18, 20, "11");
			m.IPPackage.replace(20, 24, m.GetCheck(m.IPPackage.substring(0,40)));
			m.IPPackage.replace(52, 56, m.GetCheck(m.IPPackage.substring(40, 60)));
		}	
		if(x==2)
		{
			m.portfail.replace(18, 20, "01");	
			//m.portfail.replace(20, 24, m.GetCheck(m.IPPackage.substring(0,40)));
			m.portfail.append(m.IPPackage.substring(0, 56));
			
			{	String s1=Integer.toHexString(m.portfail.length()/2);
			    StringBuffer s2=new StringBuffer();
			    s2.append(s1);
			    if(s1.length()<4)
			    {
				    for(int j=0;j<4-s1.length();j++)
					    s2.insert(0, "0");
			    }
						
			    String s3;	
			    s3=s2.substring(0,s2.length());
			
			    m.portfail.replace(4, 8, s3);
			    m.portfail.replace(20, 24, m.GetCheck(m.portfail.substring(0,40)));
			    m.portfail.replace(44, 48,m.GetCheck(m.portfail.substring(40)) );
			   
			    
			}
			
			
		 }
		if(x==3)
		{
			Calendar tt=Calendar.getInstance();
		    Date date=tt.getTime();
		    String ds=String.valueOf(date.getSeconds());
		    String dm=String.valueOf(date.getMinutes());
		    String dh=String.valueOf(date.getHours());
		    String dmo=String.valueOf(date.getMonth());
		   
			m.ICMPreq.replace(20, 24, m.GetCheck(m.ICMPreq.substring(0,40)));
			ds=addaero(ds);
		    dm=addaero(dm);
		    dh=addaero(dh);
		   
		   
		  
		   
			m.ICMPreq.replace(56,58,dh);
			m.ICMPreq.replace(58,60,dm);
			m.ICMPreq.replace(60,62,ds);
		  
			m.ICMPreq.replace(44, 48, m.GetCheck(m.ICMPreq.substring(40)));
			
			//System.out.println(m.GetCheck(m.ICMPreq.substring(0,40)));
		}
		if(x==4)
		{
			Calendar tt1=Calendar.getInstance();
		    Date date1=tt1.getTime();
		    String ds1=String.valueOf(date1.getSeconds());
		    String dm1=String.valueOf(date1.getMinutes());
		    String dh1=String.valueOf(date1.getHours());
		   
		    ds1=addaero(ds1);
		    dm1=addaero(dm1);
		    dh1=addaero(dh1);
		  
			//m.portfail.replace(20, 24, m.GetCheck(m.IPPackage.substring(0,40)));
			m.ICMPans.replace(20, 24, m.GetCheck(m.ICMPans.substring(0,40)));
			m.ICMPans.replace(56,58,dh1);
			m.ICMPans.replace(58,60,dm1);
			m.ICMPans.replace(60,62,ds1);
		
						
		    m.ICMPans.replace(44, 48,m.GetCheck(m.ICMPans.substring(40)) );
		
	    }
		if(x==5)
		{
			m.IPPackage.replace(20, 24, m.GetCheck(m.IPPackage.substring(0,40)));
		//	System.out.println(m.GetCheck(m.IPPackage.substring(40)));
			m.IPPackage.replace(52, 56, m.GetCheck(m.IPPackage.substring(40)));
			
		}
		if(x==6)
		{
			//System.out.println(m.GetCheck(m.ttlout.substring(0,40)));
			m.ttlout.replace(24, 32, "7f000003");
			m.ttlout.replace(32, 40, "7f000001");
			m.ttlout.replace(20, 24, m.GetCheck(m.ttlout.substring(0,40)));
			
			m.ttlout.append(m.IPPackage.substring(0,56));
			m.ttlout.replace(44,48, m.GetCheck(m.ttlout.substring(40)));
			
			
		}
		
		
	
	}
	String addaero(String temp){
	
	 
		StringBuffer s2=new StringBuffer();		    	
	    s2.append(temp);
	    if(temp.length()<2)
	    {
		    for(int j=0;j<2-temp.length();j++)
			    s2.insert(0, "0");
	    }
				
	    String s3;	
	    s3=s2.substring(0,s2.length());
	    return s3;
	 }
	

}
