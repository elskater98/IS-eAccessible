
package backendservlet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for local complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="local">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="localType" type="{http://backendServlet/}localType" minOccurs="0"/>
 *         &lt;element name="idStreet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="streetType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="observations" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="verified" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="urlCA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urlES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urlEN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urlGoogleMapsCA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urlGoogleMapsES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urlGoogleMapsEN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coorX" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="coorY" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "local", propOrder = {
    "id",
    "localType",
    "idStreet",
    "street",
    "streetType",
    "number",
    "name",
    "observations",
    "verified",
    "urlCA",
    "urlES",
    "urlEN",
    "urlGoogleMapsCA",
    "urlGoogleMapsES",
    "urlGoogleMapsEN",
    "coorX",
    "coorY"
})
public class Local {

    protected int id;
    protected LocalType localType;
    protected int idStreet;
    protected String street;
    protected String streetType;
    protected int number;
    protected String name;
    protected String observations;
    @XmlSchemaType(name = "unsignedShort")
    protected int verified;
    protected String urlCA;
    protected String urlES;
    protected String urlEN;
    protected String urlGoogleMapsCA;
    protected String urlGoogleMapsES;
    protected String urlGoogleMapsEN;
    protected float coorX;
    protected float coorY;

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
     * Gets the value of the localType property.
     * 
     * @return
     *     possible object is
     *     {@link LocalType }
     *     
     */
    public LocalType getLocalType() {
        return localType;
    }

    /**
     * Sets the value of the localType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalType }
     *     
     */
    public void setLocalType(LocalType value) {
        this.localType = value;
    }

    /**
     * Gets the value of the idStreet property.
     * 
     */
    public int getIdStreet() {
        return idStreet;
    }

    /**
     * Sets the value of the idStreet property.
     * 
     */
    public void setIdStreet(int value) {
        this.idStreet = value;
    }

    /**
     * Gets the value of the street property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the value of the street property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * Gets the value of the streetType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetType() {
        return streetType;
    }

    /**
     * Sets the value of the streetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetType(String value) {
        this.streetType = value;
    }

    /**
     * Gets the value of the number property.
     * 
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     */
    public void setNumber(int value) {
        this.number = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the observations property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservations() {
        return observations;
    }

    /**
     * Sets the value of the observations property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservations(String value) {
        this.observations = value;
    }

    /**
     * Gets the value of the verified property.
     * 
     */
    public int getVerified() {
        return verified;
    }

    /**
     * Sets the value of the verified property.
     * 
     */
    public void setVerified(int value) {
        this.verified = value;
    }

    /**
     * Gets the value of the urlCA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlCA() {
        return urlCA;
    }

    /**
     * Sets the value of the urlCA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlCA(String value) {
        this.urlCA = value;
    }

    /**
     * Gets the value of the urlES property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlES() {
        return urlES;
    }

    /**
     * Sets the value of the urlES property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlES(String value) {
        this.urlES = value;
    }

    /**
     * Gets the value of the urlEN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlEN() {
        return urlEN;
    }

    /**
     * Sets the value of the urlEN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlEN(String value) {
        this.urlEN = value;
    }

    /**
     * Gets the value of the urlGoogleMapsCA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlGoogleMapsCA() {
        return urlGoogleMapsCA;
    }

    /**
     * Sets the value of the urlGoogleMapsCA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlGoogleMapsCA(String value) {
        this.urlGoogleMapsCA = value;
    }

    /**
     * Gets the value of the urlGoogleMapsES property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlGoogleMapsES() {
        return urlGoogleMapsES;
    }

    /**
     * Sets the value of the urlGoogleMapsES property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlGoogleMapsES(String value) {
        this.urlGoogleMapsES = value;
    }

    /**
     * Gets the value of the urlGoogleMapsEN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlGoogleMapsEN() {
        return urlGoogleMapsEN;
    }

    /**
     * Sets the value of the urlGoogleMapsEN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlGoogleMapsEN(String value) {
        this.urlGoogleMapsEN = value;
    }

    /**
     * Gets the value of the coorX property.
     * 
     */
    public float getCoorX() {
        return coorX;
    }

    /**
     * Sets the value of the coorX property.
     * 
     */
    public void setCoorX(float value) {
        this.coorX = value;
    }

    /**
     * Gets the value of the coorY property.
     * 
     */
    public float getCoorY() {
        return coorY;
    }

    /**
     * Sets the value of the coorY property.
     * 
     */
    public void setCoorY(float value) {
        this.coorY = value;
    }

}
