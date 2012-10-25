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

/**
 *
 * @author emilianoeloi
 */
public class PessoaDAO implements InterfacePessoaDAO {
    
    Connection con = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;
    
    private Connection getConexao() throws PessoaDAOException{
        try{
            Connection con;
            con=ConexaoFactory.getInstancia().getConexao();
            return con;
        }catch(Exception e){
            throw new PessoaDAOException("Erro"+e.getMessage());
        }
    }
    
    private void obterProximoCodigo(PessoaBean pessoa) throws PessoaDAOException{
        try{
            String query = "SELECT NEXTVAL('pessoas_codigo_pessoa_seq') AS codigo";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.rs = this.ptmt.executeQuery();
            
            while(rs.next()){
                pessoa.setCodigo(rs.getInt(1));
            }
        }catch(SQLException e){
            throw new PessoaDAOException("Houve uma falha na recuperacao do proximo codigo"+e);
        }finally{
            try{
                this.con.close();
            }catch(SQLException e){
                throw new PessoaDAOException("Fala ao tentar fechar a conexão"+e);
            }
        }
    }

    public void cadastrar(PessoaBean pessoaBean) throws PessoaDAOException{
        
        if(pessoaBean == null)
            throw new PessoaDAOException("O objeto passado não pode ser nulo.");
        
        this.obterProximoCodigo(pessoaBean);
        
        try{
            String query = "INSERT INTO pessoas (Codigo_Pessoa, Nome_Pessoa, Cpf_Pessoa, Email_Pessoa, Id_Pessoa, Data_Nascimento_Pessoa, Senha_Pessoa) "
                          +"VALUES (?,?,?,?,?,?,MD5(?))";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.ptmt.setInt(1, pessoaBean.getCodigo());
            this.ptmt.setString(2, pessoaBean.getNome());
            this.ptmt.setString(3, pessoaBean.getCpf());
            this.ptmt.setString(4, pessoaBean.getEmail());
            this.ptmt.setString(5, pessoaBean.getId());
            this.ptmt.setDate(6, pessoaBean.getDataNascimento());
            this.ptmt.setString(7, pessoaBean.getSenha());
            this.ptmt.executeUpdate();
        }catch(SQLException e){
            throw new PessoaDAOException("Houve uma falha no cadastro"+e);
        }finally{
            try{
                this.con.close();
            }catch(SQLException e){
                throw new PessoaDAOException("Fala ao tentar fechar a conexão"+e);
            }
        }
    }
    
    public void alterar(PessoaBean pessoaBean) throws PessoaDAOException{
        
        if(pessoaBean == null)
            throw new PessoaDAOException("O objeto passado não pode ser nulo.");
        
        try{
            String query = "UPDATE pessoas SET Nome_Pessoa = ?, Cpf_Pessoa = ?, Email_Pessoa = ?"
                    + ", Id_Pessoa = ?, Data_Nascimento_Pessoa = ?, Senha_Pessoa = ? WHERE Codigo_Pessoa = ?";
            
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.ptmt.setString(1, pessoaBean.getNome());
            this.ptmt.setString(2, pessoaBean.getCpf());
            this.ptmt.setString(3, pessoaBean.getEmail());
            this.ptmt.setString(4, pessoaBean.getId());
            this.ptmt.setDate(5, pessoaBean.getDataNascimento());
            this.ptmt.setString(6, pessoaBean.getSenha());
            this.ptmt.setInt(7, pessoaBean.getCodigo());
            
            this.ptmt.executeUpdate();
        }catch(SQLException e){
            throw new PessoaDAOException("Houve uma falha na alteração"+e);
        }finally{
            try{
                this.con.close();
            }catch(SQLException e){
                throw new PessoaDAOException("Fala ao tentar fechar a conexão"+e);
            }
        }
    }
    
    public void excluir(PessoaBean pessoaBean) throws PessoaDAOException{
        
        if(pessoaBean == null)
            throw new PessoaDAOException("O objeto passado não pode ser nulo.");
        
        try{
            String query = "DELETE FROM pessoas WHERE Codigo_Pessoa = ?";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.ptmt.setInt(1, pessoaBean.getCodigo());
            this.ptmt.executeUpdate();
        }catch(SQLException e){
            throw new PessoaDAOException("Houve uma falha na exclusão"+e);
        }finally{
            try{
                this.con.close();
            }catch(SQLException e){
                throw new PessoaDAOException("Fala ao tentar fechar a conexão"+e);
            }
        } 
    }
    
    public boolean existePessoaPeloCodigo(Integer codigo) throws PessoaDAOException{
        try{
            String query = "SELECT Codigo_Pessoa FROM pessoas WHERE Codigo_Pessoa = ?";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.ptmt.setInt(1, codigo);
            this.rs = this.ptmt.executeQuery();
            
            while(rs.next()){
                return true;
            }
            
        }catch(SQLException e){
            throw new PessoaDAOException("Houve uma falha na Recuperação "+e);
        }finally{
            try{
                this.con.close();
            }catch(SQLException e){
                throw new PessoaDAOException("Fala ao tentar fechar a conexão"+e);
            }
        } 
        return false;
    }
    
    public List retornarTodos() throws PessoaDAOException{
        
        List pessoas = new ArrayList();
        PessoaBean pessoaBean = null;
            
        try{    
            String query = "SELECT Codigo_Pessoa, Nome_Pessoa, Cpf_Pessoa, Email_Pessoa, Id_Pessoa, "
                    + "Data_Nascimento_Pessoa, Senha_Pessoa FROM pessoas";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.rs = this.ptmt.executeQuery();
            
            while(rs.next()){
                pessoaBean = new PessoaBean();
                pessoaBean.setCodigo(rs.getInt(1));
                pessoaBean.setNome(rs.getString(2));
                pessoaBean.setCpf(rs.getString(3));
                pessoaBean.setEmail(rs.getString(4));
                pessoaBean.setId(rs.getString(5));
                pessoaBean.setDataNascimento(rs.getDate(6));
                pessoaBean.setSenha(rs.getString(7));
                pessoas.add(pessoaBean);
            }
            
        }catch(SQLException e){
            throw new PessoaDAOException("Houve uma falha ao tentar recupear uma lista de Pessoas "+e);
        }finally{
            try{
                this.con.close();
            }catch(SQLException e){
                throw new PessoaDAOException("Fala ao tentar fechar a conexão"+e);
            }
        } 
        return pessoas;
    }
    
    public PessoaBean retornarPeloCodigo(Integer codigo) throws PessoaDAOException{
        
        PessoaBean pessoaBean = null;
            
        try{    
            String query = "SELECT Codigo_Pessoa, Nome_Pessoa, Cpf_Pessoa, Email_Pessoa, Id_Pessoa, "
                    + "Data_Nascimento_Pessoa, Senha_Pessoa FROM pessoas WHERE Codigo_Pessoa = ?";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.ptmt.setInt(1, codigo);
            this.rs = this.ptmt.executeQuery();
            
            while(rs.next()){
                pessoaBean = new PessoaBean();
                pessoaBean.setCodigo(rs.getInt(1));
                pessoaBean.setNome(rs.getString(2));
                pessoaBean.setCpf(rs.getString(3));
                pessoaBean.setEmail(rs.getString(4));
                pessoaBean.setId(rs.getString(5));
                pessoaBean.setDataNascimento(rs.getDate(6));
                pessoaBean.setSenha(rs.getString(7));
            }
            
        }catch(SQLException e){
            throw new PessoaDAOException("Houve uma falha ao tentar recuperar "+e);
        }finally{
            try{
                this.con.close();
            }catch(SQLException e){
                throw new PessoaDAOException("Fala ao tentar fechar a conexão"+e);
            }
        } 
        return pessoaBean;
    }
    
    public PessoaBean recuperarPorUsuarioSenha(PessoaBean pessoa) throws PessoaDAOException{
        
        PessoaBean pessoaBean = null;
            
        try{    
            String query = "SELECT Codigo_Pessoa, Nome_Pessoa, Cpf_Pessoa, Email_Pessoa, Id_Pessoa, "
                    + "Data_Nascimento_Pessoa, Senha_Pessoa FROM pessoas "
                    + "WHERE Email_Pessoa = ? AND Senha_Pessoa = MD5(?) ";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.ptmt.setString(1, pessoa.getEmail());
            this.ptmt.setString(2, pessoa.getSenha());
            this.rs = this.ptmt.executeQuery();
            
            while(rs.next()){
                pessoaBean = new PessoaBean();
                pessoaBean.setCodigo(rs.getInt(1));
                pessoaBean.setNome(rs.getString(2));
                pessoaBean.setCpf(rs.getString(3));
                pessoaBean.setEmail(rs.getString(4));
                pessoaBean.setId(rs.getString(5));
                pessoaBean.setDataNascimento(rs.getDate(6));
                pessoaBean.setSenha(rs.getString(7));
            }
            
        }catch(SQLException e){
            throw new PessoaDAOException("Houve uma falha ao tentar recuperar "+e);
        }finally{
            try{
                this.con.close();
            }catch(SQLException e){
                throw new PessoaDAOException("Fala ao tentar fechar a conexão"+e);
            }
        } 
        return pessoaBean;
    }
    
}
