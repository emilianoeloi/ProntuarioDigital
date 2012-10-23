<%@page info="Cadastro de hospitais" contentType="text/html" errorPage="erro.jsp" pageEncoding="ISO-8859-1" 
        import="javax.servlet.http.Cookie"
        import="javax.servlet.http.HttpSession"
        import="java.text.SimpleDateFormat"
        import="java.util.Date" 
        import="pessoa.*" %>
<%
    HttpSession sessao = request.getSession();
    PessoaBean pessoa = null;
    try{
        pessoa = (PessoaBean)sessao.getAttribute("pessoaLogada");
    }catch(Exception exc){
        response.sendError(403, "Voc� n�o tem permiss�o!");
    }
%>
<!DOCTYPE html>
<html>  
	<head>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta name="description" content="Sanus">
            <meta name="author" content="Pollyana, Fernanda, Emiliano, Marlon, Mauro, Rafael, Vilmar">
            <link href="css/bootstrap.css" rel="stylesheet">
            <style type="text/css">
              body {
                padding-top: 60px;
                padding-bottom: 40px;
              }
            </style>
            <link href="css/bootstrap-responsive.css" rel="stylesheet">
            
            <link rel="shortcut icon" href="ico/favicon.ico">
            <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/sanus-144.png">
            <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/sanus-114.png">
            <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/sanus-72.png">
            <link rel="apple-touch-icon-precomposed" href="ico/sanus-57.png">
            
            <title>Prontu�rio Digital</title>
	</head>


  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
            <a class="brand" href="index.jsp"> Prontu�rio Digital </a>
          <div class="nav-collapse collapse">
            <ul class="nav">
                <li <% if(request.getParameter("pagina").equalsIgnoreCase("home")) { %> class="active" <% } %> ><a href="index.jsp">Home</a></li>
              <li <% if(request.getParameter("pagina").equalsIgnoreCase("contato")) { %> class="active" <% } %> ><a href="contato.jsp">Contato</a></li>
              <li <% if(request.getParameter("pagina").equalsIgnoreCase("info")) { %> class="active" <% } %> ><a href="informacoes.jsp">Info</a></li>
              
            </ul>
            <ul class="nav pull-right">
              <%if(pessoa == null){%>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Entrar <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                      <li class="nav-header"><i class="icon-user"></i>Autentica��o</li>
                    <li class="nav-header">
                        <form class="navbar-form pull-right" style="text-align:center" action="PessoaController" method="post">
                            <input type="hidden" id="acao" name="acao" value="autenticar" />
                          <input class="span2" type="text" id="email" name="email" placeholder="E-mail" />
                          <input class="span2" type="password" id="senha" name="senha" placeholder="Senha" />
                          <button type="submit" class="btn btn-primary">Entrar</button>
                        </form>

                    </li>
                    <li class="" style="text-align:center; cursor: pointer">Esqueci minha senha</li>
                  </ul>
                </li>
              <%}else{%>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=pessoa.getNome()%> <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                      <li class="nav-header"><i class="icon-user"></i>Autenticado</li>
                    <li class="nav-header">
                        <p><%=pessoa.getNome()%></p>
                        <form class="navbar-form pull-right" style="text-align:center" action="PessoaController" method="post">
                            <input type="hidden" id="acao" name="acao" value="sair" />
                          <button type="submit" class="btn btn-warning">Sair</button>
                        </form>

                    </li>
                  </ul>
                </li>
              <%}%>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">
                             