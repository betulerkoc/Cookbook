package CookBook;

import java.util.Random;

public class BinarySearchTree {
	private RecipeTree root;
	private int size;
	
	public RecipeTree getRoot() {
		return root;
	}
	public int getSize() {
		return size;
		}

	public void insert(Recipe recipe) {
	   if (root == null) {
	      root = new RecipeTree(recipe);
	      return;
	   }
	   RecipeTree loc = root;
	   while (true) {
	      if (recipe.getName().compareTo(loc.recipe.getName()) < 0) {
	         if (loc.left != null) loc = loc.left;
	         else { loc.left = new RecipeTree(recipe); 
	         size++;
	         break; }
	      }
	      else if (recipe.getName().compareTo(loc.recipe.getName()) > 0) {
	         if (loc.right != null) loc = loc.right;
	         else { loc.right = new RecipeTree(recipe);
	         size++;
	         break; }
	      }
	      else break;
	   }
	}
		public void inorder(RecipeTree root)
		{
			if (root == null)
				return;
				inorder(root.left);
				System.out.println("in order: " + root.recipe.getName());
				inorder(root.right);
			}
			
		

		public static Recipe search(RecipeTree root, String st)
	    {
		
		Random rand = new Random(); 
	    int r = rand.nextInt(2); 
		 System.out.println("RANDOM Char: " + st);
		 System.out.println("RANDOM number: " +  r);
	        if(root == null) 
	        {
	            return null;
	        }
	        else if(st.equals(root.recipe.getName().substring(r, r+1)))
	        {
	        	  System.out.println("sey helloooo");
	            return root.recipe;
	        }
	        else 
	        {   if (root.left != null)
	                return search(root.left, st);
	            else
	                return search(root.right, st); 
	        }
	    }

		
		
		
		}
	
	
	
	
	
	
