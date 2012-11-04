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

<jsp:useBean id="medicamentoSelecionado" scope="request" class="medicamentos.MedicamentoBean"></jsp:useBean>

<jsp:include page="cabecalho.jsp" flush="true">
    <jsp:param name="pagina" value="principal" />
</jsp:include>

<div class="row">
    <!-- MENU -->
    <jsp:include page="menu.jsp" flush="true">
        <jsp:param name="pagina" value="<%=request.getParameter("pagina")%>" />
    </jsp:include>   
    <div class="span9">
        <h2>Hospital</h2>
                <form class="form-hospital" method="POST" action="MedicamentoController">
                   <input type="hidden" id="acao" name="acao" value="<% if(medicamentoSelecionado.getCodigo() == 0 ) {%>cadastrar<%} else {%>alterar<%}%>" /> 
                    <fieldset>
                        <legend><% if(medicamentoSelecionado.getCodigo() == 0 ) {%> Cadastrar <%} else {%> Editar <%}%> Medicamento</legend>
                                <label>Código do Medicamento<br />
                                    <input readonly="readonly" type="text" id="codigo" name="codigo" class="input-xxlarge" value="<%if (medicamentoSelecionado.getCodigo() == 0 ){out.print (""); } else {out.print(medicamentoSelecionado.getCodigo());} %>">	
                                </label>
				<label>Nome do Medicamento<br />
                                    <input type="text" id="nome" name="nome" class="input-xxlarge" value="<%if (medicamentoSelecionado.getCodigo()==0){ out.print("");} else {out.print(medicamentoSelecionado.getMedicamento());} %>">	
                                </label>
    
			
			<div style="text-align: center">
                       
				<button type="submit" class="btn btn-primary">Salvar</button>
				<button type="button" class="btn btn-danger" onclick="window.location = 'MedicamentoController'">Cancelar</button>
				
                        </div>
                    </fieldset>
                    
			</form>
               </div> 
<!-- inclusao do rodape -->
<jsp:include page="rodape.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>