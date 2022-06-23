/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author Aluno
 */
public class DAOUsuario extends ConectaBD {
    
    public boolean confirmarUsuario(String nome, String senha){
        boolean status =false;
        String login = "select * from usuarios where nome = ? and senha = ?";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
        
        try {
            if(conexao == null){
                criaConexao();
            }
            
            preparedStatement = conexao.prepareStatement(login, tipo, concorrencia);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2,senha);
            rsdados =  preparedStatement.executeQuery();
            
            if(rsdados.next()){
                status = true;
            }
          
            else status = false;
            
            
        } catch (IOException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
        
    }
    
    public boolean gravarUsuario(Usuario user){
        String inserirUsuario = "insert into Usuarios (nome,senha) values(?,?)";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
        boolean status = false;
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(inserirUsuario, tipo, concorrencia);
            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2, user.getSenha());
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
            System.out.println("erro "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("erro "+erro);
        }catch(SQLException erro){
            System.out.println("erro "+erro);
        }
            
            
        return status;    
            
            
        
    }
    
    
    public boolean editarUsuario(Usuario user){
        String atualizar = "update Usuarios set nome = ? , senha = ?  where(nome = ? and  senha = ?)";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
        boolean status = false;
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(atualizar, tipo, concorrencia);
            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2, user.getSenha());
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
            System.out.println("erro "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("erro "+erro);
        }catch(SQLException erro){
            System.out.println("erro "+erro);
        }
            
            
        return status;    
            
            
        
    }
    
    public boolean deleteUsuario(String nome, String senha){
        boolean status = false;
        String delete = "DELETE FROM usuarios where nome = ? and senha = ?";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
        
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(delete, tipo, concorrencia);
            preparedStatement.setString(1,nome);
            preparedStatement.setString(2, senha);
            int resposta =  preparedStatement.executeUpdate();
            preparedStatement.close();
            if(resposta == 1){
                conexao.commit();
                status = true;
            }else {
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
    
    
}
