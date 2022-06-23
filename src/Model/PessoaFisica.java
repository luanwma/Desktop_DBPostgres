/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Luan
 */
public class PessoaFisica extends Pessoa implements java.io.Serializable{
    private static long serialVersionUID = 1L;
    private String cpf, rg;
    
    /*public PessoaFisica(String cpf, String rg){
        this.cpf = cpf;
        this.rg = rg;
    }*/

    public PessoaFisica(String cpf, String rg, int id, String nome, String email, String telefone) {
        super.setId(id);
        super.setNome( nome);
        super.setEmail ( email);
        super.setTelefone ( telefone);
      //  super(id, nome, email, telefone);
        this.cpf = cpf;
        this.rg = rg;
    }

    
    
    
    /*
    public PessoaFisica(String [] dados){
        int id = Integer.parseInt(dados[0]);
        super.setId(id);
        super.setNome(dados[1]);
        super.setEmail(dados[2]);
        super.setTelefone(dados[3]);
        this.rg = dados[4];
        this.cpf = dados[5];
        endereco.estado = dados[6];
        endereco.cidade = dados[7];
        endereco.bairro = dados[8];
        endereco.rua = dados[9];
        endereco.numero = dados[10];
        endereco.complemento = dados[11];
        
    }
    */

   /*
    public PessoaFisica(int id, String nome, String email,
            String telefone, String doc1, String doc2, String estado,
            String cidade,String bairro,String rua,String numero,String complemento){
        super.setId(id);
        super.setNome(nome);
        super.setEmail(email);
        super.setTelefone(telefone);
        this.rg = doc1;
        this.cpf = doc2;
        endereco.estado = estado;
        endereco.cidade = cidade;
        endereco.bairro = bairro;
        endereco.rua = rua;
        endereco.numero = numero;
        endereco.complemento = complemento;
    } */
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    
    
}
