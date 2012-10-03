/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.Serializable;

/**
 *
 * @author emilianoeloi
 */
public class HospitalBean implements Serializable {
    
    private Integer codigo=null;
    private String nome =null;
    
    public HospitalBean(){
        
    }
    public HospitalBean(Integer codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public void setCodigo(Integer codigo){
        this.codigo = codigo;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public Integer getCodigo(){
        return this.codigo;
    }
    public String getNome(){
        return this.nome;
    }
    
}
