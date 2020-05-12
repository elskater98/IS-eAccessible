package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import backend.BackendServiceLocator;
import backend.Local;

/**
 * Servlet implementation class sAltaLocal
 */
@WebServlet("/sAltaLocal")
public class sAltaLocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sAltaLocal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
        doFer(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    
    private void doFer(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session= request.getSession(true);

        String nomLocal = request.getParameter("nomLocal");
        String nomVia = request.getParameter("nomVia");
        String nomCarrer = request.getParameter("nomCarrer");
        String observacions = request.getParameter("observacions");

        Integer codiTipoLocal = Integer.parseInt(request.getParameter("codiTipoLocal"));
        Integer codiCarrer=Integer.parseInt(request.getParameter("codiCarrer"));
        Integer numero = Integer.parseInt(request.getParameter("numero"));

        Local local = new Local();
        local.setNomLocal(nomLocal);
        local.setNomVia(nomVia);
        local.setNomCarrer(nomCarrer);
        local.setObservacions(observacions);

        local.setCoditipoLocal(codiTipoLocal);
        local.setCodiCarrer(codiCarrer);
        local.setNumero(numero);

        try {
            backend.BackendServiceLocator serviceLocator = new BackendServiceLocator();
            backend.Backend port = serviceLocator.getBackendPort();
            port.altaLocal(local);

        }catch(Exception e) {
            e.printStackTrace();
        }

        try {
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/jProves");
            rd.forward(request, response);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
