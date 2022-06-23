
        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Luan
 */
public class Venda implements java.io.Serializable{
    private static long serialVersionUID = 1L;
    private int idVenda=0;
    ArrayList<ItemVenda> itens;
    
   
    
    private int idcliente;
     
    private double  valortotal;

    public Venda(int idVenda , int idcliente, ArrayList<ItemVenda> itens, double valortotal ) {
        this.idVenda = idVenda;
        this.idcliente = idcliente;
        this.itens = itens;
        this.valortotal = valortotal;
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }

    
    
    
    
    
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

  
    

    
    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    
    
    
    
   
  

  
    
    
    
}
