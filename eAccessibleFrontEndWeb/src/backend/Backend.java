/**
 * Backend.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package backend;

public interface Backend extends java.rmi.Remote {
    public backend.TipoLocal[] getAllTipusLocal() throws java.rmi.RemoteException, backend.BasicException, backend.Exception;
    public backend.Local[] getAllLocals() throws java.rmi.RemoteException, backend.BasicException;
    public void baixaLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception;
    public backend.Caracteristica[] getAllCharacteristic() throws java.rmi.RemoteException, backend.BasicException;
    public void updateLocal(backend.Local arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception;
    public backend.Local[] getLocalsByCodiTipusLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception;
    public void deleteFullAccessibilitat(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception;
    public void validarLocal(java.lang.Integer arg0, java.lang.String arg1) throws java.rmi.RemoteException, backend.BasicException, backend.Exception;
    public backend.TipusIncidencia getTipusIncidencia(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException;
    public backend.Caracteristica[] getCaracterisitcaTipus(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception;
    public backend.Local getLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException;
    public backend.Accessibilitat[] getAccessibilitatByLocalId(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception;
    public backend.Incidencia[] getAllIncidencia() throws java.rmi.RemoteException, backend.BasicException;
    public backend.Caracteristica getCharacteristic(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException;
    public backend.Local[] getLocalsByName(java.lang.String arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception;
    public backend.Local[] getAllLocalsNonVerificated() throws java.rmi.RemoteException, backend.BasicException;
    public backend.Local[] getLocalsbyTipusAndName(java.lang.Integer arg0, java.lang.String arg1) throws java.rmi.RemoteException, backend.BasicException;
    public backend.TipoLocal getTipusLocalByCodiLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception;
    public backend.TipoLocal getTipusLocalById(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException;
    public void addAccessibilitat(backend.Accessibilitat arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception;
    public void altaLocal(backend.Local arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception;
}
