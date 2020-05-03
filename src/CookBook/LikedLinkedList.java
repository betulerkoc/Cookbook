package CookBook;

import java.util.List;
import java.util.Vector;

public class LikedLinkedList {
	
	private Node first;
	private Node last;

	public LikedLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}
	
	public Node getFirst() {
		return first;
	}
	
	public Node getLast() {
		return last;
	}

	public void insertAtFront(Recipe itemName) {
		if(isEmpty())
			first=last=new Node(itemName);
		else
			first=new Node(itemName,first);
		
	}
	
	public boolean removeSelected(String recipe) {
		Node current = first;
		Node next;
				
		while(current.getLink().getRecipe().getName() != recipe){
			current = current.link;
		}
		next = current.getLink().getLink();
		current.setLink(next);
			
			return true;
	}
	
	public void clearList() {
		first = null;
		
	}

	public boolean removeFromFront() {
		if(isEmpty()) {
			System.out.println("There is no elemnet in the liked recipe list!");
			return false;}
		else if(first==last) {
			first=last=null;
			return true;}
		
		else {
			first=first.getLink();
			return true;}
	
	}
	
	public Node find(String target) {
		Node position = first;
		String itemAtPosition;
		while (position != null) {
			itemAtPosition = position.getRecipe().getName();
			if (itemAtPosition.equals(target))
				return position;
			position = position.getLink();
		}
		return null; // target was not found
	}
	
	public void outputList() {
		Node current = first;
		while (current != null) {
			System.out.println(current.getRecipe().getName());
			current = current.getLink();
			
		}
	}
	
	public Vector<String> toList() {
		Vector<String> likedFoods = new Vector<String>();
		Node current = first;
		while (current != null) {
			likedFoods.add(current.getRecipe().getName());
			current = current.getLink();
		}
		
		return likedFoods;
	}

	public boolean contains(String recipe) {
		return (find(recipe) != null);
	}
	

}
