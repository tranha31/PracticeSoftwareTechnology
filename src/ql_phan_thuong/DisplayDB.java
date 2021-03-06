/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_phan_thuong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author dinh
 */
public class DisplayDB extends javax.swing.JFrame {

    /**
     * Creates new form DisplayDB
     */
    public DisplayDB() {
        initComponents();
        showChiTiet();
    }
    
    final String url = "jdbc:mysql://localhost/homework1_db";
    final String user = "root";
    final String password = "";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        QuayLai = new javax.swing.JButton();
        TheoSuKien = new javax.swing.JButton();
        TheoGiaDinh = new javax.swing.JButton();
        ChiTiet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        QuayLai.setText("Quay lại");
        QuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuayLaiActionPerformed(evt);
            }
        });

        TheoSuKien.setText("Theo sự kiện");
        TheoSuKien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TheoSuKienActionPerformed(evt);
            }
        });

        TheoGiaDinh.setText("Theo gia đình");
        TheoGiaDinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TheoGiaDinhActionPerformed(evt);
            }
        });

        ChiTiet.setText("Chi tiết");
        ChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChiTietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(QuayLai)
                        .addGap(91, 91, 91)
                        .addComponent(TheoSuKien)
                        .addGap(100, 100, 100)
                        .addComponent(TheoGiaDinh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ChiTiet))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuayLai)
                    .addComponent(TheoSuKien)
                    .addComponent(TheoGiaDinh)
                    .addComponent(ChiTiet))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TheoSuKienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TheoSuKienActionPerformed
        // TODO add your handling code here:
        showTheoSuKien();
    }//GEN-LAST:event_TheoSuKienActionPerformed

    private void TheoGiaDinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TheoGiaDinhActionPerformed
        // TODO add your handling code here:
        showTheoGiaDinh();
    }//GEN-LAST:event_TheoGiaDinhActionPerformed

    private void ChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChiTietActionPerformed
        // TODO add your handling code here:
        showChiTiet();
    }//GEN-LAST:event_ChiTietActionPerformed

    private void QuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuayLaiActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_QuayLaiActionPerformed

    public void showChiTiet(){
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            
            String sql = "SELECT Event.Name AS 'Tên sự kiện', Event.Year AS 'Năm', "
                    + "Recipient.Name AS 'Người nhận', Gift.Gift_Name AS Quà, Receive_Gift.Quantity AS 'Số lượng', "
                    + "Achievement.Achievement_Name AS 'Thành tích' "
                    + "FROM Event, Receive_Gift, Recipient, Gift, Achievement "
                    + "WHERE Event.ID = Receive_Gift.ID_Event "
                    + "AND Recipient.ID = Receive_Gift.ID_Recipient "
                    + "AND Gift.ID = Receive_Gift.ID_Gift "
                    + "AND Achievement.ID = Receive_Gift.ID_Achievement";
            //System.out.println("11111");
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    public void showTheoGiaDinh(){
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "SELECT Family.Father AS 'Họ tên Bố', Family.Mother AS 'Họ tên Mẹ', "
                    + "Gift.Gift_Name AS 'Quà', SUM(Gift.Cost) AS 'Giá', SUM(Receive_Gift.Quantity) AS 'Số lượng' "
                    + "FROM Family, Recipient, Receive_Gift, Gift "
                    + "WHERE Family.ID = Recipient.ID_Family "
                    + "AND Receive_Gift.ID_Recipient = Recipient.ID "
                    + "AND Receive_Gift.ID_Gift = Gift.ID "
                    + "GROUP BY Family.ID";
            //System.out.println("22222");
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    public void showTheoSuKien(){
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "SELECT Event.Name AS 'Tên sự kiện', Event.Year AS Năm,"
                    + " Gift.Gift_Name AS Quà, Gift.Cost AS Giá, Receive_Gift.Quantity AS 'Số lượng'"
                    + "FROM Event, Receive_Gift, Gift "
                    + "WHERE Event.ID = Receive_Gift.ID_Event "
                    + "AND Gift.ID = Receive_Gift.ID_Gift "
                    + "GROUP BY Event.ID, Gift.ID";
            //System.out.println("33333");
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
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
            java.util.logging.Logger.getLogger(DisplayDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayDB().setVisible(true);
            }
        });
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChiTiet;
    private javax.swing.JButton QuayLai;
    private javax.swing.JButton TheoGiaDinh;
    private javax.swing.JButton TheoSuKien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
