<%-- 
    Document   : hospitalForm
    Created on : Oct 3, 2012, 10:20:33 AM
    Author     : emilianoeloi
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="mycss/style.css" />
                <title>Prontuário Digital - Formulário</title>
	</head>
            <body>
                <div class="container">
                <form class="form-pessoa" method="POST" action="PessoaController">
                    <input type="hidden" id="acao" name="acao" value="cadastrar " />
                    <fieldset>
                        <legend>Pessoa</legend>
                                <label>Código<br />
                                    <input readonly="readonly" type="text" id="codigo" name="codigo" class="input-xxlarge">	
                                </label>
				<label>Nome<br />
                                    <input type="text" id="nome" name="nome" class="input-xxlarge">	
                                </label>
                                <label>CPF<br />
                                    <input type="text" id="cpf" name="cpf" class="input-xxlarge">	
                                </label>
                                <label>E-mail<br />
                                    <input type="text" id="email" name="email" class="input-xxlarge">	
                                </label>
                        <label>ID<br />
                                    <input type="text" id="id" name="id" class="input-xxlarge">	
                                </label>
                        <label>Data de nascimento<br />
                                    <input type="text" id="data-nascimento" name="data-nascimento" class="input-xxlarge">	
                                </label>
                        <label>Senha<br />
                                    <input type="text" id="senha" name="senha" class="input-xxlarge">	
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