package model;

public class ShoppingListItem {
	
	private int id;
	private String title;
	
	public ShoppingListItem(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
