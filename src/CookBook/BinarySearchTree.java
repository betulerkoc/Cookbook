package CookBook;


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
				System.out.print("in order: " + root.recipe.getName() + "\r\n");
				inorder(root.right);
			}
		}

	
	
	
	
	
	
	
