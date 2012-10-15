/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

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

/**
 *
 * @author Administrador
 */
@WebServlet(name = "RestricaoControl", urlPatterns = {"/RestricaoControl"})
public class RestricaoControl extends HttpServlet {

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
        
        RestricaoBean restricao = new RestricaoBean();
        
        RestricaoDAO dao = new RestricaoDAO();
        
        String cmd = request.getParameter("cmd");
        
        if (cmd == null)
            cmd = "principal";
            
        if (cmd != null || !cmd.equalsIgnoreCase("principal")){
            String codigo = request.getParameter("codigo");
            if(codigo == null)
                codigo = "1";
            restricao.setCodigo(Integer.parseInt(codigo)); 
            restricao.setTipo(request.getParameter("tipo")); 
            restricao.setDescricao(request.getParameter("descricao"));
            restricao.setCpf(request.getParameter("cpf"));
            
        } 
        
        try{
            RequestDispatcher rd = null;
        
            if(cmd.equalsIgnoreCase("listar")){ 
                List restricoesList = dao.retornaRestricoes(); 
                request.setAttribute("restricoesList", restricoesList); 
                rd = request.getRequestDispatcher("adminRestricoes.jsp"); 
            }else if(cmd.equalsIgnoreCase("salvar")){ 
                dao.salvar(restricao); 
                rd = request.getRequestDispatcher("RestricaoControl?cmd=listar"); 
            }else if(cmd.equalsIgnoreCase("excluir")){ 
                dao.excluir(restricao); 
                rd = request.getRequestDispatcher("RestricaoControl?cmd=listar"); 
            }else if(cmd.equalsIgnoreCase("ret")){
                List restricoesList = dao.retornaRestricoes(); 
                request.setAttribute("restricoesList", restricoesList); 
                rd = request.getRequestDispatcher("adminRestricoes.jsp");
                
            }else if(cmd.equalsIgnoreCase("atu")){
                restricao = dao.adminRestricoes(restricao.getCodigo()); 
                HttpSession session = request.getSession(true); 
                session.setAttribute("restricao",restricao); 
                rd = request.getRequestDispatcher("restricaoSelecionada.jsp");
            }else if(cmd.equalsIgnoreCase("atualizar")){ 
                dao.atualizar(restricao); 
                rd = request.getRequestDispatcher("RestricaoControl?cmd=listar"); 
            }else if(cmd.equalsIgnoreCase("principal")){ 
                rd = request.getRequestDispatcher("index.jsp"); 
            }
                
            rd.forward(request, response); 
        
        }catch(Exception e){
           throw new ServletException(e);
        }
        
        
       
        
        
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
