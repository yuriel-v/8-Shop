/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.framepack;

import java.util.Date;

/**
 *
 * @author DOUGLS
 */
public class TelaPrincipal extends javax.swing.JFrame {
    Date data = new Date();
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
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

        Desktop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        MenuServicos = new javax.swing.JMenu();
        MenuConsulta = new javax.swing.JMenuItem();
        MenuAgendamento = new javax.swing.JMenuItem();
        MenuOpcoes = new javax.swing.JMenu();
        MenuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(Desktop);
        Desktop.setBounds(0, 0, 470, 470);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cliente");
        jLabel1.setMaximumSize(new java.awt.Dimension(60, 22));
        jLabel1.setMinimumSize(new java.awt.Dimension(60, 22));
        jLabel1.setPreferredSize(new java.awt.Dimension(60, 22));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(560, 50, 100, 20);

        lblData.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblData.setText("Data");
        getContentPane().add(lblData);
        lblData.setBounds(480, 100, 180, 30);

        MenuServicos.setText("Serviços");

        MenuConsulta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_TAB, java.awt.event.InputEvent.ALT_MASK));
        MenuConsulta.setText("Consulta de Produtos");
        MenuConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConsultaActionPerformed(evt);
            }
        });
        MenuServicos.add(MenuConsulta);

        MenuAgendamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.ALT_MASK));
        MenuAgendamento.setText("Agendamento");
        MenuServicos.add(MenuAgendamento);

        Menu.add(MenuServicos);

        MenuOpcoes.setText("Opções");

        MenuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        MenuSair.setText("Sair");
        MenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSairActionPerformed(evt);
            }
        });
        MenuOpcoes.add(MenuSair);

        Menu.add(MenuOpcoes);

        setJMenuBar(Menu);

        setSize(new java.awt.Dimension(748, 506));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MenuSairActionPerformed

    private void MenuConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuConsultaActionPerformed

    
       private TelaPrincipal(java.awt.event.WindowEvent evt){
        lblData.setText(data.toString());
    }
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenuItem MenuAgendamento;
    private javax.swing.JMenuItem MenuConsulta;
    private javax.swing.JMenu MenuOpcoes;
    private javax.swing.JMenuItem MenuSair;
    private javax.swing.JMenu MenuServicos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblData;
    // End of variables declaration//GEN-END:variables
}
