/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.List;

import hospital.*;
import javax.jws.Oneway;

/**
 *
 * @author emilianoeloi
 */
@WebService(serviceName = "HospitalWS")
public class HospitalWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CadastrarHospital")
    public void CadastrarHospital(@WebParam(name = "nome") String nome) {
        
        HospitalDAO hospitalDAO = new HospitalDAO();
        
        HospitalBean hospitalBean = new HospitalBean();
        hospitalBean.setNome(nome);
        
        hospitalDAO.cadastrar(hospitalBean);
        
    }
    
    @WebMethod(operationName = "AlterarHospital")
    public void AlterarHospital(@WebParam(name = "codigo") int codigo, @WebParam(name = "nome") String nome) {
        
        HospitalDAO hospitalDAO = new HospitalDAO();
        
        HospitalBean hospitalBean = new HospitalBean();
        hospitalBean.setCodigo(codigo);
        hospitalBean.setNome(nome);
        
        hospitalDAO.alterar(hospitalBean);
        
    }

    @WebMethod(operationName = "ExcluirHospital")
    @Oneway
    public void ExcluirHospital(@WebParam(name = "codigo") int codigo) {
        HospitalBean hospitalbean = new HospitalBean();
        HospitalDAO hospitalDAO = new HospitalDAO();
        
        hospitalDAO.excluir(hospitalbean);
       
    }
    
    @WebMethod(operationName = "RetornarHospitais")
    public List RetornarHospitais() {
       
        HospitalDAO hospitalDAO = new HospitalDAO();
        
        return hospitalDAO.retornarTodos();
       
    }
    
    @WebMethod(operationName = "RetornarHospitalPorCodigo")
    public HospitalBean RetornarHospitalPorCodigo(@WebParam(name = "codigo") int codigo) {
       
        HospitalDAO hospitalDAO = new HospitalDAO();
        
        return hospitalDAO.retornarPeloCodigo(codigo);
       
    }
}
