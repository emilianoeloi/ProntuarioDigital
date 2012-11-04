/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cirurgia;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrador
 */
@WebServlet(name = "CirurgiaControl", urlPatterns = {"/CirurgiaControl"})
public class CirurgiaControl extends HttpServlet {

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
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {   
        
        CirurgiaBean cirurgia = new CirurgiaBean();
        CirurgiaDAO dao = new CirurgiaDAO();
        
        String cmd = request.getParameter("cmd");
        
        if (cmd == null)
            cmd = "principal";
            
        if (cmd != null || !cmd.equalsIgnoreCase("principal")){ 
            String codigo = request.getParameter("codigo");
            if(codigo == null)
                codigo = "1";
            cirurgia.setCodigo(Integer.parseInt(codigo)); 
            cirurgia.setCirurgia(request.getParameter("nome")); 
            cirurgia.setCpf(request.getParameter("cpf")); 
            cirurgia.setCrm(request.getParameter("crm")); 
            cirurgia.setDescricao(request.getParameter("descricao")); 
            cirurgia.setData(request.getParameter("data"));
        } 
        
        try{
            RequestDispatcher rd = null;
        
            if(cmd.equalsIgnoreCase("listar")){ 
                List cirurgiasList = dao.retornaCirurgias(); 
                request.setAttribute("cirurgiasList", cirurgiasList); 
                rd = request.getRequestDispatcher("listaCirurgias.jsp"); 
            }else if(cmd.equalsIgnoreCase("salvar")){ 
                dao.salvar(cirurgia); 
                rd = request.getRequestDispatcher("CirurgiaControl?cmd=listar"); 
            }else if(cmd.equalsIgnoreCase("excluir")){ 
                dao.excluir(cirurgia); 
                rd = request.getRequestDispatcher("CirurgiaControl?cmd=listar"); 
            }else if(cmd.equalsIgnoreCase("ret")){
                List cirurgiasList = dao.retornaCirurgias(); 
                request.setAttribute("cirurgiasList", cirurgiasList); 
                rd = request.getRequestDispatcher("medicoCirurgias.jsp");
                
            }else if(cmd.equalsIgnoreCase("atu")){
                cirurgia = dao.medicoCirurgias(cirurgia.getCodigo()); 
                HttpSession session = request.getSession(true); 
                session.setAttribute("cirurgia",cirurgia); 
                rd = request.getRequestDispatcher("cirurgiaSelecionada.jsp");
            }else if(cmd.equalsIgnoreCase("atualizar")){ 
                dao.atualizar(cirurgia); 
                rd = request.getRequestDispatcher("CirurgiaControl?cmd=listar"); 
            }else if(cmd.equalsIgnoreCase("principal")){ 
                rd = request.getRequestDispatcher("index.jsp"); 
            }
                
            rd.forward(request, response); 
        
        }catch(Exception e){
           throw new ServletException(e);
        }
        /*
         * 
         * /*String data = request.getParameter("data");
              
       Calendar dataCirurgia = null;
        
        // fazendo a conversão da data
        try {
            Date date = new SimpleDateFormat("yyyy/MM/dd").parse(data);
            dataCirurgia = Calendar.getInstance();
            dataCirurgia.setTime(date);
        } catch (ParseException e) {
            out.println("Erro de conversão da data");
            return; //para a execução do método
        }
        * 
        
        //cria objeto da bean
        
        cirurgia.setCodigo(request.getParameter("codigo"));
        cirurgia.setCirurgia(request.getParameter("nome"));
        cirurgia.setCrm(request.getParameter("crm"));
        cirurgia.setCpf(request.getParameter("cpf"));
        cirurgia.setData(request.getParameter("data"));
        cirurgia.setDescricao(request.getParameter("cirurgia"));
        
        //salva cirurgia
       
        
        try{
            dao.salvar(cirurgia);
            out.println("Cadastrado ");
        }catch(SQLException e){
            e.printStackTrace();
            out.println("Erro Inesperado: " + e.getMessage());
        }
        * 
        */
        
        
       
        
        
    }
    
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
