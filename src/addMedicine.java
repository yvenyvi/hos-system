
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class addMedicine extends javax.swing.JFrame {

    hsoinventorymanagement hsoinventory = new hsoinventorymanagement();
    Date date = new Date();

    public addMedicine() {
        initComponents();
        inv_med_date.setMinSelectableDate(date);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inv_med_infopanel = new javax.swing.JPanel();
        inv_med_itemLabel = new javax.swing.JLabel();
        inv_med_name = new javax.swing.JTextField();
        inv_med_expiryLabel = new javax.swing.JLabel();
        inv_med_dateLabel = new javax.swing.JLabel();
        inv_med_date = new com.toedter.calendar.JDateChooser();
        inv_med_quantityLabel = new javax.swing.JLabel();
        inv_med_remarkLabel = new javax.swing.JLabel();
        inv_med_txt = new javax.swing.JScrollPane();
        inv_med_remark = new javax.swing.JTextArea();
        inv_med_inventoryLabel = new javax.swing.JLabel();
        inv_med_medicineLabel = new javax.swing.JLabel();
        inv_med_insertbtn = new javax.swing.JButton();
        inv_med_expiryLabel1 = new javax.swing.JLabel();
        inv_med_year = new com.toedter.calendar.JYearChooser();
        inv_med_month = new com.toedter.calendar.JMonthChooser();
        inv_med_disposedLabel = new javax.swing.JLabel();
        inv_med_dispensed = new javax.swing.JSpinner();
        inv_med_quantity = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        minimizeButton = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        inv_med_medicineLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        inv_med_infopanel.setBackground(new java.awt.Color(53, 64, 142));
        inv_med_infopanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 215, 83), 4));

        inv_med_itemLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        inv_med_itemLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_itemLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_itemLabel.setText("ITEM NAME:");

        inv_med_name.setBackground(new java.awt.Color(255, 255, 255));
        inv_med_name.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_med_name.setForeground(new java.awt.Color(0, 0, 0));
        inv_med_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inv_med_name.setToolTipText("EX: Biogesic");

        inv_med_expiryLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        inv_med_expiryLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_expiryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_expiryLabel.setText("ITEM YEAR EXPIRY:");

        inv_med_dateLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        inv_med_dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_dateLabel.setText("DATE:");

        inv_med_date.setBackground(new java.awt.Color(255, 255, 255));
        inv_med_date.setForeground(new java.awt.Color(0, 0, 0));
        inv_med_date.setDateFormatString("yyyy-MM-dd");
        inv_med_date.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        inv_med_quantityLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        inv_med_quantityLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_quantityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_quantityLabel.setText("TOTAL QUANTITY:");

        inv_med_remarkLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        inv_med_remarkLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_remarkLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_remarkLabel.setText("REMARKS:");

        inv_med_remark.setBackground(new java.awt.Color(255, 255, 255));
        inv_med_remark.setColumns(20);
        inv_med_remark.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_med_remark.setForeground(new java.awt.Color(0, 0, 0));
        inv_med_remark.setLineWrap(true);
        inv_med_remark.setRows(5);
        inv_med_remark.setWrapStyleWord(true);
        inv_med_txt.setViewportView(inv_med_remark);

        inv_med_inventoryLabel.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        inv_med_inventoryLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_inventoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_inventoryLabel.setText("INVENTORY");

        inv_med_medicineLabel.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        inv_med_medicineLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_medicineLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_medicineLabel.setText("MEDICINE");

        inv_med_insertbtn.setBackground(new java.awt.Color(51, 102, 0));
        inv_med_insertbtn.setFont(new java.awt.Font("Monospaced", 0, 21)); // NOI18N
        inv_med_insertbtn.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_insertbtn.setText("INSERT");
        inv_med_insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inv_med_insertbtnActionPerformed(evt);
            }
        });

        inv_med_expiryLabel1.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        inv_med_expiryLabel1.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_expiryLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_expiryLabel1.setText("ITEM MONTH EXPIRY:");

        inv_med_month.setForeground(new java.awt.Color(0, 0, 0));
        inv_med_month.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        inv_med_disposedLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        inv_med_disposedLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_disposedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_disposedLabel.setText("ITEM DISPENSED:");

        inv_med_dispensed.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_med_dispensed.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        inv_med_quantity.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_med_quantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout inv_med_infopanelLayout = new javax.swing.GroupLayout(inv_med_infopanel);
        inv_med_infopanel.setLayout(inv_med_infopanelLayout);
        inv_med_infopanelLayout.setHorizontalGroup(
            inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_med_infopanelLayout.createSequentialGroup()
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inv_med_infopanelLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(inv_med_insertbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inv_med_infopanelLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(inv_med_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_med_infopanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inv_med_remarkLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_med_infopanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inv_med_quantityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inv_med_quantity)
                    .addComponent(inv_med_year, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inv_med_expiryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inv_med_name)
                    .addComponent(inv_med_itemLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inv_med_infopanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(inv_med_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_med_infopanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(inv_med_dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inv_med_disposedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inv_med_expiryLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inv_med_dispensed, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inv_med_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33))))
            .addGroup(inv_med_infopanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inv_med_inventoryLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inv_med_medicineLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        inv_med_infopanelLayout.setVerticalGroup(
            inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_med_infopanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(inv_med_medicineLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_med_inventoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inv_med_dateLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inv_med_itemLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inv_med_date, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inv_med_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_med_infopanelLayout.createSequentialGroup()
                        .addComponent(inv_med_expiryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inv_med_year, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_med_infopanelLayout.createSequentialGroup()
                        .addComponent(inv_med_expiryLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inv_med_month, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inv_med_disposedLabel)
                    .addComponent(inv_med_quantityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inv_med_dispensed, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inv_med_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(inv_med_remarkLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_med_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(inv_med_insertbtn)
                .addGap(40, 40, 40))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 215, 83), 4));

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimize-sign (1).png"))); // NOI18N
        minimizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
        });

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit (1).png"))); // NOI18N
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        inv_med_medicineLabel1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        inv_med_medicineLabel1.setForeground(new java.awt.Color(0, 0, 0));
        inv_med_medicineLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_medicineLabel1.setText("INSERT NEW MEDICINE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(inv_med_medicineLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minimizeButton))
                .addContainerGap(13, Short.MAX_VALUE))
            .addComponent(inv_med_medicineLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(inv_med_infopanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 739, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 46, Short.MAX_VALUE)
                    .addComponent(inv_med_infopanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inv_med_insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_med_insertbtnActionPerformed

        String url, user, pass, query;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement st = con.prepareStatement("INSERT INTO medicine_inventory(md_date, md_item, md_quantity, md_disposed, md_year_expiry, md_month_expiry, md_remarks) VALUES (?,?,?,?,?,?,?)");

            Date med_date = inv_med_date.getDate();
            String formattedDate;

            if (med_date != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                formattedDate = sdf.format(med_date);
            } else {
                formattedDate = "";
            }

            if (inv_med_date.getDate() == null) {
                JOptionPane.showMessageDialog(new JFrame(), "Date added of item is required to proceed.", "ERROR: Date.", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(inv_med_year.getValue())) {
                JOptionPane.showMessageDialog(new JFrame(), "Year of Expiry of the item is required to proceed.", "ERROR: Item Expiry.", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(inv_med_month.getMonth())) {
                JOptionPane.showMessageDialog(new JFrame(), "Year of Expiry of the item is required to proceed.", "ERROR: Item Expiry.", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(inv_med_name.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Item name is required to proceed.", "ERROR: Item Name.", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(inv_med_quantity.getValue())) {
                JOptionPane.showMessageDialog(new JFrame(), "Item quantity is required to proceed.", "ERROR: Item Quantity.", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(inv_med_dispensed.getValue())) {
                JOptionPane.showMessageDialog(new JFrame(), "Item dispensed is required to proceed.", "ERROR: Item Quantity.", JOptionPane.ERROR_MESSAGE);
            } else {
                int md_quantity = (int) inv_med_quantity.getValue();
                int md_disposed = (int) inv_med_dispensed.getValue();
                String md_item = inv_med_name.getText().toUpperCase();
                int md_year = inv_med_year.getYear();
                int md_month = inv_med_month.getMonth();
                String md_remarks = inv_med_remark.getText();
                int md_totalquantity = (int) inv_med_quantity.getValue();

                query = "INSERT INTO medicine_inventory (md_date, md_item, md_quantity, md_disposed, md_year_expiry, md_month_expiry, md_remarks, md_totalquantity) " + "VALUES ('" + formattedDate + "', '" + md_item + "', '" + md_quantity + "','" + md_disposed + "', '" + md_year + "','" + md_month + "' , '" + md_remarks + "', '" + md_totalquantity + "')";

                st.executeUpdate(query);

                inv_med_date.setDate(null);
                inv_med_name.setText("");
                inv_med_year.setValue(2024);
                inv_med_month.setMonth(0);
                inv_med_remark.setText("");
                inv_med_quantity.setValue(0);

                JOptionPane.showMessageDialog(null, "Medicine successfully added to inventory!", "Success!", JOptionPane.INFORMATION_MESSAGE);

                hsoinventory.loadData();

                con.close();
                
                dispose();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }//GEN-LAST:event_inv_med_insertbtnActionPerformed

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((JLabel) evt.getSource());
        frame.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        dispose();
    }//GEN-LAST:event_exitButtonMouseClicked

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
    private com.toedter.calendar.JDateChooser inv_med_date;
    private javax.swing.JLabel inv_med_dateLabel;
    private javax.swing.JSpinner inv_med_dispensed;
    private javax.swing.JLabel inv_med_disposedLabel;
    private javax.swing.JLabel inv_med_expiryLabel;
    private javax.swing.JLabel inv_med_expiryLabel1;
    private javax.swing.JPanel inv_med_infopanel;
    private javax.swing.JButton inv_med_insertbtn;
    private javax.swing.JLabel inv_med_inventoryLabel;
    private javax.swing.JLabel inv_med_itemLabel;
    private javax.swing.JLabel inv_med_medicineLabel;
    private javax.swing.JLabel inv_med_medicineLabel1;
    private com.toedter.calendar.JMonthChooser inv_med_month;
    private javax.swing.JTextField inv_med_name;
    private javax.swing.JSpinner inv_med_quantity;
    private javax.swing.JLabel inv_med_quantityLabel;
    private javax.swing.JTextArea inv_med_remark;
    private javax.swing.JLabel inv_med_remarkLabel;
    private javax.swing.JScrollPane inv_med_txt;
    private com.toedter.calendar.JYearChooser inv_med_year;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel minimizeButton;
    // End of variables declaration//GEN-END:variables
}
