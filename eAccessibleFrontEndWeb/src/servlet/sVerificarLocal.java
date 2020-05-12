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

/**
 * Servlet implementation class sVerificarLocal
 */
@WebServlet("/sVerificarLocal")
public class sVerificarLocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sVerificarLocal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doFer(request, response);
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

	        
	        Integer codiLocal = Integer.parseInt(request.getParameter("codiLocal"));
	        
	        try {
	            backend.BackendServiceLocator serviceLocator = new BackendServiceLocator();
	            backend.Backend port = serviceLocator.getBackendPort();
	            port.validarLocal(codiLocal);

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
