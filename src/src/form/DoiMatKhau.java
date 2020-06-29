/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import form.*;
import dao.Account;
import dao.AccountDAO;
import dao.SinhVienDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pojo.Sinhvien;

/**
 *
 * @author Chen-Yang
 */
public class DoiMatKhau extends javax.swing.JFrame {

    /**
     * Creates new form DoiMatKhau
     */
    Account accTemp;
    
    public DoiMatKhau() {
    }
    public DoiMatKhau(Account acc) {
        accTemp = new Account();
        accTemp = acc;
        //System.out.println("usename: "+acc.getTenDN());
        initComponents();
        setDefaultCloseOperation(DoiMatKhau.DISPOSE_ON_CLOSE);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMatKhauCu = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtMatKhauMoi = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtMatKhauMoi_ = new javax.swing.JPasswordField();
        btnDoiMK = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐỔI MẬT KHẨU");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Mật khẩu cũ:");

        txtMatKhauCu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Mật khẩu mới:");

        txtMatKhauMoi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMatKhauMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauMoiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Nhập lại mật khẩu mới:");

        txtMatKhauMoi_.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMatKhauMoi_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauMoi_ActionPerformed(evt);
            }
        });

        btnDoiMK.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnDoiMK.setText("Đổi mật khẩu");
        btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMatKhauCu, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMatKhauMoi_, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatKhauCu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatKhauMoi_, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(btnDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        setSize(new java.awt.Dimension(529, 315));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMatKhauMoi_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauMoi_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauMoi_ActionPerformed

    private void txtMatKhauMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauMoiActionPerformed

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        String path = "data/gvAccount.csv";
        String path_ = "data/svAccount.csv";
        
        
        if(txtMatKhauCu.getText().equals("") || txtMatKhauMoi.getText().equals("") || txtMatKhauMoi_.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane,"Bạn cần nhập đầy đủ thông tin");
        }
        else if(accTemp.getMatKhau().compareTo(txtMatKhauCu.getText())!=0) {
            JOptionPane.showMessageDialog(rootPane,"Bạn cần nhập đúng mật khẩu");
        }
        
        else if(txtMatKhauMoi.getText().compareTo(txtMatKhauMoi_.getText())!=0) {
            JOptionPane.showMessageDialog(rootPane,"Bạn cần nhập lại mật khẩu mới cho đúng");
        }
        
        else {
                if(accTemp.getTenDN().compareTo("giaovu")==0) {
                    accTemp.setMatKhau(txtMatKhauMoi.getText());
                    List<Account> ds = new ArrayList<Account>();
                    ds.add(accTemp);
                    if(AccountDAO.GhiAccount(path, ds)==true) {
                        JOptionPane.showMessageDialog(rootPane,"Đổi mật khẩu thành công"); 
                    }
                }
                else {
                    
                    try {
                        List<Account> dsAccount_=AccountDAO.DocAccount(path_);
                        Sinhvien svMK = new Sinhvien();
                        for(int i=0;i<dsAccount_.size();i++) {
                            if(accTemp.getTenDN().compareTo(dsAccount_.get(i).getTenDN())==0) {
                                dsAccount_.get(i).setMatKhau(txtMatKhauMoi.getText());
                                svMK = SinhVienDAO.layThongTinSinhVien(accTemp.getTenDN());
                            }
                            
                        }
                        if(AccountDAO.GhiAccount(path_, dsAccount_)==true) {
                            svMK.setMatKhau(txtMatKhauMoi.getText());
                            SinhVienDAO.capNhatThongTinSinhVien(svMK);
                            JOptionPane.showMessageDialog(rootPane,"Đổi mật khẩu thành công"); 
                        }
                        else {
                            JOptionPane.showMessageDialog(rootPane,"Vui lòng thử lại"); 
                        }
                        
//                    try {
//                        List<Account> dsAcc =  AccountDAO.DocAccount(path_);
//                        if(AccountDAO.Search(accTemp, dsAcc)==true) {
//                            for(int i=0;i<dsAcc.size();i++) {
//                                
//                            }
//                            if(AccountDAO.GhiAccount(path_, dsAcc)==true) {
//                                JOptionPane.showMessageDialog(rootPane,"Đổi mật khẩu thành công"); 
//                            }
//                            else {
//                                JOptionPane.showMessageDialog(rootPane,"Vui lòng thử lại"); 
//                            }
//                        }
//                    } catch (IOException ex) {
//                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                    } catch (IOException ex) {
                        Logger.getLogger(DoiMatKhau.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
           
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoiMKActionPerformed

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
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoiMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField txtMatKhauCu;
    private javax.swing.JPasswordField txtMatKhauMoi;
    private javax.swing.JPasswordField txtMatKhauMoi_;
    // End of variables declaration//GEN-END:variables

 
}