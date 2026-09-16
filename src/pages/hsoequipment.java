package pages;


import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class hsoequipment extends javax.swing.JFrame {

    Date date = new Date();
    private String username;

    public hsoequipment() {
        initComponents();
        eq_loadData();
        eq_loadPatientData();
        eq_dateBorrowed.setMinSelectableDate(date);
        eq_dateReturned.setMinSelectableDate(date);
        eq_dateBorrowed.setDate(date);
        eq_dateReturned.setDate(date);
//        sortPatientsByID();
    }

    hsoequipment(String username) {
        this();
        nameLabel.setText(username + "!");
        this.username = username;
    }

    private void sortPatientsByID() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = util.Database.getConnection();
            String sql = "SELECT * FROM `equipment_borrowers` ORDER BY `equipment_borrowers`.`eq_id` DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) eq_patients.getModel();
            model.setRowCount(0);

            int id, eqID;
            String patientID, fname, gender, timeBorrowed, department, equipment, timeReturned, op;
            Date dateB, dateR;
            while (rs.next()) {
                op = rs.getString("user");
                id = rs.getInt("eq_id");
                eqID = rs.getInt("eq_equip_id");
                dateB = rs.getDate("eq_date");
                dateR = rs.getDate("eq_Rdate");
                patientID = rs.getString("eq_patient_id");
                fname = rs.getString("eq_fname");
                gender = rs.getString("eq_gender");
                timeBorrowed = rs.getString("eq_timeBorrowed");
                timeReturned = rs.getString("eq_timeReturned");
                department = rs.getString("eq_department");
                equipment = rs.getString("eq_equipment");

                model.addRow(new Object[]{op, id, patientID, fname, gender, department, dateB, timeBorrowed, dateR, timeReturned, eqID, equipment});

            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
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
        eq_equipment = new javax.swing.JTextField();
        eq_fnameLabel = new javax.swing.JLabel();
        eq_equipmentLabel = new javax.swing.JLabel();
        eq_dateLabel = new javax.swing.JLabel();
        eq_timeLabel = new javax.swing.JLabel();
        eq_departmentLabel = new javax.swing.JLabel();
        eq_idLabel = new javax.swing.JLabel();
        eq_genderLabel = new javax.swing.JLabel();
        eq_dateBorrowed = new com.toedter.calendar.JDateChooser();
        eq_timeBorrowedbtn = new javax.swing.JButton();
        eq_department = new javax.swing.JComboBox<>();
        eq_gender = new javax.swing.JComboBox<>();
        eq_submitbtn = new javax.swing.JButton();
        eq_searchID = new javax.swing.JTextField();
        eq_searchPatientID = new javax.swing.JTextField();
        eq_timeLabel1 = new javax.swing.JLabel();
        eq_txtTimeReturned = new javax.swing.JTextField();
        eq_timeReturnedbtn = new javax.swing.JButton();
        eq_updatebtn = new javax.swing.JButton();
        eq_dateLabel1 = new javax.swing.JLabel();
        eq_dateReturned = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        homebar = new javax.swing.JPanel();
        eq_searchName = new javax.swing.JTextField();
        eq_searchNameLabel = new javax.swing.JLabel();
        eq_searchEquipment = new javax.swing.JTextField();
        eq_searchEquipmentLabel = new javax.swing.JLabel();
        EquipemtnExportTable = new javax.swing.JLabel();
        homeButton = new javax.swing.JLabel();
        refreshButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        resizeButton = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        dashboard = new javax.swing.JPanel();
        equipment = new javax.swing.JLabel();
        inventory = new javax.swing.JLabel();
        meds = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        signout = new javax.swing.JButton();

        eq_timeBorrowed.setTextRefernce(eq_txtTimeBorrowed);

        eq_timeReturned.setTextRefernce(eq_txtTimeReturned);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        eq_searchItem.setBackground(new java.awt.Color(255, 255, 255));

        eq_patients.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        eq_patients.setForeground(new java.awt.Color(0, 0, 0));
        eq_patients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SYSTEM USER", "PATIENT NO.", "STUDENT ID", "NAME", "SEX", "DEPARTMENT", "DATE BORROWED", "TIME BORROWED", "DATE RETURNED", "TIME RETURNED", "EQUIPMENT ID", "EQUIPMENT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        eq_patients.setRowHeight(40);
        eq_patients.setSelectionBackground(new java.awt.Color(51, 102, 0));
        eq_patients.setSelectionForeground(new java.awt.Color(255, 255, 255));
        eq_patients.setShowGrid(false);
        eq_patients.getTableHeader().setResizingAllowed(false);
        eq_patients.getTableHeader().setReorderingAllowed(false);
        eq_patients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eq_patientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(eq_patients);
        if (eq_patients.getColumnModel().getColumnCount() > 0) {
            eq_patients.getColumnModel().getColumn(0).setMinWidth(0);
            eq_patients.getColumnModel().getColumn(0).setPreferredWidth(0);
            eq_patients.getColumnModel().getColumn(0).setMaxWidth(80);
            eq_patients.getColumnModel().getColumn(1).setPreferredWidth(50);
            eq_patients.getColumnModel().getColumn(2).setPreferredWidth(100);
            eq_patients.getColumnModel().getColumn(3).setPreferredWidth(150);
            eq_patients.getColumnModel().getColumn(4).setPreferredWidth(80);
            eq_patients.getColumnModel().getColumn(5).setPreferredWidth(150);
            eq_patients.getColumnModel().getColumn(6).setPreferredWidth(80);
            eq_patients.getColumnModel().getColumn(7).setPreferredWidth(80);
            eq_patients.getColumnModel().getColumn(8).setPreferredWidth(80);
            eq_patients.getColumnModel().getColumn(9).setPreferredWidth(80);
            eq_patients.getColumnModel().getColumn(10).setMinWidth(0);
            eq_patients.getColumnModel().getColumn(10).setPreferredWidth(0);
            eq_patients.getColumnModel().getColumn(10).setMaxWidth(0);
            eq_patients.getColumnModel().getColumn(11).setPreferredWidth(150);
        }

        md_infoPanel.setBackground(new java.awt.Color(53, 64, 142));

        eq_equipments.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        eq_equipments.setForeground(new java.awt.Color(0, 0, 0));
        eq_equipments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ITEM", "QUANTITY LEFT", "NO. DISPENSED", "EXPIRY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        eq_equipments.setRowHeight(40);
        eq_equipments.setSelectionBackground(new java.awt.Color(51, 102, 0));
        eq_equipments.setSelectionForeground(new java.awt.Color(255, 255, 255));
        eq_equipments.setShowGrid(false);
        eq_equipments.getTableHeader().setResizingAllowed(false);
        eq_equipments.getTableHeader().setReorderingAllowed(false);
        eq_equipments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eq_equipmentsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(eq_equipments);
        if (eq_equipments.getColumnModel().getColumnCount() > 0) {
            eq_equipments.getColumnModel().getColumn(0).setPreferredWidth(50);
            eq_equipments.getColumnModel().getColumn(1).setPreferredWidth(100);
            eq_equipments.getColumnModel().getColumn(2).setPreferredWidth(50);
            eq_equipments.getColumnModel().getColumn(3).setPreferredWidth(50);
            eq_equipments.getColumnModel().getColumn(4).setMinWidth(0);
            eq_equipments.getColumnModel().getColumn(4).setPreferredWidth(0);
            eq_equipments.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        eq_id.setBackground(new java.awt.Color(255, 255, 255));
        eq_id.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_id.setForeground(new java.awt.Color(0, 0, 0));
        eq_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eq_id.setToolTipText("EX: 2021-123456");
        eq_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eq_idKeyReleased(evt);
            }
        });

        eq_fname.setBackground(new java.awt.Color(255, 255, 255));
        eq_fname.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_fname.setForeground(new java.awt.Color(0, 0, 0));
        eq_fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eq_fname.setToolTipText("EX: Cruz, Juan Pogi A.");
        eq_fname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                eq_fnameKeyTyped(evt);
            }
        });

        eq_txtTimeBorrowed.setEditable(false);
        eq_txtTimeBorrowed.setBackground(new java.awt.Color(255, 255, 255));
        eq_txtTimeBorrowed.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_txtTimeBorrowed.setForeground(new java.awt.Color(0, 0, 0));
        eq_txtTimeBorrowed.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eq_txtTimeBorrowed.setToolTipText("Click the button beside this field for the time selector to show up.");

        eq_equipment.setEditable(false);
        eq_equipment.setBackground(new java.awt.Color(255, 255, 255));
        eq_equipment.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_equipment.setForeground(new java.awt.Color(0, 0, 0));
        eq_equipment.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eq_equipment.setToolTipText("Select the row of equipment on the table beside this field.");

        eq_fnameLabel.setFont(new java.awt.Font("Monospaced", 3, 14)); // NOI18N
        eq_fnameLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_fnameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eq_fnameLabel.setText("FULL NAME:");

        eq_equipmentLabel.setFont(new java.awt.Font("Monospaced", 3, 14)); // NOI18N
        eq_equipmentLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_equipmentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eq_equipmentLabel.setText("EQUIPMENT:");

        eq_dateLabel.setFont(new java.awt.Font("Monospaced", 3, 14)); // NOI18N
        eq_dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eq_dateLabel.setText("DATE BORROWED:");

        eq_timeLabel.setFont(new java.awt.Font("Monospaced", 3, 14)); // NOI18N
        eq_timeLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eq_timeLabel.setText("TIME BORROWED:");

        eq_departmentLabel.setFont(new java.awt.Font("Monospaced", 3, 14)); // NOI18N
        eq_departmentLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_departmentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eq_departmentLabel.setText("DEPARTMENT:");

        eq_idLabel.setFont(new java.awt.Font("Monospaced", 3, 14)); // NOI18N
        eq_idLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eq_idLabel.setText("ID NUMBER:");

        eq_genderLabel.setFont(new java.awt.Font("Monospaced", 3, 14)); // NOI18N
        eq_genderLabel.setForeground(new java.awt.Color(255, 255, 255));
        eq_genderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eq_genderLabel.setText("SEX:");

        eq_dateBorrowed.setBackground(new java.awt.Color(255, 255, 255));
        eq_dateBorrowed.setForeground(new java.awt.Color(0, 0, 0));
        eq_dateBorrowed.setDateFormatString("yyyy-MM-dd");
        eq_dateBorrowed.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

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
        eq_submitbtn.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        eq_submitbtn.setForeground(new java.awt.Color(255, 255, 255));
        eq_submitbtn.setText("SUBMIT");
        eq_submitbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eq_submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eq_submitbtnActionPerformed(evt);
            }
        });

        eq_searchID.setBackground(new java.awt.Color(255, 255, 255));
        eq_searchID.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_searchID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eq_searchID.setToolTipText("Enter equipment number");
        eq_searchID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                eq_searchIDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                eq_searchIDKeyTyped(evt);
            }
        });

        eq_searchPatientID.setBackground(new java.awt.Color(255, 255, 255));
        eq_searchPatientID.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_searchPatientID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                eq_searchPatientIDKeyTyped(evt);
            }
        });

        eq_timeLabel1.setFont(new java.awt.Font("Monospaced", 3, 14)); // NOI18N
        eq_timeLabel1.setForeground(new java.awt.Color(255, 255, 255));
        eq_timeLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eq_timeLabel1.setText("TIME RETUNED:");

        eq_txtTimeReturned.setBackground(new java.awt.Color(255, 255, 255));
        eq_txtTimeReturned.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        eq_txtTimeReturned.setForeground(new java.awt.Color(0, 0, 0));
        eq_txtTimeReturned.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eq_txtTimeReturned.setToolTipText("");

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

        eq_updatebtn.setBackground(new java.awt.Color(51, 102, 0));
        eq_updatebtn.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        eq_updatebtn.setForeground(new java.awt.Color(255, 255, 255));
        eq_updatebtn.setText("UPDATE");
        eq_updatebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eq_updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eq_updatebtnActionPerformed(evt);
            }
        });

        eq_dateLabel1.setFont(new java.awt.Font("Monospaced", 3, 14)); // NOI18N
        eq_dateLabel1.setForeground(new java.awt.Color(255, 255, 255));
        eq_dateLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eq_dateLabel1.setText("DATE RETURNED:");

        eq_dateReturned.setBackground(new java.awt.Color(255, 255, 255));
        eq_dateReturned.setForeground(new java.awt.Color(0, 0, 0));
        eq_dateReturned.setDateFormatString("yyyy-MM-dd");
        eq_dateReturned.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("SEE SYSTEM OPERATOR");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout md_infoPanelLayout = new javax.swing.GroupLayout(md_infoPanel);
        md_infoPanel.setLayout(md_infoPanelLayout);
        md_infoPanelLayout.setHorizontalGroup(
            md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(md_infoPanelLayout.createSequentialGroup()
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(md_infoPanelLayout.createSequentialGroup()
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(md_infoPanelLayout.createSequentialGroup()
                                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(md_infoPanelLayout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(md_infoPanelLayout.createSequentialGroup()
                                                .addComponent(eq_timeLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(eq_txtTimeBorrowed, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(eq_timeBorrowedbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(md_infoPanelLayout.createSequentialGroup()
                                                    .addComponent(eq_genderLabel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(eq_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(md_infoPanelLayout.createSequentialGroup()
                                                    .addComponent(eq_dateLabel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(eq_dateBorrowed, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(md_infoPanelLayout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(eq_fnameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eq_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eq_searchPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(md_infoPanelLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(eq_dateLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eq_dateReturned, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(md_infoPanelLayout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, md_infoPanelLayout.createSequentialGroup()
                                                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, md_infoPanelLayout.createSequentialGroup()
                                                        .addComponent(eq_idLabel)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(eq_id, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(eq_departmentLabel)
                                                        .addGroup(md_infoPanelLayout.createSequentialGroup()
                                                            .addGap(94, 94, 94)
                                                            .addComponent(eq_department, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(53, 53, 53))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, md_infoPanelLayout.createSequentialGroup()
                                                .addComponent(eq_timeLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(eq_txtTimeReturned, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(eq_timeReturnedbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, md_infoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(md_infoPanelLayout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(eq_updatebtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(eq_submitbtn))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, md_infoPanelLayout.createSequentialGroup()
                                        .addComponent(eq_equipmentLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eq_equipment, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eq_searchID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(220, 220, 220)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, md_infoPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        md_infoPanelLayout.setVerticalGroup(
            md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(md_infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(md_infoPanelLayout.createSequentialGroup()
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eq_fnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eq_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eq_searchPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eq_idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eq_id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(eq_genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(eq_departmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eq_department, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(eq_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eq_dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eq_dateBorrowed, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eq_dateLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eq_dateReturned, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eq_timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(eq_txtTimeBorrowed, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eq_timeBorrowedbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(eq_timeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(eq_txtTimeReturned, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(eq_timeReturnedbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eq_equipmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eq_equipment, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eq_searchID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eq_submitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eq_updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        homebar.setBackground(new java.awt.Color(255, 255, 255));

        eq_searchName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        eq_searchName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eq_searchNameKeyReleased(evt);
            }
        });

        eq_searchNameLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        eq_searchNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        eq_searchNameLabel.setText("SEARCH BORROWER:");

        eq_searchEquipment.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        eq_searchEquipment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eq_searchEquipmentKeyReleased(evt);
            }
        });

        eq_searchEquipmentLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        eq_searchEquipmentLabel.setForeground(new java.awt.Color(0, 0, 0));
        eq_searchEquipmentLabel.setText("SEARCH EQUIPMENT:");

        EquipemtnExportTable.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        EquipemtnExportTable.setForeground(new java.awt.Color(0, 0, 0));
        EquipemtnExportTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EquipemtnExportTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/down-arrow.png"))); // NOI18N
        EquipemtnExportTable.setToolTipText("Export patient's table");
        EquipemtnExportTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EquipemtnExportTable.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        EquipemtnExportTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EquipemtnExportTableMouseClicked(evt);
            }
        });

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home-button.png"))); // NOI18N
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButtonMouseClicked(evt);
            }
        });

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reload.png"))); // NOI18N
        refreshButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
            }
        });

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minus.png"))); // NOI18N
        minimizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
        });

        resizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/resize.png"))); // NOI18N
        resizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resizeButtonMouseClicked(evt);
            }
        });

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close (2).png"))); // NOI18N
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout homebarLayout = new javax.swing.GroupLayout(homebar);
        homebar.setLayout(homebarLayout);
        homebarLayout.setHorizontalGroup(
            homebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EquipemtnExportTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eq_searchNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eq_searchName)
                .addGap(29, 29, 29)
                .addComponent(eq_searchEquipment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eq_searchEquipmentLabel)
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
            .addGroup(homebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EquipemtnExportTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eq_searchNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eq_searchName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resizeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minimizeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(homebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eq_searchEquipmentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eq_searchEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        dashboard.setBackground(new java.awt.Color(53, 64, 142));

        equipment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        equipment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/first-aid-kit (1).png"))); // NOI18N
        equipment.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 215, 83), 3, true));
        equipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        equipment.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        inventory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inventory.png"))); // NOI18N
        inventory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 215, 83), 3, true));
        inventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inventory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventoryMouseClicked(evt);
            }
        });

        meds.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meds.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/medicine (2).png"))); // NOI18N
        meds.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 215, 83), 3, true));
        meds.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        meds.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        meds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medsMouseClicked(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        welcomeLabel.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("WELCOME");

        nameLabel.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        signout.setBackground(new java.awt.Color(53, 64, 142));
        signout.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        signout.setForeground(new java.awt.Color(255, 255, 255));
        signout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout (1).png"))); // NOI18N
        signout.setText("SIGN OUT");
        signout.setBorder(null);
        signout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(equipment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(meds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(meds, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(equipment, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout eq_searchItemLayout = new javax.swing.GroupLayout(eq_searchItem);
        eq_searchItem.setLayout(eq_searchItemLayout);
        eq_searchItemLayout.setHorizontalGroup(
            eq_searchItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(eq_searchItemLayout.createSequentialGroup()
                .addComponent(dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eq_searchItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(md_infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        eq_searchItemLayout.setVerticalGroup(
            eq_searchItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eq_searchItemLayout.createSequentialGroup()
                .addComponent(homebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eq_searchItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eq_searchItemLayout.createSequentialGroup()
                        .addComponent(md_infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(eq_searchItem, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void eq_timeBorrowedbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eq_timeBorrowedbtnActionPerformed
        eq_timeBorrowed.showPopup();
    }//GEN-LAST:event_eq_timeBorrowedbtnActionPerformed

    private void eq_submitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eq_submitbtnActionPerformed

        String url, user, pass, query, op;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = util.Database.getConnection();
            PreparedStatement st = con.prepareStatement("INSERT INTO equipment_borrowers(user, eq_patient_id,  eq_fname, eq_gender, eq_department,eq_date, eq_timeBorrowed,eq_equip_id, eq_equipment) VALUES (?,?,?,?,?,?,?,?,?)");

            Date med_date = eq_dateBorrowed.getDate();
            String formattedDate;

            op = username;

            if (med_date != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                formattedDate = sdf.format(med_date);
            } else {
                formattedDate = "";
            }

            if (eq_dateBorrowed.getDate() == null) {
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
                String equip_department = eq_department.getSelectedItem().toString();
                String equip_gender = eq_gender.getSelectedItem().toString();
                String equip_equipment = eq_equipment.getText();
                String eq_equip = eq_searchID.getText();

                query = "INSERT INTO equipment_borrowers(user, eq_patient_id,  eq_fname, eq_gender, eq_department,eq_date, eq_timeBorrowed, eq_equip_id, eq_equipment) " + "VALUES ('" + op + "', '" + equip_patientID + "',  '" + equip_fname + "','" + equip_gender + "' , '" + equip_department + "','" + formattedDate + "', '" + equip_timeBorrowed + "', '" + eq_equip + "', '" + equip_equipment + "')";
                st.executeUpdate(query);

                DefaultTableModel equipPatientTable = (DefaultTableModel) eq_patients.getModel();
                DefaultTableModel equipTable = (DefaultTableModel) eq_equipments.getModel();

                equipPatientTable.setRowCount(0);
                equipTable.setRowCount(0);

                JOptionPane.showMessageDialog(new JFrame(), "Borrower successfully recorded!\n\nA total of one equipment borrowed", "Managed by: " + username, JOptionPane.INFORMATION_MESSAGE);

                disposedEquipment();
                borrowedEquipment();

                eq_loadPatientData();
                eq_loadData();

                eq_id.setText("");
                eq_fname.setText("");
                eq_txtTimeBorrowed.setText("");
                eq_department.setSelectedItem(null);
                eq_gender.setSelectedItem(null);
                eq_equipment.setText("");
                eq_searchID.setText("");

                con.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }//GEN-LAST:event_eq_submitbtnActionPerformed

    private void eq_updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eq_updatebtnActionPerformed
        String patientID, fname, gender, timeBorrowed, department, equipment, timeReturned, op;
        Date Bdate = eq_dateBorrowed.getDate();
        Date Rdate = eq_dateReturned.getDate();
        String formattedDate;
        if (Bdate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            formattedDate = sdf.format(Bdate);
        } else {
            formattedDate = "";
        }

        String formattedRDate;
        if (Rdate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            formattedRDate = sdf.format(Rdate);
        } else {
            formattedRDate = "";
        }
        String url, user, pass, ID;
        int notFound = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = util.Database.getConnection();
            Statement st = con.createStatement();

            ID = eq_searchPatientID.getText();
            if ("".equals(ID)) {
                JOptionPane.showMessageDialog(new JFrame(), "Patient id is required to proceed.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {

                if ("".equals(eq_searchID.getText())) {
                    JOptionPane.showMessageDialog(null, "Equipment ID required to proceed.", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String sql = "SELECT * FROM equipment_borrowers WHERE eq_id = " + ID;
                    ResultSet rs = st.executeQuery(sql);

                    Statement stUpdate = con.createStatement();

                    while (rs.next()) {
                        op = username;
                        patientID = eq_id.getText();
                        fname = eq_fname.getText();
                        gender = (String) eq_gender.getSelectedItem();
                        department = (String) eq_department.getSelectedItem();
                        equipment = eq_equipment.getText();
                        timeReturned = eq_txtTimeReturned.getText();
                        timeBorrowed = eq_txtTimeBorrowed.getText();

                        String updateSql = "UPDATE equipment_borrowers SET user = '" + op + "', eq_patient_id = '" + patientID + "', eq_date = '" + formattedDate + "', "
                                + "eq_fname = '" + fname + "', eq_gender = '" + gender + "', eq_department = '" + department + "',eq_timeBorrowed = '" + timeBorrowed + "',"
                                + "eq_timeReturned = '" + timeReturned + "',eq_equipment = '" + equipment + "', eq_Rdate = '" + formattedRDate + "' WHERE eq_id = " + ID;
                        stUpdate.executeUpdate(updateSql);

                        DefaultTableModel equipPatientTable = (DefaultTableModel) eq_patients.getModel();
                        equipPatientTable.setRowCount(0);

                        DefaultTableModel equipTable = (DefaultTableModel) eq_equipments.getModel();
                        equipTable.setRowCount(0);

                        notFound = 1;

                        JOptionPane.showMessageDialog(new JFrame(), "Update Successful!", "Updated by: " + username, JOptionPane.INFORMATION_MESSAGE);

                        returnedEquipment();
                        returnedDisposedEquipment();

                        eq_loadData();
                        eq_loadPatientData();

                        eq_id.setText("");
                        eq_fname.setText("");
                        eq_department.setSelectedItem(null);
                        eq_gender.setSelectedItem(null);
                        eq_equipment.setText("");
                        eq_searchID.setText("");

                    }
                    rs.close();
                    st.close();
                    if (notFound == 0) {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid ID. Please select from the table.", "ERROR", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Input a valid patient number to proceed.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String url, user, pass, ID;
                int notFound = 0;

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    url = "jdbc:MySQL://localhost:3306/hso_database";
                    user = "root";
                    pass = "";

                    Connection con = util.Database.getConnection();
                    Statement st = con.createStatement();

                    ID = eq_searchPatientID.getText();

                    String sql = "SELECT * FROM equipment_borrowers WHERE eq_id = " + ID;
                    ResultSet rs = st.executeQuery(sql);

                    while (rs.next()) {

                        eq_id.setText(rs.getString("eq_patient_id"));
                        eq_fname.setText(rs.getString("eq_fname"));
                        eq_dateBorrowed.setDate(rs.getDate("eq_date"));
                        eq_txtTimeBorrowed.setText(rs.getString("eq_timeBorrowed"));
                        eq_gender.setSelectedItem(rs.getString("eq_gender"));
                        eq_department.setSelectedItem(rs.getString("eq_department"));
                        eq_equipment.setText(rs.getString("eq_equipment"));
                        notFound = 1;

                    }
                    if (notFound == 1) {
                        DefaultTableModel eq_PatientsTable = (DefaultTableModel) eq_patients.getModel();
                        for (int i = 0; i < eq_PatientsTable.getRowCount(); i++) {
                            if (eq_PatientsTable.getValueAt(i, 0).toString().equals(ID)) {
                                eq_patients.getSelectionModel().setSelectionInterval(i, i);
                                eq_patients.scrollRectToVisible(eq_patients.getCellRect(i, 0, true));
                                break;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid ID. Please select from the table.", "ERROR", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Input a valid patient number to proceed.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String url, user, pass, ID;
                int notFound = 0;

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    url = "jdbc:MySQL://localhost:3306/hso_database";
                    user = "root";
                    pass = "";

                    Connection con = util.Database.getConnection();
                    Statement st = con.createStatement();

                    ID = eq_searchID.getText();
                    if ("".equals(ID)) {
                        JOptionPane.showMessageDialog(new JFrame(), "ID of the equipment is required to proceed.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String sql = "SELECT * FROM equipment_inventory WHERE eq_id = " + ID;
                        ResultSet rs = st.executeQuery(sql);

                        while (rs.next()) {
                            eq_equipment.setText(rs.getString("eq_item"));
                            notFound = 1;
                        }
                        if (notFound == 1) {
                            DefaultTableModel equipTable = (DefaultTableModel) eq_equipments.getModel();
                            for (int i = 0; i < equipTable.getRowCount(); i++) {
                                if (equipTable.getValueAt(i, 0).toString().equals(ID)) {
                                    eq_equipments.getSelectionModel().setSelectionInterval(i, i);
                                    eq_equipments.scrollRectToVisible(eq_equipments.getCellRect(i, 0, true));
                                    break;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(new JFrame(), "Invalid ID. Please select from the table.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_eq_searchIDKeyPressed

    private Dimension originalSize;
    private Point originalLocation;

    private void eq_searchNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eq_searchNameKeyReleased
        DefaultTableModel inv_equipBorrowerTable = (DefaultTableModel) eq_patients.getModel();
        TableRowSorter<DefaultTableModel> borrowersTable = new TableRowSorter<>(inv_equipBorrowerTable);
        eq_patients.setRowSorter(borrowersTable);
        RowFilter<TableModel, Integer> filter = RowFilter.regexFilter("(?i)" + eq_searchName.getText());
        borrowersTable.setRowFilter(filter);

    }//GEN-LAST:event_eq_searchNameKeyReleased

    private void eq_searchEquipmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eq_searchEquipmentKeyReleased
        DefaultTableModel inv_equipTable = (DefaultTableModel) eq_equipments.getModel();
        TableRowSorter<DefaultTableModel> equipmentTable = new TableRowSorter<>(inv_equipTable);
        eq_equipments.setRowSorter(equipmentTable);
        RowFilter<TableModel, Integer> filter = RowFilter.regexFilter("(?i)" + eq_searchEquipment.getText());
        equipmentTable.setRowFilter(filter);
    }//GEN-LAST:event_eq_searchEquipmentKeyReleased

    private void EquipemtnExportTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EquipemtnExportTableMouseClicked
        printBorrower print = new printBorrower();
        print.setVisible(true);
    }//GEN-LAST:event_EquipemtnExportTableMouseClicked

    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked
        home home = new home(username);
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_homeButtonMouseClicked

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked

        DefaultTableModel equipTable = (DefaultTableModel) eq_equipments.getModel();
        DefaultTableModel equipPatientsTable = (DefaultTableModel) eq_patients.getModel();

        equipTable.setRowCount(0);
        equipPatientsTable.setRowCount(0);

        JOptionPane.showMessageDialog(null, "Reloading Successful.", "UPDATE", JOptionPane.INFORMATION_MESSAGE);

        eq_id.setText("");
        eq_gender.setSelectedItem(null);
        eq_searchID.setText("");
        eq_fname.setText("");
        eq_department.setSelectedItem(null);
        eq_equipment.setText("");
        eq_searchPatientID.setText("");

        eq_loadPatientData();
        eq_loadData();

    }//GEN-LAST:event_refreshButtonMouseClicked

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((JLabel) evt.getSource());
        frame.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked

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

    private void eq_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eq_idKeyReleased
        JTextField textField = (JTextField) evt.getComponent();
        String text = textField.getText();

        if (text.length() > 11) {
            textField.setText(text.substring(0, 11));
        }

        if (text.length() == 4) {
            textField.setText(text + "-");
        }

        if (!text.matches("\\d{0,4}-?\\d{0,6}")) {
            textField.setText("");
        }
    }//GEN-LAST:event_eq_idKeyReleased

    private void eq_searchIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eq_searchIDKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_eq_searchIDKeyTyped

    private void eq_searchPatientIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eq_searchPatientIDKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_eq_searchPatientIDKeyTyped

    private void eq_fnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eq_fnameKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_eq_fnameKeyTyped

    private void signoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signoutActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            SignUpLogIn login = new SignUpLogIn();
            login.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_signoutActionPerformed

    private void medsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medsMouseClicked
        hsoinventory meds = new hsoinventory(username);
        meds.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_medsMouseClicked

    private void eq_equipmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eq_equipmentsMouseClicked
        DefaultTableModel equipments = (DefaultTableModel) eq_equipments.getModel();
        int selectedRowIndex = eq_equipments.getSelectedRow();

        String url, user, pass, ID;
        int notFound = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = util.Database.getConnection();
            Statement st = con.createStatement();
            eq_searchID.setText(equipments.getValueAt(selectedRowIndex, 0).toString());
            ID = eq_searchID.getText();
            if ("".equals(ID)) {
                JOptionPane.showMessageDialog(new JFrame(), "ID of the equipment is required to proceed.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String sql = "SELECT * FROM equipment_inventory WHERE eq_id = " + ID;
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    eq_equipment.setText(rs.getString("eq_item"));
                    notFound = 1;
                }
                if (notFound == 1) {
                    DefaultTableModel equipTable = (DefaultTableModel) eq_equipments.getModel();
                    for (int i = 0; i < equipTable.getRowCount(); i++) {
                        if (equipTable.getValueAt(i, 0).toString().equals(ID)) {
                            eq_equipments.getSelectionModel().setSelectionInterval(i, i);
                            eq_equipments.scrollRectToVisible(eq_equipments.getCellRect(i, 0, true));
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Invalid ID. Please select from the table.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

    }//GEN-LAST:event_eq_equipmentsMouseClicked

    private void eq_patientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eq_patientsMouseClicked
        DefaultTableModel borrowers = (DefaultTableModel) eq_patients.getModel();
        int selectedRowIndex = eq_patients.getSelectedRow();

        String url, user, pass, ID;
        int notFound = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = util.Database.getConnection();
            Statement st = con.createStatement();

            eq_searchPatientID.setText(borrowers.getValueAt(selectedRowIndex, 1).toString());
            ID = eq_searchPatientID.getText();

            String sql = "SELECT * FROM equipment_borrowers WHERE eq_id = " + ID;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                eq_searchID.setText(rs.getString("eq_equip_id"));
                eq_searchPatientID.setText(rs.getString("eq_id"));
                eq_id.setText(rs.getString("eq_patient_id"));
                eq_fname.setText(rs.getString("eq_fname"));
                eq_dateBorrowed.setDate(rs.getDate("eq_date"));
                eq_txtTimeBorrowed.setText(rs.getString("eq_timeBorrowed"));
                eq_gender.setSelectedItem(rs.getString("eq_gender"));
                eq_department.setSelectedItem(rs.getString("eq_department"));
                eq_equipment.setText(rs.getString("eq_equipment"));
                notFound = 1;

            }
            if (notFound == 1) {
                DefaultTableModel eq_PatientsTable = (DefaultTableModel) eq_patients.getModel();
                for (int i = 0; i < eq_PatientsTable.getRowCount(); i++) {
                    if (eq_PatientsTable.getValueAt(i, 0).toString().equals(ID)) {
                        eq_patients.getSelectionModel().setSelectionInterval(i, i);
                        eq_patients.scrollRectToVisible(eq_patients.getCellRect(i, 0, true));
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Invalid ID. Please select from the table.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }//GEN-LAST:event_eq_patientsMouseClicked

    private void inventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryMouseClicked
        hsoinventorymanagement inventory = new hsoinventorymanagement(username);
        inventory.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_inventoryMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        TableColumn column = eq_patients.getColumnModel().getColumn(0);
        int preferredWidth = column.getPreferredWidth();
        if (preferredWidth == 80) {
            column.setPreferredWidth(0);
        } else {
            column.setPreferredWidth(80);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    public void borrowedEquipment() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass, ID;

            url = "jdbc:mysql://localhost:3306/hso_database";
            user = "root";
            pass = "";

            ID = eq_searchID.getText();

            Connection con = util.Database.getConnection();
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

            Connection con = util.Database.getConnection();
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

            Connection con = util.Database.getConnection();
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

            Connection con = util.Database.getConnection();
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

            Connection con = util.Database.getConnection();
            Statement st = con.createStatement();

            DefaultTableModel equipTable = (DefaultTableModel) eq_patients.getModel();

            String sql = "SELECT * FROM equipment_borrowers";
            ResultSet rs = st.executeQuery(sql);

            int id, eqID;
            String patientID, fname, gender, timeBorrowed, department, equipment, timeReturned, op;
            Date dateB, dateR;
            while (rs.next()) {
                op = rs.getString("user");
                id = rs.getInt("eq_id");
                eqID = rs.getInt("eq_equip_id");
                dateB = rs.getDate("eq_date");
                dateR = rs.getDate("eq_Rdate");
                patientID = rs.getString("eq_patient_id");
                fname = rs.getString("eq_fname");
                gender = rs.getString("eq_gender");
                timeBorrowed = rs.getString("eq_timeBorrowed");
                timeReturned = rs.getString("eq_timeReturned");
                department = rs.getString("eq_department");
                equipment = rs.getString("eq_equipment");

                equipTable.addRow(new Object[]{op, id, patientID, fname, gender, department, dateB, timeBorrowed, dateR, timeReturned, eqID, equipment});
                sortPatientsByID();

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

            Connection con = util.Database.getConnection();
            Statement st = con.createStatement();

            DefaultTableModel invequipTable = (DefaultTableModel) eq_equipments.getModel();

            String sql = "SELECT * FROM equipment_inventory";
            ResultSet rs = st.executeQuery(sql);

            String item;
            int initialquantity, disposedEquipments, id;
            String expiry;

            while (rs.next()) {
                id = rs.getInt("eq_id");
                disposedEquipments = rs.getInt("eq_disposed");
                item = rs.getString("eq_item");
                initialquantity = rs.getInt("eq_quantity");
                expiry = rs.getString("eq_expiry");

                invequipTable.addRow(new Object[]{id, item, initialquantity, disposedEquipments, expiry});

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
    private javax.swing.JPanel dashboard;
    private com.toedter.calendar.JDateChooser eq_dateBorrowed;
    private javax.swing.JLabel eq_dateLabel;
    private javax.swing.JLabel eq_dateLabel1;
    private com.toedter.calendar.JDateChooser eq_dateReturned;
    private javax.swing.JComboBox<String> eq_department;
    private javax.swing.JLabel eq_departmentLabel;
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
    private javax.swing.JPanel eq_searchItem;
    private javax.swing.JTextField eq_searchName;
    private javax.swing.JLabel eq_searchNameLabel;
    private javax.swing.JTextField eq_searchPatientID;
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
    private javax.swing.JLabel equipment;
    private javax.swing.JLabel exitButton;
    private javax.swing.JLabel homeButton;
    private javax.swing.JPanel homebar;
    private javax.swing.JLabel inventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel md_infoPanel;
    private javax.swing.JLabel meds;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel refreshButton;
    private javax.swing.JLabel resizeButton;
    private javax.swing.JButton signout;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
