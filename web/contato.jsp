<%-- 
    Document   : faleconosco
    Created on : Oct 21, 2012, 4:23:26 PM
    Author     : emilianoeloi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="cabecalho.jsp" flush="true">
    <jsp:param name="pagina" value="contato" />
</jsp:include>
<div class="row">
    <div class="span7">
    <h1>Contato</h1>
    <form class="form-horizontal">
    <fieldset>

        <legend>Entre em contato conosco para saber mais detalhes...</legend>
        <div class="control-group">
            <label class="control-label" for="home-contato-nome">
                Nome: 
            </label>  
            <div class="controls">    
                <input type="text" class="input-xlarge" placeholder="Digite seu nome…" id="home-contato-nome">
            </div>
        </div>  
        <div class="control-group">
            <label class="control-label" for="home-contato-email">
                E-mail:
            </label>
            <div class="controls"> 
                <input type="text" class="input-xlarge" placeholder="Digite seu e-mail…" id="home-contato-email"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="home-contato-assunto">
                Assunto:
            </label>
            <div class="controls">
                <input type="text" class="input-xlarge" placeholder="Digite o assunto do seu contato…"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="home-contato-texto">
            Texto:
            </label>
            <div class="controls">
                <textarea class="input-xlarge" id="home-contato-texto"></textarea>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <input type="submit" class="btn btn-primary" value="Enviar" />
            </div>
        </div>
    </fieldset>
    </form>    
    </div>
       <!-- BOX CADASTRO -->
       <jsp:include page="boxcadastro.jsp" flush="true">
            <jsp:param name="pagina" value="info" />
        </jsp:include>
</div>
<jsp:include page="rodape.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>