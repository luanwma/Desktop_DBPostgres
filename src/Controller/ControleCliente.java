/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOCliente;
import Model.Cliente;
import Model.Endereco;
import Model.Pessoa;
import Model.PessoaFisica;
import Model.PessoaJuridica;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Luan
 */
public class ControleCliente extends DAOCliente implements InterfaceControle{
   
    ArrayList<Cliente> listaclientes  = new ArrayList<Cliente>();
   
    Cliente cliente = null;
    Pessoa pessoa = null;
    PessoaFisica pf = null;
    PessoaJuridica pj = null;
    Endereco endereco = null;
    
    public ControleCliente(){
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
    
   
    
    String [] dados ;
    
   
    //pessoa fisica
    /* nome, email, telefone, rg, cpf, estado, cidade, bairro, rua, numero, complemento */
    //pessoa juridica
    /*nome, email telefone, nomefantasia, cnpj, estado, cidade, bairro, rua, numero, complemento*/
    public boolean pegarDados(boolean alteracao ,int id ,int tipo, String nome, String email, 
            String tel, String doc1, String doc2, String estado, String cidade, String bairro,
            String rua, String numero, String complemento) throws IOException{
        
        int realid = novoId();
        if(alteracao == false){
            endereco = new Endereco(estado,cidade,bairro,rua ,numero,complemento);
            if(tipo ==0 ){
                pf = new PessoaFisica(doc2, doc1, realid, nome, email, tel);
                cliente = new Cliente(pf,endereco);
            }
            if(tipo ==1){
                pj = new PessoaJuridica(doc2, doc1, realid, nome, email, tel );
                cliente = new Cliente(pj,endereco);
            }
        }else if(alteracao == true){
            endereco = new Endereco(estado,cidade,bairro,rua ,numero,complemento);
            if(tipo ==0 ){
                pf = new PessoaFisica(doc2, doc1, id, nome, email, tel);
                cliente = new Cliente(pf,endereco);
            }
            if(tipo ==1){
                pj = new PessoaJuridica(doc2, doc1, id, nome, email, tel );
                cliente = new Cliente(pj,endereco);
            }
        }
        
        return true;
    }
    
    public String[] retornarDados(int id){
        Cliente cli = buscaCliente(id);
        String []dados = new String[12] ;
        
        if(cli.getPessoaFisica() != null){
            dados[0] = cli.getTipo();
            dados[1] = cli.getPessoaFisica().getNome();
            dados[2] = cli.getPessoaFisica().getEmail();
            dados[3] = cli.getPessoaFisica().getTelefone();
            
            dados[4] = cli.getPessoaFisica().getRg();
            dados[5] = cli.getPessoaFisica().getCpf();
            dados[6] = cli.getEndereco().getEstado();
            dados[7] = cli.getEndereco().getCidade();
            dados[8] = cli.getEndereco().getBairro();
            dados[9] = cli.getEndereco().getRua();
            dados[10] = cli.getEndereco().getNumero();
            dados[11] = cli.getEndereco().getComplemento();
            
            
        }
        if(cli.getPessoaJuridica() != null){
            dados[0] = cli.getTipo();
            dados[1] = cli.getPessoaJuridica().getNome();
            dados[2] = cli.getPessoaJuridica().getEmail();
            dados[3] = cli.getPessoaJuridica().getTelefone();
            dados[4] = cli.getPessoaJuridica().getNomeFantasia();
            dados[5] = cli.getPessoaJuridica().getCNPJ();
            dados[6] = cli.getEndereco().getEstado();
            dados[7] = cli.getEndereco().getCidade();
            dados[8] = cli.getEndereco().getBairro();
            dados[9] = cli.getEndereco().getRua();
            dados[10] = cli.getEndereco().getNumero();
            dados[11] = cli.getEndereco().getComplemento();
        }
        return dados;
        
    }
    public boolean gravarCliente(){
        boolean status = false;
        if( salvarCliente(cliente)== true){
            status = true;
        }
        return status;
    }
    public boolean updateCliente(){
        boolean status = false;
        if(alterarCliente(cliente) == true ){
            status = true;
        }
        return status;
    }
   
    public ArrayList buscaCliente(String nomeBusca) throws IOException{
       ArrayList print = new ArrayList();
       ArrayList<Cliente> aux = listarTodosClientes();
       
       ControleVenda contVenda = new ControleVenda();
       
       
       for(int i = 0 ; i < aux.size() ; i++){
           if(aux.get(i).getPessoaFisica() != null){
               if(aux.get(i).getPessoaFisica().getNome().contains(nomeBusca)){
                   
                   print.add(new Object[]{aux.get(i).getPessoaFisica().getId() , 
                       aux.get(i).getTipo(), aux.get(i).getPessoaFisica().getNome() , 
                   aux.get(i).getPessoaFisica().getRg() ,aux.get(i).getPessoaFisica().getCpf(), 
                   aux.get(i).getPessoaFisica().getTelefone(), aux.get(i).getPessoaFisica().getEmail()});
               }
           }
           if(aux.get(i).getPessoaJuridica() != null){
               if(aux.get(i).getPessoaJuridica().getNome().contains(nomeBusca)){
                   
                   print.add(new Object[]{aux.get(i).getPessoaJuridica().getId() ,aux.get(i).getTipo(),
                       aux.get(i).getPessoaJuridica().getNome() ,
                       aux.get(i).getPessoaJuridica().getNomeFantasia() ,
                       aux.get(i).getPessoaJuridica().getCNPJ(), aux.get(i).getPessoaJuridica().getTelefone(), 
                       aux.get(i).getPessoaJuridica().getEmail()});
               }
           }
       }
       return print;
    }
    
    public ArrayList buscaClienteQtdVenda(String nomeBusca) throws IOException{
       ArrayList print = new ArrayList();
       ArrayList<Cliente> aux = listarTodosClientes();
       int qtddvendaclient =-1;
       ControleVenda contVenda = new ControleVenda();
       
       
       for(int i = 0 ; i < aux.size() ; i++){
           if(aux.get(i).getPessoaFisica() != null){
               if(aux.get(i).getPessoaFisica().getNome().contains(nomeBusca)){
                   qtddvendaclient = contVenda.contarVendas(aux.get(i).getPessoaFisica().getId());
                   print.add(new Object[]{aux.get(i).getPessoaFisica().getId() , 
                       aux.get(i).getTipo(), aux.get(i).getPessoaFisica().getNome() , 
                   aux.get(i).getPessoaFisica().getRg() ,aux.get(i).getPessoaFisica().getCpf(), qtddvendaclient});
               }
           }
           if(aux.get(i).getPessoaJuridica() != null){
               if(aux.get(i).getPessoaJuridica().getNome().contains(nomeBusca)){
                   qtddvendaclient = contVenda.contarVendas(aux.get(i).getPessoaJuridica().getId());
                   print.add(new Object[]{aux.get(i).getPessoaJuridica().getId() ,aux.get(i).getTipo(),
                       aux.get(i).getPessoaJuridica().getNome() ,
                       aux.get(i).getPessoaJuridica().getNomeFantasia() ,
                       aux.get(i).getPessoaJuridica().getCNPJ(), qtddvendaclient});
               }
           }
       }
       return print;  
    }
    
    public boolean removeCliente(int id){
        boolean status = false;    
        if(deleteCliente(id) == true){
            status = true;
        }
        
        return status;
    }
    
    public Cliente getCliente(){
        
        System.out.println(" dentro de get cliente +++++ \n");
        if(cliente.getPessoaFisica() != null){
            System.out.println(" id pf "+cliente.getPessoaFisica().getId());
        }
        if(cliente.getPessoaJuridica() != null){
            System.out.println(" id  pj "+cliente.getPessoaJuridica().getId());
        }
        
        return cliente;
    }
    
    
    public ArrayList listaImpressao(){
        ArrayList lista = new ArrayList();
        ArrayList<Cliente> listaClientes = listarTodosClientes();
        for(int i = 0 ; i < listaClientes.size() ; i ++){
            if(listaClientes.get(i).getPessoaFisica() != null){
                lista.add(new Object[]{listaClientes.get(i).getPessoaFisica().getId() , 
                    listaClientes.get(i).getTipo(),
                    listaClientes.get(i).getPessoaFisica().getNome(),
                    listaClientes.get(i).getPessoaFisica().getRg(),
                    listaClientes.get(i).getPessoaFisica().getCpf(),
                    listaClientes.get(i).getPessoaFisica().getTelefone(),
                    listaClientes.get(i).getPessoaFisica().getEmail(),
                    });
            }
            if(listaClientes.get(i).getPessoaJuridica() != null){
                lista.add(new Object[]{listaClientes.get(i).getPessoaJuridica().getId() , 
                    listaClientes.get(i).getTipo(),
                    listaClientes.get(i).getPessoaJuridica().getNome(),
                    listaClientes.get(i).getPessoaJuridica().getNomeFantasia(),
                    listaClientes.get(i).getPessoaJuridica().getCNPJ(),
                    listaClientes.get(i).getPessoaJuridica().getTelefone(),
                    listaClientes.get(i).getPessoaJuridica().getEmail(),
                    });
            }
            
        }
        return lista;
        
        
    }
    
    
    

    @Override
    public JTable dadostabela(JTable table, ArrayList listclientes, String[] colunas) {
        ModeloTabela modelo = new ModeloTabela(listclientes, colunas);
            
            table.setModel(modelo);
            for(int i = 0 ; i <colunas.length;i++){
                table.getColumnModel().getColumn(i).setPreferredWidth(20);
                table.getColumnModel().getColumn(i).setResizable(true);
            }
            
            
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            return table;
    
    }
    
   
    public String selecionarNome(JTable tabClientes){
        int linha = tabClientes.getSelectedRow();
        String nome = null /*(String)tabClientes.getValueAt(linha, 2)*/;
        
         try{
            if(  tabClientes.getValueAt(linha,2 ) != null){
                nome = (String) tabClientes.getValueAt(linha,2);
            }
        }catch(ArrayIndexOutOfBoundsException erro){
            System.out.println("Erro : "+erro);
        }
        return nome;
    }
    
    
     public int selecionarId(JTable tabClientes){
        int linha = tabClientes.getSelectedRow();
        int id = -1;
       try{
            if(  tabClientes.getValueAt(linha,0 ) != null){
                id = (Integer) tabClientes.getValueAt(linha,0 );
            }
        }catch(ArrayIndexOutOfBoundsException erro){
            System.out.println("Erro : "+erro);
        }
        return id;
    }
    public int selecionarTipo(JTable tabClientes){
        int linha = tabClientes.getSelectedRow();
        int type =-1;
        String tipo = null;
         try{
            if(  tabClientes.getValueAt(linha,0 ) != null){
                tipo = (String) tabClientes.getValueAt(linha,1);
            }
        }catch(ArrayIndexOutOfBoundsException erro){
            System.out.println("Erro : "+erro);
        }
       // String tipo = (String) tabClientes.getValueAt(linha,1);
        if(tipo.contains("FÍSICA")){
            type =0;
            return type;
        }
        if(tipo.contains("JURÍDICA")){
            type = 1;
            return type;
        }
        //int ttipo = Integer.parseInt(tipo);
        return type;
       
    }

   
    
    
    
   
    
}
