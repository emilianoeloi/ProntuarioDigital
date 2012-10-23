<%-- 
    Document   : informacoes
    Created on : Oct 21, 2012, 1:29:51 PM
    Author     : emilianoeloi
--%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!-- CABECALHO -->
<jsp:include page="cabecalho.jsp" flush="true">
    <jsp:param name="pagina" value="info" />
</jsp:include>

<!-- CONTEUDO -->
                   <div class="row">
            <div class="span12">
      <h1>Informa��es</h1>
      <p>O objetivo do nosso Sistema é centralizar informações sobre o histórico de saúde do paciente e permitir o acompanhamento por qualquer médico.
O Prontuário Digital armazenará informações úteis para o procedimento de atendi-mento, pois, disponibiliza dados como tipo sanguíneo do paciente, alergias, cirurgi-as dentre outras informações relevantes.
</p>
            </div>
        </div>
       <!-- Example row of columns -->
      <div class="row">
       <a name="comp"></a>               
        <div class="span8">
          
          <h2>Compartilhamento</h2>
          
          <p>Qualquer médico em qualquer lugar pode acessar os dados de um paciente específico. Isto garante qualidade, agilidade e eficiência mesmo em consultas com médicos diferentes.</p>
          
        </div>
       
       <!-- BOX CADASTRO -->
       <jsp:include page="boxcadastro.jsp" flush="true">
            <jsp:param name="pagina" value="info" />
        </jsp:include>

          
       <a name="inte"></a>
        <div class="span8">
            
          <h2>Integração</h2>
          <p>Pode ser compartilhado pelo paciente. Qualquer médico que utilize o prontuário digital. Qualquer médico em qualquer lugar pode acessar os dados de um paciente específico. Isto garante qualidade, agilidade e eficiência mesmo em consultas com médicos diferentes.</p>
          
       </div>
        <div class="span8">
            <a name="hist"></a>
            <h2>Histórico</h2>
          <p>Além dos limites da clínica. Facilita o cruzamento de informa-ções entre familiares auxiliando no tratamento de doenças hereditárias.</p>
          
        </div>
      </div>

<!-- RODAPE -->
<jsp:include page="rodape.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>