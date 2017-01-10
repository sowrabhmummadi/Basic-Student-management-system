package alerts;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Alerts
{  int count;
   JFrame alert,F;
   JLabel altm1,altm2; 

	public void alert1(Exception e,JFrame f )
	{
        count=0; 
        alert=new JFrame("alert");
        F=f;
        try {
			alert.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Sowrabh\\Pictures\\Backgrounds Wallpapers HD\\jntupic6.jpg")))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        alert.setLayout(new BorderLayout());
        alert.pack();
        altm1=new JLabel(" ",JLabel.CENTER);
		altm2=new JLabel(" ",JLabel.CENTER);
        altm1.setFont(new Font("Serif", Font.BOLD, 40));
		altm2.setFont(new Font("Serif", Font.BOLD, 30));
        JPanel altp= new JPanel();
        altp.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton ok=new JButton("ok");
        ok.addActionListener(new ActionListener()
                      {
	                    public void actionPerformed(ActionEvent e)
	                    {
	                    	alert.setVisible(false);
	                    	F.setVisible(true);
	                    	
	                    }
                      });
        JButton cl=new JButton("Cancle");
        cl.addActionListener(new ActionListener()
                 {
                   public void actionPerformed(ActionEvent e)
                     {
                         	alert.setVisible(false);
                        	System.exit(0);
                 }
                 });
              altp.add(ok);
		      altp.add(cl);
              altm1.setText("Run Time Error");
			  altm2.setText("**"+e);
			  altm1.setOpaque(false);
			  altm2.setOpaque(false);
			  altp.setOpaque(false);
			     alert.add(altm1,BorderLayout.NORTH);
				 alert.add(altm2,BorderLayout.CENTER);
				 alert.add(altp,BorderLayout.SOUTH);
			  alert.setVisible(true);
	}	
	
	public void alert1(ClassNotFoundException e,JFrame f )
	{
        count=0; 
        alert=new JFrame("alert");
        F=f;
        try {
			alert.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Sowrabh\\Pictures\\Backgrounds Wallpapers HD\\jntupic6.jpg")))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        alert.setLayout(new BorderLayout());
        alert.pack();
        altm1=new JLabel(" ",JLabel.CENTER);
		altm2=new JLabel(" ",JLabel.CENTER);
        altm1.setFont(new Font("Serif", Font.BOLD, 40));
		altm2.setFont(new Font("Serif", Font.BOLD, 30));
        JPanel altp= new JPanel();
        altp.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton ok=new JButton("ok");
        ok.addActionListener(new ActionListener()
                      {
	                    public void actionPerformed(ActionEvent e)
	                    {
	                    	alert.setVisible(false);
	                    	F.setVisible(true);
	                    	
	                    }
                      });
        JButton cl=new JButton("Cancle");
        cl.addActionListener(new ActionListener()
                 {
                   public void actionPerformed(ActionEvent e)
                     {
                         	alert.setVisible(false);
                        	System.exit(0);
                 }
                 });
              altp.add(ok);
		      altp.add(cl);
              altm1.setText("Run Time Error");
			  altm2.setText("**LOAD THE DRIVER CORRECTLY**");
			  altm1.setOpaque(false);
			  altm2.setOpaque(false);
			  altp.setOpaque(false);
			     alert.add(altm1,BorderLayout.NORTH);
				 alert.add(altm2,BorderLayout.CENTER);
				 alert.add(altp,BorderLayout.SOUTH);
			  alert.setVisible(true);
	}	
	public void alert1(IOException e,JFrame f )
	{
        count=0; 
        alert=new JFrame("alert");
        F=f;
        try {
			alert.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Sowrabh\\Pictures\\Backgrounds Wallpapers HD\\jntupic6.jpg")))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        alert.setLayout(new BorderLayout());
        alert.pack();
        altm1=new JLabel(" ",JLabel.CENTER);
		altm2=new JLabel(" ",JLabel.CENTER);
        altm1.setFont(new Font("Serif", Font.BOLD, 40));
		altm2.setFont(new Font("Serif", Font.BOLD, 25));
        JPanel altp= new JPanel();
        altp.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton ok=new JButton("ok");
        ok.addActionListener(new ActionListener()
                      {
	                    public void actionPerformed(ActionEvent e)
	                    {
	                    	alert.setVisible(false);
	                    	F.setVisible(true);
	                    	
	                    }
                      });
        JButton cl=new JButton("Cancle");
        cl.addActionListener(new ActionListener()
                 {
                   public void actionPerformed(ActionEvent e)
                     {
                         	alert.setVisible(false);
                        	System.exit(0);
                 }
                 });
              altp.add(ok);
		      altp.add(cl);
              altm1.setText("Run Time Error");
			  altm2.setText("***CHECK THE INPUT FILE....(NOTFOUND)**");
			  altm1.setOpaque(false);
			  altm2.setOpaque(false);
			  altp.setOpaque(false);
			     alert.add(altm1,BorderLayout.NORTH);
				 alert.add(altm2,BorderLayout.CENTER);
				 alert.add(altp,BorderLayout.SOUTH);
			  alert.setVisible(true);
	}	
	public void alert1(SQLException e,JFrame f )
	{
        count=0; 
        alert=new JFrame("alert");
        F=f;
        try {
			alert.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Sowrabh\\Pictures\\Backgrounds Wallpapers HD\\jntupic6.jpg")))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        alert.setLayout(new BorderLayout());
        alert.pack();
        altm1=new JLabel(" ",JLabel.CENTER);
		altm2=new JLabel(" ",JLabel.CENTER);
        altm1.setFont(new Font("Serif", Font.BOLD, 40));
		altm2.setFont(new Font("Serif", Font.BOLD, 30));
        JPanel altp= new JPanel();
        altp.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton ok=new JButton("ok");
        ok.addActionListener(new ActionListener()
                      {
	                    public void actionPerformed(ActionEvent e)
	                    {
	                    	alert.setVisible(false);
	                    	F.setVisible(true);
	                    	
	                    }
                      });
        JButton cl=new JButton("Cancle");
        cl.addActionListener(new ActionListener()
                 {
                   public void actionPerformed(ActionEvent e)
                     {
                         	alert.setVisible(false);
                        	System.exit(0);
                 }
                 });
              altp.add(ok);
		      altp.add(cl);
              altm1.setText("Run Time Error");
			  altm2.setText("***DATABASE ERROR...***");
			  altm1.setOpaque(false);
			  altm2.setOpaque(false);
			  altp.setOpaque(false);
			     alert.add(altm1,BorderLayout.NORTH);
				 alert.add(altm2,BorderLayout.CENTER);
				 alert.add(altp,BorderLayout.SOUTH);
			  alert.setVisible(true);
	}	
	public void alert1(NumberFormatException e,JFrame f )
	{
        count=0; 
        alert=new JFrame("alert");
        F=f;
        try {
			alert.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Sowrabh\\Pictures\\Backgrounds Wallpapers HD\\jntupic6.jpg")))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        alert.setLayout(new BorderLayout());
        alert.pack();
        altm1=new JLabel(" ",JLabel.CENTER);
		altm2=new JLabel(" ",JLabel.CENTER);
        altm1.setFont(new Font("Serif", Font.BOLD, 40));
		altm2.setFont(new Font("Serif", Font.BOLD, 30));
        JPanel altp= new JPanel();
        altp.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton ok=new JButton("ok");
        ok.addActionListener(new ActionListener()
                      {
	                    public void actionPerformed(ActionEvent e)
	                    {
	                    	alert.setVisible(false);
	                    	F.setVisible(true);
	                    	
	                    }
                      });
        JButton cl=new JButton("Cancle");
        cl.addActionListener(new ActionListener()
                 {
                   public void actionPerformed(ActionEvent e)
                     {
                         	alert.setVisible(false);
                        	System.exit(0);
                 }
                 });
              altp.add(ok);
		      altp.add(cl);
              altm1.setText("Run Time Error");
			  altm2.setText("**PLEASE ENTER THE DATA CORRECTLY....**");
			  altm1.setOpaque(false);
			  altm2.setOpaque(false);
			  altp.setOpaque(false);
			     alert.add(altm1,BorderLayout.NORTH);
				 alert.add(altm2,BorderLayout.CENTER);
				 alert.add(altp,BorderLayout.SOUTH);
			  alert.setVisible(true);
	}	
}