package backend;

public class BackendProxy implements backend.Backend {
  private String _endpoint = null;
  private backend.Backend backend = null;
  
  public BackendProxy() {
    _initBackendProxy();
  }
  
  public BackendProxy(String endpoint) {
    _endpoint = endpoint;
    _initBackendProxy();
  }
  
  private void _initBackendProxy() {
    try {
      backend = (new backend.BackendServiceLocator()).getBackendPort();
      if (backend != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)backend)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)backend)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (backend != null)
      ((javax.xml.rpc.Stub)backend)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public backend.Backend getBackend() {
    if (backend == null)
      _initBackendProxy();
    return backend;
  }
  
  public backend.TipoLocal[] getAllTipusLocal() throws java.rmi.RemoteException, backend.BasicException, backend.Exception{
    if (backend == null)
      _initBackendProxy();
    return backend.getAllTipusLocal();
  }
  
  public backend.Local[] getAllLocals() throws java.rmi.RemoteException, backend.BasicException{
    if (backend == null)
      _initBackendProxy();
    return backend.getAllLocals();
  }
  
  public void baixaLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception{
    if (backend == null)
      _initBackendProxy();
    backend.baixaLocal(arg0);
  }
  
  public backend.Caracteristica[] getAllCharacteristic() throws java.rmi.RemoteException, backend.BasicException{
    if (backend == null)
      _initBackendProxy();
    return backend.getAllCharacteristic();
  }
  
  public void updateLocal(backend.Local arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception{
    if (backend == null)
      _initBackendProxy();
    backend.updateLocal(arg0);
  }
  
  public backend.Local[] getLocalsByCodiTipusLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception{
    if (backend == null)
      _initBackendProxy();
    return backend.getLocalsByCodiTipusLocal(arg0);
  }
  
  public void validarLocal(java.lang.Integer arg0, java.lang.String arg1) throws java.rmi.RemoteException, backend.BasicException, backend.Exception{
    if (backend == null)
      _initBackendProxy();
    backend.validarLocal(arg0, arg1);
  }
  
  public backend.Caracteristica[] getCaracterisitcaTipus(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception{
    if (backend == null)
      _initBackendProxy();
    return backend.getCaracterisitcaTipus(arg0);
  }
  
  public backend.Local getLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException{
    if (backend == null)
      _initBackendProxy();
    return backend.getLocal(arg0);
  }
  
  public backend.Accessibilitat[] getAccessibilitatByLocalId(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception{
    if (backend == null)
      _initBackendProxy();
    return backend.getAccessibilitatByLocalId(arg0);
  }
  
  public backend.Caracteristica getCharacteristic(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException{
    if (backend == null)
      _initBackendProxy();
    return backend.getCharacteristic(arg0);
  }
  
  public backend.Local[] getLocalsByName(java.lang.String arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception{
    if (backend == null)
      _initBackendProxy();
    return backend.getLocalsByName(arg0);
  }
  
  public backend.Local[] getAllLocalsNonVerificated() throws java.rmi.RemoteException, backend.BasicException{
    if (backend == null)
      _initBackendProxy();
    return backend.getAllLocalsNonVerificated();
  }
  
  public backend.Local[] getLocalsbyTipusAndName(java.lang.Integer arg0, java.lang.String arg1) throws java.rmi.RemoteException, backend.BasicException{
    if (backend == null)
      _initBackendProxy();
    return backend.getLocalsbyTipusAndName(arg0, arg1);
  }
  
  public backend.TipoLocal getTipusLocalByCodiLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception{
    if (backend == null)
      _initBackendProxy();
    return backend.getTipusLocalByCodiLocal(arg0);
  }
  
  public backend.TipoLocal getTipusLocalById(java.lang.Integer arg0) throws java.rmi.RemoteException, backend.BasicException{
    if (backend == null)
      _initBackendProxy();
    return backend.getTipusLocalById(arg0);
  }
  
  public void addAccessibilitat(backend.Accessibilitat arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception{
    if (backend == null)
      _initBackendProxy();
    backend.addAccessibilitat(arg0);
  }
  
  public void altaLocal(backend.Local arg0) throws java.rmi.RemoteException, backend.BasicException, backend.Exception{
    if (backend == null)
      _initBackendProxy();
    backend.altaLocal(arg0);
  }
  
  
}