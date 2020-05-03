package CookBook;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
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
	
	JList list = new JList(Main.likedList.toList());

	
	public LikedRecipePage() {
	getContentPane().setBackground(new Color(255, 228, 181));
	setTitle("Cook-Book");
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(650, 400);
	setLocationRelativeTo(null);
	getContentPane().setLayout(null);
	
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
	btnDeleteRecipe.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String selectedRecipe = list.getSelectedValue().toString();
			String removeTerm = list.getSelectedValue().toString();
			Main.likedList.removeSelected(selectedRecipe);
			removeRecord(filepath, removeTerm);
			//Main.likedList.outputList();
			getContentPane().add(list);
			setVisible(false);
			LikedRecipePage newWindow = new LikedRecipePage();
			newWindow.setVisible(true);
			JOptionPane.showMessageDialog(null, "Selected recipe is successfully deleted!");
		}
	});
	
	JButton btnClearList = new JButton("Clear List");
	btnClearList.setBackground(new Color(135, 206, 250));
	btnClearList.setBounds(444, 238, 136, 47);
	getContentPane().add(btnClearList);
	btnClearList.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			FileOutputStream writer;
			try {
				writer = new FileOutputStream("saveLiked.txt");
				writer.write(("").getBytes());
				writer.close();
				//Main.likedList.outputList();
				Main.likedList.clearList();
				setVisible(false);
				LikedRecipePage newWindow = new LikedRecipePage();
				newWindow.setVisible(true);
				JOptionPane.showMessageDialog(null, "List is successfully cleared!");
				list.clearSelection();
				

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
	});
	
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
	
	String filepath = "saveLiked.txt";
	private Scanner x;

	public void removeRecord(String filepath, String removeTerm) 
	{
		String tempFile = "temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		String recipeName = "";
		try {
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			x = new Scanner(new File(filepath));
			while(x.hasNext()) {
				recipeName = x.next();
				if(!recipeName.equals(removeTerm))
				{
					pw.println(recipeName);
				} 
			}
			x.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump = new File(filepath);
			newFile.renameTo(dump);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error!");
		}

	}
}
