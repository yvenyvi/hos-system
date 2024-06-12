
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Lance
 */
public class SignUpLogIn extends javax.swing.JFrame {

    public SignUpLogIn() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        framePanel = new javax.swing.JPanel();
        imagePanel = new javax.swing.JPanel();
        nuLogo = new javax.swing.JLabel();
        nubImage = new javax.swing.JLabel();
        loginLogoLabel = new javax.swing.JLabel();
        lg_passwordLabel = new javax.swing.JLabel();
        lg_txtUsername = new javax.swing.JTextField();
        lg_usernameLabel = new javax.swing.JLabel();
        lg_seePassword = new javax.swing.JCheckBox();
        lg_loginButton = new javax.swing.JButton();
        lg_signupLabel = new javax.swing.JLabel();
        lg_signupButton = new javax.swing.JButton();
        lg_txtPassword = new javax.swing.JPasswordField();
        minimizeButton = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        framePanel.setBackground(new java.awt.Color(255, 255, 255));
        framePanel.setLayout(null);

        imagePanel.setBackground(new java.awt.Color(53, 64, 142));
        imagePanel.setLayout(null);

        nuLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/left (1).png"))); // NOI18N
        nuLogo.setText("jLabel2");
        imagePanel.add(nuLogo);
        nuLogo.setBounds(0, 0, 440, 230);

        nubImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bulldogs.jpg"))); // NOI18N
        nubImage.setText("jLabel1");
        imagePanel.add(nubImage);
        nubImage.setBounds(-330, 230, 770, 370);

        framePanel.add(imagePanel);
        imagePanel.setBounds(0, 0, 440, 600);

        loginLogoLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 60)); // NOI18N
        loginLogoLabel.setForeground(new java.awt.Color(53, 64, 142));
        loginLogoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLogoLabel.setText("LOGIN");
        framePanel.add(loginLogoLabel);
        loginLogoLabel.setBounds(540, 120, 250, 70);

        lg_passwordLabel.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        lg_passwordLabel.setForeground(new java.awt.Color(0, 0, 0));
        lg_passwordLabel.setText("PASSWORD:");
        framePanel.add(lg_passwordLabel);
        lg_passwordLabel.setBounds(480, 350, 110, 20);

        lg_txtUsername.setBackground(new java.awt.Color(255, 255, 255));
        lg_txtUsername.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        lg_txtUsername.setForeground(new java.awt.Color(0, 0, 0));
        lg_txtUsername.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lg_txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lg_txtUsernameKeyPressed(evt);
            }
        });
        framePanel.add(lg_txtUsername);
        lg_txtUsername.setBounds(480, 270, 380, 50);

        lg_usernameLabel.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        lg_usernameLabel.setForeground(new java.awt.Color(0, 0, 0));
        lg_usernameLabel.setText("USERNAME:");
        framePanel.add(lg_usernameLabel);
        lg_usernameLabel.setBounds(480, 250, 110, 20);

        lg_seePassword.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        lg_seePassword.setForeground(new java.awt.Color(0, 0, 0));
        lg_seePassword.setText("See Password:");
        lg_seePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lg_seePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lg_seePasswordActionPerformed(evt);
            }
        });
        framePanel.add(lg_seePassword);
        lg_seePassword.setBounds(740, 420, 130, 20);

        lg_loginButton.setBackground(new java.awt.Color(53, 64, 142));
        lg_loginButton.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        lg_loginButton.setForeground(new java.awt.Color(255, 255, 255));
        lg_loginButton.setText("Login");
        lg_loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lg_loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lg_loginButtonActionPerformed(evt);
            }
        });
        framePanel.add(lg_loginButton);
        lg_loginButton.setBounds(480, 430, 130, 30);

        lg_signupLabel.setForeground(new java.awt.Color(102, 102, 102));
        lg_signupLabel.setText("Don't have an account? Sign up here:");
        framePanel.add(lg_signupLabel);
        lg_signupLabel.setBounds(600, 570, 220, 20);

        lg_signupButton.setBackground(new java.awt.Color(204, 204, 204));
        lg_signupButton.setForeground(new java.awt.Color(0, 0, 0));
        lg_signupButton.setText("Sign up");
        lg_signupButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lg_signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lg_signupButtonActionPerformed(evt);
            }
        });
        framePanel.add(lg_signupButton);
        lg_signupButton.setBounds(810, 570, 72, 23);

        lg_txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        lg_txtPassword.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        lg_txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        lg_txtPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lg_txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lg_txtPasswordKeyPressed(evt);
            }
        });
        framePanel.add(lg_txtPassword);
        lg_txtPassword.setBounds(480, 370, 380, 50);

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minus.png"))); // NOI18N
        minimizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
        });
        framePanel.add(minimizeButton);
        minimizeButton.setBounds(820, 0, 32, 40);

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close (2).png"))); // NOI18N
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });
        framePanel.add(exitButton);
        exitButton.setBounds(860, 0, 32, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(framePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(framePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lg_signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lg_signupButtonActionPerformed
        // TODO add your handling code here:
        Signup signup = new Signup();
        signup.show();
        dispose();
    }//GEN-LAST:event_lg_signupButtonActionPerformed

    private void lg_seePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lg_seePasswordActionPerformed
        // TODO add your handling code here:
        if (lg_seePassword.isSelected()) {
            lg_txtPassword.setEchoChar((char) 0);
        } else {
            lg_txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_lg_seePasswordActionPerformed

    private void lg_loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lg_loginButtonActionPerformed
        String username, password, query, passDb = null;
        String url, user, pass;

        url = "jdbc:MySQL://localhost:3306/hso_database";
        user = "root";
        pass = "";
        int notFound = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            if ("".equals(lg_txtUsername.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Username is required to proceed.", "ERROR: Missing Username.", JOptionPane.ERROR_MESSAGE);
            } else if ("".equals(lg_txtPassword.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Password is required to proceed.", "ERROR: Missing Password.", JOptionPane.ERROR_MESSAGE);
            } else {
                username = lg_txtUsername.getText();
                password = lg_txtPassword.getText();

                query = "SELECT * FROM user WHERE username = '" + username + "'";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    passDb = rs.getString("password");
                    notFound = 1;

                }
                if (notFound == 1 && password.equals(passDb)) {
                    home home = new home();

                    JOptionPane.showMessageDialog(new JFrame(), "Login successfull!", "Successful!", JOptionPane.INFORMATION_MESSAGE);
                    home.show();
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Incorrect email or password.", "ERROR: Incorrect Input.", JOptionPane.ERROR_MESSAGE);
                }

                lg_txtUsername.setText("");
                lg_txtPassword.setText("");

            }
        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
        }
    }//GEN-LAST:event_lg_loginButtonActionPerformed

    private void lg_txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lg_txtUsernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            lg_txtPassword.requestFocus();
        }
    }//GEN-LAST:event_lg_txtUsernameKeyPressed

    private void lg_txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lg_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            lg_txtUsername.requestFocus();

            String username, password, query, passDb = null;
            String url, user, pass;

            url = "jdbc:MySQL://localhost:3306/hso_database";
            user = "root";
            pass = "";
            int notFound = 0;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                Statement st = con.createStatement();
                if ("".equals(lg_txtUsername.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Username is required to proceed.", "ERROR: Missing Username.", JOptionPane.ERROR_MESSAGE);
                } else if ("".equals(lg_txtPassword.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Password is required to proceed.", "ERROR: Missing Password.", JOptionPane.ERROR_MESSAGE);
                } else {
                    username = lg_txtUsername.getText();
                    password = lg_txtPassword.getText();

                    query = "SELECT * FROM user WHERE username = '" + username + "'";
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {
                        passDb = rs.getString("password");
                        notFound = 1;

                    }
                    if (notFound == 1 && password.equals(passDb)) {
                        home home = new home();

                        JOptionPane.showMessageDialog(new JFrame(), "Login successfull!", "Successful!", JOptionPane.INFORMATION_MESSAGE);
                        home.show();
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Incorrect email or password.", "ERROR: Incorrect Input.", JOptionPane.ERROR_MESSAGE);
                    }

                    lg_txtUsername.setText("");
                    lg_txtPassword.setText("");

                }
            } catch (Exception e) {
                System.out.println("Error!" + e.getMessage());
            }
        }
    }//GEN-LAST:event_lg_txtPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(SignUpLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpLogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitButton;
    private javax.swing.JPanel framePanel;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton lg_loginButton;
    private javax.swing.JLabel lg_passwordLabel;
    private javax.swing.JCheckBox lg_seePassword;
    private javax.swing.JButton lg_signupButton;
    private javax.swing.JLabel lg_signupLabel;
    private javax.swing.JPasswordField lg_txtPassword;
    private javax.swing.JTextField lg_txtUsername;
    private javax.swing.JLabel lg_usernameLabel;
    private javax.swing.JLabel loginLogoLabel;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JLabel nuLogo;
    private javax.swing.JLabel nubImage;
    // End of variables declaration//GEN-END:variables
}
