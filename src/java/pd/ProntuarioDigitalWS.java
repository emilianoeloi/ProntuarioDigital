/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pd;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author emilianoeloi
 */
@WebService(serviceName = "ProntuarioDigitalWS")
public class ProntuarioDigitalWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "conectar")
    public String conectar(@WebParam(name = "usuario") String usuario, @WebParam(name = "senha") String senha) {
        //TODO write your implementation code here:
        return null;
    }
}
