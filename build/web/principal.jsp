<%@page info="Cadastro de hospitais" contentType="text/html" errorPage="erro.jsp" pageEncoding="ISO-8859-1" 
        import="javax.servlet.http.Cookie"
        import="javax.servlet.http.HttpSession"
        import="java.text.SimpleDateFormat"
        import="java.util.Date" %>
<!DOCTYPE HTML>

<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="mycss/style.css" />
                <title>Prontuário Digital - Principal</title>
	</head>
            <body>
                    <%
                    
                    /// Recuperar Dados de Acesso
                    Cookie ckUsuario = null;
                    String txUsuario = "";
                    Cookie listaCookies[] = request.getCookies();   
                    if(listaCookies != null){
                        for(int i=0; i < listaCookies.length; i++){
                            if(listaCookies[i].getName().equals("usuario")){
                               ckUsuario = listaCookies[i]; 
                               txUsuario = ckUsuario.getValue();
                               break;
                            }
                        }
                        
                    }
                    
                    
                    /// Recuperando acesso da Sessão
                    HttpSession sessao = request.getSession();
                    String seUsuario = (String)sessao.getAttribute("usuario");
                    String dataLogin = "";
                    if(seUsuario != null){
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy - HH:mm:ss");
                        dataLogin = formato.format(new Date(sessao.getCreationTime()));
                    }
                    
                    %>
                </div>
		<div class="container">
                    <jsp:include page="cabecalho.jsp" flush="true">
                        <jsp:param name="login" value="<%=seUsuario%>" />
                    </jsp:include>
                    <%@include file="menu.jsp" %>
                    <h1>Prontuário Digital | Usuário logado: 
                        <strong><% out.print(txUsuario); %></strong> |
                        <strong><% out.print(seUsuario); %> |
                        <strong><% out.print(dataLogin); %></h1>
			<legend>Cadastro Dados de Hospitais</legend>
			<form class="form-horizontal" method="post" action="?">
                            
                                <label>Código<br />
                                    <input readonly="readonly" type="text" id="codigo" name="codigo" class="input-xxlarge">	
                                </label>
				<label>Nome do Hospital<br />
                                    <input type="text" id="nome" name="nome" class="input-xxlarge">	
                                </label>
			
			<div style="text-align: center">
				<button type="submit" class="btn btn-primary">Salvar</button>
				<button type="button" class="btn btn-danger">Cancelar</button>
				
                        </div>
			</form>
		</div>
             
		<script src="js/bootstrap.js"> 
			
		
		</script>
	</body>
</html>