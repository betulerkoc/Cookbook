package CookBook;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WelcomePage extends JFrame {
	
	WelcomePage(){
		getContentPane().setBackground(new Color(255, 222, 173));
		
		setTitle("Cook-Book");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JButton btnCreateTodaysMenu = new JButton("Create Today's Menu");
		btnCreateTodaysMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateMenuPage createMenuWindow = new CreateMenuPage();
			}
		});
		btnCreateTodaysMenu.setBackground(new Color(176, 224, 230));
		btnCreateTodaysMenu.setBounds(162, 113, 288, 45);
		getContentPane().add(btnCreateTodaysMenu);
		
		JButton btnGoToLiked = new JButton("Go To Liked List");
		btnGoToLiked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LikedRecipePage likedRecipeWindow = new LikedRecipePage();
			}
		});
		btnGoToLiked.setBackground(new Color(176, 224, 230));
		btnGoToLiked.setBounds(162, 196, 288, 45);
		getContentPane().add(btnGoToLiked);
		
		JButton btnAddNewRecipe = new JButton("Add New Recipe");
		btnAddNewRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddRecipePage addRecipeWindow = new AddRecipePage();
			}
		});
		btnAddNewRecipe.setBackground(new Color(176, 224, 230));
		btnAddNewRecipe.setBounds(162, 272, 288, 45);
		getContentPane().add(btnAddNewRecipe);
		
		JLabel lblWelcomeToCookbook = new JLabel("Welcome To CookBook!");
		lblWelcomeToCookbook.setFont(new Font("Consolas", Font.PLAIN, 28));
		lblWelcomeToCookbook.setBounds(160, 45, 326, 34);
		getContentPane().add(lblWelcomeToCookbook);
		

	}

}
