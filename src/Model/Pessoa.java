
package Model;

/**
 *
 * @author Luan
 */
public abstract class Pessoa  implements java.io.Serializable {
    private static long serialVersionUID = 1L;
    private String  nome, email, telefone ;
    private int id = 0;
   // Pessoa p ;
   // private String senha, usuario;
  //  public Endereco endereco = new Endereco();

    public Pessoa() {
    }
    
   
    
    /*
    public Pessoa(int id , String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.id = id;
    }*/
    
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    /*
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    */

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
