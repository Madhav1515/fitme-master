import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class exercise implements ActionListener {

	public void Aerobic() {
		System.out.println("\t\t\t **AEROBIC EXERCISE**\n\n");
		System.out.println("\t\t\t[1]Walking");
		System.out.println("\n\t\t\t[2]Swimming");
		System.out.println("\n\t\t\t[3]Running");
		System.out.println("\n\t\t\t[4]Cycling");

	}

	public void Balance() {
		System.out.println("\t\t\t **BALANCE EXERCISE**\n\n");
		System.out.println("\t\t\t[1]Tai Chi");
		System.out.println("\n\t\t\t[2]Standing on one foot");
		System.out.println("\n\t\t\t[3]The heel-to-toe walk");
		System.out.println("\n\t\t\t[4]The balance walk");

	}

	public void Flexibility() {
		System.out.println("\t\t\t**FLEXIBILITY EXERCISE**\n\n");
		System.out.println("\t\t\t[1]The back stretch");
		System.out.println("\n\t\t\t[2]The inner thigh stretch");
		System.out.println("\n\t\t\t[3]The ankle stretch");
		System.out.println("\n\t\t\t[4]The back of leg stretch");

	}

	public void Strength() {
		System.out.println("\t\t\t **STRENGTH EXERCISE**\n\n");
		System.out.println("\t\t\t[1]Lifting Weights");
		System.out.println("\n\t\t\t[2]Carrying grocceries");
		System.out.println("\n\t\t\t[3]Arm Curls");
		System.out.println("\n\t\t\t[4]Wall push-ups");

	}

	String selectedCheckBox = "";

	JCheckBox checkBox1 = new JCheckBox("Cardio-vascular Disease ");
	JCheckBox checkBox2 = new JCheckBox("Respiratory Disease");
	JCheckBox checkBox3 = new JCheckBox("Pregancy");
	JCheckBox checkBox4 = new JCheckBox("Sore Muscles");

	JButton button = new JButton("Get selected Medical Conditions");

	public exercise() {

		JFrame frame = new JFrame("Select your Medical Condition");

		GridLayout gl = new GridLayout(5, 1);
		
		button.addActionListener(this);

		frame.setLayout(gl);

		frame.add(checkBox1);
		frame.add(checkBox2);
		frame.add(checkBox3);
		frame.add(checkBox4);

		frame.add(button);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 200);
		frame.setVisible(true);

		JLabel lbResult = new JLabel("");
		lbResult.setBounds(140, 180, 300, 40);
		frame.add(lbResult);
	}

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == button) {

			if (checkBox1.isSelected()) {
				selectedCheckBox = selectedCheckBox + checkBox1.getText() + "\n";

			}

			if (checkBox2.isSelected()) {
				selectedCheckBox = selectedCheckBox + checkBox2.getText() + "\n";

			}

			if (checkBox3.isSelected()) {
				selectedCheckBox = selectedCheckBox + checkBox3.getText() + "\n";

			}

			if (checkBox4.isSelected()) {
				selectedCheckBox = selectedCheckBox + checkBox4.getText() + "\n";

			}
			if (checkBox1.isSelected() || checkBox2.isSelected() || checkBox3.isSelected() || checkBox4.isSelected()) {
				System.out.println("\n\n!!CAUTION HEAVY EXERCISE MAY CAUSE ADVERSE EFFECT!!");
				Aerobic();
				try {
					FileWriter myWriter = new FileWriter("C:/FitMe/exercise.txt");
					myWriter.write("[1]Walking\n[2]Running\n[3]Swimming\n[4]Cycling");
					myWriter.close();
				} catch (IOException ex) {
					System.out.println("An error occurred.");
					ex.printStackTrace();
				}
			} else {
				System.out.println("\t\t\nChoose Your Exercise Type");
				System.out.println("\t\t\t[1]Aerobic Exercise");
				System.out.println("\t\t\t[2]Balance Exercise");
				System.out.println("\t\t\t[3]Flexibility Exercise");
				System.out.println("\t\t\t[4]Strength Exercise");
				Scanner sc = new Scanner(System.in);
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					Aerobic();
					try {
						FileWriter myWriter = new FileWriter("C:/FitMe/exercise.txt");
						myWriter.write("AEROBIC EXERCISE");
						myWriter.write("[1]Walking\n[2]Running\n[3]Swimming\n[4]Cycling");
						myWriter.close();
					} catch (IOException ex) {
						System.out.println("An error occurred.");
						ex.printStackTrace();
					}
					break;
				case 2:
					Balance();
					try {
						FileWriter myWriter = new FileWriter("C:/FitMe/exercise.txt");
						myWriter.write("BALANCE EXERCISE");
						myWriter.write("\n[1]Tai chi\n[2]Standing on one foot\n[3]The heel-to-toe\n[4]The balance walk");
						myWriter.close();
					} catch (IOException ex) {
						System.out.println("An error occurred.");
						ex.printStackTrace();
					}

					break;
				case 3:
					Flexibility();
					try {
						FileWriter myWriter = new FileWriter("C:/FitMe/exercise.txt");
						myWriter.write("FLEXIBILITY EXERCISE");
						myWriter.write("[1]The Back Streatch\n[2]Thigh streatch\n[3]The ankle stretch\n[4]The baalnce walk");
						myWriter.close();
					} catch (IOException ex) {
						System.out.println("An error occurred.");
						ex.printStackTrace();
					}
					break;
				case 4:
					Strength();
					try {
						FileWriter myWriter = new FileWriter("C:/FitMe/exercise.txt");
						myWriter.write("STRENGTH EXERCISE");
						myWriter.write("[1]Lifting weights\n[2]carrying Grocceries\n[3]Arm Curls\n[4]Wall Push-ups");
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
			JOptionPane.showMessageDialog(null, "Selected Medical Conditions are : \n" + selectedCheckBox);

			selectedCheckBox = new String("");
		}

	}

	public static void main(String[] args) {
		exercise ex = new exercise();
	}
}