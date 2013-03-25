import java.awt.Graphics;
public class frames {
    StringBuffer IPPackage=new StringBuffer();
	StringBuffer portfail=new StringBuffer();	
	StringBuffer ttlout=new StringBuffer();
    StringBuffer ICMPreq=new StringBuffer();
    StringBuffer ICMPans=new StringBuffer();

    int ttl=1;
	public int x;
	
	public frames(){
		
		IPPackage.append("4500001e00010000401100007f0000017f00000200040004000a00000000");
		portfail.append("4500001c00020000400100007f0000027f0000010303000000000000");
		ICMPreq.append("4500001d00010000400100007f0000017f0000020800000002000900000000000000");
		ICMPans.append("4500001d00020000400100007f0000027f0000010000000002000900000000000000");
		ttlout.append("4500001c00020000400100007f0000017f0000020b00000000000000");
	}
/*	public String GetCheck(StringBuffer s){
			int ch=0;
			int temp1;
			String temp;
			int length=s.length();
			for (int i=0;i<length;i=i+4){
				temp=s.substring(i,i+4);
				temp1=Integer.parseInt(temp,16);
				ch=ch+temp1;
			}
			ch%=0xffff;
			
			String s1=Integer.toHexString(ch);
			
			StringBuffer s2=new StringBuffer();
			s2.append(s1);
	
			if(s1.length()<4)
			{
				for(int j=0;j<4-s1.length();j++)
					s2.insert(0, "0");
			}
			
			
			String s3;	
			s3=s2.substring(0,s2.length());
			return s3;
				
    }*/
	public String GetCheck(String s)
	{
		int ch=0;
		int temp1;
		String temp;
		int length=s.length();
		for (int i=0;i<length;i=i+4){
			temp=s.substring(i,i+4);
			temp1=Integer.parseInt(temp,16);
			ch=ch+temp1;
		}
		ch%=0xffff;
		ch=0xffff-ch;
		
		String s1=Integer.toHexString(ch);
		
		StringBuffer s2=new StringBuffer();
		s2.append(s1);

		if(s1.length()<4)
		{
			for(int j=0;j<4-s1.length();j++)
				s2.insert(0, "0");
		}
		
		
		String s3;	
		s3=s2.substring(0,s2.length());
		return s3;
			
	}
	
	
	
	
	

}
