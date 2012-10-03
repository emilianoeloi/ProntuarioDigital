/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author emilianoeloi
 */
public class ConexaoFactory {
    String driverClassName="org.postgresql.Driver";
    String urlConexao="jdbc:postgresql://127.0.0.1:5432/ADS_DB";
    String usuarioDb="pduser";
    String senhaDb="ads111";
    
    private static ConexaoFactory conexaoFactory=null;
    
    private ConexaoFactory(){
        try{
            Class.forName(driverClassName);
            
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public Connection getConexao() throws SQLException{
        Connection con = null;
        con = DriverManager.getConnection(urlConexao, usuarioDb, senhaDb);
        return con;
    }
    
    public static ConexaoFactory getInstancia(){
        if(conexaoFactory==null){
            conexaoFactory = new ConexaoFactory();
        }
        return conexaoFactory;
    }
}
