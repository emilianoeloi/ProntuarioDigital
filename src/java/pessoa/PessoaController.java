/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoa;

import util.ConverteData;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

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
        ConverteData convData = new ConverteData();
        request.setAttribute("convData", convData);
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
            if( request.getParameter("codigo") != null &&
                request.getParameter("codigo") != "" )
                pessoa.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            pessoa.setNome(request.getParameter("nome"));
            pessoa.setCpf(request.getParameter("cpf"));
            pessoa.setId(request.getParameter("id"));
            pessoa.setSenha(request.getParameter("senha"));
            pessoa.setEmail(request.getParameter("email"));
            pessoa.setDataNascimento(convData.converteEmData(request.getParameter("data-nascimento")));
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
               request.setAttribute("pessoaSelecionada", pessoa);
               rd = request.getRequestDispatcher("PessoaController?acao=formulario");
               
           }else if(acao.equalsIgnoreCase("excluir")){
               dao.excluir(pessoa);
               rd = request.getRequestDispatcher("PessoaController?acao=listar");
               
           }else if(acao.equalsIgnoreCase("obterum")){
               pessoa = dao.retornarPeloCodigo(pessoa.getCodigo());
               request.setAttribute("pessoaSelecionada", pessoa);
               rd = request.getRequestDispatcher("PessoaController?acao=formulario");
               
           }else if(acao.equalsIgnoreCase("alterar")){
               dao.alterar(pessoa);
               request.setAttribute("pessoaSelecionada", pessoa);
               rd = request.getRequestDispatcher("PessoaController?acao=formulario");
               
           }else if(acao.equalsIgnoreCase("completar-cadastro")){
               dao.alterar(pessoa);
               request.setAttribute("pessoaPrimeiroCadastro", pessoa);
               String perfil = request.getParameter("perfil");
               request.setAttribute("perfil", perfil);
               rd = request.getRequestDispatcher("escolher-perfil.jsp");
               
           }else if(acao.equalsIgnoreCase("principal")){
               rd = request.getRequestDispatcher("principal.jsp");
               
           }else if(acao.equalsIgnoreCase("autenticar")){
               pessoa = dao.recuperarPorUsuarioSenha(pessoa);
               if(pessoa != null && pessoa.getStatus()==2){
                    sessao.setMaxInactiveInterval(3600);
                    sessao.setAttribute("pessoaLogada", pessoa);
               }
               rd = request.getRequestDispatcher("principal.jsp");
               
           }else if(acao.equalsIgnoreCase("sair")){
               sessao.invalidate();
               rd = request.getRequestDispatcher("index.jsp");
               
           }else if(acao.equalsIgnoreCase("primeiro-cadastro")){
               //pessoa.setSenha("S3nhaP4drao");
               dao.cadastrar(pessoa);
               request.setAttribute("pessoaPrimeiroCadastro", pessoa);
               request.setAttribute("perfil", "pessoa");
               rd = request.getRequestDispatcher("escolher-perfil.jsp");
               
           }else if(acao.equalsIgnoreCase("escolherperfil")){
               request.setAttribute("pessoaPrimeiroCadastro", pessoa);
               String perfil = request.getParameter("perfil");
               request.setAttribute("perfil", perfil);
               rd = request.getRequestDispatcher("escolher-perfil.jsp");
               
           }else if(acao.equalsIgnoreCase("formulario")){
               rd = request.getRequestDispatcher("pessoaForm.jsp");
               
           }else if(acao.equalsIgnoreCase("checklogin")){
               pessoa = dao.procurarPeloEmail(pessoa.getEmail());
               String existe = (pessoa == null) ? "false" : "true";
               request.setAttribute("retorno", existe);
               rd = request.getRequestDispatcher("pessoaAjax.jsp");
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
