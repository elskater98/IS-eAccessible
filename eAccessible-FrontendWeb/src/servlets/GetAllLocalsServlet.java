package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backendservlet.Local;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/getAllLocals")
public class GetAllLocalsServlet extends IntegracioHttpServlet {

    public static final String GET_ALL_LOCALS_SESSION_ID = "GET_ALL_LOCALS_SESSION_ID";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Local> localList = this.soapWebService.getAllLocals();
        req.getSession(true).setAttribute(GET_ALL_LOCALS_SESSION_ID, localList);
        this.getServletContext()
                .getRequestDispatcher("/getAllLocals.jsp")
                .forward(req, resp);
    }

}
