
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class home extends javax.swing.JFrame {

    public home() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagePanel = new javax.swing.JPanel();
        medicineLabel = new javax.swing.JLabel();
        inventoryLabel = new javax.swing.JLabel();
        equipmentLabel = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        nutxt = new javax.swing.JLabel();
        nub = new javax.swing.JLabel();
        medicineBtn = new javax.swing.JButton();
        inventoryBtn = new javax.swing.JButton();
        equipmentBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        imagePanel.setBackground(new java.awt.Color(255, 255, 255));
        imagePanel.setLayout(null);

        medicineLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imagePanel.add(medicineLabel);
        medicineLabel.setBounds(130, 260, 160, 60);

        inventoryLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imagePanel.add(inventoryLabel);
        inventoryLabel.setBounds(250, 350, 160, 60);

        equipmentLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imagePanel.add(equipmentLabel);
        equipmentLabel.setBounds(370, 260, 160, 60);

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minus.png"))); // NOI18N
        minimizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
        });
        imagePanel.add(minimizeButton);
        minimizeButton.setBounds(580, 0, 40, 50);

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close (2).png"))); // NOI18N
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });
        imagePanel.add(exitButton);
        exitButton.setBounds(622, 0, 40, 50);

        nutxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/left (1).png"))); // NOI18N
        imagePanel.add(nutxt);
        nutxt.setBounds(110, 30, 450, 120);

        nub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MEDICINE (1).png"))); // NOI18N
        imagePanel.add(nub);
        nub.setBounds(0, -110, 750, 720);

        medicineBtn.setText("MEDICINE");
        medicineBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        medicineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicineBtnActionPerformed(evt);
            }
        });
        imagePanel.add(medicineBtn);
        medicineBtn.setBounds(130, 263, 160, 50);

        inventoryBtn.setText("INVENTORY");
        inventoryBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inventoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryBtnActionPerformed(evt);
            }
        });
        imagePanel.add(inventoryBtn);
        inventoryBtn.setBounds(250, 350, 160, 60);

        equipmentBtn.setText("EQUIPMENT");
        equipmentBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        equipmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipmentBtnActionPerformed(evt);
            }
        });
        imagePanel.add(equipmentBtn);
        equipmentBtn.setBounds(370, 260, 160, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void medicineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicineBtnActionPerformed

        hsoinventory medicine = new hsoinventory();
        medicine.show();
        dispose();
    }//GEN-LAST:event_medicineBtnActionPerformed

    private void inventoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryBtnActionPerformed
        hsoinventorymanagement inventory = new hsoinventorymanagement();
        inventory.show();
        dispose();
    }//GEN-LAST:event_inventoryBtnActionPerformed

    private void equipmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipmentBtnActionPerformed
        hsoequipment equipment = new hsoequipment();
        equipment.show();
        dispose();
    }//GEN-LAST:event_equipmentBtnActionPerformed

    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((JLabel) evt.getSource());
        frame.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton equipmentBtn;
    private javax.swing.JLabel equipmentLabel;
    private javax.swing.JLabel exitButton;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton inventoryBtn;
    private javax.swing.JLabel inventoryLabel;
    private javax.swing.JButton medicineBtn;
    private javax.swing.JLabel medicineLabel;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JLabel nub;
    private javax.swing.JLabel nutxt;
    // End of variables declaration//GEN-END:variables
}
