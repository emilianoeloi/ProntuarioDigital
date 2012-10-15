/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Administrador
 */
public class RestricaoDAO {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    private Connection getConexao() throws SQLException{
        
            Connection con;
            con = ConexaoFactory.getInstancia().getConexao();
            return con;
        
    }
    public void salvar (RestricaoBean restricoes) throws RestricaoDAOException, SQLException{
        
        try{
            String sql = "INSERT INTO restricao (descricao_restricao, tipo, fk_cpf) VALUES (?,?,?)";
            this.con = getConexao();
            this.stmt = con.prepareStatement(sql);
            this.stmt.setString(1, restricoes.getDescricao());
            this.stmt.setString(2, restricoes.getTipo());
            this.stmt.setString(3, restricoes.getCpf());
            
            this.stmt.executeUpdate();
        }catch(SQLException e){
            throw new RestricaoDAOException(e);
        }finally{
           if(stmt != null) stmt.close();
           if(con != null) con.close();
        }
        
    }
    public void excluir(RestricaoBean restricoes)  throws RestricaoDAOException, SQLException {
        if (restricoes == null) 
            throw new RestricaoDAOException ("O valor passado não pode ser nulo"); 
        try {
            String sql = "delete from restricao where codigo_restricao = ?";
            this.con = getConexao();
            this.stmt = this.con.prepareStatement(sql); 
            this.stmt.setInt(1, restricoes.getCodigo()); 
            this.stmt.executeUpdate(); 
        }catch (SQLException e) { 
            throw new RestricaoDAOException(e);
            
        }finally { 
            if(stmt != null) stmt.close();
            if(con != null) con.close();
        }
    }
    
    public void atualizar(RestricaoBean restricoes)  throws RestricaoDAOException, SQLException{ 
        try{ 
            String sql = "UPDATE  restricao SET descricao_restricao = ?, " +  
                    "tipo = ?, fk_cpf = ? where codigo_restricao = ?"; 
            this.con = getConexao();
            this.stmt = con.prepareStatement(sql); 
            this.stmt.setString(1, restricoes.getDescricao());
            this.stmt.setString(2, restricoes.getTipo());
            this.stmt.setString(3, restricoes.getCpf());
            this.stmt.setInt(4, restricoes.getCodigo());
            this.stmt.executeUpdate(); 
        }catch (SQLException e){ 
            throw new RestricaoDAOException(e);
        }finally{
            if(stmt != null) stmt.close();
            if(con != null) con.close();
        } 
    }

    
    public List retornaRestricoes() throws SQLException{
        List <RestricaoBean> restricoes = new ArrayList <RestricaoBean> ();
        
        try{
            this.con = getConexao();
            this.stmt = this.con.prepareStatement("select * from restricao");
            this.rs = this.stmt.executeQuery();
            
            while(rs.next()){
                int codigo = rs.getInt(1);
                String descricao = rs.getString(2);
                String tipo = rs.getString(3);
                String cpf = rs.getString(4);
                
                restricoes.add(new RestricaoBean(codigo, descricao, tipo, cpf));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
           if (this.rs != null) rs.close();
           if(this.stmt != null) stmt.close();
           if(this.con != null) con.close();
        }
        return restricoes;
    }
    
    
    public RestricaoBean adminRestricoes(int codigo) throws RestricaoDAOException, SQLException{ 
        try{ 
            this.con = getConexao();
            this.stmt = this.con.prepareStatement("select * from restricao where codigo_restricao = ?");
            this.stmt.setInt(1, codigo); 
            this.rs = this.stmt.executeQuery( ); 
            if(! rs.next() ) 
                throw new RestricaoDAOException( "Não  foi encontrado nenhum registro com:  " + codigo); 

            String descricao = rs.getString(2); 
            String tipo = rs.getString(3); 
            String cpf = rs.getString(4);
            
            return new RestricaoBean(codigo, descricao, tipo, cpf);
            
        }catch(SQLException e){
            throw new RestricaoDAOException(e);
            
        }finally{
           if (this.rs != null) rs.close();
           if(this.stmt != null) stmt.close();
           if(this.con != null) con.close();
        } 
        
    }
    public String ultimoRegistro() throws RestricaoDAOException, SQLException{
        
        
        
        try{
            this.con = getConexao();
            this.stmt = this.con.prepareStatement("select max (codigo_restricao) from restricao");
            this.rs = this.stmt.executeQuery();
            
            if(! rs.next() ) 
                throw new RestricaoDAOException("Não  foi encontrado nenhum registro"); 

            int ultimo = rs.getInt(1);
            ultimo = ultimo + 1;
            String codigo = String.valueOf(ultimo);
            
            return codigo;
            
        }catch(SQLException e){
            throw new RestricaoDAOException(e);
        }finally{
            if(this.rs != null) rs.close();
            if(this.stmt != null) stmt.close();
            if (this.con != null) con.close();
        }
        
        
    }
    
}
