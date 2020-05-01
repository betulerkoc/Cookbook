package CookBook;

public class Node {
	public Recipe recipe;
	public Node link;

	public Node() {
		link = null;
		recipe = null;
	}

	public Node(Recipe newRecipe) {
		setRecipe(newRecipe);
		link = null;
	}

	public Node(Recipe newRecipe, Node linkValue) {
		setRecipe(newRecipe);
		link = linkValue;
	}

	public void setRecipe(Recipe newRecipe) {
		recipe = newRecipe;
	}

	public void setLink(Node newLink) {
		link = newLink;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public Node getLink() {
		return link;
	}

}
