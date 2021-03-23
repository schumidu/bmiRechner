package bmiRechner;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {
	JFrame frame;
	JPanel mainPanel;

	JButton berechnenButton;
	JLabel koerperGroesseLabel;
	JLabel gewichtLabel;
	JLabel ergebnisLabel;
	JLabel ergebnisAnzeigeLabel;
	JTextField koerperGroesseTextField;
	JTextField gewichtTextField;

	public GUI() {
		int width = 150;
		int height = 25;
		frame = new JFrame("BMI-Rechner");
		frame.setSize(500, 300);

		mainPanel = new JPanel();
		mainPanel.setLayout(null);

		berechnenButton = new JButton("Berechnen");
		koerperGroesseLabel = new JLabel("Deine Körpergröße(m): ");
		gewichtLabel = new JLabel("Dein Körpergewicht(kg): ");
		ergebnisLabel = new JLabel("Ergebnis: ");
		ergebnisAnzeigeLabel = new JLabel("Hier das Ergebnis");
		koerperGroesseTextField = new JTextField();// ("bb", 4);
		gewichtTextField = new JTextField();// ("bb", 3);

		mainPanel.add(berechnenButton);
		mainPanel.add(koerperGroesseLabel);
		mainPanel.add(gewichtLabel);
		mainPanel.add(ergebnisLabel);
		mainPanel.add(ergebnisAnzeigeLabel);
		mainPanel.add(koerperGroesseTextField);
		mainPanel.add(gewichtTextField);

		koerperGroesseLabel.setBounds(10, 10, width, height);
		koerperGroesseTextField.setBounds(2 * 10 + width, 10, width, height);

		gewichtLabel.setBounds(10, 2 * 10 + height, width, height);
		gewichtTextField.setBounds(2 * 10 + width, 2 * 10 + height, width, height);

		ergebnisLabel.setBounds(10, 3 * 10 + 2 * height, width, height);
		ergebnisAnzeigeLabel.setBounds(2 * 10 + width, 3 * 10 + 2 * height, width, height);

		berechnenButton.setBounds((2 * 10 + width) / 2, 4 * 10 + 3 * height, width, height);
		berechnenButton.addActionListener(this);

		// gewichtTextField.setForeground(Color.BLUE);
//		gewichtTextField.setBackground(Color.YELLOW);
		// ergebnisAnzeigeLabel.setOpaque(true);
		ergebnisAnzeigeLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
		// ergebnisAnzeigeLabel.setBackground(Color.BLUE);
		// ergebnisAnzeigeLabel.setForeground(Color.YELLOW);

		frame.add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean fehler = false;

		String gewichtS = gewichtTextField.getText();
		String groesseS = koerperGroesseTextField.getText();

		if (gewichtS == null) {
			JOptionPane.showMessageDialog(null, "Kein Gewicht eingegeben");
			fehler = true;
		}

		if (groesseS == null) {
			JOptionPane.showMessageDialog(null, "Kein Gewicht eingegeben");
			fehler = true;
		}
		Double gewichtD = 0.0;
		try {
			gewichtD = Double.valueOf(gewichtS);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Fehler in Gewichtseingabe");
			gewichtTextField.setText("");
			fehler = true;
		}

		Double groesseD = 0.0;
		try {
			groesseD = Double.valueOf(groesseS);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Fehler in Grösseneingabe");
			koerperGroesseTextField.setText("");
			fehler = true;
		}
		if(!fehler)
		ergebnisAnzeigeLabel.setText(Double.toString(BMI.calcBMI(gewichtD, groesseD)));

	}

}
