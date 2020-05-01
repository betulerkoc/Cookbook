package CookBook;


public class BinarySearchTree {
	private RecipeTree root; // 
	
	public void insert(Recipe d) {
	   if (root == null) {
	      root = new RecipeTree(d);
	      return;
	   }
	   RecipeTree loc = root;
	   while (true) {
	      if (d.getName().compareTo(loc.recipe.getName()) < 0) {
	         if (loc.left != null) loc = loc.left;
	         else { loc.left = new RecipeTree(d); break; }
	      }
	      else if (d.getName().compareTo(loc.recipe.getName()) > 0) {
	         if (loc.right != null) loc = loc.right;
	         else { loc.right = new RecipeTree(d); break; } 
	      }
	      else break;
	   }
	}

	   public void inorderTraversal() {inorderT(root); }

	   private void inorderT(RecipeTree t) {
	      if (t != null) {
	         inorderT(t.left);
	         System.out.print(t.recipe.getName() + " ");
	         inorderT(t.right);
	      }
	   }
	}
	
	
	
	
	
	
	
