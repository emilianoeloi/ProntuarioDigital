<%-- 
    Document   : autenticacao
    Created on : Oct 2, 2012, 10:41:40 AM
    Author     : emilianoeloi
--%>
<%@page contentType="text/html" errorPage="erro.jsp" pageEncoding="ISO-8859-1" 
        import="javax.servlet.http.Cookie"
        import="javax.servlet.http.HttpSession"  %>
<%
    /// Recuperr Dados Postados
    Boolean autenticado = false;
    String usuario = request.getParameter("login");
    String senha = request.getParameter("password");
    
    /// Verificar Usu�rio e Senha
    if(usuario != null)
        if(usuario.equals("vilmar") && senha.equals("B1shop")){
            /// Gardar acesso no Cookie do Cliente
            Cookie pdCookie = new Cookie("usuario", usuario);
            pdCookie.setMaxAge(60);
            pdCookie.setSecure(false);
            pdCookie.setComment("Login do usu�rio");
            /// Guardar acesso na Sessao
            HttpSession sessao = request.getSession(true);
            session.setMaxInactiveInterval(3600);
            sessao.setAttribute("usuario", usuario);

            response.addCookie(pdCookie);
            response.sendRedirect("principal.jsp");
        }else{
            response.sendError(403, "Voc� n�o tem permiss�o!");

        }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prontu�rio Digital - Autentica��o</title>
		<link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="mycss/style.css" />
    </head>
    <body>
        <div class="container">
            <h1>Prot�tipo - tela de autentica��o</h1>
            <form method="POST">
                <fieldset>
                    <legend>Login</legend>
                    <label>Usu�rio
                        <input type="text" id="login" name="login" />
                    </label>
                    <label>Senha
                        <input type="password" id="password" name="password" />
                    </label>
                    <button type="submit" class="btn">Entrar</button>
            </form>
            
        </div>
        <script src="js/bootstrap.js"></script>
    </body>
</html>
