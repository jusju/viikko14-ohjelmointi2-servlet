package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Joululahja;


@WebServlet("/joululahjat")
public class JoululahjaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
    	
    	Joululahja joululahja1 = new Joululahja("World peace");
    	Joululahja joululahja2 = new Joululahja("Love");
    	
    	ArrayList<Joululahja> lahjat = new ArrayList<Joululahja>();
    	lahjat.add(joululahja1);
    	lahjat.add(joululahja2);

        // pass to the JSP page as an attribute
        req.setAttribute("lahjat", lahjat);

        // forward the request to the index.jsp page
        req.getRequestDispatcher("/WEB-INF/lahjat.jsp").forward(req, resp);
    }
}
