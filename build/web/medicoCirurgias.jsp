<%-- 
    Document   : medicoCirurgias
    Created on : Oct 13, 2012, 7:08:46 PM
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
        <h2>Médicos</h2>
        <ul class="nav">
            <li><a href="cirurgiaForm.jsp">Nova Cirurgia</a></li>
        </ul>
        <table class="table table-hover">
            <caption>
                Médicos
            </caption>
            
            <thead>
                <tr>
                    <th>Código</th>
                    <th></th>
                    <th>Paciente</th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th colspan="4">Opções</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List cirurgiasList = (List)request.getAttribute("cirurgiasList"); 
                for(Iterator i = cirurgiasList.iterator(); i.hasNext();) {
                    CirurgiaBean c = (CirurgiaBean)i.next(); 
             %>
                <tr>
                    <td><a href="CirurgiaControl?cmd=listar"><%= c.getCodigo() %></td>
                    <td></td>
                    <td><%= c.getCpf() %></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <th><a href="CirurgiaControl?cmd=atu&codigo=<%= c.getCodigo() %>">Editar</a></th>
                    <th><a href="CirurgiaControl?cmd=excluir&codigo=<%= c.getCodigo() %>">Excluir</a></th>
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
