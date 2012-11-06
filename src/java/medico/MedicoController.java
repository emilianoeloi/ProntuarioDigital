/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package medico;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import pessoa.*;
import util.ConverteData;

/**
 *
 * @author emilianoeloi
 */
@WebServlet(name = "MedicoController", urlPatterns = {"/MedicoController"})
public class MedicoController extends HttpServlet {
    
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
        MedicoDAO dao;
        MedicoBean medico = new MedicoBean();
        
        if(acao != null || !acao.equalsIgnoreCase("lista")){
            if( request.getParameter("codigo") != null &&
                request.getParameter("codigo") != "" )
                medico.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            medico.setNome(request.getParameter("nome"));
            medico.setCpf(request.getParameter("cpf"));
            medico.setId(request.getParameter("id"));
            medico.setSenha(request.getParameter("senha"));
            medico.setEmail(request.getParameter("email"));
            medico.setDataNascimento(convData.converteEmData(request.getParameter("data-nascimento")));
            medico.setCrm(request.getParameter("crm"));
            try{
                medico.setCodigoPessoa(Integer.parseInt(request.getParameter("codigo-pessoa")));
            }catch(Exception e){
                
            }
            try{
                medico.setCodigoHospital(Integer.parseInt(request.getParameter("codigo-hospital")));
            }catch(Exception e){
                
            }
        }
        
        try{
            
           dao = new MedicoDAO();
           RequestDispatcher rd = null;
           if(acao.equalsIgnoreCase("listar")){
               List medicosList = dao.retornarTodos();
               request.setAttribute("medicosList", medicosList);
               rd = request.getRequestDispatcher("medicoLista.jsp");
               
           }else if(acao.equalsIgnoreCase("cadastrar")){
               /// Verificar se existem pessoa com esse CPF
               PessoaBean pessoa = daoPessoa.procurarPeloCpf(medico);
               if(pessoa.getCodigo() == 0){
                   daoPessoa.cadastrar(medico);
               }else{
                   medico.setCodigoPessoa(pessoa.getCodigo());
               }
               
               dao.cadastrar(medico);
               request.setAttribute("medicoSelecionado", medico);
               
               /// Hospital do Médico
               if(medico.getCodigoHospital() != 0)
                    dao.cadastrarHospitalMedico(medico);
               
               rd = request.getRequestDispatcher("MedicoController?acao=formulario");
               
           }else if(acao.equalsIgnoreCase("completarcadastro")){
               /// Verificar se existem pessoa com esse CPF
               dao.cadastrar(medico);
               request.setAttribute("medicoSelecionado", medico);
               
               /// Instanciar Pessoa do médico
               PessoaBean pessoaMedico = new PessoaBean();
               pessoaMedico.setCodigo(medico.getCodigoPessoa());
               pessoaMedico.setSenha(medico.getSenha());
               pessoaMedico.setStatus(2);
               /// Setar senha
               daoPessoa.definirSenha(pessoaMedico);
               /// Ativar usuário
               daoPessoa.alterarStatus(pessoaMedico);
               
               /// Hospital do Médico
               if(medico.getCodigoHospital() != 0)
                    dao.cadastrarHospitalMedico(medico);
               
               rd = request.getRequestDispatcher("PessoaController?acao=confirmarcadastro");
               
           }else if(acao.equalsIgnoreCase("excluir")){
               dao.excluir(medico);
               rd = request.getRequestDispatcher("MedicoController?acao=listar");
               
           }else if(acao.equalsIgnoreCase("obterum")){
               medico = dao.retornarPeloCodigo(medico);
               request.setAttribute("medicoSelecionado", medico);
               rd = request.getRequestDispatcher("MedicoController?acao=formulario");
               
           }else if(acao.equalsIgnoreCase("alterar")){
               /// Hospital
               
               dao.alterar(medico);
               request.setAttribute("medicoSelecionado", medico);
               rd = request.getRequestDispatcher("MedicoController?acao=formulario");
               
           }else if(acao.equalsIgnoreCase("formulario")){
               rd = request.getRequestDispatcher("medicoForm.jsp");
               
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
