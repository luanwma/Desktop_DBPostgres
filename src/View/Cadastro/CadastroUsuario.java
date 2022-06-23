/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Cadastro;

import Controller.ControleUsuario;
import View.Pesquisa.PesquisaCliente;
import View.Pesquisa.PesquisaProduto;
import View.Pesquisa.PesquisaUsuario;
import View.Pesquisa.PesquisaVenda;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */
public class CadastroUsuario extends javax.swing.JFrame {

    ControleUsuario controle = new ControleUsuario();
    /**
     * Creates new form CadastroUsuario
     */
    public CadastroUsuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userSenha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        userNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nome");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(310, 280, 80, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Senha");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(300, 350, 90, 22);

        userSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(userSenha);
        userSenha.setBounds(470, 340, 170, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Insira o nome e senha do novo usuário");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(320, 160, 470, 40);

        userNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(userNome);
        userNome.setBounds(470, 280, 170, 40);

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(810, 310, 100, 40);

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

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome, senha;
        nome = userSenha.getText();
        senha = userSenha.getText();
        if(controle.criarUsuario(nome, senha)== true){
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
        }
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JMenu jMenuCliente;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenu jMenuSair;
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
    private javax.swing.JTextField userNome;
    private javax.swing.JTextField userSenha;
    // End of variables declaration//GEN-END:variables
}
