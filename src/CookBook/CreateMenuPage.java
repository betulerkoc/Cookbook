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

		textAreaDessert.setEditable (false);
		textAreaMain.setBounds(321, 81, 138, 218);
		getContentPane().add(textAreaMain);
		textAreaMain.setBorder(titleMain);
		

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
			
		textAreaStarter.setText ("");
		textAreaDessert.setText("");
		textAreaMain.setText("");
	    
		try {
            FileReader reader = new FileReader("saveStarter.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
            	textAreaStarter.append(line + "\n");
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		try {
            FileReader reader = new FileReader("saveDessert.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
            	textAreaDessert.append(line + "\n");
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		try {
            FileReader reader = new FileReader("saveMainMeal.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
            	textAreaMain.append(line + "\n");
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		
	//	AddRecipePage app = new AddRecipePage();
		//bst1.inorder(bst1.getRoot());
	    
	    
	    
//	    String sss="";
//	    try {
//	    	InputStreamReader reader = new InputStreamReader(
//	    	        new FileInputStream("saveStarter.txt"), "UTF-8");
//
//		    sss = reader.t();
//			reader.close();
//			}
//		catch(IOException e) {
//				e.printStackTrace();
//			}
//	    for (int s = 0; s < 5; s++)
//        {
//	    	textAreaStarter.append(sss + "\n");
//        }	
//		
		
		btnChangeStarter.addActionListener     (event -> changeStarter ());
} 		

	    
	private void changeStarter() {
		Random rand = new Random(); 
		int rand_int1 = rand.nextInt(2);
		System.out.print(rand_int1);
		
		AddRecipePage.bst1.find(rand_int1);
		textAreaStarter.append("");
		
//			if(rand_int1 == AddRecipePage.bst1.getRoot().recipe.getId()) {
//				System.out.print(AddRecipePage.bst1.getRoot().recipe.getName());
//				System.out.print(rand_int1);
//			}
	
		
		//System.out.print(AddRecipePage.bst1.getSize() + "\r\n");
	}
	
}
