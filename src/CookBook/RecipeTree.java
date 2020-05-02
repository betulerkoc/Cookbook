package CookBook;

public class RecipeTree {
	   public Recipe recipe; 
	   public RecipeTree left, right;
	   
	   public RecipeTree(Recipe newRecipe) { 
	      recipe = newRecipe;
	      left = right = null;
	   }
}
