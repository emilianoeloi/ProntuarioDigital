/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paciente;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import paciente.*;
import pessoa.*;
import util.*;

/**
 *
 * @author emilianoeloi
 */
@WebServlet(name = "PacienteController", urlPatterns = {"/PacienteController"})
public class PacienteController extends HttpServlet {
    
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
        PessoaDAO daoPessoa = new PessoaDAO();
        PacienteDAO dao;
        PacienteBean paciente = new PacienteBean();
        
        if(acao != null || !acao.equalsIgnoreCase("lista")){
            if( request.getParameter("codigo") != null &&
                request.getParameter("codigo") != "" )
                paciente.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            paciente.setNome(request.getParameter("nome"));
            paciente.setCpf(request.getParameter("cpf"));
            paciente.setId(request.getParameter("id"));
            paciente.setSenha(request.getParameter("senha"));
            paciente.setEmail(request.getParameter("email"));
            paciente.setDataNascimento(convData.converteEmData(request.getParameter("data-nascimento")));
            try{
                paciente.setCodigoPessoa(Integer.parseInt(request.getParameter("codigo-pessoa")));
            }catch(Exception e){
                
            }
        }
        
        try{
            
           dao = new PacienteDAO();
           RequestDispatcher rd = null;
           if(acao.equalsIgnoreCase("listar")){
               List pacientesList = dao.retornarTodos();
               request.setAttribute("pacientesList", pacientesList);
               rd = request.getRequestDispatcher("pacienteLista.jsp");
               
           }else if(acao.equalsIgnoreCase("cadastrar")){
               /// Verificar se existem pessoa com esse CPF
               PessoaBean pessoa = daoPessoa.procurarPeloCpf(paciente);
               if(pessoa.getCodigo() == 0){
                   daoPessoa.cadastrar(paciente);
               }else{
                   paciente.setCodigoPessoa(pessoa.getCodigo());
               }
               dao.cadastrar(paciente);
               request.setAttribute("pacienteSelecionado", paciente);
               rd = request.getRequestDispatcher("MedicoController?acao=formulario");
               
           }else if(acao.equalsIgnoreCase("completarcadastro")){
               /// Verificar se existem pessoa com esse CPF
               dao.cadastrar(paciente);
               request.setAttribute("pacienteSelecionado", paciente);
               
               /// Instanciar Pessoa do médico
               PessoaBean pessoaPaciente = new PessoaBean();
               pessoaPaciente.setCodigo(paciente.getCodigoPessoa());
               pessoaPaciente.setSenha(paciente.getSenha());
               pessoaPaciente.setStatus(2);
               /// Setar senha
               daoPessoa.definirSenha(pessoaPaciente);
               /// Ativar usuário
               daoPessoa.alterarStatus(pessoaPaciente);
               
               rd = request.getRequestDispatcher("PessoaController?acao=confirmarcadastro");
               
           }else if(acao.equalsIgnoreCase("excluir")){
               dao.excluir(paciente);
               rd = request.getRequestDispatcher("MedicoController?acao=listar");
               
           }else if(acao.equalsIgnoreCase("obterum")){
               paciente = dao.retornarPeloCodigo(paciente);
               request.setAttribute("pacienteSelecionado", paciente);
               rd = request.getRequestDispatcher("MedicoController?acao=formulario");
               
           }else if(acao.equalsIgnoreCase("alterar")){
               dao.alterar(paciente);
               request.setAttribute("pacienteSelecionado", paciente);
               rd = request.getRequestDispatcher("MedicoController?acao=formulario");
               
           }else if(acao.equalsIgnoreCase("formulario")){
               rd = request.getRequestDispatcher("pacienteForm.jsp");
               
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
