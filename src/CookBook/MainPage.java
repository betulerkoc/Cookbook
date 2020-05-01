package CookBook;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

public class MainPage {
	
	
	public static void main(String s[]) {  
        JFrame frame = new JFrame("Cook Book");  
        JPanel panel = new JPanel();
      
        
        panel.setLayout(new FlowLayout());  
        JLabel label = new JLabel("Create menu!");  
        JButton button = new JButton();  
        button.setText("Create Menu!");  
        
        LikedLinkedList foodName = new LikedLinkedList();
       // Vector foodName = new Vector();
        
        LikedLinkedList ls = new LikedLinkedList();
		Recipe no1 = new Recipe( "pilav", "dafsdags", "ana yemek");
		Recipe no2 = new Recipe( "makarna", "dafsssssdags", "ana yemek");
		Recipe no3 = new Recipe( "yayla", "dafsdfags", "corba");
		Recipe no4 = new Recipe( "sutlac", "dafsssdags", "tatli");
		
        foodName.insertAtFront(no1);
        foodName.insertAtFront(no2);
        foodName.insertAtFront(no3);
        foodName.insertAtFront(no4);
        
        Vector<String> foods = new Vector<String>();
        
        foods = foodName.toList();
   
        JList<String> likedFoodList = new JList<String>(foods);
        likedFoodList.setPreferredSize(new Dimension(200,200));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(likedFoodList);
        likedFoodList.setLayoutOrientation(JList.VERTICAL);
        
        likedFoodList.setBackground(Color.yellow);
        
        
        
        JButton button2 = new JButton();  
        button2.setText("Like");
        
        JLabel label1 = new JLabel("added");
        
        
        button2.addActionListener(new ActionListener(){
        	 @Override
             public void actionPerformed(ActionEvent e) {
                 //likedFoodList.
             }
        	
        });

        panel.add(likedFoodList);
        panel.add(scrollPane);
        panel.add(label);  
        panel.add(button); 
        panel.add(button2);
        frame.add(panel);  
        frame.setSize(700, 600);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
    }  
	

}
