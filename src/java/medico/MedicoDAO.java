/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package medico;

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
public class MedicoDAO extends GenericDAO {
    
    public MedicoDAO(){
        super();
    }
    
    private void obterProximoCodigo(MedicoBean medico) throws SQLException{
        try{
            super.setSql("SELECT NEXTVAL('medicos_codigo_medico_seq') AS codigo");
            super.executarSelect();
            
            while(super.getResultSet().next()){
                medico.setCodigo(super.getResultSet().getInt(1));
            }
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha na recuperacao do proximo codigo"+e);
        }
    }

    public void cadastrar(MedicoBean medico) throws SQLException{
        
        if(medico == null)
            throw new GenericDAOException("O objeto passado não pode ser nulo.");
        
        this.obterProximoCodigo(medico);
        
        try{
            super.setSql("INSERT INTO medicos (Codigo_Medico, Codigo_Pessoa, Crm_Medico) "
                          +"VALUES (?, ?, ?)");

            super.setParametro(medico.getCodigo());
            super.setParametro(medico.getCodigoPessoa());
            super.setParametro(medico.getCrm());
            
            super.executarInsert();
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha no cadastro"+e);
        }
    }
    
    public void alterarHospitalMedico(MedicoBean medico) throws SQLException{
        
        if(medico == null)
            throw new GenericDAOException("O objeto passado não pode ser nulo.");
        
        try{
            super.setSql("UPDATE MedicoXHospital SET Codigo_Hospital = ? WHERE Codigo_Medico = ?");

            super.setParametro(medico.getCodigoHospital());    
            super.setParametro(medico.getCodigo());
            
            super.executarInsert();
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha no cadastro"+e);
        }
    }
    public void cadastrarHospitalMedico(MedicoBean medico) throws SQLException{
        
        if(medico == null)
            throw new GenericDAOException("O objeto passado não pode ser nulo.");
        
        try{
            super.setSql("INSERT INTO MedicoXHospital (Codigo_Medico, Codigo_Hospital) "
                          +"VALUES (?, ?)");

            super.setParametro(medico.getCodigo());
            super.setParametro(medico.getCodigoHospital());
            
            super.executarInsert();
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha no cadastro"+e);
        }
    }
    public boolean existeHospitalMedico(MedicoBean medico) throws SQLException{
        Integer codigo = medico.getCodigo();
        Integer codigoHospital = medico.getCodigoHospital();
        if(codigo == null || codigo == 0 || codigoHospital == null || codigoHospital == 0)
            throw new GenericDAOException("O Código precisa ser válido.");
        
        try{
            super.setSql("SELECT Codigo_Medico FROM MedicoXHospital WHERE Codigo_Medico = ? AND Codigo_Hospital = ?");
            super.setParametro(codigo);
            super.setParametro(codigoHospital);
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
    
    public void alterar(MedicoBean medico) throws SQLException{
        
        if(medico == null)
            throw new GenericDAOException("O objeto passado não pode ser nulo.");
        
        try{
            
            super.setSql("UPDATE medicos SET Crm_Medico = ? WHERE Codigo_Medico = ?");
            
            super.setParametro(medico.getCodigo());
            super.setParametro(medico.getCrm());
            
            super.executarUpdate();
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha na alteração"+e);
        }
    }
    
    public void excluir(MedicoBean medico) throws SQLException{
        
        if(medico == null)
            throw new GenericDAOException("O objeto passado não pode ser nulo.");
        
        try{
            super.setSql("DELETE FROM medicos WHERE Codigo_Medico = ?");

            super.setParametro(medico.getCodigo());
            
            super.executarDelete();
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha na exclusão"+e);
        }
    }
    
    public boolean existePeloCodigo(MedicoBean medico) throws SQLException{
        Integer codigo = medico.getCodigo();
        if(codigo == null || codigo == 0)
            throw new GenericDAOException("O Código precisa ser válido.");
        
        try{
            super.setSql("SELECT Codigo_Medico FROM medicos WHERE Codigo_Medico = ?");
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
    
    public boolean existePeloCodigoPessoa(PessoaBean pessoa) throws SQLException{
        Integer codigo = pessoa.getCodigo();
        if(codigo == null || codigo == 0)
            throw new GenericDAOException("O Código precisa ser válido.");
        
        try{
            super.setSql("SELECT Codigo_Medico FROM medicos WHERE Codigo_Pessoa = ?");
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
        
        List medicos = new ArrayList();
            
        try{    
        super.setSql("SELECT m.Codigo_Medico, m.Crm_Medico, p.Codigo_Pessoa, p.Nome_Pessoa, p.Cpf_Pessoa, p.Email_Pessoa, p.Id_Pessoa, "
                    + "p.Data_Nascimento_Pessoa, p.Senha_Pessoa FROM pessoas p, medicos m WHERE p.Codigo_Pessoa = m.Codigo_Pessoa");
            super.executarSelect();
            
            ResultSet rs = super.getResultSet();
            while(rs.next()){
                MedicoBean medico = new MedicoBean();
                medico.setCodigo(rs.getInt(1));
                medico.setCrm(rs.getString(2));
                medico.setCodigoPessoa(rs.getInt(3));
                medico.setNome(rs.getString(4));
                medico.setCpf(rs.getString(5));
                medico.setEmail(rs.getString(6));
                medico.setId(rs.getString(7));
                medico.setDataNascimento(rs.getDate(8));
                medico.setSenha(rs.getString(9));
                medicos.add(medico);
            }
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha ao tentar recupear uma lista de Pessoas "+e);
        }
        return medicos;
    }
    
    public MedicoBean retornarPeloCodigo(MedicoBean medico) throws SQLException{
        Integer codigo = medico.getCodigo();
        if(codigo == null || codigo == 0)
            throw new GenericDAOException("O Código precisa ser válido.");
        
        try{    
            super.setSql("SELECT m.Codigo_Medico, m.Crm_Medico, p.Codigo_Pessoa, p.Nome_Pessoa, p.Cpf_Pessoa, p.Email_Pessoa, p.Id_Pessoa, "
                    + "p.Data_Nascimento_Pessoa, p.Senha_Pessoa FROM pessoas p, medicos m WHERE p.Codigo_Pessoa = m.Codigo_Pessoa AND Codigo_Medico = ?");
            super.setParametro(codigo);
            super.executarSelect();
            
            ResultSet rs = super.getResultSet();
            while(rs.next()){
                medico = new MedicoBean();
                medico.setCodigo(rs.getInt(1));
                medico.setCrm(rs.getString(2));
                medico.setCodigoPessoa(rs.getInt(3));
                medico.setNome(rs.getString(4));
                medico.setCpf(rs.getString(5));
                medico.setEmail(rs.getString(6));
                medico.setId(rs.getString(7));
                medico.setDataNascimento(rs.getDate(8));
                medico.setSenha(rs.getString(9));
            }
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha ao tentar recuperar "+e);
        }
        return medico;
    }
    
    public MedicoBean procurarPeloEmail(MedicoBean medico) throws SQLException{
        String email = medico.getEmail();
        if(email.equals(""))
            throw new GenericDAOException("O valor precisa ser preenchido.");        
        
        try{    
            super.setSql("SELECT m.Codigo_Medico, m.Crm_Medico, p.Codigo_Pessoa, p.Nome_Pessoa, p.Cpf_Pessoa, p.Email_Pessoa, p.Id_Pessoa, "
                    + "p.Data_Nascimento_Pessoa, p.Senha_Pessoa FROM pessoas p, medicos m WHERE p.Codigo_Pessoa = m.Codigo_Pessoa AND Email_Pessoa = ?");
            super.setParametro(email);
            super.executarSelect();
            
            ResultSet rs = super.getResultSet();
            while(rs.next()){
                medico = new MedicoBean();
                medico.setCodigo(rs.getInt(1));
                medico.setCrm(rs.getString(2));
                medico.setCodigoPessoa(rs.getInt(3));
                medico.setNome(rs.getString(4));
                medico.setCpf(rs.getString(5));
                medico.setEmail(rs.getString(6));
                medico.setId(rs.getString(7));
                medico.setDataNascimento(rs.getDate(8));
                medico.setSenha(rs.getString(9));
            }
            
        }catch(GenericDAOException e){
            throw new GenericDAOException("Houve uma falha ao tentar recuperar "+e);
        }
        return medico;
    }
    
}
