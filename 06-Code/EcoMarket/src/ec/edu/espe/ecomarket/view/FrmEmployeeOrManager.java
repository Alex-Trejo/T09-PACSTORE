/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.espe.ecomarket.view;

import ec.edu.espe.ecomarket.controller.SoundPlayer;

/**
 *
 * @author Carlos Torres, T09_PACSTORE, DCCO-ESPE
 */
public class FrmEmployeeOrManager extends javax.swing.JFrame {

    /**
     * Creates new form FrmEmployeeOrManager
     */
    public FrmEmployeeOrManager() {
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

        btnEmployee = new javax.swing.JButton();
        btnManager = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEmployee.setBackground(new java.awt.Color(204, 102, 0));
        btnEmployee.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btnEmployee.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployee.setText("Click");
        btnEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEmployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEmployeeMouseExited(evt);
            }
        });
        btnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 165, 180, 150));

        btnManager.setBackground(new java.awt.Color(204, 102, 0));
        btnManager.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnManager.setForeground(new java.awt.Color(255, 255, 255));
        btnManager.setText("Click");
        btnManager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnManagerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnManagerMouseExited(evt);
            }
        });
        btnManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagerActionPerformed(evt);
            }
        });
        getContentPane().add(btnManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 170, 150));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/ecomarket/images/flecha60x60.png"))); // NOI18N
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 330, 60, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/ecomarket/images/EorM.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeActionPerformed
        // TODO add your handling code here:
        FrmLoginEmployee login = new FrmLoginEmployee();
        login.setVisible(true);
        this.setVisible(false);
        SoundPlayer.playSound("click.wav");
    }//GEN-LAST:event_btnEmployeeActionPerformed

    private void btnManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagerActionPerformed
        // TODO add your handling code here:
        FrmLoginManager login = new FrmLoginManager();
        login.setVisible(true);
        this.setVisible(false);
        SoundPlayer.playSound("click.wav");
    }//GEN-LAST:event_btnManagerActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        FrmSubmission login = new FrmSubmission();
        login.setVisible(true);
        this.setVisible(false);
        SoundPlayer.playSound("click.wav");
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnEmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeMouseEntered
        // TODO add your handling code here:
        btnEmployee.setOpaque(true);
        btnEmployee.setContentAreaFilled(true);
        btnEmployee.setBorderPainted(true);
        SoundPlayer.playSound("mouseEntered.wav");
    }//GEN-LAST:event_btnEmployeeMouseEntered

    private void btnEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeMouseExited
        // TODO add your handling code here:
        transparentButton(false);

    }//GEN-LAST:event_btnEmployeeMouseExited

    private void btnManagerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagerMouseEntered
        // TODO add your handling code here:
        btnManager.setOpaque(true);
        btnManager.setContentAreaFilled(true);
        btnManager.setBorderPainted(true);
        SoundPlayer.playSound("mouseEntered.wav");
    }//GEN-LAST:event_btnManagerMouseEntered

    private void btnManagerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagerMouseExited
        // TODO add your handling code here:
        transparentButton(false);

    }//GEN-LAST:event_btnManagerMouseExited

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        // TODO add your handling code here:
        SoundPlayer.playSound("mouseEntered.wav");
    }//GEN-LAST:event_btnBackMouseEntered

    public void transparentButton(boolean button) {

        btnEmployee.setOpaque(button);
        btnEmployee.setContentAreaFilled(button);
        btnEmployee.setBorderPainted(button);

        btnManager.setOpaque(button);
        btnManager.setContentAreaFilled(button);
        btnManager.setBorderPainted(button);

        btnBack.setOpaque(button);
        btnBack.setContentAreaFilled(button);
        btnBack.setBorderPainted(button);
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
            java.util.logging.Logger.getLogger(FrmEmployeeOrManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEmployeeOrManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEmployeeOrManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEmployeeOrManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEmployeeOrManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEmployee;
    private javax.swing.JButton btnManager;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
