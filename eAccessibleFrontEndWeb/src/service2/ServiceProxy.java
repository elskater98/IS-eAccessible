package service2;

public class ServiceProxy implements service2.Service {
  private String _endpoint = null;
  private service2.Service service = null;
  
  public ServiceProxy() {
    _initServiceProxy();
  }
  
  public ServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceProxy();
  }
  
  private void _initServiceProxy() {
    try {
      service = (new service2.ServiceServiceLocator()).getServicePort();
      if (service != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)service)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (service != null)
      ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public service2.Service getService() {
    if (service == null)
      _initServiceProxy();
    return service;
  }
  
  public service2.Local[] getAllLocals() throws java.rmi.RemoteException, service2.BasicException{
    if (service == null)
      _initServiceProxy();
    return service.getAllLocals();
  }
  
  public service2.TipoLocal[] getAllTipusLocal() throws java.rmi.RemoteException, service2.BasicException, service2.Exception{
    if (service == null)
      _initServiceProxy();
    return service.getAllTipusLocal();
  }
  
  public void baixaLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception{
    if (service == null)
      _initServiceProxy();
    service.baixaLocal(arg0);
  }
  
  public void updateLocal(service2.Local arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception{
    if (service == null)
      _initServiceProxy();
    service.updateLocal(arg0);
  }
  
  public service2.Local[] getLocalsByCodiTipusLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception{
    if (service == null)
      _initServiceProxy();
    return service.getLocalsByCodiTipusLocal(arg0);
  }
  
  public void validarLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception{
    if (service == null)
      _initServiceProxy();
    service.validarLocal(arg0);
  }
  
  public service2.Local getLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, service2.BasicException{
    if (service == null)
      _initServiceProxy();
    return service.getLocal(arg0);
  }
  
  public service2.Accessibilitat[] getAccessibilitatByLocalId(java.lang.Integer arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception{
    if (service == null)
      _initServiceProxy();
    return service.getAccessibilitatByLocalId(arg0);
  }
  
  public service2.Caracteristica[] getCharacteristic(java.lang.Integer arg0) throws java.rmi.RemoteException, service2.BasicException{
    if (service == null)
      _initServiceProxy();
    return service.getCharacteristic(arg0);
  }
  
  public service2.Local[] getLocalsByName(java.lang.String arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception{
    if (service == null)
      _initServiceProxy();
    return service.getLocalsByName(arg0);
  }
  
  public void addAccessibilitat(service2.Accessibilitat arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception{
    if (service == null)
      _initServiceProxy();
    service.addAccessibilitat(arg0);
  }
  
  public service2.Local[] getLocalsbyTipusAndName(java.lang.Integer arg0, java.lang.String arg1) throws java.rmi.RemoteException, service2.BasicException{
    if (service == null)
      _initServiceProxy();
    return service.getLocalsbyTipusAndName(arg0, arg1);
  }
  
  public service2.TipoLocal getTipusLocalByCodiLocal(java.lang.Integer arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception{
    if (service == null)
      _initServiceProxy();
    return service.getTipusLocalByCodiLocal(arg0);
  }
  
  public service2.TipoLocal getTipusLocalById(java.lang.Integer arg0) throws java.rmi.RemoteException, service2.BasicException{
    if (service == null)
      _initServiceProxy();
    return service.getTipusLocalById(arg0);
  }
  
  public void altaLocal(service2.Local arg0) throws java.rmi.RemoteException, service2.BasicException, service2.Exception{
    if (service == null)
      _initServiceProxy();
    service.altaLocal(arg0);
  }
  
  
}