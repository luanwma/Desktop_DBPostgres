/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luan
 */
public final class ModeloTabela extends AbstractTableModel{
    private ArrayList linhas;
    private String[] colunas = null;
 
    
    
    public ModeloTabela(ArrayList linha, String[] coluna ){
        setLinhas(linha);
        setColunas(coluna);
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    @Override
    public int getRowCount(){
        return linhas.size();
    }
    @Override
    public String getColumnName(int numColuna){
        return colunas[numColuna];
    }
    
    @Override
    public Object getValueAt(int numLinha, int numColuna){
        Object[] linha = (Object[])getLinhas().get(numLinha);
        return linha[numColuna];
    } 
 
   
    
}
