/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import servico_client.HospitalBean;
import servico_client.HospitalWS;
import servico_client.RetornarHospitalResponse;

/**
 * REST Web Service
 *
 * @author emilianoeloi
 */
@Path("hospitalwsport")
public class HospitalWSPort {
    private HospitalWS port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HospitalWSPort
     */
    public HospitalWSPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method CadastrarHospital
     * @param nome resource URI parameter
     */
    @PUT
    @Consumes("text/plain")
    @Path("cadastrarhospital/")
    public void putCadastrarHospital(@QueryParam("nome") String nome) {
        try {
            // Call Web Service Operation
            if (port != null) {
                port.cadastrarHospital(nome);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    /**
     * Invokes the SOAP method AlterarHospital
     * @param codigo resource URI parameter
     * @param nome resource URI parameter
     */
    @PUT
    @Consumes("text/plain")
    @Path("alterarhospital/")
    public void putAlterarHospital(@QueryParam("codigo")
            @DefaultValue("0") int codigo, @QueryParam("nome") String nome) {
        try {
            // Call Web Service Operation
            if (port != null) {
                port.alterarHospital(codigo, nome);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    /**
     * Invokes the SOAP method excluirHospital
     * @param codigo resource URI parameter
     */
    @PUT
    @Consumes("text/plain")
    @Path("excluirhospital/")
    public void putExcluirHospital(@QueryParam("codigo")
            @DefaultValue("0") int codigo) {
        try {
            // Call Web Service Operation
            if (port != null) {
                port.excluirHospital(codigo);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    /**
     * Invokes the SOAP method retornarHospital
     * @return an instance of javax.xml.bind.JAXBElement<servico_client.RetornarHospitalResponse>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("retornarhospital/")
    public JAXBElement<RetornarHospitalResponse> getRetornarHospital() {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<java.lang.Object> result = port.retornarHospital();

                class RetornarHospitalResponse_1 extends servico_client.RetornarHospitalResponse {

                    RetornarHospitalResponse_1(java.util.List<java.lang.Object> _return) {
                        this._return = _return;
                    }
                }
                servico_client.RetornarHospitalResponse response = new RetornarHospitalResponse_1(result);
                return new servico_client.ObjectFactory().createRetornarHospitalResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method retornarHospitalPorCodigo
     * @param codigo resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<servico_client.HospitalBean>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("retornarhospitalporcodigo/")
    public JAXBElement<HospitalBean> getRetornarHospitalPorCodigo(@QueryParam("codigo")
            @DefaultValue("0") int codigo) {
        try {
            // Call Web Service Operation
            if (port != null) {
                servico_client.HospitalBean result = port.retornarHospitalPorCodigo(codigo);
                return new JAXBElement<servico_client.HospitalBean>(new QName("http//servico_client/", "hospitalbean"), servico_client.HospitalBean.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private HospitalWS getPort() {
        try {
            // Call Web Service Operation
            servico_client.HospitalWS_Service service = new servico_client.HospitalWS_Service();
            servico_client.HospitalWS p = service.getHospitalWSPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
