
package servico_client;

import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-2b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HospitalWS", targetNamespace = "http://servico/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HospitalWS {


    /**
     * 
     * @param nome
     */
    @WebMethod(operationName = "CadastrarHospital")
    @RequestWrapper(localName = "CadastrarHospital", targetNamespace = "http://servico/", className = "servico_client.CadastrarHospital")
    @ResponseWrapper(localName = "CadastrarHospitalResponse", targetNamespace = "http://servico/", className = "servico_client.CadastrarHospitalResponse")
    @Action(input = "http://servico/HospitalWS/CadastrarHospitalRequest", output = "http://servico/HospitalWS/CadastrarHospitalResponse")
    public void cadastrarHospital(
        @WebParam(name = "nome", targetNamespace = "")
        String nome);

    /**
     * 
     * @param codigo
     * @param nome
     */
    @WebMethod(operationName = "AlterarHospital")
    @RequestWrapper(localName = "AlterarHospital", targetNamespace = "http://servico/", className = "servico_client.AlterarHospital")
    @ResponseWrapper(localName = "AlterarHospitalResponse", targetNamespace = "http://servico/", className = "servico_client.AlterarHospitalResponse")
    @Action(input = "http://servico/HospitalWS/AlterarHospitalRequest", output = "http://servico/HospitalWS/AlterarHospitalResponse")
    public void alterarHospital(
        @WebParam(name = "codigo", targetNamespace = "")
        int codigo,
        @WebParam(name = "nome", targetNamespace = "")
        String nome);

    /**
     * 
     * @param codigo
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "excluirHospital", targetNamespace = "http://servico/", className = "servico_client.ExcluirHospital")
    @Action(input = "http://servico/HospitalWS/excluirHospital")
    public void excluirHospital(
        @WebParam(name = "codigo", targetNamespace = "")
        int codigo);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.Object>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retornarHospital", targetNamespace = "http://servico/", className = "servico_client.RetornarHospital")
    @ResponseWrapper(localName = "retornarHospitalResponse", targetNamespace = "http://servico/", className = "servico_client.RetornarHospitalResponse")
    @Action(input = "http://servico/HospitalWS/retornarHospitalRequest", output = "http://servico/HospitalWS/retornarHospitalResponse")
    public List<Object> retornarHospital();

    /**
     * 
     * @param codigo
     * @return
     *     returns servico_client.HospitalBean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retornarHospitalPorCodigo", targetNamespace = "http://servico/", className = "servico_client.RetornarHospitalPorCodigo")
    @ResponseWrapper(localName = "retornarHospitalPorCodigoResponse", targetNamespace = "http://servico/", className = "servico_client.RetornarHospitalPorCodigoResponse")
    @Action(input = "http://servico/HospitalWS/retornarHospitalPorCodigoRequest", output = "http://servico/HospitalWS/retornarHospitalPorCodigoResponse")
    public HospitalBean retornarHospitalPorCodigo(
        @WebParam(name = "codigo", targetNamespace = "")
        int codigo);

}