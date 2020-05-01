package CookBook;

public class RecipeTree {
	   public Recipe recipe; 
	   public RecipeTree left, right;
	   
	   public RecipeTree(Recipe d) { 
	      recipe = d;
	      left = right = null;
	   }
}
