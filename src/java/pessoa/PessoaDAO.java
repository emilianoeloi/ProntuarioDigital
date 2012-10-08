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
public class PessoaDAO {
    
    Connection con = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;
    
    private Connection getConexao() throws SQLException{
        Connection con;
        con=ConexaoFactory.getInstancia().getConexao();
        return con;
    }

    public void cadastrar(PessoaBean pessoaBean){
        try{
            String query = "INSERT INTO pessoas (Nome_Pessoa, Cpf_Pessoa, Email_Pessoa, Id_Pessoa, Data_Nascimento_Pessoa, Senha_Pessoa) "
                          +"VALUES (?,?,?,?,?,?)";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.ptmt.setString(1, pessoaBean.getNome());
            this.ptmt.setString(2, pessoaBean.getCpf());
            this.ptmt.setString(3, pessoaBean.getEmail());
            this.ptmt.setString(4, pessoaBean.getId());
            this.ptmt.setDate(5, pessoaBean.getDataNascimento());
            this.ptmt.setString(6, pessoaBean.getSenha());
            this.ptmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(this.rs!=null)
                    rs.close();
                if(this.ptmt!=null)
                    ptmt.close();
                if(this.con!=null)
                    this.con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void alterar(PessoaBean pessoaBean){
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
            e.printStackTrace();
        }finally{
            try{
                if(this.rs!=null)
                    rs.close();
                if(this.ptmt!=null)
                    ptmt.close();
                if(this.con!=null)
                    this.con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        } 
    }
    
    public void excluir(Integer codigo){
        try{
            String query = "DELETE pessoas WHERE Codigo_Pessoa = ?";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.ptmt.setInt(1, codigo);
            this.ptmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(this.rs!=null)
                    rs.close();
                if(this.ptmt!=null)
                    ptmt.close();
                if(this.con!=null)
                    this.con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        } 
    }
    
    public boolean existePessoaPeloCodigo(Integer codigo){
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
            e.printStackTrace();
        }finally{
            try{
                if(this.rs!=null)
                    rs.close();
                if(this.ptmt!=null)
                    ptmt.close();
                if(this.con!=null)
                    this.con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        } 
        return false;
    }
    
    public List retornarTodos(){
        
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
            e.printStackTrace();
        }finally{
            try{
                if(this.rs!=null)
                    rs.close();
                if(this.ptmt!=null)
                    ptmt.close();
                if(this.con!=null)
                    this.con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return pessoas;
    }
    
    public PessoaBean retornarPeloCodigo(Integer codigo){
        
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
            e.printStackTrace();
        }finally{
            try{
                if(this.rs!=null)
                    rs.close();
                if(this.ptmt!=null)
                    ptmt.close();
                if(this.con!=null)
                    this.con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return pessoaBean;
    }
    
}
