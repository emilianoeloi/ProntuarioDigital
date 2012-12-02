/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ferramenta;

/**
 *
 * @author emilianoeloi
 */
/**
 * 
 * @author emilianoeloi
 */
public class ControleAcao {
    public static int getCodigoByAcao(String acao){
        int acaoRetorno = -1;
        if(acao.equals("cadastrar")){
            acaoRetorno = 0;
        }else if(acao.equals("editar")){
            acaoRetorno = 1;
        }else if(acao.equals("excluir")){
            acaoRetorno = 2;
        }else if(acao.equals("obterum")){
            acaoRetorno = 3;
        }else if(acao.equals("listar")){
            acaoRetorno = 4;
        }else if(acao.equals("form-cadastro")){
            acaoRetorno = 5;
        }else if(acao.equals("form-edicao")){
            acaoRetorno = 6;
        }
        return acaoRetorno;
    }
}
