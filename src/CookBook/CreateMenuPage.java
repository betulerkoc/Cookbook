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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class CreateMenuPage extends JFrame{
	
	JTextArea textAreaStarter = new JTextArea();
	JTextArea textAreaDessert = new JTextArea();
	JTextArea textAreaMain = new JTextArea();
	
	JButton btnChangeStarter = new JButton("Change it");
	JButton btnChangeMain = new JButton("Change it");
	JButton btnChangeDessert = new JButton("Change it");


	
	
	public CreateMenuPage() {
		
		Recipe recipeStarter = crs();
		textAreaStarter.append(recipeStarter.getName().toUpperCase() + "\n");
		textAreaStarter.append(recipeStarter.getRecipe());
		Recipe recipeMainMeal = crm();
		textAreaMain.append(recipeMainMeal.getName().toUpperCase() + "\n");
		textAreaMain.append(recipeMainMeal.getRecipe());
		Recipe recipeDessert = crd();
		textAreaDessert.append(recipeDessert.getName().toUpperCase()+ "\n");
		textAreaDessert.append(recipeDessert.getRecipe());
		
		
		getContentPane().setBackground(new Color(255, 222, 173));
		setTitle("Cook-Book");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(703, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		TitledBorder titleStarter = new TitledBorder("Starter:");
		textAreaStarter.setEditable(false);
		textAreaStarter.setBorder(titleStarter);
		textAreaStarter.setLineWrap(true);
	    textAreaStarter.setWrapStyleWord(true);
	    JScrollPane scroll = new JScrollPane(textAreaStarter);
	    scroll = new JScrollPane(textAreaStarter, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scroll.setBounds(131, 81, 138, 218);
	    getContentPane().add(scroll);

		
		TitledBorder titleDessert = new TitledBorder("Dessert:");
		textAreaMain.setEditable(false);
		getContentPane().add(textAreaDessert);
		textAreaDessert.setBorder(titleDessert);
		textAreaDessert.setLineWrap(true);
	    textAreaDessert.setWrapStyleWord(true);
	    JScrollPane scroll_1= new JScrollPane(textAreaDessert);
	    scroll_1 = new JScrollPane(textAreaDessert, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scroll_1.setBounds(501, 81, 138, 218);
	    getContentPane().add(scroll_1);
		
		TitledBorder titleMain = new TitledBorder("Main Meal:");
		textAreaDessert.setEditable(false);
		getContentPane().add(textAreaMain);
		textAreaMain.setBorder(titleMain);
		textAreaMain.setLineWrap(true);
	    textAreaMain.setWrapStyleWord(true);
	    JScrollPane scroll_2 = new JScrollPane(textAreaMain);
	    scroll_2 = new JScrollPane(textAreaMain, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scroll_2.setBounds(320, 81, 138, 218);
	    getContentPane().add(scroll_2);
		
		btnChangeStarter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Recipe changedRecipe = crs();
				recipeStarter.setName(changedRecipe.getName());
				recipeStarter.setRecipe(changedRecipe.getRecipe());
				textAreaStarter.setText("");
				textAreaStarter.append(recipeStarter.getName().toUpperCase() + "\n");
				textAreaStarter.append(recipeStarter.getRecipe());
			}
		});
		btnChangeStarter.setBackground(new Color(255, 250, 205));
		btnChangeStarter.setBounds(141, 49, 115, 29);
		getContentPane().add(btnChangeStarter);
		
		
		btnChangeDessert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recipe changedRecipe = crd();
				recipeDessert.setName(changedRecipe.getName());
				recipeDessert.setRecipe(changedRecipe.getRecipe());
				textAreaDessert.setText("");
				textAreaDessert.append(recipeDessert.getName().toUpperCase() + "\n");
				textAreaDessert.append(recipeDessert.getRecipe());
			}
		});
		btnChangeDessert.setBackground(new Color(255, 250, 205));
		btnChangeDessert.setBounds(511, 49, 115, 29);
		getContentPane().add(btnChangeDessert);
		
		btnChangeMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recipe changedRecipe = crm();
				recipeMainMeal.setName(changedRecipe.getName());
				recipeMainMeal.setRecipe(changedRecipe.getRecipe());
				textAreaMain.setText("");
				textAreaMain.append(recipeMainMeal.getName().toUpperCase() + "\n");
				textAreaMain.append(recipeMainMeal.getRecipe());
			}
		});
		btnChangeMain.setBackground(new Color(255, 250, 205));
		btnChangeMain.setBounds(331, 49, 115, 29);
		getContentPane().add(btnChangeMain);
		
		JButton btnLikeStarter = new JButton("Like ");
		btnLikeStarter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Main.likedList.insertAtFront(recipeStarter);
				try {
					FileWriter writer = new FileWriter("saveLiked.txt", true);
					writer.write(recipeStarter.getName() + "=" + recipeStarter.getRecipe() + "=" + recipeStarter.getType() + "\r\n");
					writer.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Recipe is added to liked list!");
			}
		});
		btnLikeStarter.setBackground(new Color(240, 255, 240));
		btnLikeStarter.setBounds(141, 299, 115, 29);
		getContentPane().add(btnLikeStarter);
		
		JButton btnLikeMain = new JButton("Like ");
		btnLikeMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.likedList.insertAtFront(recipeMainMeal);
				try {
					FileWriter writer = new FileWriter("saveLiked.txt", true);
					writer.write(recipeMainMeal.getName() + "=" + recipeMainMeal.getRecipe() + "=" + recipeMainMeal.getType() +"\r\n");
					writer.close();
				}
				catch(IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Recipe is added to liked list!");
				
			}
		});
		btnLikeMain.setBackground(new Color(240, 255, 240));
		btnLikeMain.setBounds(331, 299, 115, 29);
		getContentPane().add(btnLikeMain);
		
		JButton btnLikeDessert = new JButton("Like ");
		btnLikeDessert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.likedList.insertAtFront(recipeDessert);
				try {
					FileWriter writer = new FileWriter("saveLiked.txt", true);
					writer.write(recipeDessert.getName() + "=" + recipeDessert.getRecipe() + "=" + recipeDessert.getType() +"\r\n");
					writer.close();
				}
				catch(IOException e2) {
					e2.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Recipe is added to liked list!");
			}
		});
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
	
	public String createRandomChar() {
			
			String s = "";
			
			String alphabet= "abcdefghijklmnopqrstuvwxyz";
		    
		    Random random = new Random();
			
		    for (int i = 0; i < 1; i++) {
		      char c = alphabet.charAt(random.nextInt(26));
		      s+=c;
		    }
	        return s;
		}

	private Recipe crs() {
		Recipe randomStarter = new Recipe();
		do {
			 randomStarter = Main.bstStarter.search(Main.bstStarter.getRoot(), this.createRandomChar());
		}while(randomStarter == null);
		return randomStarter;
	}
	
	private Recipe crm() {
		Recipe randomMainMeal = new Recipe();
		do {
			 randomMainMeal = Main.bstMainMeal.search(Main.bstMainMeal.getRoot(), this.createRandomChar());
		}while(randomMainMeal == null);
		return randomMainMeal;
	}
	
	private Recipe crd() {
		Recipe randomDessertt = new Recipe();
		do {
			 randomDessertt = Main.bstDessert.search(Main.bstDessert.getRoot(), this.createRandomChar());
		}while(randomDessertt == null);
		
		return randomDessertt;
	}
}
