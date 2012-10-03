<%@page info="Cadastro de hospitais" contentType="text/html" errorPage="erro.jsp" pageEncoding="ISO-8859-1" 
        import="javax.servlet.http.Cookie"
        import="javax.servlet.http.HttpSession"
        import="java.text.SimpleDateFormat"
        import="java.util.Date" %>
<!DOCTYPE HTML>

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

		<div class="container">
                    <jsp:include page="cabecalho.jsp" flush="true">
                        <jsp:param name="login" value="<%=seUsuario%>" />
                    </jsp:include>
                    
                    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
            <jsp:include page="menu.jsp" flush="true">
                 <jsp:param name="login" value="<%=seUsuario%>" />
            </jsp:include>
        </div><!--/span-->
        <div class="span9">
          <div class="hero-unit">
            <h1>Prontuário Digital</h1>
            <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
            <p><a class="btn btn-primary btn-large">Saiba mais &raquo;</a></p>
          </div>
          <div class="row-fluid">
            <div class="span4">
              <h2>Hospitais</h2>
              <table class="table table-hover">
                  <thead>
                      <tr>
                          <th>Código</th>
                          <th>Nome</th>
                      </tr>
                  </thead>
                  <tbody>
                      <tr>
                          <td>1</td>
                          <td>Felício Rocho</td>
                      </tr>
                      <tr>
                          <td>2</td>
                          <td>Madre Tereza</td>
                      </tr>  
                  </tbody>
                  <tfoot>
                      <tr>
                          <th colspan="2">{N} hospitais cadastrados</th>
                          
                      </tr>
                  </tfoot>
              </table>
              <p><a class="btn" href="#">Mais &raquo;</a></p>
            </div><!--/span-->
            <div class="span4">
              <h2>Cirurgias</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn" href="#">Mais &raquo;</a></p>
            </div><!--/span-->
            <div class="span4">
              <h2>Restrições</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn" href="#">Mais&raquo;</a></p>
            </div><!--/span-->
          </div><!--/row-->
          <div class="row-fluid">
            <div class="span4">
              <h2>Exames</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn" href="#">Mais &raquo;</a></p>
            </div><!--/span-->
            <div class="span4">
              <h2>Médicos</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn" href="#">Mais &raquo;</a></p>
            </div><!--/span-->
            <div class="span4">
              <h2>Medicamentos</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn" href="#">Mais &raquo;</a></p>
            </div><!--/span-->
          </div><!--/row-->
        </div><!--/span-->
      </div><!--/row-->

      <hr>

      <footer>
        <p>2012/2 - Projeto Aplicado - Análise e desenvolvimento de sistemas - 3 Período - Instituto UNATEC de Tecnologia </p>
      </footer>

    </div><!--/.fluid-container-->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap-transition.js"></script>
    <script src="js/bootstrap-alert.js"></script>
    <script src="js/bootstrap-modal.js"></script>
    <script src="js/bootstrap-dropdown.js"></script>
    <script src="js/bootstrap-scrollspy.js"></script>
    <script src="js/bootstrap-tab.js"></script>
    <script src="js/bootstrap-tooltip.js"></script>
    <script src="js/bootstrap-popover.js"></script>
    <script src="js/bootstrap-button.js"></script>
    <script src="js/bootstrap-collapse.js"></script>
    <script src="js/bootstrap-carousel.js"></script>
    <script src="js/bootstrap-typeahead.js"></script>
	</body>
</html>