
package backendservlet;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the backendservlet package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetLocalsByName_QNAME = new QName("http://backendServlet/", "getLocalsByName");
    private final static QName _GetCharacteristics_QNAME = new QName("http://backendServlet/", "getCharacteristics");
    private final static QName _GetIncidencesByIncidenceType_QNAME = new QName("http://backendServlet/", "getIncidencesByIncidenceType");
    private final static QName _GetAllLocalTypes_QNAME = new QName("http://backendServlet/", "getAllLocalTypes");
    private final static QName _GetLocalResponse_QNAME = new QName("http://backendServlet/", "getLocalResponse");
    private final static QName _AddAccessibilityResponse_QNAME = new QName("http://backendServlet/", "addAccessibilityResponse");
    private final static QName _GetLocal_QNAME = new QName("http://backendServlet/", "getLocal");
    private final static QName _GetCharacteristicsResponse_QNAME = new QName("http://backendServlet/", "getCharacteristicsResponse");
    private final static QName _DeleteLocalById_QNAME = new QName("http://backendServlet/", "deleteLocalById");
    private final static QName _GetAllLocalsResponse_QNAME = new QName("http://backendServlet/", "getAllLocalsResponse");
    private final static QName _GetLocalTypeResponse_QNAME = new QName("http://backendServlet/", "getLocalTypeResponse");
    private final static QName _GetIncidenceTypeResponse_QNAME = new QName("http://backendServlet/", "getIncidenceTypeResponse");
    private final static QName _GetLocalsByNameResponse_QNAME = new QName("http://backendServlet/", "getLocalsByNameResponse");
    private final static QName _ValidateLocalResponse_QNAME = new QName("http://backendServlet/", "validateLocalResponse");
    private final static QName _AddAccessibility_QNAME = new QName("http://backendServlet/", "addAccessibility");
    private final static QName _GetIncidencesByDateResponse_QNAME = new QName("http://backendServlet/", "getIncidencesByDateResponse");
    private final static QName _GetLocalsByLocalTypeAndNameResponse_QNAME = new QName("http://backendServlet/", "getLocalsByLocalTypeAndNameResponse");
    private final static QName _AddIncidence_QNAME = new QName("http://backendServlet/", "addIncidence");
    private final static QName _GetIncidencesByDate_QNAME = new QName("http://backendServlet/", "getIncidencesByDate");
    private final static QName _GetLocalType_QNAME = new QName("http://backendServlet/", "getLocalType");
    private final static QName _GetIncidencesByIncidenceTypeResponse_QNAME = new QName("http://backendServlet/", "getIncidencesByIncidenceTypeResponse");
    private final static QName _ValidateLocal_QNAME = new QName("http://backendServlet/", "validateLocal");
    private final static QName _AddLocalResponse_QNAME = new QName("http://backendServlet/", "addLocalResponse");
    private final static QName _GetAllIncidenceTypesResponse_QNAME = new QName("http://backendServlet/", "getAllIncidenceTypesResponse");
    private final static QName _GetAllLocalTypesResponse_QNAME = new QName("http://backendServlet/", "getAllLocalTypesResponse");
    private final static QName _DeleteLocalByIdResponse_QNAME = new QName("http://backendServlet/", "deleteLocalByIdResponse");
    private final static QName _GetLocalsByLocalTypeAndName_QNAME = new QName("http://backendServlet/", "getLocalsByLocalTypeAndName");
    private final static QName _AddIncidenceResponse_QNAME = new QName("http://backendServlet/", "addIncidenceResponse");
    private final static QName _GetAllLocals_QNAME = new QName("http://backendServlet/", "getAllLocals");
    private final static QName _GetAccesibilityByLocalResponse_QNAME = new QName("http://backendServlet/", "getAccesibilityByLocalResponse");
    private final static QName _GetIncidenceType_QNAME = new QName("http://backendServlet/", "getIncidenceType");
    private final static QName _AddLocal_QNAME = new QName("http://backendServlet/", "addLocal");
    private final static QName _GetAccesibilityByLocal_QNAME = new QName("http://backendServlet/", "getAccesibilityByLocal");
    private final static QName _GetAllIncidenceTypes_QNAME = new QName("http://backendServlet/", "getAllIncidenceTypes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: backendservlet
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetIncidenceType }
     * 
     */
    public GetIncidenceType createGetIncidenceType() {
        return new GetIncidenceType();
    }

    /**
     * Create an instance of {@link AddLocal }
     * 
     */
    public AddLocal createAddLocal() {
        return new AddLocal();
    }

    /**
     * Create an instance of {@link GetAccesibilityByLocal }
     * 
     */
    public GetAccesibilityByLocal createGetAccesibilityByLocal() {
        return new GetAccesibilityByLocal();
    }

    /**
     * Create an instance of {@link GetAllIncidenceTypes }
     * 
     */
    public GetAllIncidenceTypes createGetAllIncidenceTypes() {
        return new GetAllIncidenceTypes();
    }

    /**
     * Create an instance of {@link GetAllLocals }
     * 
     */
    public GetAllLocals createGetAllLocals() {
        return new GetAllLocals();
    }

    /**
     * Create an instance of {@link GetAccesibilityByLocalResponse }
     * 
     */
    public GetAccesibilityByLocalResponse createGetAccesibilityByLocalResponse() {
        return new GetAccesibilityByLocalResponse();
    }

    /**
     * Create an instance of {@link AddIncidenceResponse }
     * 
     */
    public AddIncidenceResponse createAddIncidenceResponse() {
        return new AddIncidenceResponse();
    }

    /**
     * Create an instance of {@link GetLocalsByLocalTypeAndName }
     * 
     */
    public GetLocalsByLocalTypeAndName createGetLocalsByLocalTypeAndName() {
        return new GetLocalsByLocalTypeAndName();
    }

    /**
     * Create an instance of {@link GetAllIncidenceTypesResponse }
     * 
     */
    public GetAllIncidenceTypesResponse createGetAllIncidenceTypesResponse() {
        return new GetAllIncidenceTypesResponse();
    }

    /**
     * Create an instance of {@link GetAllLocalTypesResponse }
     * 
     */
    public GetAllLocalTypesResponse createGetAllLocalTypesResponse() {
        return new GetAllLocalTypesResponse();
    }

    /**
     * Create an instance of {@link DeleteLocalByIdResponse }
     * 
     */
    public DeleteLocalByIdResponse createDeleteLocalByIdResponse() {
        return new DeleteLocalByIdResponse();
    }

    /**
     * Create an instance of {@link AddLocalResponse }
     * 
     */
    public AddLocalResponse createAddLocalResponse() {
        return new AddLocalResponse();
    }

    /**
     * Create an instance of {@link GetLocalType }
     * 
     */
    public GetLocalType createGetLocalType() {
        return new GetLocalType();
    }

    /**
     * Create an instance of {@link GetIncidencesByIncidenceTypeResponse }
     * 
     */
    public GetIncidencesByIncidenceTypeResponse createGetIncidencesByIncidenceTypeResponse() {
        return new GetIncidencesByIncidenceTypeResponse();
    }

    /**
     * Create an instance of {@link ValidateLocal }
     * 
     */
    public ValidateLocal createValidateLocal() {
        return new ValidateLocal();
    }

    /**
     * Create an instance of {@link AddIncidence }
     * 
     */
    public AddIncidence createAddIncidence() {
        return new AddIncidence();
    }

    /**
     * Create an instance of {@link GetIncidencesByDate }
     * 
     */
    public GetIncidencesByDate createGetIncidencesByDate() {
        return new GetIncidencesByDate();
    }

    /**
     * Create an instance of {@link AddAccessibility }
     * 
     */
    public AddAccessibility createAddAccessibility() {
        return new AddAccessibility();
    }

    /**
     * Create an instance of {@link GetIncidencesByDateResponse }
     * 
     */
    public GetIncidencesByDateResponse createGetIncidencesByDateResponse() {
        return new GetIncidencesByDateResponse();
    }

    /**
     * Create an instance of {@link GetLocalsByLocalTypeAndNameResponse }
     * 
     */
    public GetLocalsByLocalTypeAndNameResponse createGetLocalsByLocalTypeAndNameResponse() {
        return new GetLocalsByLocalTypeAndNameResponse();
    }

    /**
     * Create an instance of {@link GetAllLocalsResponse }
     * 
     */
    public GetAllLocalsResponse createGetAllLocalsResponse() {
        return new GetAllLocalsResponse();
    }

    /**
     * Create an instance of {@link GetLocalTypeResponse }
     * 
     */
    public GetLocalTypeResponse createGetLocalTypeResponse() {
        return new GetLocalTypeResponse();
    }

    /**
     * Create an instance of {@link GetIncidenceTypeResponse }
     * 
     */
    public GetIncidenceTypeResponse createGetIncidenceTypeResponse() {
        return new GetIncidenceTypeResponse();
    }

    /**
     * Create an instance of {@link GetLocalsByNameResponse }
     * 
     */
    public GetLocalsByNameResponse createGetLocalsByNameResponse() {
        return new GetLocalsByNameResponse();
    }

    /**
     * Create an instance of {@link ValidateLocalResponse }
     * 
     */
    public ValidateLocalResponse createValidateLocalResponse() {
        return new ValidateLocalResponse();
    }

    /**
     * Create an instance of {@link GetCharacteristicsResponse }
     * 
     */
    public GetCharacteristicsResponse createGetCharacteristicsResponse() {
        return new GetCharacteristicsResponse();
    }

    /**
     * Create an instance of {@link DeleteLocalById }
     * 
     */
    public DeleteLocalById createDeleteLocalById() {
        return new DeleteLocalById();
    }

    /**
     * Create an instance of {@link GetLocalResponse }
     * 
     */
    public GetLocalResponse createGetLocalResponse() {
        return new GetLocalResponse();
    }

    /**
     * Create an instance of {@link AddAccessibilityResponse }
     * 
     */
    public AddAccessibilityResponse createAddAccessibilityResponse() {
        return new AddAccessibilityResponse();
    }

    /**
     * Create an instance of {@link GetLocal }
     * 
     */
    public GetLocal createGetLocal() {
        return new GetLocal();
    }

    /**
     * Create an instance of {@link GetAllLocalTypes }
     * 
     */
    public GetAllLocalTypes createGetAllLocalTypes() {
        return new GetAllLocalTypes();
    }

    /**
     * Create an instance of {@link GetLocalsByName }
     * 
     */
    public GetLocalsByName createGetLocalsByName() {
        return new GetLocalsByName();
    }

    /**
     * Create an instance of {@link GetCharacteristics }
     * 
     */
    public GetCharacteristics createGetCharacteristics() {
        return new GetCharacteristics();
    }

    /**
     * Create an instance of {@link GetIncidencesByIncidenceType }
     * 
     */
    public GetIncidencesByIncidenceType createGetIncidencesByIncidenceType() {
        return new GetIncidencesByIncidenceType();
    }

    /**
     * Create an instance of {@link Accessibility }
     * 
     */
    public Accessibility createAccessibility() {
        return new Accessibility();
    }

    /**
     * Create an instance of {@link Local }
     * 
     */
    public Local createLocal() {
        return new Local();
    }

    /**
     * Create an instance of {@link Characteristic }
     * 
     */
    public Characteristic createCharacteristic() {
        return new Characteristic();
    }

    /**
     * Create an instance of {@link IncidenceType }
     * 
     */
    public IncidenceType createIncidenceType() {
        return new IncidenceType();
    }

    /**
     * Create an instance of {@link Timestamp }
     * 
     */
    public Timestamp createTimestamp() {
        return new Timestamp();
    }

    /**
     * Create an instance of {@link Level }
     * 
     */
    public Level createLevel() {
        return new Level();
    }

    /**
     * Create an instance of {@link LocalType }
     * 
     */
    public LocalType createLocalType() {
        return new LocalType();
    }

    /**
     * Create an instance of {@link Incidence }
     * 
     */
    public Incidence createIncidence() {
        return new Incidence();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocalsByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getLocalsByName")
    public JAXBElement<GetLocalsByName> createGetLocalsByName(GetLocalsByName value) {
        return new JAXBElement<GetLocalsByName>(_GetLocalsByName_QNAME, GetLocalsByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCharacteristics }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getCharacteristics")
    public JAXBElement<GetCharacteristics> createGetCharacteristics(GetCharacteristics value) {
        return new JAXBElement<GetCharacteristics>(_GetCharacteristics_QNAME, GetCharacteristics.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIncidencesByIncidenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getIncidencesByIncidenceType")
    public JAXBElement<GetIncidencesByIncidenceType> createGetIncidencesByIncidenceType(GetIncidencesByIncidenceType value) {
        return new JAXBElement<GetIncidencesByIncidenceType>(_GetIncidencesByIncidenceType_QNAME, GetIncidencesByIncidenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllLocalTypes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getAllLocalTypes")
    public JAXBElement<GetAllLocalTypes> createGetAllLocalTypes(GetAllLocalTypes value) {
        return new JAXBElement<GetAllLocalTypes>(_GetAllLocalTypes_QNAME, GetAllLocalTypes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getLocalResponse")
    public JAXBElement<GetLocalResponse> createGetLocalResponse(GetLocalResponse value) {
        return new JAXBElement<GetLocalResponse>(_GetLocalResponse_QNAME, GetLocalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAccessibilityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "addAccessibilityResponse")
    public JAXBElement<AddAccessibilityResponse> createAddAccessibilityResponse(AddAccessibilityResponse value) {
        return new JAXBElement<AddAccessibilityResponse>(_AddAccessibilityResponse_QNAME, AddAccessibilityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getLocal")
    public JAXBElement<GetLocal> createGetLocal(GetLocal value) {
        return new JAXBElement<GetLocal>(_GetLocal_QNAME, GetLocal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCharacteristicsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getCharacteristicsResponse")
    public JAXBElement<GetCharacteristicsResponse> createGetCharacteristicsResponse(GetCharacteristicsResponse value) {
        return new JAXBElement<GetCharacteristicsResponse>(_GetCharacteristicsResponse_QNAME, GetCharacteristicsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteLocalById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "deleteLocalById")
    public JAXBElement<DeleteLocalById> createDeleteLocalById(DeleteLocalById value) {
        return new JAXBElement<DeleteLocalById>(_DeleteLocalById_QNAME, DeleteLocalById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllLocalsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getAllLocalsResponse")
    public JAXBElement<GetAllLocalsResponse> createGetAllLocalsResponse(GetAllLocalsResponse value) {
        return new JAXBElement<GetAllLocalsResponse>(_GetAllLocalsResponse_QNAME, GetAllLocalsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocalTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getLocalTypeResponse")
    public JAXBElement<GetLocalTypeResponse> createGetLocalTypeResponse(GetLocalTypeResponse value) {
        return new JAXBElement<GetLocalTypeResponse>(_GetLocalTypeResponse_QNAME, GetLocalTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIncidenceTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getIncidenceTypeResponse")
    public JAXBElement<GetIncidenceTypeResponse> createGetIncidenceTypeResponse(GetIncidenceTypeResponse value) {
        return new JAXBElement<GetIncidenceTypeResponse>(_GetIncidenceTypeResponse_QNAME, GetIncidenceTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocalsByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getLocalsByNameResponse")
    public JAXBElement<GetLocalsByNameResponse> createGetLocalsByNameResponse(GetLocalsByNameResponse value) {
        return new JAXBElement<GetLocalsByNameResponse>(_GetLocalsByNameResponse_QNAME, GetLocalsByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateLocalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "validateLocalResponse")
    public JAXBElement<ValidateLocalResponse> createValidateLocalResponse(ValidateLocalResponse value) {
        return new JAXBElement<ValidateLocalResponse>(_ValidateLocalResponse_QNAME, ValidateLocalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAccessibility }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "addAccessibility")
    public JAXBElement<AddAccessibility> createAddAccessibility(AddAccessibility value) {
        return new JAXBElement<AddAccessibility>(_AddAccessibility_QNAME, AddAccessibility.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIncidencesByDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getIncidencesByDateResponse")
    public JAXBElement<GetIncidencesByDateResponse> createGetIncidencesByDateResponse(GetIncidencesByDateResponse value) {
        return new JAXBElement<GetIncidencesByDateResponse>(_GetIncidencesByDateResponse_QNAME, GetIncidencesByDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocalsByLocalTypeAndNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getLocalsByLocalTypeAndNameResponse")
    public JAXBElement<GetLocalsByLocalTypeAndNameResponse> createGetLocalsByLocalTypeAndNameResponse(GetLocalsByLocalTypeAndNameResponse value) {
        return new JAXBElement<GetLocalsByLocalTypeAndNameResponse>(_GetLocalsByLocalTypeAndNameResponse_QNAME, GetLocalsByLocalTypeAndNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddIncidence }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "addIncidence")
    public JAXBElement<AddIncidence> createAddIncidence(AddIncidence value) {
        return new JAXBElement<AddIncidence>(_AddIncidence_QNAME, AddIncidence.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIncidencesByDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getIncidencesByDate")
    public JAXBElement<GetIncidencesByDate> createGetIncidencesByDate(GetIncidencesByDate value) {
        return new JAXBElement<GetIncidencesByDate>(_GetIncidencesByDate_QNAME, GetIncidencesByDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocalType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getLocalType")
    public JAXBElement<GetLocalType> createGetLocalType(GetLocalType value) {
        return new JAXBElement<GetLocalType>(_GetLocalType_QNAME, GetLocalType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIncidencesByIncidenceTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getIncidencesByIncidenceTypeResponse")
    public JAXBElement<GetIncidencesByIncidenceTypeResponse> createGetIncidencesByIncidenceTypeResponse(GetIncidencesByIncidenceTypeResponse value) {
        return new JAXBElement<GetIncidencesByIncidenceTypeResponse>(_GetIncidencesByIncidenceTypeResponse_QNAME, GetIncidencesByIncidenceTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateLocal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "validateLocal")
    public JAXBElement<ValidateLocal> createValidateLocal(ValidateLocal value) {
        return new JAXBElement<ValidateLocal>(_ValidateLocal_QNAME, ValidateLocal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLocalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "addLocalResponse")
    public JAXBElement<AddLocalResponse> createAddLocalResponse(AddLocalResponse value) {
        return new JAXBElement<AddLocalResponse>(_AddLocalResponse_QNAME, AddLocalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllIncidenceTypesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getAllIncidenceTypesResponse")
    public JAXBElement<GetAllIncidenceTypesResponse> createGetAllIncidenceTypesResponse(GetAllIncidenceTypesResponse value) {
        return new JAXBElement<GetAllIncidenceTypesResponse>(_GetAllIncidenceTypesResponse_QNAME, GetAllIncidenceTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllLocalTypesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getAllLocalTypesResponse")
    public JAXBElement<GetAllLocalTypesResponse> createGetAllLocalTypesResponse(GetAllLocalTypesResponse value) {
        return new JAXBElement<GetAllLocalTypesResponse>(_GetAllLocalTypesResponse_QNAME, GetAllLocalTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteLocalByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "deleteLocalByIdResponse")
    public JAXBElement<DeleteLocalByIdResponse> createDeleteLocalByIdResponse(DeleteLocalByIdResponse value) {
        return new JAXBElement<DeleteLocalByIdResponse>(_DeleteLocalByIdResponse_QNAME, DeleteLocalByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocalsByLocalTypeAndName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getLocalsByLocalTypeAndName")
    public JAXBElement<GetLocalsByLocalTypeAndName> createGetLocalsByLocalTypeAndName(GetLocalsByLocalTypeAndName value) {
        return new JAXBElement<GetLocalsByLocalTypeAndName>(_GetLocalsByLocalTypeAndName_QNAME, GetLocalsByLocalTypeAndName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddIncidenceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "addIncidenceResponse")
    public JAXBElement<AddIncidenceResponse> createAddIncidenceResponse(AddIncidenceResponse value) {
        return new JAXBElement<AddIncidenceResponse>(_AddIncidenceResponse_QNAME, AddIncidenceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllLocals }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getAllLocals")
    public JAXBElement<GetAllLocals> createGetAllLocals(GetAllLocals value) {
        return new JAXBElement<GetAllLocals>(_GetAllLocals_QNAME, GetAllLocals.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccesibilityByLocalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getAccesibilityByLocalResponse")
    public JAXBElement<GetAccesibilityByLocalResponse> createGetAccesibilityByLocalResponse(GetAccesibilityByLocalResponse value) {
        return new JAXBElement<GetAccesibilityByLocalResponse>(_GetAccesibilityByLocalResponse_QNAME, GetAccesibilityByLocalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIncidenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getIncidenceType")
    public JAXBElement<GetIncidenceType> createGetIncidenceType(GetIncidenceType value) {
        return new JAXBElement<GetIncidenceType>(_GetIncidenceType_QNAME, GetIncidenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddLocal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "addLocal")
    public JAXBElement<AddLocal> createAddLocal(AddLocal value) {
        return new JAXBElement<AddLocal>(_AddLocal_QNAME, AddLocal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccesibilityByLocal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getAccesibilityByLocal")
    public JAXBElement<GetAccesibilityByLocal> createGetAccesibilityByLocal(GetAccesibilityByLocal value) {
        return new JAXBElement<GetAccesibilityByLocal>(_GetAccesibilityByLocal_QNAME, GetAccesibilityByLocal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllIncidenceTypes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://backendServlet/", name = "getAllIncidenceTypes")
    public JAXBElement<GetAllIncidenceTypes> createGetAllIncidenceTypes(GetAllIncidenceTypes value) {
        return new JAXBElement<GetAllIncidenceTypes>(_GetAllIncidenceTypes_QNAME, GetAllIncidenceTypes.class, null, value);
    }

}
