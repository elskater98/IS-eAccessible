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

import backend.Accessibilitat;
import backend.BackendServiceLocator;
import backend.Caracteristica;
import backend.Local;

/**
 * Servlet implementation class sAddFullAccessibilitat
 */
@WebServlet("/sAddFullAccessibilitat")
public class sAddFullAccessibilitat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sAddFullAccessibilitat() {
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

	        
	        Integer len=0;
	        Integer codiTipoLocal = 0;
	        Caracteristica [] ca = null;
	        try {
	            backend.BackendServiceLocator serviceLocator = new BackendServiceLocator();
	            backend.Backend port = serviceLocator.getBackendPort();
	            
	            codiTipoLocal = port.getLocal(Integer.parseInt(request.getParameter("codiLocal"))).getCoditipoLocal();
	            ca = port.getCaracterisitcaTipus(codiTipoLocal);
	            port.deleteFullAccessibilitat(Integer.parseInt(request.getParameter("codiLocal")));
	            
	            
	            for(int i=0; i<ca.length;i++) {
	            	try {
	            		Integer codiLocal = Integer.parseInt(request.getParameter("codiLocal"));
	        	        Integer codiCaracteristica = Integer.parseInt(request.getParameter("caracterisitca_"+i));
	        	        Integer valor = Integer.parseInt(request.getParameter("valor_"+i));
	        	        String verificat = request.getParameter("verificat_"+i);
	        	        
	        	        Accessibilitat ac = new Accessibilitat();
	        	        ac.setCodiLocal(codiLocal);
	        	        ac.setCodiCaracterisitca(codiCaracteristica);
	        	        ac.setValor(valor);
	        	        ac.setVerificat(verificat);
	        	        
	        	        port.addAccessibilitat(ac);
	            	}catch(Exception e) {
	    	            e.printStackTrace();
	    	        }
	            }
	            
	            

	        }catch(Exception e) {
	            e.printStackTrace();
	        }

	        try {
	            ServletContext context = getServletContext();
	            RequestDispatcher rd = context.getRequestDispatcher("/jviewfullAccessibilitat?codiLocal="+Integer.parseInt(request.getParameter("codiLocal")));
	            rd.forward(request, response);

	        }catch(Exception e) {
	            e.printStackTrace();
	        }
	    }

}
