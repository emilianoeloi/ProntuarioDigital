<%-- 
    Document   : adminRestricoes
    Created on : Oct 14, 2012, 10:16:32 AM
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"
        import="java.util.*"
        import="admin.*" %>
<!-- incluindo o cabecalho -->
<jsp:include page="cabecalho.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>
<html>
    <div class="span9">
        <h2>Restrições</h2>
        <ul class="nav">
            <li><a href="restricaoForm.jsp">Nova Restrição</a></li>
        </ul>
        <table class="table table-hover">
            <caption>
                Administrador
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
                List restricoesList = (List)request.getAttribute("restricoesList"); 
                for(Iterator i = restricoesList.iterator(); i.hasNext();) {
                    RestricaoBean r = (RestricaoBean)i.next(); 
             %>
                <tr>
                    <td><a href="RestricaoControl?cmd=listar"><%= r.getCodigo() %></td>
                    <td></td>
                    <td><%= r.getCpf() %></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <th><a href="RestricaoControl?cmd=atu&codigo=<%= r.getCodigo() %>">Editar</a></th>
                    <th><a href="RestricaoControl?cmd=excluir&codigo=<%= r.getCodigo() %>">Excluir</a></th>
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

