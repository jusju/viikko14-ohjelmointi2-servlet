package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/christmas")
public class ChristmasCountdownServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate today = LocalDate.now();
        int year = 0;
        
        if (today.getMonthValue()!=12 || today.getDayOfMonth()<25) {
        	year = today.getYear();
        }
        else {
        	year = today.getYear()+1;
        }
        LocalDate christmas = LocalDate.of(year, 12, 24);
        
        long daysToChristmas = ChronoUnit.DAYS.between(today, christmas);
        
		String dayString = String.valueOf(daysToChristmas);

        // pass the time string to the JSP page as an attribute
        req.setAttribute("daysNow", dayString);

        // forward the request to the index.jsp page
        req.getRequestDispatcher("/WEB-INF/christmas.jsp").forward(req, resp);
    }
	
	
}
