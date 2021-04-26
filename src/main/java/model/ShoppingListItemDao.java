package model;

import java.util.List;

public interface ShoppingListItemDao {
	
	public List<ShoppingListItem> getAllItems();
	
	public ShoppingListItem getItem(String title);
	
	public boolean addItem(String newItem);

	public boolean removeItem(int id);
}
