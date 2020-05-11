
package backendservlet;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SoapWebServiceService", targetNamespace = "http://backendServlet/", wsdlLocation = "http://localhost:8080/eAccessible-backendWeb/SoapWebService?wsdl")
public class SoapWebServiceService
    extends Service
{

    private final static URL SOAPWEBSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException SOAPWEBSERVICESERVICE_EXCEPTION;
    private final static QName SOAPWEBSERVICESERVICE_QNAME = new QName("http://backendServlet/", "SoapWebServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/eAccessible-backendWeb/SoapWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOAPWEBSERVICESERVICE_WSDL_LOCATION = url;
        SOAPWEBSERVICESERVICE_EXCEPTION = e;
    }

    public SoapWebServiceService() {
        super(__getWsdlLocation(), SOAPWEBSERVICESERVICE_QNAME);
    }

    public SoapWebServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOAPWEBSERVICESERVICE_QNAME, features);
    }

    public SoapWebServiceService(URL wsdlLocation) {
        super(wsdlLocation, SOAPWEBSERVICESERVICE_QNAME);
    }

    public SoapWebServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOAPWEBSERVICESERVICE_QNAME, features);
    }

    public SoapWebServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SoapWebServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SoapWebService
     */
    @WebEndpoint(name = "SoapWebServicePort")
    public SoapWebService getSoapWebServicePort() {
        return super.getPort(new QName("http://backendServlet/", "SoapWebServicePort"), SoapWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SoapWebService
     */
    @WebEndpoint(name = "SoapWebServicePort")
    public SoapWebService getSoapWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://backendServlet/", "SoapWebServicePort"), SoapWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOAPWEBSERVICESERVICE_EXCEPTION!= null) {
            throw SOAPWEBSERVICESERVICE_EXCEPTION;
        }
        return SOAPWEBSERVICESERVICE_WSDL_LOCATION;
    }

}