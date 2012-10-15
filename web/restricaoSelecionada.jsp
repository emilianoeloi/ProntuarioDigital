<%-- 
    Document   : restricaoSelecionada
    Created on : Oct 14, 2012, 10:15:45 AM
    Author     : Administrador
--%>

<jsp:include page="cabecalho.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>

<jsp:useBean id="restricao" scope="session" class="admin.RestricaoBean" />

<%
    String nomeRestricao = restricao.getTipo();
%>
<html>
    <head>
        <style type="text/css">
            #descricao{
                height: 200px; 
                width: 530px;
                overflow-x:hidden;
                overflow:auto;
                resize:none;
            }
        
        </style>
        
    </head>
    <body>
    <div class="span9">
        <h2>Restrição</h2>
<form class="frm-cirurgia" method="POST" action="RestricaoControl?cmd=atualizar">
                    
                    <fieldset>
                        <legend>Cadastro de Restrição</legend>
                                <label>Código<br />
                                    <input type="text" id="codigo" name="codigo" class="input-xxlarge" value="${restricao.codigo}" readonly="readonly">	
                                </label>
                                
                                <label>CPF Paciente<br />
                                    <input type="text" id="cpf" name="cpf" class="input-xxlarge" value="${restricao.cpf}" >	
                                </label>
                                
                                
                                <label> Tipo Restrição <br>
                                    <input type="text" id="tipo" name="tipo" class="input-xxlarge" value="${restricao.tipo}">
                                </label>
                                <label>Descrição Restrição<br />
                                    <textarea id="descricao" name="descricao" class="input-xxlarge" >${restricao.descricao}</textarea>>	
                                </label>
				
			<div style="text-align: center">
				<button type="submit" class="btn btn-primary">Salvar</button>
				<button type="button" class="btn btn-danger">Cancelar</button>
				
                        </div>
                    </fieldset>
			</form>
    </div>
</body>
    </html>
<!-- inclusao do rodape -->
<jsp:include page="rodape.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>