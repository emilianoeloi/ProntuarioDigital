/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoa;

import java.util.List;



/**
 *
 * @author emilianoeloi
 */
public interface InterfacePessoaDAO {
    
    public void cadastrar(PessoaBean pessoaBean) throws PessoaDAOException;
    
    public void alterar(PessoaBean pessoaBean) throws PessoaDAOException;
    
    public void excluir(PessoaBean pessoaBean) throws PessoaDAOException;
    
    public boolean existePessoaPeloCodigo(Integer codigo) throws PessoaDAOException;
    
    public List retornarTodos() throws PessoaDAOException;
    
    public PessoaBean retornarPeloCodigo(Integer codigo) throws PessoaDAOException;
    
    public PessoaBean recuperarPorUsuarioSenha(PessoaBean pessoa) throws PessoaDAOException;
    
}
