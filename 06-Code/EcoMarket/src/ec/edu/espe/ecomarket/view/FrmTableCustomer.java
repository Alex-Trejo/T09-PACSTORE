package ec.edu.espe.ecomarket.view;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.ecomarket.controller.Connection;
import ec.edu.espe.ecomarket.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.text.*;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable.PrintMode;
import org.bson.Document;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Reishel Tipan, PACSTORE, DCCO-ESPE
 */
public class FrmTableCustomer extends javax.swing.JFrame {

    public class centerFrame extends javax.swing.JFrame {

        public centerFrame() {
            initComponents();

            setLocationRelativeTo(null);
        }
    }

    /**
     * Creates new form FrmTableCustomer
     */
    public FrmTableCustomer() {
        initComponents();
    }

    public void loadCustomersTable() {

        CodecRegistry codecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoDatabase db = Connection.mongodb.withCodecRegistry(codecRegistry);
        MongoCollection<Customer> collectionCustomers = db.getCollection("customers", Customer.class);
        List<Customer> customers = collectionCustomers.find(new Document(), Customer.class).into(new ArrayList<Customer>());

        Object[][] objects = new Object[customers.size()][6];

        for (int i = 0; i < customers.size(); i++) {
            objects[i][0] = customers.get(i).getIdentificationCard();
            objects[i][1] = customers.get(i).getName();
            objects[i][2] = customers.get(i).getNumber();
            objects[i][3] = customers.get(i).isPendingPayment();
            objects[i][4] = customers.get(i).getAppointment();
            objects[i][5] = customers.get(i).getAddress();

            tableCustomers.setModel(new javax.swing.table.DefaultTableModel(
                    objects,
                    new String[]{
                        "Cédula", "Nombre", "Número", "Pago", "Cita", "Dirección"
                    }
            ));

        }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomers = new javax.swing.JTable();
        btnLoad = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnPrintCustomers = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Número", "Pago pendiente", "Cita", "Direccion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableCustomers);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 787, 160));

        btnLoad.setText("Cargar");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });
        jPanel1.add(btnLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 352, -1, 30));

        btnBack.setText("Volver");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, -1, 30));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel2.setText("Clientes");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 220, -1));

        btnPrintCustomers.setText("Imprimir tabla");
        btnPrintCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintCustomersActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrintCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed

        loadCustomersTable();

    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        FrmHuertoEcoMarketMenu frmStylesirelia;
        frmStylesirelia = new FrmHuertoEcoMarketMenu();
        frmStylesirelia.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnPrintCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintCustomersActionPerformed

        boolean complete;
        MessageFormat headerFormat = new MessageFormat("Customers");
        MessageFormat footerFormat = new MessageFormat("- Página {0} -");
        try {
            tableCustomers.print(PrintMode.FIT_WIDTH, headerFormat, footerFormat);
            complete = true;
        } catch (PrinterException ex) {
            Logger.getLogger(FrmTablePosition.class.getName()).log(Level.SEVERE, null, ex);
            complete = false;
        }
        
        if (complete) {
            System.out.println("---print finished!--");
             JOptionPane.showMessageDialog(rootPane, "La impresión fue exitosa.");
        } else {
            System.out.println("---Error printing---");
            JOptionPane.showMessageDialog(rootPane, "Ocurrio un error.");
        }
    }//GEN-LAST:event_btnPrintCustomersActionPerformed

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
            java.util.logging.Logger.getLogger(FrmTableCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTableCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTableCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTableCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTableCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLoad;
    private javax.swing.JToggleButton btnPrintCustomers;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCustomers;
    // End of variables declaration//GEN-END:variables
}
