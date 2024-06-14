
import java.awt.Color;
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

public class hsoinventory extends javax.swing.JFrame {

    Date date = new Date();

    public hsoinventory() {
        initComponents();
        loadData();
        loadPatientData();
        md_date.setMinSelectableDate(date);
        adjust_mdPatientsColumn();
        adjust_mdMedsColumn();
    }

    public void adjust_mdPatientsColumn() {
        md_patients.getColumnModel().getColumn(0).setPreferredWidth(50);
        md_patients.getColumnModel().getColumn(1).setPreferredWidth(100);
        md_patients.getColumnModel().getColumn(2).setPreferredWidth(100);
        md_patients.getColumnModel().getColumn(3).setPreferredWidth(180);
        md_patients.getColumnModel().getColumn(4).setPreferredWidth(50);
        md_patients.getColumnModel().getColumn(5).setPreferredWidth(150);
        md_patients.getColumnModel().getColumn(6).setPreferredWidth(180);
        md_patients.getColumnModel().getColumn(7).setPreferredWidth(100);
        md_patients.getColumnModel().getColumn(8).setPreferredWidth(120);
    }

    public void adjust_mdMedsColumn() {
        md_meds.getColumnModel().getColumn(0).setPreferredWidth(50);
        md_meds.getColumnModel().getColumn(1).setPreferredWidth(100);
        md_meds.getColumnModel().getColumn(2).setPreferredWidth(50);
        md_meds.getColumnModel().getColumn(3).setPreferredWidth(50);
        md_meds.getColumnModel().getColumn(4).setPreferredWidth(80);
        md_meds.getColumnModel().getColumn(5).setPreferredWidth(80);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        md_time = new cambodia.raven.Time();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        md_frame = new javax.swing.JPanel();
        md_infoPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        md_meds = new javax.swing.JTable();
        md_id = new javax.swing.JTextField();
        md_fname = new javax.swing.JTextField();
        md_txtTime = new javax.swing.JTextField();
        md_designation = new javax.swing.JTextField();
        md_medication = new javax.swing.JTextField();
        md_fnameLabel = new javax.swing.JLabel();
        md_medicationLabel = new javax.swing.JLabel();
        md_dateLabel = new javax.swing.JLabel();
        md_timeLabel = new javax.swing.JLabel();
        md_departmentLabel = new javax.swing.JLabel();
        md_idLabel = new javax.swing.JLabel();
        md_genderLabel = new javax.swing.JLabel();
        md_designationLabel = new javax.swing.JLabel();
        md_timebtn = new javax.swing.JButton();
        md_department = new javax.swing.JComboBox<>();
        md_gender = new javax.swing.JComboBox<>();
        md_submitbtn = new javax.swing.JButton();
        md_date = new com.toedter.calendar.JDateChooser();
        md_searchID = new javax.swing.JTextField();
        md_searchIdLabel = new javax.swing.JLabel();
        md_searchPatientLabel = new javax.swing.JLabel();
        md_searchPatientId = new javax.swing.JTextField();
        eq_updatebtn = new javax.swing.JButton();
        labelblocker = new javax.swing.JLabel();
        labelblocker1 = new javax.swing.JLabel();
        labelblocker2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        md_patients = new javax.swing.JTable();
        homebar = new javax.swing.JPanel();
        md_searchMedicine = new javax.swing.JTextField();
        md_searchNameLabel = new javax.swing.JLabel();
        md_searchMedicineLabel = new javax.swing.JLabel();
        md_searchName = new javax.swing.JTextField();
        homeButton = new javax.swing.JLabel();
        refreshButton = new javax.swing.JLabel();
        EquipemtnExportTable = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        resizeButton = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();

        md_time.setTextRefernce(md_txtTime);

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        md_frame.setBackground(new java.awt.Color(255, 255, 255));

        md_infoPanel.setBackground(new java.awt.Color(53, 64, 142));

        md_meds.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        md_meds.setForeground(new java.awt.Color(0, 0, 0));
        md_meds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ITEM", "QUANTITY LEFT", "NO. DISPENSED", "YEAR EXPIRY", "MONTH EXPIRY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
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
        md_meds.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        md_meds.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        md_meds.setRowHeight(40);
        md_meds.setSelectionBackground(new java.awt.Color(51, 102, 0));
        md_meds.setSelectionForeground(new java.awt.Color(255, 255, 255));
        md_meds.setShowGrid(false);
        md_meds.getTableHeader().setResizingAllowed(false);
        md_meds.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(md_meds);

        md_id.setBackground(new java.awt.Color(255, 255, 255));
        md_id.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        md_id.setForeground(new java.awt.Color(0, 0, 0));
        md_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        md_id.setToolTipText("EX: 2021-123456");

        md_fname.setBackground(new java.awt.Color(255, 255, 255));
        md_fname.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        md_fname.setForeground(new java.awt.Color(0, 0, 0));
        md_fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        md_fname.setToolTipText("EX: Cruz, Juan Pogi A.");

        md_txtTime.setEditable(false);
        md_txtTime.setBackground(new java.awt.Color(255, 255, 255));
        md_txtTime.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        md_txtTime.setForeground(new java.awt.Color(0, 0, 0));
        md_txtTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        md_txtTime.setToolTipText("Click the button beside this field for the time selector to show up.");

        md_designation.setBackground(new java.awt.Color(255, 255, 255));
        md_designation.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        md_designation.setForeground(new java.awt.Color(0, 0, 0));
        md_designation.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        md_medication.setEditable(false);
        md_medication.setBackground(new java.awt.Color(255, 255, 255));
        md_medication.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        md_medication.setForeground(new java.awt.Color(0, 0, 0));
        md_medication.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        md_medication.setToolTipText("");

        md_fnameLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        md_fnameLabel.setForeground(new java.awt.Color(255, 255, 255));
        md_fnameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        md_fnameLabel.setText("FULL NAME:");

        md_medicationLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        md_medicationLabel.setForeground(new java.awt.Color(255, 255, 255));
        md_medicationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        md_medicationLabel.setText("MEDICATION:");

        md_dateLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        md_dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        md_dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        md_dateLabel.setText("DATE:");

        md_timeLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        md_timeLabel.setForeground(new java.awt.Color(255, 255, 255));
        md_timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        md_timeLabel.setText("TIME:");

        md_departmentLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        md_departmentLabel.setForeground(new java.awt.Color(255, 255, 255));
        md_departmentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        md_departmentLabel.setText("DEPARTMENT:");

        md_idLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        md_idLabel.setForeground(new java.awt.Color(255, 255, 255));
        md_idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        md_idLabel.setText("NATIONALIAN ID:");

        md_genderLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        md_genderLabel.setForeground(new java.awt.Color(255, 255, 255));
        md_genderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        md_genderLabel.setText("SEX:");

        md_designationLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        md_designationLabel.setForeground(new java.awt.Color(255, 255, 255));
        md_designationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        md_designationLabel.setText("DESIGNATION:");

        md_timebtn.setBackground(new java.awt.Color(255, 255, 255));
        md_timebtn.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        md_timebtn.setForeground(new java.awt.Color(0, 0, 0));
        md_timebtn.setText("...");
        md_timebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        md_timebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                md_timebtnActionPerformed(evt);
            }
        });

        md_department.setBackground(new java.awt.Color(255, 255, 255));
        md_department.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        md_department.setForeground(new java.awt.Color(0, 0, 0));
        md_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Senior HighSchool", "Faculty", "BS Information Technology", "BS-Computer Engineering", "BS-Civil Engineering", "BS-Architecture", "BA-Economics", "BS-Pychology", "BA-English Language Studies", "B-Physical Education", "Graduate Studies", "BS-Tourism Management", "BS-Hospitality Management", "BSBA-Financial Management", "BSBA-Marketing Management", "BS-Accountancy", "BS-Accounting Information System", "HUMMS", "ABM", "STEM", "Sports Track", "Faculty", "Staff" }));
        md_department.setSelectedIndex(-1);
        md_department.setBorder(null);

        md_gender.setBackground(new java.awt.Color(255, 255, 255));
        md_gender.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        md_gender.setForeground(new java.awt.Color(0, 0, 0));
        md_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        md_gender.setSelectedIndex(-1);
        md_gender.setBorder(null);

        md_submitbtn.setBackground(new java.awt.Color(51, 102, 0));
        md_submitbtn.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        md_submitbtn.setForeground(new java.awt.Color(255, 255, 255));
        md_submitbtn.setText("SUBMIT");
        md_submitbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        md_submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                md_submitbtnActionPerformed(evt);
            }
        });

        md_date.setDateFormatString("yyyy-MM-dd");
        md_date.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        md_searchID.setBackground(new java.awt.Color(255, 255, 255));
        md_searchID.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        md_searchID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        md_searchID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                md_searchIDKeyPressed(evt);
            }
        });

        md_searchIdLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        md_searchIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        md_searchIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        md_searchIdLabel.setText("MEDICINE ID:");

        md_searchPatientLabel.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        md_searchPatientLabel.setForeground(new java.awt.Color(255, 255, 255));
        md_searchPatientLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        md_searchPatientLabel.setText("PATIENT ID:");

        md_searchPatientId.setBackground(new java.awt.Color(255, 255, 255));
        md_searchPatientId.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        md_searchPatientId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        md_searchPatientId.setMaximumSize(new java.awt.Dimension(400, 35));
        md_searchPatientId.setMinimumSize(new java.awt.Dimension(245, 35));
        md_searchPatientId.setPreferredSize(new java.awt.Dimension(400, 35));
        md_searchPatientId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                md_searchPatientIdKeyPressed(evt);
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

        javax.swing.GroupLayout md_infoPanelLayout = new javax.swing.GroupLayout(md_infoPanel);
        md_infoPanel.setLayout(md_infoPanelLayout);
        md_infoPanelLayout.setHorizontalGroup(
            md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, md_infoPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(md_id)
                    .addComponent(md_fname)
                    .addComponent(md_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(md_department, 0, 1, Short.MAX_VALUE)
                    .addComponent(md_idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(md_dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(md_fnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(md_departmentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(md_infoPanelLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(md_gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(md_infoPanelLayout.createSequentialGroup()
                                .addComponent(md_txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(md_timebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(md_designation, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(md_medication, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(md_designationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(md_timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(md_genderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, md_infoPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(md_medicationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63)
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(md_searchIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(md_searchID)
                    .addComponent(md_submitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55)
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(md_infoPanelLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eq_updatebtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelblocker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(md_searchPatientLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(md_searchPatientId, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelblocker2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(labelblocker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(6, 6, 6))
        );
        md_infoPanelLayout.setVerticalGroup(
            md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(md_infoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, md_infoPanelLayout.createSequentialGroup()
                        .addComponent(md_dateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(md_date, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(md_fnameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, md_infoPanelLayout.createSequentialGroup()
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(md_idLabel)
                            .addComponent(md_genderLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(md_id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(md_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(md_timeLabel)
                            .addComponent(md_searchIdLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(md_txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(md_timebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(md_searchID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(md_medicationLabel)
                        .addGap(6, 6, 6)))
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(md_medication, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(md_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(md_submitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(md_departmentLabel)
                    .addComponent(md_designationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(md_department, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(md_designation, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
            .addGroup(md_infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(md_searchPatientLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelblocker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelblocker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(md_infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(md_searchPatientId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eq_updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelblocker2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        md_patients.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        md_patients.setForeground(new java.awt.Color(0, 0, 0));
        md_patients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PATIENT NO.", "STUDENT ID", "DATE", "NAME", "SEX", "DESIGNATION", "DEPARTMENT", "TIME", "MEDICATION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        md_patients.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        md_patients.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        md_patients.setRowHeight(40);
        md_patients.setSelectionBackground(new java.awt.Color(51, 102, 0));
        md_patients.setSelectionForeground(new java.awt.Color(255, 255, 255));
        md_patients.setShowGrid(false);
        md_patients.getTableHeader().setResizingAllowed(false);
        md_patients.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(md_patients);

        homebar.setBackground(new java.awt.Color(255, 255, 255));

        md_searchMedicine.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        md_searchMedicine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                md_searchMedicineKeyReleased(evt);
            }
        });

        md_searchNameLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        md_searchNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        md_searchNameLabel.setText("SEARCH NAME OF PATIENT:");

        md_searchMedicineLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        md_searchMedicineLabel.setForeground(new java.awt.Color(0, 0, 0));
        md_searchMedicineLabel.setText("SEARCH EQUIPMENTS:");

        md_searchName.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        md_searchName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                md_searchNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                md_searchNameKeyReleased(evt);
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

        EquipemtnExportTable.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        EquipemtnExportTable.setForeground(new java.awt.Color(0, 0, 0));
        EquipemtnExportTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EquipemtnExportTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/upload.png"))); // NOI18N
        EquipemtnExportTable.setToolTipText("Export patient's table");
        EquipemtnExportTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EquipemtnExportTable.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        EquipemtnExportTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EquipemtnExportTableMouseClicked(evt);
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
                .addComponent(md_searchNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(md_searchName, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(md_searchMedicine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(md_searchMedicineLabel)
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
                    .addComponent(md_searchMedicine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(md_searchMedicineLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(md_searchNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(md_searchName)
                    .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EquipemtnExportTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resizeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minimizeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout md_frameLayout = new javax.swing.GroupLayout(md_frame);
        md_frame.setLayout(md_frameLayout);
        md_frameLayout.setHorizontalGroup(
            md_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(md_infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(md_frameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        md_frameLayout.setVerticalGroup(
            md_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(md_frameLayout.createSequentialGroup()
                .addComponent(homebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(md_infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(md_frame, java.awt.BorderLayout.CENTER);

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

            DefaultTableModel medTable = (DefaultTableModel) md_meds.getModel();

            String sql = "SELECT * FROM medicine_inventory";
            ResultSet rs = st.executeQuery(sql);

            String item;
            int initialquantity, year_expiry, month_expiry, id, disposedMeds;

            while (rs.next()) {
                id = rs.getInt("md_id");
                disposedMeds = rs.getInt("md_disposed");
                item = rs.getString("md_item");
                initialquantity = rs.getInt("md_quantity");
                year_expiry = rs.getInt("md_year_expiry");
                month_expiry = rs.getInt("md_month_expiry");

                medTable.addRow(new Object[]{id, item, initialquantity, disposedMeds, year_expiry, month_expiry});

            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void loadPatientData() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            DefaultTableModel medPatientTable = (DefaultTableModel) md_patients.getModel();

            String sql = "SELECT * FROM medicine_takers";
            ResultSet rs = st.executeQuery(sql);

            String med_patientID, med_fname, med_time, med_department, med_gender, med_designation, med_med;
            int med_id;
            Date formattedDate;
            while (rs.next()) {
                med_id = rs.getInt("md_id");
                formattedDate = rs.getDate("md_date");
                med_patientID = rs.getString("md_patient_id");
                med_fname = rs.getString("md_fname");
                med_gender = rs.getString("md_sex");
                med_designation = rs.getString("md_designation");
                med_time = rs.getString("md_time");
                med_department = rs.getString("md_department");
                med_med = rs.getString("md_medication");

                medPatientTable.addRow(new Object[]{med_id, med_patientID, formattedDate, med_fname, med_gender, med_designation, med_department, med_time, med_med});

            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void subtractMedicine() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass, ID;

            url = "jdbc:mysql://localhost:3306/hso_database";
            user = "root";
            pass = "";

            ID = md_searchID.getText();

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            String sql = "SELECT md_quantity FROM medicine_inventory WHERE md_id = '" + ID + "'";
            ResultSet rs = st.executeQuery(sql);

            int currentQuantity = 0;
            if (rs.next()) {
                currentQuantity = rs.getInt("md_quantity");
            }

            sql = "UPDATE medicine_inventory SET md_quantity = " + (currentQuantity - 1) + " WHERE md_id = '" + ID + "'";
            st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void disposedMedicine() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass, ID;

            url = "jdbc:mysql://localhost:3306/hso_database";
            user = "root";
            pass = "";

            ID = md_searchID.getText();

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            String sql = "SELECT md_disposed FROM medicine_inventory WHERE md_id = '" + ID + "'";
            ResultSet rs = st.executeQuery(sql);

            int currentDisposed = 0;
            if (rs.next()) {
                currentDisposed = rs.getInt("md_disposed");
            }

            sql = "UPDATE medicine_inventory SET md_disposed = " + (currentDisposed + 1) + " WHERE md_id = '" + ID + "'";
            st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }


    private void md_timebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_md_timebtnActionPerformed
        md_time.showPopup();
    }//GEN-LAST:event_md_timebtnActionPerformed

    private void md_submitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_md_submitbtnActionPerformed

        String url, user, pass, query;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement st = con.prepareStatement("INSERT INTO medicine_takers(md_patient_id, md_date, md_fname, md_sex, md_designation, md_department, md_time, md_medication) VALUES (?,?,?,?,?,?,?,?)");

            Date med_date = md_date.getDate();
            String formattedDate;

            if (med_date != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                formattedDate = sdf.format(med_date);
            } else {
                formattedDate = "";
            }

            if (md_date.getDate() == null) {
                JOptionPane.showMessageDialog(new JFrame(), "Date added of patient is required to proceed.", "ERROR: Date.", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(md_id.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Patient ID is required to proceed.", "ERROR: Patient ID.", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(md_fname.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Patient Name is required to proceed.", "ERROR: Patient Name.", JOptionPane.ERROR_MESSAGE);
            } else if (md_gender.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(new JFrame(), "Patient gender is required to proceed.", "ERROR: Patient Gender.", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(md_txtTime.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Time of visitation is required to proceed.", "ERROR: Time.", JOptionPane.ERROR_MESSAGE);
            } else if (md_department.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(new JFrame(), "Department of the patient is required to proceed.", "ERROR: Time.", JOptionPane.ERROR_MESSAGE);
            } else {

                String med_patientID = md_id.getText().toUpperCase();
                String med_fname = md_fname.getText().toUpperCase();
                String med_time = md_txtTime.getText().toUpperCase();
                String med_department = md_department.getSelectedItem().toString();
                String med_gender = md_gender.getSelectedItem().toString();
                String med_designation = md_designation.getText();
                String med_med = md_medication.getText();

                query = "INSERT INTO medicine_takers (md_patient_id, md_date, md_fname, md_sex, md_designation, md_department, md_time, md_medication) " + "VALUES ('" + med_patientID + "', '" + formattedDate + "', '" + med_fname + "','" + med_gender + "' , '" + med_designation + "', '" + med_department + "', '" + med_time + "', '" + med_med + "')";
                st.executeUpdate(query);

                disposedMedicine();
                subtractMedicine();

                DefaultTableModel medPatientTable = (DefaultTableModel) md_patients.getModel();
                DefaultTableModel medTable = (DefaultTableModel) md_meds.getModel();

                JOptionPane.showMessageDialog(null, "Patient recording successful", "UPDATE: Recorded", JOptionPane.INFORMATION_MESSAGE);

                medPatientTable.setRowCount(0);
                medTable.setRowCount(0);

                loadPatientData();
                loadData();

                md_id.setText("");
                md_fname.setText("");
                md_txtTime.setText("");
                md_department.setSelectedItem(null);
                md_gender.setSelectedItem(null);
                md_designation.setText("");
                md_medication.setText("");
                md_searchID.setText("");

                con.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

    }//GEN-LAST:event_md_submitbtnActionPerformed

    private Dimension originalSize;
    private Point originalLocation;

    private void md_searchIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_md_searchIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if ("".equals(md_searchID.getText())) {
                JOptionPane.showMessageDialog(null, "Id of medicine is required to proceed.", "ERROR: Medicine id", JOptionPane.ERROR_MESSAGE);
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

                    ID = md_searchID.getText();
                    if ("".equals(ID)) {
                        JOptionPane.showMessageDialog(new JFrame(), "ID of the medicine is required to proceed.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String sql = "SELECT * FROM medicine_inventory WHERE md_id = " + ID;
                        ResultSet rs = st.executeQuery(sql);

                        while (rs.next()) {
                            md_medication.setText(rs.getString("md_item"));
                            notFound = 1;
                        }
                        if (notFound == 1) {
                            DefaultTableModel medTable = (DefaultTableModel) md_meds.getModel();
                            for (int i = 0; i < medTable.getRowCount(); i++) {
                                if (medTable.getValueAt(i, 0).toString().equals(ID)) {
                                    md_meds.getSelectionModel().setSelectionInterval(i, i);
                                    md_meds.scrollRectToVisible(md_meds.getCellRect(i, 0, true));
                                    break;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(new JFrame(), "Invalid ID. Please select from the table.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_md_searchIDKeyPressed

    private void md_searchPatientIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_md_searchPatientIdKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if ("".equals(md_searchPatientId.getText())) {
                JOptionPane.showMessageDialog(null, "Id of medicine is required to proceed.", "ERROR: Medicine id", JOptionPane.INFORMATION_MESSAGE);
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

                    ID = md_searchPatientId.getText();
                    if ("".equals(ID)) {
                        JOptionPane.showMessageDialog(new JFrame(), "ID of the patient is required to proceed.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String sql = "SELECT * FROM medicine_takers WHERE md_id = " + ID;
                        ResultSet rs = st.executeQuery(sql);

                        while (rs.next()) {

                            md_medication.setText(rs.getString("md_medication"));
                            md_fname.setText(rs.getString("md_fname"));
                            md_date.setDate(rs.getDate("md_date"));
                            md_id.setText(rs.getString("md_patient_id"));
                            md_gender.setSelectedItem(rs.getString("md_sex"));
                            md_designation.setText(rs.getString("md_designation"));
                            md_department.setSelectedItem(rs.getString("md_department"));
                            md_txtTime.setText(rs.getString("md_time"));
                            notFound = 1;
                        }
                        if (notFound == 1) {
                            DefaultTableModel medPatientTable = (DefaultTableModel) md_patients.getModel();
                            for (int i = 0; i < medPatientTable.getRowCount(); i++) {
                                if (medPatientTable.getValueAt(i, 0).toString().equals(ID)) {
                                    md_patients.getSelectionModel().setSelectionInterval(i, i);
                                    md_patients.scrollRectToVisible(md_patients.getCellRect(i, 0, true));
                                    break;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(new JFrame(), "Invalid ID. Please select from the table.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_md_searchPatientIdKeyPressed

    private void eq_updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eq_updatebtnActionPerformed
        String patientID, fname, gender, designation, department, medicine, time;
        Date date = md_date.getDate();
        String formattedDate;
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            formattedDate = sdf.format(date);
        } else {
            formattedDate = "";
        }
        String url, user, pass, ID;
        int notFound = 0;

        // Get the values from the fields
        patientID = md_id.getText();
        fname = md_fname.getText();
        gender = (String) md_gender.getSelectedItem();
        department = (String) md_department.getSelectedItem();
        designation = md_designation.getText();
        medicine = md_medication.getText();
        time = md_txtTime.getText();
        ID = md_searchPatientId.getText();

        // Check if any of the fields are empty
        if (ID.isEmpty() || patientID.isEmpty() || fname.isEmpty() || gender.isEmpty() || department.isEmpty() || medicine.isEmpty() || time.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "ERROR: Select ID of patient to proceed.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

            String sql = "SELECT * FROM medicine_takers WHERE md_id = " + ID;
            ResultSet rs = st.executeQuery(sql);

            Statement stUpdate = con.createStatement();

            while (rs.next()) {
                String updateSql = "UPDATE medicine_takers SET md_patient_id = '" + patientID + "', md_date = '" + formattedDate + "', "
                        + "md_fname = '" + fname + "', md_sex = '" + gender + "', md_designation = '" + designation + "', md_department = '" + department + "',"
                        + "md_time= '" + time + "',md_medication = '" + medicine + "' WHERE md_id = " + ID;
                stUpdate.executeUpdate(updateSql);

                DefaultTableModel medPatientTable = (DefaultTableModel) md_patients.getModel();
                medPatientTable.setRowCount(0);

                DefaultTableModel medTable = (DefaultTableModel) md_meds.getModel();
                medTable.setRowCount(0);

                notFound = 1;

                loadData();
                loadPatientData();

                JOptionPane.showMessageDialog(new JFrame(), "Update Successful!", "UPDATE", JOptionPane.INFORMATION_MESSAGE);
            }
            rs.close();
            st.close();
            if (notFound == 0) {
                JOptionPane.showMessageDialog(new JFrame(), "Invalid ID. Please select from the table.", "ERROR: ID", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }//GEN-LAST:event_eq_updatebtnActionPerformed

    private void md_searchNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_md_searchNameKeyPressed

    }//GEN-LAST:event_md_searchNameKeyPressed

    private void md_searchNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_md_searchNameKeyReleased
        DefaultTableModel medPatientTable = (DefaultTableModel) md_patients.getModel();
        TableRowSorter<DefaultTableModel> medpatients = new TableRowSorter<>(medPatientTable);
        md_patients.setRowSorter(medpatients);
        medpatients.setRowFilter(RowFilter.regexFilter(md_searchName.getText()));
    }//GEN-LAST:event_md_searchNameKeyReleased

    private void md_searchMedicineKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_md_searchMedicineKeyReleased
        DefaultTableModel inv_medsTable = (DefaultTableModel) md_meds.getModel();
        TableRowSorter<DefaultTableModel> medpatients = new TableRowSorter<>(inv_medsTable);
        md_meds.setRowSorter(medpatients);
        medpatients.setRowFilter(RowFilter.regexFilter(md_searchMedicine.getText()));
    }//GEN-LAST:event_md_searchMedicineKeyReleased

    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked
        home home = new home();
        home.show();
        dispose();
    }//GEN-LAST:event_homeButtonMouseClicked

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked

        DefaultTableModel medTable = (DefaultTableModel) md_meds.getModel();
        DefaultTableModel medPatientsTable = (DefaultTableModel) md_patients.getModel();
        

        medTable.setRowCount(0);
        medPatientsTable.setRowCount(0);
        JOptionPane.showMessageDialog(null, "Reloading Successful.", "UPDATE: Reload", JOptionPane.INFORMATION_MESSAGE);

        loadData();
        loadPatientData();
    }//GEN-LAST:event_refreshButtonMouseClicked

    private void EquipemtnExportTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EquipemtnExportTableMouseClicked
        MessageFormat header = new MessageFormat("Patient's Table Records");
        MessageFormat footer = new MessageFormat("");
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);
            md_patients.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null, "Failed");
        }
    }//GEN-LAST:event_EquipemtnExportTableMouseClicked

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
            java.util.logging.Logger.getLogger(hsoinventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hsoinventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hsoinventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hsoinventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                hsoinventory hso = new hsoinventory();
//                hso.loadData();
//                hso.loadPatientData();
                hso.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EquipemtnExportTable;
    private javax.swing.JButton eq_updatebtn;
    private javax.swing.JLabel exitButton;
    private javax.swing.JLabel homeButton;
    private javax.swing.JPanel homebar;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelblocker;
    private javax.swing.JLabel labelblocker1;
    private javax.swing.JLabel labelblocker2;
    private com.toedter.calendar.JDateChooser md_date;
    private javax.swing.JLabel md_dateLabel;
    private javax.swing.JComboBox<String> md_department;
    private javax.swing.JLabel md_departmentLabel;
    private javax.swing.JTextField md_designation;
    private javax.swing.JLabel md_designationLabel;
    private javax.swing.JTextField md_fname;
    private javax.swing.JLabel md_fnameLabel;
    private javax.swing.JPanel md_frame;
    private javax.swing.JComboBox<String> md_gender;
    private javax.swing.JLabel md_genderLabel;
    private javax.swing.JTextField md_id;
    private javax.swing.JLabel md_idLabel;
    private javax.swing.JPanel md_infoPanel;
    private javax.swing.JTextField md_medication;
    private javax.swing.JLabel md_medicationLabel;
    private javax.swing.JTable md_meds;
    private javax.swing.JTable md_patients;
    private javax.swing.JTextField md_searchID;
    private javax.swing.JLabel md_searchIdLabel;
    private javax.swing.JTextField md_searchMedicine;
    private javax.swing.JLabel md_searchMedicineLabel;
    private javax.swing.JTextField md_searchName;
    private javax.swing.JLabel md_searchNameLabel;
    private javax.swing.JTextField md_searchPatientId;
    private javax.swing.JLabel md_searchPatientLabel;
    private javax.swing.JButton md_submitbtn;
    private cambodia.raven.Time md_time;
    private javax.swing.JLabel md_timeLabel;
    private javax.swing.JButton md_timebtn;
    private javax.swing.JTextField md_txtTime;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JLabel refreshButton;
    private javax.swing.JLabel resizeButton;
    // End of variables declaration//GEN-END:variables

    String setSearchName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
