<%
    String loginUsuario = request.getParameter("login");
%>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
      <div class="container-fluid">
        <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </a>
        <a class="brand" href="#">Prontuário Digital</a>
        <div class="nav-collapse collapse">
          <p class="navbar-text pull-right">
            Logado: <a href="#" class="navbar-link"><%=loginUsuario%></a>
          </p>
          <ul class="nav">
            <li class="active"><a href="#">Principal</a></li>
            <li><a href="#contato">Contato</a></li>
            <li><a href="#ajuda">Ajuda</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
</div>
