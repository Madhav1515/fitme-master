
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException;

public class bmi extends javax.swing.JFrame {

	private static double height;

	bmi() {
		JFrame f = new JFrame();

		JLabel lb1 = new JLabel("Height(Inches):");
		lb1.setBounds(20, 20, 100, 50);
		lb1.setForeground(Color.white);
		lb1.setFont(new Font("Leelawade",Font.BOLD,14));
		f.add(lb1);

		JLabel lb2 = new JLabel("Weight(Pounds):");
		lb2.setBounds(20, 60, 100, 40);
		lb2.setForeground(Color.white);
		lb2.setFont(new Font("Leelawade",Font.BOLD,14));
		f.add(lb2);

		JLabel lbResult = new JLabel("");
		lbResult.setBounds(20, 90, 300, 40);
		f.add(lbResult);
		lbResult.setFont(new Font("Leelawade",Font.BOLD,14));

		JTextField txtHeight = new JTextField("");
		txtHeight.setBounds(150, 20, 200, 40);
		f.add(txtHeight);

		JTextField txtWeight = new JTextField("");
		txtWeight.setBounds(150, 60, 200, 40);
		f.add(txtWeight);

		JButton btn = new JButton("Calculate BMI");
		btn.setBounds(20, 130, 300, 40);
		
		f.getContentPane().setBackground(Color.black);

		// Event
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				double weight = Double.parseDouble(txtWeight.getText());
				double height = Double.parseDouble(txtHeight.getText());

				double bmi = weight / Math.pow(height, 2) * 703;

				if (bmi < 18.5) {
					lbResult.setForeground(Color.yellow);
					lbResult.setText("Underweight - BMI : " + bmi);
				} else if (bmi < 25) {
					lbResult.setForeground(Color.green);
					lbResult.setText("Normal - BMI : " + bmi);
				} else if (bmi < 30) {
					lbResult.setForeground(Color.orange);
					lbResult.setText("Overweight - BMI : " + bmi);
				} else {
					lbResult.setForeground(Color.red);
					lbResult.setText("Obese - BMI : " + bmi);
				}
				String sh = Double.toString(height);
				String sw = Double.toString(weight);
				String sbmi = Double.toString(bmi);
				String result = lbResult.getText();
				try {
					FileWriter myWriter = new FileWriter("C:/FitMe/bmi.txt");
					myWriter.write("\nHeight:\t\t" + height);
					myWriter.write("\nWeight:\t\t" + weight);
					myWriter.write("\nBMI :\t\t" + bmi);
					myWriter.write("\n\t\tRESULT:\t\t" + result);
					myWriter.close();
				} catch (IOException ex) {
					System.out.println("An error occurred.");
					ex.printStackTrace();
				}
			}
		});

		f.add(btn);

		f.setSize(400, 300);
		f.setLayout(null);
		f.setVisible(true);

	}

	public static void main(String[] args) {
		new bmi();

	}
}
