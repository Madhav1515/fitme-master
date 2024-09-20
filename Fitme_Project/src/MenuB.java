import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuB extends JFrame
{
	JMenuBar menuBar;
	JMenu bmi,diet,exercise,report,refrences,exit;
	JMenu Admin;
	private ImageIcon img;
	private JLabel l1;
   public MenuB() {
      JFrame frame = new JFrame("Fit-Me");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      menuBar = new JMenuBar();
      menuBar.setLayout(new GridLayout(0,1));
      frame.getContentPane().setBackground(Color.black);
      img=new ImageIcon(getClass().getResource("fitme.jpeg"));
		l1=new JLabel(img);
		l1.setBounds(50,180,220,220);
		frame.add(l1);
      
      bmi = new JMenu("BMI");
      bmi.setMnemonic(KeyEvent.VK_S);
      menuBar.add(bmi);
      JMenuItem seeBmi = new JMenuItem("CHECK YOUR BMI", KeyEvent.VK_N);
      bmi.add(seeBmi);
      
      diet = new JMenu("DIET");
      diet.setMnemonic(KeyEvent.VK_R);
      menuBar.add(diet);
      JMenuItem seeDiet = new JMenuItem("CHECK YOUR DIET", KeyEvent.VK_N);
      diet.add(seeDiet);
      
      exercise = new JMenu("EXERCICSE");
      exercise.setMnemonic(KeyEvent.VK_A);
      menuBar.add(exercise);
      JMenuItem seeExer = new JMenuItem("CHECK YOUR EXERCISE", KeyEvent.VK_N);
      exercise.add(seeExer);
      
      report = new JMenu("REPORT");
      report.setMnemonic(KeyEvent.VK_R);
      menuBar.add(report);
      JMenuItem seeRep = new JMenuItem("CHECK YOUR REPORT OF BMI ", KeyEvent.VK_N);
      JMenuItem seeexe = new JMenuItem("CHECK YOUR REPORT OF EXERCISE", KeyEvent.VK_N);
      JMenuItem seediet = new JMenuItem("CHECK YOUR REPORT OF DIET", KeyEvent.VK_N);
      report.add(seeRep);
      report.add(seeexe);
      report.add(seediet);
      
      refrences = new JMenu("REFRENCES");
      refrences.setMnemonic(KeyEvent.VK_R);
      menuBar.add(refrences);
      JMenuItem seeRef = new JMenuItem("CHECK REFRENCES", KeyEvent.VK_N);
      refrences.add(seeRef);
      
      exit = new JMenu("EXIT");
      exit.setMnemonic(KeyEvent.VK_R);
      menuBar.add(exit);
      JMenuItem exit1 = new JMenuItem("EXIT", KeyEvent.VK_N);
      exit.add(exit1);
      
      Admin = new JMenu("ADMIN");
      Admin.setMnemonic(KeyEvent.VK_S);
      menuBar.add(Admin);
      JMenuItem allUser = new JMenuItem("CHECK ALL USER", KeyEvent.VK_N);
      Admin.add(allUser);
      JMenuItem removeUser = new JMenuItem("REMOVE ANY USER", KeyEvent.VK_N);
      Admin.add(removeUser);
      
      seeBmi.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("");
			new bmi();
			
		}
  
	  });
      
      seeDiet.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("");
			new diet();
			
		}
  
	  });
      
      seeExer.addActionListener(new ActionListener()
    		  {

				@Override
				public void actionPerformed(ActionEvent e) {
					new exercise();
					
				}
    	  
    		  });
      
      seeexe.addActionListener(new ActionListener()
    		  {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
					new EXER1();
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
				}
    	  
    		  });
      seediet.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			new Diet1();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
  
	  });
      seeRep.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent e) {
			try
			{
			new bmi1();
			}
			catch(Exception m) {}
			
		}
  
	  });
      
      
      
      
      seeRef.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			new ref();
		}
  
	  });
      
      exit1.addActionListener(new ActionListener()
    		  {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
				}
    	  
    		  });
      
      
      allUser.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent e) {
			new DisplayAll();
		}
  
	  });
      
      removeUser.addActionListener(new ActionListener()
	  {

		@Override
		public void actionPerformed(ActionEvent e) {
			new  DeleteStatement();
			
		}
  
	  });
     
      menuBar.revalidate();
      frame.setJMenuBar(menuBar);
      frame.setSize(650, 450);
      frame.setVisible(true);
   }
   
   
public static void main(String Args[])
{
	MenuB mb=new MenuB();
}

}