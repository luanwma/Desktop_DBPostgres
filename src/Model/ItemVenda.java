/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Luan
 */
public class ItemVenda implements java.io.Serializable{
    private static long serialVersionUID = 1L;
    private Produto itemProduto ;
    private int quantidade, id;
    private double valorItem;

    //para pegar dados do bd
    public ItemVenda(int id, Produto itemProduto, int quantidade, double valorItem) {
        this.id = id;
        this.itemProduto = itemProduto;
        this.quantidade = quantidade;
        this.valorItem = valorItem;
    }
    //para criaçao de um item
    public ItemVenda( Produto produto, int quantidade, double valorItem ){
        this.itemProduto = produto;
        this.quantidade = quantidade;
        this.valorItem = valorItem;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public Produto getItemProduto() {
        return itemProduto;
    }

    public void setItemProduto(Produto itemProduto) {
        this.itemProduto = itemProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorItem() {
        return valorItem;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

    

    

    
    
    
    
}
