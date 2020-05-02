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
		
		public void find(int id)
		{
			if (root == null) 
				return;
			//System.out.print(root.recipe.getName());
			
			else if(id == root.recipe.getId()) {
				System.out.print(root.recipe.getName());
			}
			else if(id == root.left.recipe.getId()) {
				System.out.print(root.left.recipe.getName());
			}
			}
		

//		public static BinarySearchTree search(RecipeTree root, String st)
//	    {
//	        if(root == null) 
//	        {
//	            return null;
//	        }
//	        else if(st.equals(root.recipe.getName()))
//	        {
//	            return root;
//	        }
//	        else 
//	        {   if (root.left!= null)
//	                return search(root.left, st);
//	            else
//	                return search(root.left, st); 
//	        }
//	    }
		}
	
	
	
	
	
	
