/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Luan
 */
public class PessoaJuridica extends Pessoa implements java.io.Serializable {
    private static long serialVersionUID = 1L;
    private String CNPJ, nomeFantasia;

    public PessoaJuridica(String CNPJ, String nomeFantasia, int id, String nome, 
            String email, String telefone) {
        super.setId(id);
        super.setNome( nome);
        super.setEmail ( email);
        super.setTelefone ( telefone);
        this.CNPJ = CNPJ;
        this.nomeFantasia = nomeFantasia;
    }
    
    

    /*
    public PessoaJuridica(int id, String nome, String email,
            String telefone, String doc1, String doc2, String estado,
            String cidade,String bairro,String rua,String numero,String complemento){
        super.setId(id);
        super.setNome(nome);
        super.setEmail(email);
        this.nomeFantasia = doc1;
        this.CNPJ = doc2;
        endereco.estado= estado;
        endereco.cidade = cidade;
        endereco.bairro = bairro;
        endereco.rua = rua;
        endereco.numero = numero;
        endereco.complemento = complemento;
    }

    
    public PessoaJuridica(String [] dados){
        int id = Integer.parseInt(dados[0]);
        super.setId(id);
        super.setNome(dados[1]);
        super.setEmail(dados[2]);
        super.setTelefone(dados[3]);
        this.nomeFantasia = dados[4];
        this.CNPJ = dados[5];
        endereco.estado = dados[6];
        endereco.cidade = dados[7];
        endereco.bairro = dados[8];
        endereco.rua = dados[9];
        endereco.numero = dados[10];
        endereco.complemento = dados[11];
    }*/

   

   

    
    
    
    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /*public PessoaJuridica(String CNPJ, String nomeFantasia) {
        this.CNPJ = CNPJ;
        this.nomeFantasia = nomeFantasia;
    }*/

    
    
}
