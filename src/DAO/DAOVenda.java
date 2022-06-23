/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Controller.ControleProduto;
import Model.ItemVenda;
import Model.Produto;
import Model.Venda;
import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Luan
 */
public class DAOVenda extends ConectaBD{
    public ArrayList<Venda> listvendas = null;
    public ArrayList<ItemVenda> listItens = null;
    ControleProduto contprod = null;
    private int cont;
    
    public void setCont(int cont){
        this.cont = cont;
    }
    public int getCont(){
        return cont;
    }
    
    public int novoIDVenda(){
        int id = 0;
        String buscaid = "select max( id_venda ) from venda";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_READ_ONLY;
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(buscaid, tipo, concorrencia);
            rsdados = preparedStatement.executeQuery();
            rsdados.next();
            id = (Integer)rsdados.getInt(1);
            preparedStatement.close();
            //conexao.close();
            id++;
        }catch(IOException erro){
            System.out.println("erro "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("erro "+erro);
        }catch(SQLException erro){
            System.out.println("erro "+erro);
        }
        return id;
    }
    public int novoIDItem(){
        int id = 0 ;
        String buscaid = "SELECT MAX(id_item_venda) from item_venda";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_READ_ONLY;
        try{
            if(conexao == null){
               criaConexao();
            }
            preparedStatement = conexao.prepareStatement(buscaid, tipo, concorrencia);
            rsdados = preparedStatement.executeQuery();
            rsdados.next();
            id = (Integer)rsdados.getInt(1);
            preparedStatement.close();
            id++;
            
        }catch(IOException erro){
            System.out.println("Erro: "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro: "+erro);
        }catch(SQLException erro){
            System.out.println("Erro: "+erro);
        }
        return id;
    }
    public boolean gravarItem(ItemVenda item){
        boolean status =false;
        String insertItem = "INSERT INTO item_venda(id_item_venda, id_produto_item, quantidade, valor_item) values(?,?,?,?)";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
        try{
            if(conexao == null){
                criaConexao();
            }
            item.setId(novoIDItem());
            preparedStatement = conexao.prepareStatement(insertItem, tipo, concorrencia);
            preparedStatement.setInt(1, item.getId());
            preparedStatement.setInt(2, item.getItemProduto().getId());
            preparedStatement.setInt(3, item.getQuantidade());
            preparedStatement.setDouble(4, item.getValorItem());
            int resultado = preparedStatement.executeUpdate();
            if(resultado == 1){
                conexao.commit();
                status =true;
            }else{
                conexao.rollback();
                status = false;
            }
        }catch(IOException erro){
            System.out.println("Erro: "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro: "+erro);
        }catch(SQLException erro){
            System.out.println("Erro: "+erro);
        }
        
        return status;
    }
    
    
    public boolean gravarVenda(Venda venda){
        boolean status = false;
        ItemVenda item = null;
        String insertVenda = "INSERT INTO venda (id_venda, id_cliente, id_item_venda, valor_total) values(?,?,?,?)";
        String insertItemVenda = "INSERT INTO item_venda () values(?,?,?,?)";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
        
        try{
            if(conexao == null){
                criaConexao();
            }
            
            for(ItemVenda aux : venda.getItens()){
                preparedStatement = conexao.prepareStatement(insertVenda, tipo, concorrencia);
                preparedStatement.setInt(1, venda.getIdVenda());
                preparedStatement.setInt(2, venda.getIdcliente());
                preparedStatement.setInt(3, aux.getId());
                preparedStatement.setDouble(4, venda.getValortotal());
                
                int resposta = preparedStatement.executeUpdate();
                if(resposta == 1){
                    conexao.commit();
                    status = true;
                }else{
                    conexao.rollback();
                    status = false;
                }
            }
            
            
            
        }catch(IOException erro){
            System.out.println("Erro: "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro: "+erro);
        }catch(SQLException erro){
            System.out.println("Erro: "+erro);
        }
        
        
        return status;
    }
    
    public ItemVenda buscaItem(int iditemvenda){
        String busca = "SELECT * FROM item_venda where id_item_venda = ?";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_READ_ONLY;
        int idproduto, quantidade;
        double valoritem;
        ItemVenda item = null;
        contprod = new ControleProduto();
        Produto p = null;
        
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(busca, tipo, concorrencia);
            preparedStatement.setInt(1, iditemvenda);
            rsdados = preparedStatement.executeQuery();
            
            //rsdados.isBeforeFirst();
          //  while(rsdados.next()){
                rsdados.next();
                idproduto = rsdados.getInt("id_produto_item");
                quantidade = rsdados.getInt("quantidade");
                valoritem = rsdados.getDouble("valor_item");
                p = contprod.buscaProdBD(idproduto);
                item = new ItemVenda(iditemvenda, p, quantidade, valoritem);
            
        }catch(IOException erro){
            System.out.println("Erro: "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro: "+erro);
        }catch(SQLException erro){
            System.out.println("Erro: "+erro);
        }
        
        return item;
    }
    
    public ArrayList buscaVenda(int idcliente ){
        String busca = "SELECT * FROM venda INNER JOIN item_venda"
                + " ON item_venda.id_item_venda = venda.id_item_venda where id_cliente = ? order by id_venda";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_READ_ONLY;
        listvendas = new ArrayList<Venda>(); 
        int idvenda = 0, iditem=0, idproduto = 0, quantidade =0;
        double valortotal =0, valoritem =0;
        Venda aux = null;
        ItemVenda auxitem = null;
        ArrayList lista = new ArrayList();
        ArrayList<ItemVenda> auxlist = new ArrayList<>();
        Produto p = null;
        contprod = new ControleProduto();
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(busca, tipo, concorrencia);
            preparedStatement.setInt(1, idcliente);
            
            rsdados = preparedStatement.executeQuery();
            
            while(rsdados.next()){
                idvenda = rsdados.getInt("id_venda");
                iditem = rsdados.getInt("id_item_venda");
                idproduto = rsdados.getInt("id_produto_item");
                p = contprod.buscaProdBD(idproduto);
                quantidade = rsdados.getInt("quantidade");
                valoritem = rsdados.getDouble("valor_item");
                idvenda = rsdados.getInt("id_venda");
                valortotal = rsdados.getDouble("valor_total");
                //auxitem =  buscaItem(iditem);
                lista.add(new Object[]{idvenda,iditem, idproduto,p.getNome(), p.getDescricao(), quantidade
                ,valoritem, valortotal});
                
            }
           
        }catch(IOException erro){
            System.out.println("Erro: "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro: "+erro);
        }catch(SQLException erro){
            System.out.println("Erro: "+erro);
        }
        
        
        return lista;
        
        
    }
    
    public Venda listaVendaBD(int idvenda){
        Venda venda = null;
        ArrayList<ItemVenda> listaitens = new ArrayList<>();
        ItemVenda itemaux = null;
        
        
        ResultSet rsdados2 = null;
        PreparedStatement preparedStatement2 = null;
        int iditem, idcliente =0 , idVenda;
        double valortotal =0 ;
        
        String listar = "select * from venda where id_venda = ?";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_READ_ONLY;
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(listar, tipo, concorrencia);
            preparedStatement.setInt(1,idvenda);
            rsdados = preparedStatement.executeQuery();
            
            rsdados.isFirst();
            while(rsdados.next()){
                idcliente = rsdados.getInt("id_cliente");
                int iditemv = rsdados.getInt("id_item_venda");
                String busca = "SELECT * FROM item_venda where id_item_venda = ?";
                preparedStatement2 = conexao.prepareStatement(busca, tipo, concorrencia);
                preparedStatement2.setInt(1,iditemv);
                rsdados2 = preparedStatement2.executeQuery();
                rsdados2.next();
                int idprod = rsdados2.getInt("id_produto_item");
                contprod = new ControleProduto();
                Produto p = contprod.buscaProdBD(idprod);
                int quantidade = rsdados2.getInt("quantidade");
                double vitem = rsdados2.getDouble("valor_item");
                itemaux = new ItemVenda(iditemv,p,quantidade, vitem);
                listaitens.add(itemaux);
                
            }
            venda = new Venda(idvenda, idcliente, listaitens, valortotal);
           
            /*
            for(int i = 0; i < listaitens.size(); i++){
                System.out.println(" dao venda ");
                System.out.println(" id item "+listaitens.get(i).getId());
                System.out.println("nome prod "+listaitens.get(i).getItemProduto().getNome());
                System.out.println("descricao "+listaitens.get(i).getItemProduto().getDescricao());
                System.out.println("preco "+listaitens.get(i).getItemProduto().getPreco());
                System.out.println("quantidade "+listaitens.get(i).getQuantidade());
                System.out.println("preco total "+listaitens.get(i).getValorItem());
            }*/
        }catch(IOException erro){
            System.out.println("Erro: "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro: "+erro);
        }catch(SQLException erro){
            System.out.println("Erro: "+erro);
        }
        return venda;
        
    }
    
    public boolean deleteItem(int iditem){
        boolean status = false;
        String delete = "DELETE FROM venda where id_item_venda = ?";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
        
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(delete, tipo, concorrencia);
            preparedStatement.setInt(1,iditem);
            int resposta = preparedStatement.executeUpdate();
            if(resposta == 1){
                conexao.commit();
                status = true;
            }else {
                conexao.rollback();
                status = false;
            }
            
            
            
        }catch(IOException erro){
            System.out.println("erro "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("erro "+erro);
        }catch(SQLException erro){
            System.out.println("erro "+erro);
        }
        
        
        
        return status;
    }
    
    public boolean alterarItem(ItemVenda item){
        boolean status =false;
        String insertItem = "UPDATE item_venda set id_item_venda = ? , id_produto_item = ?, quantidade = ?, valor_item=? where id_item_venda = ?";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
        
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(insertItem, tipo, concorrencia);
            preparedStatement.setInt(1, item.getId());
            preparedStatement.setInt(2, item.getItemProduto().getId());
            preparedStatement.setInt(3, item.getQuantidade());
            preparedStatement.setDouble(4, item.getValorItem());
            preparedStatement.setInt(5, item.getId());
            int resultado = preparedStatement.executeUpdate();
            if(resultado == 1){
                conexao.commit();
                System.out.println("passou alterar item");
                status =true;
            }else{
                conexao.rollback();
                status = false;
            }
            
        }catch(IOException erro){
            System.out.println("Erro: "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro: "+erro);
        }catch(SQLException erro){
            System.out.println("Erro: "+erro);
        }
        return status;
    }
    public boolean deleteVenda(int idvenda){
        boolean status = false;
        String deletevenda = "delete from venda where id_venda = ?";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(deletevenda, tipo, concorrencia);
            preparedStatement.setInt(1, idvenda);
            int rs = preparedStatement.executeUpdate();
            if(rs == cont){
                    conexao.commit();
                    status = true;
                   
                }else{
                    conexao.rollback();
                    status = false;
                }
        }catch(IOException erro){
            System.out.println("Erro: "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro: "+erro);
        }catch(SQLException erro){
            System.out.println("Erro: "+erro);
        }
        return status;
    }
    
    public boolean alterarVenda(Venda venda){
        boolean status =false;
        String alterarvenda = "UPDATE venda set id_venda = ?, id_cliente = ?, id_item_venda = ?, valor_total = ? where id_venda =? ";
       // String alteraritem = "UPDATE item_venda set id_item_venda = ?  , id_produto_item =? , quantidade = ? , valor_item = ? where id_item_venda = ?";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
        try{
            if(conexao == null){
                criaConexao();
            }
            for(ItemVenda aux : venda.getItens()){
                preparedStatement = conexao.prepareStatement(alterarvenda, tipo, concorrencia);
                preparedStatement.setInt(1, venda.getIdVenda());
                preparedStatement.setInt(2, venda.getIdcliente());
                preparedStatement.setInt(3, aux.getId());
                preparedStatement.setDouble(4, venda.getValortotal());
                preparedStatement.setInt(5, venda.getIdVenda());
                
                int resposta = preparedStatement.executeUpdate();
                if(resposta == 1){
                    conexao.commit();
                    status = true;
                    System.out.println("passou alterar venda ");
                }else{
                    conexao.rollback();
                    status = false;
                }
            }
            
            
        }catch(IOException erro){
            System.out.println("Erro: "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro: "+erro);
        }catch(SQLException erro){
            System.out.println("Erro: "+erro);
        }
        
        
        return status;
    }
    
    public ArrayList buscarDadosAlterar(int idVenda){
        ArrayList lista = new ArrayList();
        String selectvenda = "select * from venda inner join item_venda "
                + "on venda.id_item_venda = item_venda.id_item_venda where id_venda = ?";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_READ_ONLY;
        contprod = new ControleProduto();
        int  idproduto, quantidade;
        String nomeproduto, descricao;
        double valoritem;
        Produto p =null;
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(selectvenda, tipo , concorrencia);
            preparedStatement.setInt(1, idVenda);
            rsdados = preparedStatement.executeQuery();
            
            while(rsdados.next()){
                cont++;
                idproduto = rsdados.getInt("id_produto_item");
                p = contprod.buscaProdBD(idproduto);
                
                quantidade = rsdados.getInt("quantidade");
                valoritem = rsdados.getDouble("valor_item");
                lista.add(new Object[]{idproduto, p.getNome(), p.getDescricao(), p.getPreco(), quantidade, valoritem});
                
            }
            
            
        }catch(IOException erro){
            System.out.println("erro "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("erro "+erro);
        }catch(SQLException erro){
            System.out.println("erro "+erro);
        }
        return lista;
    }
    public int contarVendas(int idcliente){
        String count = "select count(distinct id_venda) from venda where id_cliente = ?";
        int qtd = 0;
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_READ_ONLY;
        
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(count, tipo, concorrencia);
            preparedStatement.setInt(1, idcliente);
            rsdados = preparedStatement.executeQuery();
            rsdados.next();
            qtd = rsdados.getInt("count");
            
        }catch(IOException erro){
            System.out.println("erro "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("erro "+erro);
        }catch(SQLException erro){
            System.out.println("erro "+erro);
        }
        return qtd;
    }
    
    
}
