package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/countdown")
public class CountdownServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String d = req.getParameter("day");
        String m = req.getParameter("month");
        String y = req.getParameter("year");
        
        int day = Integer.parseInt(d);
        int month = Integer.parseInt(m);
        int year = Integer.parseInt(y);
        
		LocalDate today = LocalDate.now();
       
        LocalDate wantedDate = LocalDate.of(year, month, day);
        String date = day + "." + month + "." + year;
        
        long daysTo = ChronoUnit.DAYS.between(today, wantedDate);
        
		String dayString = String.valueOf(daysTo);

        // pass the time string to the JSP page as an attribute
        req.setAttribute("daysNow", dayString);
        req.setAttribute("date", date);

        // forward the request to the index.jsp page
        req.getRequestDispatcher("/WEB-INF/countdown.jsp").forward(req, resp);
    }
	
	
}