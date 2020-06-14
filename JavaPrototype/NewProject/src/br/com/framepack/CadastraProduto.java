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
public class CadastraProduto extends javax.swing.JInternalFrame {
    Connection conexao = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    /**
     * Creates new form CadastraProduto
     */
    
    //Método de consultar produto
    private void Consultar(){
        String sql = "select * from mercadoria where codmercadoria = ?";
         try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, tfNome.getText());
          
            rs = ps.executeQuery();
            
            if (rs.next()){
                tfNome.setText(rs.getString(2));
                tfPreco.setText(rs.getString(3));
                
              
            } else {
                JOptionPane.showMessageDialog(null, "Dados Inválidos!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dados inválidos!");
        }
    }
    
    //Método para adicionar Produto
    private void Adicionar(){
        String sql = "insert into mercadoria(nome, preco), values(?, ?)";
        try {
            //Os pontos de interrogação serão substituídos pelos valores digitados
            ps = conexao.prepareStatement(sql);
            ps.setString(1, tfNome.getText());
            ps.setFloat(2, Float.parseFloat(tfPreco.getText()));
            //Verificação dos campos obrigatória
            if (tfNome.getText().isEmpty()||tfPreco.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Favor preencher os campos obrigatórios");
                
            }
            // A estrutura abaixo é utilizada para confirmar a inserção dos dados do produto na tabela
            int a = ps.executeUpdate();
            if (a > 0){
                JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
                tfNome.setText(null);
                tfPreco.setText(null);
                tfCodigo.setText(null);
                
                
            }
            else {
                JOptionPane.showMessageDialog(null, "Não foi possível adicionar!");
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        
    }
    
    
    
    //criando o método para alterar dados do produto
    private void Alterar(){
        String sql = "update mercadoria set nome = ?, preco = ? where codmercadoria = ? ";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, tfNome.getText());
            ps.setFloat(2, Float.parseFloat(tfPreco.getText()));
            ps.setInt(3, Integer.parseInt(tfCodigo.getText()));
            
            //Verificação dos campos obrigatória
            if (tfNome.getText().isEmpty()||tfPreco.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Favor preencher os campos obrigatórios");
                
            }
            // A estrutura abaixo é utilizada para confirmar a alteração dos dados do produto na tabela
            int a = ps.executeUpdate();
            if (a > 0){
                JOptionPane.showMessageDialog(null, "Dados do produto alterados com sucesso!");
                tfNome.setText(null);
                tfPreco.setText(null);
                tfCodigo.setText(null);
                
                
            }
            else {
                JOptionPane.showMessageDialog(null, "Não foi possível adicionar!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    //O método abaixo deleta dados de produtos cadastrados
    private void Deletar(){
        int confirma = JOptionPane.showConfirmDialog(null, "Você está certo disso?","Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION){
            String sql = "delete from mercadoria where codmercadoria = ?";
            try {
                //Comando de preparação da conexão com o banco de dados
                ps = conexao.prepareStatement(sql);
                ps.setInt(3, Integer.parseInt(tfCodigo.getText()));
                ps.executeUpdate();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else if (confirma == JOptionPane.NO_OPTION){
            
        }
                       
    }
    
    
    
    
    
    
    public CadastraProduto() {
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

        lblNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        tfPreco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setClosable(true);

        lblNome.setText("Informe o Nome do Produto:");

        lblPreco.setText("Informe o Preço do Produto:");

        jLabel1.setText("Informe o Código do Produto:");

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNome))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPreco)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btCadastrar)
                        .addGap(2, 2, 2)
                        .addComponent(btExcluir)
                        .addGap(2, 2, 2)
                        .addComponent(btAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btConsultar)
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addGap(128, 128, 128))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btConsultar)
                    .addComponent(btAtualizar)
                    .addComponent(btExcluir))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
       Consultar();
    }//GEN-LAST:event_btConsultarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        Alterar();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        Adicionar();
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
       Deletar();
    }//GEN-LAST:event_btExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPreco;
    // End of variables declaration//GEN-END:variables
}
