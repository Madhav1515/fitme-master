import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.applet.Applet;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginForm extends JFrame implements ActionListener
{
	private ImageIcon img;
	private JLabel l1;
	static String user_name;
	static String pass_word;
	static JLabel nameLabel,passLabel,success;
    static JTextField text1,text2;
    static JButton button,button1;
    static JPasswordField pass;
    JFrame jf;
    JPanel jp;
	public LoginForm()
	{
		jf=new JFrame("Fit-Me");
		//jf.setBackground(Color.cyan);
		jp=new JPanel();
		jp.setBackground(Color.black);
		jf.setSize(500,500);
	
		
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.add(jp);
		
		jp.setLayout(null);
		
		img=new ImageIcon(getClass().getResource("fitme.jpeg"));
		l1=new JLabel(img);
		l1.setBounds(50,180,220,220);
		jp.add(l1);
		
		nameLabel=new JLabel("USERNAME");
		nameLabel.setBounds(10,20,85,30);
		nameLabel.setForeground(Color.white);
		jp.add(nameLabel);
		nameLabel.setFont(new Font("Leelawade",Font.BOLD,12));
		
		text1 = new JTextField();
		text1.setBounds(100,20,165,25);
		jp.add(text1);
		text1.setFont(new Font("TimesRoman",Font.BOLD,12));
		//text1.setEchoChar('*');
		
		pass = new JPasswordField(8);
		pass.setBounds(100,50,165,25);
	
		jp.add(pass);
		pass.setFont(new Font("TimesRoman",Font.BOLD,12));
		
	    passLabel=new JLabel("PASSWORD");
		passLabel.setBounds(10,50,80,25);
		jp.add(passLabel);
		passLabel.setFont(new Font("Leelawade",Font.BOLD,12));
		passLabel.setForeground(Color.white);
		
		
		button = new JButton("LOGIN");
		button.setBounds(10,90,80,35);
		jp.add(button);
		button.setFont(new Font("Leelawade",Font.BOLD,12));
		
		button1 = new JButton("NEW USER");
		button1.setBounds(120,90,120,35);
		jp.add(button1);
		button.setFont(new Font("Leelawade",Font.BOLD,12));
		
		success = new JLabel("");
		success.setBounds(10,110,300,25);
		jp.add(success);
		success.setFont(new Font("TimesRoman",Font.BOLD,12));
		
		button.addActionListener(this);
		button1.addActionListener(this);
		
		jf.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==button)
		{
		
		try {
			String user = text1.getText();
			user_name=user;
			
			String password = pass.getText();
			pass_word=password;

			
			Connection connection = DriverManager.getConnection("jdbc:mysql:thin:@localhost:1521:xe", "system","abhii");
			//System.out.println("Connection...");
			PreparedStatement st = connection.prepareStatement("Select fullName, password from Registration where fullName=? and password=?");

			st.setString(1, user);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				
				JOptionPane.showMessageDialog(button, "You have successfully logged in");
				new MenuB();
				jf.dispose();
			} else {
				JOptionPane.showMessageDialog(button, "Wrong Username & Password");
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		}
		
		if(e.getSource()==button1)
		{
			
			new Frame1();
			
			}
		
	}
	
	public static void main(String Args[])
	{
		LoginForm lf=new LoginForm();
	}
}



