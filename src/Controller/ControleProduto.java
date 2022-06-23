/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOProduto;
import Model.Produto;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.sql.*;
/**
 *
 * @author Luan
 */
public class ControleProduto extends DAOProduto implements InterfaceControle{
    
    
    Produto produto = null;

    public Produto getProduto() {
        return produto;
    }
    
    public ControleProduto(){
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
    
    public boolean criarProduto(boolean config, int id, String nome, double preco, String descricao) throws IOException{
        boolean status = false;
        if(config == false){
            id = novoId();
            produto = new Produto(id, nome, preco, descricao);
            status = true;
        }
        if(config == true){
            produto = new Produto(id, nome, preco, descricao);
            status = true;
        }
        return status;
        
    }
    public boolean gravarProduto(){
        boolean status = false;
        if( salvarProduto(produto)== true){
            status = true;
        }
        return status;
    }
    
    public ArrayList buscaProduto(String nomeBusca) throws IOException{
        ArrayList print = new ArrayList();
        ArrayList<Produto> aux = listarTodosProdutos();

        for(int i = 0 ; i < aux.size() ; i++){
            if(aux.get(i).getNome().contains(nomeBusca)){
                print.add(new Object[]{aux.get(i).getId(), 
                    aux.get(i).getNome(),
                    aux.get(i).getPreco(),
                    aux.get(i).getDescricao()
                });
            }


        }
       
        return print;  
    }
    
   
    
    
    public ArrayList listarProdutos(){
        ArrayList print = new ArrayList();
        ArrayList<Produto> aux = listarTodosProdutos();
        for(int i =  0 ; i <aux.size() ; i ++){
            print.add(new Object[]{aux.get(i).getId(), 
                    aux.get(i).getNome(),
                    aux.get(i).getPreco(),
                    aux.get(i).getDescricao()
                });
        }
        return print;
    }
    
    public String[] retornarDados(int idproduto){
        Produto p = buscaProdBD(idproduto);
        String []dados = new String[3];
        dados[0] = p.getNome();
        dados[1] = String.valueOf(p.getPreco());
        dados[2] = p.getDescricao();
        return dados;
        
    }
    
    
    

    @Override
    public JTable dadostabela(JTable table, ArrayList listProds, String[] colunas) {
        ModeloTabela modelo = new ModeloTabela(listProds, colunas);
            
            table.setModel(modelo);
            for(int i = 0 ; i <colunas.length;i++){
                table.getColumnModel().getColumn(i).setPreferredWidth(20);
                table.getColumnModel().getColumn(i).setResizable(true);
            }
            
            
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            return table;
    }
    public int selecionarId(JTable tabProds){
        int linha = tabProds.getSelectedRow();
        int id = -1;
        
        try{
            if(  tabProds.getValueAt(linha,0 ) != null){
                id = (Integer) tabProds.getValueAt(linha,0 );
            }
        }catch(ArrayIndexOutOfBoundsException erro){
            System.out.println("Erro : "+erro);
        }
            
        
        
        //int ide = Integer.parseInt(id);
        return id;
    }
    
   
   

   

}
