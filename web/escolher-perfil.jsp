<%-- 
    Document   : faleconosco
    Created on : Oct 21, 2012, 4:23:26 PM
    Author     : emilianoeloi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="perfil" scope="request" class="String"></jsp:useBean> 
<jsp:useBean id="pessoaPrimeiroCadastro" scope="request" class="pessoa.PessoaBean" />
<jsp:include page="cabecalho.jsp" flush="true">
    <jsp:param name="pagina" value="contato" />
</jsp:include>
<div class="row">
    <div class="span7">
    <h1>Escolher Perfil</h1>
    <form class="form-horizontal" id="cadastro-completo" method="post" action="PessoaController">
        <input type="hidden" value="cadastrar" id="acao" name="acao" />
        <input type="hidden" value="<%=pessoaPrimeiroCadastro.getCodigo()%>" id="codigo" name="codigo" />
    <fieldset>

        <legend>Escolha seu perfil para continuar o cadastro</legend>
<ul class="nav nav-tabs">
    <li <% if (perfil.equalsIgnoreCase("pessoa")){ %> class="active"<% } %> >
        <a href="PessoaController?acao=escolherperfil&perfil=pessoa"><i class="icon-user"></i>Pessoa</a>
  </li>
  <li <% if (perfil.equalsIgnoreCase("medico")){ %> class="active"<% } %> >
      <a href="PessoaController?acao=escolherperfil&perfil=medico"><i class="icon-user"></i>Médico</a>
  </li>
  <li <% if (perfil.equalsIgnoreCase("paciente")){ %> class="active"<% } %> >
      <a href="PessoaController?acao=escolherperfil&perfil=paciente"><i class="icon-user"></i>Paciente</a>
  </li>
</ul>
      <div class="control-group">
            <label class="control-label" for="nome">
                Nome: 
            </label>  
            <div class="controls">    
                <input type="text" value="<%=pessoaPrimeiroCadastro.getNome()%>" class="input-xlarge" placeholder="Digite seu nome…" id="nome" name="nome" />
            </div>
       </div>
      <div class="control-group">
            <label class="control-label" for="email">
                E-mail: 
            </label>  
            <div class="controls">    
                <input type="text" value="<%=pessoaPrimeiroCadastro.getEmail()%>" class="input-xlarge" placeholder="Digite seu e-mail…" id="email" name="email" />
            </div>
       </div>
      <div class="control-group">
            <label class="control-label" for="cpf">
                CPF: 
            </label>  
            <div class="controls">    
                <input type="text" value="<%=pessoaPrimeiroCadastro.getCpf()%>" class="input-xlarge campo-cpf" placeholder="Digite seu CPF…" id="cpf" name="cpf" />
            </div>
       </div>
      <div class="control-group">
            <label class="control-label" for="id">
                RG: 
            </label>  
            <div class="controls">    
                <input type="text" value="<%=pessoaPrimeiroCadastro.getId()%>" class="input-xlarge" placeholder="Digite seu RG…" id="id" name="id" />
            </div>
       </div>
      <div class="control-group">
            <label class="control-label" for="data-nascimento">
                Data de Nascimento: 
            </label>  
            <div class="controls">    
                <input type="text" value="<%=pessoaPrimeiroCadastro.getDataNascimento()%>" class="input-xlarge campo-data" placeholder="Digite sua data de nascimento…" id="data-nascimento" name="data-nascimento" />
            </div>
       </div>
      <% if (perfil.equalsIgnoreCase("medico")){ %>
      <div class="control-group">
            <label class="control-label" for="nome">
                CRM: 
            </label>  
            <div class="controls">    
                <input type="text" value="<%=pessoaPrimeiroCadastro.getDataNascimento()%>" class="input-xlarge" placeholder="Digite seu CRM…" id="nome" />
            </div>
       </div>
      <% } %>
        <div class="control-group">
            <div class="controls">
                <input type="submit" class="btn btn-primary" value="Salvar" />
            </div>
        </div>
    </fieldset>
    </form>    
    </div>
         <!-- BOX CADASTRO -->
       <jsp:include page="boxpublicidade.jsp" flush="true">
            <jsp:param name="pagina" value="info" />
        </jsp:include>
    <script type="text/javascript">  
    <script type="text/javascript">

$().ready(function() {
    
        
        
        $('#box-cadastro').validate({
            rules:{
                email:{
                    required: true,
                    email:true,
                    verifyLogin: true
                },
                nome:{
                    required: true
                },
                senha:{
                    required: true
                }
            },
            messages:{
                email:{
                    required: 'Obrigatório',
                    email: 'Inválido',
                    verifyLogin: 'já cadastrado'
                },
                nome:{
                    required: 'Obrigatório'
                },
                senha: {
                    required: 'Obrigatório'
                }
            }
        });
    }); 
    </script>        
</div>
<jsp:include page="rodape.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>