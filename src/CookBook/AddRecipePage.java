package CookBook;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AddRecipePage extends JFrame{
	
	public static BinarySearchTree bst1 = new BinarySearchTree();
	public static BinarySearchTree bst2 = new BinarySearchTree();
	public static BinarySearchTree bst3 = new BinarySearchTree();
	
	JTextField txtRecipeName = new JTextField();
	JTextArea txtRecipe = new JTextArea();
	JComboBox<String> cmbRecipeType = new JComboBox<>();
	JButton btnAddRecipe = new JButton("ADD!");
	JButton btnGoBack = new JButton("Go Back");

	
	public AddRecipePage() {
		getContentPane().setBackground(new Color(255, 228, 181));
		setTitle("Cook-Book");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(744, 547);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
				
	    JLabel lblHeader = new JLabel("ADD NEW RECIPE!");
		lblHeader.setBounds(301, 37, 226, 27);
		getContentPane().add(lblHeader);
		lblHeader.setFont(new Font("Consolas", Font.PLAIN, 22));
				
		JLabel lblRecipeName = new JLabel("Recipe Name: ");
		getContentPane().add(lblRecipeName);
		lblRecipeName.setHorizontalAlignment(JLabel.LEADING);
		lblRecipeName.setBounds(153, 130, 104, 17);
		lblRecipeName.setFont(new Font("Consolas", Font.PLAIN, 14));
			
		getContentPane().add(txtRecipeName);
		txtRecipeName.setBounds(283, 123, 289, 33);
		txtRecipeName.setColumns(12);		
				
		txtRecipe.setLineWrap(true);
		txtRecipe.setWrapStyleWord(true);
		txtRecipe.setPreferredSize(new Dimension(200,70));
				
		JScrollPane scrollPane = new JScrollPane(txtRecipe);
		scrollPane.setBounds(283, 204, 289, 122);
		getContentPane().add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
				

		getContentPane().add(cmbRecipeType);
		cmbRecipeType.addItem("Choose one");
		cmbRecipeType.addItem("Starter");
		cmbRecipeType.addItem("Main Meal");
		cmbRecipeType.addItem("Dessert");
		cmbRecipeType.setBounds(376, 337, 124, 27);
		cmbRecipeType.setBackground(Color.white);
		cmbRecipeType.setFont(new Font("Consolas", Font.PLAIN, 14));
				
		JLabel lblRecipe = new JLabel("Recipe: ");
		lblRecipe.setBounds(158, 209, 64, 17);
		getContentPane().add(lblRecipe);
		lblRecipe.setHorizontalAlignment(JLabel.LEADING);
		lblRecipe.setFont(new Font("Consolas", Font.PLAIN, 14));
				
		btnAddRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Recipe newRecipe = new Recipe(txtRecipeName.getText(), txtRecipe.getText(), cmbRecipeType.getSelectedItem().toString());
				if(txtRecipeName.getText().isEmpty() ||
						txtRecipe.getText().isEmpty() ||
						cmbRecipeType.getSelectedIndex() == 0 ) {
						JOptionPane.showMessageDialog(null, "Please fill all the fields! ");
					}
						
				else {
					if(newRecipe.getType() == "Starter") {
						Main.bstStarter.insert(newRecipe);
						Main.bstStarter.inorder(Main.bstStarter.getRoot());
						newRecipe.setId(Main.bstStarter.getSize());
	
						try {
						FileWriter writer = new FileWriter("saveStarter.txt", true);
						writer.write(newRecipe.getName() + " = " +newRecipe.getRecipe()+ "\r\n");
						writer.close();
						}
					catch(IOException e) {
							e.printStackTrace();
						}

						System.out.print("iddd:" + newRecipe.getId() +  "\r\n");
					} 
					
					else if(newRecipe.getType() == "Main Meal") {
						
							Main.bstMainMeal.insert(newRecipe);
							Main.bstMainMeal.inorder(Main.bstMainMeal.getRoot());
							newRecipe.setId(Main.bstMainMeal.getSize());
					
							try {
							FileWriter writer = new FileWriter("saveMainMeal.txt", true);
							writer.write(newRecipe.getName() + " = " +newRecipe.getRecipe()+ "\r\n");
							writer.close();
							}
						catch(IOException e) {
								e.printStackTrace();
							}
					}
					else {
						if(newRecipe.getType() == "Dessert") {
							
							Main.bstDessert.insert(newRecipe);
							Main.bstDessert.inorder(Main.bstDessert.getRoot());
							newRecipe.setId(Main.bstDessert.getSize());
						
							try {
							FileWriter writer = new FileWriter("saveDessert.txt", true);
							writer.write(newRecipe.getName() + " = " +newRecipe.getRecipe()+ "\r\n");
							writer.close();
							}
						catch(IOException e) {
								e.printStackTrace();
							}
						}
					}
					
				JOptionPane.showMessageDialog(null, "Recipe is added!");
							
						
			}
				txtRecipeName.setText("");
				txtRecipe.setText("");
				cmbRecipeType.setSelectedIndex(0);
			}			
			
		});
		
		btnAddRecipe.setBackground(new Color(240, 255, 255));
		btnAddRecipe.setBounds(336, 407, 111, 49);
		getContentPane().add(btnAddRecipe);
		btnAddRecipe.setFont(new Font("Consolas", Font.BOLD, 20));
				
				
		JLabel lblRecipeType= new JLabel("Selecet Type of the meal: ");
		lblRecipeType.setBounds(153, 342, 208, 17);
		getContentPane().add(lblRecipeType);
		lblRecipeType.setHorizontalAlignment(JLabel.LEADING);
		lblRecipeType.setFont(new Font("Consolas", Font.PLAIN, 14));
				
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePage welcomeWindow = new WelcomePage();
				setVisible(false);
				welcomeWindow.setVisible(true);
			}
		});
		btnGoBack.setBounds(29, 36, 117, 55);
		getContentPane().add(btnGoBack);
		
	}
	
}