package servlet;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

/**
 * Servlet implementation class SvlaltaLocal
 */
@WebServlet("/altalocal")
public class SvlaltaLocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvlaltaLocal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doFer(request,response);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doFer(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	public void doFer(HttpServletRequest request, HttpServletResponse response) throws RemoteException, ServiceException {
		HttpSession session;

		String nomLocal = request.getParameter("nomLocal");
		String nomVia = request.getParameter("nomVia");
		String nomCarrer = request.getParameter("nomCarrer");
		String observacions = request.getParameter("observacions");
		
		Integer codiTipoLocal = Integer.parseInt(request.getParameter("codiTipoLocal"));
		Integer codiCarrer=Integer.parseInt(request.getParameter("codiCarrer"));
		Integer numero = Integer.parseInt(request.getParameter("numero"));
		
		session = request.getSession(true);
		
		
		service2.Local local = new service2.Local();
		local.setNomLocal(nomLocal);
		local.setNomVia(nomVia);
		local.setNomCarrer(nomCarrer);
		local.setObservacions(observacions);
		
		local.setCoditipoLocal(codiTipoLocal);
		local.setCodiCarrer(codiCarrer);
		local.setNumero(numero);
		
		try {
			service2.ServiceServiceLocator serviceLocator = new service2.ServiceServiceLocator();
			service2.Service port = serviceLocator.getServicePort();
			
			port.altaLocal(local);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		try {
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/JAltaLocal");
			rd.forward(request, response);
		}
		catch ( Exception e ) {e.printStackTrace();}
		
	}


}
