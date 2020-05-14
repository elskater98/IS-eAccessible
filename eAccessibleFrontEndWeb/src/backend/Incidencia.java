/**
 * Incidencia.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package backend;

public class Incidencia  implements java.io.Serializable {
    private java.lang.Integer codiIncidencia;

    private java.lang.Integer codiTipusIncidencia;

    private java.lang.String data;

    private java.lang.String dataHora;

    public Incidencia() {
    }

    public Incidencia(
           java.lang.Integer codiIncidencia,
           java.lang.Integer codiTipusIncidencia,
           java.lang.String data,
           java.lang.String dataHora) {
           this.codiIncidencia = codiIncidencia;
           this.codiTipusIncidencia = codiTipusIncidencia;
           this.data = data;
           this.dataHora = dataHora;
    }


    /**
     * Gets the codiIncidencia value for this Incidencia.
     * 
     * @return codiIncidencia
     */
    public java.lang.Integer getCodiIncidencia() {
        return codiIncidencia;
    }


    /**
     * Sets the codiIncidencia value for this Incidencia.
     * 
     * @param codiIncidencia
     */
    public void setCodiIncidencia(java.lang.Integer codiIncidencia) {
        this.codiIncidencia = codiIncidencia;
    }


    /**
     * Gets the codiTipusIncidencia value for this Incidencia.
     * 
     * @return codiTipusIncidencia
     */
    public java.lang.Integer getCodiTipusIncidencia() {
        return codiTipusIncidencia;
    }


    /**
     * Sets the codiTipusIncidencia value for this Incidencia.
     * 
     * @param codiTipusIncidencia
     */
    public void setCodiTipusIncidencia(java.lang.Integer codiTipusIncidencia) {
        this.codiTipusIncidencia = codiTipusIncidencia;
    }


    /**
     * Gets the data value for this Incidencia.
     * 
     * @return data
     */
    public java.lang.String getData() {
        return data;
    }


    /**
     * Sets the data value for this Incidencia.
     * 
     * @param data
     */
    public void setData(java.lang.String data) {
        this.data = data;
    }


    /**
     * Gets the dataHora value for this Incidencia.
     * 
     * @return dataHora
     */
    public java.lang.String getDataHora() {
        return dataHora;
    }


    /**
     * Sets the dataHora value for this Incidencia.
     * 
     * @param dataHora
     */
    public void setDataHora(java.lang.String dataHora) {
        this.dataHora = dataHora;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Incidencia)) return false;
        Incidencia other = (Incidencia) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codiIncidencia==null && other.getCodiIncidencia()==null) || 
             (this.codiIncidencia!=null &&
              this.codiIncidencia.equals(other.getCodiIncidencia()))) &&
            ((this.codiTipusIncidencia==null && other.getCodiTipusIncidencia()==null) || 
             (this.codiTipusIncidencia!=null &&
              this.codiTipusIncidencia.equals(other.getCodiTipusIncidencia()))) &&
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            ((this.dataHora==null && other.getDataHora()==null) || 
             (this.dataHora!=null &&
              this.dataHora.equals(other.getDataHora())));
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
        if (getCodiIncidencia() != null) {
            _hashCode += getCodiIncidencia().hashCode();
        }
        if (getCodiTipusIncidencia() != null) {
            _hashCode += getCodiTipusIncidencia().hashCode();
        }
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        if (getDataHora() != null) {
            _hashCode += getDataHora().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Incidencia.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://backend/", "incidencia"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiIncidencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiIncidencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiTipusIncidencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiTipusIncidencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataHora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataHora"));
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
