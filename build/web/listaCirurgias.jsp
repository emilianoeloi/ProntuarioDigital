<%-- 
    Document   : listaCirurgias
    Created on : Oct 12, 2012, 10:57:09 PM
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"
        import="java.util.*"
        import="cirurgia.*" %>
<!-- incluindo o cabecalho -->
<jsp:include page="cabecalho.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>
<html>
    <div class="span9">
        <h2>Cirurgias</h2>
        <ul class="nav">
            
        </ul>
        <table class="table table-hover">
            <caption>
                Cirurgias
            </caption>
            
            <tbody>
                <% 
                List cirurgiasList = (List)request.getAttribute("cirurgiasList"); 
                for(Iterator i = cirurgiasList.iterator(); i.hasNext();) {
                    CirurgiaBean c = (CirurgiaBean)i.next(); 
                %>
                <tr>
                    <th>Cirurgia <%= c.getCodigo() %></th>
                </tr><tr>
                <tr>
                    <th>Nome Cirurgia</th>
                </tr><tr>    
                    <td><%= c.getCirurgia() %></td>
                </tr>
                <tr>
                    <th>CRM Médico</th>
                </tr><tr> 
                    <td><%= c.getCrm() %></td>
                    
                </tr>
                <tr>
                    <th>CPF Paciente</th>
                </tr><tr>    
                    <td><%= c.getCpf() %></td>
                    
                </tr>
                <tr>
                    <th>Data Cirurgia</th>
                </tr><tr>    
                    <td><%= c.getData() %></td>
                    
                </tr>
                <tr>
                    <th>Descrição</th>
                </tr><tr>    
                    <td><%= c.getDescricao() %></td>
                </tr><tr>    
                    <td> <br></td>
                </tr>
            </tbody>
            <tfoot>
                
            </tfoot>
              <% }
                %>
        </table>
                  
</div>
</html>
<!-- inclusao do rodape -->
<jsp:include page="rodape.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>