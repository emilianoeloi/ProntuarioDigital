/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 */
package hospital;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Enumeration;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author emilianoeloi
 */
@WebServlet(name = "HospitalController", urlPatterns = {"/HospitalController"})
public class HospitalController extends HttpServlet{ 

    protected void service (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HospitalDAO dao = new HospitalDAO();
        HospitalBean hospital = new HospitalBean();
         
        String acao = request.getParameter("acao");
        
        if (acao == null){
            acao = "listar";
        }
        
                
        if(acao != null){
           if (request.getParameter("codigo") != null && request.getParameter("codigo") !="" ){
               hospital.setCodigo(Integer.parseInt(request.getParameter("codigo"))); 
           }
           
           hospital.setNome(request.getParameter("nome"));

        }
        
       try {
           RequestDispatcher rd = null;
           if (acao.equalsIgnoreCase("cadastrar")){
               dao.cadastrar(hospital);
               request.setAttribute("hospitalSelecionado", hospital);
               rd = request.getRequestDispatcher("hospitalForm.jsp");
               
           } else if(acao.equalsIgnoreCase("listar")) {
               List hospitalList = dao.retornarTodos();
               request.setAttribute("hospitalList", hospitalList);
               rd = request.getRequestDispatcher("hospitalLista.jsp");
                              
           } else if (acao.equalsIgnoreCase("excluir")){
               dao.excluir(hospital);
               rd = request.getRequestDispatcher("HospitalController?acao=listar");
           
           } else if (acao.equalsIgnoreCase("obterum")){
            
               hospital = dao.retornarPeloCodigo(hospital.getCodigo());
               request.setAttribute("hospitalSelecionado", hospital);
               rd = request.getRequestDispatcher("HospitalController?acao=formulario");

           } else if(acao.equalsIgnoreCase("Formulario")) {
               rd = request.getRequestDispatcher("hospitalForm.jsp");
           
           } else if (acao.equalsIgnoreCase("alterar")){
               dao.alterar(hospital);
               request.setAttribute("hospitalSelecionado", hospital);
               rd = request.getRequestDispatcher("HospitalController?acao=formulario");
           } else if (acao.equalsIgnoreCase("combo")){
               String selecionado = request.getParameter("codigo_hospital");
               List hospitalList = dao.retornarTodos();
               request.setAttribute("hospitalList", hospitalList);
               request.setAttribute("hospitalSelecionado", selecionado);
               rd = request.getRequestDispatcher("comboHospital.jsp");
           
           }
           
           
           rd.forward(request, response);
        } catch (Exception e) {            
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
