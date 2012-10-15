<%-- 
    Document   : restricaoForm
    Created on : Oct 14, 2012, 10:15:12 AM
    Author     : Administrador
--%>

<!-- incluindo o cabecalho -->


<jsp:include page="cabecalho.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>



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
        
        <jsp:useBean id="restricao" scope="session" class="admin.RestricaoDAO" />

        <%
            String codigo = restricao.ultimoRegistro();
        %>
        
    <div class="span9">
        <h2>Restrição</h2>
<form class="form-restricao" method="POST" action="RestricaoControl?cmd=salvar">
               
                    <fieldset>
                        <legend>Cadastro de Restrição</legend>
                                <label>Código<br />
                                    <input type="text" id="codigo" name="codigo" class="input-xxlarge" readonly="readonly" value="<%= codigo %>" />	
                                </label>
            
                                <label>CPF Paciente<br />
                                    <input type="text" id="cpf" name="cpf" class="input-xxlarge">	
                                </label>
                                
                                <label> Tipo Restrição <br>
                                    <input type="text" id="tipo" name="tipo" class="input-xxlarge">
                                </label>
                                <label>Descrição Restrição<br />
                                    <textarea id="descricao" name="descricao" class="input-xxlarge"> </textarea>	
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
