/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Cadastro;

import Controller.ControleProduto;
import View.Pesquisa.PesquisaCliente;
import View.Pesquisa.PesquisaProduto;
import View.Pesquisa.PesquisaUsuario;
import View.Pesquisa.PesquisaVenda;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */
public class CadastroProduto extends javax.swing.JFrame {
    ControleProduto controle = null;
    private int id;
    boolean config = false;
    
    /**
     * Creates new form CadastroProduto
     */
    public CadastroProduto() {
       initComponents();
       config = false;
       confBotoes(config);
    }
    
    public CadastroProduto(boolean config, int idproduto){
        initComponents();
        this.id = idproduto;
        config = config;
        confBotoes(config);
        getValues(idproduto);
        
    }
    public void getValues(int idproduto){
        controle = new ControleProduto();
        String []values = controle.retornarDados(idproduto);
        txtNomeProd.setText(values[0]);
        txtPreco.setText(values[1]);
        txtDescricao.setText(values[2]);
    }

   

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNomeProd = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
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
        getContentPane().setLayout(null);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Cadastro de Novo Produto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 5, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nome do Produto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Preço do Produto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Descrição do Produto");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        txtNomeProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtNomeProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 260, 35));

        txtPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPreco.setText("0");
        jPanel1.add(txtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 70, 35));

        txtDescricao.setColumns(20);
        txtDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 300, 110));

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 110, 35));

        btnLimpar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 110, 35));

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, 110, 35));

        btnNovo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, 110, 35));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(190, 140, 910, 500);

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

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtNomeProd.setText("");    
        txtPreco.setText("0");
        txtDescricao.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        controle = new ControleProduto();
        String nome, preco, descricao;
        nome = txtNomeProd.getText();
        preco = txtPreco.getText();
        descricao = txtDescricao.getText();
        double pnum = Double.parseDouble(preco);
        try{
            controle.criarProduto(true, id, nome, pnum,descricao);
            if(controle.alterarProduto(controle.getProduto()) == true){
                JOptionPane.showMessageDialog(null,"Produto alterado com sucesso! ");
                dispose();
            }
            
          
            
        }catch(IOException erro){
            System.out.println("Erro : "+erro);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        controle = new ControleProduto();
        String nome, preco, descricao;
        nome = txtNomeProd.getText();
        preco = txtPreco.getText();
        descricao = txtDescricao.getText();
        double pnum = Double.parseDouble(preco);
        try{
            
            controle.criarProduto(false, id, nome, pnum, descricao);
            
            if( controle.gravarProduto()== true){
                JOptionPane.showMessageDialog(null,"Produto criado com sucesso! ");
                dispose();
            }
            
        }catch(IOException erro){
            System.out.println("erro " +erro);
        }
       
       
       
       
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNovoActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JMenuItem exportClientePDF;
    private javax.swing.JMenuItem exportMaioresClientes;
    private javax.swing.JMenuItem exportProdutoPDF;
    private javax.swing.JMenuItem exportVendasAgrupadasPDF;
    private javax.swing.JMenuItem exportVendasPDF;
    private javax.swing.JMenuItem exportVisuRelatorioClientes;
    private javax.swing.JMenuItem exportVisuRelatorioProdutos;
    private javax.swing.JMenuItem exportVisuRelatorioVenda;
    private javax.swing.JMenuItem exportVisuVendasAgrupadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenuCliente;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNomeProd;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables

    public void confBotoes( boolean confg){
        if(confg == false){
            btnSalvar.setEnabled(true);
            btnLimpar.setEnabled(true);
            btnNovo.setEnabled(true);
            btnEditar.setEnabled(false);
        }
        if(confg == true){
            btnSalvar.setEnabled(false);
            btnLimpar.setEnabled(true);
            btnNovo.setEnabled(false);
            btnEditar.setEnabled(true);
        }
        
    }

}
