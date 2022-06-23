/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Pesquisa;

import Controller.ControleCliente;
import View.Cadastro.CadastroCliente;
import View.Cadastro.CadastroProduto;
import View.Cadastro.CadastroUsuario;
import View.Cadastro.CadastroVenda;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */
public class PesquisaCliente extends javax.swing.JFrame {
    ControleCliente controle = null;
    /**
     * Creates new form PesquisaCliente
     */
    public PesquisaCliente() {
        initComponents();
        listar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabClientes = new javax.swing.JTable();
        btnListaCli = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnExcluir1 = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();
        menuBarra = new javax.swing.JMenuBar();
        jMenuCliente = new javax.swing.JMenu();
        menuClieCad = new javax.swing.JMenuItem();
        menuCliePesq = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();
        menuUser = new javax.swing.JMenu();
        menuUserCad = new javax.swing.JMenuItem();
        menuUserPesq = new javax.swing.JMenuItem();
        menuProduto = new javax.swing.JMenu();
        menuProdCad = new javax.swing.JMenuItem();
        menuProdPesq = new javax.swing.JMenuItem();
        menuVenda = new javax.swing.JMenu();
        menuVendCad = new javax.swing.JMenuItem();
        menuVendPesq = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();
        relatorioMenuCliente = new javax.swing.JMenu();
        exportClientePDF = new javax.swing.JMenuItem();
        exportVisuRelatorioClientes = new javax.swing.JMenuItem();
        exportMaioresClientes = new javax.swing.JMenuItem();
        relatorioMenuProduto = new javax.swing.JMenu();
        exportProdutoPDF = new javax.swing.JMenuItem();
        exportVisuRelatorioProdutos = new javax.swing.JMenuItem();
        relatorioMenuVenda = new javax.swing.JMenu();
        exportVendasPDF = new javax.swing.JMenuItem();
        exportVisuRelatorioVenda = new javax.swing.JMenuItem();
        exportVisuVendasAgrupadas = new javax.swing.JMenuItem();
        exportVendasAgrupadasPDF = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(null);

        tabClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tipo", "Nome", "Documento1", "Documento2", "Telefone", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabClientes.setColumnSelectionAllowed(true);
        tabClientes.setRowHeight(20);
        tabClientes.setShowGrid(true);
        jScrollPane1.setViewportView(tabClientes);
        tabClientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabClientes.getColumnModel().getColumnCount() > 0) {
            tabClientes.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabClientes.getColumnModel().getColumn(1).setPreferredWidth(20);
            tabClientes.getColumnModel().getColumn(2).setPreferredWidth(80);
            tabClientes.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabClientes.getColumnModel().getColumn(4).setPreferredWidth(50);
            tabClientes.getColumnModel().getColumn(5).setPreferredWidth(30);
            tabClientes.getColumnModel().getColumn(6).setPreferredWidth(150);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(180, 20, 980, 620);

        btnListaCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnListaCli.setText("Listar Clientes");
        btnListaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaCliActionPerformed(evt);
            }
        });
        getContentPane().add(btnListaCli);
        btnListaCli.setBounds(30, 20, 130, 30);

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excluir24px.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(50, 80, 40, 40);

        btnExcluir1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir1);
        btnExcluir1.setBounds(830, 140, 40, 40);

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar);
        btnEditar.setBounds(50, 150, 40, 40);

        lblFundo.setBackground(new java.awt.Color(0, 255, 255));
        lblFundo.setMaximumSize(new java.awt.Dimension(1400, 800));
        lblFundo.setName(""); // NOI18N
        lblFundo.setOpaque(true);
        lblFundo.setPreferredSize(new java.awt.Dimension(980, 580));
        getContentPane().add(lblFundo);
        lblFundo.setBounds(0, 0, 1200, 780);

        jMenuCliente.setText("Cliente");

        menuClieCad.setText("Cadastrar");
        menuClieCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClieCadActionPerformed(evt);
            }
        });
        jMenuCliente.add(menuClieCad);

        menuCliePesq.setText("Pesquisar");
        menuCliePesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCliePesqActionPerformed(evt);
            }
        });
        jMenuCliente.add(menuCliePesq);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuCliente.add(jMenuItemSair);

        menuBarra.add(jMenuCliente);

        menuUser.setText("Usuario");

        menuUserCad.setText("Cadastrar");
        menuUserCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUserCadActionPerformed(evt);
            }
        });
        menuUser.add(menuUserCad);

        menuUserPesq.setText("Pesquisar");
        menuUserPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUserPesqActionPerformed(evt);
            }
        });
        menuUser.add(menuUserPesq);

        menuBarra.add(menuUser);

        menuProduto.setText("Produto");

        menuProdCad.setText("Cadastrar");
        menuProdCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProdCadActionPerformed(evt);
            }
        });
        menuProduto.add(menuProdCad);

        menuProdPesq.setText("Pesquisar");
        menuProdPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProdPesqActionPerformed(evt);
            }
        });
        menuProduto.add(menuProdPesq);

        menuBarra.add(menuProduto);

        menuVenda.setText("Venda");

        menuVendCad.setText("Cadastrar");
        menuVendCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVendCadActionPerformed(evt);
            }
        });
        menuVenda.add(menuVendCad);

        menuVendPesq.setText("Pesquisar");
        menuVendPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVendPesqActionPerformed(evt);
            }
        });
        menuVenda.add(menuVendPesq);

        menuBarra.add(menuVenda);

        menuRelatorios.setText("Relatórios");

        relatorioMenuCliente.setText("Cliente");

        exportClientePDF.setText("Exportar para PDF");
        exportClientePDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportClientePDFActionPerformed(evt);
            }
        });
        relatorioMenuCliente.add(exportClientePDF);

        exportVisuRelatorioClientes.setText("Visualizar Relatórios Clientes");
        exportVisuRelatorioClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportVisuRelatorioClientesActionPerformed(evt);
            }
        });
        relatorioMenuCliente.add(exportVisuRelatorioClientes);

        exportMaioresClientes.setText("Maiores Clientes");
        exportMaioresClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportMaioresClientesActionPerformed(evt);
            }
        });
        relatorioMenuCliente.add(exportMaioresClientes);

        menuRelatorios.add(relatorioMenuCliente);

        relatorioMenuProduto.setText("Produto");

        exportProdutoPDF.setText("Exportar para PDF");
        exportProdutoPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportProdutoPDFActionPerformed(evt);
            }
        });
        relatorioMenuProduto.add(exportProdutoPDF);

        exportVisuRelatorioProdutos.setText("Visualizar Relatório Produtos");
        exportVisuRelatorioProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportVisuRelatorioProdutosActionPerformed(evt);
            }
        });
        relatorioMenuProduto.add(exportVisuRelatorioProdutos);

        menuRelatorios.add(relatorioMenuProduto);

        relatorioMenuVenda.setText("Venda");

        exportVendasPDF.setText("Exportar para PDF");
        exportVendasPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportVendasPDFActionPerformed(evt);
            }
        });
        relatorioMenuVenda.add(exportVendasPDF);

        exportVisuRelatorioVenda.setText("Visualizar Relatório de Venda");
        exportVisuRelatorioVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportVisuRelatorioVendaActionPerformed(evt);
            }
        });
        relatorioMenuVenda.add(exportVisuRelatorioVenda);

        exportVisuVendasAgrupadas.setText("Vendas Agrupadas Visualização");
        exportVisuVendasAgrupadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportVisuVendasAgrupadasActionPerformed(evt);
            }
        });
        relatorioMenuVenda.add(exportVisuVendasAgrupadas);

        exportVendasAgrupadasPDF.setText("Vendas Agrupadas Exportar PDF");
        exportVendasAgrupadasPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportVendasAgrupadasPDFActionPerformed(evt);
            }
        });
        relatorioMenuVenda.add(exportVendasAgrupadasPDF);

        menuRelatorios.add(relatorioMenuVenda);

        menuBarra.add(menuRelatorios);

        jMenuSair.setText("Sair");
        jMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairActionPerformed(evt);
            }
        });
        menuBarra.add(jMenuSair);

        setJMenuBar(menuBarra);

        setSize(new java.awt.Dimension(1216, 839));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnListaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaCliActionPerformed
        controle = new ControleCliente();
       // String nome = controle.selecionarNome(tabClientes);
        String [] colunas = new String[]{"ID","TIPO ","NOME", "DOCUMENTO1","DOCUMENTO2","TELEFONE","EMAIL" };
       
            tabClientes = controle.dadostabela(tabClientes, controle.listaImpressao() , colunas);

        
       
    }//GEN-LAST:event_btnListaCliActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        controle = new ControleCliente();
        int id = controle.selecionarId( tabClientes);
       // int tipo = controle.selecionarTipo( tabClientes);
        int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o Cliente?","Excluir Cliente",JOptionPane.YES_NO_OPTION);
        if(op == JOptionPane.YES_OPTION){
            // controle.newListClient();
            //controle.listarTodosClientes();
           // controle.deleteClientefromLista(id);
            //controle.deleteFile();
             if(controle.deleteCliente(id)== true){
               JOptionPane.showMessageDialog(null, "Cliente excluido!");
            }
          
        }if(op == JOptionPane.NO_OPTION || op == JOptionPane.CANCEL_OPTION){
            dispose();
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir1ActionPerformed
      
    }//GEN-LAST:event_btnExcluir1ActionPerformed

    private void menuClieCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClieCadActionPerformed
        CadastroCliente obj_acesso = new CadastroCliente();
        obj_acesso.setVisible(true);
    }//GEN-LAST:event_menuClieCadActionPerformed

    private void menuCliePesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCliePesqActionPerformed
        PesquisaCliente obj_acesso = new PesquisaCliente();
        obj_acesso.setVisible(true);
    }//GEN-LAST:event_menuCliePesqActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void menuUserCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUserCadActionPerformed
        CadastroUsuario obj = new CadastroUsuario();
        obj.setVisible(true);
    }//GEN-LAST:event_menuUserCadActionPerformed

    private void menuUserPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUserPesqActionPerformed
        PesquisaUsuario obj = new PesquisaUsuario();
        obj.setVisible(true);
    }//GEN-LAST:event_menuUserPesqActionPerformed

    private void menuProdCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProdCadActionPerformed
        CadastroProduto obj_acesso = new CadastroProduto();
        obj_acesso.setVisible(true);
    }//GEN-LAST:event_menuProdCadActionPerformed

    private void menuProdPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProdPesqActionPerformed
        PesquisaProduto obj_acesso = new PesquisaProduto();
        obj_acesso.setVisible(true);
    }//GEN-LAST:event_menuProdPesqActionPerformed

    private void menuVendCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVendCadActionPerformed
        CadastroVenda obj_acesso = new CadastroVenda(false);
        obj_acesso.setVisible(true);
    }//GEN-LAST:event_menuVendCadActionPerformed

    private void menuVendPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVendPesqActionPerformed
        PesquisaVenda obj_acesso = new PesquisaVenda();
        obj_acesso.setVisible(true);
    }//GEN-LAST:event_menuVendPesqActionPerformed

    private void exportClientePDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportClientePDFActionPerformed

    }//GEN-LAST:event_exportClientePDFActionPerformed

    private void exportVisuRelatorioClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportVisuRelatorioClientesActionPerformed

    }//GEN-LAST:event_exportVisuRelatorioClientesActionPerformed

    private void exportMaioresClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportMaioresClientesActionPerformed

    }//GEN-LAST:event_exportMaioresClientesActionPerformed

    private void exportProdutoPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportProdutoPDFActionPerformed

    }//GEN-LAST:event_exportProdutoPDFActionPerformed

    private void exportVisuRelatorioProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportVisuRelatorioProdutosActionPerformed

    }//GEN-LAST:event_exportVisuRelatorioProdutosActionPerformed

    private void exportVendasPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportVendasPDFActionPerformed

    }//GEN-LAST:event_exportVendasPDFActionPerformed

    private void exportVisuRelatorioVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportVisuRelatorioVendaActionPerformed

    }//GEN-LAST:event_exportVisuRelatorioVendaActionPerformed

    private void exportVisuVendasAgrupadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportVisuVendasAgrupadasActionPerformed

    }//GEN-LAST:event_exportVisuVendasAgrupadasActionPerformed

    private void exportVendasAgrupadasPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportVendasAgrupadasPDFActionPerformed

    }//GEN-LAST:event_exportVendasAgrupadasPDFActionPerformed

    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuSairActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int id = controle.selecionarId(tabClientes);
        int linha = tabClientes.getSelectedRow();

        CadastroCliente cad ;
        int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Editar o Cliente?","Editar Cliente",JOptionPane.YES_NO_OPTION);
        if(op == JOptionPane.YES_OPTION){

            dispose();

            cad = new CadastroCliente(true, id);
            cad.setVisible(true);

        }if(op == JOptionPane.NO_OPTION || op == JOptionPane.CANCEL_OPTION){
            dispose();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExcluir1;
    private javax.swing.JButton btnListaCli;
    private javax.swing.JMenuItem exportClientePDF;
    private javax.swing.JMenuItem exportMaioresClientes;
    private javax.swing.JMenuItem exportProdutoPDF;
    private javax.swing.JMenuItem exportVendasAgrupadasPDF;
    private javax.swing.JMenuItem exportVendasPDF;
    private javax.swing.JMenuItem exportVisuRelatorioClientes;
    private javax.swing.JMenuItem exportVisuRelatorioProdutos;
    private javax.swing.JMenuItem exportVisuRelatorioVenda;
    private javax.swing.JMenuItem exportVisuVendasAgrupadas;
    private javax.swing.JMenu jMenuCliente;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JMenuBar menuBarra;
    private javax.swing.JMenuItem menuClieCad;
    private javax.swing.JMenuItem menuCliePesq;
    private javax.swing.JMenuItem menuProdCad;
    private javax.swing.JMenuItem menuProdPesq;
    private javax.swing.JMenu menuProduto;
    private javax.swing.JMenu menuRelatorios;
    private javax.swing.JMenu menuUser;
    private javax.swing.JMenuItem menuUserCad;
    private javax.swing.JMenuItem menuUserPesq;
    private javax.swing.JMenuItem menuVendCad;
    private javax.swing.JMenuItem menuVendPesq;
    private javax.swing.JMenu menuVenda;
    private javax.swing.JMenu relatorioMenuCliente;
    private javax.swing.JMenu relatorioMenuProduto;
    private javax.swing.JMenu relatorioMenuVenda;
    private javax.swing.JTable tabClientes;
    // End of variables declaration//GEN-END:variables

/*
public void dadostabela(ArrayList listUsers){
    String [] colunas = new String[]{"ID","TIPO ","NOME", "EMAIL", "TELEFONE", "DOCUMENTO1", "DOCUMENTO2"};          
         
            ModeloTabela modelo = new ModeloTabela(listUsers, colunas);
            
            tabClientes.setModel(modelo);
            tabClientes.getColumnModel().getColumn(0).setPreferredWidth(80);
            tabClientes.getColumnModel().getColumn(0).setResizable(true);
            tabClientes.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabClientes.getColumnModel().getColumn(1).setResizable(true);
            tabClientes.getColumnModel().getColumn(2).setPreferredWidth(80);
            tabClientes.getColumnModel().getColumn(2).setResizable(true);
            tabClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabClientes.getColumnModel().getColumn(3).setResizable(true);
            tabClientes.getColumnModel().getColumn(4).setPreferredWidth(80);
            tabClientes.getColumnModel().getColumn(4).setResizable(true);
            tabClientes.getColumnModel().getColumn(5).setPreferredWidth(100);
            tabClientes.getColumnModel().getColumn(5).setResizable(true);
            tabClientes.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabClientes.getColumnModel().getColumn(6).setResizable(true);
           
            
           // tabUsers.setAutoResizeMode(tabUsers.AUTO_RESIZE_OFF);
            tabClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
    }



 
    
    public int selecionarId(){
        int linha = tabClientes.getSelectedRow();
        String id = (String) tabClientes.getValueAt(linha,0);
        int ide = Integer.parseInt(id);
        return ide;
    }
    public int selecionarTipo(){
        int linha = tabClientes.getSelectedRow();
        int type =-1;
        String tipo = (String) tabClientes.getValueAt(linha,1);
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
    */
    public void listar(){
        controle = new ControleCliente();
        String [] colunas = new String[]{"ID","TIPO ","NOME", "DOCUMENTO1","DOCUMENTO2","TELEFONE","EMAIL" };
        tabClientes = controle.dadostabela(tabClientes, controle.listaImpressao() , colunas);
    }      
    

}
