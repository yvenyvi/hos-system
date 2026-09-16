package pages;


import java.awt.Dimension;
import java.awt.Point;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class hsoinventorymanagement extends javax.swing.JFrame {

    private String username;

    public hsoinventorymanagement() {
        initComponents();
        loadData();       
        removed_medsLoadData();
        removed_equipsLoadData();
        adjust_mdMedsColumn();
        adjust_mdDelMedsColumn();
        adjust_mdEquipmentColumn();
        adjust_mdDelEquipmentColumn();
        moveExpiredMedicines();
        sortExpiredMedicineByExpiry();
        sortMedicineByExpiry();   
        eq_sortEquipmentByDate();
        eq_sortDelEquipmentByDate();
    }

    hsoinventorymanagement(String username) {
        this();
        nameLabelMeds1.setText(username + "!");
        this.username = username;
    }

    private void sortMedicineByExpiry() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = util.Database.getConnection();
            String sql = "SELECT * FROM medicine_inventory ORDER BY md_expiry ASC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) inv_medTable.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String op = rs.getString("added_by");
                String med_id = rs.getString("md_id");
                String med_name = rs.getString("md_item");
                String totalquantity = rs.getString("md_totalquantity");
                String quantity = rs.getString("md_quantity");
                String disposed = rs.getString("md_disposed");
                String expiry_date = rs.getString("md_expiry");
                String date_added = rs.getString("md_date");
                String remarks = rs.getString("md_remarks");

                model.addRow(new Object[]{op, med_id, med_name, totalquantity, quantity, disposed, date_added, expiry_date, remarks});
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    private void sortExpiredMedicineByExpiry() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = util.Database.getConnection();
            String sql = "SELECT * FROM removed_medicine ORDER BY md_expiry DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) inv_recent_medtable.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String op = rs.getString("added_by");
                String med_id = rs.getString("md_id");
                String med_name = rs.getString("md_item");
                String totalquantity = rs.getString("md_totalquantity");
                String quantity = rs.getString("md_quantity");
                String disposed = rs.getString("md_dispensed");
                String expiry_date = rs.getString("md_expiry");
                String date_added = rs.getString("md_date");
                String remarks = rs.getString("md_remarks");

                model.addRow(new Object[]{op, med_id, med_name, totalquantity, quantity, disposed, date_added, expiry_date, remarks});
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    private void moveExpiredMedicines() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = util.Database.getConnection();

            // Get today's date
            Date currentDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(currentDate);

            String sql = "SELECT * FROM medicine_inventory WHERE md_expiry <= ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, today);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String op = rs.getString("added_by");
                String med_id = rs.getString("md_id");
                String med_name = rs.getString("md_item");
                String totalquantity = rs.getString("md_totalquantity");
                String quantity = rs.getString("md_quantity");
                String disposed = rs.getString("md_disposed");
                String expiry_date = rs.getString("md_expiry");
                String date_added = rs.getString("md_date");
                String remarks = rs.getString("md_remarks");

                // Insert into removed_medicine table
                sql = "INSERT INTO removed_medicine (added_by, md_id, md_item, md_totalquantity, md_quantity, md_dispensed, md_date, md_expiry,  md_remarks) VALUES (?,?,?,?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);

                pst.setString(1, op);
                pst.setString(2, med_id);
                pst.setString(3, med_name);
                pst.setString(4, totalquantity);
                pst.setString(5, quantity);
                pst.setString(6, disposed);
                pst.setString(7, expiry_date);
                pst.setString(8, date_added);
                pst.setString(9, remarks);
                pst.executeUpdate();

                // Delete from medicine_inventory table
                sql = "DELETE FROM medicine_inventory WHERE md_id = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, med_id);
                pst.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    public void eq_sortEquipmentByDate() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = util.Database.getConnection();
            Statement st = con.createStatement();

            DefaultTableModel invequipTable = (DefaultTableModel) inv_equipmentTable.getModel();

            String sql = "SELECT * FROM `equipment_inventory` ORDER BY `equipment_inventory`.`eq_date` DESC";
            ResultSet rs = st.executeQuery(sql);

            String item, remarks, op;
            int initialquantity, disposed, id, totalquantity;
            String date, expiry;

            while (rs.next()) {
                op = rs.getString("added_by");
                id = rs.getInt("eq_id");
                date = rs.getString("eq_date");
                item = rs.getString("eq_item");
                initialquantity = rs.getInt("eq_quantity");
                disposed = rs.getInt("eq_disposed");
                expiry = rs.getString("eq_expiry");
                remarks = rs.getString("eq_remarks");
                totalquantity = rs.getInt("eq_totalquantity");

                invequipTable.addRow(new Object[]{op, id, item, totalquantity, initialquantity, disposed, date, expiry, remarks});

            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    public void eq_sortDelEquipmentByDate() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = util.Database.getConnection();
            Statement st = con.createStatement();

            DefaultTableModel invequipTable = (DefaultTableModel) inv_equipmentTable.getModel();

            String sql = "SELECT * FROM `removed_equipment` ORDER BY `removed_equipment`.`eq_date` DESC";
            ResultSet rs = st.executeQuery(sql);

            String item, remarks, op;
            int initialquantity, disposed, id, totalquantity;
            String date, expiry;

            while (rs.next()) {
                op = rs.getString("added_by");
                id = rs.getInt("eq_id");
                date = rs.getString("eq_date");
                item = rs.getString("eq_item");
                initialquantity = rs.getInt("eq_quantity");
                disposed = rs.getInt("eq_dispensed");
                expiry = rs.getString("eq_expiry");
                remarks = rs.getString("eq_remarks");
                totalquantity = rs.getInt("eq_totalquantity");

                invequipTable.addRow(new Object[]{op, id, item, totalquantity, initialquantity, disposed, date, expiry, remarks});

            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        inv_frame = new javax.swing.JPanel();
        homebar = new javax.swing.JPanel();
        homeButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        eq_searchNameLabel = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        resizeButton = new javax.swing.JLabel();
        refreshButton = new javax.swing.JLabel();
        inv_searchName = new javax.swing.JTextField();
        inv_inventorymanager = new javax.swing.JTabbedPane();
        inv_medicine = new javax.swing.JPanel();
        inv_med_table = new javax.swing.JScrollPane();
        inv_medTable = new javax.swing.JTable();
        function = new javax.swing.JPanel();
        inv_med_medicineLabel = new javax.swing.JLabel();
        inv_med_insertbtn = new javax.swing.JButton();
        inv_med_updatebtn = new javax.swing.JButton();
        frommed = new javax.swing.JLabel();
        fromDate = new com.toedter.calendar.JDateChooser();
        tomed = new javax.swing.JLabel();
        toDate = new com.toedter.calendar.JDateChooser();
        searchDate = new javax.swing.JButton();
        exportMedicineTable = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        inv_equipment = new javax.swing.JPanel();
        inv_equip_table = new javax.swing.JScrollPane();
        inv_equipmentTable = new javax.swing.JTable();
        inv_equip_insertbtn = new javax.swing.JButton();
        inv_equip_equipmentLabel = new javax.swing.JLabel();
        inv_equip_updatebtn = new javax.swing.JButton();
        inv_equip_deletebtn = new javax.swing.JButton();
        fromequip = new javax.swing.JLabel();
        fromDate1 = new com.toedter.calendar.JDateChooser();
        toequip = new javax.swing.JLabel();
        toDate1 = new com.toedter.calendar.JDateChooser();
        searchDateEquip = new javax.swing.JButton();
        exportEquipmentTable = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        int_delmedicine = new javax.swing.JPanel();
        inv_med_table1 = new javax.swing.JScrollPane();
        inv_recent_medtable = new javax.swing.JTable();
        fromremoved = new javax.swing.JLabel();
        revFromDate = new com.toedter.calendar.JDateChooser();
        toremoved = new javax.swing.JLabel();
        revToDate = new com.toedter.calendar.JDateChooser();
        searchDateMedRemove = new javax.swing.JButton();
        exportRemovedMeds = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inv_med_medicineLabel1 = new javax.swing.JLabel();
        int_delequipments = new javax.swing.JPanel();
        inv_equip_table1 = new javax.swing.JScrollPane();
        inv_recent_equiptable = new javax.swing.JTable();
        fromremovedequip = new javax.swing.JLabel();
        revEquipFromDate = new com.toedter.calendar.JDateChooser();
        toremovedequip = new javax.swing.JLabel();
        revEquipToDate = new com.toedter.calendar.JDateChooser();
        searchDateEquipRemove = new javax.swing.JButton();
        exportRemovedEquip = new javax.swing.JLabel();
        inv_equip_equipmentLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dashboard1 = new javax.swing.JPanel();
        equipment4 = new javax.swing.JLabel();
        inventory4 = new javax.swing.JLabel();
        meds4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        welcomeLabel4 = new javax.swing.JLabel();
        nameLabelMeds1 = new javax.swing.JLabel();
        signout1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        inv_frame.setBackground(new java.awt.Color(255, 255, 255));

        homebar.setBackground(new java.awt.Color(255, 255, 255));

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home-button.png"))); // NOI18N
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButtonMouseClicked(evt);
            }
        });

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minus.png"))); // NOI18N
        minimizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
        });

        eq_searchNameLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        eq_searchNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        eq_searchNameLabel.setText("SEARCH MEDICINE/EQUIPMENT:");

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close (2).png"))); // NOI18N
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        resizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/resize.png"))); // NOI18N
        resizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resizeButtonMouseClicked(evt);
            }
        });

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reload.png"))); // NOI18N
        refreshButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
            }
        });

        inv_searchName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        inv_searchName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inv_searchNameKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout homebarLayout = new javax.swing.GroupLayout(homebar);
        homebar.setLayout(homebarLayout);
        homebarLayout.setHorizontalGroup(
            homebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homebarLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eq_searchNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_searchName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resizeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton)
                .addContainerGap())
        );
        homebarLayout.setVerticalGroup(
            homebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homebarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(homebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inv_searchName)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homebarLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(eq_searchNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(homebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(resizeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(minimizeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        inv_inventorymanager.setForeground(new java.awt.Color(255, 255, 255));

        inv_medicine.setBackground(new java.awt.Color(53, 64, 142));

        inv_medTable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        inv_medTable.setForeground(new java.awt.Color(0, 0, 0));
        inv_medTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ADDED BY", "ID", "ITEM", "TOTAL QUANTITY", "QUANTITY LEFT", "NO. DISPENSED", "DATE ADDED", "EXPIRY", "REMARKS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inv_medTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        inv_medTable.setRowHeight(40);
        inv_medTable.setSelectionBackground(new java.awt.Color(51, 102, 0));
        inv_medTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        inv_medTable.setShowGrid(false);
        inv_medTable.getTableHeader().setResizingAllowed(false);
        inv_medTable.getTableHeader().setReorderingAllowed(false);
        inv_med_table.setViewportView(inv_medTable);
        if (inv_medTable.getColumnModel().getColumnCount() > 0) {
            inv_medTable.getColumnModel().getColumn(0).setMinWidth(0);
            inv_medTable.getColumnModel().getColumn(0).setPreferredWidth(0);
            inv_medTable.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        function.setBackground(new java.awt.Color(53, 64, 142));

        inv_med_medicineLabel.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        inv_med_medicineLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_medicineLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_medicineLabel.setText("MEDICINE INVENTORY");

        inv_med_insertbtn.setBackground(new java.awt.Color(51, 102, 0));
        inv_med_insertbtn.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        inv_med_insertbtn.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_insertbtn.setText("ADD");
        inv_med_insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inv_med_insertbtnActionPerformed(evt);
            }
        });

        inv_med_updatebtn.setBackground(new java.awt.Color(51, 102, 0));
        inv_med_updatebtn.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        inv_med_updatebtn.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_updatebtn.setText("UPDATE");
        inv_med_updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inv_med_updatebtnActionPerformed(evt);
            }
        });

        frommed.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        frommed.setForeground(new java.awt.Color(255, 255, 255));
        frommed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frommed.setText("FROM:");
        frommed.setToolTipText("");
        frommed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        frommed.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        fromDate.setForeground(new java.awt.Color(0, 0, 0));
        fromDate.setDateFormatString("yyyy-MM-dd");
        fromDate.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        tomed.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        tomed.setForeground(new java.awt.Color(255, 255, 255));
        tomed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tomed.setText("TO:");
        tomed.setToolTipText("");
        tomed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tomed.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        toDate.setForeground(new java.awt.Color(0, 0, 0));
        toDate.setDateFormatString("yyyy-MM-dd");
        toDate.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        searchDate.setBackground(new java.awt.Color(51, 102, 0));
        searchDate.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        searchDate.setForeground(new java.awt.Color(255, 255, 255));
        searchDate.setText("SEARCH");
        searchDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDateActionPerformed(evt);
            }
        });

        exportMedicineTable.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        exportMedicineTable.setForeground(new java.awt.Color(255, 255, 255));
        exportMedicineTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exportMedicineTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/diskette (1).png"))); // NOI18N
        exportMedicineTable.setText("SAVE TABLE:");
        exportMedicineTable.setToolTipText("Export medicine inventory");
        exportMedicineTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportMedicineTable.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        exportMedicineTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportMedicineTableMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout functionLayout = new javax.swing.GroupLayout(function);
        function.setLayout(functionLayout);
        functionLayout.setHorizontalGroup(
            functionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inv_med_medicineLabel)
                .addGap(18, 18, 18)
                .addComponent(inv_med_insertbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_med_updatebtn)
                .addGap(108, 108, 108)
                .addComponent(frommed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tomed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportMedicineTable)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        functionLayout.setVerticalGroup(
            functionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(functionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(functionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(functionLayout.createSequentialGroup()
                        .addGroup(functionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(functionLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(tomed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(toDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(functionLayout.createSequentialGroup()
                        .addGroup(functionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(inv_med_medicineLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(functionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(functionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(searchDate)
                                    .addComponent(exportMedicineTable))
                                .addGroup(functionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fromDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, functionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(frommed, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inv_med_updatebtn)
                                        .addComponent(inv_med_insertbtn)))))
                        .addGap(0, 4, Short.MAX_VALUE))))
        );

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("SEE SYSTEM OPERATOR");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout inv_medicineLayout = new javax.swing.GroupLayout(inv_medicine);
        inv_medicine.setLayout(inv_medicineLayout);
        inv_medicineLayout.setHorizontalGroup(
            inv_medicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_medicineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inv_medicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inv_medicineLayout.createSequentialGroup()
                        .addComponent(inv_med_table)
                        .addContainerGap())
                    .addGroup(inv_medicineLayout.createSequentialGroup()
                        .addComponent(function, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(108, 108, 108))
                    .addGroup(inv_medicineLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        inv_medicineLayout.setVerticalGroup(
            inv_medicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_medicineLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(function, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(inv_med_table, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                .addContainerGap())
        );

        inv_inventorymanager.addTab("MEDICINE INVENTORY", inv_medicine);

        inv_equipment.setBackground(new java.awt.Color(53, 64, 142));

        inv_equipmentTable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        inv_equipmentTable.setForeground(new java.awt.Color(0, 0, 0));
        inv_equipmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ADDED BY", "ID", "ITEM", "TOTAL QUANTITY", "QUANTITY LEFT", "NO. DISPENSED", "DATE ADDED", "ITEM EXPIRY", "REMARKS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inv_equipmentTable.setRowHeight(40);
        inv_equipmentTable.setSelectionBackground(new java.awt.Color(51, 102, 0));
        inv_equipmentTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        inv_equipmentTable.setShowGrid(false);
        inv_equipmentTable.getTableHeader().setResizingAllowed(false);
        inv_equipmentTable.getTableHeader().setReorderingAllowed(false);
        inv_equip_table.setViewportView(inv_equipmentTable);
        if (inv_equipmentTable.getColumnModel().getColumnCount() > 0) {
            inv_equipmentTable.getColumnModel().getColumn(0).setMinWidth(0);
            inv_equipmentTable.getColumnModel().getColumn(0).setPreferredWidth(0);
            inv_equipmentTable.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        inv_equip_insertbtn.setBackground(new java.awt.Color(51, 102, 0));
        inv_equip_insertbtn.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        inv_equip_insertbtn.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_insertbtn.setText("INSERT");
        inv_equip_insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inv_equip_insertbtnActionPerformed(evt);
            }
        });

        inv_equip_equipmentLabel.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        inv_equip_equipmentLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_equipmentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_equipmentLabel.setText("EQUIPMENT INVENTORY");

        inv_equip_updatebtn.setBackground(new java.awt.Color(51, 102, 0));
        inv_equip_updatebtn.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        inv_equip_updatebtn.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_updatebtn.setText("UPDATE");
        inv_equip_updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inv_equip_updatebtnActionPerformed(evt);
            }
        });

        inv_equip_deletebtn.setBackground(new java.awt.Color(51, 102, 0));
        inv_equip_deletebtn.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        inv_equip_deletebtn.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_deletebtn.setText("DELETE");
        inv_equip_deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inv_equip_deletebtnActionPerformed(evt);
            }
        });

        fromequip.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        fromequip.setForeground(new java.awt.Color(255, 255, 255));
        fromequip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fromequip.setText("FROM:");
        fromequip.setToolTipText("");
        fromequip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fromequip.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        fromDate1.setForeground(new java.awt.Color(0, 0, 0));
        fromDate1.setDateFormatString("yyyy-MM-dd");
        fromDate1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        toequip.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        toequip.setForeground(new java.awt.Color(255, 255, 255));
        toequip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toequip.setText("TO:");
        toequip.setToolTipText("");
        toequip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toequip.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        toDate1.setForeground(new java.awt.Color(0, 0, 0));
        toDate1.setDateFormatString("yyyy-MM-dd");
        toDate1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        searchDateEquip.setBackground(new java.awt.Color(51, 102, 0));
        searchDateEquip.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        searchDateEquip.setForeground(new java.awt.Color(255, 255, 255));
        searchDateEquip.setText("SEARCH");
        searchDateEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDateEquipActionPerformed(evt);
            }
        });

        exportEquipmentTable.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        exportEquipmentTable.setForeground(new java.awt.Color(255, 255, 255));
        exportEquipmentTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exportEquipmentTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/diskette (1).png"))); // NOI18N
        exportEquipmentTable.setText("SAVE TABLE:");
        exportEquipmentTable.setToolTipText("Export equipment inventory");
        exportEquipmentTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportEquipmentTable.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        exportEquipmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportEquipmentTableMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("SEE SYSTEM OPERATOR");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout inv_equipmentLayout = new javax.swing.GroupLayout(inv_equipment);
        inv_equipment.setLayout(inv_equipmentLayout);
        inv_equipmentLayout.setHorizontalGroup(
            inv_equipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_equipmentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inv_equip_table)
                .addContainerGap())
            .addGroup(inv_equipmentLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(inv_equipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(inv_equipmentLayout.createSequentialGroup()
                        .addComponent(inv_equip_equipmentLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inv_equip_insertbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inv_equip_updatebtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inv_equip_deletebtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromequip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toequip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchDateEquip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exportEquipmentTable)))
                .addGap(0, 172, Short.MAX_VALUE))
        );
        inv_equipmentLayout.setVerticalGroup(
            inv_equipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_equipmentLayout.createSequentialGroup()
                .addGroup(inv_equipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inv_equipmentLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(inv_equipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(inv_equipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(inv_equip_insertbtn)
                                .addComponent(inv_equip_updatebtn)
                                .addComponent(inv_equip_deletebtn))
                            .addGroup(inv_equipmentLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(fromequip, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(inv_equip_equipmentLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(inv_equipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_equipmentLayout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addGroup(inv_equipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(toequip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exportEquipmentTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchDateEquip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_equipmentLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(inv_equipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fromDate1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                .addComponent(toDate1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_equip_table, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                .addContainerGap())
        );

        inv_inventorymanager.addTab("EQUIPMENT INVENTORY", inv_equipment);

        int_delmedicine.setBackground(new java.awt.Color(53, 64, 142));

        inv_recent_medtable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        inv_recent_medtable.setForeground(new java.awt.Color(0, 0, 0));
        inv_recent_medtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ADDED BY", "ID", "ITEM", "TOTAL QUANTITY", "QUANTITY LEFT", "NO. DISPENSED", "DATE ADDED", "EXPIRY", "REMARKS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inv_recent_medtable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        inv_recent_medtable.setRowHeight(40);
        inv_recent_medtable.setRowSelectionAllowed(false);
        inv_recent_medtable.setSelectionBackground(new java.awt.Color(51, 102, 0));
        inv_recent_medtable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        inv_recent_medtable.setShowGrid(false);
        inv_recent_medtable.getTableHeader().setResizingAllowed(false);
        inv_recent_medtable.getTableHeader().setReorderingAllowed(false);
        inv_med_table1.setViewportView(inv_recent_medtable);
        if (inv_recent_medtable.getColumnModel().getColumnCount() > 0) {
            inv_recent_medtable.getColumnModel().getColumn(0).setMinWidth(0);
            inv_recent_medtable.getColumnModel().getColumn(0).setPreferredWidth(0);
            inv_recent_medtable.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        fromremoved.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        fromremoved.setForeground(new java.awt.Color(255, 255, 255));
        fromremoved.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fromremoved.setText("FROM:");
        fromremoved.setToolTipText("");
        fromremoved.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fromremoved.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        revFromDate.setForeground(new java.awt.Color(0, 0, 0));
        revFromDate.setDateFormatString("yyyy-MM-dd");
        revFromDate.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        toremoved.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        toremoved.setForeground(new java.awt.Color(255, 255, 255));
        toremoved.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toremoved.setText("TO:");
        toremoved.setToolTipText("");
        toremoved.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toremoved.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        revToDate.setForeground(new java.awt.Color(0, 0, 0));
        revToDate.setDateFormatString("yyyy-MM-dd");
        revToDate.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        searchDateMedRemove.setBackground(new java.awt.Color(51, 102, 0));
        searchDateMedRemove.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        searchDateMedRemove.setForeground(new java.awt.Color(255, 255, 255));
        searchDateMedRemove.setText("SEARCH");
        searchDateMedRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDateMedRemoveActionPerformed(evt);
            }
        });

        exportRemovedMeds.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        exportRemovedMeds.setForeground(new java.awt.Color(255, 255, 255));
        exportRemovedMeds.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exportRemovedMeds.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/diskette (1).png"))); // NOI18N
        exportRemovedMeds.setText("SAVE TABLE:");
        exportRemovedMeds.setToolTipText("Export medicine inventory");
        exportRemovedMeds.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportRemovedMeds.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        exportRemovedMeds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportRemovedMedsMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("SEE SYSTEM OPERATOR");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        inv_med_medicineLabel1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        inv_med_medicineLabel1.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_medicineLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_medicineLabel1.setText("DELETED MEDICINE");

        javax.swing.GroupLayout int_delmedicineLayout = new javax.swing.GroupLayout(int_delmedicine);
        int_delmedicine.setLayout(int_delmedicineLayout);
        int_delmedicineLayout.setHorizontalGroup(
            int_delmedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(int_delmedicineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(int_delmedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(int_delmedicineLayout.createSequentialGroup()
                        .addComponent(inv_med_medicineLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 499, Short.MAX_VALUE)
                        .addComponent(fromremoved)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(revFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toremoved)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(revToDate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchDateMedRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exportRemovedMeds, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(int_delmedicineLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(int_delmedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(int_delmedicineLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(inv_med_table1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        int_delmedicineLayout.setVerticalGroup(
            int_delmedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(int_delmedicineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(int_delmedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(int_delmedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(exportRemovedMeds)
                        .addComponent(searchDateMedRemove))
                    .addComponent(revToDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(revFromDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(int_delmedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fromremoved, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inv_med_medicineLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(toremoved, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addContainerGap(699, Short.MAX_VALUE))
            .addGroup(int_delmedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, int_delmedicineLayout.createSequentialGroup()
                    .addContainerGap(61, Short.MAX_VALUE)
                    .addComponent(inv_med_table1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        inv_inventorymanager.addTab("DELETED MEDICINE", int_delmedicine);

        int_delequipments.setBackground(new java.awt.Color(53, 64, 142));

        inv_recent_equiptable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        inv_recent_equiptable.setForeground(new java.awt.Color(0, 0, 0));
        inv_recent_equiptable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ADDED BY", "ID", "ITEM", "TOTAL QUANTITY", "QUANTITY LEFT", "NO. DISPENSED", "DATE ADDED", "ITEM EXPIRY", "REMARKS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inv_recent_equiptable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        inv_recent_equiptable.setRowHeight(40);
        inv_recent_equiptable.setRowSelectionAllowed(false);
        inv_recent_equiptable.setSelectionBackground(new java.awt.Color(51, 102, 0));
        inv_recent_equiptable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        inv_recent_equiptable.setShowGrid(false);
        inv_recent_equiptable.getTableHeader().setResizingAllowed(false);
        inv_recent_equiptable.getTableHeader().setReorderingAllowed(false);
        inv_equip_table1.setViewportView(inv_recent_equiptable);
        if (inv_recent_equiptable.getColumnModel().getColumnCount() > 0) {
            inv_recent_equiptable.getColumnModel().getColumn(0).setMinWidth(0);
            inv_recent_equiptable.getColumnModel().getColumn(0).setPreferredWidth(0);
            inv_recent_equiptable.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        fromremovedequip.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        fromremovedequip.setForeground(new java.awt.Color(255, 255, 255));
        fromremovedequip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fromremovedequip.setText("FROM:");
        fromremovedequip.setToolTipText("");
        fromremovedequip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fromremovedequip.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        revEquipFromDate.setForeground(new java.awt.Color(0, 0, 0));
        revEquipFromDate.setDateFormatString("yyyy-MM-dd");
        revEquipFromDate.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N

        toremovedequip.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        toremovedequip.setForeground(new java.awt.Color(255, 255, 255));
        toremovedequip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toremovedequip.setText("TO:");
        toremovedequip.setToolTipText("");
        toremovedequip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toremovedequip.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        revEquipToDate.setForeground(new java.awt.Color(0, 0, 0));
        revEquipToDate.setDateFormatString("yyyy-MM-dd");
        revEquipToDate.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N

        searchDateEquipRemove.setBackground(new java.awt.Color(51, 102, 0));
        searchDateEquipRemove.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        searchDateEquipRemove.setForeground(new java.awt.Color(255, 255, 255));
        searchDateEquipRemove.setText("SEARCH");
        searchDateEquipRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDateEquipRemoveActionPerformed(evt);
            }
        });

        exportRemovedEquip.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        exportRemovedEquip.setForeground(new java.awt.Color(255, 255, 255));
        exportRemovedEquip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exportRemovedEquip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/diskette (1).png"))); // NOI18N
        exportRemovedEquip.setText("SAVE TABLE:");
        exportRemovedEquip.setToolTipText("Export medicine inventory");
        exportRemovedEquip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportRemovedEquip.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        exportRemovedEquip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportRemovedEquipMouseClicked(evt);
            }
        });

        inv_equip_equipmentLabel1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        inv_equip_equipmentLabel1.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_equipmentLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_equipmentLabel1.setText("EQUIPMENT INVENTORY");

        jLabel6.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("SEE SYSTEM OPERATOR");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout int_delequipmentsLayout = new javax.swing.GroupLayout(int_delequipments);
        int_delequipments.setLayout(int_delequipmentsLayout);
        int_delequipmentsLayout.setHorizontalGroup(
            int_delequipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(int_delequipmentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(int_delequipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(int_delequipmentsLayout.createSequentialGroup()
                        .addComponent(inv_equip_equipmentLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 466, Short.MAX_VALUE)
                        .addComponent(fromremovedequip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(revEquipFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toremovedequip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(revEquipToDate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchDateEquipRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exportRemovedEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(int_delequipmentsLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(int_delequipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(int_delequipmentsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(inv_equip_table1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        int_delequipmentsLayout.setVerticalGroup(
            int_delequipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(int_delequipmentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(int_delequipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(searchDateEquipRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exportRemovedEquip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(int_delequipmentsLayout.createSequentialGroup()
                        .addGroup(int_delequipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toremovedequip)
                            .addGroup(int_delequipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fromremovedequip)
                                .addComponent(inv_equip_equipmentLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1))
                    .addComponent(revEquipFromDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(revEquipToDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(695, Short.MAX_VALUE))
            .addGroup(int_delequipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, int_delequipmentsLayout.createSequentialGroup()
                    .addContainerGap(66, Short.MAX_VALUE)
                    .addComponent(inv_equip_table1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        inv_inventorymanager.addTab("DELETED EQUIPMENT", int_delequipments);

        dashboard1.setBackground(new java.awt.Color(53, 64, 142));

        equipment4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        equipment4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/first-aid-kit (1).png"))); // NOI18N
        equipment4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 215, 83), 3, true));
        equipment4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        equipment4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        equipment4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equipment4equipmentMouseClicked(evt);
            }
        });

        inventory4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inventory4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inventory.png"))); // NOI18N
        inventory4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 215, 83), 3, true));
        inventory4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inventory4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        meds4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meds4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/medicine (2).png"))); // NOI18N
        meds4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 215, 83), 3, true));
        meds4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        meds4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        meds4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                meds4medsMouseClicked(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        welcomeLabel4.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        welcomeLabel4.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel4.setText("WELCOME");

        nameLabelMeds1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        nameLabelMeds1.setForeground(new java.awt.Color(255, 255, 255));
        nameLabelMeds1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        signout1.setBackground(new java.awt.Color(53, 64, 142));
        signout1.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        signout1.setForeground(new java.awt.Color(255, 255, 255));
        signout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout (1).png"))); // NOI18N
        signout1.setText("SIGN OUT");
        signout1.setBorder(null);
        signout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signout1jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dashboard1Layout = new javax.swing.GroupLayout(dashboard1);
        dashboard1.setLayout(dashboard1Layout);
        dashboard1Layout.setHorizontalGroup(
            dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboard1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(equipment4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inventory4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(meds4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(welcomeLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabelMeds1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signout1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dashboard1Layout.setVerticalGroup(
            dashboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcomeLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabelMeds1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(meds4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(equipment4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inventory4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signout1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout inv_frameLayout = new javax.swing.GroupLayout(inv_frame);
        inv_frame.setLayout(inv_frameLayout);
        inv_frameLayout.setHorizontalGroup(
            inv_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(inv_frameLayout.createSequentialGroup()
                .addComponent(dashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_inventorymanager)
                .addContainerGap())
        );
        inv_frameLayout.setVerticalGroup(
            inv_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_frameLayout.createSequentialGroup()
                .addComponent(homebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inv_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_frameLayout.createSequentialGroup()
                        .addComponent(inv_inventorymanager)
                        .addContainerGap())))
        );

        getContentPane().add(inv_frame, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void adjust_mdMedsColumn() {
        inv_medTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        inv_medTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        inv_medTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        inv_medTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        inv_medTable.getColumnModel().getColumn(5).setPreferredWidth(50);
        inv_medTable.getColumnModel().getColumn(6).setPreferredWidth(80);
        inv_medTable.getColumnModel().getColumn(7).setPreferredWidth(80);
        inv_medTable.getColumnModel().getColumn(8).setPreferredWidth(200);
    }

    public void adjust_mdDelMedsColumn() {
        inv_recent_medtable.getColumnModel().getColumn(1).setPreferredWidth(50);
        inv_recent_medtable.getColumnModel().getColumn(2).setPreferredWidth(150);
        inv_recent_medtable.getColumnModel().getColumn(3).setPreferredWidth(50);
        inv_recent_medtable.getColumnModel().getColumn(4).setPreferredWidth(50);
        inv_recent_medtable.getColumnModel().getColumn(5).setPreferredWidth(50);
        inv_recent_medtable.getColumnModel().getColumn(6).setPreferredWidth(80);
        inv_recent_medtable.getColumnModel().getColumn(7).setPreferredWidth(80);
        inv_recent_medtable.getColumnModel().getColumn(8).setPreferredWidth(200);
    }

    public void adjust_mdEquipmentColumn() {
        inv_equipmentTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        inv_equipmentTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        inv_equipmentTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        inv_equipmentTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        inv_equipmentTable.getColumnModel().getColumn(5).setPreferredWidth(50);
        inv_equipmentTable.getColumnModel().getColumn(6).setPreferredWidth(100);
        inv_equipmentTable.getColumnModel().getColumn(7).setPreferredWidth(100);
        inv_equipmentTable.getColumnModel().getColumn(8).setPreferredWidth(200);
    }

    public void adjust_mdDelEquipmentColumn() {
        inv_recent_equiptable.getColumnModel().getColumn(1).setPreferredWidth(50);
        inv_recent_equiptable.getColumnModel().getColumn(2).setPreferredWidth(150);
        inv_recent_equiptable.getColumnModel().getColumn(3).setPreferredWidth(50);
        inv_recent_equiptable.getColumnModel().getColumn(4).setPreferredWidth(50);
        inv_recent_equiptable.getColumnModel().getColumn(5).setPreferredWidth(50);
        inv_recent_equiptable.getColumnModel().getColumn(6).setPreferredWidth(100);
        inv_recent_equiptable.getColumnModel().getColumn(7).setPreferredWidth(100);
        inv_recent_equiptable.getColumnModel().getColumn(8).setPreferredWidth(200);
    }

    public void loadData() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = util.Database.getConnection();
            Statement st = con.createStatement();

            DefaultTableModel invmedTable = (DefaultTableModel) inv_medTable.getModel();

            String sql = "SELECT * FROM medicine_inventory";
            ResultSet rs = st.executeQuery(sql);

            String item, remarks, op;
            int initialquantity, id, disposedMeds, total;
            Date date, expiry;
            while (rs.next()) {
                op = rs.getString("added_by");
                id = rs.getInt("md_id");
                date = rs.getDate("md_date");
                disposedMeds = rs.getInt("md_disposed");
                item = rs.getString("md_item");
                initialquantity = rs.getInt("md_quantity");
                expiry = rs.getDate("md_expiry");
                remarks = rs.getString("md_remarks");
                total = rs.getInt("md_totalquantity");

                invmedTable.addRow(new Object[]{op, id, item, total, initialquantity, disposedMeds, date, expiry, remarks});

            }
        } catch (Exception e) {
            System.out.println("//: " + e.getMessage());
        }
    }

    public void eq_loadData() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = util.Database.getConnection();
            Statement st = con.createStatement();

            DefaultTableModel invequipTable = (DefaultTableModel) inv_equipmentTable.getModel();

            String sql = "SELECT * FROM equipment_inventory";
            ResultSet rs = st.executeQuery(sql);

            String item, remarks, op;
            int initialquantity, disposed, id, totalquantity;
            String date, expiry;

            while (rs.next()) {
                op = rs.getString("added_by");
                id = rs.getInt("eq_id");
                date = rs.getString("eq_date");
                item = rs.getString("eq_item");
                initialquantity = rs.getInt("eq_quantity");
                disposed = rs.getInt("eq_disposed");
                expiry = rs.getString("eq_expiry");
                remarks = rs.getString("eq_remarks");
                totalquantity = rs.getInt("eq_totalquantity");

                invequipTable.addRow(new Object[]{op, id, item, totalquantity, initialquantity, disposed, date, expiry, remarks});

            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void removed_medsLoadData() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = util.Database.getConnection();
            Statement st = con.createStatement();

            DefaultTableModel invRemovedMedsTable = (DefaultTableModel) inv_recent_medtable.getModel();

            String sql = "SELECT * FROM removed_medicine";
            ResultSet rs = st.executeQuery(sql);

            String item, remarks, op;
            int initialquantity, id, disposedMeds, total;
            Date date, expiry;
            while (rs.next()) {
                op = rs.getString("added_by");
                id = rs.getInt("md_id");
                date = rs.getDate("md_date");
                disposedMeds = rs.getInt("md_dispensed");
                item = rs.getString("md_item");
                initialquantity = rs.getInt("md_quantity");
                expiry = rs.getDate("md_expiry");
                remarks = rs.getString("md_remarks");
                total = rs.getInt("md_totalquantity");

                invRemovedMedsTable.addRow(new Object[]{op, id, item, total, initialquantity, disposedMeds, date, expiry, remarks,});

            }
        } catch (Exception e) {
            System.out.println("//: " + e.getMessage());
        }
    }

    public void removed_equipsLoadData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = util.Database.getConnection();
            Statement st = con.createStatement();

            DefaultTableModel invRemovedEquipTable = (DefaultTableModel) inv_recent_equiptable.getModel();

            String sql = "SELECT * FROM `removed_equipment` ORDER BY `removed_equipment`.`eq_date` DESC";
            ResultSet rs = st.executeQuery(sql);

            String item, remarks, expiry, op;
            int initialquantity, id, disposedEquips, total;
            Date date;
            while (rs.next()) {
                op = rs.getString("added_by");
                id = rs.getInt("eq_id");
                date = rs.getDate("eq_date");
                disposedEquips = rs.getInt("eq_dispensed");
                item = rs.getString("eq_item");
                initialquantity = rs.getInt("eq_quantity");
                expiry = rs.getString("eq_expiry");
                remarks = rs.getString("eq_remarks");
                total = rs.getInt("eq_totalquantity");

                invRemovedEquipTable.addRow(new Object[]{op, id, item, total, initialquantity, disposedEquips, date, expiry, remarks});;

            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void inv_equip_insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_equip_insertbtnActionPerformed
        addEquipment add = new addEquipment(username);
        add.setVisible(true);
    }//GEN-LAST:event_inv_equip_insertbtnActionPerformed

    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked
        home home = new home(username);
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_homeButtonMouseClicked

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked

        DefaultTableModel medTable = (DefaultTableModel) inv_medTable.getModel();
        DefaultTableModel equipTable = (DefaultTableModel) inv_equipmentTable.getModel();
        DefaultTableModel invRemovedMedsTable = (DefaultTableModel) inv_recent_medtable.getModel();
        DefaultTableModel invRemovedEquipsTable = (DefaultTableModel) inv_recent_equiptable.getModel();

        medTable.setRowCount(0);
        invRemovedMedsTable.setRowCount(0);
        equipTable.setRowCount(0);
        invRemovedEquipsTable.setRowCount(0);

        JOptionPane.showMessageDialog(null, "Reloading Successful.", "UPDATE", JOptionPane.INFORMATION_MESSAGE);

        inv_searchName.setText("");

        removed_equipsLoadData();
        removed_medsLoadData();
        loadData();
        sortExpiredMedicineByExpiry();
        sortMedicineByExpiry();
        eq_sortEquipmentByDate();
        eq_sortDelEquipmentByDate();

    }//GEN-LAST:event_refreshButtonMouseClicked

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((JLabel) evt.getSource());
        frame.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked

    private Dimension originalSize;
    private Point originalLocation;

    private void resizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resizeButtonMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((JLabel) evt.getSource());

        if (originalSize == null) {
            originalSize = frame.getSize();
            originalLocation = frame.getLocation();
        }

        if (frame.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
            frame.setExtendedState(JFrame.NORMAL);
            frame.setSize(originalSize);
            frame.setLocation(originalLocation);
        } else {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
    }//GEN-LAST:event_resizeButtonMouseClicked

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitButtonMouseClicked

    private void inv_searchNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inv_searchNameKeyReleased
        DefaultTableModel inv_medicineTable = (DefaultTableModel) inv_medTable.getModel();
        TableRowSorter<DefaultTableModel> inv_meds = new TableRowSorter<>(inv_medicineTable);
        inv_medTable.setRowSorter(inv_meds);
        RowFilter<TableModel, Integer> filterPatient = RowFilter.regexFilter("(?i)" + inv_searchName.getText());
        inv_meds.setRowFilter(filterPatient);

        DefaultTableModel inv_equipBorrowerTable = (DefaultTableModel) inv_equipmentTable.getModel();
        TableRowSorter<DefaultTableModel> inv_equipments = new TableRowSorter<>(inv_equipBorrowerTable);
        inv_equipmentTable.setRowSorter(inv_equipments);
        RowFilter<TableModel, Integer> filterBorrower = RowFilter.regexFilter("(?i)" + inv_searchName.getText());
        inv_equipments.setRowFilter(filterBorrower);

        DefaultTableModel inv_recentsMedsTable = (DefaultTableModel) inv_recent_medtable.getModel();
        TableRowSorter<DefaultTableModel> inv_recentmeds = new TableRowSorter<>(inv_recentsMedsTable);
        inv_recent_medtable.setRowSorter(inv_recentmeds);
        RowFilter<TableModel, Integer> filterMeds = RowFilter.regexFilter("(?i)" + inv_searchName.getText());
        inv_recentmeds.setRowFilter(filterMeds);

        DefaultTableModel inv_recentsEquipTable = (DefaultTableModel) inv_recent_equiptable.getModel();
        TableRowSorter<DefaultTableModel> inv_recentequip = new TableRowSorter<>(inv_recentsEquipTable);
        inv_recent_equiptable.setRowSorter(inv_recentequip);
        RowFilter<TableModel, Integer> filterEquips = RowFilter.regexFilter("(?i)" + inv_searchName.getText());
        inv_recentequip.setRowFilter(filterEquips);;

    }//GEN-LAST:event_inv_searchNameKeyReleased

    private void inv_equip_deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_equip_deletebtnActionPerformed
        deleteEquipment delete = new deleteEquipment(username);
        delete.setVisible(true);
    }//GEN-LAST:event_inv_equip_deletebtnActionPerformed

    private void exportMedicineTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportMedicineTableMouseClicked
        MessageFormat header = new MessageFormat("Medicine Inventory Records");
        MessageFormat footer = new MessageFormat("National University Baliwag");
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);
            inv_medTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null, "Failed");
        }
    }//GEN-LAST:event_exportMedicineTableMouseClicked

    private void exportEquipmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportEquipmentTableMouseClicked
        MessageFormat header = new MessageFormat("Equipment Inventory Records");
        MessageFormat footer = new MessageFormat("National Univeristy Baliwag");
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);
            inv_equipmentTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null, "Failed");
        }
    }//GEN-LAST:event_exportEquipmentTableMouseClicked

    private void inv_med_insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_med_insertbtnActionPerformed
        addMedicine add = new addMedicine(username);
        add.setVisible(true);
    }//GEN-LAST:event_inv_med_insertbtnActionPerformed

    private void inv_med_updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_med_updatebtnActionPerformed
        updateMedicine update = new updateMedicine();
        update.setVisible(true);
    }//GEN-LAST:event_inv_med_updatebtnActionPerformed

    private void inv_equip_updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_equip_updatebtnActionPerformed
        updateEquipment update = new updateEquipment(username);
        update.setVisible(true);
    }//GEN-LAST:event_inv_equip_updatebtnActionPerformed

    private void searchDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDateActionPerformed
        try {
            inv_medTable.setModel(new DefaultTableModel(null, new Object[]{"ID", "ITEM", "TOTAL QUANTITY", "QUANTITY LEFT", "NO. DISPENSED", "DATE ADDED", "EXPIRY", "REMARKS"}));
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String fDate = date.format(fromDate.getDate());
            String tDate = date.format(toDate.getDate());
            showData(fDate, tDate);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_searchDateActionPerformed

    private void searchDateEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDateEquipActionPerformed
        try {
            inv_equipmentTable.setModel(new DefaultTableModel(null, new Object[]{"ID", "ITEM", "TOTAL QUANTITY", "QUANTITY LEFT", "NO. DISPENSED", "DATE ADDED", "EXPIRY", "REMARKS"}));
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String fDate = date.format(fromDate1.getDate());
            String tDate = date.format(toDate1.getDate());
            showDataEquip(fDate, tDate);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_searchDateEquipActionPerformed

    private void searchDateMedRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDateMedRemoveActionPerformed
        try {
            inv_recent_medtable.setModel(new DefaultTableModel(null, new Object[]{"ID", "ITEM", "TOTAL QUANTITY", "QUANTITY LEFT", "NO. DISPENSED", "DATE ADDED", "EXPIRY", "REMARKS"}));
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String fDate = date.format(revFromDate.getDate());
            String tDate = date.format(revToDate.getDate());
            showRemovedData(fDate, tDate);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_searchDateMedRemoveActionPerformed

    private void exportRemovedMedsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportRemovedMedsMouseClicked
        MessageFormat header = new MessageFormat("Removed Medicine Records");
        MessageFormat footer = new MessageFormat("National University Baliwag");
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);
            inv_recent_medtable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null, "Failed");
        }
    }//GEN-LAST:event_exportRemovedMedsMouseClicked

    private void searchDateEquipRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDateEquipRemoveActionPerformed
        try {
            inv_recent_equiptable.setModel(new DefaultTableModel(null, new Object[]{"ID", "ITEM", "TOTAL QUANTITY", "QUANTITY LEFT", "NO. DISPENSED", "DATE ADDED", "EXPIRY", "REMARKS"}));
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String fDate = date.format(revEquipFromDate.getDate());
            String tDate = date.format(revEquipToDate.getDate());
            showRemovedEquipData(fDate, tDate);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_searchDateEquipRemoveActionPerformed

    private void exportRemovedEquipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportRemovedEquipMouseClicked
        MessageFormat header = new MessageFormat("Removed Equipment Records");
        MessageFormat footer = new MessageFormat("National University Baliwag");
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);
            inv_recent_equiptable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null, "Failed");
        }
    }//GEN-LAST:event_exportRemovedEquipMouseClicked

    private void equipment4equipmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equipment4equipmentMouseClicked
        hsoequipment equipment = new hsoequipment(username);
        equipment.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_equipment4equipmentMouseClicked

    private void meds4medsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_meds4medsMouseClicked
        hsoinventory meds = new hsoinventory(username);
        meds.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_meds4medsMouseClicked

    private void signout1jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signout1jButton1ActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            SignUpLogIn login = new SignUpLogIn();
            login.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_signout1jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        TableColumn column = inv_medTable.getColumnModel().getColumn(0);
        int preferredWidth = column.getPreferredWidth();
        if (preferredWidth == 80) {
            column.setPreferredWidth(0);
        } else {
            column.setPreferredWidth(80);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        TableColumn column = inv_recent_medtable.getColumnModel().getColumn(0);
        int preferredWidth = column.getPreferredWidth();
        if (preferredWidth == 80) {
            column.setPreferredWidth(0);
        } else {
            column.setPreferredWidth(80);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        TableColumn column = inv_equipmentTable.getColumnModel().getColumn(0);
        int preferredWidth = column.getPreferredWidth();
        if (preferredWidth == 80) {
            column.setPreferredWidth(0);
        } else {
            column.setPreferredWidth(80);
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        TableColumn column = inv_recent_equiptable.getColumnModel().getColumn(0);
        int preferredWidth = column.getPreferredWidth();
        if (preferredWidth == 80) {
            column.setPreferredWidth(0);
        } else {
            column.setPreferredWidth(80);
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            con = util.Database.getConnection();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }

    public void showDataEquip(String d1, String d2) {
        Connection con = getConnection();
        PreparedStatement st;
        ResultSet rs;

        try {

            if (d1.equals("") || d2.equals("")) {
                st = con.prepareStatement("SELECT * FROM `equipment_inventory`");
            } else {
                st = con.prepareStatement("SELECT * FROM `equipment_inventory` WHERE `eq_date`BETWEEN ? AND ?");
                st.setString(1, d1);
                st.setString(2, d2);
            }

            rs = st.executeQuery();
            DefaultTableModel equipTable = (DefaultTableModel) inv_equipmentTable.getModel();

            String item, remarks, op;
            int initialquantity, disposed, id, totalquantity;
            String date, expiry;

            while (rs.next()) {
                op = rs.getString("added_by");
                id = rs.getInt("eq_id");
                date = rs.getString("eq_date");
                item = rs.getString("eq_item");
                initialquantity = rs.getInt("eq_quantity");
                disposed = rs.getInt("eq_disposed");
                expiry = rs.getString("eq_expiry");
                remarks = rs.getString("eq_remarks");
                totalquantity = rs.getInt("eq_totalquantity");

                equipTable.addRow(new Object[]{op, id, item, totalquantity, initialquantity, disposed, date, expiry, remarks});

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showData(String d1, String d2) {
        Connection con = getConnection();
        PreparedStatement st;
        ResultSet rs;

        try {

            if (d1.equals("") || d2.equals("")) {
                st = con.prepareStatement("SELECT * FROM `medicine_inventory`");
            } else {
                st = con.prepareStatement("SELECT * FROM `medicine_inventory` WHERE `md_date`BETWEEN ? AND ?");
                st.setString(1, d1);
                st.setString(2, d2);
            }

            rs = st.executeQuery();
            DefaultTableModel medTable = (DefaultTableModel) inv_medTable.getModel();

            String item, remarks, op;
            int initialquantity, id, disposedMeds, total;
            Date date, expiry;
            while (rs.next()) {
                op = rs.getString("added_by");
                id = rs.getInt("md_id");
                date = rs.getDate("md_date");
                disposedMeds = rs.getInt("md_disposed");
                item = rs.getString("md_item");
                initialquantity = rs.getInt("md_quantity");
                expiry = rs.getDate("md_expiry");
                remarks = rs.getString("md_remarks");
                total = rs.getInt("md_totalquantity");

                medTable.addRow(new Object[]{op, id, item, total, initialquantity, disposedMeds, date, expiry, remarks});

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showRemovedData(String d1, String d2) {
        Connection con = getConnection();
        PreparedStatement st;
        ResultSet rs;

        try {

            if (d1.equals("") || d2.equals("")) {
                st = con.prepareStatement("SELECT * FROM `removed_medicine`");
            } else {
                st = con.prepareStatement("SELECT * FROM `removed_medicine` WHERE `md_date`BETWEEN ? AND ?");
                st.setString(1, d1);
                st.setString(2, d2);
            }

            rs = st.executeQuery();
            DefaultTableModel revmedTable = (DefaultTableModel) inv_recent_medtable.getModel();

            String item, remarks, op;
            int initialquantity, id, disposedMeds, total;
            Date date, expiry;
            while (rs.next()) {
                op = rs.getString("added_by");
                id = rs.getInt("md_id");
                date = rs.getDate("md_date");
                disposedMeds = rs.getInt("md_dispensed");
                item = rs.getString("md_item");
                initialquantity = rs.getInt("md_quantity");
                expiry = rs.getDate("md_expiry");
                remarks = rs.getString("md_remarks");
                total = rs.getInt("md_totalquantity");

                revmedTable.addRow(new Object[]{op, id, item, total, initialquantity, disposedMeds, date, expiry, remarks});

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showRemovedEquipData(String d1, String d2) {
        Connection con = getConnection();
        PreparedStatement st;
        ResultSet rs;

        try {

            if (d1.equals("") || d2.equals("")) {
                st = con.prepareStatement("SELECT * FROM `removed_equipment`");
            } else {
                st = con.prepareStatement("SELECT * FROM `removed_equipment` WHERE `eq_date`BETWEEN ? AND ?");
                st.setString(1, d1);
                st.setString(2, d2);
            }

            rs = st.executeQuery();
            DefaultTableModel revEquipTable = (DefaultTableModel) inv_recent_equiptable.getModel();

            String item, remarks, op;
            int initialquantity, disposed, id, totalquantity;
            String date, expiry;

            while (rs.next()) {
                op = rs.getString("added_by");
                id = rs.getInt("eq_id");
                date = rs.getString("eq_date");
                item = rs.getString("eq_item");
                initialquantity = rs.getInt("eq_quantity");
                disposed = rs.getInt("eq_dispensed");
                expiry = rs.getString("eq_expiry");
                remarks = rs.getString("eq_remarks");
                totalquantity = rs.getInt("eq_totalquantity");

                revEquipTable.addRow(new Object[]{op, id, item, totalquantity, initialquantity, disposed, date, expiry, remarks});

            }

        } catch (Exception e) {
            System.out.println("wie.getMessage()");
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
            java.util.logging.Logger.getLogger(hsoinventorymanagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hsoinventorymanagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hsoinventorymanagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hsoinventorymanagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                hsoinventorymanagement hso = new hsoinventorymanagement();
                hso.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dashboard1;
    private javax.swing.JLabel eq_searchNameLabel;
    private javax.swing.JLabel equipment;
    private javax.swing.JLabel equipment1;
    private javax.swing.JLabel equipment4;
    private javax.swing.JLabel exitButton;
    private javax.swing.JLabel exportEquipmentTable;
    private javax.swing.JLabel exportMedicineTable;
    private javax.swing.JLabel exportRemovedEquip;
    private javax.swing.JLabel exportRemovedMeds;
    private com.toedter.calendar.JDateChooser fromDate;
    private com.toedter.calendar.JDateChooser fromDate1;
    private javax.swing.JLabel fromequip;
    private javax.swing.JLabel frommed;
    private javax.swing.JLabel fromremoved;
    private javax.swing.JLabel fromremovedequip;
    private javax.swing.JPanel function;
    private javax.swing.JLabel homeButton;
    private javax.swing.JPanel homebar;
    private javax.swing.JPanel int_delequipments;
    private javax.swing.JPanel int_delmedicine;
    private javax.swing.JButton inv_equip_deletebtn;
    private javax.swing.JLabel inv_equip_equipmentLabel;
    private javax.swing.JLabel inv_equip_equipmentLabel1;
    private javax.swing.JButton inv_equip_insertbtn;
    private javax.swing.JScrollPane inv_equip_table;
    private javax.swing.JScrollPane inv_equip_table1;
    private javax.swing.JButton inv_equip_updatebtn;
    private javax.swing.JPanel inv_equipment;
    private javax.swing.JTable inv_equipmentTable;
    private javax.swing.JPanel inv_frame;
    private javax.swing.JTabbedPane inv_inventorymanager;
    public javax.swing.JTable inv_medTable;
    private javax.swing.JButton inv_med_insertbtn;
    private javax.swing.JLabel inv_med_medicineLabel;
    private javax.swing.JLabel inv_med_medicineLabel1;
    private javax.swing.JScrollPane inv_med_table;
    private javax.swing.JScrollPane inv_med_table1;
    private javax.swing.JButton inv_med_updatebtn;
    private javax.swing.JPanel inv_medicine;
    private javax.swing.JTable inv_recent_equiptable;
    private javax.swing.JTable inv_recent_medtable;
    private javax.swing.JTextField inv_searchName;
    private javax.swing.JLabel inventory;
    private javax.swing.JLabel inventory1;
    private javax.swing.JLabel inventory4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel meds;
    private javax.swing.JLabel meds1;
    private javax.swing.JLabel meds4;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JLabel nameLabelMeds1;
    private javax.swing.JLabel refreshButton;
    private javax.swing.JLabel resizeButton;
    private com.toedter.calendar.JDateChooser revEquipFromDate;
    private com.toedter.calendar.JDateChooser revEquipToDate;
    private com.toedter.calendar.JDateChooser revFromDate;
    private com.toedter.calendar.JDateChooser revToDate;
    private javax.swing.JButton searchDate;
    private javax.swing.JButton searchDateEquip;
    private javax.swing.JButton searchDateEquipRemove;
    private javax.swing.JButton searchDateMedRemove;
    private javax.swing.JButton signout1;
    private com.toedter.calendar.JDateChooser toDate;
    private com.toedter.calendar.JDateChooser toDate1;
    private javax.swing.JLabel toequip;
    private javax.swing.JLabel tomed;
    private javax.swing.JLabel toremoved;
    private javax.swing.JLabel toremovedequip;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel welcomeLabel1;
    private javax.swing.JLabel welcomeLabel4;
    // End of variables declaration//GEN-END:variables
}
