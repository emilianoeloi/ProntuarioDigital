<%-- 
    Document   : especialidadeForm
    Created on : Nov 4, 2012, 9:10:20 PM
    Author     : Administrador
--%>

<%@page  contentType="text/html" errorPage="erro.jsp" pageEncoding="iso-8859-1" 
        import="javax.servlet.http.Cookie"
        import="javax.servlet.http.HttpSession"
        import="pessoa.*"        
%>

<%
    HttpSession sessao = request.getSession();
    PessoaBean pessoa = null;
    try{
        pessoa = (PessoaBean)sessao.getAttribute("pessoaLogada");
        if(pessoa == null)
            response.sendError(403, "Voc� n�o tem permiss�o!");

    }catch(Exception exc){
        response.sendError(403, "Voc� n�o tem permiss�o!");
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
    <jsp:useBean id="especialidade" scope="request" class="especialidade.EspecialidadeBean" />
    <jsp:useBean id="codigo" scope="request" class="especialidade.EspecialidadeDAO" />
    
  <%  
    int cod = codigo.ultimoRegistro();
%>  
    
    <div class="span9">
        <h2>Especialidade</h2>
<form class="form-especialidade" method="POST" action="EspecialidadeControl">
               <input type="hidden" id="cmd" name="cmd" value="<% if(especialidade.getCodigo() > 0 && especialidade.getCodigo() < cod ) {%>atualizar<%} else  {%>salvar<%}%>" /> 
                    
                    <fieldset>
                        <legend><% if(especialidade.getCodigo() > 0 && especialidade.getCodigo() < cod) {%> Editar <%} else {%> Cadastrar <%}%> Especialidade</legend>
                                <label>C�digo<br />
                                    <input type="text" id="codigo" name="codigo" class="input-xxlarge" readonly="readonly" value="<% if(especialidade.getCodigo() > 0 && especialidade.getCodigo() > 0 && especialidade.getCodigo() < cod){ out.print(especialidade.getCodigo()); } else  { out.print(cod); } %>" />	
                                </label>
            
                                <label>Nome Especialidade<br />
                                    <input type="text" name="nome" id="nome" class="input-xxlarge" value="<% if(especialidade.getCodigo() > 0 && especialidade.getCodigo() <  cod){ out.print(especialidade.getNome()); } else { out.print(""); } %>"/>
                                            	
                                </label>
                                
                                
                                <label>Descri��o Especialidade<br />
                                    <textarea id="descricao" name="descricao" class="input-xxlarge" style="resize:none;"><% if(especialidade.getCodigo() > 0 && especialidade.getCodigo() <  cod){ out.print(especialidade.getDescricao()); } else { out.print(""); } %> </textarea>	
                                </label>
				
			
			<div style="text-align: center">
				<button type="submit" class="btn btn-primary">Salvar</button>
				<button type="button" class="btn btn-danger">Cancelar</button>
				
                        </div>

                    </fieldset>
               
			</form>
    </div>
<!-- inclusao do rodape -->
<jsp:include page="rodape.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>

