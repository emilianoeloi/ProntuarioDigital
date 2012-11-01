/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package medico;

import pessoa.*;

/**
 *
 * @author emilianoeloi
 */
public class MedicoBean extends PessoaBean {

    public MedicoBean() {
        super();
    }
    
    private String Crm;

    public String getCrm() {
        return this.Crm;
    }

    public void setCrm(String Crm) {
        this.Crm = Crm;
    }
    
}
