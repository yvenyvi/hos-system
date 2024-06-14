
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class printBorrower extends javax.swing.JFrame {

    public printBorrower() {
        initComponents();

        showData("", "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        homebar = new javax.swing.JPanel();
        fromDateLabel = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        fromDate = new com.toedter.calendar.JDateChooser();
        toDateLabel = new javax.swing.JLabel();
        toDate = new com.toedter.calendar.JDateChooser();
        searchDate = new javax.swing.JButton();
        searchDateLabel = new javax.swing.JLabel();
        saveTable = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eq_patients = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(53, 64, 142));

        homebar.setBackground(new java.awt.Color(255, 255, 255));

        fromDateLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        fromDateLabel.setForeground(new java.awt.Color(0, 0, 0));
        fromDateLabel.setText("FROM:");

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

        fromDate.setDateFormatString("yyyy-MM-dd");
        fromDate.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        toDateLabel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        toDateLabel.setForeground(new java.awt.Color(0, 0, 0));
        toDateLabel.setText("TO:");

        toDate.setDateFormatString("yyyy-MM-dd");

        searchDate.setBackground(new java.awt.Color(51, 102, 0));
        searchDate.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        searchDate.setForeground(new java.awt.Color(255, 255, 255));
        searchDate.setText("SEARCH");
        searchDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDateActionPerformed(evt);
            }
        });

        searchDateLabel.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        searchDateLabel.setForeground(new java.awt.Color(0, 0, 0));
        searchDateLabel.setText("SEARCH DATE:");

        javax.swing.GroupLayout homebarLayout = new javax.swing.GroupLayout(homebar);
        homebar.setLayout(homebarLayout);
        homebarLayout.setHorizontalGroup(
            homebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homebarLayout.createSequentialGroup()
                .addContainerGap(337, Short.MAX_VALUE)
                .addComponent(fromDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(toDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toDate, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(searchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton)
                .addContainerGap())
            .addGroup(homebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(homebarLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(searchDateLabel)
                    .addContainerGap(702, Short.MAX_VALUE)))
        );
        homebarLayout.setVerticalGroup(
            homebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minimizeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toDateLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fromDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fromDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(homebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(homebarLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(searchDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        saveTable.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        saveTable.setForeground(new java.awt.Color(255, 255, 255));
        saveTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/diskette (1).png"))); // NOI18N
        saveTable.setText("SAVE TABLE");
        saveTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveTable.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        saveTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveTableMouseClicked(evt);
            }
        });

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
        eq_patients.setRowHeight(40);
        eq_patients.setSelectionBackground(new java.awt.Color(51, 102, 0));
        eq_patients.setSelectionForeground(new java.awt.Color(255, 255, 255));
        eq_patients.setShowGrid(false);
        eq_patients.getTableHeader().setResizingAllowed(false);
        eq_patients.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(eq_patients);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveTable)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(homebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveTable, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void searchDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDateActionPerformed
        try {
            eq_patients.setModel(new DefaultTableModel(null, new Object[]{"PATIENT NO.", "STUDENT ID", "DATE", "NAME", "SEX", "DESIGNATION", "DEPARTMENT", "TIME BORROWED", "TIME RETURNED", "MEDICATION"}));
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String fDate = date.format(fromDate.getDate());
            String tDate = date.format(toDate.getDate());
            showData(fDate, tDate);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_searchDateActionPerformed

    private void saveTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveTableMouseClicked
        MessageFormat header = new MessageFormat("Borrower Table Records");
        MessageFormat footer = new MessageFormat("National University Baliwag");
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.LANDSCAPE);
            eq_patients.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null, "Failed");
        }
    }//GEN-LAST:event_saveTableMouseClicked

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";

            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            System.out.println("ex.getMessage()");
        }

        return con;
    }

    public void showData(String d1, String d2) {
        Connection con = getConnection();
        PreparedStatement st;
        ResultSet rs;

        try {

            if (d1.equals("") || d2.equals("")) {
                st = con.prepareStatement("SELECT * FROM `equipment_borrowers`");
            } else {
                st = con.prepareStatement("SELECT * FROM `equipment_borrowers` WHERE `eq_date`BETWEEN ? AND ?");
                st.setString(1, d1);
                st.setString(2, d2);
            }

            rs = st.executeQuery();
            DefaultTableModel borrowerTable = (DefaultTableModel) eq_patients.getModel();

            int id;
            String patientID, fname, gender, designation, timeBorrowed, department, equipment, timeReturned;
            java.util.Date date;
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

                borrowerTable.addRow(new Object[]{id, patientID, date, fname, gender, designation, department, timeBorrowed, timeReturned, equipment});

            }

        } catch (Exception e) {
            System.out.println("e.getMessage()");
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new printPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable eq_patients;
    private javax.swing.JLabel exitButton;
    private com.toedter.calendar.JDateChooser fromDate;
    private javax.swing.JLabel fromDateLabel;
    private javax.swing.JPanel homebar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JLabel saveTable;
    private javax.swing.JButton searchDate;
    private javax.swing.JLabel searchDateLabel;
    private com.toedter.calendar.JDateChooser toDate;
    private javax.swing.JLabel toDateLabel;
    // End of variables declaration//GEN-END:variables
}
