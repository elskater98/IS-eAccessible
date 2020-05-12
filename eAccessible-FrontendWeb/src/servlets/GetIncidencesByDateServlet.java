package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backendservlet.Incidence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/getIncidencesByDate")
public class GetIncidencesByDateServlet extends IntegracioHttpServlet {

    public static final String INCIDENCE_LIST_SESSION_ID = "INCIDENCE_LIST_SESSION_ID";

    private List<Incidence> incidenceList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.incidenceList = new ArrayList<>();
        req.getSession(true).setAttribute(INCIDENCE_LIST_SESSION_ID, this.incidenceList);
        this.getServletContext()
                .getRequestDispatcher("/getIncidencesByDate.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
	        final String startDate = req.getParameter("startDate");
	        final String endDate = req.getParameter("endDate");
	        if (startDate != null && endDate != null) {
	            this.incidenceList = this.soapWebService.getIncidencesByDate(startDate, endDate);
	        } else {
	            this.incidenceList = new ArrayList<>();
	        }
	        req.getSession(true).setAttribute(INCIDENCE_LIST_SESSION_ID, this.incidenceList);
	        this.getServletContext()
	                .getRequestDispatcher("/getIncidencesByDate.jsp")
	                .forward(req, resp);
        } catch (RuntimeException e) {
        	resp.sendRedirect("/eAccessible-FrontendWeb/error.jsp");
        }
    }

}