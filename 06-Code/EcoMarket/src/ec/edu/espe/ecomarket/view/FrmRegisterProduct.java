package ec.edu.espe.ecomarket.view;

import ec.edu.espe.ecomarket.controller.FileManager;
import ec.edu.espe.ecomarket.model.Product;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author Alex Trejo, PACSTORE, DCCO-ESPE
 */
public class FrmRegisterProduct extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form FrmProduct
     */
    public FrmRegisterProduct() {
        initComponents();
        model.addColumn("Name");
        model.addColumn("Unit price");
        model.addColumn("Amount");
        this.jTable1.setModel(model);
    }

    private void addToTable(Product product) {
        //Product product = new Product();
        product.setName(txtName.getText());
        product.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));
        product.setAmount(Integer.valueOf(txtQuantity.getText()));

        Object[] dataProduct = new Object[4];
        dataProduct[0] = product.getName();
        dataProduct[1] = product.getUnitPrice();
        dataProduct[2] = product.getAmount();
        model.addRow(dataProduct);

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
        txtName = new javax.swing.JTextField();
        txtUnitPrice = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 60, 60));

        txtName.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 239, -1));
        getContentPane().add(txtUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 239, -1));

        btnFind.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        getContentPane().add(btnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 130, 50));
        getContentPane().add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 239, -1));

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
        jScrollPane3.setViewportView(jTable1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 520, 110));

        btnSave.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 110, 40));

        btnUpdate.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 349, 110, 40));

        btnDelete.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 349, 110, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/ecomarket/images/RegisterProduct.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        validateName();
        Product enteredProduct = new Product();
        Product product = new Product();
        String name = txtName.getText();
        enteredProduct.setName(name);

        System.out.println("name->" + enteredProduct.getName());

        product = FileManager.findproduct(enteredProduct);

        txtQuantity.setText(String.valueOf(product.getAmount()));

        txtUnitPrice.setText(String.valueOf(product.getUnitPrice()));

        addToTable(enteredProduct);


    }//GEN-LAST:event_btnFindActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        validateDataProduct();
        Product enteredProduct = new Product();

        enteredProduct.setName(txtName.getText());
        enteredProduct.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));
        enteredProduct.setAmount(Integer.valueOf(txtQuantity.getText()));

        FileManager.saveProduct(enteredProduct);

        emptyFields();

        FrmActionsOfTheManager fmrActionsOfTheManager = new FrmActionsOfTheManager();
        fmrActionsOfTheManager.setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:

        String nameInitial = name();
        validateName();
        Product enteredProduct = new Product();
        String name = txtName.getText();
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        int amount = Integer.valueOf(txtQuantity.getText());
        enteredProduct.setName(name);
        enteredProduct.setAmount(amount);
        enteredProduct.setUnitPrice(unitPrice);

        FileManager.updateProduct(nameInitial, enteredProduct);

        emptyFields();

        //addToTable();
        FrmActionsOfTheManager fmrActionsOfTheManager = new FrmActionsOfTheManager();
        fmrActionsOfTheManager.setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        validateName();

        Product enteredProduct = new Product();
        String name = txtName.getText();
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        int amount = Integer.valueOf(txtQuantity.getText());
        enteredProduct.setName(name);
        enteredProduct.setAmount(amount);
        enteredProduct.setUnitPrice(unitPrice);

        FileManager.eraseProduct(enteredProduct);

        emptyFields();

        FrmActionsOfTheManager fmrActionsOfTheManager = new FrmActionsOfTheManager();
        fmrActionsOfTheManager.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        FrmActionsOfTheManager login = new FrmActionsOfTheManager();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private String name() {
        String name = txtName.getText();
        return name;
    }

    private void emptyFields() {

        txtName.setText("");
        txtUnitPrice.setText("");
        txtQuantity.setText("");

    }

    public void validateDataProduct() throws HeadlessException {
        // TODO add your handling code here:

        if (txtName.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "You must enter the product name");
        }

        if (txtUnitPrice.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "You must enter the unit product");
        }

        if (txtQuantity.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "You must enter the Amount product");
        }

        try {
            if ((Integer.valueOf(txtQuantity.getText())) % 2 != 0) {
                JOptionPane.showMessageDialog(null, "Enter a valid quantity");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter a valid quantity");
        }

    }

    public void validateName() throws HeadlessException {
        // TODO add your handling code here:

        if (txtName.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "You must enter the product name");
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
            java.util.logging.Logger.getLogger(FrmRegisterProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegisterProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegisterProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegisterProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegisterProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables
}
