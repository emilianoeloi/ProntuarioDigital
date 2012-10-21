/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

import ferramenta.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import pessoa.*;

/**
 *
 * @author emilianoeloi
 */
@WebServlet(name = "PessoaController", urlPatterns = {"/PessoaController"})
public class PessoaController extends HttpServlet {
    
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {
        /// sessao
        HttpSession sessao = request.getSession(true);
        
        /// Receber variavel de acao
        String acao = request.getParameter("acao");
        
        /// Acao Padao
        if(acao == null)
            acao = "listar";
        
        /// Instanciar bean/dao - Data Access Object
        InterfacePessoaDAO dao;
        PessoaBean pessoa = new PessoaBean();
        
        
        if(acao != null || !acao.equalsIgnoreCase("lista")){
            pessoa.setNome(request.getParameter("nome"));
            pessoa.setCpf(request.getParameter("cpf"));
            pessoa.setId(request.getParameter("id"));
            pessoa.setSenha(request.getParameter("senha"));
            pessoa.setEmail(request.getParameter("email"));
        }
        
        try{
            
           dao = new PessoaDAO();
           RequestDispatcher rd = null;
           if(acao.equalsIgnoreCase("listar")){
               List pessoasList = dao.retornarTodos();
               request.setAttribute("pessoasList", pessoasList);
               rd = request.getRequestDispatcher("pessoaLista.jsp");
           }else if(acao.equalsIgnoreCase("cadastrar")){
               dao.cadastrar(pessoa);
               rd = request.getRequestDispatcher("PesssoaController?acao=listar");
           }else if(acao.equalsIgnoreCase("excluir")){
               dao.excluir(pessoa);
               rd = request.getRequestDispatcher("PesssoaController?acao=listar");
           }else if(acao.equalsIgnoreCase("obterum")){
               pessoa = dao.retornarPeloCodigo(pessoa.getCodigo());
               sessao.setAttribute("pessoa", pessoa);
               rd = request.getRequestDispatcher("PessoaController?acao=listar");
           }else if(acao.equalsIgnoreCase("alterar")){
               dao.alterar(pessoa);
               rd = request.getRequestDispatcher("PessoaController?acao=listar");
           }else if(acao.equalsIgnoreCase("principal")){
               rd = request.getRequestDispatcher("principal.jsp");
           }else if(acao.equalsIgnoreCase("autenticar")){
               pessoa = dao.recuperarPorUsuarioSenha(pessoa);
               if(pessoa != null){
                    sessao.setMaxInactiveInterval(3600);
                    sessao.setAttribute("pessoaLogada", pessoa);
               }
               rd = request.getRequestDispatcher("principal.jsp");
           }
           rd.forward(request, response);

        }catch(Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
        
    }

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
