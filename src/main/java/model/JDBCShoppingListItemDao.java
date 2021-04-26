package model;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCShoppingListItemDao implements ShoppingListItemDao {
	
	//T�h�n voi tehd� ymp�rist�muuttujan
	private static final String URL = "jdbc:sqlite:.\\Chinook_Sqlite.sqlite";
	Connection connection = null;
	ResultSet results = null;
	PreparedStatement statement = null;		
	
	public Connection connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection(URL);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return connection;
	}

	@Override
    public List<ShoppingListItem> getAllItems() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection(URL);
		
			List<ShoppingListItem> list = new ArrayList<ShoppingListItem>();
			statement = connection.prepareStatement("SELECT * FROM ShoppingListItem");
			results = statement.executeQuery();
			// K�yd��n tulokset l�pi
			while (results.next()) {
				int id = results.getInt("id");
				String title = results.getString("title");
				ShoppingListItem item = new ShoppingListItem(id, title);
				list.add(item);
			}
			results.close();
			statement.close();
			connection.close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }

    @Override
    public ShoppingListItem getItem(String title) {
    	try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection(URL);
    
			statement = connection.prepareStatement("SELECT * FROM ShoppingListItem WHERE title = ?");
			statement.setString(1, title);
			results = statement.executeQuery();
			int id = results.getInt("id");
			ShoppingListItem item = new ShoppingListItem(id, title);
		
			results.close();
			statement.close();
			connection.close();
			return item;
    	} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }

    @Override
    public boolean addItem(String newItem) {
    	try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection(URL);
    	
			statement = connection.prepareStatement("INSERT INTO ShoppingListItem (title) VALUES (?)");
			statement.setString(1, newItem);
			statement.executeUpdate();
		
			statement.close();
			connection.close();
			return true;
    	} catch (Exception e) {
			throw new RuntimeException(e);
		}
    }

    @Override
    public boolean removeItem(int id) {
    	try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection(URL);
			
			statement = connection.prepareStatement("SELECT * FROM ShoppingListItem WHERE id = ?");
			statement.setInt(1, id);
			results = statement.executeQuery();
			if (results.next()) {
				statement = connection.prepareStatement("DELETE FROM ShoppingListItem WHERE id = ?");
				statement.setInt(1, id);
				statement.executeUpdate();
				results.close();
				statement.close();
				connection.close();
				return true;
				}
			else {
				results.close();
				statement.close();
				connection.close();
				return false;
		}
		
    } catch (Exception e) {
		throw new RuntimeException(e);
	}}

	
}
