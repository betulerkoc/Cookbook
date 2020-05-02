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
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Random;
import java.awt.event.ActionEvent;

public class CreateMenuPage extends JFrame{
	
	JTextArea textAreaStarter = new JTextArea();
	JTextArea textAreaDessert = new JTextArea();
	JTextArea textAreaMain = new JTextArea();
	
	JButton btnChangeStarter = new JButton("Change it");
	JButton btnChangeMain = new JButton("Change it");
	JButton btnChangeDessert = new JButton("Change it");
	
	public CreateMenuPage() {
		getContentPane().setBackground(new Color(255, 222, 173));
		setTitle("Cook-Book");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(703, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		TitledBorder titleStarter = new TitledBorder("Starter:");

		textAreaStarter.setEditable (false);
		textAreaStarter.setBounds(131, 81, 138, 218);
		getContentPane().add(textAreaStarter);
		textAreaStarter.setBorder(titleStarter);
		
		TitledBorder titleDessert = new TitledBorder("Dessert:");
	
		textAreaDessert.setEditable (false);
		textAreaDessert.setBounds(501, 81, 138, 218);
		getContentPane().add(textAreaDessert);
		textAreaDessert.setBorder(titleDessert);
		
		TitledBorder titleMain = new TitledBorder("Main Meal:");

		textAreaMain.setEditable (false);
		textAreaMain.setBounds(321, 81, 138, 218);
		getContentPane().add(textAreaMain);
		textAreaMain.setBorder(titleMain);
		

		btnChangeStarter.setBackground(new Color(255, 250, 205));
		btnChangeStarter.setBounds(141, 49, 115, 29);
		getContentPane().add(btnChangeStarter);
		
		btnChangeDessert.setBackground(new Color(255, 250, 205));
		btnChangeDessert.setBounds(511, 49, 115, 29);
		getContentPane().add(btnChangeDessert);
		
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
			
		createRandomStarter();
		createRandomMain();
		createRandomDessert();
	    
		btnChangeStarter.addActionListener     (event -> changeStarter ());
		btnChangeMain.addActionListener     (event -> changeMain ());
		btnChangeDessert.addActionListener     (event -> changeDessert ());
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
	
	private void createRandomStarter() {
         
        //System.out.println("RANDOMSTARTER " + this.createRandomChar());

        String randomStarter = Main.bstStarter.search(Main.bstStarter.getRoot(), this.createRandomChar());
        
        if(randomStarter != null)
        textAreaStarter.append(randomStarter + "\n");
        else
        	createRandomStarter();	
   
	}

	private void createRandomMain() {
         
       // System.out.println("RANDOMMAIN " + this.createRandomChar());

        String randomMain = Main.bstMainMeal.search(Main.bstMainMeal.getRoot(), this.createRandomChar());
        
        if(randomMain != null)
        textAreaMain.append(randomMain + "\n");
        else
        	createRandomMain();	
  
	}

	
	private void createRandomDessert() {
         
       // System.out.println("RANDOMDESSERT " + this.createRandomChar());

        String randomDessert = Main.bstDessert.search(Main.bstDessert.getRoot(), this.createRandomChar());
        
        if(randomDessert != null)
        	textAreaDessert.append(randomDessert + "\n");
        else
        	createRandomDessert();	
   
	}
	
	private void changeStarter() {
		textAreaStarter.setText("");
		createRandomStarter();
	}
	
	
	private void changeMain() {
		textAreaMain.setText("");
		createRandomMain();
	}
	private void changeDessert() {
		textAreaDessert.setText("");
		createRandomDessert();
	}
	
}
