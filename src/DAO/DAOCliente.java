/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Cliente;
import Model.Endereco;
import Model.PessoaFisica;
import Model.PessoaJuridica;
import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */
public class DAOCliente extends ConectaBD {
    protected ArrayList<Cliente> listaClientes = null;
    
    
    public int novoId(){
        int id = 0;
        String buscaid = "select max( id_cliente ) from cliente";
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
    
    public boolean salvarCliente(Cliente cliente){
        String sqlSalvarCliente = "insert into cliente (id_cliente, tipo, nome, email, telefone, documento1, documento2,"
                + "estado, cidade, bairro, rua, numero, complemento) values(?,? , ? ,? , ? ,? , ? ,? , ? ,? , ? ,? , ? )";
        
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
        boolean status = false;
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(sqlSalvarCliente, tipo, concorrencia);
            if(cliente.getPessoaFisica() != null){
                preparedStatement.setInt(1, cliente.getPessoaFisica().getId());
                preparedStatement.setString(2, cliente.getTipo());
                preparedStatement.setString(3,cliente.getPessoaFisica().getNome());
                preparedStatement.setString(4 , cliente.getPessoaFisica().getEmail());
                preparedStatement.setString(5, cliente.getPessoaFisica().getTelefone());
                preparedStatement.setString(6,cliente.getPessoaFisica().getRg());
                preparedStatement.setString(7, cliente.getPessoaFisica().getCpf());
                preparedStatement.setString(8, cliente.getEndereco().getEstado());
                preparedStatement.setString(9, cliente.getEndereco().getCidade());
                preparedStatement.setString(10, cliente.getEndereco().getBairro());
                preparedStatement.setString(11, cliente.getEndereco().getRua());
                preparedStatement.setInt(12,Integer.parseInt( cliente.getEndereco().getNumero()));
                preparedStatement.setString(13,cliente.getEndereco().getComplemento());
                int resposta = preparedStatement.executeUpdate();
                preparedStatement.close();
                if(resposta == 1){
                    conexao.commit();
                    status = true;
                }else{
                    conexao.rollback();
                    status = false;
                }
                
                
            }
            if(cliente.getPessoaJuridica() != null){
                preparedStatement.setInt(1, cliente.getPessoaJuridica().getId());
                preparedStatement.setString(2, cliente.getTipo());
                preparedStatement.setString(3,cliente.getPessoaJuridica().getNome());
                preparedStatement.setString(4 , cliente.getPessoaJuridica().getEmail());
                preparedStatement.setString(5, cliente.getPessoaJuridica().getTelefone());
                preparedStatement.setString(6,cliente.getPessoaJuridica().getNomeFantasia());
                preparedStatement.setString(7, cliente.getPessoaJuridica().getCNPJ());
                preparedStatement.setString(8, cliente.getEndereco().getEstado());
                preparedStatement.setString(9, cliente.getEndereco().getCidade());
                preparedStatement.setString(10, cliente.getEndereco().getBairro());
                preparedStatement.setString(11, cliente.getEndereco().getRua());
                preparedStatement.setInt(12,Integer.parseInt( cliente.getEndereco().getNumero()));
                preparedStatement.setString(13,cliente.getEndereco().getComplemento());
                int resposta = preparedStatement.executeUpdate();
                preparedStatement.close();
                if(resposta == 1){
                    conexao.commit();
                    status = true;
                }else{
                    conexao.rollback();
                    status = false;
                }
            }
            
            
        }catch(IOException erro){
            System.out.println("Erro "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro "+erro);
        }catch(SQLException erro){
            System.out.println("Erro "+erro);
        }
        return status;
    }
    
    
    public ArrayList<Cliente> listarTodosClientes(){
        listaClientes = new ArrayList<>();
        Endereco endereco ;
        PessoaFisica pf ; 
        PessoaJuridica pj;
        
        int id, n;
        String pessoatipo,  nome,  email, 
             tel,  doc1,  doc2,  estado,  cidade,  bairro,
             rua,  numero,  complemento;
        Cliente aux = null;
        String lista = "select * from cliente order by id_cliente";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_READ_ONLY;
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(lista, tipo, concorrencia);
            rsdados = preparedStatement.executeQuery();
            int i = 0;
            rsdados.isBeforeFirst();
            while(rsdados.next()){
                id = rsdados.getInt("id_cliente");
                pessoatipo = rsdados.getString("tipo");
                nome = rsdados.getString("nome");
                email = rsdados.getString("email");
                tel = rsdados.getString("telefone");
                doc1 = rsdados.getString("documento1");
                doc2 = rsdados.getString("documento2");
                estado = rsdados.getString("estado");
                cidade = rsdados.getString("cidade");
                bairro = rsdados.getString("bairro");
                rua = rsdados.getString("rua");
                n = rsdados.getInt("numero");
                numero = Integer.toString(n);
                complemento = rsdados.getString("complemento");
                
                endereco = new Endereco(estado,cidade,bairro,rua ,numero,complemento);
                if(pessoatipo.equals("FÍSICA")){
                    pf = new PessoaFisica(doc2, doc1, id, nome, email, tel);
                    aux = new Cliente(pf,endereco);
                }
                if(pessoatipo.equals("JURÍDICA")){
                    pj = new PessoaJuridica(doc2, doc1, id, nome, email, tel );
                    aux = new Cliente(pj,endereco);
                }
                listaClientes.add(aux);
                
            }
        }catch(IOException erro){
            System.out.println("Erro "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro "+erro);
        }catch(SQLException erro){
            //System.out.println("Erro "+erro);
            JOptionPane.showMessageDialog(null, "Não há Clientes Cadastrados");
        }
        return listaClientes;
    }
    
    public boolean deleteCliente(int id){
        boolean status = false;
        String delete = "delete from cliente where id_cliente = ?";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
        
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(delete, tipo, concorrencia);
            preparedStatement.setInt(1,id);
            int resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
            if(resultado == 1){
                conexao.commit();
                status = true;
            }
            else{
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
    
    public Cliente buscaCliente(int idcliente){
        Cliente cliente = null;
        String estado, cidade, rua, bairro, numero, complemento,pessoatipo;
        String  nome, email, tel ;
        String doc1, doc2;
        int n = 0;
        Endereco endereco ;
        PessoaFisica pf ;
        PessoaJuridica pj;
        String busca = "SELECT * FROM cliente where id_cliente = ?";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_READ_ONLY;
        
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(busca, tipo, concorrencia);
            preparedStatement.setInt(1,idcliente);
            rsdados = preparedStatement.executeQuery();
            if(rsdados.next()){
                pessoatipo = rsdados.getString("tipo");
                nome = rsdados.getString("nome");
                email = rsdados.getString("email");
                tel = rsdados.getString("telefone");
                doc1 = rsdados.getString("documento1");
                doc2 = rsdados.getString("documento2");
                estado = rsdados.getString("estado");
                cidade = rsdados.getString("cidade");
                bairro = rsdados.getString("bairro");
                rua = rsdados.getString("rua");
                n = rsdados.getInt("numero");
                numero = Integer.toString(n);
                complemento = rsdados.getString("complemento");
                
                endereco = new Endereco(estado,cidade,bairro,rua ,numero,complemento);
                if(pessoatipo.equals("FÍSICA")){
                    pf = new PessoaFisica(doc2, doc1, idcliente, nome, email, tel);
                    cliente = new Cliente(pf,endereco);
                }
                if(pessoatipo.equals("JURÍDICA")){
                    pj = new PessoaJuridica(doc2, doc1, idcliente, nome, email, tel );
                    cliente = new Cliente(pj,endereco);
                }
                
            }
            
        }catch(IOException erro){
            System.out.println("Erro: "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro: "+erro);
        }catch(SQLException erro){
            System.out.println("Erro: "+erro);
        }
        return cliente;
    }
    
    
    public boolean alterarCliente(Cliente cliente){
        boolean status = false;
        String update = "update cliente set id_cliente = ? , tipo = ? , nome = ? , email = ? ,telefone = ?,"
                + "documento1 = ? , documento2 = ? , estado = ? , cidade = ? , bairro = ?, rua = ? , numero = ? , "
                + "complemento = ? where id_cliente = ?";
        int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
        int concorrencia = ResultSet.CONCUR_UPDATABLE;
       
        try{
            if(conexao == null){
                criaConexao();
            }
            preparedStatement = conexao.prepareStatement(update, tipo, concorrencia);
            if(cliente.getPessoaFisica() != null){
                preparedStatement.setInt(1, cliente.getPessoaFisica().getId());
                preparedStatement.setString(2, cliente.getTipo());
                preparedStatement.setString(3,cliente.getPessoaFisica().getNome());
                preparedStatement.setString(4 , cliente.getPessoaFisica().getEmail());
                preparedStatement.setString(5, cliente.getPessoaFisica().getTelefone());
                preparedStatement.setString(6,cliente.getPessoaFisica().getRg());
                preparedStatement.setString(7, cliente.getPessoaFisica().getCpf());
                preparedStatement.setString(8, cliente.getEndereco().getEstado());
                preparedStatement.setString(9, cliente.getEndereco().getCidade());
                preparedStatement.setString(10, cliente.getEndereco().getBairro());
                preparedStatement.setString(11, cliente.getEndereco().getRua());
                preparedStatement.setInt(12,Integer.parseInt( cliente.getEndereco().getNumero()));
                preparedStatement.setString(13,cliente.getEndereco().getComplemento());
                preparedStatement.setInt(14, cliente.getPessoaFisica().getId());
                int resposta = preparedStatement.executeUpdate();
                preparedStatement.close();
                if(resposta == 1){
                    conexao.commit();
                    status = true;
                }else{
                    conexao.rollback();
                    status = false;
                }
                
                
            }
            if(cliente.getPessoaJuridica() != null){
                preparedStatement.setInt(1, cliente.getPessoaJuridica().getId());
                preparedStatement.setString(2, cliente.getTipo());
                preparedStatement.setString(3,cliente.getPessoaJuridica().getNome());
                preparedStatement.setString(4 , cliente.getPessoaJuridica().getEmail());
                preparedStatement.setString(5, cliente.getPessoaJuridica().getTelefone());
                preparedStatement.setString(6,cliente.getPessoaJuridica().getNomeFantasia());
                preparedStatement.setString(7, cliente.getPessoaJuridica().getCNPJ());
                preparedStatement.setString(8, cliente.getEndereco().getEstado());
                preparedStatement.setString(9, cliente.getEndereco().getCidade());
                preparedStatement.setString(10, cliente.getEndereco().getBairro());
                preparedStatement.setString(11, cliente.getEndereco().getRua());
                preparedStatement.setInt(12,Integer.parseInt( cliente.getEndereco().getNumero()));
                preparedStatement.setString(13,cliente.getEndereco().getComplemento());
                preparedStatement.setInt(14, cliente.getPessoaJuridica().getId());
                int resposta = preparedStatement.executeUpdate();
                preparedStatement.close();
                if(resposta == 1){
                    conexao.commit();
                    status = true;
                }else{
                    conexao.rollback();
                    status = false;
                }
            }
            
            
        }catch(IOException erro){
            System.out.println("Erro "+erro);
        }catch(ClassNotFoundException erro){
            System.out.println("Erro "+erro);
        }catch(SQLException erro){
            System.out.println("Erro "+erro);
        }
        return status;
        
        
    }
    
}
