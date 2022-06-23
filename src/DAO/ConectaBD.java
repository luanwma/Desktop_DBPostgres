/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luan
 */
public abstract class  ConectaBD {
    protected Connection conexao  = null;
   
    protected ResultSet rsdados = null;
    protected PreparedStatement preparedStatement = null;
    
    private static final String path = System.getProperty("user.dir");
    private static final File config_file = new File(path + "/src/configuracaobd.properties");
    private static String url;
    private static String username;
    private static String password;


    
    public boolean criaConexao() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
       Class.forName("org.postgresql.Driver");
        
      //  Properties props = new Properties();
      //  FileInputStream in = new FileInputStream(config_file);
      //  props.load(in);
        //String driver = props.getProperty("jdbc.driver");
       // Class.forName(driver);
       // url = props.getProperty("jdbc.url");
      //  username = props.getProperty("jdbc.username");
        
       // password = props.getProperty("jdbc.password");
        //password = "utfpr";
        url = "jdbc:postgresql://localhost:5432/Desktop_T3";
        username = "postgres";
        password = "luan";
        
        
        conexao = getConnection();
        conexao.setAutoCommit(false);
       // DatabaseMetaData dbmt = conexao.getMetaData();
        return true;
            
            
       
    }
    
    public Connection getConnection() throws SQLException{
        conexao = DriverManager.getConnection(url,username, password);
        return conexao;
    }
    public boolean fechaConexao() throws SQLException{
        boolean status = false;
        if(conexao != null){
            conexao.close();
            status = true;
        }
        
        return status;
    }
}
