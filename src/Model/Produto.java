/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Luan
 */
public class Produto implements java.io.Serializable{
    private static long serialVersionUID = 1L;
    private double preco;
    private int id= 0;
    private String nome, descricao;

    public Produto() {
        
    }

    public Produto(int id, String nome, double preco,  String descricao) {
        this.preco = preco;
        this.nome = nome;
        this.descricao = descricao;
        this.id = id;
        
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
       this.id = id;
    } 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    /*
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    */
    
}
