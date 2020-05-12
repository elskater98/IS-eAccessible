package servlets;

import javax.servlet.http.HttpServlet;

import backendservlet.SoapWebService;
import backendservlet.SoapWebServiceService;

@SuppressWarnings("serial")
public abstract class IntegracioHttpServlet extends HttpServlet {

    protected final SoapWebService soapWebService;

    public IntegracioHttpServlet() {
        final SoapWebServiceService service = new SoapWebServiceService();
        this.soapWebService = service.getSoapWebServicePort();
    }

}
