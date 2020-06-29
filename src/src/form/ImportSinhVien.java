/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import dao.SinhVienDAO;
import java.awt.Font;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import pojo.*;

/**
 *
 * @author Chen-Yang
 */
public class ImportSinhVien extends javax.swing.JFrame  {
    private String filePath;
    /**
     * Creates new form ImportSinhVien
     */
    public ImportSinhVien()  {
        initComponents();
        setDefaultCloseOperation(ImportSinhVien.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        lblImport = new javax.swing.JLabel();
        txtImport = new javax.swing.JTextField();
        btnChonFile = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Import Sinh Viên");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImport.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblImport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImport.setText("IMPORT SINH VIÊN");
        getContentPane().add(lblImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 343, 31));

        txtImport.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImportActionPerformed(evt);
            }
        });
        getContentPane().add(txtImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 397, 33));

        btnChonFile.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnChonFile.setText("Chọn file");
        btnChonFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonFileActionPerformed(evt);
            }
        });
        getContentPane().add(btnChonFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 116, 35));

        btnImport.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnImport.setText("Import");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });
        getContentPane().add(btnImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 92, -1));

        setSize(new java.awt.Dimension(683, 225));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnChonFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonFileActionPerformed
        JFileChooser c = new JFileChooser("data");
        int rVal = c.showOpenDialog(null);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            String filename = c.getSelectedFile().getName();
            String dir = c.getCurrentDirectory().toString();
            filePath = dir+"\\"+filename;
            txtImport.setText(filePath);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChonFileActionPerformed

    private void txtImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImportActionPerformed
        JOptionPane.showConfirmDialog(rootPane, filePath);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImportActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        if(filePath==null) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn file");
        }
        else {
            try {
                if(SinhVienDAO.themDanhSachSinhVien(filePath)==true) {
                    
                    
                    JOptionPane.showMessageDialog(rootPane, "Import danh sách lớp thành công");
                }
            } catch (IOException ex) {
                Logger.getLogger(ImportSinhVien.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.exit(0); 
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImportActionPerformed

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
            java.util.logging.Logger.getLogger(ImportSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImportSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonFile;
    private javax.swing.JButton btnImport;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblImport;
    private javax.swing.JTextField txtImport;
    // End of variables declaration//GEN-END:variables
}
