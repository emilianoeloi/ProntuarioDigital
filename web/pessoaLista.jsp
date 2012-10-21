<%-- 
    Document   : pessoaLista
    Created on : Oct 6, 2012, 2:07:10 PM
    Author     : emilianoeloi
--%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"
        import="java.util.*"
        import="pessoa.*" %>
<!-- incluindo o cabecalho -->
<jsp:include page="cabecalho.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>

    <div class="span9">
        <h2>Pessoa</h2>
        <ul class="nav">
            <li><a href="pessoaForm.jsp">Nova Pessoa</a></li>
        </ul>
        <table class="table table-hover">
            <caption>
                Pessoas
            </caption>
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Identidade</th>
                    <th>E-mail</th>
                    <th>Data nascimento</th>
                    <th colspan="2">Opções</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><a href="">1</a></td>
                    <td>Emiliano</td>
                    <td>013.1231212.312</td>
                    <td>MG13</td>
                    <td>@</td>
                    <td>31/05/81</td>
                    <th><a href="">Editar</a></th>
                    <th><a href="">Excluir</a></th>
                </tr>
                <tr>
                    <td><a href="">2</a></td>
                    <td>Pollyana</td>
                    <td>013.1231212.312</td>
                    <td>MG13</td>
                    <td>@</td>
                    <td>31/05/81</td>
                    <th><a href="">Editar</a></th>
                    <th><a href="">Excluir</a></th>
                </tr>
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