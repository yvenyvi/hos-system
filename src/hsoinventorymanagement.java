
import java.awt.Dimension;
import java.awt.Point;
import java.util.Date;
import java.awt.event.KeyEvent;
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
import javax.swing.table.TableRowSorter;

public class hsoinventorymanagement extends javax.swing.JFrame {
    
    Date date = new Date();

    public hsoinventorymanagement() {
        initComponents();
        loadData();
        eq_loadData();
        removed_medsLoadData();
        removed_equipsLoadData();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inv_frame = new javax.swing.JPanel();
        inv_inventorymanager = new javax.swing.JTabbedPane();
        inv_medicine = new javax.swing.JPanel();
        inv_med_table = new javax.swing.JScrollPane();
        inv_medTable = new javax.swing.JTable();
        inv_med_infopanel = new javax.swing.JPanel();
        inv_med_inventoryLabel = new javax.swing.JLabel();
        inv_med_medicineLabel = new javax.swing.JLabel();
        exportMedicineTable = new javax.swing.JLabel();
        inv_med_insertbtn = new javax.swing.JButton();
        inv_med_removebtn = new javax.swing.JButton();
        inv_med_updatebtn = new javax.swing.JButton();
        inv_equipment = new javax.swing.JPanel();
        inv_equip_table = new javax.swing.JScrollPane();
        inv_equipmentTable = new javax.swing.JTable();
        inv_med_infopanel1 = new javax.swing.JPanel();
        inv_equip_inventoryLabel = new javax.swing.JLabel();
        inv_equip_equipmentLabel = new javax.swing.JLabel();
        inv_equip_insertbtn = new javax.swing.JButton();
        inv_equip_deletebtn = new javax.swing.JButton();
        inv_equip_updatebtn = new javax.swing.JButton();
        exportEquipmentTable = new javax.swing.JLabel();
        int_delmedicine = new javax.swing.JPanel();
        inv_med_table1 = new javax.swing.JScrollPane();
        inv_recent_medtable = new javax.swing.JTable();
        int_delequipments = new javax.swing.JPanel();
        inv_equip_table1 = new javax.swing.JScrollPane();
        inv_recent_equiptable = new javax.swing.JTable();
        homebar = new javax.swing.JPanel();
        homeButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        eq_searchNameLabel = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        resizeButton = new javax.swing.JLabel();
        refreshButton = new javax.swing.JLabel();
        inv_searchName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        inv_frame.setBackground(new java.awt.Color(255, 255, 255));

        inv_inventorymanager.setForeground(new java.awt.Color(255, 255, 255));

        inv_medTable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        inv_medTable.setForeground(new java.awt.Color(0, 0, 0));
        inv_medTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATE ADDED", "ITEM", "QUANTITY LEFT", "NO. DISPENSED", "YEAR EXPIRY", "MONTH EXPIRY", "REMARKS", "TOTAL QUANTITY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
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
        inv_medTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        inv_medTable.setRowHeight(40);
        inv_medTable.setSelectionBackground(new java.awt.Color(51, 102, 0));
        inv_medTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        inv_medTable.setShowGrid(false);
        inv_medTable.getTableHeader().setResizingAllowed(false);
        inv_medTable.getTableHeader().setReorderingAllowed(false);
        inv_med_table.setViewportView(inv_medTable);

        inv_med_infopanel.setBackground(new java.awt.Color(53, 64, 142));

        inv_med_inventoryLabel.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        inv_med_inventoryLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_inventoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_inventoryLabel.setText("INVENTORY");

        inv_med_medicineLabel.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        inv_med_medicineLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_medicineLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_medicineLabel.setText("MEDICINE");

        exportMedicineTable.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        exportMedicineTable.setForeground(new java.awt.Color(0, 0, 0));
        exportMedicineTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exportMedicineTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/diskette (1).png"))); // NOI18N
        exportMedicineTable.setToolTipText("Export medicine inventory");
        exportMedicineTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportMedicineTable.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        exportMedicineTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportMedicineTableMouseClicked(evt);
            }
        });

        inv_med_insertbtn.setBackground(new java.awt.Color(51, 102, 0));
        inv_med_insertbtn.setFont(new java.awt.Font("Monospaced", 0, 21)); // NOI18N
        inv_med_insertbtn.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_insertbtn.setText("INSERT");
        inv_med_insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inv_med_insertbtnActionPerformed(evt);
            }
        });

        inv_med_removebtn.setBackground(new java.awt.Color(51, 102, 0));
        inv_med_removebtn.setFont(new java.awt.Font("Monospaced", 0, 21)); // NOI18N
        inv_med_removebtn.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_removebtn.setText("REMOVE");
        inv_med_removebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inv_med_removebtnActionPerformed(evt);
            }
        });

        inv_med_updatebtn.setBackground(new java.awt.Color(51, 102, 0));
        inv_med_updatebtn.setFont(new java.awt.Font("Monospaced", 0, 21)); // NOI18N
        inv_med_updatebtn.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_updatebtn.setText("UPDATE");
        inv_med_updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inv_med_updatebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inv_med_infopanelLayout = new javax.swing.GroupLayout(inv_med_infopanel);
        inv_med_infopanel.setLayout(inv_med_infopanelLayout);
        inv_med_infopanelLayout.setHorizontalGroup(
            inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_med_infopanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inv_med_medicineLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inv_med_inventoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_med_infopanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inv_med_updatebtn, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(inv_med_insertbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inv_med_removebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_med_infopanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exportMedicineTable)
                .addContainerGap())
        );
        inv_med_infopanelLayout.setVerticalGroup(
            inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_med_infopanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exportMedicineTable)
                .addGap(31, 31, 31)
                .addComponent(inv_med_medicineLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_med_inventoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(inv_med_insertbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(inv_med_updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(inv_med_removebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout inv_medicineLayout = new javax.swing.GroupLayout(inv_medicine);
        inv_medicine.setLayout(inv_medicineLayout);
        inv_medicineLayout.setHorizontalGroup(
            inv_medicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_medicineLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inv_med_table, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_med_infopanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        inv_medicineLayout.setVerticalGroup(
            inv_medicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_medicineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inv_medicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inv_med_table, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addComponent(inv_med_infopanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        inv_inventorymanager.addTab("MEDICINE INVENTORY", inv_medicine);

        inv_equipmentTable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        inv_equipmentTable.setForeground(new java.awt.Color(0, 0, 0));
        inv_equipmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATE ADDED", "ITEM", "QUANTITY LEFT", "NO. DISPENSED", "ITEM EXPIRY", "REMARKS", "TOTAL QUANTITY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        inv_med_infopanel1.setBackground(new java.awt.Color(53, 64, 142));

        inv_equip_inventoryLabel.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        inv_equip_inventoryLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_inventoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_inventoryLabel.setText("INVENTORY");

        inv_equip_equipmentLabel.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        inv_equip_equipmentLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_equipmentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_equipmentLabel.setText("EQUIPMENT");

        inv_equip_insertbtn.setBackground(new java.awt.Color(51, 102, 0));
        inv_equip_insertbtn.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        inv_equip_insertbtn.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_insertbtn.setText("INSERT");
        inv_equip_insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inv_equip_insertbtnActionPerformed(evt);
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

        inv_equip_updatebtn.setBackground(new java.awt.Color(51, 102, 0));
        inv_equip_updatebtn.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        inv_equip_updatebtn.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_updatebtn.setText("UPDATE");
        inv_equip_updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inv_equip_updatebtnActionPerformed(evt);
            }
        });

        exportEquipmentTable.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        exportEquipmentTable.setForeground(new java.awt.Color(0, 0, 0));
        exportEquipmentTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exportEquipmentTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/diskette (1).png"))); // NOI18N
        exportEquipmentTable.setToolTipText("Export equipment inventory");
        exportEquipmentTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportEquipmentTable.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        exportEquipmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportEquipmentTableMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout inv_med_infopanel1Layout = new javax.swing.GroupLayout(inv_med_infopanel1);
        inv_med_infopanel1.setLayout(inv_med_infopanel1Layout);
        inv_med_infopanel1Layout.setHorizontalGroup(
            inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_med_infopanel1Layout.createSequentialGroup()
                .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inv_med_infopanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inv_equip_inventoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inv_equip_equipmentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(inv_med_infopanel1Layout.createSequentialGroup()
                                .addComponent(exportEquipmentTable)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(inv_med_infopanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inv_equip_deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(inv_equip_insertbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(inv_equip_updatebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 81, Short.MAX_VALUE)))
                .addContainerGap())
        );
        inv_med_infopanel1Layout.setVerticalGroup(
            inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_med_infopanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exportEquipmentTable)
                .addGap(32, 32, 32)
                .addComponent(inv_equip_equipmentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_equip_inventoryLabel)
                .addGap(77, 77, 77)
                .addComponent(inv_equip_insertbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(inv_equip_updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(inv_equip_deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout inv_equipmentLayout = new javax.swing.GroupLayout(inv_equipment);
        inv_equipment.setLayout(inv_equipmentLayout);
        inv_equipmentLayout.setHorizontalGroup(
            inv_equipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_equipmentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inv_med_infopanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_equip_table, javax.swing.GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)
                .addContainerGap())
        );
        inv_equipmentLayout.setVerticalGroup(
            inv_equipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_equipmentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inv_equipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inv_med_infopanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inv_equip_table, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE))
                .addContainerGap())
        );

        inv_inventorymanager.addTab("EQUIPMENT INVENTORY", inv_equipment);

        inv_recent_medtable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        inv_recent_medtable.setForeground(new java.awt.Color(0, 0, 0));
        inv_recent_medtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATE ADDED", "ITEM", "QUANTITY LEFT", "NO. DISPENSED", "YEAR EXPIRY", "MONTH EXPIRY", "REMARKS", "TOTAL QUANTITY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
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
        inv_recent_medtable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        inv_recent_medtable.setRowHeight(40);
        inv_recent_medtable.setRowSelectionAllowed(false);
        inv_recent_medtable.setSelectionBackground(new java.awt.Color(51, 102, 0));
        inv_recent_medtable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        inv_recent_medtable.setShowGrid(false);
        inv_recent_medtable.getTableHeader().setResizingAllowed(false);
        inv_recent_medtable.getTableHeader().setReorderingAllowed(false);
        inv_med_table1.setViewportView(inv_recent_medtable);

        javax.swing.GroupLayout int_delmedicineLayout = new javax.swing.GroupLayout(int_delmedicine);
        int_delmedicine.setLayout(int_delmedicineLayout);
        int_delmedicineLayout.setHorizontalGroup(
            int_delmedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1288, Short.MAX_VALUE)
            .addGroup(int_delmedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(int_delmedicineLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(inv_med_table1, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        int_delmedicineLayout.setVerticalGroup(
            int_delmedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
            .addGroup(int_delmedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(int_delmedicineLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(inv_med_table1)
                    .addContainerGap()))
        );

        inv_inventorymanager.addTab("RECENTLY DELETED MEDICINE", int_delmedicine);

        inv_recent_equiptable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        inv_recent_equiptable.setForeground(new java.awt.Color(0, 0, 0));
        inv_recent_equiptable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATE ADDED", "ITEM", "QUANTITY LEFT", "NO. DISPENSED", "ITEM EXPIRY", "REMARKS", "TOTAL QUANTITY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        javax.swing.GroupLayout int_delequipmentsLayout = new javax.swing.GroupLayout(int_delequipments);
        int_delequipments.setLayout(int_delequipmentsLayout);
        int_delequipmentsLayout.setHorizontalGroup(
            int_delequipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1288, Short.MAX_VALUE)
            .addGroup(int_delequipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(int_delequipmentsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(inv_equip_table1, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        int_delequipmentsLayout.setVerticalGroup(
            int_delequipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
            .addGroup(int_delequipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(int_delequipmentsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(inv_equip_table1)
                    .addContainerGap()))
        );

        inv_inventorymanager.addTab("RECENTLY DELETED EQUIPMENT", int_delequipments);

        homebar.setBackground(new java.awt.Color(255, 255, 255));
        homebar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        javax.swing.GroupLayout inv_frameLayout = new javax.swing.GroupLayout(inv_frame);
        inv_frame.setLayout(inv_frameLayout);
        inv_frameLayout.setHorizontalGroup(
            inv_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_frameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inv_inventorymanager)
                .addContainerGap())
            .addComponent(homebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        inv_frameLayout.setVerticalGroup(
            inv_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_frameLayout.createSequentialGroup()
                .addComponent(homebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_inventorymanager)
                .addContainerGap())
        );

        getContentPane().add(inv_frame, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void loadData() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            DefaultTableModel invmedTable = (DefaultTableModel) inv_medTable.getModel();

            String sql = "SELECT * FROM medicine_inventory";
            ResultSet rs = st.executeQuery(sql);

            String item, remarks;
            int initialquantity, year_expiry, month_expiry, id, disposedMeds, total;
            Date date;
            while (rs.next()) {
                id = rs.getInt("md_id");
                date = rs.getDate("md_date");
                disposedMeds = rs.getInt("md_disposed");
                item = rs.getString("md_item");
                initialquantity = rs.getInt("md_quantity");
                year_expiry = rs.getInt("md_year_expiry");
                month_expiry = rs.getInt("md_month_expiry");
                remarks = rs.getString("md_remarks");
                total = rs.getInt("md_totalquantity");

                invmedTable.addRow(new Object[]{id, date, item, initialquantity, disposedMeds, year_expiry, month_expiry, remarks, total});

            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void eq_loadData() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            DefaultTableModel invequipTable = (DefaultTableModel) inv_equipmentTable.getModel();

            String sql = "SELECT * FROM equipment_inventory";
            ResultSet rs = st.executeQuery(sql);

            String item, remarks;
            int initialquantity, disposed, id, totalquantity;
            String date, expiry;

            while (rs.next()) {
                id = rs.getInt("eq_id");
                date = rs.getString("eq_date");
                item = rs.getString("eq_item");
                initialquantity = rs.getInt("eq_quantity");
                disposed = rs.getInt("eq_disposed");
                expiry = rs.getString("eq_expiry");
                remarks = rs.getString("eq_remarks");
                totalquantity = rs.getInt("eq_totalquantity");

                invequipTable.addRow(new Object[]{id, date, item, initialquantity, disposed, expiry, remarks, totalquantity});

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

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            DefaultTableModel invRemovedMedsTable = (DefaultTableModel) inv_recent_medtable.getModel();

            String sql = "SELECT * FROM removed_medicine";
            ResultSet rs = st.executeQuery(sql);

            String item, remarks;
            int initialquantity, year_expiry, month_expiry, id, disposedMeds, total;
            Date date;
            while (rs.next()) {
                id = rs.getInt("md_id");
                date = rs.getDate("md_date");
                disposedMeds = rs.getInt("md_dispensed");
                item = rs.getString("md_item");
                initialquantity = rs.getInt("md_quantity");
                year_expiry = rs.getInt("md_year_expiry");
                month_expiry = rs.getInt("md_month_expiry");
                remarks = rs.getString("md_remarks");
                total = rs.getInt("md_totalquantity");

                invRemovedMedsTable.addRow(new Object[]{id, date, item, initialquantity, disposedMeds, year_expiry, month_expiry, remarks, total});

            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void removed_equipsLoadData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            DefaultTableModel invRemovedEquipTable = (DefaultTableModel) inv_recent_equiptable.getModel();

            String sql = "SELECT * FROM removed_equipment";
            ResultSet rs = st.executeQuery(sql);

            String item, remarks, expiry;
            int initialquantity, id, disposedMeds, total;
            Date date;
            while (rs.next()) {
                id = rs.getInt("eq_id");
                date = rs.getDate("eq_date");
                disposedMeds = rs.getInt("eq_dispensed");
                item = rs.getString("eq_item");
                initialquantity = rs.getInt("eq_quantity");
                expiry = rs.getString("eq_expiry");
                remarks = rs.getString("eq_remarks");
                total = rs.getInt("eq_totalquantity");

                invRemovedEquipTable.addRow(new Object[]{id, date, item, initialquantity, disposedMeds, expiry, remarks, total});

            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void inv_equip_insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_equip_insertbtnActionPerformed
        addEquipment add = new addEquipment();
        add.setVisible(true);
    }//GEN-LAST:event_inv_equip_insertbtnActionPerformed

    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked
        home home = new home();
        home.show();
        dispose();
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

        JOptionPane.showMessageDialog(null, "Reloading Successful.", "UPDATE: Reload", JOptionPane.INFORMATION_MESSAGE);

        
        removed_equipsLoadData();
        removed_medsLoadData();
        loadData();
        eq_loadData();

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
        inv_meds.setRowFilter(RowFilter.regexFilter(inv_searchName.getText()));

        DefaultTableModel inv_equipBorrowerTable = (DefaultTableModel) inv_equipmentTable.getModel();
        TableRowSorter<DefaultTableModel> inv_equipments = new TableRowSorter<>(inv_equipBorrowerTable);
        inv_equipmentTable.setRowSorter(inv_equipments);
        inv_equipments.setRowFilter(RowFilter.regexFilter(inv_searchName.getText()));

        DefaultTableModel inv_recentsMedsTable = (DefaultTableModel) inv_recent_medtable.getModel();
        TableRowSorter<DefaultTableModel> inv_recentmeds = new TableRowSorter<>(inv_recentsMedsTable);
        inv_recent_medtable.setRowSorter(inv_recentmeds);
        inv_recentmeds.setRowFilter(RowFilter.regexFilter(inv_searchName.getText()));

        DefaultTableModel inv_recentsEquipTable = (DefaultTableModel) inv_recent_equiptable.getModel();
        TableRowSorter<DefaultTableModel> inv_recentequip = new TableRowSorter<>(inv_recentsEquipTable);
        inv_recent_equiptable.setRowSorter(inv_recentequip);
        inv_recentequip.setRowFilter(RowFilter.regexFilter(inv_searchName.getText()));

    }//GEN-LAST:event_inv_searchNameKeyReleased

    private void inv_equip_deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_equip_deletebtnActionPerformed
       deleteEquipment delete = new deleteEquipment();
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
        MessageFormat header = new MessageFormat("Equipement Inventory Records");
        MessageFormat footer = new MessageFormat("National Univeristy Baliwag");
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);
            inv_medTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null, "Failed");
        }
    }//GEN-LAST:event_exportEquipmentTableMouseClicked

    private void inv_med_insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_med_insertbtnActionPerformed

        addMedicine add = new addMedicine();
        add.setVisible(true);
    }//GEN-LAST:event_inv_med_insertbtnActionPerformed

    private void inv_med_updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_med_updatebtnActionPerformed
        updateMedicine update = new updateMedicine();
        update.setVisible(true);
    }//GEN-LAST:event_inv_med_updatebtnActionPerformed

    private void inv_med_removebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_med_removebtnActionPerformed
        deleteMedicine delete = new deleteMedicine();
        delete.setVisible(true);
    }//GEN-LAST:event_inv_med_removebtnActionPerformed

    private void inv_equip_updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_equip_updatebtnActionPerformed
       updateEquipment update = new updateEquipment();
       update.setVisible(true);
    }//GEN-LAST:event_inv_equip_updatebtnActionPerformed

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
//                hso.loadData();
//                hso.eq_loadData();
                hso.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel eq_searchNameLabel;
    private javax.swing.JLabel exitButton;
    private javax.swing.JLabel exportEquipmentTable;
    private javax.swing.JLabel exportMedicineTable;
    private javax.swing.JLabel homeButton;
    private javax.swing.JPanel homebar;
    private javax.swing.JPanel int_delequipments;
    private javax.swing.JPanel int_delmedicine;
    private javax.swing.JButton inv_equip_deletebtn;
    private javax.swing.JLabel inv_equip_equipmentLabel;
    private javax.swing.JButton inv_equip_insertbtn;
    private javax.swing.JLabel inv_equip_inventoryLabel;
    private javax.swing.JScrollPane inv_equip_table;
    private javax.swing.JScrollPane inv_equip_table1;
    private javax.swing.JButton inv_equip_updatebtn;
    private javax.swing.JPanel inv_equipment;
    private javax.swing.JTable inv_equipmentTable;
    private javax.swing.JPanel inv_frame;
    private javax.swing.JTabbedPane inv_inventorymanager;
    public javax.swing.JTable inv_medTable;
    private javax.swing.JPanel inv_med_infopanel;
    private javax.swing.JPanel inv_med_infopanel1;
    private javax.swing.JButton inv_med_insertbtn;
    private javax.swing.JLabel inv_med_inventoryLabel;
    private javax.swing.JLabel inv_med_medicineLabel;
    private javax.swing.JButton inv_med_removebtn;
    private javax.swing.JScrollPane inv_med_table;
    private javax.swing.JScrollPane inv_med_table1;
    private javax.swing.JButton inv_med_updatebtn;
    private javax.swing.JPanel inv_medicine;
    private javax.swing.JTable inv_recent_equiptable;
    private javax.swing.JTable inv_recent_medtable;
    private javax.swing.JTextField inv_searchName;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JLabel refreshButton;
    private javax.swing.JLabel resizeButton;
    // End of variables declaration//GEN-END:variables
}
