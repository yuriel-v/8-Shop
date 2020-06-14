/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.framepack;

import br.com.daopack.Connecting;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DOUGLS
 */
public class TelaBemVindo extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    public void logar(){
        String sql = "select * from tbcliente where cpf = ? and senha = ?";
        //Os pontos de interrogação serão substituídos pelos valores digitados
        try {
            /*As linhas abaixo preparam a consulta ao banco de dados com base no que foi
            digitado nos campos de texto
            */
            ps = conexao.prepareStatement(sql);
            ps.setString(1, tfCpf.getText());
            ps.setString(2, pfSenha.getText());
            rs = ps.executeQuery();
            
            if (rs.next()){
                TelaPrincipal tp = new TelaPrincipal();
                tp.setVisible(true);
                this.dispose();
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Login e/ou Senha inválidos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Dados inválidos!");
        }
        
    }
    
    

    /**
     * Creates new form TelaBemVindo
     */
    public TelaBemVindo() {
        conexao = Connecting.connect();
        System.out.println(conexao);
   
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblSenha = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        btEntrar = new javax.swing.JButton();
        tfCpf = new javax.swing.JTextField();
        pfSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        btCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("G8 Store - LOGIN");
        setResizable(false);
        getContentPane().setLayout(null);

        lblSenha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(255, 255, 0));
        lblSenha.setText("Senha:");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(70, 120, 160, 20);

        lblCpf.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCpf.setForeground(new java.awt.Color(255, 255, 0));
        lblCpf.setText("CPF:");
        getContentPane().add(lblCpf);
        lblCpf.setBounds(70, 70, 50, 30);

        btEntrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btEntrar.setText("Entrar");
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btEntrar);
        btEntrar.setBounds(200, 170, 80, 30);
        getContentPane().add(tfCpf);
        tfCpf.setBounds(140, 70, 170, 30);
        getContentPane().add(pfSenha);
        pfSenha.setBounds(140, 110, 170, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Não Possui cadastro? Então faça um clicando no botão abaixo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 210, 430, 30);

        btCadastrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btCadastrar);
        btCadastrar.setBounds(190, 240, 110, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/viewpack/Fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, -10, 530, 350);

        setSize(new java.awt.Dimension(503, 334));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
       logar();
    }//GEN-LAST:event_btEntrarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        TelaCadastro tc = new TelaCadastro();
        tc.setVisible(true);
        this.dispose();
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(TelaBemVindo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaBemVindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBemVindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBemVindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBemVindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaBemVindo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btEntrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfCpf;
    // End of variables declaration//GEN-END:variables
}
