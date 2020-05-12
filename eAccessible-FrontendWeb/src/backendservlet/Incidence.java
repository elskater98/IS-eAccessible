
package backendservlet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for incidence complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="incidence">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="timestamp" type="{http://backendServlet/}timestamp" minOccurs="0"/>
 *         &lt;element name="incidenceType" type="{http://backendServlet/}incidenceType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "incidence", propOrder = {
    "id",
    "date",
    "timestamp",
    "incidenceType"
})
public class Incidence {

    protected int id;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    protected Timestamp timestamp;
    protected IncidenceType incidenceType;

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
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link Timestamp }
     *     
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Timestamp }
     *     
     */
    public void setTimestamp(Timestamp value) {
        this.timestamp = value;
    }

    /**
     * Gets the value of the incidenceType property.
     * 
     * @return
     *     possible object is
     *     {@link IncidenceType }
     *     
     */
    public IncidenceType getIncidenceType() {
        return incidenceType;
    }

    /**
     * Sets the value of the incidenceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncidenceType }
     *     
     */
    public void setIncidenceType(IncidenceType value) {
        this.incidenceType = value;
    }

}
