package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backendservlet.Local;
import backendservlet.LocalType;
import backendservlet.SoapWebService;
import backendservlet.SoapWebServiceService;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/addLocal")
public class AddLocalServlet extends IntegracioHttpServlet {

    public static final String MODEL = AddLocalServlet.class.getCanonicalName();

    public static final String LOCAL_TYPES_SESSION_ID = "LOCAL_TYPES_SESSION_ID";
    public static final List<LocalType> LOCAL_TYPES;

    static {
        final SoapWebServiceService service = new SoapWebServiceService();
        final SoapWebService soapWebService = service.getSoapWebServicePort();
        LOCAL_TYPES = soapWebService.getAllLocalTypes();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession(true).setAttribute(LOCAL_TYPES_SESSION_ID, LOCAL_TYPES);
        this.getServletContext()
                .getRequestDispatcher("/addLocal.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
	    	final Local local = new Local();
	        local.setLocalType(this.soapWebService.getLocalType(Integer.parseInt(req.getParameter("tipusLocal"))));
	        local.setName(req.getParameter("nom"));
	        local.setStreet(req.getParameter("carrer"));
	        local.setStreetType(req.getParameter("tipusCarrer"));
	        local.setNumber(Integer.parseInt(req.getParameter("numero")));
	        local.setObservations(req.getParameter("observacions"));
	        local.setUrlCA(req.getParameter("urlCA"));
	        local.setUrlES(req.getParameter("urlES"));
	        local.setUrlEN(req.getParameter("urlEN"));
	        local.setUrlGoogleMapsCA(req.getParameter("urlGoogleMapsCA"));
	        local.setUrlGoogleMapsES(req.getParameter("urlGoogleMapsES"));
	        local.setUrlGoogleMapsEN(req.getParameter("urlGoogleMapsEN"));
	        local.setCoorX(Float.parseFloat(req.getParameter("coorX")));
	        local.setCoorY(Float.parseFloat(req.getParameter("coorY")));
	        req.getSession(true).setAttribute(MODEL, local);
	        resp.sendRedirect("/eAccessible-FrontendWeb/addCharacteristic");
        } catch (RuntimeException e) {
        	resp.sendRedirect("/eAccessible-FrontendWeb/error.jsp");
        }
    }

}
