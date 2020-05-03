package CookBook;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LikedRecipePage extends JFrame{
	
	public LikedRecipePage() {
	getContentPane().setBackground(new Color(255, 228, 181));
	setTitle("Cook-Book");
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(650, 400);
	setLocationRelativeTo(null);
	getContentPane().setLayout(null);
	
	JList list = new JList(Main.likedList.toList());
	getContentPane().add(list);
	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	JScrollPane scroll = new JScrollPane(list);
	scroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scroll.setBounds(210, 72, 193, 213);
    getContentPane().add(scroll);
    	
	JButton btnDetails = new JButton("See Details");
	btnDetails.setBackground(new Color(135, 206, 250));
	btnDetails.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String nameSelected = null;
			String recipeSelected = null;
			int index = list.getSelectedIndex();
			if(index != -1) {
				String name = list.getSelectedValue().toString();
				Node selected = Main.likedList.find(name);
				Recipe recipe = selected.recipe;
				nameSelected = recipe.getName();
				recipeSelected = recipe.getRecipe();
				System.out.println(recipe.getName());
				System.out.println(recipe.getRecipe());
			}
			else
				JOptionPane.showMessageDialog(null, "Nothing has selected!");	
			
			SeeDetails seeDetailsPage = new SeeDetails();
			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			
			textArea.append(nameSelected + "\n");
			textArea.append(recipeSelected + "\n");
			
			JScrollPane scroll = new JScrollPane(textArea);
			scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		    scroll.setBounds(155, 38, 250, 200);
		    getContentPane().add(scroll);
		    seeDetailsPage.add(scroll);

		}		
	});
	btnDetails.setBounds(440, 72, 140, 47);
	getContentPane().add(btnDetails);
	
	JButton btnDeleteRecipe = new JButton("Delete Recipe");
	btnDeleteRecipe.setBackground(new Color(135, 206, 250));
	btnDeleteRecipe.setBounds(440, 157, 140, 47);
	getContentPane().add(btnDeleteRecipe);
	
	JButton btnClearList = new JButton("Clear List");
	btnClearList.setBackground(new Color(135, 206, 250));
	btnClearList.setBounds(444, 238, 136, 47);
	getContentPane().add(btnClearList);
	
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
	
	JLabel lblListOfLiked = new JLabel("List of Liked Recipes");
	lblListOfLiked.setFont(new Font("Consolas", Font.BOLD, 22));
	lblListOfLiked.setBounds(167, 16, 282, 20);
	getContentPane().add(lblListOfLiked);
	
	}
}
