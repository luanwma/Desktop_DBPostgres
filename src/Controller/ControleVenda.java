/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import DAO.DAOVenda;
import Model.Cliente;
import Model.ItemVenda;
import Model.Produto;
import Model.Venda;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Luan
 */
public class ControleVenda extends DAOVenda implements InterfaceControle{
    ArrayList<ItemVenda> itensVenda = null;
    
    Venda venda = null;
    Cliente cliente;
    ItemVenda item = null;
    Produto produto;
    ControleProduto controleproduto = new ControleProduto();
    ControleCliente controlecliente = new ControleCliente();
    ArrayList dados = null;
   // ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
  
    
    double precototal=0;
    int linha;
    
    public ControleVenda(){
       try {
            criaConexao();
            itensVenda = new ArrayList<>();
        } catch (IOException erro) {
            System.out.println("Erro: "+erro);
        } catch (ClassNotFoundException erro) {
           System.out.println("Erro: "+erro);
        } catch (SQLException erro) {
            System.out.println("Erro: "+erro);
        }
    }
    
    public ArrayList<ItemVenda> getItensVendaBD(Venda venda){
        ArrayList<ItemVenda> lista = new ArrayList<>();
        lista = venda.getItens();
        return lista;
    }
    
    public void itemVenda(Produto produto,  int quantidade, double valor){
       int id_itemVenda = novoIDItem();
       ItemVenda item = new ItemVenda(id_itemVenda, produto,  quantidade, valor);
       itensVenda.add(item);
       
    }
    public boolean gravarItens(ArrayList<ItemVenda> listaitens){
        boolean status = false;
        
        for(ItemVenda aux : listaitens){
            if(gravarItem(aux) == true){
                status = true;
            }
        }
        return status;
    }
    
    public boolean alterarItens(ArrayList<ItemVenda> listaitens){
        boolean status = false;
        
        for(ItemVenda aux : listaitens){
            if(alterarItem(aux) == true){
                status = true;
            }
        }
        return status;
    }
    
    
    public boolean novaVenda(boolean config, int idvenda, int idClient, ArrayList<ItemVenda> itensVenda){
        double valor = 0;
        int id = 0;
        if(config == false){
           id = novoIDVenda(); 
            for(int i = 0 ; i< itensVenda.size() ; i++){
                valor = itensVenda.get(i).getValorItem() + valor;
            }
            venda = new Venda(id, idClient, itensVenda, valor);
        }
        if(config == true){
            for(int i = 0 ; i< itensVenda.size() ; i++){
                valor = itensVenda.get(i).getValorItem() + valor;
            }
            venda = new Venda(idvenda, idClient, itensVenda, valor);
        }
        
        
        
        
        
      
        return true;
        
    }
    
    public Venda getVenda(){
        return venda;
    }
    
    
    
    @Override
     public JTable dadostabela(JTable table, ArrayList lista, String [] colunas){
               
         
            ModeloTabela modelo = new ModeloTabela(lista, colunas);
            
            table.setModel(modelo);
            for(int i = 0 ; i <colunas.length;i++){
                table.getColumnModel().getColumn(i).setPreferredWidth(20);
                table.getColumnModel().getColumn(i).setResizable(true);
            }
            
            
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            return table;
     }
     
     
     
    public int selecionarId(JTable tab){
        int linha = tab.getSelectedRow();
        int id = -1;
        try{
            if(  tab.getValueAt(linha,0 ) != null){
                id = (Integer) tab.getValueAt(linha,0 );
            }
        }catch(ArrayIndexOutOfBoundsException erro){
            System.out.println("Erro : "+erro);
        }catch(IndexOutOfBoundsException erro){
            System.out.println("Erro : "+erro);
        }
        return id;
    }
    
    public void setLinha(int linha){
        this.linha = linha;
    }
    public int selecionarID(JTable tab, int campo){
        int linha = tab.getSelectedRow();
        int id = -1;
        try{
            if(tab.getValueAt(linha, campo) != null){
                id = (int) tab.getValueAt(linha, campo);
            }
        }catch(ArrayIndexOutOfBoundsException erro){
            System.out.println("Erro : "+erro);
        }
        
       // int ide = Integer.parseInt(id);
        return id;
    }
   
    
    
    public void inserirItem(JTable tab, int qtd) throws IOException{
      
        int linha = tab.getSelectedRow();
        int id = (Integer) tab.getValueAt(linha, 0);
        System.out.println("teste id "+id);
        produto = controleproduto.buscaProdBD(id);
        precototal = produto.getPreco() * qtd;
        item = new ItemVenda(produto, qtd, precototal);
        itensVenda.add(item);
        convItemObject();
        
        
       
    }
    public int quantidadeVendavsCliente(int idcliente){
        int qtd= -1;
        qtd = contarVendas(idcliente);
        return qtd;
    }
    
    
    
    public ArrayList convItemObject( ){
        dados = new ArrayList();
        for(ItemVenda v : getItensVenda()){
          
            //System.out.println("dentro conv item obj 2 ---> "+v.getQuantidade());
            dados.add(new Object[]{v.getId(),
                v.getItemProduto().getNome(),v.getItemProduto().getDescricao(),
                v.getItemProduto().getPreco(),v.getQuantidade(),
                v.getValorItem()
                
            });
        }
        return dados;
    }
    
    public ArrayList getDadosTabelas(){
        return dados;
    }
    
    public ArrayList<ItemVenda> getItensVenda(){
        return itensVenda;
    }
      
    public double valorTotal(JTable tab){
        double value =0 ;
        for(int i =0 ; i <tab.getRowCount() ; i++){
            value = (double)tab.getValueAt(i, 5) + value;
        }
        return value;
    }
   
    public boolean removerItemCarrinho( int idprod){
        boolean status = false;
        int x = 0;
        Iterator iterator = itensVenda.iterator();
        while(iterator.hasNext()){
            ItemVenda aux = (ItemVenda) iterator.next();
            if(aux.getId()== idprod){
                iterator.remove();
                status = true;
            }
        }
       
        return status;
       
    }
    public boolean removerPosCarrinho(int pos){
        
        boolean status = false;
        int cont = -1 ;
       
        Iterator iterator = itensVenda.iterator();
        while(iterator.hasNext()){
            cont++;
            ItemVenda aux = (ItemVenda) iterator.next();
            if(cont== pos){
                iterator.remove();
                status = true;
            }
        }
        
        return status;
    }
    
    public  JTable atualizaTabela(JTable tab, String [] colunas){
        
       // String [] colunas = new String[]{"ID ","NOME DO PRODUTO","DESCRIÇÃO","PREÇO", "QUANTIDADE","PREÇO TOTAL"};
        //Carrinho.tabCarrinho = controlVenda.dadostabela(Carrinho.tabCarrinho, controlVenda.getProdPreco(),colunas );
        tab = dadostabela(tab, convItemObject(),colunas );
        //idClient = controlVenda.selecionarId(selCli.tabClientes);
        return tab;
    }
 
    public void atualizarDados(int idvenda){
        Venda v = listaVendaBD(idvenda);
      //  this.itensVenda = new ArrayList<>();
        this.itensVenda = v.getItens();
        
        
    }

   
    
    
    
    
}
