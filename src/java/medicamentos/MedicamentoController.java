/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 */
package medicamentos;

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
 * @author vilmar
 */
@WebServlet(name = "MedicamentoController", urlPatterns = {"/MedicamentoController"})
public class MedicamentoController extends HttpServlet{ 

    protected void service (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        MedicamentoDAO dao = new MedicamentoDAO();
        MedicamentoBean medicamento = new MedicamentoBean();
         
        String acao = request.getParameter("acao");
        
        if (acao == null){
            acao = "listar";
        }
        
                
        if(acao != null){
           if (request.getParameter("codigo") != null && request.getParameter("codigo") !="" ){
               medicamento.setCodigo(Integer.parseInt(request.getParameter("codigo"))); 
           }
           
           medicamento.setMedicamento(request.getParameter("nome"));

        }
        
       try {
           RequestDispatcher rd = null;
           if (acao.equalsIgnoreCase("cadastrar")){
               dao.cadastrar(medicamento);
               request.setAttribute("medicamentoSelecionado", medicamento);
               rd = request.getRequestDispatcher("medicamentoForm.jsp");
               
           } else if(acao.equalsIgnoreCase("listar")) {
               List medicamentoList = dao.retornarTodos();
               request.setAttribute("medicamentoList", medicamentoList);
               rd = request.getRequestDispatcher("medicamentoLista.jsp");
                              
           } else if (acao.equalsIgnoreCase("excluir")){
               dao.excluir(medicamento);
               rd = request.getRequestDispatcher("MedicamentoController?acao=listar");
           
           } else if (acao.equalsIgnoreCase("obterum")){
            
               medicamento = dao.retornarPeloCodigo(medicamento.getCodigo());
               request.setAttribute("medicamentoSelecionado", medicamento);
               rd = request.getRequestDispatcher("MedicamentoController?acao=formulario");

           } else if(acao.equalsIgnoreCase("Formulario")) {
               rd = request.getRequestDispatcher("medicamentoForm.jsp");
           
           } else if (acao.equalsIgnoreCase("alterar")){
               dao.alterar(medicamento);
               request.setAttribute("medicamentoSelecionado", medicamento);
               rd = request.getRequestDispatcher("MedicamentoController?acao=formulario");
           }
           rd.forward(request, response);
        } catch (Exception e) {            
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
