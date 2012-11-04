<%@page info="Cadastro de hospitais" contentType="text/html" errorPage="erro.jsp" pageEncoding="ISO-8859-1" 
        import="javax.servlet.http.Cookie"
        import="javax.servlet.http.HttpSession"
        import="java.text.SimpleDateFormat"
        import="java.util.Date" 
        import="pessoa.*"
        import="java.util.List"
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

<jsp:useBean id="exameSelecionado" scope="request" class="exame.ExameBean"></jsp:useBean>

<jsp:include page="cabecalho.jsp" flush="true">
    <jsp:param name="pagina" value="principal" />
</jsp:include>

<div class="row">
    <!-- MENU -->
    <jsp:include page="menu.jsp" flush="true">
        <jsp:param name="pagina" value="<%=request.getParameter("pagina")%>" />
    </jsp:include>   
    <div class="span9">
        <h2>Exame</h2>
                <form class="form-hospital" method="POST" action="ExameController">
                    <input type="hidden" id="acao" name="acao" value="<% if(exameSelecionado.getCodigo() == 0 ) {%>cadastrar<%} else {%>alterar<%}%>" /> 
                    <fieldset>
                        <legend><% if(exameSelecionado.getCodigo() == 0 ) {%> Cadastrar <%} else {%> Editar <%}%> Exame</legend>
                                <label>Código<br />
                                    <input readonly="readonly" type="text" id="codigo" name="codigo" class="input-xxlarge" value="<% if(exameSelecionado.getCodigo() == 0 ){ out.print(""); } else { out.print(exameSelecionado.getCodigo()); } %>">	
                                </label>
				<label>Nome do Exame<br />
                                    <input type="text" id="nome" name="nome" class="input-xxlarge" value="<% if(exameSelecionado.getCodigo() == 0 ){ out.print(""); } else { out.print(exameSelecionado.getNome()); } %>">	
                                </label>
                                <div class="control-group">
                                    <label class="control-label" for="home-contato-texto">
                                  Descrição do Exame
                                 </label>
                                         <div class="controls">
                                           <textarea class="input-xxlarge" id="desc" name="desc" ><% if(exameSelecionado.getCodigo() == 0 ){ out.print(""); } else { out.print(exameSelecionado.getDescricao()); } %></textarea>
                                             </div>
                                 </div>
			
			<div style="text-align: center">
                       
				<button type="submit" class="btn btn-primary">Salvar</button>
				<button type="button" class="btn btn-danger" onclick="window.location = 'ExameController'">Cancelar</button>
				
                        </div>
                    </fieldset>
                    
			</form>
               </div> 
<!-- inclusao do rodape -->
<jsp:include page="rodape.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>