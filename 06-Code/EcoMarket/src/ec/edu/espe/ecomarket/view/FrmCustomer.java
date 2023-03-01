package ec.edu.espe.ecomarket.view;

import com.toedter.calendar.JDateChooser;
import ec.edu.espe.ecomarket.controller.CustomerController;
import ec.edu.espe.ecomarket.controller.Connection;
import ec.edu.espe.ecomarket.model.Customer;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author Alex Trejo, PACSTORE, DCCO-ESPE
 */
public class FrmCustomer extends javax.swing.JFrame {

    public class centerFrame extends javax.swing.JFrame {

        public centerFrame() {
            initComponents();

            setLocationRelativeTo(null);
        }
    }

    SimpleDateFormat formDate = new SimpleDateFormat("dd-MM-yyyy");
    private CustomerController customerController;
    public String getDate(JDateChooser jdDate) {
        if (jdDate.getDate() != null) {
            return formDate.format(jdDate.getDate());
        } else {
            return null;
        }

    }

    /**
     * Creates new form FrmCustomer
     */
    public FrmCustomer() {
        initComponents();
        Connection.connectionDataBase();
        customerController = new CustomerController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnBackToMenu = new javax.swing.JButton();
        cmbPayment = new javax.swing.JComboBox<>();
        txtNumber = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtDateService = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Cedula");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel1.setText("Cliente");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jLabel3.setText("Nombre");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 117, -1, -1));

        jLabel4.setText("Número");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 167, -1, -1));

        jLabel5.setText("Falta Pagar");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 225, -1, -1));

        jLabel6.setText("Fecha");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 279, -1, -1));

        jLabel7.setText("Dirección");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 323, -1, -1));

        btnAdd.setText("Crear");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel3.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel3.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, -1, -1));

        btnBackToMenu.setText("Volver al Menu");
        btnBackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToMenuActionPerformed(evt);
            }
        });
        jPanel3.add(btnBackToMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, -1, -1));

        cmbPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pagado", "Falta pagar" }));
        jPanel3.add(cmbPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 222, 256, -1));

        txtNumber.setBorder(null);
        txtNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumberKeyTyped(evt);
            }
        });
        jPanel3.add(txtNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 167, 256, -1));

        txtName.setBorder(null);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });
        jPanel3.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 117, 256, -1));

        txtId.setToolTipText("");
        txtId.setBorder(null);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });
        jPanel3.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 63, 256, -1));

        txtAddress.setBorder(null);
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAddressKeyTyped(evt);
            }
        });
        jPanel3.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 323, 256, -1));

        txtDateService.setMinSelectableDate(new java.util.Date(1658210469000L));
        jPanel3.add(txtDateService, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 273, 256, -1));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 85, 256, 10));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 136, 256, 10));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 189, 256, 10));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 345, 256, 10));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/HuertoEcoMarketIcon.jpeg"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, -20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        String identificationCard;
        String name;
        int number;
        boolean pendigPayment;
        String appointment;
        String address;

        identificationCard = txtId.getText();
        name = txtName.getText();
        number = Integer.parseInt(txtNumber.getText());
        pendigPayment = false;
        appointment = formDate.format(txtDateService.getDate());
        address = txtAddress.getText();

        Customer customer = new Customer(identificationCard, name, number, false, appointment, address);
        
        customerController.create(customerController.buildDocument(customer));
        Document result = customerController.read(customerController.buildDocument(customer));
        if (result!=null) {
            JOptionPane.showMessageDialog(null, "Creado con exito");
        }else{
            JOptionPane.showMessageDialog(null, "Hubo un problema reintente");
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String identificationCard;
        String name;
        int number;
        boolean pendigPayment;
        String appointment;
        String address;

        identificationCard = txtId.getText();
        name = txtName.getText();
        number = Integer.parseInt(txtNumber.getText());
        pendigPayment = false;
        appointment = formDate.format(txtDateService.getDate());
        address = txtAddress.getText();

        Customer customer = new Customer(identificationCard, name, number, false, appointment, address);

        customerController.read(identificationCard, "identificationCard");

        txtId.setText(identificationCard);
        txtName.setText(name);

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnBackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToMenuActionPerformed
        FrmHuertoEcoMarketMenu frmStylesirelia;
        frmStylesirelia = new FrmHuertoEcoMarketMenu();
        frmStylesirelia.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackToMenuActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        String value = txtId.getText();
        int legth = value.length(); //saca la longitud del string
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txtId.setEditable(true);
            if (legth >= 10) {

                JOptionPane.showMessageDialog(this, "Id must have 10 digits", "Warning", JOptionPane.WARNING_MESSAGE);
                txtId.setText("");

            }
        } else {
            JOptionPane.showMessageDialog(this, "Enter only numbers", "Warning", JOptionPane.WARNING_MESSAGE);
            txtId.setText("");
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        char validateLetters = evt.getKeyChar();
        if (Character.isDigit(validateLetters)) {
            evt.consume();
            JOptionPane.showMessageDialog(txtName, "Enter only letters", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumberKeyTyped
        String value = txtNumber.getText();
        int legth = value.length(); //saca la longitud del string
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txtNumber.setEditable(true);
            if (legth >= 10) {

                JOptionPane.showMessageDialog(this, "Number must have 10 digits", "Warning", JOptionPane.WARNING_MESSAGE);
                txtNumber.setText("");

            }
        } else {
            JOptionPane.showMessageDialog(this, "Enter only numbers", "Warning", JOptionPane.WARNING_MESSAGE);
            txtNumber.setText("");
        }
    }//GEN-LAST:event_txtNumberKeyTyped

    private void txtAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyTyped
       char validar = evt.getKeyChar();
        if(Character.isDigit(validar)){
            getToolkit().beep();
            
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras \n Enter only letters");}
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressKeyTyped

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
            java.util.logging.Logger.getLogger(FrmCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBackToMenu;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbPayment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField txtAddress;
    private com.toedter.calendar.JDateChooser txtDateService;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}
