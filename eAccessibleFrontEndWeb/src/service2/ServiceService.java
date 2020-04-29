/**
 * ServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service2;

public interface ServiceService extends javax.xml.rpc.Service {
    public java.lang.String getServicePortAddress();

    public service2.Service getServicePort() throws javax.xml.rpc.ServiceException;

    public service2.Service getServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
