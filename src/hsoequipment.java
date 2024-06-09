
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class hsoequipment extends javax.swing.JFrame {

    Date date = new Date();
    
    public hsoequipment() {
        initComponents();
        eq_loadData();
        eq_loadPatientData();
        eq_date.setMinSelectableDate(date);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eq_timeBorrowed = new cambodia.raven.Time();
        eq_timeReturned = new cambodia.raven.Time();
        eq_searchItem = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eq_patients = new javax.swing.JTable();
        md_infoPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        eq_equipments = new javax.swing.JTable();
        eq_id = new javax.swing.JTextField();
        eq_fname = new javax.swing.JTextField();
        eq_txtTimeBorrowed = new javax.swing.JTextField();
        eq_designation = new javax.swing.JTextField();
        eq_equipment = new javax.swing.JTextField();
        eq_fnameLabel = new javax.swing.JLabel();
        eq_equipmentLabel = new javax.swing.JLabel();
        eq_dateLabel = new javax.swing.JLabel();
        eq_timeLabel = new javax.swing.JLabel();
        eq_departmentLabel = new javax.swing.JLabel();
        eq_idLabel = new javax.swing.JLabel();
        eq_genderLabel = new javax.swing.JLabel();
        eq_designationLabel = new javax.swing.JLabel();
        eq_date = new com.toedter.calendar.JDateChooser();
        eq_timeBorrowedbtn = new javax.swing.JButton();
        eq_department = new javax.swing.JComboBox<>();
        eq_gender = new javax.swing.JComboBox<>();
        eq_submitbtn = new javax.swing.JButton();
        eq_timeLabel1 = new javax.swing.JLabel();
        eq_txtTimeReturned = new javax.swing.JTextField();
        eq_searchID = new javax.swing.JTextField();
        eq_searchIdLabel = new javax.swing.JLabel();
        eq_searchPatientID = new javax.swing.JTextField();
        eq_updatebtn = new javax.swing.JButton();
        eq_timeReturnedbtn = new javax.swing.JButton();
        eq_searchPatientLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        refreshButton = new javax.swing.JLabel();
        eq_searchName = new javax.swing.JTextField();
        resizeButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        eq_searchNameLabel = new javax.swing.JLabel();
        eq_searchEquipment = new javax.swing.JTextField();
        exitButton = new javax.swing.JLabel();
        eq_searchEquipmentLabel = new javax.swing.JLabel();
        homeButton = new javax.swing.JLabel();
        EquipemtnExportTable = new javax.swing.JLabel();

        eq_timeBorrowed.setTextRefernce(eq_txtTimeBorrowed);

        eq_timeReturned.setTextRefernce(eq_txtTimeReturned);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.BorderLayout());

        eq_searchItem.setBackground(new java.awt.Color(255, 255, 255));

        eq_patients.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        eq_patients.setForeground(new java.awt.Color(0, 0, 0));
        eq_patients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PATIENT NO.", "STUDENT ID", "DATE", "NAME", "SEX", "DESIGNATION", "DEPARTMENT", "TIME BORROWED", "TIME RETURNED", "EQUIPMENT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        eq_patients.setShowGrid(true);
        eq_patients.getTableHeader().setResizingAllowed(false);
        eq_patients.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(eq_patients);

        md_infoPanel.setBackground(new java.awt.Color(53, 64, 142));

        eq_equipments.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        eq_equipments.setForeground(new java.awt.Color(0, 0, 0));
        eq_equipments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATE", "ITEM", "QUANTITY LEFT", "NO. DISPENSED", "EXPIRY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        eq_equipments.setShowGrid(true);
        eq_equipments.getTableHeader().setResizingAllowed(false);
        eq_equipments.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(eq_equipments);

        eq_id.setBackground(new java.awt.Color(255, 255, 255));
        eq_id.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_id.setForeground(new java.awt.Color(0, 0, 0));
        eq_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eq_id.setToolTipText("EX: 2021-123456");

        eq_fname.setBackground(new java.awt.Color(255, 255, 255));
        eq_fname.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_fname.setForeground(new java.awt.Color(0, 0, 0));
        eq_fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eq_fname.setToolTipText("EX: Cruz, Juan Pogi A.");

        eq_txtTimeBorrowed.setEditable(false);
        eq_txtTimeBorrowed.setBackground(new java.awt.Color(255, 255, 255));
        eq_txtTimeBorrowed.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_txtTimeBorrowed.setForeground(new java.awt.Color(0, 0, 0));
        eq_txtTimeBorrowed.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eq_txtTimeBorrowed.setToolTipText("Click the button beside this field for the time selector to show up.");

        eq_designation.setBackground(new java.awt.Color(255, 255, 255));
        eq_designation.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_designation.setForeground(new java.awt.Color(0, 0, 0));
        eq_designation.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        eq_equipment.setEditable(false);
        eq_equipment.setBackground(new java.awt.Color(255, 255, 255));
        eq_equipment.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_equipment.setForeground(new java.awt.Color(0, 0, 0));
        eq_equipment.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eq_equipment.setToolTipText("Select the row of equipment on the table beside this field.");

        eq_fnameLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        eq_fnameLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_fnameLabel.setText("FULL NAME:");

        eq_equipmentLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        eq_equipmentLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_equipmentLabel.setText("EQUIPMENT");

        eq_dateLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        eq_dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_dateLabel.setText("DATE:");

        eq_timeLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        eq_timeLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_timeLabel.setText("TIME BORROWED:");

        eq_departmentLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        eq_departmentLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_departmentLabel.setText("DEPARTMENT:");

        eq_idLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        eq_idLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_idLabel.setText("NATIONALIAN ID:");

        eq_genderLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        eq_genderLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_genderLabel.setText("SEX:");

        eq_designationLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        eq_designationLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_designationLabel.setText("DESIGNATION:");

        eq_date.setBackground(new java.awt.Color(255, 255, 255));
        eq_date.setForeground(new java.awt.Color(0, 0, 0));
        eq_date.setDateFormatString("yyyy-MM-dd");
        eq_date.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        eq_timeBorrowedbtn.setBackground(new java.awt.Color(255, 255, 255));
        eq_timeBorrowedbtn.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_timeBorrowedbtn.setForeground(new java.awt.Color(0, 0, 0));
        eq_timeBorrowedbtn.setText("...");
        eq_timeBorrowedbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eq_timeBorrowedbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eq_timeBorrowedbtnActionPerformed(evt);
            }
        });

        eq_department.setBackground(new java.awt.Color(255, 255, 255));
        eq_department.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_department.setForeground(new java.awt.Color(0, 0, 0));
        eq_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Senior HighSchool", "Faculty", "BS Information Technology", "BS-Computer Engineering", "BS-Civil Engineering", "BS-Architecture", "BA-Economics", "BS-Pychology", "BA-English Language Studies", "B-Physical Education", "Graduate Studies", "BS-Tourism Management", "BS-Hospitality Management", "BSBA-Financial Management", "BSBA-Marketing Management", "BS-Accountancy", "BS-Accounting Information System", "HUMMS", "ABM", "STEM", "Sports Track", "Faculty", "Staff" }));
        eq_department.setSelectedIndex(-1);
        eq_department.setBorder(null);

        eq_gender.setBackground(new java.awt.Color(255, 255, 255));
        eq_gender.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_gender.setForeground(new java.awt.Color(0, 0, 0));
        eq_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        eq_gender.setSelectedIndex(-1);
        eq_gender.setBorder(null);

        eq_submitbtn.setBackground(new java.awt.Color(51, 102, 0));
        eq_submitbtn.setFont(new java.awt.Font("Monospaced", 0, 23)); // NOI18N
        eq_submitbtn.setForeground(new java.awt.Color(255, 255, 255));
        eq_submitbtn.setText("SUBMIT");
        eq_submitbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eq_submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eq_submitbtnActionPerformed(evt);
            }
        });

        eq_timeLabel1.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        eq_timeLabel1.setForeground(new java.awt.Color(255, 255, 255));
        eq_timeLabel1.setText("TIME RETUNED:");

        eq_txtTimeReturned.setBackground(new java.awt.Color(255, 255, 255));
        eq_txtTimeReturned.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_txtTimeReturned.setForeground(new java.awt.Color(0, 0, 0));
        eq_txtTimeReturned.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eq_txtTimeReturned.setToolTipText("");

        eq_searchID.setBackground(new java.awt.Color(255, 255, 255));
        eq_searchID.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_searchID.setToolTipText("Enter equipment number");
        eq_searchID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                eq_searchIDKeyPressed(evt);
            }
        });

        eq_searchIdLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        eq_searchIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_searchIdLabel.setText("Equipment ID:");

        eq_searchPatientID.setBackground(new java.awt.Color(255, 255, 255));
        eq_searchPatientID.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_searchPatientID.setToolTipText("Enter patient number.");
        eq_searchPatientID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eq_searchPatientIDActionPerformed(evt);
            }
        });
        eq_searchPatientID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                eq_searchPatientIDKeyPressed(evt);
            }
        });

        eq_updatebtn.setBackground(new java.awt.Color(51, 102, 0));
        eq_updatebtn.setFont(new java.awt.Font("Monospaced", 0, 23)); // NOI18N
        eq_updatebtn.setForeground(new java.awt.Color(255, 255, 255));
        eq_updatebtn.setText("UPDATE");
        eq_updatebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eq_updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eq_updatebtnActionPerformed(evt);
            }
        });

        eq_timeReturnedbtn.setBackground(new java.awt.Color(255, 255, 255));
        eq_timeReturnedbtn.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_timeReturnedbtn.setForeground(new java.awt.Color(0, 0, 0));
        eq_timeReturnedbtn.setText("...");
        eq_timeReturnedbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eq_timeReturnedbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eq_timeReturnedbtn.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        eq_timeReturnedbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eq_timeReturnedbtnActionPerformed(evt);
            }
        });

        eq_searchPatientLabel.setFont(new java.awt.Font("Monospaced", 3, 12)); // NOI18N
        eq_searchPatientLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_searchPatientLabel.setText("Patient ID:");

        javax.swing.GroupLayout md_infoPanelLayout = new javax.swing.GroupLayout(md_infoPanel);
        md_infoPanel.setLayout(md_infoPanelLayout);
        md_infoPanelLayout.setHorizontalGroup(
            md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(md_infoPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(md_infoPanelLayout.createSequentialGroup()
                        .addComponent(eq_searchPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eq_searchPatientLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eq_updatebtn)
                        .addGap(143, 143, 143)
                        .addComponent(eq_submitbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eq_searchIdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eq_searchID, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(md_infoPanelLayout.createSequentialGroup()
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(md_infoPanelLayout.createSequentialGroup()
                                .addComponent(eq_dateLabel)
                                .addGap(233, 233, 233))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, md_infoPanelLayout.createSequentialGroup()
                                .addComponent(eq_date, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eq_timeLabel)
                            .addGroup(md_infoPanelLayout.createSequentialGroup()
                                .addComponent(eq_txtTimeBorrowed, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(eq_timeBorrowedbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(md_infoPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eq_department, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eq_departmentLabel)))
                            .addGroup(md_infoPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eq_equipmentLabel)
                                    .addComponent(eq_equipment, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(md_infoPanelLayout.createSequentialGroup()
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eq_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eq_fnameLabel))
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(md_infoPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(eq_timeLabel1))
                            .addGroup(md_infoPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(eq_txtTimeReturned, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(eq_timeReturnedbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(md_infoPanelLayout.createSequentialGroup()
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eq_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eq_idLabel))
                        .addGap(18, 18, 18)
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eq_genderLabel)
                            .addComponent(eq_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eq_designationLabel)
                            .addComponent(eq_designation, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        md_infoPanelLayout.setVerticalGroup(
            md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(md_infoPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eq_idLabel)
                    .addComponent(eq_genderLabel)
                    .addComponent(eq_designationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eq_id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eq_designation, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(eq_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eq_dateLabel)
                        .addComponent(eq_timeLabel))
                    .addComponent(eq_departmentLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eq_timeBorrowedbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eq_txtTimeBorrowed)
                    .addComponent(eq_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eq_department, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eq_fnameLabel)
                        .addComponent(eq_timeLabel1))
                    .addComponent(eq_equipmentLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(eq_txtTimeReturned)
                        .addComponent(eq_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eq_timeReturnedbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(eq_equipment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eq_searchID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eq_submitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eq_searchIdLabel)
                        .addComponent(eq_updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eq_searchPatientLabel)
                        .addComponent(eq_searchPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(md_infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh (1).png"))); // NOI18N
        refreshButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
            }
        });

        eq_searchName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        eq_searchName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eq_searchNameKeyReleased(evt);
            }
        });

        resizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimize (1).png"))); // NOI18N
        resizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resizeButtonMouseClicked(evt);
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
        eq_searchNameLabel.setText("SEARCH NAME OF BORROWER:");

        eq_searchEquipment.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        eq_searchEquipment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eq_searchEquipmentKeyReleased(evt);
            }
        });

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit (1).png"))); // NOI18N
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        eq_searchEquipmentLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        eq_searchEquipmentLabel.setForeground(new java.awt.Color(0, 0, 0));
        eq_searchEquipmentLabel.setText("SEARCH EQUIPMENT:");

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home (1).png"))); // NOI18N
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButtonMouseClicked(evt);
            }
        });

        EquipemtnExportTable.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        EquipemtnExportTable.setForeground(new java.awt.Color(0, 0, 0));
        EquipemtnExportTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EquipemtnExportTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/export (1).png"))); // NOI18N
        EquipemtnExportTable.setToolTipText("Export patient's table");
        EquipemtnExportTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EquipemtnExportTable.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        EquipemtnExportTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EquipemtnExportTableMouseClicked(evt);
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
                .addComponent(EquipemtnExportTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eq_searchNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eq_searchName, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eq_searchEquipment, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(eq_searchEquipmentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eq_searchNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eq_searchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eq_searchEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eq_searchEquipmentLabel))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(exitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(resizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(EquipemtnExportTable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout eq_searchItemLayout = new javax.swing.GroupLayout(eq_searchItem);
        eq_searchItem.setLayout(eq_searchItemLayout);
        eq_searchItemLayout.setHorizontalGroup(
            eq_searchItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eq_searchItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eq_searchItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(md_infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(10, 10, 10))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        eq_searchItemLayout.setVerticalGroup(
            eq_searchItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eq_searchItemLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(md_infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(eq_searchItem, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void eq_timeBorrowedbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eq_timeBorrowedbtnActionPerformed
        eq_timeBorrowed.showPopup();
    }//GEN-LAST:event_eq_timeBorrowedbtnActionPerformed

    private void eq_submitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eq_submitbtnActionPerformed

        String url, user, pass, query;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement st = con.prepareStatement("INSERT INTO equipment_borrowers(eq_patient_id, eq_date, eq_fname, eq_gender, eq_designation, eq_department, eq_timeBorrowed, eq_equipment) VALUES (?,?,?,?,?,?,?,?)");

            Date med_date = eq_date.getDate();
            String formattedDate;

            if (med_date != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                formattedDate = sdf.format(med_date);
            } else {
                formattedDate = "";
            }

            if (eq_date.getDate() == null) {
                JOptionPane.showMessageDialog(new JFrame(), "Date added of patient is required to proceed.", "ERROR: Date", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(eq_id.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Patient ID is required to proceed.", "ERROR: Patient ID", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(eq_fname.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Patient Name is required to proceed.", "ERROR: Patient Name", JOptionPane.ERROR_MESSAGE);
            } else if (eq_gender.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(new JFrame(), "Patient gender is required to proceed.", "ERROR: Patient Gender", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(eq_txtTimeBorrowed.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Time of visitation is required to proceed.", "ERROR: Time Borrowed", JOptionPane.ERROR_MESSAGE);
            } else if (eq_department.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(new JFrame(), "Department of the patient is required to proceed.", "ERROR: Department", JOptionPane.ERROR_MESSAGE);
            } else {

                String equip_patientID = eq_id.getText().toUpperCase();
                String equip_fname = eq_fname.getText().toUpperCase();
                String equip_timeBorrowed = eq_txtTimeBorrowed.getText().toUpperCase();
                String equip_timeReturned = eq_txtTimeReturned.getText().toUpperCase();
                String equip_department = eq_department.getSelectedItem().toString();
                String equip_gender = eq_gender.getSelectedItem().toString();
                String equip_designation = eq_designation.getText();
                String equip_equipment = eq_equipment.getText();

                query = "INSERT INTO equipment_borrowers(eq_patient_id, eq_date, eq_fname, eq_gender, eq_designation, eq_department, eq_timeBorrowed, eq_timeReturned, eq_equipment) " + "VALUES ('" + equip_patientID + "', '" + formattedDate + "', '" + equip_fname + "','" + equip_gender + "' , '" + equip_designation + "', '" + equip_department + "', '" + equip_timeBorrowed + "', '" + equip_timeReturned + "', '" + equip_equipment + "')";
                st.executeUpdate(query);

                DefaultTableModel equipPatientTable = (DefaultTableModel) eq_patients.getModel();
                DefaultTableModel equipTable = (DefaultTableModel) eq_equipments.getModel();

                equipPatientTable.setRowCount(0);
                equipTable.setRowCount(0);

                JOptionPane.showMessageDialog(new JFrame(), "Borrower successfully recorded!", "UPDATE", JOptionPane.INFORMATION_MESSAGE);

                disposedEquipment();
                borrowedEquipment();

                eq_loadPatientData();
                eq_loadData();

                eq_id.setText("");
                eq_fname.setText("");
                eq_txtTimeBorrowed.setText("");
                eq_txtTimeReturned.setText("");
                eq_department.setSelectedItem(null);
                eq_gender.setSelectedItem(null);
                eq_designation.setText("");
                eq_equipment.setText("");
                eq_searchID.setText("");

                con.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }//GEN-LAST:event_eq_submitbtnActionPerformed

    private void eq_updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eq_updatebtnActionPerformed
        String patientID, fname, gender, designation, timeBorrowed, department, equipment, timeReturned;
        Date date = eq_date.getDate();
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

            ID = eq_searchPatientID.getText();
            if ("".equals(ID)) {
                JOptionPane.showMessageDialog(new JFrame(), "Patient id is required to proceed.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
            } else {

                if ("".equals(eq_searchID.getText())) {
                    JOptionPane.showMessageDialog(null, "Equipment ID required to proceed.", "Error: ID", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String sql = "SELECT * FROM equipment_borrowers WHERE eq_id = " + ID;
                    ResultSet rs = st.executeQuery(sql);

                    Statement stUpdate = con.createStatement();

                    while (rs.next()) {
                        patientID = eq_id.getText();
                        fname = eq_fname.getText();
                        gender = (String) eq_gender.getSelectedItem();
                        department = (String) eq_department.getSelectedItem();
                        designation = eq_designation.getText();
                        equipment = eq_equipment.getText();
                        timeReturned = eq_txtTimeReturned.getText();
                        timeBorrowed = eq_txtTimeBorrowed.getText();

                        String updateSql = "UPDATE equipment_borrowers SET eq_patient_id = '" + patientID + "', eq_date = '" + formattedDate + "', "
                                + "eq_fname = '" + fname + "', eq_gender = '" + gender + "', eq_designation = '" + designation + "', eq_department = '" + department + "',eq_timeBorrowed = '" + timeBorrowed + "',"
                                + "eq_timeReturned = '" + timeReturned + "',eq_equipment = '" + equipment + "' WHERE eq_id = " + ID;
                        stUpdate.executeUpdate(updateSql);

                        DefaultTableModel equipPatientTable = (DefaultTableModel) eq_patients.getModel();
                        equipPatientTable.setRowCount(0);

                        DefaultTableModel equipTable = (DefaultTableModel) eq_equipments.getModel();
                        equipTable.setRowCount(0);

                        notFound = 1;

                        JOptionPane.showMessageDialog(new JFrame(), "Update Successful!", "UPDATE", JOptionPane.INFORMATION_MESSAGE);

                        returnedEquipment();
                        returnedDisposedEquipment();

                        eq_loadData();
                        eq_loadPatientData();

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
    }//GEN-LAST:event_eq_updatebtnActionPerformed

    private void eq_searchPatientIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eq_searchPatientIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if ("".equals(eq_searchPatientID.getText())) {
                JOptionPane.showMessageDialog(null, "Input a valid patient number to proceed.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
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

                    ID = eq_searchPatientID.getText();

                    String sql = "SELECT * FROM equipment_borrowers WHERE eq_id = " + ID;
                    ResultSet rs = st.executeQuery(sql);

                    while (rs.next()) {

                        JOptionPane.showMessageDialog(new JFrame(), "Patient number selected.", "SELECTION: Patient number.", JOptionPane.INFORMATION_MESSAGE);

                        eq_id.setText(rs.getString("eq_patient_id"));
                        eq_fname.setText(rs.getString("eq_fname"));
                        eq_date.setDate(rs.getDate("eq_date"));
                        eq_txtTimeBorrowed.setText(rs.getString("eq_timeBorrowed"));
                        eq_gender.setSelectedItem(rs.getString("eq_gender"));
                        eq_department.setSelectedItem(rs.getString("eq_department"));
                        eq_designation.setText(rs.getString("eq_designation"));
                        eq_equipment.setText(rs.getString("eq_equipment"));
                        notFound = 1;

                    }
                    if (notFound == 0) {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid ID. Please select from the table.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_eq_searchPatientIDKeyPressed

    private void eq_timeReturnedbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eq_timeReturnedbtnActionPerformed
        eq_timeReturned.showPopup();
    }//GEN-LAST:event_eq_timeReturnedbtnActionPerformed

    private void eq_searchPatientIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eq_searchPatientIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eq_searchPatientIDActionPerformed

    private void eq_searchIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eq_searchIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if ("".equals(eq_searchID.getText())) {
                JOptionPane.showMessageDialog(null, "Input a valid patient number to proceed.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
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

                    ID = eq_searchID.getText();
                    if ("".equals(ID)) {
                        JOptionPane.showMessageDialog(new JFrame(), "ID of the equipment is required to proceed.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String sql = "SELECT * FROM equipment_inventory WHERE eq_id = " + ID;
                        ResultSet rs = st.executeQuery(sql);

                        while (rs.next()) {
                            eq_equipment.setText(rs.getString("eq_item"));
                            notFound = 1;
                            JOptionPane.showMessageDialog(null, "Equipment selected.", "INFORM: Success", JOptionPane.INFORMATION_MESSAGE);
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
    }//GEN-LAST:event_eq_searchIDKeyPressed

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

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked
        DefaultTableModel equipTable = (DefaultTableModel) eq_equipments.getModel();
        equipTable.setRowCount(0);

        DefaultTableModel equipPatientTable = (DefaultTableModel) eq_patients.getModel();
        equipPatientTable.setRowCount(0);

        JOptionPane.showMessageDialog(null, "Reloading Successful.", "UPDATE: Reload", JOptionPane.INFORMATION_MESSAGE);

        eq_loadData();
        eq_loadPatientData();
    }//GEN-LAST:event_refreshButtonMouseClicked

    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked
        home home = new home();
        home.show();
        dispose();
    }//GEN-LAST:event_homeButtonMouseClicked

    private void eq_searchNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eq_searchNameKeyReleased
        DefaultTableModel inv_equipBorrowerTable = (DefaultTableModel) eq_patients.getModel();
        TableRowSorter<DefaultTableModel> borrowersTable = new TableRowSorter<>(inv_equipBorrowerTable);
        eq_patients.setRowSorter(borrowersTable);
        borrowersTable.setRowFilter(RowFilter.regexFilter(eq_searchName.getText()));
    }//GEN-LAST:event_eq_searchNameKeyReleased

    private void eq_searchEquipmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eq_searchEquipmentKeyReleased
        DefaultTableModel inv_equipTable = (DefaultTableModel) eq_equipments.getModel();
        TableRowSorter<DefaultTableModel> equipmentTable = new TableRowSorter<>(inv_equipTable);
        eq_equipments.setRowSorter(equipmentTable);
        equipmentTable.setRowFilter(RowFilter.regexFilter(eq_searchEquipment.getText()));
    }//GEN-LAST:event_eq_searchEquipmentKeyReleased

    private void EquipemtnExportTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EquipemtnExportTableMouseClicked
        MessageFormat header = new MessageFormat("Patient's Table Records");
        MessageFormat footer = new MessageFormat("");
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);
            eq_patients.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, set, true);
            JOptionPane.showMessageDialog(null, "/n" + "Printed Successfully");
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null, "/n" + "Failed");
        }
    }//GEN-LAST:event_EquipemtnExportTableMouseClicked

    public void borrowedEquipment() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass, ID;

            url = "jdbc:mysql://localhost:3306/hso_database";
            user = "root";
            pass = "";

            ID = eq_searchID.getText();

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            String sql = "SELECT eq_quantity FROM equipment_inventory WHERE eq_id = '" + ID + "'";
            ResultSet rs = st.executeQuery(sql);

            int currentQuantity = 0;
            if (rs.next()) {
                currentQuantity = rs.getInt("eq_quantity");
            }

            sql = "UPDATE equipment_inventory SET eq_quantity = " + (currentQuantity - 1) + " WHERE eq_id = '" + ID + "'";
            st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void returnedEquipment() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass, ID;

            url = "jdbc:mysql://localhost:3306/hso_database";
            user = "root";
            pass = "";

            ID = eq_searchID.getText();

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            String sql = "SELECT eq_quantity, eq_totalquantity FROM equipment_inventory WHERE eq_id = '" + ID + "'";
            ResultSet rs = st.executeQuery(sql);

            int currentQuantity = 0;
            int totalQuantity = 0;
            if (rs.next()) {
                currentQuantity = rs.getInt("eq_quantity");
                totalQuantity = rs.getInt("eq_totalquantity");
            }

            if (currentQuantity + 1 <= totalQuantity) {
                sql = "UPDATE equipment_inventory SET eq_quantity = " + (currentQuantity + 1) + " WHERE eq_id = '" + ID + "'";
                st.executeUpdate(sql);
            } else {
                JOptionPane.showMessageDialog(null, "Cannot return equipment. Total quantity has been reached.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void disposedEquipment() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass, ID;

            url = "jdbc:mysql://localhost:3306/hso_database";
            user = "root";
            pass = "";

            ID = eq_searchID.getText();

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            String sql = "SELECT eq_disposed FROM equipment_inventory WHERE eq_id = '" + ID + "'";
            ResultSet rs = st.executeQuery(sql);

            int currentDisposed = 0;
            if (rs.next()) {
                currentDisposed = rs.getInt("eq_disposed");
            }

            sql = "UPDATE equipment_inventory SET eq_disposed = " + (currentDisposed + 1) + " WHERE eq_id = '" + ID + "'";
            st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void returnedDisposedEquipment() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass, ID;

            url = "jdbc:mysql://localhost:3306/hso_database";
            user = "root";
            pass = "";

            ID = eq_searchID.getText();

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            String sql = "SELECT eq_disposed FROM equipment_inventory WHERE eq_id = '" + ID + "'";
            ResultSet rs = st.executeQuery(sql);

            int currentDisposed = 0;
            if (rs.next()) {
                currentDisposed = rs.getInt("eq_disposed");
            }

            if (currentDisposed > 0) {
                sql = "UPDATE equipment_inventory SET eq_disposed = " + (currentDisposed - 1) + " WHERE eq_id = '" + ID + "'";
                st.executeUpdate(sql);
            } else {
                JOptionPane.showMessageDialog(null, "Equipment is not disposed.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void eq_loadPatientData() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            DefaultTableModel equipTable = (DefaultTableModel) eq_patients.getModel();

            String sql = "SELECT * FROM equipment_borrowers";
            ResultSet rs = st.executeQuery(sql);

            int id;
            String patientID, fname, gender, designation, timeBorrowed, department, equipment, timeReturned;
            Date date;
            while (rs.next()) {
                id = rs.getInt("eq_id");
                date = rs.getDate("eq_date");
                patientID = rs.getString("eq_patient_id");
                fname = rs.getString("eq_fname");
                gender = rs.getString("eq_gender");
                designation = rs.getString("eq_designation");
                timeBorrowed = rs.getString("eq_timeBorrowed");
                timeReturned = rs.getString("eq_timeReturned");
                department = rs.getString("eq_department");
                equipment = rs.getString("eq_equipment");

                equipTable.addRow(new Object[]{id, patientID, date, fname, gender, designation, department, timeBorrowed, timeReturned, equipment});

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

            DefaultTableModel invequipTable = (DefaultTableModel) eq_equipments.getModel();

            String sql = "SELECT * FROM equipment_inventory";
            ResultSet rs = st.executeQuery(sql);

            String item;
            int initialquantity, disposedEquipments, id;
            String date, expiry;

            while (rs.next()) {
                id = rs.getInt("eq_id");
                date = rs.getString("eq_date");
                disposedEquipments = rs.getInt("eq_disposed");
                item = rs.getString("eq_item");
                initialquantity = rs.getInt("eq_quantity");
                expiry = rs.getString("eq_expiry");

                invequipTable.addRow(new Object[]{id, date, item, initialquantity, disposedEquipments, expiry});

            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
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
            java.util.logging.Logger.getLogger(hsoequipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hsoequipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hsoequipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hsoequipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                hsoequipment hso = new hsoequipment();
                hso.setVisible(true);
//                hso.eq_loadData();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EquipemtnExportTable;
    private com.toedter.calendar.JDateChooser eq_date;
    private javax.swing.JLabel eq_dateLabel;
    private javax.swing.JComboBox<String> eq_department;
    private javax.swing.JLabel eq_departmentLabel;
    private javax.swing.JTextField eq_designation;
    private javax.swing.JLabel eq_designationLabel;
    private javax.swing.JTextField eq_equipment;
    private javax.swing.JLabel eq_equipmentLabel;
    private javax.swing.JTable eq_equipments;
    private javax.swing.JTextField eq_fname;
    private javax.swing.JLabel eq_fnameLabel;
    private javax.swing.JComboBox<String> eq_gender;
    private javax.swing.JLabel eq_genderLabel;
    private javax.swing.JTextField eq_id;
    private javax.swing.JLabel eq_idLabel;
    private javax.swing.JTable eq_patients;
    private javax.swing.JTextField eq_searchEquipment;
    private javax.swing.JLabel eq_searchEquipmentLabel;
    private javax.swing.JTextField eq_searchID;
    private javax.swing.JLabel eq_searchIdLabel;
    private javax.swing.JPanel eq_searchItem;
    private javax.swing.JTextField eq_searchName;
    private javax.swing.JLabel eq_searchNameLabel;
    private javax.swing.JTextField eq_searchPatientID;
    private javax.swing.JLabel eq_searchPatientLabel;
    private javax.swing.JButton eq_submitbtn;
    private cambodia.raven.Time eq_timeBorrowed;
    private javax.swing.JButton eq_timeBorrowedbtn;
    private javax.swing.JLabel eq_timeLabel;
    private javax.swing.JLabel eq_timeLabel1;
    private cambodia.raven.Time eq_timeReturned;
    private javax.swing.JButton eq_timeReturnedbtn;
    private javax.swing.JTextField eq_txtTimeBorrowed;
    private javax.swing.JTextField eq_txtTimeReturned;
    private javax.swing.JButton eq_updatebtn;
    private javax.swing.JLabel exitButton;
    private javax.swing.JLabel homeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel md_infoPanel;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JLabel refreshButton;
    private javax.swing.JLabel resizeButton;
    // End of variables declaration//GEN-END:variables
}
