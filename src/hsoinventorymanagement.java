
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
        inv_med_date.setMinSelectableDate(date);
        inv_equip_date.setMinSelectableDate(date);
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
        inv_med_removebtn = new javax.swing.JButton();
        inv_med_updatebtn = new javax.swing.JButton();
        inv_med_expiryLabel1 = new javax.swing.JLabel();
        inv_med_year = new com.toedter.calendar.JYearChooser();
        inv_med_month = new com.toedter.calendar.JMonthChooser();
        inv_med_disposedLabel = new javax.swing.JLabel();
        inv_med_dispensed = new javax.swing.JSpinner();
        inv_med_quantity = new javax.swing.JSpinner();
        inv_equip_quantityLabel3 = new javax.swing.JLabel();
        inv_md_searchID = new javax.swing.JTextField();
        exportMedicineTable = new javax.swing.JLabel();
        inv_equipment = new javax.swing.JPanel();
        inv_equip_table = new javax.swing.JScrollPane();
        inv_equipmentTable = new javax.swing.JTable();
        inv_med_infopanel1 = new javax.swing.JPanel();
        inv_equip_itemLabel = new javax.swing.JLabel();
        inv_equip_name = new javax.swing.JTextField();
        inv_equip_yearexpiryLabel = new javax.swing.JLabel();
        inv_equip_dateLabel = new javax.swing.JLabel();
        inv_equip_date = new com.toedter.calendar.JDateChooser();
        inv_equip_quantityLabel = new javax.swing.JLabel();
        inv_equip_remarkLabel = new javax.swing.JLabel();
        inv_equip_txt = new javax.swing.JScrollPane();
        inv_equip_remark = new javax.swing.JTextArea();
        inv_equip_inventoryLabel = new javax.swing.JLabel();
        inv_equip_equipmentLabel = new javax.swing.JLabel();
        inv_equip_insertbtn = new javax.swing.JButton();
        inv_equip_deletebtn = new javax.swing.JButton();
        inv_equip_updatebtn = new javax.swing.JButton();
        inv_equip_quantityLabel1 = new javax.swing.JLabel();
        inv_equip_expiry = new javax.swing.JTextField();
        inv_eq_searchID = new javax.swing.JTextField();
        inv_equip_quantityLabel2 = new javax.swing.JLabel();
        inv_equip_quantity = new javax.swing.JSpinner();
        inv_equip_dispensed = new javax.swing.JSpinner();
        exportEquipmentTable = new javax.swing.JLabel();
        int_delmedicine = new javax.swing.JPanel();
        inv_med_table1 = new javax.swing.JScrollPane();
        inv_recent_medtable = new javax.swing.JTable();
        int_delequipments = new javax.swing.JPanel();
        inv_equip_table1 = new javax.swing.JScrollPane();
        inv_recent_equiptable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        homeButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        eq_searchNameLabel = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        resizeButton = new javax.swing.JLabel();
        refreshButton = new javax.swing.JLabel();
        inv_searchName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.BorderLayout());

        inv_frame.setBackground(new java.awt.Color(255, 255, 255));

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
        inv_medTable.setRowSelectionAllowed(false);
        inv_medTable.setShowGrid(true);
        inv_medTable.getTableHeader().setResizingAllowed(false);
        inv_medTable.getTableHeader().setReorderingAllowed(false);
        inv_med_table.setViewportView(inv_medTable);

        inv_med_infopanel.setBackground(new java.awt.Color(53, 64, 142));

        inv_med_itemLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        inv_med_itemLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_itemLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_itemLabel.setText("ITEM NAME:");

        inv_med_name.setBackground(new java.awt.Color(255, 255, 255));
        inv_med_name.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_med_name.setForeground(new java.awt.Color(0, 0, 0));
        inv_med_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inv_med_name.setToolTipText("EX: Biogesic");

        inv_med_expiryLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        inv_med_expiryLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_expiryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_expiryLabel.setText("ITEM YEAR EXPIRY:");

        inv_med_dateLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        inv_med_dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_dateLabel.setText("DATE:");

        inv_med_date.setBackground(new java.awt.Color(255, 255, 255));
        inv_med_date.setForeground(new java.awt.Color(0, 0, 0));
        inv_med_date.setDateFormatString("yyyy-MM-dd");
        inv_med_date.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        inv_med_quantityLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        inv_med_quantityLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_quantityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_quantityLabel.setText("TOTAL QUANTITY:");

        inv_med_remarkLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
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

        inv_med_expiryLabel1.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        inv_med_expiryLabel1.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_expiryLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_expiryLabel1.setText("ITEM MONTH EXPIRY:");

        inv_med_month.setForeground(new java.awt.Color(0, 0, 0));
        inv_med_month.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        inv_med_disposedLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        inv_med_disposedLabel.setForeground(new java.awt.Color(255, 255, 255));
        inv_med_disposedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_med_disposedLabel.setText("ITEM DISPENSED:");

        inv_med_dispensed.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_med_dispensed.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        inv_med_quantity.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_med_quantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        inv_equip_quantityLabel3.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        inv_equip_quantityLabel3.setForeground(new java.awt.Color(255, 255, 255));
        inv_equip_quantityLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_quantityLabel3.setText("SEARCH ID:");

        inv_md_searchID.setBackground(new java.awt.Color(255, 255, 255));
        inv_md_searchID.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_md_searchID.setForeground(new java.awt.Color(0, 0, 0));
        inv_md_searchID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inv_md_searchID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inv_md_searchIDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inv_md_searchIDKeyReleased(evt);
            }
        });

        exportMedicineTable.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        exportMedicineTable.setForeground(new java.awt.Color(0, 0, 0));
        exportMedicineTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exportMedicineTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/export (1).png"))); // NOI18N
        exportMedicineTable.setToolTipText("Export medicine inventory");
        exportMedicineTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportMedicineTable.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        exportMedicineTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportMedicineTableMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout inv_med_infopanelLayout = new javax.swing.GroupLayout(inv_med_infopanel);
        inv_med_infopanel.setLayout(inv_med_infopanelLayout);
        inv_med_infopanelLayout.setHorizontalGroup(
            inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_med_infopanelLayout.createSequentialGroup()
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inv_med_infopanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(inv_med_infopanelLayout.createSequentialGroup()
                                .addComponent(inv_med_quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inv_med_disposedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inv_med_infopanelLayout.createSequentialGroup()
                                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(inv_med_expiryLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(inv_med_itemLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(inv_med_name, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inv_med_year, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inv_med_dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(inv_med_date, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(inv_med_expiryLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(inv_med_month, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inv_med_infopanelLayout.createSequentialGroup()
                                .addComponent(inv_med_quantity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inv_med_dispensed))))
                    .addGroup(inv_med_infopanelLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inv_equip_quantityLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(inv_med_insertbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(inv_md_searchID))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_med_infopanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_med_infopanelLayout.createSequentialGroup()
                        .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inv_med_remarkLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_med_infopanelLayout.createSequentialGroup()
                                .addGap(0, 14, Short.MAX_VALUE)
                                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inv_med_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(inv_med_infopanelLayout.createSequentialGroup()
                                        .addComponent(inv_med_updatebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inv_med_removebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_med_infopanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inv_med_inventoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inv_med_medicineLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(3, 3, 3)
                        .addComponent(exportMedicineTable)
                        .addContainerGap())))
        );
        inv_med_infopanelLayout.setVerticalGroup(
            inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_med_infopanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inv_med_medicineLabel)
                    .addComponent(exportMedicineTable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_med_inventoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inv_med_itemLabel)
                    .addComponent(inv_med_dateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inv_med_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inv_med_date, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inv_med_expiryLabel)
                    .addComponent(inv_med_expiryLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inv_med_year, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(inv_med_month, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inv_med_quantityLabel)
                    .addComponent(inv_med_disposedLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inv_med_dispensed, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inv_med_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(inv_med_remarkLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_med_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inv_med_insertbtn)
                .addGap(28, 28, 28)
                .addComponent(inv_equip_quantityLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_md_searchID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inv_med_infopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inv_med_removebtn)
                    .addComponent(inv_med_updatebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout inv_medicineLayout = new javax.swing.GroupLayout(inv_medicine);
        inv_medicine.setLayout(inv_medicineLayout);
        inv_medicineLayout.setHorizontalGroup(
            inv_medicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_medicineLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inv_med_table, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_med_infopanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        inv_medicineLayout.setVerticalGroup(
            inv_medicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_medicineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inv_medicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inv_med_table)
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
        inv_equipmentTable.setRowSelectionAllowed(false);
        inv_equipmentTable.setShowGrid(true);
        inv_equipmentTable.getTableHeader().setResizingAllowed(false);
        inv_equipmentTable.getTableHeader().setReorderingAllowed(false);
        inv_equip_table.setViewportView(inv_equipmentTable);

        inv_med_infopanel1.setBackground(new java.awt.Color(247, 208, 0));

        inv_equip_itemLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        inv_equip_itemLabel.setForeground(new java.awt.Color(0, 0, 0));
        inv_equip_itemLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_itemLabel.setText("ITEM NAME:");

        inv_equip_name.setBackground(new java.awt.Color(255, 255, 255));
        inv_equip_name.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_equip_name.setForeground(new java.awt.Color(0, 0, 0));
        inv_equip_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inv_equip_name.setToolTipText("EX: 2021-123456");

        inv_equip_yearexpiryLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        inv_equip_yearexpiryLabel.setForeground(new java.awt.Color(0, 0, 0));
        inv_equip_yearexpiryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_yearexpiryLabel.setText("ITEM EXPIRY:");

        inv_equip_dateLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        inv_equip_dateLabel.setForeground(new java.awt.Color(0, 0, 0));
        inv_equip_dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_dateLabel.setText("DATE:");

        inv_equip_date.setBackground(new java.awt.Color(255, 255, 255));
        inv_equip_date.setForeground(new java.awt.Color(0, 0, 0));
        inv_equip_date.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        inv_equip_quantityLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        inv_equip_quantityLabel.setForeground(new java.awt.Color(0, 0, 0));
        inv_equip_quantityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_quantityLabel.setText("TOTAL QUANTITY:");

        inv_equip_remarkLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        inv_equip_remarkLabel.setForeground(new java.awt.Color(0, 0, 0));
        inv_equip_remarkLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_remarkLabel.setText("REMARKS:");

        inv_equip_remark.setBackground(new java.awt.Color(255, 255, 255));
        inv_equip_remark.setColumns(20);
        inv_equip_remark.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_equip_remark.setForeground(new java.awt.Color(0, 0, 0));
        inv_equip_remark.setLineWrap(true);
        inv_equip_remark.setRows(5);
        inv_equip_remark.setWrapStyleWord(true);
        inv_equip_txt.setViewportView(inv_equip_remark);

        inv_equip_inventoryLabel.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        inv_equip_inventoryLabel.setForeground(new java.awt.Color(0, 0, 0));
        inv_equip_inventoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_inventoryLabel.setText("INVENTORY");

        inv_equip_equipmentLabel.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        inv_equip_equipmentLabel.setForeground(new java.awt.Color(0, 0, 0));
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

        inv_equip_quantityLabel1.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        inv_equip_quantityLabel1.setForeground(new java.awt.Color(0, 0, 0));
        inv_equip_quantityLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_quantityLabel1.setText("ITEM DISPENSED:");

        inv_equip_expiry.setBackground(new java.awt.Color(255, 255, 255));
        inv_equip_expiry.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_equip_expiry.setForeground(new java.awt.Color(0, 0, 0));
        inv_equip_expiry.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inv_equip_expiry.setToolTipText("EX: 2021-123456");

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

        inv_equip_quantityLabel2.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        inv_equip_quantityLabel2.setForeground(new java.awt.Color(0, 0, 0));
        inv_equip_quantityLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inv_equip_quantityLabel2.setText("SEARCH ID:");

        inv_equip_quantity.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_equip_quantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        inv_equip_dispensed.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        inv_equip_dispensed.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        exportEquipmentTable.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        exportEquipmentTable.setForeground(new java.awt.Color(0, 0, 0));
        exportEquipmentTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exportEquipmentTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/export (1).png"))); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_med_infopanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inv_equip_inventoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(inv_med_infopanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(inv_med_infopanel1Layout.createSequentialGroup()
                                .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inv_equip_itemLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inv_equip_name, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inv_equip_dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inv_equip_date, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(inv_med_infopanel1Layout.createSequentialGroup()
                                .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inv_equip_quantityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(inv_equip_quantity))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inv_equip_quantityLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inv_equip_dispensed)))
                            .addComponent(inv_equip_yearexpiryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
            .addGroup(inv_med_infopanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inv_med_infopanel1Layout.createSequentialGroup()
                        .addComponent(inv_equip_remarkLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_med_infopanel1Layout.createSequentialGroup()
                        .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inv_equip_txt)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inv_med_infopanel1Layout.createSequentialGroup()
                                .addComponent(inv_equip_updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inv_equip_deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))))
            .addGroup(inv_med_infopanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inv_equip_quantityLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inv_equip_insertbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(inv_eq_searchID))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_med_infopanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_med_infopanel1Layout.createSequentialGroup()
                        .addComponent(inv_equip_expiry, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_med_infopanel1Layout.createSequentialGroup()
                        .addComponent(exportEquipmentTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inv_equip_equipmentLabel)
                        .addGap(57, 57, 57))))
        );
        inv_med_infopanel1Layout.setVerticalGroup(
            inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_med_infopanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inv_equip_equipmentLabel)
                    .addComponent(exportEquipmentTable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_equip_inventoryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inv_equip_itemLabel)
                    .addComponent(inv_equip_dateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inv_equip_name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inv_equip_date, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_equip_yearexpiryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_equip_expiry, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inv_equip_quantityLabel)
                    .addComponent(inv_equip_quantityLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inv_equip_dispensed, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inv_equip_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(inv_equip_remarkLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_equip_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inv_equip_insertbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(inv_equip_quantityLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_eq_searchID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inv_med_infopanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inv_equip_updatebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inv_equip_deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout inv_equipmentLayout = new javax.swing.GroupLayout(inv_equipment);
        inv_equipment.setLayout(inv_equipmentLayout);
        inv_equipmentLayout.setHorizontalGroup(
            inv_equipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_equipmentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inv_med_infopanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_equip_table, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
                .addContainerGap())
        );
        inv_equipmentLayout.setVerticalGroup(
            inv_equipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inv_equipmentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inv_equipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inv_med_infopanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inv_equip_table))
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
        inv_recent_medtable.setRowSelectionAllowed(false);
        inv_recent_medtable.setShowGrid(true);
        inv_recent_medtable.getTableHeader().setResizingAllowed(false);
        inv_recent_medtable.getTableHeader().setReorderingAllowed(false);
        inv_med_table1.setViewportView(inv_recent_medtable);

        javax.swing.GroupLayout int_delmedicineLayout = new javax.swing.GroupLayout(int_delmedicine);
        int_delmedicine.setLayout(int_delmedicineLayout);
        int_delmedicineLayout.setHorizontalGroup(
            int_delmedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1169, Short.MAX_VALUE)
            .addGroup(int_delmedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(int_delmedicineLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(inv_med_table1, javax.swing.GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        int_delmedicineLayout.setVerticalGroup(
            int_delmedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
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
        inv_recent_equiptable.setRowSelectionAllowed(false);
        inv_recent_equiptable.setShowGrid(true);
        inv_recent_equiptable.getTableHeader().setResizingAllowed(false);
        inv_recent_equiptable.getTableHeader().setReorderingAllowed(false);
        inv_equip_table1.setViewportView(inv_recent_equiptable);

        javax.swing.GroupLayout int_delequipmentsLayout = new javax.swing.GroupLayout(int_delequipments);
        int_delequipments.setLayout(int_delequipmentsLayout);
        int_delequipmentsLayout.setHorizontalGroup(
            int_delequipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1169, Short.MAX_VALUE)
            .addGroup(int_delequipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(int_delequipmentsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(inv_equip_table1, javax.swing.GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        int_delequipmentsLayout.setVerticalGroup(
            int_delequipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
            .addGroup(int_delequipmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(int_delequipmentsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(inv_equip_table1)
                    .addContainerGap()))
        );

        inv_inventorymanager.addTab("RECENTLY DELETED EQUIPMENT", int_delequipments);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home (1).png"))); // NOI18N
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButtonMouseClicked(evt);
            }
        });

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimize-sign (1).png"))); // NOI18N
        minimizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
        });

        eq_searchNameLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        eq_searchNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        eq_searchNameLabel.setText("SEARCH MEDICINE/EQUIPMENT:");

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit (1).png"))); // NOI18N
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        resizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimize (1).png"))); // NOI18N
        resizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resizeButtonMouseClicked(evt);
            }
        });

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh (1).png"))); // NOI18N
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eq_searchNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inv_searchName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resizeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minimizeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inv_searchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eq_searchNameLabel))
                    .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        inv_frameLayout.setVerticalGroup(
            inv_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inv_frameLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

                DefaultTableModel invmedTable = (DefaultTableModel) inv_medTable.getModel();
                invmedTable.setRowCount(0);

                JOptionPane.showMessageDialog(null, "Medicine successfully added to inventory!", "Success!", JOptionPane.INFORMATION_MESSAGE);

                loadData();
                con.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }//GEN-LAST:event_inv_med_insertbtnActionPerformed

    private void inv_med_removebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_med_removebtnActionPerformed
        Date date = inv_med_date.getDate();
        String formattedDate;
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            formattedDate = sdf.format(date);
        } else {
            formattedDate = "";
        }
        String url, user, pass, ID;
        int notFound = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            url = "jdbc:mysql://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            ID = inv_md_searchID.getText();
            if ("".equals(ID)) {
                JOptionPane.showMessageDialog(new JFrame(), "Medicine ID is required to proceed.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
            } else {

                if ("".equals(inv_md_searchID.getText())) {
                    JOptionPane.showMessageDialog(null, "Medicine ID required to proceed.", "Error: ID", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String sql = "SELECT * FROM medicine_inventory WHERE md_id = " + ID;
                    ResultSet rs = st.executeQuery(sql);

                    if (rs.next()) {
                        notFound = 1;

                        sql = "INSERT INTO removed_medicine (md_id, md_date, md_item, md_quantity, md_dispensed, md_year_expiry, md_month_expiry, md_remarks, md_totalquantity) VALUES (?,?,?,?,?,?,?,?,?)";
                        PreparedStatement pst = con.prepareStatement(sql);
                        pst.setString(1, ID);
                        pst.setString(2, formattedDate);
                        pst.setString(3, inv_med_name.getText());
                        pst.setInt(4, (int) inv_med_quantity.getValue() - (int) inv_med_dispensed.getValue());
                        pst.setInt(5, (int) inv_med_dispensed.getValue());
                        pst.setInt(6, (int) inv_med_year.getYear());
                        pst.setInt(7, inv_med_month.getMonth());
                        pst.setString(8, inv_med_remark.getText());
                        pst.setInt(9, (int) inv_med_quantity.getValue());
                        pst.executeUpdate();

                        sql = "DELETE FROM medicine_inventory WHERE md_id = " + ID;
                        st.executeUpdate(sql);

                        inv_med_name.setText("");
                        inv_med_year.setYear(2024);
                        inv_med_month.setMonth(0);
                        inv_med_remark.setText("");
                        inv_med_quantity.setValue(0);
                        inv_med_dispensed.setValue(0);

                        inv_md_searchID.setText("");

                        DefaultTableModel invRemovedMedsTable = (DefaultTableModel) inv_recent_medtable.getModel();
                        invRemovedMedsTable.setRowCount(0);

                        DefaultTableModel invmedTable = (DefaultTableModel) inv_medTable.getModel();
                        invmedTable.setRowCount(0);

                        JOptionPane.showMessageDialog(new JFrame(), "Selected ID of medicine removed from inventory.", "UPDATE: ID", JOptionPane.INFORMATION_MESSAGE);

                        removed_medsLoadData();
                        loadData();

                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid ID. Please select from the table.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }//GEN-LAST:event_inv_med_removebtnActionPerformed

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

                DefaultTableModel invequipTable = (DefaultTableModel) inv_equipmentTable.getModel();
                invequipTable.setRowCount(0);

                JOptionPane.showMessageDialog(null, "Equipment successfully added to inventory!", "Success!", JOptionPane.INFORMATION_MESSAGE);

                eq_loadData();
                con.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
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

        medTable.setRowCount(0);
        invRemovedMedsTable.setRowCount(0);
        equipTable.setRowCount(0);

        JOptionPane.showMessageDialog(null, "Reloading Successful.", "UPDATE: Reload", JOptionPane.INFORMATION_MESSAGE);

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

    private void inv_equip_updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_equip_updatebtnActionPerformed
        String item, expiry, remarks;
        int totalquantity, quantity, disposed;
        Date date = inv_equip_date.getDate();
        String formattedDate;
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            formattedDate = sdf.format(date);
        } else {
            formattedDate = "";
        }
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
                JOptionPane.showMessageDialog(new JFrame(), "Equipment ID is required to proceed.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
            } else {

                if ("".equals(inv_eq_searchID.getText())) {
                    JOptionPane.showMessageDialog(null, "Equipment ID required to proceed.", "Error: ID", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String sql = "SELECT * FROM equipment_inventory WHERE eq_id = " + ID;
                    ResultSet rs = st.executeQuery(sql);

                    Statement stUpdate = con.createStatement();

                    while (rs.next()) {

                        item = inv_equip_name.getText();
                        expiry = inv_equip_expiry.getText();
                        remarks = inv_equip_remark.getText();
                        quantity = (int) inv_equip_quantity.getValue();
                        totalquantity = (int) inv_equip_quantity.getValue();
                        disposed = (int) inv_equip_dispensed.getValue();

                        String updateSql = "UPDATE equipment_inventory SET eq_date = '" + formattedDate + "', eq_item = '" + item + "', eq_quantity = '" + (quantity - disposed) + "', eq_disposed = '" + disposed + "', eq_expiry = '" + expiry + "', eq_remarks = '" + remarks + "', eq_totalquantity = '" + totalquantity + "' WHERE eq_id = " + ID;
                        stUpdate.executeUpdate(updateSql);

                        DefaultTableModel equipTable = (DefaultTableModel) inv_equipmentTable.getModel();
                        equipTable.setRowCount(0);

                        notFound = 1;

                        JOptionPane.showMessageDialog(new JFrame(), "Update Successful!", "UPDATE", JOptionPane.INFORMATION_MESSAGE);

                        inv_equip_name.setText("");
                        inv_equip_expiry.setText("");
                        inv_equip_remark.setText("");
                        inv_equip_quantity.setValue(0);
                        inv_equip_dispensed.setValue(0);

                        inv_eq_searchID.setText("");

                        eq_loadData();

                    }
                    rs.close();
                    st.close();
                    if (notFound == 0) {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid ID. Please select from the table.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }//GEN-LAST:event_inv_equip_updatebtnActionPerformed

    private void inv_med_updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_med_updatebtnActionPerformed
        String item, remarks;
        int quantity, totalquantity, disposed, year, month;
        Date date = inv_med_date.getDate();
        String formattedDate;
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            formattedDate = sdf.format(date);
        } else {
            formattedDate = "";
        }
        String url, user, pass, ID;
        int notFound = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            ID = inv_md_searchID.getText();
            if ("".equals(ID)) {
                JOptionPane.showMessageDialog(new JFrame(), "Medicine ID is required to proceed.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
            } else {

                if ("".equals(inv_md_searchID.getText())) {
                    JOptionPane.showMessageDialog(null, "Medicine ID required to proceed.", "Error: ID", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String sql = "SELECT * FROM medicine_inventory WHERE md_id = " + ID;
                    ResultSet rs = st.executeQuery(sql);

                    Statement stUpdate = con.createStatement();

                    while (rs.next()) {

                        item = inv_med_name.getText();
                        year = (int) inv_med_year.getYear();
                        month = inv_med_month.getMonth();
                        remarks = inv_med_remark.getText();
                        disposed = (int) inv_med_dispensed.getValue();
                        quantity = (int) inv_med_quantity.getValue() - disposed;
                        totalquantity = (int) inv_med_quantity.getValue();

                        String updateSql = "UPDATE medicine_inventory SET md_date = '" + formattedDate + "', md_item = '" + item + "', md_quantity = '" + quantity + "', md_disposed = '" + disposed + "', md_year_expiry = '" + year + "', md_month_expiry = '" + month + "', md_remarks = '" + remarks + "', md_totalquantity = '" + totalquantity + "' WHERE md_id = " + ID;
                        stUpdate.executeUpdate(updateSql);

                        DefaultTableModel medTable = (DefaultTableModel) inv_medTable.getModel();
                        medTable.setRowCount(0);

                        notFound = 1;

                        JOptionPane.showMessageDialog(new JFrame(), "Update Successful!", "UPDATE", JOptionPane.INFORMATION_MESSAGE);

                        inv_med_name.setText("");
                        inv_med_year.setYear(0);
                        inv_med_month.setMonth(0);
                        inv_med_remark.setText("");
                        inv_med_quantity.setValue(0);
                        inv_med_dispensed.setValue(0);

                        inv_md_searchID.setText("");

                        loadData();

                    }
                    rs.close();
                    st.close();
                    if (notFound == 0) {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid ID. Please select from the table.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }//GEN-LAST:event_inv_med_updatebtnActionPerformed

    private void inv_eq_searchIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inv_eq_searchIDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_inv_eq_searchIDKeyReleased

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
                            inv_equip_dispensed.setValue(rs.getInt("eq_disposed"));
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

    private void inv_md_searchIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inv_md_searchIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if ("".equals(inv_md_searchID.getText())) {
                JOptionPane.showMessageDialog(null, "Input a valid Medicine id number to proceed.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
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

                    ID = inv_md_searchID.getText();
                    if ("".equals(ID)) {
                        JOptionPane.showMessageDialog(new JFrame(), "ID of the equipment is required to proceed.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String sql = "SELECT * FROM medicine_inventory WHERE md_id = " + ID;
                        ResultSet rs = st.executeQuery(sql);

                        while (rs.next()) {
                            inv_med_name.setText(rs.getString("md_item"));
                            inv_med_date.setDate(rs.getDate("md_date"));
                            inv_med_year.setYear(rs.getInt("md_year_expiry"));
                            inv_med_month.setMonth(rs.getInt("md_month_expiry"));
                            inv_med_quantity.setValue(rs.getInt("md_totalquantity"));
                            inv_med_dispensed.setValue(rs.getInt("md_disposed"));
                            inv_med_remark.setText(rs.getString("md_remarks"));
                            notFound = 1;
                            JOptionPane.showMessageDialog(null, "Medicine selected.", "INFORM: Selected", JOptionPane.INFORMATION_MESSAGE);
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
    }//GEN-LAST:event_inv_md_searchIDKeyPressed

    private void inv_md_searchIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inv_md_searchIDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_inv_md_searchIDKeyReleased

    private void inv_equip_deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_equip_deletebtnActionPerformed
        Date date = inv_equip_date.getDate();
        String formattedDate;
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            formattedDate = sdf.format(date);
        } else {
            formattedDate = "";
        }
        String url, user, pass, ID;
        int notFound = 0;

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

                        sql = "INSERT INTO removed_equipment (eq_id, eq_date, eq_item, eq_quantity, eq_dispensed, eq_expiry, eq_remarks, eq_totalquantity) VALUES (?,?,?,?,?,?,?,?)";
                        PreparedStatement pst = con.prepareStatement(sql);
                        pst.setString(1, ID);
                        pst.setString(2, formattedDate);
                        pst.setString(3, inv_equip_name.getText());
                        pst.setInt(4, (int) inv_equip_quantity.getValue() - (int) inv_equip_dispensed.getValue());
                        pst.setInt(5, (int) inv_equip_dispensed.getValue());
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
                        inv_equip_dispensed.setValue(0);

                        inv_eq_searchID.setText("");

                        DefaultTableModel invRemovedEquipTable = (DefaultTableModel) inv_recent_equiptable.getModel();
                        invRemovedEquipTable.setRowCount(0);

                        DefaultTableModel equipTable = (DefaultTableModel) inv_equipmentTable.getModel();
                        equipTable.setRowCount(0);

                        JOptionPane.showMessageDialog(new JFrame(), "Selected ID of equipment removed from inventory.", "UPDATE: ID", JOptionPane.INFORMATION_MESSAGE);

                        removed_equipsLoadData();
                        eq_loadData();

                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid ID. Please select from the table.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }//GEN-LAST:event_inv_equip_deletebtnActionPerformed

    private void exportMedicineTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportMedicineTableMouseClicked
        MessageFormat header = new MessageFormat("Medicine Inventory Records");
        MessageFormat footer = new MessageFormat("");
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);
            inv_medTable.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, set, true);
            JOptionPane.showMessageDialog(null, "Printed Successfully");
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null, "Failed");
        }
    }//GEN-LAST:event_exportMedicineTableMouseClicked

    private void exportEquipmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportEquipmentTableMouseClicked
        MessageFormat header = new MessageFormat("Equipement Inventory Records");
        MessageFormat footer = new MessageFormat("");
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);
            inv_medTable.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, set, true);
            JOptionPane.showMessageDialog(null, "Printed Successfully");
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null, "Failed");
        }
    }//GEN-LAST:event_exportEquipmentTableMouseClicked

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
    private javax.swing.JPanel int_delequipments;
    private javax.swing.JPanel int_delmedicine;
    private javax.swing.JTextField inv_eq_searchID;
    private com.toedter.calendar.JDateChooser inv_equip_date;
    private javax.swing.JLabel inv_equip_dateLabel;
    private javax.swing.JButton inv_equip_deletebtn;
    private javax.swing.JSpinner inv_equip_dispensed;
    private javax.swing.JLabel inv_equip_equipmentLabel;
    private javax.swing.JTextField inv_equip_expiry;
    private javax.swing.JButton inv_equip_insertbtn;
    private javax.swing.JLabel inv_equip_inventoryLabel;
    private javax.swing.JLabel inv_equip_itemLabel;
    private javax.swing.JTextField inv_equip_name;
    private javax.swing.JSpinner inv_equip_quantity;
    private javax.swing.JLabel inv_equip_quantityLabel;
    private javax.swing.JLabel inv_equip_quantityLabel1;
    private javax.swing.JLabel inv_equip_quantityLabel2;
    private javax.swing.JLabel inv_equip_quantityLabel3;
    private javax.swing.JTextArea inv_equip_remark;
    private javax.swing.JLabel inv_equip_remarkLabel;
    private javax.swing.JScrollPane inv_equip_table;
    private javax.swing.JScrollPane inv_equip_table1;
    private javax.swing.JScrollPane inv_equip_txt;
    private javax.swing.JButton inv_equip_updatebtn;
    private javax.swing.JLabel inv_equip_yearexpiryLabel;
    private javax.swing.JPanel inv_equipment;
    private javax.swing.JTable inv_equipmentTable;
    private javax.swing.JPanel inv_frame;
    private javax.swing.JTabbedPane inv_inventorymanager;
    private javax.swing.JTextField inv_md_searchID;
    private javax.swing.JTable inv_medTable;
    private com.toedter.calendar.JDateChooser inv_med_date;
    private javax.swing.JLabel inv_med_dateLabel;
    private javax.swing.JSpinner inv_med_dispensed;
    private javax.swing.JLabel inv_med_disposedLabel;
    private javax.swing.JLabel inv_med_expiryLabel;
    private javax.swing.JLabel inv_med_expiryLabel1;
    private javax.swing.JPanel inv_med_infopanel;
    private javax.swing.JPanel inv_med_infopanel1;
    private javax.swing.JButton inv_med_insertbtn;
    private javax.swing.JLabel inv_med_inventoryLabel;
    private javax.swing.JLabel inv_med_itemLabel;
    private javax.swing.JLabel inv_med_medicineLabel;
    private com.toedter.calendar.JMonthChooser inv_med_month;
    private javax.swing.JTextField inv_med_name;
    private javax.swing.JSpinner inv_med_quantity;
    private javax.swing.JLabel inv_med_quantityLabel;
    private javax.swing.JTextArea inv_med_remark;
    private javax.swing.JLabel inv_med_remarkLabel;
    private javax.swing.JButton inv_med_removebtn;
    private javax.swing.JScrollPane inv_med_table;
    private javax.swing.JScrollPane inv_med_table1;
    private javax.swing.JScrollPane inv_med_txt;
    private javax.swing.JButton inv_med_updatebtn;
    private com.toedter.calendar.JYearChooser inv_med_year;
    private javax.swing.JPanel inv_medicine;
    private javax.swing.JTable inv_recent_equiptable;
    private javax.swing.JTable inv_recent_medtable;
    private javax.swing.JTextField inv_searchName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JLabel refreshButton;
    private javax.swing.JLabel resizeButton;
    // End of variables declaration//GEN-END:variables
}
