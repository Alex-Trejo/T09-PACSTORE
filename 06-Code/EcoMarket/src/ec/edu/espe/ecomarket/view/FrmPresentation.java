/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.espe.ecomarket.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Alex Trejo, PACSTORE, DCCO-ESPE
 */
public class FrmPresentation extends javax.swing.JFrame {

    /**
     * Creates new form FrmPresentation
     */
    public FrmPresentation() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnlInput = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniManagement = new javax.swing.JMenuItem();
        mniEmployee = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EcoMarketSystem");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("EcoMarketSystem");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(java.awt.SystemColor.textHighlight);

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("BIENVENIDO AL SISTEMA DE GESTION DE HUERTO ECO MARKET");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(206, 206, 206))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 40));

        jpnlInput.setBackground(new java.awt.Color(255, 255, 255));
        jpnlInput.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jpnlInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 990, 360));

        jMenuBar1.setToolTipText("EcoMarket");
        jMenuBar1.setEnabled(false);

        jMenu1.setText("Ingresar");

        mniManagement.setText("Administrador");
        mniManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniManagementActionPerformed(evt);
            }
        });
        jMenu1.add(mniManagement);

        mniEmployee.setText("Empleado");
        mniEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEmployeeActionPerformed(evt);
            }
        });
        jMenu1.add(mniEmployee);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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

    private void mniManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniManagementActionPerformed
        // TODO add your handling code here:
        FrmLoginManager frmManager= new FrmLoginManager();
        frmManager.setVisible(true);
        this.setVisible(false);
        


    }//GEN-LAST:event_mniManagementActionPerformed

    private void mniEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEmployeeActionPerformed
        // TODO add your handling code here:
        FrmLoginEmployee frmLoginEmployee= new FrmLoginEmployee();
        frmLoginEmployee.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniEmployeeActionPerformed

    private void showPanel(FrmLoginManager p) {
        p.setSize(900, 550);
        p.setLocation(0, 0);

        jpnlInput.removeAll();
        jpnlInput.add(p, BorderLayout.CENTER);
        jpnlInput.revalidate();
        jpnlInput.repaint();
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
            java.util.logging.Logger.getLogger(FrmPresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPresentation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPresentation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jpnlInput;
    private javax.swing.JMenuItem mniEmployee;
    private javax.swing.JMenuItem mniManagement;
    // End of variables declaration//GEN-END:variables
}
