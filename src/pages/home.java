package pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class home extends JFrame {

    private String username;

    private int totalMedicines = 0;
    private int totalEquipment = 0;
    private int totalPatients = 0;
    private int totalBorrowers = 0;

    public home() {
        this("Guest");
    }

    home(String username) {
        this.username = username;
        fetchAnalytics();
        initComponents();
    }

    private void fetchAnalytics() {
        try (Connection con = util.Database.getConnection()) {
            if (con != null) {
                // Medicines
                try (PreparedStatement ps = con.prepareStatement("SELECT SUM(md_quantity) FROM medicine_inventory");
                     ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) totalMedicines = rs.getInt(1);
                }
                // Equipment
                try (PreparedStatement ps = con.prepareStatement("SELECT SUM(eq_quantity) FROM equipment_inventory");
                     ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) totalEquipment = rs.getInt(1);
                }
                // Patients
                try (PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM medicine_takers");
                     ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) totalPatients = rs.getInt(1);
                }
                // Borrowers
                try (PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM equipment_borrowers");
                     ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) totalBorrowers = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(800, 550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 244, 248));
        setLayout(new BorderLayout());

        // --- TOP BAR ---
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(41, 128, 185));
        topBar.setPreferredSize(new Dimension(800, 70));
        topBar.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));

        JLabel titleLabel = new JLabel("HSO System Dashboard");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        
        JPanel rightTopPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 0));
        rightTopPanel.setOpaque(false);

        JLabel userLabel = new JLabel("User: " + username);
        userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        userLabel.setForeground(Color.WHITE);

        JLabel minimizeBtn = new JLabel(new ImageIcon(getClass().getResource("/images/minus.png")));
        minimizeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setExtendedState(JFrame.ICONIFIED);
            }
        });

        JLabel exitBtn = new JLabel(new ImageIcon(getClass().getResource("/images/close (2).png")));
        exitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        rightTopPanel.add(userLabel);
        rightTopPanel.add(minimizeBtn);
        rightTopPanel.add(exitBtn);

        topBar.add(titleLabel, BorderLayout.WEST);
        topBar.add(rightTopPanel, BorderLayout.EAST);
        add(topBar, BorderLayout.NORTH);

        // --- MAIN CONTENT ---
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setOpaque(false);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Analytics Cards
        JPanel cardsPanel = new JPanel(new GridLayout(2, 2, 25, 25));
        cardsPanel.setOpaque(false);

        cardsPanel.add(createCard("Total Medicines", String.valueOf(totalMedicines), new Color(46, 204, 113)));
        cardsPanel.add(createCard("Total Equipment", String.valueOf(totalEquipment), new Color(52, 152, 219)));
        cardsPanel.add(createCard("Total Patients", String.valueOf(totalPatients), new Color(155, 89, 182)));
        cardsPanel.add(createCard("Total Borrowers", String.valueOf(totalBorrowers), new Color(230, 126, 34)));

        mainPanel.add(cardsPanel, BorderLayout.CENTER);

        // Navigation Buttons
        JPanel navPanel = new JPanel(new GridLayout(1, 4, 15, 0));
        navPanel.setOpaque(false);
        navPanel.setPreferredSize(new Dimension(800, 50));

        JButton medBtn = createNavButton("Medicine Inventory");
        medBtn.addActionListener(e -> {
            new hsoinventory(username).setVisible(true);
            this.dispose();
        });

        JButton eqBtn = createNavButton("Equipment Inventory");
        eqBtn.addActionListener(e -> {
            new hsoequipment(username).setVisible(true);
            this.dispose();
        });

        JButton invBtn = createNavButton("Manage Records");
        invBtn.addActionListener(e -> {
            new hsoinventorymanagement(username).setVisible(true);
            this.dispose();
        });
        
        JButton logoutBtn = createNavButton("Log Out");
        logoutBtn.setBackground(new Color(231, 76, 60));
        logoutBtn.addActionListener(e -> {
            new SignUpLogIn().setVisible(true);
            this.dispose();
        });

        navPanel.add(medBtn);
        navPanel.add(eqBtn);
        navPanel.add(invBtn);
        navPanel.add(logoutBtn);

        mainPanel.add(navPanel, BorderLayout.SOUTH);
        
        add(mainPanel, BorderLayout.CENTER);
    }

    private JPanel createCard(String title, String value, Color color) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(Color.DARK_GRAY);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 48));
        valueLabel.setForeground(color);
        valueLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.SOUTH);
        return card;
    }

    private JButton createNavButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBackground(new Color(41, 128, 185));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new home().setVisible(true));
    }
}
