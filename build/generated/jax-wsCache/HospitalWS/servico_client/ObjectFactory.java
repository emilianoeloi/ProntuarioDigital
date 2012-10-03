
package servico_client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servico_client package. 
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

    private final static QName _ExcluirHospital_QNAME = new QName("http://servico/", "excluirHospital");
    private final static QName _CadastrarHospitalResponse_QNAME = new QName("http://servico/", "CadastrarHospitalResponse");
    private final static QName _RetornarHospital_QNAME = new QName("http://servico/", "retornarHospital");
    private final static QName _AlterarHospitalResponse_QNAME = new QName("http://servico/", "AlterarHospitalResponse");
    private final static QName _CadastrarHospital_QNAME = new QName("http://servico/", "CadastrarHospital");
    private final static QName _RetornarHospitalResponse_QNAME = new QName("http://servico/", "retornarHospitalResponse");
    private final static QName _AlterarHospital_QNAME = new QName("http://servico/", "AlterarHospital");
    private final static QName _RetornarHospitalPorCodigo_QNAME = new QName("http://servico/", "retornarHospitalPorCodigo");
    private final static QName _RetornarHospitalPorCodigoResponse_QNAME = new QName("http://servico/", "retornarHospitalPorCodigoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servico_client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RetornarHospital }
     * 
     */
    public RetornarHospital createRetornarHospital() {
        return new RetornarHospital();
    }

    /**
     * Create an instance of {@link CadastrarHospitalResponse }
     * 
     */
    public CadastrarHospitalResponse createCadastrarHospitalResponse() {
        return new CadastrarHospitalResponse();
    }

    /**
     * Create an instance of {@link ExcluirHospital }
     * 
     */
    public ExcluirHospital createExcluirHospital() {
        return new ExcluirHospital();
    }

    /**
     * Create an instance of {@link RetornarHospitalPorCodigoResponse }
     * 
     */
    public RetornarHospitalPorCodigoResponse createRetornarHospitalPorCodigoResponse() {
        return new RetornarHospitalPorCodigoResponse();
    }

    /**
     * Create an instance of {@link RetornarHospitalPorCodigo }
     * 
     */
    public RetornarHospitalPorCodigo createRetornarHospitalPorCodigo() {
        return new RetornarHospitalPorCodigo();
    }

    /**
     * Create an instance of {@link AlterarHospital }
     * 
     */
    public AlterarHospital createAlterarHospital() {
        return new AlterarHospital();
    }

    /**
     * Create an instance of {@link RetornarHospitalResponse }
     * 
     */
    public RetornarHospitalResponse createRetornarHospitalResponse() {
        return new RetornarHospitalResponse();
    }

    /**
     * Create an instance of {@link CadastrarHospital }
     * 
     */
    public CadastrarHospital createCadastrarHospital() {
        return new CadastrarHospital();
    }

    /**
     * Create an instance of {@link AlterarHospitalResponse }
     * 
     */
    public AlterarHospitalResponse createAlterarHospitalResponse() {
        return new AlterarHospitalResponse();
    }

    /**
     * Create an instance of {@link HospitalBean }
     * 
     */
    public HospitalBean createHospitalBean() {
        return new HospitalBean();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExcluirHospital }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico/", name = "excluirHospital")
    public JAXBElement<ExcluirHospital> createExcluirHospital(ExcluirHospital value) {
        return new JAXBElement<ExcluirHospital>(_ExcluirHospital_QNAME, ExcluirHospital.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarHospitalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico/", name = "CadastrarHospitalResponse")
    public JAXBElement<CadastrarHospitalResponse> createCadastrarHospitalResponse(CadastrarHospitalResponse value) {
        return new JAXBElement<CadastrarHospitalResponse>(_CadastrarHospitalResponse_QNAME, CadastrarHospitalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetornarHospital }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico/", name = "retornarHospital")
    public JAXBElement<RetornarHospital> createRetornarHospital(RetornarHospital value) {
        return new JAXBElement<RetornarHospital>(_RetornarHospital_QNAME, RetornarHospital.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AlterarHospitalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico/", name = "AlterarHospitalResponse")
    public JAXBElement<AlterarHospitalResponse> createAlterarHospitalResponse(AlterarHospitalResponse value) {
        return new JAXBElement<AlterarHospitalResponse>(_AlterarHospitalResponse_QNAME, AlterarHospitalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastrarHospital }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico/", name = "CadastrarHospital")
    public JAXBElement<CadastrarHospital> createCadastrarHospital(CadastrarHospital value) {
        return new JAXBElement<CadastrarHospital>(_CadastrarHospital_QNAME, CadastrarHospital.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetornarHospitalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico/", name = "retornarHospitalResponse")
    public JAXBElement<RetornarHospitalResponse> createRetornarHospitalResponse(RetornarHospitalResponse value) {
        return new JAXBElement<RetornarHospitalResponse>(_RetornarHospitalResponse_QNAME, RetornarHospitalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AlterarHospital }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico/", name = "AlterarHospital")
    public JAXBElement<AlterarHospital> createAlterarHospital(AlterarHospital value) {
        return new JAXBElement<AlterarHospital>(_AlterarHospital_QNAME, AlterarHospital.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetornarHospitalPorCodigo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico/", name = "retornarHospitalPorCodigo")
    public JAXBElement<RetornarHospitalPorCodigo> createRetornarHospitalPorCodigo(RetornarHospitalPorCodigo value) {
        return new JAXBElement<RetornarHospitalPorCodigo>(_RetornarHospitalPorCodigo_QNAME, RetornarHospitalPorCodigo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetornarHospitalPorCodigoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servico/", name = "retornarHospitalPorCodigoResponse")
    public JAXBElement<RetornarHospitalPorCodigoResponse> createRetornarHospitalPorCodigoResponse(RetornarHospitalPorCodigoResponse value) {
        return new JAXBElement<RetornarHospitalPorCodigoResponse>(_RetornarHospitalPorCodigoResponse_QNAME, RetornarHospitalPorCodigoResponse.class, null, value);
    }

}
