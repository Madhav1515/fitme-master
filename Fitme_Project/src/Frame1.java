import javax.swing.*;
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Frame1 implements ActionListener {
	Frame frame;
	ResultSet rs=null;
	Button b1, b2;
	TextField tname, tpass1, temail, theight, tweight;
	TextArea taddr;
	Label title, name, email, gender, addr, pass1, height, weight;
	CheckboxGroup gen;
	Checkbox male, female;

	public Frame1() {
		frame = new Frame("REGISRATION FORM ");
		frame.setVisible(true);
		frame.setSize(900, 900);
		

		// Labels
		title = new Label("REGISTRATION FORM");
		name = new Label("Full Name :");
		pass1 = new Label("Password :");
		email = new Label("Email :");
		height = new Label("Height");
		weight = new Label("Weight");
		addr = new Label("Address :");
		gender = new Label("Gender :");

		// TextFields
		tname = new TextField(30);
		tpass1 = new TextField(20);
		temail = new TextField(20);
		tweight = new TextField(20);
		theight = new TextField(20);
		taddr = new TextArea();
		b1 = new Button("Submit");
		b2 = new Button("Close");
		gen = new CheckboxGroup();
		male = new Checkbox("Male", gen, false);
		female = new Checkbox("Female", gen, false);

		frame.setLayout(null);
		title.setBounds(150, 50, 280, 25);
		name.setBounds(30, 90, 140, 25);
		tname.setBounds(170, 90, 280, 30);
		pass1.setBounds(30, 130, 140, 25);
		tpass1.setBounds(170, 130, 280, 30);
		email.setBounds(30, 180, 100, 25);
		temail.setBounds(170, 180, 230, 30);
		height.setBounds(30, 235, 140, 30);
		theight.setBounds(170, 235, 230, 30);
		weight.setBounds(30, 280, 140, 30);
		tweight.setBounds(170, 280, 230, 30);
		addr.setBounds(30, 330, 120, 25);
		taddr.setBounds(170, 330, 260, 50);
		gender.setBounds(30, 400, 120, 25);
		male.setBounds(170, 400, 80, 25);
		female.setBounds(290, 400, 100, 25);
		b1.setBounds(170, 480, 80, 30);
		b2.setBounds(280, 480, 80, 30);

		// Changing Fonts

		title.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		name.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		tname.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		pass1.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		tpass1.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		email.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		height.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		theight.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		weight.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		tweight.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		temail.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		addr.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		taddr.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		gender.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		male.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		female.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		b1.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		b2.setFont(new Font("TimesRoman", Font.PLAIN, 24));

		// adding elements
		frame.add(title);
		frame.add(name);
		frame.add(tname);
		frame.add(pass1);
		frame.add(tpass1);
		frame.add(email);
		frame.add(temail);
		frame.add(height);
		frame.add(theight);
		frame.add(weight);
		frame.add(tweight);
		frame.add(addr);
		frame.add(taddr);
		frame.add(gender);
		frame.add(male);
		frame.add(female);
		frame.add(b1);
		frame.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {

			

			/*String fullName = name.getText();
			String password = pass1.getText();
			String email1 = email.getText();
			String height1 = height.getText();
			String weight1 = weight.getText();
			String address = addr.getText();*/
			
			try {
				
				 
				 
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","ruqayya");
				Statement st=null; //=(PreparedStatement) connection.prepareStatement("insert into Registration values(?,?,?,?,?,?)");
				st=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				st.executeUpdate("insert into Registration values('" +tname.getText() +"','"+tpass1.getText()+"','"+temail.getText()+"','"+theight.getText()+"','"+tweight.getText()+"','"+taddr.getText()+"')");
				JOptionPane.showMessageDialog(b1, "Your Registration Is Successfull..");
				
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}

		
			new LoginForm();
            frame.dispose();
		}
		
		if(e.getSource() == b2)
		{
			frame.dispose();
		}

	}
    public void text()
    {
    	try
    	{
    		tname.setText(rs.getString(1));
			tpass1.setText(rs.getString(2));
			 temail.setText(rs.getString(3));
			 theight.setText(rs.getString(4));
			 tweight.setText(rs.getString(5));
			 taddr.setText(rs.getString(6));
			 
    	}
    	
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }
	public static void main(String args[]) {
		Frame1 f1 = new Frame1();
	}

}