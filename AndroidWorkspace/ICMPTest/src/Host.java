import java.util.ArrayList;

public class Host {
	
	public frames msg;
	public ArrayList inqueue;
	public ArrayList outqueue;
	public ArrayList sharemessage;
	public String address;
	private int[] port={1,1,1,1,1};

	

	
	public Host(frames m,ArrayList shme,String address,int port){
		
		this.inqueue=new ArrayList();
		this.outqueue=new ArrayList();
		this.port[4]=port;
		this.address=address;
		this.sharemessage=shme;
		
	}
	
	public void send(frames msg){
		this.sharemessage.add(msg);
		
	}
	public void receive(frames msg){
		this.sharemessage.remove(msg);
	};
	public frames getsendmsg(){
		return (frames)this.outqueue.get(0);
	}
	public frames getrevemsg(){
		return (frames)this.inqueue.get(0);
	}
	private boolean check(String s){
		boolean c;
		int ch=0;
		int ch1;
		int temp1;
		String temp;
		int length=s.length();
		for (int i=0;i<length;i=i+4){
			temp=s.substring(i,4);
			temp1=Integer.parseInt(temp,16);
			ch=ch+temp1;
		}
		ch1=ch%0xffff;
		if(ch1==0)
		c=true;
		else c=false;
		return c;
			
	}
	public void run (){
		
		if(!this.outqueue.isEmpty()){
			frames msg1=(frames)this.outqueue.get(0);
			this.send(msg1);
			if(msg1.x==1){
			
			
			//System.out.println("PC1������PC2�������ݣ�");
			
			
			try{
				Thread.sleep(200);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("���͵�����Ϊ��");
		    try{
				Thread.sleep(200);
			}
		    
		    catch(Exception e){
				e.printStackTrace();
			}
		   	
		    System.out.println(msg1.IPPackage);
		   System.out.println("IP����ͷ����");
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("�汾:      "+msg1.IPPackage.substring(0,1));
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("�ײ�����:  "+msg1.IPPackage.substring(1,2));
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("���ַ���:  "+msg1.IPPackage.substring(2,4));
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("�ܳ��� :    "+msg1.IPPackage.substring(4,8));
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("��ʶ:      "+msg1.IPPackage.substring(8,12));
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("��־Ƭƫ�ƣ�"+msg1.IPPackage.substring(12,16));
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("����ʱ�䣺    "+msg1.IPPackage.substring(16,18));
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("Э�飺            "+msg1.IPPackage.substring(18,20));
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("�ײ�����ͣ�"+msg1.IPPackage.substring(20,24));
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("Դ��ַ��        "+msg1.IPPackage.substring(24,32));
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("Ŀ�ĵ�ַ��    "+msg1.IPPackage.substring(32,40));
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("UDP�����ײ���");
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("Դ�˿�:    "+msg1.IPPackage.substring(40,44));
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("Ŀ�Ķ˿ڣ�    "+msg1.IPPackage.substring(44,48));
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("���ȣ�            "+msg1.IPPackage.substring(48,52));
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
		    System.out.println("У���:    "+msg1.IPPackage.substring(52,56));
		    try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
			}
			
		//	System.out.println("�����"+msg1.GetCheck(msg1.IPPackage));
			
			//System.out.println(msg2.portfail);
		    System.out.println("UDP���ݲ���"+msg1.IPPackage.substring(56));
			}
			else if(msg1.x==2){
				
				System.out.println(msg1.portfail.substring(0,65)+"->");
				System.out.println(msg1.portfail.substring(65));
				System.out.println("ICMP�ֶ����ݣ�");
				 try{
						Thread.sleep(200);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
				    System.out.println("���ͣ�            "+msg1.portfail.substring(40,42));
				    try{
						Thread.sleep(200);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
				    System.out.println("���룺            "+msg1.portfail.substring(42,44));
				    try{
						Thread.sleep(200);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
				    System.out.println("У��ͣ�            "+msg1.portfail.substring(44,48));
				    try{
						Thread.sleep(200);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
				    System.out.println("��ѡ�ֶΣ�         "+msg1.portfail.substring(48,56));
				    try{
						Thread.sleep(200);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
				    System.out.println("���ݲ���:  "+msg1.portfail.substring(56));
				
				    
			}
			else if(msg1.x==3){
				 System.out.println("                                                                        ");    
				System.out.println("PC1��PC2���ͻ�Ӧ������");
				System.out.println("��������Ϊ:");
				System.out.println(msg1.ICMPreq.toString());
				System.out.println("ICMP����");
				 System.out.println("����:    "+msg1.ICMPreq.substring(40,42));
				    try{
						Thread.sleep(100);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
				    System.out.println("���룺        "+msg1.ICMPreq.substring(42,44));
				    try{
						Thread.sleep(100);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
				    System.out.println("У��ͣ�            "+msg1.ICMPreq.substring(44,48));
				    try{
						Thread.sleep(100);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
				    System.out.println("��ʶ:    "+msg1.ICMPreq.substring(48,52));
				    
				    try{
						Thread.sleep(100);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
				    System.out.println("���:    "+msg1.ICMPreq.substring(52,56));
				    try{
						Thread.sleep(100);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
				    System.out.println("ʱ��:    "+msg1.ICMPreq.substring(56,58)+":"+msg1.ICMPreq.substring(58,60)+":"+msg1.ICMPreq.substring(60,62));
				    try{
						Thread.sleep(100);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
				
			}
			else if(msg1.x==4){
				System.out.println("                                                                                           ");
			    System.out.println("PC2��PC1���ͻ�ӦӦ����");
			    System.out.println("��������Ϊ��");
			    System.out.println(msg1.ICMPans.toString());
				System.out.println("ICMP����");
				 System.out.println("����:    "+msg1.ICMPans.substring(40,42));
				    try{
						Thread.sleep(100);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
				    System.out.println("���룺        "+msg1.ICMPans.substring(42,44));
				    try{
						Thread.sleep(100);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
				    System.out.println("У��ͣ�            "+msg1.ICMPans.substring(44,48));
				    try{
						Thread.sleep(100);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
				    System.out.println("��ʶ:    "+msg1.ICMPans.substring(48,52));
				    
				    try{
						Thread.sleep(100);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
				    System.out.println("���:    "+msg1.ICMPans.substring(52,56));
				    try{
						Thread.sleep(100);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
				    System.out.println("ʱ��:    "+msg1.ICMPans.substring(56,58)+":"+msg1.ICMPans.substring(58,60)+":"+msg1.ICMPans.substring(60,62));
				    try{
						Thread.sleep(100);
					}
				    catch(Exception e){
						e.printStackTrace();
					}
			}
			else if(msg1.x==5){
				System.out.println("��������Ϊ��");
				System.out.println(msg1.IPPackage);
				System.out.println("TTLֵ��        "+Integer.parseInt(msg1.IPPackage.substring(16,18),16));
			    try{
					Thread.sleep(100);
				}catch(Exception e){
					e.printStackTrace();
				}
				System.out.println("Э�����ͣ�        "+Integer.parseInt(msg1.IPPackage.substring(18,20),16));
			    try{
					Thread.sleep(100);
				}catch(Exception e){
					e.printStackTrace();
				}
				System.out.println("                                                       ");			
			
				
				
			}
			

		    this.outqueue.remove(0);
		}
		else if(!this.inqueue.isEmpty()){
			frames msg2= (frames)this.inqueue.get(0);
			if(msg2.x==1){
			    this.receive(msg2);
			    if(msg2.IPPackage.substring(18,20).equals("11"))
			    	
			    if(port[Integer.parseInt(msg2.IPPackage.substring(44,48),16)]==-1){
				    System.out.println("                                                                        ");
				    System.out.println("Э������Ϊ17  UDP");
				    System.out.println("��⵽port["+Integer.parseInt(msg2.IPPackage.substring(44,48),16)+"]�˿ڲ�����");
				    System.out.println("�����ð�");
				    System.out.println("                                                                        ");
			     }
			     else {						
				     System.out.println("");
				     if((msg2.portfail.substring(24, 32)=="7f000001")&&msg2.GetCheck(msg2.portfail.substring(0,40))=="ffff")
				     System.out.println("PC2���ܵ����ݣ�");
			     }
		
		     }
			else if(msg2.x==2){
				this.receive(msg2);
				//System.out.println(msg2.portfail.substring(24, 32));
				 if((msg2.portfail.substring(32, 40).equals("7f000001"))&&(msg2.GetCheck(msg2.portfail.substring(0,40)).equals("ffff")||msg2.GetCheck(msg2.portfail.substring(0,40)).equals("0000"))){
					 
				      System.out.println("                                                                        ");
				      System.out.println("IP��ַ��У�����ȷ��");
				      if(msg2.portfail.substring(18, 20).equals("01"))
				    	  System.out.println("Э������Ϊ1");
				      System.out.println("PC1���յ��˿ڲ�����ICMP��");
				 }
			}
			else if(msg2.x==3)
			{
				this.receive(msg2);
				//prinSystem.out.println(msg2.ICMPreq.substring(32,40));
				if(msg2.ICMPreq.substring(32,40).equals("7f000002")&&(msg2.GetCheck(msg2.ICMPreq.substring(0,40)).equals("ffff")||msg2.GetCheck(msg2.ICMPreq.substring(0,40)).equals("0000"))){
					System.out.println("                                                                                           ");
					System.out.println("IP��ַ��У�����ȷ");
					System.out.println("PC2���յ�PC1��ICMP��Ӧ������");
				}
			}
			else if(msg2.x==4)
			{
				this.receive(msg2);
				if(msg2.ICMPans.substring(32,40).equals("7f000001")&&(msg2.GetCheck(msg2.ICMPans.substring(0,40)).equals("ffff")||msg2.GetCheck(msg2.ICMPans.substring(0,40)).equals("0000"))){
					System.out.println("                                                                                           ");
					System.out.println("IP��ַ��У�����ȷ");
					System.out.println("PC1���յ�PC2��ICMP��ӦӦ����");
				}
				
			}
					
			else if(msg2.x==5)
			{
				//System.out.println("OK!");
				System.out.println("PC2���յ�����");
				this.receive(msg2);
				
			    if(msg2.IPPackage.substring(18,20).equals("11"))			    	
			    if(port[Integer.parseInt(msg2.IPPackage.substring(44,48),16)]==-1){
				    System.out.println("                                                                        ");
				    System.out.println("Э������Ϊ17  UDP");
				    System.out.println("��⵽port["+Integer.parseInt(msg2.IPPackage.substring(44,48),16)+"]�˿ڲ�����");
				    System.out.println("�����ð�");
				    System.out.println("                                                                        ");
			     }
			     else {						
				     
				     if((msg2.portfail.substring(24, 32)=="7f000001")&&msg2.GetCheck(msg2.portfail.substring(0,40))=="ffff")
				     System.out.println("PC2���ܵ����ݣ�");
			     }
			}
			else if(msg2.x==6)
			{
				
				this.receive(msg2);
				//System.out.println(msg2.GetCheck(msg2.ttlout.toString()));
			
				if(msg2.ttlout.substring(40, 44).equals("0b00"))
					
				//	System.out.println(msg2.GetCheck(msg2.ttlout.toString()));
					if(msg2.GetCheck(msg2.ttlout.toString()).equals("0000")||msg2.GetCheck(msg2.ttlout.toString()).equals("ffff")){
						System.out.println("PC1���յ�TTL��ʱ����");
						System.out.println("�յ��ı���Ϊ��");	
						if(msg2.ttl==2)		
							//System.out.println("00000");
							msg2.ttlout.replace(24, 32, "7f000004");						
						System.out.println(msg2.ttlout.substring(0,65)+"->");
						System.out.println(msg2.ttlout.substring(65));
						 System.out.println("ICMP����");
							System.out.println("����:    "+msg2.ttlout.substring(40,42));
							    try{
									Thread.sleep(100);
								}
							    catch(Exception e){
									e.printStackTrace();
								}
							    System.out.println("���룺        "+msg2.ttlout.substring(42,44));
							    try{
									Thread.sleep(100);
								}
							    catch(Exception e){
									e.printStackTrace();
								}
							    System.out.println("У��ͣ�            "+msg2.ttlout.substring(44,48));
							    try{
									Thread.sleep(100);
								}
							    catch(Exception e){
									e.printStackTrace();
								}
							   
							   
					}
			}
			this.inqueue.remove(0);
			
			
	}
		
		
	}
	

}
