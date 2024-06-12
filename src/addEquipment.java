
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class addEquipment extends javax.swing.JFrame {

    hsoinventorymanagement hsoinventory = new hsoinventorymanagement();
    Date date = new Date();

    public addEquipment() {
        initComponents();
        inv_equip_date.setMinSelectableDate(date);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inv_equip_infopanel = new javax.swing.JPanel();
        inv_equip_name = new javax.swing.JTextField();
        inv_equip_itemLabel = new javax.swing.JLabel();
        inv_equip_expiry = new javax.swing.JTextField();
        inv_equip_yearexpiryLabel = new javax.swing.JLabel();
        inv_equip_date = new com.toedter.calendar.JDateChooser();
        inv_equip_dateLabel = new javax.swing.JLabel();
        inv_equip_equipmentLabel = new javax.swing.JLabel();
        inv_equip_inventoryLabel = new javax.swing.JLabel();
        inv_equip_quantity = new javax.swing.JSpinner();
        inv_equip_quantityLabel = new javax.swing.JLabel();
        inv_equip_quantityLabel1 = new javax.swing.JLabel();
        inv_equip_dispensed = new javax.swing.JSpinner();
        inv_equip_txt = new javax.swing.JScrollPane();
        inv_equip_remark = new javax.swing.JTextArea();
        inv_equip_remarkLabel = new javax.swing.JLabel();
        inv_equip_insertbtn = new javax.swing.JButton();
        homebar = new javax.swing.JPanel();
        minimizeButton = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        inv_equipLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        inv_equip_infopanel.setBackground(new java.awt.Color(53, 64, 142));
        inv_equip_infopanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 215, 83), 4));

        inv_equip_name.setBackground(new java.awt.Color(255, 255, 255));
        inv_equip_name.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_equip_name.setForeground(new java.awt.Color(0, 0, 0));
        inv_equip_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inv_equip_name.setToolTipText("EX: 2021-123456");

        inv_equip_itemLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        inv_equip_itemLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_itemLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_itemLabel.setText("ITEM NAME:");

        inv_equip_expiry.setBackground(new java.awt.Color(255, 255, 255));
        inv_equip_expiry.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_equip_expiry.setForeground(new java.awt.Color(0, 0, 0));
        inv_equip_expiry.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inv_equip_expiry.setToolTipText("EX: 2021-123456");

        inv_equip_yearexpiryLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        inv_equip_yearexpiryLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_yearexpiryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_yearexpiryLabel.setText("ITEM EXPIRY:");

        inv_equip_date.setBackground(new java.awt.Color(255, 255, 255));
        inv_equip_date.setForeground(new java.awt.Color(0, 0, 0));
        inv_equip_date.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        inv_equip_dateLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        inv_equip_dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_dateLabel.setText("DATE:");

        inv_equip_equipmentLabel.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        inv_equip_equipmentLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_equipmentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_equipmentLabel.setText("EQUIPMENT");

        inv_equip_inventoryLabel.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        inv_equip_inventoryLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_inventoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_inventoryLabel.setText("INVENTORY");

        inv_equip_quantity.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_equip_quantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        inv_equip_quantityLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        inv_equip_quantityLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_quantityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_quantityLabel.setText("TOTAL QUANTITY:");

        inv_equip_quantityLabel1.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        inv_equip_quantityLabel1.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_quantityLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_quantityLabel1.setText("ITEM DISPENSED:");

        inv_equip_dispensed.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_equip_dispensed.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        inv_equip_remark.setBackground(new java.awt.Color(255, 255, 255));
        inv_equip_remark.setColumns(20);
        inv_equip_remark.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_equip_remark.setForeground(new java.awt.Color(0, 0, 0));
        inv_equip_remark.setLineWrap(true);
        inv_equip_remark.setRows(5);
        inv_equip_remark.setWrapStyleWord(true);
        inv_equip_txt.setViewportView(inv_equip_remark);

        inv_equip_remarkLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        inv_equip_remarkLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_remarkLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_remarkLabel.setText("REMARKS:");

        inv_equip_insertbtn.setBackground(new java.awt.Color(51, 102, 0));
        inv_equip_insertbtn.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        inv_equip_insertbtn.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_insertbtn.setText("INSERT");
        inv_equip_insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inv_equip_insertbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inv_equip_infopanelLayout = new javax.swing.GroupLayout(inv_equip_infopanel);
        inv_equip_infopanel.setLayout(inv_equip_infopanelLayout);
        inv_equip_infopanelLayout.setHorizontalGroup(
            inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inv_equip_txt)
                    .addComponent(inv_equip_equipmentLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inv_equip_inventoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                        .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inv_equip_quantity)
                            .addComponent(inv_equip_quantityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inv_equip_quantityLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(inv_equip_dispensed)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_equip_infopanelLayout.createSequentialGroup()
                        .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inv_equip_name)
                            .addComponent(inv_equip_itemLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inv_equip_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inv_equip_dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(inv_equip_remarkLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
            .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inv_equip_expiry)
                            .addComponent(inv_equip_yearexpiryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
                    .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(inv_equip_insertbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inv_equip_infopanelLayout.setVerticalGroup(
            inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(inv_equip_equipmentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_equip_inventoryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                        .addComponent(inv_equip_itemLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inv_equip_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                        .addComponent(inv_equip_dateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inv_equip_date, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(inv_equip_yearexpiryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_equip_expiry, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                        .addComponent(inv_equip_quantityLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inv_equip_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                        .addComponent(inv_equip_quantityLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inv_equip_dispensed, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addComponent(inv_equip_remarkLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_equip_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addGap(77, 77, 77)
                .addComponent(inv_equip_insertbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        homebar.setBackground(new java.awt.Color(255, 255, 255));
        homebar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 215, 83), 4));

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minus.png"))); // NOI18N
        minimizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
        });

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close (2).png"))); // NOI18N
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        inv_equipLabel.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        inv_equipLabel.setForeground(new java.awt.Color(0, 0, 0));
        inv_equipLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equipLabel.setText("INSERT NEW EQUIPMENT");

        javax.swing.GroupLayout homebarLayout = new javax.swing.GroupLayout(homebar);
        homebar.setLayout(homebarLayout);
        homebarLayout.setHorizontalGroup(
            homebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homebarLayout.createSequentialGroup()
                .addComponent(inv_equipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton)
                .addContainerGap())
        );
        homebarLayout.setVerticalGroup(
            homebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minimizeButton))
                .addContainerGap(13, Short.MAX_VALUE))
            .addComponent(inv_equipLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(inv_equip_infopanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(homebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 733, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 55, Short.MAX_VALUE)
                    .addComponent(inv_equip_infopanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((JLabel) evt.getSource());
        frame.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        dispose();
    }//GEN-LAST:event_exitButtonMouseClicked

    private void inv_equip_insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_equip_insertbtnActionPerformed

        String url, user, pass, query;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement st = con.prepareStatement("INSERT INTO equipment_inventory(eq_date, eq_item, eq_quantity, eq_disposed, eq_expiry, eq_remarks) VALUES (?,?,?,?,?,?)");

            Date equip_date = inv_equip_date.getDate();
            String formattedDate;

            if (equip_date != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                formattedDate = sdf.format(equip_date);
            } else {
                formattedDate = "";
            }

            if (inv_equip_date.getDate() == null) {
                JOptionPane.showMessageDialog(new JFrame(), "Date added of item is required to proceed.", "ERROR: Date.", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(inv_equip_name.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Item name is required to proceed.", "ERROR: Item Name.", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(inv_equip_quantity.getValue())) {
                JOptionPane.showMessageDialog(new JFrame(), "Item quantity is required to proceed.", "ERROR: Item Quantity.", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(inv_equip_dispensed.getValue())) {
                JOptionPane.showMessageDialog(new JFrame(), "Item quantity is required to proceed.", "ERROR: Item Quantity.", JOptionPane.ERROR_MESSAGE);
            } else {
                int eq_quantity = (int) inv_equip_quantity.getValue();
                int eq_disposed = (int) inv_equip_dispensed.getValue();
                String eq_item = inv_equip_name.getText().toUpperCase();
                String eq_remarks = inv_equip_remark.getText();
                String eq_expiry = inv_equip_expiry.getText();
                int eq_totalquantity = (int) inv_equip_quantity.getValue();

                query = "INSERT INTO equipment_inventory (eq_date, eq_item, eq_quantity, eq_disposed, eq_expiry, eq_remarks, eq_totalquantity) " + "VALUES ('" + formattedDate + "', '" + eq_item + "', '" + eq_quantity + "', '" + eq_disposed + "', '" + eq_expiry + "' , '" + eq_remarks + "', '" + eq_totalquantity + "')";
                st.executeUpdate(query);

                inv_equip_date.setDate(null);
                inv_equip_name.setText("");
                inv_equip_expiry.setText("");
                inv_equip_remark.setText("");
                inv_equip_quantity.setValue(0);
                inv_equip_dispensed.setValue(0);

                JOptionPane.showMessageDialog(null, "Equipment successfully added to inventory!", "Success!", JOptionPane.INFORMATION_MESSAGE);

                hsoinventory.eq_loadData();
                
                dispose();
                
                con.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }//GEN-LAST:event_inv_equip_insertbtnActionPerformed

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
            java.util.logging.Logger.getLogger(addMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addMedicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitButton;
    private javax.swing.JPanel homebar;
    private javax.swing.JLabel inv_equipLabel;
    private com.toedter.calendar.JDateChooser inv_equip_date;
    private javax.swing.JLabel inv_equip_dateLabel;
    private javax.swing.JSpinner inv_equip_dispensed;
    private javax.swing.JLabel inv_equip_equipmentLabel;
    private javax.swing.JTextField inv_equip_expiry;
    private javax.swing.JPanel inv_equip_infopanel;
    private javax.swing.JButton inv_equip_insertbtn;
    private javax.swing.JLabel inv_equip_inventoryLabel;
    private javax.swing.JLabel inv_equip_itemLabel;
    private javax.swing.JTextField inv_equip_name;
    private javax.swing.JSpinner inv_equip_quantity;
    private javax.swing.JLabel inv_equip_quantityLabel;
    private javax.swing.JLabel inv_equip_quantityLabel1;
    private javax.swing.JTextArea inv_equip_remark;
    private javax.swing.JLabel inv_equip_remarkLabel;
    private javax.swing.JScrollPane inv_equip_txt;
    private javax.swing.JLabel inv_equip_yearexpiryLabel;
    private javax.swing.JLabel minimizeButton;
    // End of variables declaration//GEN-END:variables
}
