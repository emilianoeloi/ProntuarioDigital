/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exame;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vilmar
 */
@WebServlet(name = "ExameController", urlPatterns = {"/ExameController"})
public class ExameController extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ExameDAO dao = new ExameDAO();
        ExameBean exame = new ExameBean();
         
        String acao = request.getParameter("acao");
        
        if (acao == null){
            acao = "lista";
        }
        
                
        if(acao != null){
           exame.setNome(request.getParameter("nome"));
           exame.setDescricao(request.getParameter("desc"));
        }
        
       try {
           RequestDispatcher rd = null;
           if (acao.equalsIgnoreCase("cadastrar")){
               dao.cadastrar(exame);
               request.setAttribute("exameSelecionado", exame);
               rd = request.getRequestDispatcher("exameForm.jsp");
               
           } else if(acao.equalsIgnoreCase("Formulario")) {
               rd = request.getRequestDispatcher("exameForm.jsp");
           } else if (acao.equalsIgnoreCase("alterar")){
               
           }
           rd.forward(request, response);
        } catch (Exception e) {            
            e.printStackTrace();
            throw new ServletException(e);
        }
    }


}
