/**
 * BackendServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package backend;

public class BackendServiceLocator extends org.apache.axis.client.Service implements backend.BackendService {

    public BackendServiceLocator() {
    }


    public BackendServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BackendServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BackendPort
    private java.lang.String BackendPort_address = "http://localhost:8080/eAccessibleBackEndWeb/Backend";

    public java.lang.String getBackendPortAddress() {
        return BackendPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BackendPortWSDDServiceName = "BackendPort";

    public java.lang.String getBackendPortWSDDServiceName() {
        return BackendPortWSDDServiceName;
    }

    public void setBackendPortWSDDServiceName(java.lang.String name) {
        BackendPortWSDDServiceName = name;
    }

    public backend.Backend getBackendPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BackendPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBackendPort(endpoint);
    }

    public backend.Backend getBackendPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            backend.BackendServiceSoapBindingStub _stub = new backend.BackendServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getBackendPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBackendPortEndpointAddress(java.lang.String address) {
        BackendPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (backend.Backend.class.isAssignableFrom(serviceEndpointInterface)) {
                backend.BackendServiceSoapBindingStub _stub = new backend.BackendServiceSoapBindingStub(new java.net.URL(BackendPort_address), this);
                _stub.setPortName(getBackendPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BackendPort".equals(inputPortName)) {
            return getBackendPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://backend/", "BackendService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://backend/", "BackendPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BackendPort".equals(portName)) {
            setBackendPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
