
import java.awt.event.KeyEvent;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class deleteEquipment extends javax.swing.JFrame {

    hsoinventorymanagement hsoinventory = new hsoinventorymanagement();
    Date date = new Date();

    public deleteEquipment() {
        initComponents();
        inv_equip_date.setMinSelectableDate(date);
    }

    private String username;
    
    deleteEquipment(String username) {
        this();
        this.username = username;
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
        inv_equip_txt = new javax.swing.JScrollPane();
        inv_equip_remark = new javax.swing.JTextArea();
        inv_equip_remarkLabel = new javax.swing.JLabel();
        inv_eq_searchID = new javax.swing.JTextField();
        inv_equip_quantityLabel2 = new javax.swing.JLabel();
        inv_equip_deletebtn = new javax.swing.JButton();
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
        inv_equip_date.setDateFormatString("yyyy-MM-dd");
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

        inv_eq_searchID.setBackground(new java.awt.Color(255, 255, 255));
        inv_eq_searchID.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_eq_searchID.setForeground(new java.awt.Color(0, 0, 0));
        inv_eq_searchID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inv_eq_searchID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inv_eq_searchIDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inv_eq_searchIDKeyReleased(evt);
            }
        });

        inv_equip_quantityLabel2.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        inv_equip_quantityLabel2.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_quantityLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_quantityLabel2.setText("SEARCH ID:");

        inv_equip_deletebtn.setBackground(new java.awt.Color(51, 102, 0));
        inv_equip_deletebtn.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        inv_equip_deletebtn.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_deletebtn.setText("DELETE");
        inv_equip_deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inv_equip_deletebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inv_equip_infopanelLayout = new javax.swing.GroupLayout(inv_equip_infopanel);
        inv_equip_infopanel.setLayout(inv_equip_infopanelLayout);
        inv_equip_infopanelLayout.setHorizontalGroup(
            inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                        .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inv_equip_equipmentLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inv_equip_inventoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_equip_infopanelLayout.createSequentialGroup()
                                .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inv_equip_name)
                                    .addComponent(inv_equip_itemLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inv_equip_date, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(inv_equip_dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(33, 33, 33))
                    .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                        .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inv_equip_yearexpiryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(inv_equip_expiry))
                        .addGap(18, 18, 18)
                        .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inv_equip_quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(inv_equip_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inv_equip_remarkLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inv_equip_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)))
                    .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inv_eq_searchID)
                            .addComponent(inv_equip_quantityLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inv_equip_deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        inv_equip_infopanelLayout.setVerticalGroup(
            inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_equip_infopanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(20, 20, 20)
                .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inv_equip_yearexpiryLabel)
                    .addComponent(inv_equip_quantityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inv_equip_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inv_equip_expiry, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inv_equip_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(inv_equip_remarkLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_equip_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(inv_equip_quantityLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_eq_searchID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_equip_deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
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
                .addGap(0, 661, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 56, Short.MAX_VALUE)
                    .addComponent(inv_equip_infopanel, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void inv_eq_searchIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inv_eq_searchIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if ("".equals(inv_eq_searchID.getText())) {
                JOptionPane.showMessageDialog(null, "Input a valid Equipment id number to proceed.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
            } else {
                String url, user, pass, ID;
                int notFound = 0;

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    url = "jdbc:MySQL://localhost:3306/hso_database";
                    user = "root";
                    pass = "";

                    Connection con = DriverManager.getConnection(url, user, pass);
                    Statement st = con.createStatement();

                    ID = inv_eq_searchID.getText();
                    if ("".equals(ID)) {
                        JOptionPane.showMessageDialog(new JFrame(), "ID of the equipment is required to proceed.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String sql = "SELECT * FROM equipment_inventory WHERE eq_id = " + ID;
                        ResultSet rs = st.executeQuery(sql);

                        while (rs.next()) {                            
                            inv_equip_name.setText(rs.getString("eq_item"));
                            inv_equip_date.setDate(rs.getDate("eq_date"));
                            inv_equip_expiry.setText(rs.getString("eq_expiry"));
                            inv_equip_quantity.setValue(rs.getInt("eq_totalquantity"));                            
                            inv_equip_remark.setText(rs.getString("eq_remarks"));
                            notFound = 1;
                            JOptionPane.showMessageDialog(null, "Equipment selected.", "INFORM: Selected", JOptionPane.INFORMATION_MESSAGE);
                        }
                        if (notFound == 0) {
                            JOptionPane.showMessageDialog(new JFrame(), "Invalid ID. Please select from the table.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_inv_eq_searchIDKeyPressed

    private void inv_eq_searchIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inv_eq_searchIDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_inv_eq_searchIDKeyReleased

    private void inv_equip_deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_equip_deletebtnActionPerformed
        Date date = inv_equip_date.getDate();
        String formattedDate;
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            formattedDate = sdf.format(date);
        } else {
            formattedDate = "";
        }
        String url, user, pass, ID, op;
        int notFound = 0;
        op = username;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            url = "jdbc:mysql://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            ID = inv_eq_searchID.getText();
            if ("".equals(ID)) {
                JOptionPane.showMessageDialog(new JFrame(), "Equipment ID is required to proceed.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
            } else {

                if ("".equals(inv_eq_searchID.getText())) {
                    JOptionPane.showMessageDialog(null, "Equipment ID required to proceed.", "Error: ID", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String sql = "SELECT * FROM equipment_inventory WHERE eq_id = " + ID;
                    ResultSet rs = st.executeQuery(sql);

                    if (rs.next()) {
                        notFound = 1;

                        sql = "INSERT INTO removed_equipment (added_by, eq_id, eq_date, eq_item, eq_quantity, eq_expiry, eq_remarks, eq_totalquantity) VALUES (?,?,?,?,?,?,?,?)";
                        PreparedStatement pst = con.prepareStatement(sql);
                        pst.setString(1, op);
                        pst.setString(2, ID);
                        pst.setString(3, formattedDate);
                        pst.setString(4, inv_equip_name.getText());
                        pst.setInt(5, (int) inv_equip_quantity.getValue());                       
                        pst.setString(6, inv_equip_expiry.getText());
                        pst.setString(7, inv_equip_remark.getText());
                        pst.setInt(8, (int) inv_equip_quantity.getValue());
                        pst.executeUpdate();

                        sql = "DELETE FROM equipment_inventory WHERE eq_id = " + ID;
                        st.executeUpdate(sql);

                        inv_equip_name.setText("");
                        inv_equip_expiry.setText("");
                        inv_equip_remark.setText("");
                        inv_equip_quantity.setValue(0);

                        inv_eq_searchID.setText("");

                        JOptionPane.showMessageDialog(new JFrame(), "Selected ID of equipment removed from inventory.", "UPDATE: ID", JOptionPane.INFORMATION_MESSAGE);

                        hsoinventory.removed_equipsLoadData();
                        hsoinventory.eq_loadData();

                        con.close();
                        
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid ID. Please select from the table.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }//GEN-LAST:event_inv_equip_deletebtnActionPerformed

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
    private javax.swing.JTextField inv_eq_searchID;
    private javax.swing.JLabel inv_equipLabel;
    private com.toedter.calendar.JDateChooser inv_equip_date;
    private javax.swing.JLabel inv_equip_dateLabel;
    private javax.swing.JButton inv_equip_deletebtn;
    private javax.swing.JLabel inv_equip_equipmentLabel;
    private javax.swing.JTextField inv_equip_expiry;
    private javax.swing.JPanel inv_equip_infopanel;
    private javax.swing.JLabel inv_equip_inventoryLabel;
    private javax.swing.JLabel inv_equip_itemLabel;
    private javax.swing.JTextField inv_equip_name;
    private javax.swing.JSpinner inv_equip_quantity;
    private javax.swing.JLabel inv_equip_quantityLabel;
    private javax.swing.JLabel inv_equip_quantityLabel2;
    private javax.swing.JTextArea inv_equip_remark;
    private javax.swing.JLabel inv_equip_remarkLabel;
    private javax.swing.JScrollPane inv_equip_txt;
    private javax.swing.JLabel inv_equip_yearexpiryLabel;
    private javax.swing.JLabel minimizeButton;
    // End of variables declaration//GEN-END:variables
}
