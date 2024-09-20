import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.util.*;

public class diet implements ActionListener {

	// private static final long serialVersionUID = 1L;
	JFrame frame;
	private JRadioButton Male;
	private JRadioButton Female;

	private JButton button;
	private ButtonGroup buttonGroup;
	
	
	public void paelo() {
		System.out.println("\t\t\t\tPAELO DIET\n\n");
		System.out.println("\tFood\t[1]Fishes\t[2]Meat\t[3]Eggs\t[4]Nuts");
		System.out.println("\n\t** Avoid**\t\t[1]Sugar\t[2]Processed food\t[3]Soft drinks\t[4]Dairy Products");
	}
	public void Vegan() {
		System.out.println("\t\t\t\tVEGAN DIET\n\n");
		System.out.println("\tFood\t[1]high-fat dairy[2]healthy oils\t[3]tubers\t[4]Non-Glueten Grains");
		System.out.println("\n\t** Avoid **\t\t[1]HFCS\t[2]Sugar\t[3]seed oils\t[4]trans fats");
	}
	

	public diet() {

		frame = new JFrame();

		// Display the window.

		frame.pack();

		frame.setVisible(true);
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set flow layout for the frame
		frame.setLayout(new FlowLayout());

		Male = new JRadioButton("Male");
		Male.setActionCommand("Male");

		Female = new JRadioButton("Female");
		Female.setActionCommand("Female");

		button = new JButton("Check");

		button.addActionListener(this);

		buttonGroup = new ButtonGroup();

		// add radio buttons
		buttonGroup.add(Male);
		buttonGroup.add(Female);

		frame.add(Male);
		frame.add(Female);

		frame.add(button);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Check")) {
			Scanner sc = new Scanner(System.in);
			String s = buttonGroup.getSelection().getActionCommand();
			if (s == "Male") {
				Frame f = new Frame();
				System.out.println("\n\nEnter Your Age\n\n");
				int age = sc.nextInt();
				double bmr = (66.47 + (13.75 * 54) + (5.003 * 161.544) - (6.755 * age));
				double Cal = bmr * 1.2;
				System.out.println("\n\n\tHEY! CALORIES PER DAY FOR YOU ARE :" + Cal);
				//file operation
				try {
					FileWriter myWriter = new FileWriter("C:/FitMe/diet.txt");
					myWriter.write("CALORIES:"+Cal);
					myWriter.close();
				} catch (IOException ex) {
					System.out.println("An error occurred.");
					ex.printStackTrace();
				}

			} else {
				System.out.println("\n\nEnter Your Age\n");
				int age = sc.nextInt();
				double bmr = (655.1 + (9.563 * 54) + (1.85 * 161.544) - (4.676 * age));
				double Cal = bmr * 1.2;
				System.out.println("\n\n\tHEY! CALORIES PER DAY FOR YOU ARE :" + Cal);
				
				//file operation
				try {
					FileWriter myWriter = new FileWriter("C:/FitMe/diet.txt");
					myWriter.write("CALORIES:"+Cal);
					myWriter.close();
				} catch (IOException ex) {
					System.out.println("An error occurred.");
					ex.printStackTrace();
				}
			}
			
			
			System.out.println("\t\tCHOOSE YOUR DIET PLAN");
			System.out.println("\n\t\t[1]PAELO DIET");
			System.out.println("\n\t\t[2]VEGAN DIET\n");
			int ch1=sc.nextInt();
			switch(ch1)
			{
			case 1: paelo();
					
					try {
						FileWriter myWriter = new FileWriter("C:/FitMe/diet.txt");
						myWriter.write("Paelo Diet");
						myWriter.write("\nFood\n[1]Fishes[2]Meat[3]Eggs[4]Nuts");
						myWriter.write("** Avoid**[1]Sugar[2]Processed food[3]Soft drinks[4]Dairy Products");
						myWriter.close();
					} catch (IOException ex) {
						System.out.println("An error occurred.");
						ex.printStackTrace();
					}
					
					break;
			case 2:
					Vegan();
					try {
						FileWriter myWriter = new FileWriter("C:/FitMe/diet.txt");
						myWriter.write("Vegan Diet");
						myWriter.write("\nFood\n[1]high-fat dairy[2]healthy oils[3]tubers[4]Non-Glueten Grains");
						myWriter.write("** Avoid **[1]HFCS[2]Sugar[3]seed oils[4]trans fats");
						myWriter.close();
					} catch (IOException ex) {
						System.out.println("An error occurred.");
						ex.printStackTrace();
					}
					break;
			default:
					break;
			}
		}
	}

	public static void main(String[] args) {

		diet obj = new diet();

	}
}