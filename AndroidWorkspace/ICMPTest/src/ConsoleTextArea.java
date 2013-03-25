import java.io.*;

import javax.swing.*;
import javax.swing.text.*;

public class ConsoleTextArea extends JTextArea {
	private int width;
    public ConsoleTextArea(InputStream[] inStreams)
    {
        for(int i=0;i<inStreams.length;i++)
            startConsoleReaderThread(inStreams[i]);
    } // ConsoleTextArea()

    public ConsoleTextArea(int width)throws IOException 
    {
    	this.width=2*width;
       final LoopedStreams ls = new LoopedStreams();

        // �ض���System.out��System.err
        PrintStream ps = new PrintStream(ls.getOutputStream());

        System.setOut(ps);
        System.setErr(ps);
        startConsoleReaderThread(ls.getInputStream());
    } // ConsoleTextArea()

    private void startConsoleReaderThread(InputStream inStream)
    {
        final BufferedReader br =new BufferedReader(new InputStreamReader(inStream));

        new Thread(new Runnable()
        {
            public void run()
            {
            	StringBuffer sb = new StringBuffer();
                try 
                {
                	String s;
                    Document doc = getDocument();
                    while((s=br.readLine())!=null)
                    {
                        boolean caretAtEnd = false;
                        caretAtEnd=getCaretPosition()==doc.getLength()?true : false;
                        sb.setLength(0);
                        append(sb.append(s).append('\n').toString());
                        if(caretAtEnd)
                            setCaretPosition(doc.getLength());
                    }
                }
                catch(IOException e)
                {
                    JOptionPane.showMessageDialog(null,
                    							"��BufferedReader��ȡ����" + e);
                    System.exit(1);
                }
            }
        }).start();

    } // startConsoleReaderThread()

} // ConsoleTextAr

