<%-- 
    Document   : INDEX
    Created on : Oct 21, 2012, 1:29:51 PM
    Author     : emilianoeloi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- CABECALHO -->
<jsp:include page="cabecalho.jsp" flush="true">
    <jsp:param name="pagina" value="home" />
</jsp:include>

<!-- CONTEUDO -->

  <!-- Main hero unit for a primary marketing message or call to action -->
  <div class="hero-unit">
    <h1>Prontuário Digital</h1>
    <p>O objetivo do nosso Sistema é centralizar informações sobre o histórico de saúde do paciente e permitir o acompanhamento por qualquer médico.
O Prontuário Digital armazenará informações úteis para o procedimento de atendi-mento, pois, disponibiliza dados como tipo sanguíneo do paciente, alergias, cirurgi-as dentre outras informações relevantes.</p>
    <p><a class="btn btn-primary btn-large" href="informacoes.jsp">Saiba mais &raquo;</a></p>
  </div>

  <!-- Example row of columns -->
  <div class="row">
    <div class="span4">
      <h2>Compartilhamento</h2>
      <p>Qualquer médico em qualquer lugar pode acessar os dados de um paciente específico. Isto garante qualidade, agilidade e eficiência mesmo em consultas com médicos diferentes.</p>
      <p><a class="btn" href="informacoes.jsp#comp">Mais sobre compartilhamento &raquo;</a></p>
    </div>
    <div class="span4">
      <h2>Integração</h2>
      <p>Pode ser compartilhado pelo paciente. Qualquer médico que utilize o prontuário digital. Qualquer médico em qualquer lugar pode acessar os dados de um paciente específico. Isto garante qualidade, agilidade e eficiência mesmo em consultas com médicos diferentes.</p>
      <p><a class="btn" href="informacoes.jsp#inte">Mais sobre integração &raquo;</a></p>
   </div>
    <div class="span4">
      <h2>Histórico</h2>
      <p>Além dos limites da clínica. Facilita o cruzamento de informa-ções entre familiares auxiliando no tratamento de doenças hereditárias.</p>
      <p><a class="btn" href="informacoes.jsp#hist">Mais sobre histórico &raquo;</a></p>
    </div>
  </div>

<!-- RODAPE -->
<jsp:include page="rodape.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>