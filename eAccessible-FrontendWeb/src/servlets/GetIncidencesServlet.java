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
@WebServlet("/getIncidences")
public class GetIncidencesServlet extends IntegracioHttpServlet {

    public static final String INCIDENCE_TYPE_LIST_SESSION_ID = "INCIDENCE_TYPE_LIST_SESSION_ID";

    public static final String INCIDENCE_LIST_SESSION_ID = "INCIDENCE_LIST_SESSION_ID";

    private List<Incidence> incidenceList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.incidenceList = new ArrayList<>();
        req.getSession(true).setAttribute(INCIDENCE_LIST_SESSION_ID, this.incidenceList);
        this.getServletContext()
                .getRequestDispatcher("/getIncidences.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
        	final String incidenceTypeId = req.getParameter("incidenceType");
	        if (incidenceTypeId != null) {
	            this.incidenceList = this.soapWebService.getIncidencesByIncidenceType(this.soapWebService.getIncidenceType(Integer.parseInt(incidenceTypeId)));
	        } else {
	            this.incidenceList = new ArrayList<>();
	        }
	        req.getSession(true).setAttribute(INCIDENCE_LIST_SESSION_ID, this.incidenceList);
	        this.getServletContext()
	                .getRequestDispatcher("/getIncidences.jsp")
	                .forward(req, resp);
        } catch (RuntimeException e) {
        	resp.sendRedirect("/eAccessible-FrontendWeb/error.jsp");
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession(true).setAttribute(INCIDENCE_TYPE_LIST_SESSION_ID, this.soapWebService.getAllIncidenceTypes());
        super.service(req, resp);
    }

}
