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
import javax.servlet.RequestDispatcher;
import pessoa.*;

/**
 *
 * @author emilianoeloi
 */
@WebServlet(name = "PessoaController", urlPatterns = {"/PessoaController"})
public class PessoaController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PessoaDAO dao = new PessoaDAO();
        String paginaView = "pessoaLista.jsp";
        try {
            
            int acao = ControleAcao.getCodigoByAcao( (String)request.getParameter("acao") );
            switch(acao){
                case 0: /// Cadastrar
                    PessoaBean pessoaSalvar = new PessoaBean();
                    pessoaSalvar.setCpf((String)request.getParameter("cpf"));
                    pessoaSalvar.setNome((String)request.getParameter("nome"));
                    pessoaSalvar.setId((String)request.getParameter("id"));
                    //pessoaSalvar.setDataNascimento(Date.parse((String)request.getParameter("data-nascimento")));
                    pessoaSalvar.setSenha((String)request.getParameter("senha"));
                    
                    dao.cadastrar(pessoaSalvar);
                    
                    request.setAttribute("acao", "listar");
                    
                    break;
                case 1: /// Alterar
                    PessoaBean pessoaAlterar = new PessoaBean();
                    pessoaAlterar.setCpf((String)request.getParameter("cpf"));
                    pessoaAlterar.setNome((String)request.getParameter("nome"));
                    pessoaAlterar.setId((String)request.getParameter("id"));
                    //pessoaSalvar.setDataNascimento(Date.parse((String)request.getParameter("data-nascimento")));
                    pessoaAlterar.setSenha((String)request.getParameter("senha"));
                    
                    dao.alterar(pessoaAlterar);
                    break;
                case 2: /// Excluir
                    break;
                case 3: /// Obter 1 Pessoa
                    break;
                case 4: /// Listar
                    break;
                case 5: // Formulário de cadastro
                    paginaView = "pessoaForm.jsp";
                    break;
                default:
                    break;
            }
            
            RequestDispatcher view = request.getRequestDispatcher(paginaView);
            view.forward(request, response);
            
        } finally {            
            out.close();
        }
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
