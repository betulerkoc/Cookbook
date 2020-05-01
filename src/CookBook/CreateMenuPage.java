package CookBook;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateMenuPage extends JFrame{
	
	public CreateMenuPage() {
		getContentPane().setBackground(new Color(255, 222, 173));
		setTitle("Cook-Book");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(703, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		TitledBorder titleStarter = new TitledBorder("Starter:");
		JTextArea textAreaStarter = new JTextArea();
		textAreaStarter.setBounds(131, 81, 138, 218);
		getContentPane().add(textAreaStarter);
		textAreaStarter.setBorder(titleStarter);
		
		TitledBorder titleDessert = new TitledBorder("Dessert:");
		JTextArea textAreaDessert = new JTextArea();
		textAreaDessert.setBounds(501, 81, 138, 218);
		getContentPane().add(textAreaDessert);
		textAreaDessert.setBorder(titleDessert);
		
		TitledBorder titleMain = new TitledBorder("Main Meal:");
		JTextArea textAreaMain = new JTextArea();
		textAreaMain.setBounds(321, 81, 138, 218);
		getContentPane().add(textAreaMain);
		textAreaMain.setBorder(titleMain);
		
		JButton btnChangeStarter = new JButton("Change it");
		btnChangeStarter.setBackground(new Color(255, 250, 205));
		btnChangeStarter.setBounds(141, 49, 115, 29);
		getContentPane().add(btnChangeStarter);
		
		JButton btnChangeDessert = new JButton("Change it");
		btnChangeDessert.setBackground(new Color(255, 250, 205));
		btnChangeDessert.setBounds(511, 49, 115, 29);
		getContentPane().add(btnChangeDessert);
		
		JButton btnChangeMain = new JButton("Change it");
		btnChangeMain.setBackground(new Color(255, 250, 205));
		btnChangeMain.setBounds(331, 49, 115, 29);
		getContentPane().add(btnChangeMain);
		
		LikedLinkedList likedRecipe = new LikedLinkedList();
		JButton btnLikeStarter = new JButton("Like ");
		btnLikeStarter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnLikeStarter.setBackground(new Color(240, 255, 240));
		btnLikeStarter.setBounds(141, 299, 115, 29);
		getContentPane().add(btnLikeStarter);
		
		JButton btnLikeMain = new JButton("Like ");
		btnLikeMain.setBackground(new Color(240, 255, 240));
		btnLikeMain.setBounds(331, 299, 115, 29);
		getContentPane().add(btnLikeMain);
		
		JButton btnLikeDessert = new JButton("Like ");
		btnLikeDessert.setBackground(new Color(240, 255, 240));
		btnLikeDessert.setBounds(511, 299, 115, 29);
		getContentPane().add(btnLikeDessert);
		
		JLabel lblCreateTodaysMenu = new JLabel("Create Today's Menu!");
		lblCreateTodaysMenu.setFont(new Font("Consolas", Font.BOLD, 22));
		lblCreateTodaysMenu.setBounds(240, 16, 257, 20);
		getContentPane().add(lblCreateTodaysMenu);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePage welcomeWindow = new WelcomePage();
				setVisible(false);
				welcomeWindow.setVisible(true);
			}
		});
		btnGoBack.setBounds(11, 16, 115, 51);
		getContentPane().add(btnGoBack);
		
		
		
		
		
	    
	    
	    
	}
}
