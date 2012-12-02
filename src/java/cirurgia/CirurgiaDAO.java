/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cirurgia;

import java.sql.Date;
import factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pessoa.PessoaBean;

/**
 *
 * @author Administrador
 */
public class CirurgiaDAO {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public Connection getConexao() throws SQLException{
        
            Connection con;
            con = ConexaoFactory.getInstancia().getConexao();
            return con;
        
    }
    public void salvar (CirurgiaBean cirurgia) throws CirurgiaDAOException, SQLException{
        
        try{
            CirurgiaDAO aux = new CirurgiaDAO();
            String str = aux.ultimoRegistro();
            int codigo = (Integer.parseInt(str));
            
            
            String sql = "INSERT INTO cirurgias (nome_cirurgia, descricao, data) VALUES (?,?,?)";
            String medico = "INSERT INTO medicoxcirurgia (codigo_medico,codigo_cirurgia) VALUES (?,?)";
            String paciente = "INSERT INTO pacientexcirurgia (codigo_paciente, codigo_cirurgia) VALUES (?,?)";
            
            this.con = getConexao();
            this.stmt = con.prepareStatement(sql);
            this.stmt.setString(1, cirurgia.getCirurgia());
            this.stmt.setString(2, cirurgia.getDescricao());
            this.stmt.setDate(3, cirurgia.getData());
            this.stmt.executeUpdate();
            
            this.stmt = con.prepareStatement(medico);
            this.stmt.setInt(1, cirurgia.getCrm());
            this.stmt.setInt(2, codigo);
            this.stmt.executeUpdate();
            
            this.stmt = con.prepareStatement(paciente);
            this.stmt.setInt(1, cirurgia.getCpf());
            this.stmt.setInt(2, codigo);
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
            String sql = "delete from cirurgias where codigo_cirurgia = ?";
            
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
            String sql = "UPDATE  cirurgias SET nome_cirurgia = ?, " +  
                  "descricao = ?, data = ? where codigo_cirurgia = ?"; 
            String paciente = "UPDATE pacientexcirurgia set codigo_paciente = ? where codigo_cirurgia = ?";
            String medico = "UPDATE medicoxcirurgia set codigo_medico = ? where codigo_cirurgia = ?";
            
            this.con = getConexao();
            this.stmt = con.prepareStatement(sql); 
            this.stmt.setString(1, cirurgia.getCirurgia());
            this.stmt.setString(2, cirurgia.getDescricao());
            this.stmt.setDate(3, cirurgia.getData());
            this.stmt.setInt(4, cirurgia.getCodigo());
            this.stmt.executeUpdate();
            
            this.stmt = con.prepareStatement(paciente);
            this.stmt.setInt(1, cirurgia.getCpf());
            this.stmt.setInt(2, cirurgia.getCodigo());
            this.stmt.executeUpdate();
            
            this.stmt = con.prepareStatement(medico);
            this.stmt.setInt(1, cirurgia.getCrm());
            this.stmt.setInt(2, cirurgia.getCodigo());
            this.stmt.executeUpdate();
            
            
        }catch (SQLException e){ 
            throw new CirurgiaDAOException(e);
            
        }finally{
            if(stmt != null) stmt.close();
            if(con != null) con.close();
        } 
    }

    
    public List retornaCirurgias() throws SQLException, CirurgiaDAOException{
        List <CirurgiaBean> cirurgias = new ArrayList <CirurgiaBean> ();
        
        try{
            String sql = "select * from cirurgias as ci inner join pacientexcirurgia as pc on ci.codigo_cirurgia = pc.codigo_cirurgia "
                    + "inner join medicoxcirurgia as mc on ci.codigo_cirurgia = mc.codigo_cirurgia inner join medicos as me on "+
                    "mc.codigo_medico = me.codigo_medico inner join pessoas as pe on me.codigo_pessoa = pe.codigo_pessoa inner join "+
                    "pacientes as pa on pc.codigo_paciente = pa.codigo_paciente inner join pessoas as p on pa.codigo_pessoa = p.codigo_pessoa "+
                    "order by ci.codigo_cirurgia asc";
            this.con = getConexao();
            this.stmt = this.con.prepareStatement(sql);
            this.rs = this.stmt.executeQuery();
            
            while(rs.next()){
                int codigo = rs.getInt(1);
                String cirurgia = rs.getString(2);
                String paciente = rs.getString(23);
                  
                cirurgias.add(new CirurgiaBean(codigo,cirurgia,paciente));
            }
            
        }catch(SQLException e){
            throw new CirurgiaDAOException(e);
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
            this.stmt = this.con.prepareStatement("select * from cirurgias where codigo_cirurgia = ?");
            this.stmt.setInt(1, codigo); 
            this.rs = this.stmt.executeQuery( ); 
            if(! rs.next() ) 
                throw new CirurgiaDAOException( "Não  foi encontrado nenhum registro com:  " + codigo); 

            String nome = rs.getString(2); 
            String descricao = rs.getString(3);
            Date data = rs.getDate(4);
            
            return new CirurgiaBean(codigo, nome, 0, 0, descricao, data);
            
        }catch(SQLException e){
            throw new CirurgiaDAOException(e);
            
        }finally{
           if (this.rs != null) rs.close();
           if(this.stmt != null) stmt.close();
           if(this.con != null) con.close();
        } 
        
    }
    
       
    //para paciente
      public List pacienteCirurgias() throws CirurgiaDAOException, SQLException{
        
        List <CirurgiaBean> cirurgias = new ArrayList <CirurgiaBean> ();
        
        try{
            this.con = getConexao();
            this.stmt = this.con.prepareStatement("select codigo_paciente, nome_pessoa from pessoas as pe inner join pacientes as pa on pa.codigo_pessoa = pe.codigo_pessoa");
            
            this.rs = this.stmt.executeQuery();
            
            while(rs.next() ){ 
                
            int codigo = rs.getInt(1);
            
            String nome = rs.getString(2);
            cirurgias.add(new CirurgiaBean(codigo,nome));
            
            }
            return cirurgias;
                               
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
            this.stmt = this.con.prepareStatement("select last_value from cirurgias_codigo_cirurgia_seq");
            this.rs = this.stmt.executeQuery();
            
            if(! rs.next() ) 
                throw new CirurgiaDAOException("Não  foi encontrado nenhum registro"); 

            int ultimo = rs.getInt(1);
            if(ultimo > 1)
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
    
    public List medicos() throws SQLException, CirurgiaDAOException{
        List pessoas = new ArrayList ();
        
        try{
            this.con = getConexao();
            this.stmt = this.con.prepareStatement("select codigo_medico, nome_pessoa from pessoas as pe inner join medicos as pa on pa.codigo_pessoa = pe.codigo_pessoa");
            this.rs = this.stmt.executeQuery();
            
            while(rs.next()){
                PessoaBean pessoa = new PessoaBean();
        
                pessoa.setCodigo(rs.getInt(1));
                pessoa.setNome(rs.getString(2));
                pessoas.add(pessoa);                
            }
            
        }catch(SQLException e){
            throw new CirurgiaDAOException(e);
        }finally{
           if (this.rs != null) rs.close();
           if(this.stmt != null) stmt.close();
           if(this.con != null) con.close();
        }
        return pessoas;
            
            
    } 
    public List pacientes() throws SQLException, CirurgiaDAOException{
        List pessoas = new ArrayList();
        
        try{
            this.con = getConexao();
            this.stmt = this.con.prepareStatement("select codigo_paciente, nome_pessoa from pessoas as pe inner join pacientes as pa on pa.codigo_pessoa = pe.codigo_pessoa");
            this.rs = this.stmt.executeQuery();
            
            while(rs.next()){
                PessoaBean pessoa = new PessoaBean();
        
                pessoa.setCodigo(rs.getInt(1));
                pessoa.setNome(rs.getString(2));
                pessoas.add(pessoa);                
            }
        }catch(SQLException e){
            throw new CirurgiaDAOException(e);
        }finally{
           if (this.rs != null) rs.close();
           if(this.stmt != null) stmt.close();
           if(this.con != null) con.close();
        }
        return pessoas;
        
    }
    public List codigoMedico(int codigo) throws SQLException, CirurgiaDAOException{
        List pessoas = new ArrayList();
        
        try{
            this.con = getConexao();
            this.stmt = this.con.prepareStatement("select codigo_medico from medicoxcirurgia where codigo_cirurgia = ?");
            
            this.stmt.setInt(1, codigo);
            this.rs = this.stmt.executeQuery();
            
            if(rs.next()){
                                
                int medico = rs.getInt(1);
                pessoas.add(medico);
                
            }
                         
                      
        }catch(SQLException e){
            throw new CirurgiaDAOException(e);
        }finally{
           if (this.rs != null) rs.close();
           if(this.stmt != null) stmt.close();
           if(this.con != null) con.close();
        }
        return pessoas;
    }
    public List codigoPaciente(int codigo) throws SQLException, CirurgiaDAOException{
        List pessoas = new ArrayList();
        
        try{
            this.con = getConexao();
            this.stmt = this.con.prepareStatement("select codigo_paciente from pacientexcirurgia where codigo_cirurgia = ?");
            
            this.stmt.setInt(1, codigo);
            this.rs = this.stmt.executeQuery();
            
            if(rs.next()){
                                
                int medico = (rs.getInt("codigo_paciente"));
                pessoas.add(medico);
                
            }
                         
                      
        }catch(SQLException e){
            throw new CirurgiaDAOException(e);
        }finally{
           if (this.rs != null) rs.close();
           if(this.stmt != null) stmt.close();
           if(this.con != null) con.close();
        }
        return pessoas;
    }
    
    public List retornaTodasCirurgias() throws SQLException, CirurgiaDAOException{
        List <CirurgiaBean> cirurgias = new ArrayList <CirurgiaBean> ();
        
        try{
            String sql = "select * from cirurgias as ci inner join pacientexcirurgia as pc on ci.codigo_cirurgia = pc.codigo_cirurgia "
                    + "inner join medicoxcirurgia as mc on ci.codigo_cirurgia = mc.codigo_cirurgia inner join medicos as me on "+
                    "mc.codigo_medico = me.codigo_medico inner join pessoas as pe on me.codigo_pessoa = pe.codigo_pessoa inner join "+
                    "pacientes as pa on pc.codigo_paciente = pa.codigo_paciente inner join pessoas as p on pa.codigo_pessoa = p.codigo_pessoa "+
                    "order by ci.codigo_cirurgia asc";
            this.con = getConexao();
            this.stmt = this.con.prepareStatement(sql);
            this.rs = this.stmt.executeQuery();
            
            while(rs.next()){
                int codigo = rs.getInt(1);
                String cirurgia = rs.getString(2);
                String descricao = rs.getString(3);
                Date data = rs.getDate(4);
                String paciente = rs.getString(23);
                String medico = rs.getString(13);
                
                cirurgias.add(new CirurgiaBean(codigo,cirurgia, medico, paciente, data, descricao));
            }
            
        }catch(SQLException e){
            throw new CirurgiaDAOException(e);
        }finally{
           if (this.rs != null) rs.close();
           if(this.stmt != null) stmt.close();
           if(this.con != null) con.close();
        }
        return cirurgias;
    }
    
     
}
