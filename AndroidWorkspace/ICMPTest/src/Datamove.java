import java.awt.*;
public class Datamove {
	private int startposition;
	private int endposition;
	private int yposition;
	public MainFrame mf;
	Graphics g;
	Graphics g1;
	Graphics2D gd;
	Graphics2D gd1;
	
	
	
	public Datamove (MainFrame mf, int start ,int end,int y)
	{
		this.mf=mf;
		this.startposition= start;
		this.endposition= end;
		this.yposition= y;
		g=mf.paint.getGraphics();
		g1=mf.paint1.getGraphics();
		gd= (Graphics2D)g1;
		gd1=(Graphics2D)g;
		Color toright=Color.black;
		Color toleft=Color.gray;
		gd.setStroke(new BasicStroke(15));
		gd1.setStroke(new BasicStroke(20));
		
	}
	public void movex()
	{
		int x=this.startposition;
		int y=this.endposition;
		 while(x<this.endposition-20)
		 {		
			 
			 		// gd.drawLine(130, 180, 230, 280);	
			 gd1.setColor(Color.orange);
			 gd1.drawLine(x, this.yposition, x+20,this.yposition );
		     
		 	
			 try{
					Thread.sleep(200);
				}
			    catch(Exception e){
					e.printStackTrace();
			    }
		     gd1.setColor(new Color(100,200,200));
		     gd1.drawLine(x, this.yposition, x+20, this.yposition);
		     x+=20;
		 }	  
		// gd1.setColor(new Color(100,200,200));
	//	 gd1.drawLine(x, this.yposition, x+20, this.yposition);

		
		
	}
	public void movey()
	{
		
		int x=this.endposition-20;
		 while(x>this.startposition)
		 {		
			
			 		// gd.drawLine(130, 180, 230, 280);	
			 gd1.setColor(Color.gray);
			 gd1.drawLine(x, this.yposition, x+20,this.yposition );
		     
		 	
			 try{
					Thread.sleep(200);
				}
			    catch(Exception e){
					e.printStackTrace();
			    }
		     gd1.setColor(new Color(100,200,200));
		     gd1.drawLine(x, this.yposition, x+20, this.yposition);
		     x-=20;
		 }	  
		// gd1.setColor(new Color(100,200,200));
	//	 gd1.drawLine(x, this.yposition, x+20, this.yposition);

		
	}
	public void move1()
	{			  
		 int x=160;
		 int y=180;
		 	
		 while(x<240)
		 {	
			 		// gd.drawLine(130, 180, 230, 280);	
			 gd.setColor(Color.orange);
			 gd.drawLine(x, y, x+10, y+10);
		     
		 	
			 try{
					Thread.sleep(200);
				}
			    catch(Exception e){
					e.printStackTrace();
			    }
		     gd.setColor(new Color(100,200,200));
		     gd.drawLine(x, y, x+10, y+10);
		     x+=10;
		     y+=10;
		 }	  
		
		 
	}	
	public void move2()
	{			  
		 int x=250;
		 int y=270;
		 while(x>160)
		 {		
			 
			 gd.setColor(Color.gray);			// gd.drawLine(130, 180, 230, 280);			  
			 gd.drawLine(x, y, x+10, y+10);
		    
		 	
			 try{
					Thread.sleep(200);
				}
			    catch(Exception e){
					e.printStackTrace();
			    }
		     gd.setColor(new Color(100,200,200));
		     gd.drawLine(x, y, x+10, y+10);
		     x-=20;
		     y-=20;
		     
		 }		
		
	}	
	public void move3()
	{
		int x=290;
		while(x<550)
		{
			
		 gd.setColor(Color.orange);			// gd.drawLine(130, 180, 230, 280);			  
		 gd.drawLine(x, 310, x+10,310);
	     
	 	
		 try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
		    }
	     gd.setColor(new Color(100,200,200));
	     gd.drawLine(x, 310, x+10, 310);
	     x+=20;
		}
		
	}
	
	public void move4()
	{
		int x=550;
		while(x>290)
		{
		 gd.setColor(Color.gray);			// gd.drawLine(130, 180, 230, 280);			  
		 gd.drawLine(x, 310, x+10,310);
	    
	 	
		 try{
				Thread.sleep(200);
			}
		    catch(Exception e){
				e.printStackTrace();
		    }
	     gd.setColor(new Color(100,200,200));
	     gd.drawLine(x, 310, x+10, 310);
	     x-=20;
		}
		
	}
	
	public void move5()
	{
		 int x=600;
		 int y=260;
		 	
		 while(x<680)
		 {		
			 
			 		// gd.drawLine(130, 180, 230, 280);	
			 gd.setColor(Color.orange);
			 gd.drawLine(x, y, x+10, y-10);
		     
		 	
			 try{
					Thread.sleep(200);
				}
			    catch(Exception e){
					e.printStackTrace();
			    }
		     gd.setColor(new Color(100,200,200));
		     gd.drawLine(x, y, x+10, y-10);
		     x+=20;
		     y-=20;
		 }	  
		 
		
		 
		
	}
	public void move6()
	{
		 int x=680;
		 int y=190;
		 	
		 while(x>600)
		 {		
			 
			 		// gd.drawLine(130, 180, 230, 280);	
			 gd.setColor(Color.gray);
			 gd.drawLine(x, y, x+10, y-10);
		    
		 	
			 try{
					Thread.sleep(200);
				}
			    catch(Exception e){
					e.printStackTrace();
			    }
		     gd.setColor(new Color(100,200,200));
		     gd.drawLine(x, y, x+10, y-10);
		     x-=10;
		     y+=10;
		 }	  
	
		 
		
	}
}
