/**
 * Accessibilitat.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service2;

public class Accessibilitat  implements java.io.Serializable {
    private java.lang.Integer codiAccessibilitat;

    private java.lang.Integer codiCaracterisitca;

    private java.lang.Integer codiLocal;

    private java.lang.Integer valor;

    private java.lang.String verificat;

    public Accessibilitat() {
    }

    public Accessibilitat(
           java.lang.Integer codiAccessibilitat,
           java.lang.Integer codiCaracterisitca,
           java.lang.Integer codiLocal,
           java.lang.Integer valor,
           java.lang.String verificat) {
           this.codiAccessibilitat = codiAccessibilitat;
           this.codiCaracterisitca = codiCaracterisitca;
           this.codiLocal = codiLocal;
           this.valor = valor;
           this.verificat = verificat;
    }


    /**
     * Gets the codiAccessibilitat value for this Accessibilitat.
     * 
     * @return codiAccessibilitat
     */
    public java.lang.Integer getCodiAccessibilitat() {
        return codiAccessibilitat;
    }


    /**
     * Sets the codiAccessibilitat value for this Accessibilitat.
     * 
     * @param codiAccessibilitat
     */
    public void setCodiAccessibilitat(java.lang.Integer codiAccessibilitat) {
        this.codiAccessibilitat = codiAccessibilitat;
    }


    /**
     * Gets the codiCaracterisitca value for this Accessibilitat.
     * 
     * @return codiCaracterisitca
     */
    public java.lang.Integer getCodiCaracterisitca() {
        return codiCaracterisitca;
    }


    /**
     * Sets the codiCaracterisitca value for this Accessibilitat.
     * 
     * @param codiCaracterisitca
     */
    public void setCodiCaracterisitca(java.lang.Integer codiCaracterisitca) {
        this.codiCaracterisitca = codiCaracterisitca;
    }


    /**
     * Gets the codiLocal value for this Accessibilitat.
     * 
     * @return codiLocal
     */
    public java.lang.Integer getCodiLocal() {
        return codiLocal;
    }


    /**
     * Sets the codiLocal value for this Accessibilitat.
     * 
     * @param codiLocal
     */
    public void setCodiLocal(java.lang.Integer codiLocal) {
        this.codiLocal = codiLocal;
    }


    /**
     * Gets the valor value for this Accessibilitat.
     * 
     * @return valor
     */
    public java.lang.Integer getValor() {
        return valor;
    }


    /**
     * Sets the valor value for this Accessibilitat.
     * 
     * @param valor
     */
    public void setValor(java.lang.Integer valor) {
        this.valor = valor;
    }


    /**
     * Gets the verificat value for this Accessibilitat.
     * 
     * @return verificat
     */
    public java.lang.String getVerificat() {
        return verificat;
    }


    /**
     * Sets the verificat value for this Accessibilitat.
     * 
     * @param verificat
     */
    public void setVerificat(java.lang.String verificat) {
        this.verificat = verificat;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Accessibilitat)) return false;
        Accessibilitat other = (Accessibilitat) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codiAccessibilitat==null && other.getCodiAccessibilitat()==null) || 
             (this.codiAccessibilitat!=null &&
              this.codiAccessibilitat.equals(other.getCodiAccessibilitat()))) &&
            ((this.codiCaracterisitca==null && other.getCodiCaracterisitca()==null) || 
             (this.codiCaracterisitca!=null &&
              this.codiCaracterisitca.equals(other.getCodiCaracterisitca()))) &&
            ((this.codiLocal==null && other.getCodiLocal()==null) || 
             (this.codiLocal!=null &&
              this.codiLocal.equals(other.getCodiLocal()))) &&
            ((this.valor==null && other.getValor()==null) || 
             (this.valor!=null &&
              this.valor.equals(other.getValor()))) &&
            ((this.verificat==null && other.getVerificat()==null) || 
             (this.verificat!=null &&
              this.verificat.equals(other.getVerificat())));
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
        if (getCodiAccessibilitat() != null) {
            _hashCode += getCodiAccessibilitat().hashCode();
        }
        if (getCodiCaracterisitca() != null) {
            _hashCode += getCodiCaracterisitca().hashCode();
        }
        if (getCodiLocal() != null) {
            _hashCode += getCodiLocal().hashCode();
        }
        if (getValor() != null) {
            _hashCode += getValor().hashCode();
        }
        if (getVerificat() != null) {
            _hashCode += getVerificat().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Accessibilitat.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service2/", "accessibilitat"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiAccessibilitat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiAccessibilitat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiCaracterisitca");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiCaracterisitca"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiLocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiLocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verificat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "verificat"));
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
