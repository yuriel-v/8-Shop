package br.com.daopack;

import java.sql.*;

public final class Connecting {
    Connection conexao;
    
    
    //Método para estabelecer a conexão
    public static Connection connect(){
        
        Connection conexao = null;
        //A linha abaixo chama o driver
        String driver = "com.mysql.jdbc.Driver";
        //Armazenamento de informações referentes ao banco de dados
        String url = "jdbc:mysql://localhost:3306/newsystem";
        String user = "root";
        String password = "";
        //Estabelecendo a conexão com o banco de dados
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.out.println(e);
        }
        
     return null;   
    }
    
}
