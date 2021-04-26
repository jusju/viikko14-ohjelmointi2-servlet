package servlet;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.JDBCShoppingListItemDao;
import model.Joululahja;
import model.ShoppingListItem;

@WebServlet("/list")
public class ShoppingListServlet extends HttpServlet {
	
	JDBCShoppingListItemDao olio = new JDBCShoppingListItemDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
    	
    	List<ShoppingListItem> ostokset = new ArrayList<ShoppingListItem>();
    	
    	ostokset = olio.getAllItems();
    	
    	//req.getAttribute();

        // pass to the JSP page as an attribute
        req.setAttribute("ostokset", ostokset);

        // forward the request to the index.jsp page
        req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    	throws ServletException, IOException {
    	String title =req.getParameter("item");
    	olio.addItem(title);
    	
    	resp.sendRedirect("/list");
    }
   
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
    	
    	int id = Integer.parseInt(req.getParameter("id"));
    	olio.removeItem(id);
    	resp.sendRedirect("/shoppingForm");
    	resp.sendRedirect("/list");
    	
    	//req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
    }
}
