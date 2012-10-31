/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import factory.ConexaoFactory;

/**
 *
 * @author emilianoeloi
 */
public class ExameDAO {
    
    Connection con = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;
    
    public ExameDAO (){
        
    }
    
    private Connection getConexao() throws SQLException{
        Connection con;
        con=ConexaoFactory.getInstancia().getConexao();
        return con;
    }
    
    private void obterProximoCodigo(ExameBean exame){
                    
        try{    
            
            String query = "SELECT NEXTVAL ('exames_codigo_exame_seq') AS codigo";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.rs = this.ptmt.executeQuery();
            
            while(rs.next()){
                exame.setCodigo(rs.getInt(1));
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
    }
    
   
    
    public void cadastrar(ExameBean exameBean){
        try{
            String query = "INSERT INTO exames (codigo_exame, Nome_Exame, Descricao_exame) VALUES (?,?, ?)";
            this.obterProximoCodigo(exameBean);
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.ptmt.setInt(1, exameBean.getCodigo());
            this.ptmt.setString(2, exameBean.getNome());
            this.ptmt.setString (3, exameBean.getDescricao());
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
    
    public void alterar(ExameBean exameBean){
        try{
            String query = "UPDATE exames SET Nome_exame = ?, Descricao_exame = ? WHERE Codigo_exame = ?";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.ptmt.setString(1, exameBean.getNome());
            this.ptmt.setString (2, exameBean.getDescricao());
            this.ptmt.setInt(3, exameBean.getCodigo());
            
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
    
    public void excluir(ExameBean examebean){ //Integer codigo
        try{
            String query = "DELETE from exames WHERE Codigo_exame = ?";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.ptmt.setInt(1, examebean.getCodigo());
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
    
    public List retornarTodos(){
        
        List exame = new ArrayList();
        ExameBean exameBean = null;
            
        try{    
            String query = "SELECT Codigo_exame, Nome_exame, Descricao_exame FROM exames";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.rs = this.ptmt.executeQuery();
            
            while(rs.next()){
                exameBean = new ExameBean();
                exameBean.setCodigo(rs.getInt(1));
                exameBean.setNome(rs.getString(2));
                exameBean.setDescricao(rs.getString(3));
                exame.add(exameBean);
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
        return exame;
    }
    
    public ExameBean retornarPeloCodigo(Integer codigo){
        
        ExameBean exameBean = null;
            
        try{    
            String query = "SELECT Codigo_exame, Nome_exame, Descricao_exame FROM exames WHERE Codigo_exame = ?";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.ptmt.setInt(1, codigo);
            this.rs = this.ptmt.executeQuery();
            
            while(rs.next()){
                exameBean = new ExameBean();
                exameBean.setCodigo(rs.getInt(1));
                exameBean.setNome(rs.getString(2));
                exameBean.setDescricao(rs.getString(3));
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
        return exameBean;
    }
    
}
