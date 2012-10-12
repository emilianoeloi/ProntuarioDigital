/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exame;

/**
 *
 * @author Vilmar
 */
public class ExameBean {

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ExameBean(int codigo, String nome, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public ExameBean(){
        
    };
    
    private int codigo;
    private String nome;
    private String descricao;
    
    
}
