/**
 * BackendService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package backend;

public interface BackendService extends javax.xml.rpc.Service {
    public java.lang.String getBackendPortAddress();

    public backend.Backend getBackendPort() throws javax.xml.rpc.ServiceException;

    public backend.Backend getBackendPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
