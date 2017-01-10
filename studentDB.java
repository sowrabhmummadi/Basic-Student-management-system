import java.awt.*;
import java.io.*;
import java.util.Properties;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;
class studentDB extends JFrame implements ActionListener
  {
	Properties ptr;
	String Password="password";
	JPasswordField pas;
	JFrame f,alert,g,k;
	JFrame F1=new JFrame();
	JLabel altm1,altm2,name,am; 
	JPanel p,p1,p2,altp,P,p3;
	JButton B1,B2,B3,ok,cl;
	ResultSet rs;
	PreparedStatement pins,pdis,pdel;
	TextField t1,t2,t3,t5,t6,t7,t8,t9;
	int count=10;
	Exception o;
	
	Connection con;
	public void alert(Exception e,String s)
	{ alert1(e,s);
	 }
	public void alert1(Exception e,String s)
	{
        count=0; 
		f.setVisible(false);
        alert=new JFrame("alert");
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
	                    	f.setVisible(true);
	                    	
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
        JButton bk=new JButton("back");
        bk.addActionListener(new ActionListener()
                 {
                   public void actionPerformed(ActionEvent e)
                     {
                      alert.setVisible(false);
                      try{
                      F1.setVisible(true);
                      }
                      catch(Exception u)
                      {System.out.println(u);}
                     }
                 });
              altp.add(ok);
		      altp.add(cl); 
		      altp.add(bk);
			  altm1.setOpaque(false);
			  altm2.setOpaque(false);
			  altp.setOpaque(false);
			     alert.add(altm1,BorderLayout.NORTH);
				 alert.add(altm2,BorderLayout.CENTER);
				 alert.add(altp,BorderLayout.SOUTH);
			  switch(s)
			  {
			  case "sqle":
				  altm1.setText("Run Time Error");
				  altm2.setText("***DATABASE ERROR***"+e);
				  break;
			  case "ioe":
				  altm1.setText("Run Time Error");
				  altm2.setText("*INPUT FILE NOT FOUND*"+e);
				  break;
			  case "nfe":
				  altm1.setText("Run Time Error");
				  altm2.setText("*ENTER THE DATA CORRECTLY*");
				  break;
			  case "cnfe":
				  altm1.setText("Run Time Error");
				  altm2.setText("*CHECK RESPECTIVE DRIVER*");
				  break;
			  case "e":
				  altm1.setText("Run TIME Error");
				  altm2.setText("**"+e);
				  break;
			 default:
				 altm1.setText("Run Time Error");
				  altm2.setText("*HI**");
			  }
			  alert.setVisible(true);
	}
	public static void main(String args[])
	{
	 studentDB sdb=new studentDB();
	}
	public studentDB()
	{
      
		    super();
			f=new JFrame("Student DataBase"); 
			try{f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Sowrabh\\Pictures\\Backgrounds Wallpapers HD\\jntupic2.jpg")))));}
			catch(IOException e)
			{alert(e,"ioe");}			
			f.setLayout(new BorderLayout());	
			p=new JPanel();
			p.setOpaque(false);
			p.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
			B1=new JButton("ADD");
			B2=new JButton("DELETE");
			B3=new JButton("DISPLAY");
			p.add(B1);
			B1.addActionListener(this);
			p.add(B2);
			B2.addActionListener(this);
			p.add(B3);
			B3.addActionListener(this);
			f.add(p,BorderLayout.SOUTH);
			f.setVisible(true);
			f.pack();
		    	 
	}
	public void actionPerformed(ActionEvent e)
	 {   
		f.setVisible(false);
		try{
		    ptr= new Properties();
    	  	ptr.load(new FileInputStream("D:\\c++\\eclipse\\studentDB\\src\\resorce.prop"));
	    	Class.forName(ptr.getProperty("DRIVER"));
    	    con=DriverManager.getConnection(ptr.getProperty("URL"),ptr.getProperty("USERNAME"),ptr.getProperty("PASSWORD"));
    	    }
		catch(ClassNotFoundException E)
				{alert(E,"cnfe");}
		catch(SQLException s)
		        {alert(s,"sqle");}
		catch(IOException i)
		        {alert(i,"ioe");}
		catch(Exception E)
		        {alert(E,"e");}
		
		if(e.getActionCommand()=="DISPLAY")
		{   
			try { pdis=con.prepareStatement("select * from student where name =?");}
			catch (SQLException e1)
			{alert(e1,"sqle");}			 
			F1=new JFrame();
			try {F1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Sowrabh\\Pictures\\Backgrounds Wallpapers HD\\jntupic5.jpg")))));}
			catch (IOException e1){alert(e1,"ioe");}
			F1.setLayout(new BorderLayout());
			p1=new JPanel();
			p2=new JPanel();
			p1.setLayout(new FlowLayout());
			p1.setFont(new Font("serif",Font.BOLD,30));
			//F2.setSize(800,200);
			p2.setLayout(new FlowLayout());			
			name= new JLabel("Student Name",JLabel.LEFT);
			t1=new TextField(20);
			p1.add(name);
			p1.add(t1);
			p1.setOpaque(false);
			p2.setOpaque(false);
			B1=new JButton("SUBMIT");
			B1.addActionListener(new ActionListener()
			   {
				public void actionPerformed(ActionEvent e)
				{   
					F1.setVisible(false);
					try {pdis.setString(1,t1.getText());
					rs=pdis.executeQuery();} 
					catch (SQLException e1) 
					{alert(e1,"sqle");count=0;}
		            if(count!=0){
					 g=new JFrame();
					 g.setLayout(new BorderLayout());
					 P=new JPanel();
					JButton ok=new JButton("ok");
					ok.addActionListener(new ActionListener()
					                    {
						                 public void actionPerformed(ActionEvent e)
						                 {
						                	 g.setVisible(false);
						                	 f.setVisible(true);					                	 
						                 }
					                    });
					JButton cl=new JButton("cancle");
					cl.addActionListener(new ActionListener()
                    {
	                 public void actionPerformed(ActionEvent e)
	                 {
	                	 g.setVisible(false);
	                	 System.exit(0);					                	 
	                 }
                    });
					p.setFont(new Font("jokerman",Font.BOLD,20));
					P.add(ok);
					P.add(cl);
					/*try {g.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Sowrabh\\Pictures\\Backgrounds Wallpapers HD\\jntupic7.jpg")))));}
					catch (IOException e1){alert(e1,"ioe");}*/
					g.setSize(400,300);
					TextArea Ta= new TextArea("",400,400);
					
					try {
						while(rs.next())
						{Ta.setFont(new Font("jokerman",Font.BOLD,20));
						 Ta.setText("NAME \t:"+rs.getString(1)+"\nSURNAME \t:"+rs.getString(2)+"\nFATHER NAME \t:"+rs.getString(3)+" \nPHONE \t:"+rs.getInt(4)+"\nFAX \t"+rs.getInt(5)+"\nEmail \t:"+rs.getString(6)+"\nDOFB \t:"+rs.getString(7));}
					} catch (SQLException e1)
					   {alert(e1,"sqle");
					   System.out.println("hi");}
					g.add(Ta,BorderLayout.CENTER);
				    g.add(P,BorderLayout.SOUTH);
					g.setVisible(true);
					
				}}
			   });
			B2=new JButton("CANCLE");
			B2.addActionListener(new ActionListener()
			        {
				public void actionPerformed(ActionEvent e)
				              {
					            F1.setVisible(false);
					            System.exit(0);
				              }});
			p2.add(B1);
			p2.add(B2);
			p2.setVisible(true);
			p1.setVisible(true);
			F1.pack();
			JLabel tit=new JLabel("Displaying record",JLabel.CENTER);
			tit.setFont(new Font("serif",Font.ITALIC,40));
			F1.add(tit,BorderLayout.NORTH);
			F1.add(p1,BorderLayout.CENTER);
			F1.add(p2,BorderLayout.SOUTH);
			F1.setVisible(true);
		}
		else if(e.getActionCommand()=="ADD")
		{        
			try {pins=con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");}
			catch (SQLException e1)
			{alert(e1,"sqle");}
		    try{F1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Sowrabh\\Pictures\\Backgrounds Wallpapers HD\\jntupic4.jpg")))));}
		    catch(IOException i)
		    {  alert(i,"ioe");}
			F1.setVisible(true);
			JPanel inP=new JPanel();
			inP.setOpaque(false);
			JPanel miP=new JPanel();
			miP.setOpaque(false);
		//	JPanel ta=new JPanel();
			JPanel p= new JPanel();
			p.setOpaque(false);
			F1.setSize(500,500);
			F1.setLayout(new BorderLayout());
			inP.setLayout(new GridLayout(9,2));
			inP.setFont(new Font("Serif", Font.BOLD, 20));
			miP.setLayout(new GridBagLayout());
			JLabel tit=new JLabel("ADDING A RECORD",JLabel.CENTER);
			tit.setFont(new Font("Serif", Font.BOLD, 40));
			tit.setOpaque(false);
			JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
			JButton sbm,back;
			sbm=new JButton("SUBMIT");
			sbm.addActionListener(new ActionListener()
            {
 	     		public void actionPerformed(ActionEvent e)
 	     			{
 	     			 		
 	   			     try{
 	   			        pins.setString(1,t1.getText());
 	   			        pins.setString(2,t2.getText());
 	   			        pins.setString(3,t3.getText());
 	   			        pins.setInt(4,Integer.parseInt(t5.getText()));
 	   		    	    pins.setInt(5,Integer.parseInt(t6.getText()));
 	   		            pins.setString(6,t7.getText());
 	   		            pins.setString(7,t8.getText());
 	   		            pins.executeUpdate();
 	   		            con.commit(); 	   		            
 	   		            }
 	   			      catch(SQLException s)
 	   			        {F1.setVisible(false);alert(s,"sqle");}
 	   			      catch(NumberFormatException n)
 	   			        {F1.setVisible(false);alert(n,"nfe"); }
 	   			      catch(Exception E)
 	   			      { F1.setVisible(false);
 	   			    	  alert(E,"e");}
 	   			     finally
 	   			     {  try {
						pins.close();con.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						alert(e1,"sqle");
					}}
 	   			       
 	   			     if(count!=0)
 	   			     {
 	   			     F1.setVisible(false);
 	   			     alert=new JFrame("alert");
 	   			     try {alert.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Sowrabh\\Pictures\\Backgrounds Wallpapers HD\\jntupic6.jpg")))));}
 	   			     catch (IOException e1) {alert(e1,"ioe");}
		             alert.setLayout(new BorderLayout());
		             alert.pack();
		             altm1=new JLabel(" ",JLabel.CENTER);
	                 altm1.setFont(new Font("Serif", Font.BOLD, 30));
	                 altp= new JPanel();
	                 altp.setLayout(new FlowLayout(FlowLayout.CENTER));
	                 altp.setOpaque(false);
	                 ok=new JButton("ok");
		             ok.addActionListener(new ActionListener()
		                      {
			                    public void actionPerformed(ActionEvent e)
			                    {
			                    	alert.setVisible(false);
			                    	f.setVisible(true);
			                    	
			                    }
		                      });
		              cl=new JButton("Cancle");
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
 	                   altm1.setText("inserted into database");
 					   alert.add(altm1,BorderLayout.CENTER);
 					   alert.add(altp,BorderLayout.SOUTH);
 					   alert.setVisible(true);
 	   			     }
                        
 	 
 	     			}
             }
         );; 
			back=new JButton("BACK");
			back.addActionListener(new ActionListener()
               {
 	     		     public void actionPerformed(ActionEvent e)
 	     			     {
 	     			       F1.setVisible(false);
 	   			           f.setVisible(true);
 					     }
               }
         );; 
			back.addActionListener(this);
			l1=new JLabel("Name       :");
			l3=new JLabel("FathersName:");
			l2=new JLabel("Surame     :");
			l4=new JLabel("HomeAdress :");
			l5=new JLabel("Phone      :");
			l6=new JLabel("Fax        :");
			l7=new JLabel("Email      :");
			l8=new JLabel("DateOfBirth:");
			l9=new JLabel("Nationality:");
			t1=new TextField(20);
			t2=new TextField(20);
			t3=new TextField(20);
			t5=new TextField(20);
			t6=new TextField(20);
			t7=new TextField(20);
			t8=new TextField(20);
			t9=new TextField(20);
			inP.add(l1);
			inP.add(t1);
			inP.add(l2);
			inP.add(t2);
			inP.add(l3);
			inP.add(t3);
			inP.add(l5);
			inP.add(t5);
			inP.add(l6);
			inP.add(t6);
			inP.add(l7);
			inP.add(t7);
			inP.add(l8);
			inP.add(t8);
			miP.add(inP);
			p.add(sbm);
			p.add(back);
			F1.pack();
			F1.add(tit,BorderLayout.NORTH);
			//F1.add(p1,BorderLayout.CENTER);	
			F1.add(miP,BorderLayout.CENTER);
			F1.add(p,BorderLayout.SOUTH);	
		}
		else if(e.getActionCommand()=="DELETE")
		{   
			try { pdel=con.prepareStatement("delete from student where name=?");}
	     	catch (SQLException e1){alert(e1,"sqle");}
			F1=new JFrame("DELETE");
			pas=new JPasswordField(20);
			pas.setFont(new Font("Serif", Font.ITALIC,25));
			p1=new JPanel();
			try {
				F1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Sowrabh\\Pictures\\Backgrounds Wallpapers HD\\jntupic6.jpg")))));
			} catch (IOException e1) {}
			F1.pack();
			F1.setLayout(new BorderLayout());
			F1.setResizable(false);		
			F1.setVisible(true);
			name =new JLabel("DELETING RECORD",JLabel.CENTER);
			name.setFont(new Font("Serif", Font.BOLD, 40));
			p1.setLayout(new FlowLayout());						
			JLabel pass=new JLabel("enter password");
			//JLabel name=new JLable("");
			pass.setLabelFor(pas);pass.setFont(new Font("Serif", Font.ITALIC, 25));
			p1.add(pass);
			p1.add(pas);
			p1.setOpaque(false);
			 JPanel p2 = new JPanel(new FlowLayout());
		        JButton ok = new JButton("OK");
		        JButton cl = new JButton("Back");
		        p2.add(ok);
		          ok.addActionListener(new ActionListener()
		                                {
		        	                      public void actionPerformed(ActionEvent e)
		        	                      {
		        	                    	  F1.setVisible(false);
		        	                    	  System.out.println(Password);
		        	                    	  String temp = new String(pas.getPassword());
		        	                    	  if(temp.equals(Password))
		        	                    	  System.out.println(temp);
                                                 if(temp.equals(Password))
                                                {                                                	
		        	                    	  k=new JFrame("deleting rec");
		        	                    	  JLabel sn=new JLabel("Student name :");
		        	              			try {k.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Sowrabh\\Pictures\\Backgrounds Wallpapers HD\\jntupic5.jpg")))));}
		        	              			catch (IOException e1){alert(e1,"ioe");}
		        	              			k.setLayout(new BorderLayout());
		        	              			p1=new JPanel();
		        	              			p3=new JPanel();
		        	              			p1.setLayout(new FlowLayout());
		        	              			p1.setFont(new Font("serif",Font.BOLD,30));
		        	              			//F2.setSize(800,200);
		        	              			p3.setLayout(new FlowLayout());		        	
		        	              			t1=new TextField(20);
		        	              			p1.add(sn);
		        	              			p1.add(t1);
		        	              			p1.setOpaque(false);
		        	              			p3.setOpaque(false);
		        	              			B1=new JButton("SUBMIT");
		        	              			B1.addActionListener(new ActionListener()
		        	              			   {
		        	              				private int i;

												public void actionPerformed(ActionEvent e)
		        	              				{   
		        	              					k.setVisible(false);
		        	              					try {pdis.setString(1,t1.getText());
		        	              					i=pdis.executeUpdate();} 
		        	              					catch (SQLException e1) 
		        	              					{alert(e1,"sqle");count=0;}
		        	              		             if(i !=0)
		        	              		             {
		        	              					   g=new JFrame("RESULT");
		        	              					   g.setLayout(new BorderLayout());
		        	              				       JLabel P4=new JLabel("DONE");
		        	              					   JButton ok=new JButton("ok");
		        	              					   ok.addActionListener(new ActionListener()
		        	              		                     {
		        	              			                   public void actionPerformed(ActionEvent e)
		        	              				                 {
		        	              						           g.setVisible(false);
		        	              						           f.setVisible(true);					                	 
		        	              						          }
		        	              					          });
		        	              					   JButton cl=new JButton("cancle");
		        	              					   cl.addActionListener(new ActionListener()
		        	                                          {
		        	              	                            public void actionPerformed(ActionEvent e)
		        	              	                               {
		        	              	                	             g.setVisible(false);
		        	              	                	             System.exit(0);					                	 
		        	              	                               }
		        	                                          });
		        	              					   p.setFont(new Font("jokerman",Font.BOLD,20));
		        	              					   P.add(ok);
		        	              					   P.add(cl);
		        	              					try {g.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Sowrabh\\Pictures\\Backgrounds Wallpapers HD\\jntupic7.jpg")))));}
		        	              					catch (IOException e1){alert(e1,"ioe");}
		        	              					   g.pack();
		        	              				       am=new JLabel("DELETED");
		        	              					   am.setFont(new Font("jokerman",Font.BOLD,20));
		        	              					/*try {
		        	              						while(rs.next())
		        	              						{
		        	              						 Ta.setText("NAME \t:"+rs.getString(1)+"\nSURNAME \t:"+rs.getString(2)+"\nFATHER NAME \t:"+rs.getString(3)+" \nPHONE \t:"+rs.getInt(4)+"\nFAX \t"+rs.getInt(5)+"\nEmail \t:"+rs.getString(6)+"\nDOFB \t:"+rs.getString(7));}
		        	              					} catch (SQLException e1)
		        	              					   {alert(e1,"sqle");*/
		        	              					   System.out.println("hi");
		        	              					   g.add(am,BorderLayout.CENTER);
		        	              				       g.add(P,BorderLayout.SOUTH);
		        	              					   g.setVisible(true);
		        	              		             }
		        	              		             else
		        	              		             {
		        	              		            	 g=new JFrame("sorry");
		        	              		            	try {g.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Sowrabh\\Pictures\\Backgrounds Wallpapers HD\\jntupic7.jpg")))));}
			        	              					catch (IOException e1){alert(e1,"ioe");}
			        	              					   g.pack();
			        	              					 p1=new JPanel();
			        	              					 p1.setLayout(new FlowLayout());
		        	              		            	 JLabel h= new JLabel("INVALID NAME");
		                                                 g.setLayout(new BorderLayout());
		                                                 JButton ok=new JButton("back");
			        	              					   ok.addActionListener(new ActionListener()
			        	              		                     {
			        	              			                   public void actionPerformed(ActionEvent e)
			        	              				                 {
			        	              						           g.setVisible(false);
			        	              						           k.setVisible(true);					                	 
			        	              						          }
			        	              					          });
		                                                 
		                                                 JButton cl=new JButton("cancle");
			        	              					   cl.addActionListener(new ActionListener()
			        	                                          {
			        	              	                            public void actionPerformed(ActionEvent e)
			        	              	                               {
			        	              	                	             g.setVisible(false);
			        	              	                	             System.exit(0);					                	 
			        	              	                               }
			        	                                          });
			        	              					   p1.add(ok);
			        	              					   p1.add(cl);
			        	              					   p1.setOpaque(false);
			        	              				g.add(p1,BorderLayout.SOUTH);
			        	              				g.add(h,BorderLayout.CENTER);
		        	              		            g.setVisible(true);	 
		        	              		             }
		        	              				
		        	              				}
												
		        	              			   });
		        	              			B2=new JButton("CANCLE");
		        	              			B2.addActionListener(new ActionListener()
		        	              			        {
		        	              				public void actionPerformed(ActionEvent e)
		        	              				              {
		        	              					            F1.setVisible(false);
		        	              					            System.exit(0);
		        	              				              }});
		        	              			p3.add(B1);
		        	              			p3.add(B2);
		        	              			p3.setVisible(true);
		        	              			p1.setVisible(true);
		        	              			F1.pack();
		        	              			JLabel tit=new JLabel("Displaying record",JLabel.CENTER);
		        	              			tit.setFont(new Font("serif",Font.ITALIC,40));
		        	              			F1.add(tit,BorderLayout.NORTH);
		        	              			F1.add(p1,BorderLayout.CENTER);
		        	              			F1.add(p3,BorderLayout.SOUTH);
		        	              			F1.setVisible(true);
		        	                    	  		        	                                            	  
		        	                      }  
                                                else
                                                {
                                                	k=new JFrame("SORRY");
	        	              		            	try {k.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Sowrabh\\Pictures\\Backgrounds Wallpapers HD\\jntupic7.jpg")))));}
		        	              					catch (IOException e1){alert(e1,"ioe");}
		        	              					   k.pack();
		        	              					 p1=new JPanel();
		        	              					 p1.setLayout(new FlowLayout());
	        	              		            	 JLabel h=new JLabel("invalid password");
	                                                 k.setLayout(new BorderLayout());
	                                                 JButton ok=new JButton("back");
		        	              					   ok.addActionListener(new ActionListener()
		        	              		                     {
		        	              			                   public void actionPerformed(ActionEvent e)
		        	              				                 {
		        	              						           k.setVisible(false);
		        	              						           F1.setVisible(true);					                	 
		        	              						          }
		        	              					          });
	                                                 
	                                                 JButton cl=new JButton("cancle");
		        	              					   cl.addActionListener(new ActionListener()
		        	                                          {
		        	              	                            public void actionPerformed(ActionEvent e)
		        	              	                               {
		        	              	                	             k.setVisible(false);
		        	              	                	             System.exit(0);					                	 
		        	              	                               }
		        	                                          });
		        	              					   p1.add(ok);
		        	              					   p1.add(cl);
		        	              					   p1.setOpaque(false);
		        	              				k.add(p1,BorderLayout.SOUTH);
		        	              				k.add(h,BorderLayout.CENTER);
	        	              		            k.setVisible(true);	 
                                                }
                                       }   
		                                });
		        p2.add(cl);
		        cl.addActionListener(new ActionListener()
                                   {
                                       public void actionPerformed(ActionEvent e)
                                         {
                	                        F1.setVisible(false);
                	                        f.setVisible(true);
                                         }     
                                    });
		        p2.setOpaque(false);
		        F1.add(p1,BorderLayout.CENTER);
		        F1.add(name,BorderLayout.NORTH);
		        F1.add(p2,BorderLayout.SOUTH);
			
		}
	 
	 }
	
  }
  
	
  