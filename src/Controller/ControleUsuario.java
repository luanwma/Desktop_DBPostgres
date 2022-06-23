/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import DAO.DAOUsuario;
import Model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Luan
 */
public class ControleUsuario extends DAOUsuario{
        
    ArrayList listUser = new ArrayList<>();
    protected Usuario user;
    
    public ControleUsuario(){
        try {
            criaConexao();
        } catch (IOException ex) {
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }
    
    public boolean criarUsuario(String nome, String senha) {
        boolean status = false;
        user = new Usuario(nome, senha);
        if(gravarUsuario(user)==true){
            status = true;
        }
        return status;
    }
    
   
    
    public boolean verificarUsuario(String nome, String senha){
        boolean status = false;
        if( confirmarUsuario(nome, senha) == true ){
            status = true;
        }
        
        return status;
      
    }
    
    public boolean excluirUsuario(String nome, String senha){
        boolean status = false;
        if(deleteUsuario(nome, senha) == true){
            status = true;
        }
        return status;
        
    }
    
    
    

}
