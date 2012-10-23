<%@page info="Cadastro de hospitais" contentType="text/html" errorPage="erro.jsp" pageEncoding="ISO-8859-1" 
        import="javax.servlet.http.Cookie"
        import="javax.servlet.http.HttpSession"
        import="java.text.SimpleDateFormat"
        import="java.util.Date" %>
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
<jsp:include page="cabecalho.jsp" flush="true">
    <jsp:param name="pagina" value="principal" />
</jsp:include>

<div class="row">
    <!-- MENU -->
    <jsp:include page="menu.jsp" flush="true">
        <jsp:param name="pagina" value="<%=request.getParameter("pagina")%>" />
    </jsp:include>    
    
    <div class="span9" style="min-height: 300px">
        <h1>Sistema</h1>
    </div><!--/span-->
</div>        

<jsp:include page="rodape.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>