/**
 * Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service2;

public interface Service extends java.rmi.Remote {
    public service2.Local[] getAllLocals() throws java.rmi.RemoteException, service2.BasicException;
    public service2.TipoLocal[] getAllTipusLocal() throws java.rmi.RemoteException, service2.BasicException, service2.Exception;
    public void baixaLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception;
    public void updateLocal(service2.Local arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception;
    public service2.Local[] getLocalsByCodiTipusLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception;
    public void validarLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception;
    public service2.Local getLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, service2.BasicException;
    public service2.Accessibilitat[] getAccessibilitatByLocalId(java.lang.Integer arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception;
    public service2.Caracteristica[] getCharacteristic(java.lang.Integer arg0) throws java.rmi.RemoteException, service2.BasicException;
    public service2.Local[] getLocalsByName(java.lang.String arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception;
    public void addAccessibilitat(service2.Accessibilitat arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception;
    public service2.Local[] getLocalsbyTipusAndName(java.lang.Integer arg0, java.lang.String arg1) throws java.rmi.RemoteException, service2.BasicException;
    public service2.TipoLocal getTipusLocalByCodiLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception;
    public service2.TipoLocal getTipusLocalById(java.lang.Integer arg0) throws java.rmi.RemoteException, service2.BasicException;
    public void altaLocal(service2.Local arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception;
}
