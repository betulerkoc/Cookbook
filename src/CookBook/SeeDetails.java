package CookBook;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SeeDetails extends JFrame{
	public SeeDetails() {
		getContentPane().setBackground(new Color(255, 228, 181));
		setTitle("Cook-Book");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePage welcomeWindow = new WelcomePage();
				setVisible(false);
				welcomeWindow.setVisible(true);
			}
		});
		btnGoBack.setBounds(27, 72, 115, 47);
		getContentPane().add(btnGoBack);

	}
}
