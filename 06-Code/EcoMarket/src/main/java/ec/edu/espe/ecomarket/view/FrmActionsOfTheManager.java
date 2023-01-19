/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.espe.ecomarket.view;

/**
 *
 * @author David Toapanta, Pacstore, DCCO-ESPE
 */
public class FrmActionsOfTheManager extends javax.swing.JFrame {

    /**
     * Creates new form FmrActionsOfTheManager
     */
    public FrmActionsOfTheManager() {
        initComponents();
        transparentButton(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        btnRegisterProduct = new javax.swing.JButton();
        btnEmployeeS = new javax.swing.JButton();
        btnSaleRecords = new javax.swing.JButton();
        btnInventory = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setIcon(new javax.swing.ImageIcon("C:\\Users\\ALEXANDER\\Desktop\\Alexander programa\\EcoMarket\\src\\main\\java\\ec\\edu\\espe\\ecomarket\\images\\flecha60x60.png")); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 60, 60));

        btnRegisterProduct.setText("Register products");
        btnRegisterProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegisterProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegisterProductMouseExited(evt);
            }
        });
        btnRegisterProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterProductActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegisterProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 130, 40));

        btnEmployeeS.setText("About System");
        btnEmployeeS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmployeeSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEmployeeSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEmployeeSMouseExited(evt);
            }
        });
        getContentPane().add(btnEmployeeS, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 130, 40));

        btnSaleRecords.setText("Sale Record");
        btnSaleRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaleRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaleRecordsMouseExited(evt);
            }
        });
        btnSaleRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleRecordsActionPerformed(evt);
            }
        });
        getContentPane().add(btnSaleRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 130, 40));

        btnInventory.setText("Inventory");
        btnInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInventoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInventoryMouseExited(evt);
            }
        });
        btnInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryActionPerformed(evt);
            }
        });
        getContentPane().add(btnInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 130, 40));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ALEXANDER\\Desktop\\Alexander programa\\EcoMarket\\src\\main\\java\\ec\\edu\\espe\\ecomarket\\images\\Actions for the manager.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 180, 400));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ALEXANDER\\Desktop\\Alexander programa\\EcoMarket\\src\\main\\java\\ec\\edu\\espe\\ecomarket\\images\\Actions for the manager.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 0, 530, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterProductActionPerformed
        // TODO add your handling code here:
        FrmRegisterProduct registerProduct = new FrmRegisterProduct();
        registerProduct.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnRegisterProductActionPerformed

    private void btnInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryActionPerformed
        // TODO add your handling code here:
        FrmInventory login = new FrmInventory();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnInventoryActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        FrmEmployeeOrManager login = new FrmEmployeeOrManager();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaleRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleRecordsActionPerformed
        // TODO add your handling code here:
        FrmSaleRecord login = new FrmSaleRecord();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSaleRecordsActionPerformed

    private void btnRegisterProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterProductMouseEntered
        // TODO add your handling code here:
        btnRegisterProduct.setOpaque(true);
        btnRegisterProduct.setContentAreaFilled(true);
        btnRegisterProduct.setBorderPainted(true);
    }//GEN-LAST:event_btnRegisterProductMouseEntered

    private void btnRegisterProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterProductMouseExited
        // TODO add your handling code here:
        transparentButton(false);
    }//GEN-LAST:event_btnRegisterProductMouseExited

    private void btnInventoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventoryMouseEntered
        // TODO add your handling code here:
        btnInventory.setOpaque(true);
        btnInventory.setContentAreaFilled(true);
        btnInventory.setBorderPainted(true);
    }//GEN-LAST:event_btnInventoryMouseEntered

    private void btnInventoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventoryMouseExited
        transparentButton(false);
    }//GEN-LAST:event_btnInventoryMouseExited

    private void btnSaleRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaleRecordsMouseEntered
        // TODO add your handling code here:
        btnSaleRecords.setOpaque(true);
        btnSaleRecords.setContentAreaFilled(true);
        btnSaleRecords.setBorderPainted(true);
    }//GEN-LAST:event_btnSaleRecordsMouseEntered

    private void btnSaleRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaleRecordsMouseExited
        // TODO add your handling code here:
        transparentButton(false);
    }//GEN-LAST:event_btnSaleRecordsMouseExited

    private void btnEmployeeSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeSMouseEntered
        // TODO add your handling code here:
        btnEmployeeS.setOpaque(true);
        btnEmployeeS.setContentAreaFilled(true);
        btnEmployeeS.setBorderPainted(true);
    }//GEN-LAST:event_btnEmployeeSMouseEntered

    private void btnEmployeeSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeSMouseExited
        // TODO add your handling code here:
        transparentButton(false);
    }//GEN-LAST:event_btnEmployeeSMouseExited

    private void btnEmployeeSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeSMouseClicked
        // TODO add your handling code here:
        FrmAbout login = new FrmAbout();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnEmployeeSMouseClicked

    
    
    public void transparentButton(boolean button) {

        btnRegisterProduct.setOpaque(button);
        btnRegisterProduct.setContentAreaFilled(button);
        btnRegisterProduct.setBorderPainted(button);

        btnInventory.setOpaque(button);
        btnInventory.setContentAreaFilled(button);
        btnInventory.setBorderPainted(button);

        btnSaleRecords.setOpaque(button);
        btnSaleRecords.setContentAreaFilled(button);
        btnSaleRecords.setBorderPainted(button);

        btnEmployeeS.setOpaque(button);
        btnEmployeeS.setContentAreaFilled(button);
        btnEmployeeS.setBorderPainted(button);

        btnBack.setOpaque(button);
        btnBack.setContentAreaFilled(button);
        btnBack.setBorderPainted(button);
    }

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
            java.util.logging.Logger.getLogger(FrmActionsOfTheManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmActionsOfTheManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmActionsOfTheManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmActionsOfTheManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmActionsOfTheManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEmployeeS;
    private javax.swing.JButton btnInventory;
    private javax.swing.JButton btnRegisterProduct;
    private javax.swing.JButton btnSaleRecords;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
