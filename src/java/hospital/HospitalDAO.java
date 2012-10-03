/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

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
public class HospitalDAO {
    
    Connection con = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;
    
    public HospitalDAO(){
        
    }
    
    private Connection getConexao() throws SQLException{
        Connection con;
        con=ConexaoFactory.getInstancia().getConexao();
        return con;
    }
    
    public void cadastrar(HospitalBean hospitalBean){
        try{
            String query = "INSERT INTO Hospitais (Nome_Hospital) VALUES (?)";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.ptmt.setString(1, hospitalBean.getNome());
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
    
    public void alterar(HospitalBean hospitalBean){
        try{
            String query = "UPDATE Hospitais SET Nome_Hospital = ? WHERE Codigo_Hospital = ?";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.ptmt.setString(1, hospitalBean.getNome());
            this.ptmt.setInt(2, hospitalBean.getCodigo());
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
            String query = "DELETE Hospitais WHERE Codigo_Hospital = ?";
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
    
    public List retornarTodos(){
        
        List hospitais = new ArrayList();
        HospitalBean hospitalBean = null;
            
        try{    
            String query = "SELECT Codigo_Hospital, Nome_Hospital FROM Hospitais";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.rs = this.ptmt.executeQuery();
            
            while(rs.next()){
                hospitalBean = new HospitalBean();
                hospitalBean.setCodigo(rs.getInt(1));
                hospitalBean.setNome(rs.getString(2));
                hospitais.add(hospitalBean);
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
        return hospitais;
    }
    
    public HospitalBean retornarPeloCodigo(Integer codigo){
        
        HospitalBean hospitalBean = null;
            
        try{    
            String query = "SELECT Codigo_Hospital, Nome_Hospital FROM Hospitais WHERE Codigo_Hospital = ?";
            this.con = getConexao();
            this.ptmt = con.prepareStatement(query);
            this.ptmt.setInt(1, codigo);
            this.rs = this.ptmt.executeQuery();
            
            while(rs.next()){
                hospitalBean = new HospitalBean();
                hospitalBean.setCodigo(rs.getInt(1));
                hospitalBean.setNome(rs.getString(2));
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
        return hospitalBean;
    }
    
}
