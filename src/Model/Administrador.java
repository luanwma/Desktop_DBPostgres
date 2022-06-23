/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Luan
 */
public class Administrador {
    private String CRA;
    
    public static final int FISICA = 0;
    public static final int JURIDICA = 1;
   
    PessoaFisica pf ;
    PessoaJuridica pj;
    public Administrador(int op, String [] dados){
       
       switch(op){
           case FISICA : 
              
           case JURIDICA: 
       }
    }
    
    public void setPessoaFisica(PessoaFisica pf){
       this.pf = pf;
    }
    public void setPessoaJuridica(PessoaJuridica pj){
       this.pj = pj;
    }
    public PessoaFisica getPessoaFisica(){
       return pf;
    }
    public PessoaJuridica getPessoaJuridica(){
       return pj;
    }
   
   
   
    public String getCRA() {
        return CRA;
    }

    public void setCRA(String CRA) {
        this.CRA = CRA;
    }

   

    
}
