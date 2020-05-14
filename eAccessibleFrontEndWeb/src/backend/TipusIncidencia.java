/**
 * TipusIncidencia.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package backend;

public class TipusIncidencia  implements java.io.Serializable {
    private java.lang.Integer codiTipusIncidencia;

    private java.lang.String descripcio;

    public TipusIncidencia() {
    }

    public TipusIncidencia(
           java.lang.Integer codiTipusIncidencia,
           java.lang.String descripcio) {
           this.codiTipusIncidencia = codiTipusIncidencia;
           this.descripcio = descripcio;
    }


    /**
     * Gets the codiTipusIncidencia value for this TipusIncidencia.
     * 
     * @return codiTipusIncidencia
     */
    public java.lang.Integer getCodiTipusIncidencia() {
        return codiTipusIncidencia;
    }


    /**
     * Sets the codiTipusIncidencia value for this TipusIncidencia.
     * 
     * @param codiTipusIncidencia
     */
    public void setCodiTipusIncidencia(java.lang.Integer codiTipusIncidencia) {
        this.codiTipusIncidencia = codiTipusIncidencia;
    }


    /**
     * Gets the descripcio value for this TipusIncidencia.
     * 
     * @return descripcio
     */
    public java.lang.String getDescripcio() {
        return descripcio;
    }


    /**
     * Sets the descripcio value for this TipusIncidencia.
     * 
     * @param descripcio
     */
    public void setDescripcio(java.lang.String descripcio) {
        this.descripcio = descripcio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TipusIncidencia)) return false;
        TipusIncidencia other = (TipusIncidencia) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codiTipusIncidencia==null && other.getCodiTipusIncidencia()==null) || 
             (this.codiTipusIncidencia!=null &&
              this.codiTipusIncidencia.equals(other.getCodiTipusIncidencia()))) &&
            ((this.descripcio==null && other.getDescripcio()==null) || 
             (this.descripcio!=null &&
              this.descripcio.equals(other.getDescripcio())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCodiTipusIncidencia() != null) {
            _hashCode += getCodiTipusIncidencia().hashCode();
        }
        if (getDescripcio() != null) {
            _hashCode += getDescripcio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TipusIncidencia.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://backend/", "tipusIncidencia"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiTipusIncidencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiTipusIncidencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
