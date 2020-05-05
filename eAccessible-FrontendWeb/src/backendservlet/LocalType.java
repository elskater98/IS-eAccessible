
package backendservlet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for localType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="localType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nameCA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameEN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "localType", propOrder = {
    "id",
    "nameCA",
    "nameES",
    "nameEN"
})
public class LocalType {

    protected int id;
    protected String nameCA;
    protected String nameES;
    protected String nameEN;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the nameCA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameCA() {
        return nameCA;
    }

    /**
     * Sets the value of the nameCA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameCA(String value) {
        this.nameCA = value;
    }

    /**
     * Gets the value of the nameES property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameES() {
        return nameES;
    }

    /**
     * Sets the value of the nameES property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameES(String value) {
        this.nameES = value;
    }

    /**
     * Gets the value of the nameEN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameEN() {
        return nameEN;
    }

    /**
     * Sets the value of the nameEN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameEN(String value) {
        this.nameEN = value;
    }

}
