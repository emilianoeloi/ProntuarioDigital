/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoa;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author emilianoeloi
 */
public class PessoaBean implements Serializable {
    
    private int codigo;
    private String nome;
    private String cpf;
    private String email;
    private String id;
    private Date dataNascimento;
    private String senha;
    
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
