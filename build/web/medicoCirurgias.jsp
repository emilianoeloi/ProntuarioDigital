<%@page info="Cadastro de hospitais" contentType="text/html" errorPage="erro.jsp" pageEncoding="ISO-8859-1" 
        import="javax.servlet.http.Cookie"
        import="javax.servlet.http.HttpSession"
        import="java.text.SimpleDateFormat"
        import="java.util.Date" 
        import="pessoa.*"
        import="java.util.List"
        import="cirurgia.*"
        import="java.util.*"%>

<%
    HttpSession sessao = request.getSession();
    PessoaBean pessoa = null;
    try{
        pessoa = (PessoaBean)sessao.getAttribute("pessoaLogada");
        if(pessoa == null)
            response.sendError(403, "Você não tem permissão!");

    }catch(Exception exc){
        response.sendError(403, "Você não tem permissão!");
    }
    
%>


<jsp:include page="cabecalho.jsp" flush="true">
    <jsp:param name="pagina" value="principal" />
</jsp:include>

<div class="row">
    <!-- MENU -->
    <jsp:include page="menu.jsp" flush="true">
        <jsp:param name="pagina" value="<%=request.getParameter("pagina")%>" />
    </jsp:include>   

    <jsp:useBean id="cirurgiasList" scope="request" class="List" />
        <div class="span9">
        <h2>Médicos</h2>
        <ul class="nav">
            <li><a href="CirurgiaControl?cmd=lista">Nova Cirurgia</a></li>
        </ul>
        <table class="table table-hover">
            <caption>
                Médicos
            </caption>
            
            <thead>
                <tr>
                
                    <th>Código</th>
                    <th></th>
                    <th>Cirurgia</th>
                    <th></th>
                    <th>Paciente</th>
                    <th></th>
                    <th></th>
                    
                    <th colspan="4">Opções</th>
                </tr>
                
            </thead>
            <tbody>
                <% 
                 
                for(Iterator i = cirurgiasList.iterator(); i.hasNext();) {
                    CirurgiaBean c = (CirurgiaBean)i.next(); 
             %>
                <tr>
                    <td><a href="CirurgiaControl?cmd=listar"><%= c.getCodigo() %></td>
                    <td></td>
                    <td><%= c.getCirurgia() %></td>
                    <td></td>
                    <td><%= c.getDescricao() %></td>
                    <td></td>
                    <td></td>
                    <th><a href="CirurgiaControl?cmd=atu&codigo=<%=c.getCodigo()%>">Editar</a></th>
                    <th><a href="CirurgiaControl?cmd=excluir&codigo=<%=c.getCodigo()%>">Excluir</a></th>
                </tr>
            </tbody>
            <tfoot>
                
            </tfoot>
            <% }
                %>
        </table>
</div>
<!-- inclusao do rodape -->
<jsp:include page="rodape.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>