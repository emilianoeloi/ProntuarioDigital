/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import factory.ConexaoFactory;
import java.util.Date;
import dao.*;
import pessoa.*;

/**
 *
 * @author emilianoeloi
 */
public class PacienteDAO extends GenericDAO {
    
    public PacienteDAO(){
        super();
    }
    
    private void obterProximoCodigo(PacienteBean paciente) throws SQLException{
        try{
            super.setSql("SELECT NEXTVAL('pacientes_codigo_paciente_seq') AS codigo");
            super.executarSelect();
            
            while(super.getResultSet().next()){
                paciente.setCodigo(super.getResultSet().getInt(1));
            }
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha na recuperacao do proximo codigo"+e);
        }
    }

    public void cadastrar(PacienteBean paciente) throws SQLException{
        
        if(paciente == null)
            throw new GenericDAOException("O objeto passado não pode ser nulo.");
        
        this.obterProximoCodigo(paciente);
        
        try{
            super.setSql("INSERT INTO pacientes (Codigo_Paciente, Codigo_Pessoa) "
                          +"VALUES (?, ?)");

            super.setParametro(paciente.getCodigo());
            super.setParametro(paciente.getCodigoPessoa());
            
            super.executarInsert();
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha no cadastro"+e);
        }
    }
    
    public void alterar(PacienteBean paciente) throws SQLException{
        
        if(paciente == null)
            throw new GenericDAOException("O objeto passado não pode ser nulo.");
        
        try{
            
            super.setSql("UPDATE pacientes SET Crm_Medico = ? WHERE Codigo_Medico = ?");
            
            super.setParametro(paciente.getCodigo());
            
            super.executarUpdate();
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha na alteração"+e);
        }
    }
    
    public void excluir(PacienteBean paciente) throws SQLException{
        
        if(paciente == null)
            throw new GenericDAOException("O objeto passado não pode ser nulo.");
        
        try{
            super.setSql("DELETE FROM pacientes WHERE Codigo_Paciente = ?");

            super.setParametro(paciente.getCodigo());
            
            super.executarDelete();
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha na exclusão"+e);
        }
    }
    
    public boolean existePeloCodigo(PacienteBean paciente) throws SQLException{
        Integer codigo = paciente.getCodigo();
        if(codigo == null || codigo == 0)
            throw new GenericDAOException("O Código precisa ser válido.");
        
        try{
            super.setSql("SELECT Codigo_Paciente FROM pacientes WHERE Codigo_Paciente = ?");
            super.setParametro(codigo);
            super.executarSelect();
            
            while(super.getResultSet().next()){
                return true;
            }
            
        }catch(SQLException e){
            throw new SQLException("Houve uma falha na Recuperação "+e);
        }
        return false;
    }
    
    public List retornarTodos() throws SQLException{
        
        List pacientes = new ArrayList();
            
        try{    
        super.setSql("SELECT pa.Codigo_Paciente, p.Codigo_Pessoa, p.Nome_Pessoa, p.Cpf_Pessoa, p.Email_Pessoa, p.Id_Pessoa, "
                    + "p.Data_Nascimento_Pessoa, p.Senha_Pessoa FROM pessoas p, pacientes pa WHERE p.Codigo_Pessoa = pa.Codigo_Pessoa");
            super.executarSelect();
            
            ResultSet rs = super.getResultSet();
            while(rs.next()){
                PacienteBean paciente = new PacienteBean();
                paciente.setCodigo(rs.getInt(1));
                paciente.setCodigoPessoa(rs.getInt(2));
                paciente.setNome(rs.getString(3));
                paciente.setCpf(rs.getString(4));
                paciente.setEmail(rs.getString(5));
                paciente.setId(rs.getString(6));
                paciente.setDataNascimento(rs.getDate(7));
                paciente.setSenha(rs.getString(8));
                pacientes.add(paciente);
            }
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha ao tentar recupear uma lista de Pessoas "+e);
        }
        return pacientes;
    }
    
    public PacienteBean retornarPeloCodigo(PacienteBean paciente) throws SQLException{
        Integer codigo = paciente.getCodigo();
        if(codigo == null || codigo == 0)
            throw new GenericDAOException("O Código precisa ser válido.");
        
        try{    
            super.setSql("SELECT pa.Codigo_Paciente, p.Codigo_Pessoa, p.Nome_Pessoa, p.Cpf_Pessoa, p.Email_Pessoa, p.Id_Pessoa, "
                    + "p.Data_Nascimento_Pessoa, p.Senha_Pessoa FROM pessoas p, pacientes pa WHERE p.Codigo_Pessoa = pa.Codigo_Pessoa AND Codigo_Paciente = ?");
            super.setParametro(codigo);
            super.executarSelect();
            
            ResultSet rs = super.getResultSet();
            while(rs.next()){
                paciente = new PacienteBean();
                paciente.setCodigo(rs.getInt(1));
                paciente.setCodigoPessoa(rs.getInt(2));
                paciente.setNome(rs.getString(3));
                paciente.setCpf(rs.getString(4));
                paciente.setEmail(rs.getString(5));
                paciente.setId(rs.getString(6));
                paciente.setDataNascimento(rs.getDate(7));
                paciente.setSenha(rs.getString(8));
            }
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha ao tentar recuperar "+e);
        }
        return paciente;
    }
    
    public PacienteBean procurarPeloEmail(PacienteBean paciente) throws SQLException{
        String email = paciente.getEmail();
        if(email.equals(""))
            throw new GenericDAOException("O valor precisa ser preenchido.");        
        
        try{    
            super.setSql("SELECT pa.Codigo_Paciente, p.Codigo_Pessoa, p.Nome_Pessoa, p.Cpf_Pessoa, p.Email_Pessoa, p.Id_Pessoa, "
                    + "p.Data_Nascimento_Pessoa, p.Senha_Pessoa FROM pessoas p, pacientes pa WHERE p.Codigo_Pessoa = pa.Codigo_Pessoa AND Email_Pessoa = ?");
            super.setParametro(email);
            super.executarSelect();
            
            ResultSet rs = super.getResultSet();
            while(rs.next()){
                paciente = new PacienteBean();
                paciente.setCodigo(rs.getInt(1));
                paciente.setCodigoPessoa(rs.getInt(2));
                paciente.setNome(rs.getString(3));
                paciente.setCpf(rs.getString(4));
                paciente.setEmail(rs.getString(5));
                paciente.setId(rs.getString(6));
                paciente.setDataNascimento(rs.getDate(7));
                paciente.setSenha(rs.getString(8));
            }
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha ao tentar recuperar "+e);
        }
        return paciente;
    }
    
}
