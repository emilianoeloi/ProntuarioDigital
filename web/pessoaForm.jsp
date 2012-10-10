<!-- incluindo o cabecalho -->
<jsp:include page="cabecalho.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>
    <div class="span9">
        <h2>Pessoa</h2>
<form class="form-pessoa" method="POST" action="PessoaController">
                    <input type="hidden" id="acao" name="acao" value="cadastrar " />
                    <fieldset>
                        <legend>Pessoa</legend>
                                <label>Código<br />
                                    <input readonly="readonly" type="text" id="codigo" name="codigo" class="input-xxlarge">	
                                </label>
				<label>Nome<br />
                                    <input type="text" id="nome" name="nome" class="input-xxlarge">	
                                </label>
                                <label>CPF<br />
                                    <input type="text" id="cpf" name="cpf" class="input-xxlarge">	
                                </label>
                                <label>E-mail<br />
                                    <input type="text" id="email" name="email" class="input-xxlarge">	
                                </label>
                        <label>ID<br />
                                    <input type="text" id="id" name="id" class="input-xxlarge">	
                                </label>
                        <label>Data de nascimento<br />
                                    <input type="text" id="data-nascimento" name="data-nascimento" class="input-xxlarge">	
                                </label>
                        <label>Senha<br />
                                    <input type="text" id="senha" name="senha" class="input-xxlarge">	
                                </label>
			
			<div style="text-align: center">
				<button type="submit" class="btn btn-primary">Salvar</button>
				<button type="button" class="btn btn-danger">Cancelar</button>
				
                        </div>
                    </fieldset>
			</form>
    </div> 
<!-- inclusao do rodape -->
<jsp:include page="rodape.jsp" flush="true">
    <jsp:param name="login" value="generico" />
</jsp:include>