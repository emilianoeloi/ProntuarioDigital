<%@page info="Cadastro de hospitais" contentType="text/html" errorPage="erro403.jsp" pageEncoding="ISO-8859-1" 
        import="javax.servlet.http.Cookie"
        import="javax.servlet.http.HttpSession"
        import="java.text.SimpleDateFormat"
        import="java.util.Date" 
        import="pessoa.*"
        import="paciente.*"
        import="java.util.List"
        import="java.util.*"%>

<jsp:useBean id="pacientesList" scope="request" class="List" />

<jsp:include page="cabecalho.jsp" flush="true">
    <jsp:param name="pagina" value="principal" />
</jsp:include>

<div class="row">
    <!-- MENU -->
    <jsp:include page="menu.jsp" flush="true">
        <jsp:param name="pagina" value="<%=request.getParameter("pagina")%>" />
    </jsp:include>   


    <div class="span9">
        <h2>Paciente</h2>     
        <ul class="nav">
            <li><a href="PacienteController?acao=formulario">Novo Paciente</a></li>
        </ul>
        <table class="table table-hover">
            <caption>
                Paciente
            </caption>
            <thead>
                <tr>
                    <th>C�digo</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Identidade</th>
                    <th>E-mail</th>
                    <th>Data nascimento</th>
                    <th colspan="2">Op��es</th>
                </tr>
            </thead>
            <tbody>
<% 
    for(Iterator i = pacientesList.iterator(); i.hasNext();) {
        PacienteBean m = (PacienteBean)i.next(); 
%>                
                <tr>
                    <td><a href="PacienteController?acao=obterum&codigo=<%=m.getCodigo()%> "><%=m.getCodigo()%></a></td>
                    <td><%=m.getNome()%></td>
                    <td><%=m.getCpf()%></td>
                    <td><%=m.getId()%></td>
                    <td><%=m.getEmail()%></td>
                    <td>31/05/81</td>
                    <th><a href="PacienteController?acao=obterum&codigo=<%=m.getCodigo()%> ">Editar</a></th>
                    <th><a href="PacienteController?acao=excluir&codigo=<%=m.getCodigo()%> ">Excluir</a></th>
                </tr>
<% } %>
            </tbody>
            <tfoot>
                <tr>
                    <th>
                        
                    </th>
                </tr>
            </tfoot>
        </table>
</div>
<!-- inclusao do rodape -->
<jsp:include page="rodape.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>