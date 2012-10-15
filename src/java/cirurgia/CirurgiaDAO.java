/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cirurgia;

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
public class CirurgiaDAO {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    private Connection getConexao() throws SQLException{
        
            Connection con;
            con = ConexaoFactory.getInstancia().getConexao();
            return con;
        
    }
    public void salvar (CirurgiaBean cirurgia) throws CirurgiaDAOException, SQLException{
        
        try{
            String sql = "INSERT INTO cirurgia (nome_cirurgia, fk_codigo_paciente, fk_codigo_medico, descricao, data) VALUES (?,?,?,?,?)";
            this.con = getConexao();
            this.stmt = con.prepareStatement(sql);
            this.stmt.setString(1, cirurgia.getCirurgia());
            this.stmt.setString(2, cirurgia.getCpf());
            this.stmt.setString(3, cirurgia.getCrm());
            this.stmt.setString(4, cirurgia.getDescricao());
            this.stmt.setString(5, cirurgia.getData());
            
            this.stmt.executeUpdate();
        }catch(SQLException e){
            throw new CirurgiaDAOException(e);
        }finally{
           if(stmt != null) stmt.close();
           if(con != null) con.close();
        }
        
    }
    public void excluir(CirurgiaBean cirurgia)  throws CirurgiaDAOException, SQLException {
        if (cirurgia == null) 
            throw new CirurgiaDAOException ("O valor passado não pode ser nulo"); 
        try {
            String sql = "delete from cirurgia where codigo_cirurgia = ?";
            this.con = getConexao();
            this.stmt = this.con.prepareStatement(sql); 
            this.stmt.setInt(1, cirurgia.getCodigo()); 
            this.stmt.executeUpdate(); 
        }catch (SQLException e) { 
            throw new CirurgiaDAOException(e);
            
        }finally { 
            if(stmt != null) stmt.close();
            if(con != null) con.close();
        }
    }
    
    public void atualizar(CirurgiaBean cirurgia)  throws CirurgiaDAOException, SQLException{ 
        try{ 
            String sql = "UPDATE  cirurgia SET nome_cirurgia = ?, fk_codigo_paciente = ?, " +  
                    "fk_codigo_medico = ?, descricao = ?, data = ? where codigo_cirurgia = ?"; 
            this.con = getConexao();
            this.stmt = con.prepareStatement(sql); 
            this.stmt.setString(1, cirurgia.getCirurgia());
            this.stmt.setString(2, cirurgia.getCpf());
            this.stmt.setString(3, cirurgia.getCrm());
            this.stmt.setString(4, cirurgia.getDescricao());
            this.stmt.setString(5, cirurgia.getData());
            this.stmt.setInt(6, cirurgia.getCodigo());
            this.stmt.executeUpdate(); 
        }catch (SQLException e){ 
            throw new CirurgiaDAOException(e);
        }finally{
            if(stmt != null) stmt.close();
            if(con != null) con.close();
        } 
    }

    
    public List retornaCirurgias() throws SQLException{
        List <CirurgiaBean> cirurgias = new ArrayList <CirurgiaBean> ();
        
        try{
            this.con = getConexao();
            this.stmt = this.con.prepareStatement("select * from cirurgia");
            this.rs = this.stmt.executeQuery();
            
            while(rs.next()){
                int codigo = rs.getInt(1);
                String cirurgia = rs.getString(2);
                String cpf = rs.getString(3);
                String crm = rs.getString(4);
                String descricao = rs.getString(5);
                String data = rs.getString(6);
                
                cirurgias.add(new CirurgiaBean(codigo, cirurgia, cpf, crm, descricao, data));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
           if (this.rs != null) rs.close();
           if(this.stmt != null) stmt.close();
           if(this.con != null) con.close();
        }
        return cirurgias;
    }
    
    //para medico
    public CirurgiaBean medicoCirurgias(int codigo) throws CirurgiaDAOException, SQLException{ 
        try{ 
            this.con = getConexao();
            this.stmt = this.con.prepareStatement("select * from cirurgia where codigo_cirurgia = ?");
            //this.stmt = this.con.prepareStatement("select m.crm from cirurgias as c inner join medicos as m"+
              //                              "on m.codigo_medico = c.fk_codigo_medico and c.codigo_cirurgia = ?");
            this.stmt.setInt(1, codigo); 
            this.rs = this.stmt.executeQuery( ); 
            if(! rs.next() ) 
                throw new CirurgiaDAOException( "Não  foi encontrado nenhum registro com:  " + codigo); 

            String nome = rs.getString(2); 
            String cpf = rs.getString(3); 
            String crm = rs.getString(4); 
            String descricao = rs.getString(5);
            String data = rs.getString(6);
            
            return new CirurgiaBean(codigo, nome, cpf, crm, descricao, data);
            
        }catch(SQLException e){
            throw new CirurgiaDAOException(e);
            
        }finally{
           if (this.rs != null) rs.close();
           if(this.stmt != null) stmt.close();
           if(this.con != null) con.close();
        } 
        
    }
    
       
    //para paciente
    public CirurgiaBean pacienteCirurgias(String cpf) throws CirurgiaDAOException, SQLException{
        
        try{
            this.con = getConexao();
            //this.stmt = this.con.prepareStatement("select * from cirurgia where fk_codigo_paciente = ?");
            this.stmt = this.con.prepareStatement("select p.cpf from cirurgia as c inner join pacientes as pc"+
                                                "on c.fk_codigo_paciente = pc.codigo_paciente " +
                                                "inner join pessoas as p on pc.codigo_pessoa = p.codigo_pessoa");
            this.stmt.setString(3, cpf);
            this.rs = this.stmt.executeQuery();
            
            if(! rs.next() ) 
                throw new CirurgiaDAOException("Não  foi encontrado nenhum registro com:  " + cpf); 

            int codigo = rs.getInt(1);
            String nome = rs.getString(2); 
            
            String crm = rs.getString(4); 
            String descricao = rs.getString(5);
            String data = rs.getString(6);
            
            return new CirurgiaBean(codigo, nome, cpf, crm, descricao, data);
            
            
        }catch(SQLException e){
            throw new CirurgiaDAOException(e);
        }finally{
            if(this.rs != null) rs.close();
            if(this.stmt != null) stmt.close();
            if (this.con != null) con.close();
        }
        
        
    }
    
    public String ultimoRegistro() throws CirurgiaDAOException, SQLException{
        
        try{
            this.con = getConexao();
            this.stmt = this.con.prepareStatement("select max (codigo_cirurgia) from cirurgia");
            this.rs = this.stmt.executeQuery();
            
            if(! rs.next() ) 
                throw new CirurgiaDAOException("Não  foi encontrado nenhum registro"); 

            int ultimo = rs.getInt(1);
            ultimo = ultimo + 1;
            String codigo = String.valueOf(ultimo);
            
            return codigo;
            
        }catch(SQLException e){
            throw new CirurgiaDAOException(e);
        }finally{
            if(this.rs != null) rs.close();
            if(this.stmt != null) stmt.close();
            if (this.con != null) con.close();
        }
        
        
    }
}
