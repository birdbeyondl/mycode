import java.util.ArrayList;
public class Router  {
	public frames msg;
	public ArrayList inqueue[]=new ArrayList[2];
	public ArrayList outqueue[]=new ArrayList[2];
	public ArrayList sharemessage[]=new ArrayList[2];
	
	public String address;
	public int x=0;
	public MainFrame mf;
	
	

	
	public Router(ArrayList shme,ArrayList shme1,String address){
		this.inqueue[1]=new ArrayList();	
		this.outqueue[0]=new ArrayList();
		this.inqueue[0]=new ArrayList();
		this.outqueue[1]=new ArrayList();
		/*this.sharemessage[0]=new ArrayList();
		this.sharemessage[1]=new ArrayList();
		*/
		this.address=address;
		this.sharemessage[0]=shme;
		this.sharemessage[1]=shme1;
		
	}
	
	public void send0(frames msg){
		this.sharemessage[0].add(msg);
	//	this.outqueue[0].remove(0);
		
	}
	public void send1(frames msg){
		this.sharemessage[1].add(msg);
	//	this.outqueue[1].remove(0);
		
	}
	public void receive0(frames msg){
		this.sharemessage[0].remove(msg);
		this.inqueue[0].remove(0);
	};
	public void receive1(frames msg){
		this.sharemessage[1].remove(msg);
		this.inqueue[1].remove(0);
	};
	/*public frames getsendmsg(){
		return (frames)this.outqueue.get(0);
	}
	public frames getrevemsg(){
		return (frames)this.inqueue.get(0);
	}
	
*/
	public void  run()
	{
		
		if(!sharemessage[0].isEmpty()){
			
			frames mm1=(frames)sharemessage[0].get(0);
			this.inqueue[0].add((frames)sharemessage[0].get(0));
			//this.receive0((frames)sharemessage[0].get(0));
			sharemessage[0].remove(0);
			String s1=mm1.IPPackage.substring(16,18);
			int x=Integer.parseInt(s1);
			if(x<=1){
				System.out.println("TTL值为1  丢弃该包并返回TTL超时报文");
				this.inqueue[0].remove(0);
				//mf.router1.setText("");
			//	mf.router1.//
				//TTLout(mm1);

				
			//	this.send0(mm1);
			}
			else{
			this.outqueue[1].add(this.inqueue[0].get(0));
			frames msg1=(frames)this.outqueue[1].get(0);
			TTLd(msg1,1);
		    this.send1(msg1);
		/*    System.out.println("ICMP部分");
			System.out.println("类型:    "+msg1.ttlout.substring(40,42));
			    try{
					Thread.sleep(100);
				}
			    catch(Exception e){
					e.printStackTrace();
				}
			    System.out.println("代码：        "+msg1.ttlout.substring(42,44));
			    try{
					Thread.sleep(100);
				}
			    catch(Exception e){
					e.printStackTrace();
				}
			    System.out.println("校验和：            "+msg1.ttlout.substring(44,48));
			    try{
					Thread.sleep(100);
				}
			    catch(Exception e){
					e.printStackTrace();
				}
			    System.out.println("标识:    "+msg1.ttlout.substring(48,52));
			    
			    try{
					Thread.sleep(100);
				}
			    catch(Exception e){
					e.printStackTrace();
				}
			    System.out.println("序号:    "+msg1.ttlout.substring(52,56));
			    try{
					Thread.sleep(100);
				}
			    catch(Exception e){
					e.printStackTrace();
				}
			    System.out.println("时间:    "+msg1.ttlout.substring(56,58)+":"+msg1.ICMPans.substring(58,60)+":"+msg1.ICMPans.substring(60,62));
			    try{
					Thread.sleep(100);
				}
			    catch(Exception e){
					e.printStackTrace();
				}*/
		    this.outqueue[1].remove(0);
		   // System.out.println(msg1.IPPackage.substring(16,18));
			}
		}
		else if(!sharemessage[1].isEmpty()){
		
			this.inqueue[1].add((frames)sharemessage[1].get(0));
			//this.receive1((frames)sharemessage[1].get(0));
			frames mm2=(frames)sharemessage[1].get(0);
			sharemessage[1].remove(0);
			String s1=mm2.IPPackage.substring(16,18);
			int x=Integer.parseInt(s1);
			
			if(x<=1){						
				this.inqueue[0].remove(0);
				
				System.out.println("TTL值为1  丢弃该包并返回TTL超时报文");
				//TTLout(mm2);
				
				
			}
			else{
			this.outqueue[0].add(this.inqueue[1].get(0));
			frames msg2=(frames)this.outqueue[0].get(0);
			TTLd(msg2,1);
		    this.send1(msg2);
		    this.outqueue[0].remove(0);
		    
			}
		}
			
			
	}
	public void run1()
	{
if(!sharemessage[0].isEmpty()){
			
			frames mm1=(frames)sharemessage[0].get(0);
			this.inqueue[0].add((frames)sharemessage[0].get(0));
			//this.receive0((frames)sharemessage[0].get(0));
			sharemessage[0].remove(0);
			String s1=mm1.portfail.substring(16,18);
			int x=Integer.parseInt(s1);
			if(x<=1){
				this.inqueue[0].remove(0);
				
				//TTLout(mm1);
			//	this.send0(mm1);
			}
			else{
			this.outqueue[1].add(this.inqueue[0].get(0));
			frames msg1=(frames)this.outqueue[1].get(0);
			TTLd(msg1,1);
		    this.send1(msg1);
		    System.out.println(msg1.portfail.substring(16,18));
			}
		}
		else if(!sharemessage[1].isEmpty()){
	//		System.out.println("0000");
		
			this.inqueue[1].add((frames)sharemessage[1].get(0));
			//this.receive1((frames)sharemessage[1].get(0));
			frames mm2=(frames)sharemessage[1].get(0);
			sharemessage[1].remove(0);
			String s1=mm2.portfail.substring(16,18);
			int x=Integer.parseInt(s1);
			
			if(x<=1){						
				this.inqueue[0].remove(0);
				
				//TTLout(mm2);
				
				
			}
			else{
			this.outqueue[0].add(this.inqueue[1].get(0));
			frames msg2=(frames)this.outqueue[0].get(0);
			TTLd(msg2,1);
		    this.send0(msg2);
		   // System.out.println(x);
		    
			}
		}
			
	}
	
	
	public void TTLd(frames m,int i)
	{
		String s1=m.IPPackage.substring(16,18);
		int x=Integer.parseInt(s1);
		if(x>1){
		    String s2=Integer.toHexString(x-i);
		    StringBuffer s3=new StringBuffer();		    	
		    s3.append(s2);
		    if(s2.length()<2)
		    {
			    for(int j=0;j<2-s2.length();j++)
				    s3.insert(0, "0");
		    }
					
		    String s4;	
		    s4=s3.substring(0,s3.length());
		    m.IPPackage.replace(16,18,s4);
		}
	}
	public void TTLout(frames m)
	{
		m.ttlout.replace(20, 24, m.GetCheck(m.ttlout.substring(0,40)));
		m.ttlout.append(m.IPPackage.substring(0,56));
		m.ttlout.replace(44,48, m.GetCheck(m.ttlout.substring(40)));
		
	}
}
