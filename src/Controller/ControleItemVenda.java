/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Luan
 */
public class ControleItemVenda extends ControleVenda implements InterfaceControle{
    
    public ControleItemVenda(){
        try {
            criaConexao();
        } catch (IOException erro) {
            System.out.println("Erro: "+erro);
        } catch (ClassNotFoundException erro) {
           System.out.println("Erro: "+erro);
        } catch (SQLException erro) {
            System.out.println("Erro: "+erro);
        }
    }
    
    
    
}
