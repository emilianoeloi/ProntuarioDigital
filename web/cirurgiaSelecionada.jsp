<%-- 
    Document   : cirurgiaSelecionada
    Created on : Oct 13, 2012, 8:20:34 PM
    Author     : Administrador
--%>

<!-- incluindo o cabecalho -->
<jsp:include page="cabecalho.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>

<jsp:useBean id="cirurgia" scope="session" class="cirurgia.CirurgiaBean" />

<%
    String nomeCirurgia = cirurgia.getCirurgia();
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
        <h2>Médico</h2>
<form class="frm-cirurgia" method="POST" action="CirurgiaControl?cmd=atualizar">
                    
                    <fieldset>
                        <legend>Cadastro de Cirurgia</legend>
                                <label>Código<br />
                                    <input type="text" id="codigo" name="codigo" class="input-xxlarge" value="${cirurgia.codigo}" readonly="readonly">	
                                </label>
                                
                                <label> Nome Cirurgia <br>
                                    <input type="text" id="nome" name="nome" class="input-xxlarge" value="${cirurgia.cirurgia}">
                                </label>
                                <label>CRM Médico<br />
                                    <input type="text" id="crm" name="crm" class="input-xxlarge" value="${cirurgia.crm}">	
                                </label>
				<label>CPF Paciente<br />
                                    <input type="text" id="cpf" name="cpf" class="input-xxlarge" value="${cirurgia.cpf}">	
                                </label>
                                <label>Data Cirurgia<br />
                                    <input type="text" id="data" name="data" class="input-xxlarge" value="${cirurgia.data}">	
                                </label>
                                <label>Descrição da Cirurgia<br />
                                    <textarea id="descricao" name="descricao" >${cirurgia.descricao}</textarea>	
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
