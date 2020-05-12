package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backendservlet.Local;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/getLocalsByName")
public class GetLocalsByNameServlet extends IntegracioHttpServlet {

    public static final String LOCAL_LIST_SESSION_ID = "LOCAL_LIST_SESSION_ID";
    private List<Local> localList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final String localType = req.getParameter("tipoLocal");
        if (name != null) {
        	if (localType.equals("empty")) {
        		this.localList = this.soapWebService.getLocalsByName(name);
        	} else {
        		this.localList = this.soapWebService.getLocalsByLocalTypeAndName(
        							this.soapWebService.getLocalType(Integer.parseInt(localType)), name);
        	}
        } else {
            this.localList = new ArrayList<>();
        }
        req.getSession(true).setAttribute(LOCAL_LIST_SESSION_ID, this.localList);
        this.getServletContext()
                .getRequestDispatcher("/getLocalsByName.jsp")
                .forward(req, resp);
    }

}
