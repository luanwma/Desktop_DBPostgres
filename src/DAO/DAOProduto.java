/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Produto;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Luan
 */
public class DAOProduto extends ConectaBD {
    ArrayList<Produto> listaProdutos = null;
    
    public int novoId(){
        int id = 0;
        String buscaid = "select max( id_produto ) from produto";
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
    
    public boolean salvarProduto(Produto produto){
        String salvarproduto = "INSERT INTO produto (id_produto, nome, preco, descricao) values(?,?,?,?)";
        boolean status = false;
        
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(salvarproduto, tipo, concorrencia);
            preparedStatement.setInt(1, produto.getId());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setDouble(3, produto.getPreco());
            preparedStatement.setString(4, produto.getDescricao());
            
            int resposta = preparedStatement.executeUpdate();
            preparedStatement.close();
            if(resposta == 1){
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
    
    public ArrayList<Produto> listarTodosProdutos(){
        listaProdutos = new ArrayList<>();
        Produto produto ;
        int id;
        String nome, descricao;
        double preco;
        String buscaProdutos = "SELECT * FROM produto order by id_produto";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_READ_ONLY;
        
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(buscaProdutos, tipo, concorrencia);
            rsdados = preparedStatement.executeQuery();
            
            rsdados.isBeforeFirst();
            while(rsdados.next()){
                id = rsdados.getInt("id_produto");
                nome = rsdados.getString("nome");
                preco = rsdados.getDouble("preco");
                descricao = rsdados.getString("descricao");
                produto = new Produto(id, nome, preco, descricao);
                listaProdutos.add(produto);
            }
        }catch(IOException erro){
            System.out.println("Erro: "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro: "+erro);
        }catch(SQLException erro){
            System.out.println("Erro: "+erro);
        }
        return listaProdutos;
    }
    public Produto buscaProdBD(int idProduto){
        Produto prod = null;
        String busca = "Select * from produto where id_produto = ?";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_READ_ONLY;
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(busca,tipo, concorrencia );
            preparedStatement.setInt(1, idProduto);
            rsdados = preparedStatement.executeQuery();
            rsdados.isBeforeFirst();
            while(rsdados.next()){
                int id = rsdados.getInt("id_produto");
                String nome = rsdados.getString("nome");
                double preco = rsdados.getDouble("preco");
                String descricao = rsdados.getString("descricao");
                prod = new Produto(id, nome, preco, descricao);
            }
        }catch(IOException erro){
            System.out.println("Erro: "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro: "+erro);
        }catch(SQLException erro){
            System.out.println("Erro: "+erro);
        }
        return prod;
        
    }
    
    public boolean deleteProduto(int id){
        boolean status = false;
        String deleteprod = "delete from produto where id_produto = ?";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
        
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(deleteprod, tipo , concorrencia);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            preparedStatement.close();
            if(rs == 1){
                conexao.commit();
                status = true;
            }else{
                conexao.rollback();
                status = false;
            }
        }catch(IOException erro){
            System.out.println("Erro : "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro : "+erro);
        }catch(SQLException erro){
            System.out.println("Erro : "+erro);
        }
        
        
        return status;
    }
    
    public boolean alterarProduto(Produto alterado){
        boolean status = false;
        String update = "update produto set id_produto = ? , nome = ? , preco = ? , descricao = ? where id_produto = ?";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
        
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(update, tipo, concorrencia);
            preparedStatement.setInt(1, alterado.getId());
            preparedStatement.setString(2,alterado.getNome());
            preparedStatement.setDouble(3, alterado.getPreco());
            preparedStatement.setString(4,alterado.getDescricao());
            preparedStatement.setInt(5,alterado.getId());
            int rs = preparedStatement.executeUpdate();
            preparedStatement.close();
            
            if(rs ==1){
                conexao.commit();
                status = true;
            }else{
                conexao.rollback();
                status = false;
            }
        }catch(IOException erro){
            System.out.println("Erro : "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro : "+erro);
        }catch(SQLException erro){
            System.out.println("Erro : "+erro);
        }
        return status;
        
        
    }
    
    
}
