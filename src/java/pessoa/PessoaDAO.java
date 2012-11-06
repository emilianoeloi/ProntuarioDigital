/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import factory.ConexaoFactory;
import java.util.Date;
import dao.*;

/**
 *
 * @author emilianoeloi
 */
public class PessoaDAO extends GenericDAO implements InterfacePessoaDAO {
    
    public PessoaDAO(){
        super();
    }
    
    private void obterProximoCodigo(PessoaBean pessoa) throws SQLException{
        try{
            super.setSql("SELECT NEXTVAL('pessoas_codigo_pessoa_seq') AS codigo");
            super.executarSelect();
            
            while(super.getResultSet().next()){
                pessoa.setCodigo(super.getResultSet().getInt(1));
            }
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha na recuperacao do proximo codigo"+e);
        }finally{
            super.fecharConexao();
        }
    }

    public void cadastrar(PessoaBean pessoa) throws SQLException{
        
        if(pessoa == null)
            throw new GenericDAOException("O objeto passado não pode ser nulo.");
        
        this.obterProximoCodigo(pessoa);
        
        try{
            super.setSql("INSERT INTO pessoas (Codigo_Pessoa, Nome_Pessoa, Cpf_Pessoa, Email_Pessoa, Id_Pessoa, Data_Nascimento_Pessoa, Senha_Pessoa) "
                          +"VALUES (?,?,?,?,?,?,MD5('S3nhaP4drao'))");

            super.setParametro(pessoa.getCodigo());
            super.setParametro(pessoa.getNome());
            super.setParametro(pessoa.getCpf());
            super.setParametro(pessoa.getEmail());
            super.setParametro(pessoa.getId());
            super.setParametro(pessoa.getDataNascimento());
            
            super.executarInsert();
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha no cadastro"+e);
        }finally{
            super.fecharConexao();
        }
    }
    
    public void alterar(PessoaBean pessoa) throws SQLException{
        
        if(pessoa == null)
            throw new GenericDAOException("O objeto passado não pode ser nulo.");
        
        try{
            
            super.setSql("UPDATE pessoas SET Nome_Pessoa = ?, Cpf_Pessoa = ?, Email_Pessoa = ?"
                    + ", Id_Pessoa = ?, Data_Nascimento_Pessoa = ? WHERE Codigo_Pessoa = ?");
            
            super.setParametro(pessoa.getNome());
            super.setParametro(pessoa.getCpf());
            super.setParametro(pessoa.getEmail());
            super.setParametro(pessoa.getId());
            super.setParametro(pessoa.getDataNascimento());
            super.setParametro(pessoa.getCodigo());
            
            super.executarUpdate();
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha na alteração"+e);
        }
    }
    
    public void definirSenha(PessoaBean pessoa) throws SQLException{
        
        if(pessoa == null)
            throw new GenericDAOException("O objeto passado não pode ser nulo.");
        
        try{
            
            super.setSql("UPDATE pessoas SET Senha_Pessoa = MD5(?)  WHERE Codigo_Pessoa = ?");
            
            super.setParametro(pessoa.getSenha());
            super.setParametro(pessoa.getCodigo());
            
            super.executarUpdate();
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha na alteração"+e);
        }
    }
    
    public void alterarStatus(PessoaBean pessoa) throws SQLException{
        
        if(pessoa == null)
            throw new GenericDAOException("O objeto passado não pode ser nulo.");
        
        try{
            
            super.setSql("UPDATE pessoas SET Status_Pessoa = ?  WHERE Codigo_Pessoa = ?");
            
            super.setParametro(pessoa.getStatus());
            super.setParametro(pessoa.getCodigo());
            
            super.executarUpdate();
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha na alteração"+e);
        }
    }
    
    public void excluir(PessoaBean pessoa) throws SQLException{
        
        if(pessoa == null)
            throw new GenericDAOException("O objeto passado não pode ser nulo.");
        
        try{
            super.setSql("DELETE FROM pessoas WHERE Codigo_Pessoa = ?");

            super.setParametro(pessoa.getCodigo());
            
            super.executarDelete();
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha na exclusão"+e);
        }
    }
    
    public boolean existePeloCodigo(Integer codigo) throws SQLException{
        if(codigo == null || codigo == 0)
            throw new GenericDAOException("O Código precisa ser válido.");
        
        try{
            super.setSql("SELECT Codigo_Pessoa FROM pessoas WHERE Codigo_Pessoa = ?");
            super.setParametro(codigo);
            super.executarSelect();
            
            while(super.getResultSet().next()){
                return true;
            }
            
        }catch(SQLException e){
            throw new SQLException("Houve uma falha na Recuperação "+e);
        }finally{
            super.fecharConexao();
        }
        return false;
    }
    
    public List retornarTodos() throws SQLException{
        
        List pessoas = new ArrayList();
            
        try{    
            super.setSql("SELECT Codigo_Pessoa, Nome_Pessoa, Cpf_Pessoa, Email_Pessoa, Id_Pessoa, "
                    + "Data_Nascimento_Pessoa, Senha_Pessoa FROM pessoas");
            super.executarSelect();
            
            ResultSet rs = super.getResultSet();
            while(rs.next()){
                PessoaBean pessoa = new PessoaBean();
                pessoa.setCodigo(rs.getInt(1));
                pessoa.setNome(rs.getString(2));
                pessoa.setCpf(rs.getString(3));
                pessoa.setEmail(rs.getString(4));
                pessoa.setId(rs.getString(5));
                pessoa.setDataNascimento(rs.getDate(6));
                pessoa.setSenha(rs.getString(7));
                pessoas.add(pessoa);
            }
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha ao tentar recupear uma lista de Pessoas "+e);
        }finally{
            super.fecharConexao();
        }
        return pessoas;
    }
    
    public PessoaBean retornarPeloCodigo(Integer codigo) throws SQLException{
        if(codigo == null || codigo == 0)
            throw new GenericDAOException("O Código precisa ser válido.");
        
        PessoaBean pessoa = null;
            
        try{    
            super.setSql("SELECT Codigo_Pessoa, Nome_Pessoa, Cpf_Pessoa, Email_Pessoa, Id_Pessoa, "
                    + "Data_Nascimento_Pessoa, Senha_Pessoa FROM pessoas WHERE Codigo_Pessoa = ?");
            super.setParametro(codigo);
            super.executarSelect();
            
            ResultSet rs = super.getResultSet();
            while(rs.next()){
                pessoa = new PessoaBean();
                pessoa.setCodigo(rs.getInt(1));
                pessoa.setNome(rs.getString(2));
                pessoa.setCpf(rs.getString(3));
                pessoa.setEmail(rs.getString(4));
                pessoa.setId(rs.getString(5));
                pessoa.setDataNascimento(rs.getDate(6));
                pessoa.setSenha(rs.getString(7));
            }
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha ao tentar recuperar "+e);
        }finally{
            super.fecharConexao();
        }
        return pessoa;
    }
    
    public PessoaBean procurarPeloEmail(String email) throws SQLException{
        if(email == "")
            throw new GenericDAOException("O valor precisa ser preenchido.");        
        
        PessoaBean pessoa = null;
            
        try{    
            super.setSql("SELECT Codigo_Pessoa, Nome_Pessoa, Cpf_Pessoa, Email_Pessoa, Id_Pessoa, "
                    + "Data_Nascimento_Pessoa, Senha_Pessoa FROM pessoas WHERE Email_Pessoa = ?");
            super.setParametro(email);
            super.executarSelect();
            
            ResultSet rs = super.getResultSet();
            while(rs.next()){
                pessoa = new PessoaBean();
                pessoa.setCodigo(rs.getInt(1));
                pessoa.setNome(rs.getString(2));
                pessoa.setCpf(rs.getString(3));
                pessoa.setEmail(rs.getString(4));
                pessoa.setId(rs.getString(5));
                pessoa.setDataNascimento(rs.getDate(6));
                pessoa.setSenha(rs.getString(7));
            }
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha ao tentar recuperar "+e);
        }finally{
            super.fecharConexao();
        }
        return pessoa;
    }
    
    public PessoaBean procurarPeloCpf(PessoaBean pessoa) throws SQLException{
        if(pessoa.getCpf().equals(""))
            throw new GenericDAOException("O valor precisa ser preenchido.");        
        
        try{    
            super.setSql("SELECT Codigo_Pessoa, Nome_Pessoa, Cpf_Pessoa, Email_Pessoa, Id_Pessoa, "
                    + "Data_Nascimento_Pessoa, Senha_Pessoa FROM pessoas WHERE Cpf_Pessoa = ?");
            super.setParametro(pessoa.getCpf());
            super.executarSelect();
            
            ResultSet rs = super.getResultSet();
            while(rs.next()){
                pessoa = new PessoaBean();
                pessoa.setCodigo(rs.getInt(1));
                pessoa.setNome(rs.getString(2));
                pessoa.setCpf(rs.getString(3));
                pessoa.setEmail(rs.getString(4));
                pessoa.setId(rs.getString(5));
                pessoa.setDataNascimento(rs.getDate(6));
                pessoa.setSenha(rs.getString(7));
            }
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha ao tentar recuperar "+e);
        }finally{
            super.fecharConexao();
        }
        return pessoa;
    }
    
    public PessoaBean recuperarPorUsuarioSenha(PessoaBean pessoa) throws SQLException{
        
            
        try{    
            super.setSql("SELECT Codigo_Pessoa, Nome_Pessoa, Cpf_Pessoa, Email_Pessoa, Id_Pessoa, "
                    + "Data_Nascimento_Pessoa, Senha_Pessoa, Status_Pessoa FROM pessoas "
                    + "WHERE Email_Pessoa = ? AND Senha_Pessoa = MD5(?) ");

            super.setParametro(pessoa.getEmail());
            super.setParametro(pessoa.getSenha());
            super.executarSelect();
            
            ResultSet rs = super.getResultSet();
            while(rs.next()){
                pessoa = new PessoaBean();
                pessoa.setCodigo(rs.getInt(1));
                pessoa.setNome(rs.getString(2));
                pessoa.setCpf(rs.getString(3));
                pessoa.setEmail(rs.getString(4));
                pessoa.setId(rs.getString(5));
                pessoa.setDataNascimento(rs.getDate(6));
                pessoa.setSenha(rs.getString(7));
                pessoa.setStatus(rs.getInt(8));
            }
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha ao tentar recuperar "+e);
        }
        return pessoa;
    }
    
}
