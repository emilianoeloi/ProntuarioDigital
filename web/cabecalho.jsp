<%
    String loginUsuario = request.getParameter("login");
%>
<html>
	<head>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta name="description" content="Prontuário Digital">
            <meta name="author" content="Pollyana, Fernanda, Emiliano, Marlon, Mauro, Rafael, Vilmar">
            <link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>
            <link rel="stylesheet" type="text/css" href="mycss/style.css" />
            <link href="css/bootstrap-responsive.css" rel="stylesheet">
     <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }
    </style>
            <title>Prontuário Digital - Principal</title>
	</head>
            <body>
                <div class="container">
                <div class="navbar navbar-inverse navbar-fixed-top">
                    <div class="navbar-inner">
                      <div class="container-fluid">
                        <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                          <span class="icon-bar"></span>
                          <span class="icon-bar"></span>
                          <span class="icon-bar"></span>
                        </a>
                        <a class="brand" href="principal.jsp">Prontuário Digital</a>
                        <div class="nav-collapse collapse">
                          <p class="navbar-text pull-right">
                            Logado: <a href="#" class="navbar-link"><%=loginUsuario%></a>
                          </p>
                          <ul class="nav">
                            <li class="active"><a href="principal.jsp">Principal</a></li>
                            <li><a href="#contato">Contato</a></li>
                            <li><a href="#ajuda">Ajuda</a></li>
                          </ul>
                        </div><!--/.nav-collapse -->
                      </div>
                    </div>
                </div>
                <div class="container-fluid">
                      <div class="row-fluid">
                        <div class="span3">
                            <jsp:include page="menu.jsp" flush="true">
                                 <jsp:param name="login" value="<%=loginUsuario%>" />
                            </jsp:include>
                        </div><!--/span-->
                             