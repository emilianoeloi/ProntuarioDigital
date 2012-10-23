<%-- 
    Document   : boxcadastro
    Created on : Oct 21, 2012, 5:04:40 PM
    Author     : emilianoeloi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="span3 well" style="float: right">
    <h2>Cadastre-se</h2>
    <form id="home-cadastro" method="post" action="PessoaController" >
        <input type="hidden" id="acao" name="acao" value="primeiro-cadastro" />
        <label>
            E-mail:
            <input type="text" id="email" name="email" />
        </label>
        <label>
            Nome:
            <input type="text" id="nome" name="nome" />
        </label>
        <label>
            Senha:
            <input type="password" id="senha" name="senha" />
        </label>
        <div style="text-align: right">
        <input type="submit" value="Inicar cadastro..." class="btn btn-primary" />
        </div>
    </form>
</div>