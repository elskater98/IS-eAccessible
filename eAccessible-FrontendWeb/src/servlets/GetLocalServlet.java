package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backendservlet.Accessibility;
import backendservlet.Local;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/getLocal")
public class GetLocalServlet extends IntegracioHttpServlet {

    public static final String GET_LOCAL_SESSION_ID = "GET_LOCAL_SESSION_ID";
    public static final String GET_ACCESSIBLILITY_LIST_SESSION_ID = "GET_ACCESSIBLILITY_LIST_SESSION_ID";
    private Local local;
    private List<Accessibility> accessibilityList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	final String id = req.getParameter("id");
        if (id != null) {
        	try {
        		this.local = this.soapWebService.getLocal(Integer.parseInt(id));
                this.accessibilityList = this.soapWebService.getAccesibilityByLocal(this.local);
        	} catch (RuntimeException e){
        		this.local = new Local();
                this.accessibilityList = new ArrayList<>();
        	}
        } else {
            this.local = new Local();
            this.accessibilityList = new ArrayList<>();
        }
        req.getSession(true).setAttribute(GET_LOCAL_SESSION_ID, this.local);
        req.getSession(true).setAttribute(GET_ACCESSIBLILITY_LIST_SESSION_ID, this.accessibilityList);
        this.getServletContext()
                .getRequestDispatcher("/getLocal.jsp")
                .forward(req, resp);
    }
}
