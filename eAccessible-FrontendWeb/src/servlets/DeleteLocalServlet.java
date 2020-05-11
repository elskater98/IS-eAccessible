package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backendservlet.Local;

import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet("/deleteLocal")
public class DeleteLocalServlet extends IntegracioHttpServlet {

    private Local local;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
        	this.soapWebService.deleteLocalById(this.local.getId());
        	resp.sendRedirect("/eAccessible-FrontendWeb/getAllLocals");
        } catch (RuntimeException e) {
        	resp.sendRedirect("/eAccessible-FrontendWeb/error.jsp");
        }
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        final String idString=req.getParameter("id");
        if(idString==null){
            resp.sendRedirect("/eAccessible-FrontendWeb/getAllLocals");
            return;
        }
        this.local=this.soapWebService.getLocal(Integer.parseInt(idString));
        super.service(req, resp);
    }

}