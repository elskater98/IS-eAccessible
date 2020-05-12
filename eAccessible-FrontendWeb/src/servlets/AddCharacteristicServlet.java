package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backendservlet.Accessibility;
import backendservlet.Characteristic;
import backendservlet.Local;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/addCharacteristic")
public class AddCharacteristicServlet extends IntegracioHttpServlet {

    public static final String CHARACTERISTIC_LIST_SESSION = "CHARACTERISTIC_LIST_SESSION";

    private Local local;
    private List<Characteristic> characteristicList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext()
                .getRequestDispatcher("/addCharacteristic.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
	    	//Afegir Local
	        this.local = this.soapWebService.addLocal(this.local);
	
	        //Afegir Accessibilitat
	        List<Accessibility> accessibilityList = new ArrayList<>();
	        for (final Characteristic characteristic : characteristicList) {
	            final Accessibility accessibility = new Accessibility();
	            accessibility.setCharacteristic(characteristic);
	            accessibility.setLocal(this.local);
	            if (req.getParameter(Integer.toString(characteristic.getId())) != null) {
	                accessibility.setValue(1);
	            } else {
	                accessibility.setValue(0);
	            }
	            accessibilityList.add(accessibility);
	        }
        	accessibilityList = this.soapWebService.addAccessibility(accessibilityList);

        	resp.sendRedirect("/eAccessible-FrontendWeb/getLocal?id=" + this.local.getId());
        } catch (RuntimeException e) {
        	resp.sendRedirect("/eAccessible-FrontendWeb/error.jsp");
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        local = (Local) req.getSession(true).getAttribute(AddLocalServlet.MODEL);
        if (local == null) {
            resp.sendRedirect("/eAccessible-FrontendWeb/addLocal");
            return;
        }
        characteristicList = this.soapWebService.getCharacteristics(local.getLocalType());
        req.getSession(true).setAttribute(CHARACTERISTIC_LIST_SESSION, characteristicList);
        super.service(req, resp);
    }
}
