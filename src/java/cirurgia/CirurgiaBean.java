/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cirurgia;

import java.sql.Date;

/**
 *
 * @author Administrador
 */
public class CirurgiaBean {
    private int codigo;
    private String cirurgia;
    private String crm;
    private String cpf;
    private String descricao;
    private String data;
    
    public CirurgiaBean(int codigo, String cirurgia, String cpf, String crm, String descricao, String data) {
        this.codigo = codigo;
        this.cirurgia = cirurgia;
        this.cpf = cpf;
        this.crm = crm;
        this.descricao = descricao;
        this.data = data;
    }

    public CirurgiaBean() {
        
    }
    
       
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public void setCirurgia(String cirurgia){
        this.cirurgia = cirurgia;
    }
    
    public void setCrm(String crm){
        this.crm = crm;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setData(String data){
        this.data = data;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getCirurgia(){
        return cirurgia;
    }
    public String getCrm(){
        return crm;
    }
    public String getCpf(){
        return cpf;
    }
    
    public String getDescricao(){
        return descricao;
    }
    public String getData(){
        return data;
    }
    
}
