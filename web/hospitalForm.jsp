<%-- 
    Document   : hospitalForm
    Created on : Oct 3, 2012, 10:20:33 AM
    Author     : emilianoeloi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="mycss/style.css" />
                <title>Prontuário Digital</title>
	</head>
            <body>
                <div class="container">
                <form class="form-hospital" method="POST" action="HospitalController">
                    <fieldset>
                        <legend>Hospital</legend>
                                <label>Código<br />
                                    <input readonly="readonly" type="text" id="codigo" name="codigo" class="input-xxlarge">	
                                </label>
				<label>Nome do Hospital<br />
                                    <input type="text" id="nome" name="nome" class="input-xxlarge">	
                                </label>
			
			<div style="text-align: center">
                            <button></button>
				<button type="submit" class="btn btn-primary">Salvar</button>
				<button type="button" class="btn btn-danger">Cancelar</button>
				
                        </div>
                    </fieldset>
			</form>
                </div>
            </body>
</html>