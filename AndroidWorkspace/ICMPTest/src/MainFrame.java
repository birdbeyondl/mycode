import java.applet.*;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class MainFrame extends Applet implements ActionListener
{
	InterControl IC;
	boolean IsAC=true;
	
	private JButton buttonyes;
	private Image imageyes;
	private ImageIcon iconyes;
	
	private JButton buttonsuspend;
	private Image imagesuspend;
	private ImageIcon iconsuspend;
	
	private JButton buttoncontinue;
	private Image  imagecontinue;
	private ImageIcon iconcontinue;
	
	private JRadioButton button1;
	private JRadioButton button2;
	private JRadioButton button3;
	
	public  JTextArea text1;
	public JTextArea text2;
	public JTextArea pc1;
	public JTextArea pc2;
	public JTextArea router1;
	public JTextArea router2;
	
	private JButton btn1;
	private ConsoleTextArea showprocess;
	
	Panel select;
	Panel pbutton;
	Panel pshow;
	Panel paint;
	
	Panel paint1;
	
	JScrollPane pshowprocess;
	
	int width;
	int height;
	int choose=1;
	
	Image pcleft;
	Image pcright;
	Image router;
	
	public Color bkcolor= new Color(100,200,200);
	public boolean start;
	
	private Image off_screen_buf;
	private Graphics off_screen_gc;
	private Graphics g1;
	private Graphics g2;
	private Graphics g3;
	private Graphics g4;

	private Font userFont=new Font("",Font.BOLD,15);
	
	public void init()
	{
		Color handelcolor=Color.gray;
		Color showcolor= Color.gray;
		
		this.setBackground(bkcolor);
		Toolkit tool=getToolkit();
		Dimension dim=tool.getScreenSize();
		width=dim.width;
		height=dim.height;
		setLayout(null);
		
		off_screen_buf=this.createImage(width,height);
		off_screen_gc=off_screen_buf.getGraphics();
		off_screen_gc.setFont(userFont);
		
		select=new Panel();
		select.setBackground(handelcolor);
		select.setBounds(0,0,900,150);
		
		ButtonGroup bg=new ButtonGroup();
		button1=new JRadioButton("主机不可达",true);
		button2=new JRadioButton("ICMP的ping演示",false);
		button3=new JRadioButton("ICMP的traceroute演示",false);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		//button1.setBounds(100, 150, 150, 100);
		//button2.setBounds(180, 150, 150, 100);
		//button2.setBounds(260, 150, 150, 100);		
		bg.add(button1);
		bg.add(button2);
		bg.add(button3);
		
		select.add(button1);
		select.add(button2);
		select.add(button3);
		//button1.setBounds(100, 150, 150, 100);
		//button2.setBounds(180, 150, 150, 100);
		//button2.setBounds(260, 150, 150, 100);
		//Label lab1=new Label("端口不可达报文");
		
		
		
		add(select);
		
		
		pcleft=getImage(getCodeBase(),"pcleft.png");
		pcright=getImage(getCodeBase(),"pcright.png");
		router=getImage(getCodeBase(),"router.png");
		
		imageyes= getImage(getCodeBase(),"buttonyes.png");
		iconyes = new ImageIcon(imageyes);
		buttonyes = new JButton(iconyes);
		//
		
		pbutton = new Panel();
		pbutton.setBackground(showcolor);
		pbutton.setForeground(Color.black);
		pbutton.setBounds(0,650,900,250);
		pbutton.setLayout(null);
		
		
		
		imageyes= getImage(getCodeBase(),"buttonyes.png");
		iconyes = new ImageIcon(imageyes);
		buttonyes = new JButton(iconyes);
		buttonyes.setBounds(100, 40, 60, 60);
		buttonyes.addActionListener(this);
		pbutton.add(buttonyes);
		
		imagecontinue= getImage(getCodeBase(),"buttoncontinue.png");
		iconcontinue= new ImageIcon(imagecontinue);
		buttoncontinue= new JButton(iconcontinue);
		buttoncontinue.setBounds(400, 40, 60, 60);
		buttoncontinue.setEnabled(false);
		buttoncontinue.addActionListener(this);
		pbutton.add(buttoncontinue);
		
		
	
		paint =new Panel();
		paint.setBackground(bkcolor);
		paint.setBounds(0,150,900,500);
		paint.setLayout(null);
		
	
		text1=new JTextArea();		
		text1.setEditable(false);
		text1.setBackground(Color.LIGHT_GRAY);
		text1.setBounds(80, 250, 100,90);
		
		text2=new JTextArea();
		text2.setEditable(false);
		text2.setBackground(Color.LIGHT_GRAY);
		text2.setBounds(710, 250, 100, 90);
	
		
	 //   text1.setText("1234\n");
	   // text1.append("1534");
		paint.add(text1);
		paint.add(text2);
		
		
		
		//paint.setLayout(new FlowLayout());
		
		add(paint);
		
		paint1= new Panel();
		paint1.setBackground(bkcolor);
		paint1.setBounds(0,150,900,500);
		paint1.setLayout(null);
		
		pc1=new JTextArea();		
		pc1.setEditable(false);
		pc1.setBackground(Color.LIGHT_GRAY);
		pc1.setBounds(40, 210, 100,90);
		
		pc2=new JTextArea();		
		pc2.setEditable(false);
		pc2.setBackground(Color.LIGHT_GRAY);
		pc2.setBounds(720, 210, 100,90);
		
		router1=new JTextArea();		
		router1.setEditable(false);
		router1.setBackground(Color.LIGHT_GRAY);
		router1.setBounds(580, 350, 100,90);
		
		router2=new JTextArea();		
		router2.setEditable(false);
		router2.setBackground(Color.LIGHT_GRAY);
	    router2.setBounds(200, 350, 100,90);
	    
	    paint1.add(router1);
	    paint1.add(router2);
		paint1.add(pc2);
		paint1.add(pc1);
		add(paint1);
	
		imagesuspend =getImage(getCodeBase(),"buttonsuspend.png");
		iconsuspend = new ImageIcon(imagesuspend);
		buttonsuspend =new JButton(iconsuspend);
		buttonsuspend.setBounds(700,40,60,60);
		buttonsuspend.setEnabled(false);
		buttonsuspend.addActionListener(this);
		
		pbutton.add(buttonsuspend);
		add(pbutton);
		

		try{
			showprocess=new ConsoleTextArea(1000);
		}
		catch(IOException e)
		{
            System.err.println("不能创建LoopedStreams："+e);
	        System.exit(1);
		}
		
		showprocess.setEditable(false);
		showprocess.setBackground(Color.gray);
		showprocess.setForeground(Color.black);
		showprocess.setFont(userFont);
		
		pshow =new Panel();
		pshow.setBounds(900, 0, width-900, height);
		pshow.setLayout(null);
		
		pshowprocess=new JScrollPane(showprocess);
		pshowprocess.setBounds(0,0,width-900,height);
		
		
		pshow.add(pshowprocess);
		add(pshow);
		
		
		
		
		
		
	}
	public void paint(Graphics g)
	{
		
		//g.drawImage(pcleft,500,350,this);   
		 g1 =paint.getGraphics();
		 g3=select.getGraphics();
		 g4=pbutton.getGraphics();
		 g2=paint1.getGraphics();
		 g3.setColor(Color.white);
		 g4.setColor(Color.white);
		 g3.fillRect(0, 0, 20, height);
		 g3.fillRect(880, 0, 20, height);
		 g4.fillRect(0, 0, 20, height);
		 g4.fillRect(880, 0, 20, height);
		 if(choose==1||choose==2){ 
		   
		    g1.drawImage(pcleft,width/15,height/5-100,this);//pc1
		    g1.drawImage(pcright,width/2,height/5-100,this);//pc2
		    g1.setColor(Color.white);
		    g1.fillRect(0, 0, 20, height);
		    g1.fillRect(880, 0, 20, height);
		   
		
		
		    Graphics2D gd= (Graphics2D)g1;
		    gd.setColor(Color.gray);
		    gd.setStroke(new BasicStroke(15));
		    gd.drawLine(width/15+20, height/5+40, width/2+70, height/5+40);
		//g1.drawLine(0, 200, 400, 400);
		    gd.setStroke(new BasicStroke(6));
		    gd.drawLine(width/15+50, height/5-20, width/15+50, height/5+40);
		    gd.drawLine(width/2+50, height/5-20, width/2+50, height/5+40);  
		 }
		 if(choose==3){
			
			 
			 g2.drawImage(pcleft,80,80,this);//pc1
			 g2.drawImage(pcright,700,80,this);
			 g2.drawImage(router, 200, 290, this);
			 g2.drawImage(router, 550, 290, this);
			 g2.setColor(Color.white);
			 g2.fillRect(0, 0, 20, height);
			 g2.fillRect(880, 0, 20, height);
			 Graphics2D gd= (Graphics2D)g2;
			 gd.setColor(Color.gray);
			 gd.setStroke(new BasicStroke(15));
			 gd.drawLine(130, 180, 230, 280);
			 gd.drawLine(290, 340, 560, 340);
			 gd.drawLine(620, 280, 720, 180);
			 
			 
			 
		 }
	    
		/*if(choose==0){
		
			g2 =paint1.getGraphics();
			g2.drawImage(pcleft,width/15,height/5+40,this);//pc1
			g2.drawImage(pcright,width/2,height/5+40,this);//pc2
			g2.setColor(Color.black);
			g2.fillRect(0, 0, 20, height);
			g2.fillRect(880, 0, 20, height);
			
		}*/
		
		
	}

	
	
	
	
	
	
	public void actionPerformed(ActionEvent e )
	{
		if(e.getSource()==button1){
			 
			choose=1;
			paint.show(true);
			paint1.show(false);
			//remove(paint1);
			repaint();
			
			buttonyes.setEnabled(true);
			
			
		}
		else if(e.getSource()==button2){
			
			choose=2;	
			paint.show(true);
			paint1.show(false);
			repaint();
			buttonyes.setEnabled(true);
			
		}
		else if(e.getSource()==button3){
			
			choose=3;
			paint1.show(true);
			paint.show(false);
			repaint();
			buttonyes.setEnabled(true);
			
		}
		else if(e.getSource()==buttonyes){
			
			IC=new InterControl(this);
			IC.start();
			
			
			buttonyes.setEnabled(false);
			buttonsuspend.setEnabled(true);
			buttoncontinue.setEnabled(false);
		}
			
			
		
		else if(e.getSource()==buttoncontinue)
		{
			buttoncontinue.setEnabled(false);
			buttonsuspend.setEnabled(true);
			
			IC.resume();
		}
		else if(e.getSource()==buttonsuspend)
		{
			buttoncontinue.setEnabled(true);
			buttonsuspend.setEnabled(false);
			IC.suspend();
		}


		
	}
	public void resetOffScreenImage()
	{
		off_screen_gc.dispose();
		off_screen_buf.flush();
		off_screen_buf =this.createImage(width,height);//this.mF
		off_screen_gc = off_screen_buf.getGraphics();
		off_screen_gc.clearRect(0, 0, width, height);
		off_screen_gc.setFont(userFont);
	}
}

