package Bookingpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class LoginUI {
    public static void main(String[] args) {
        FlatDarkLaf.setup(); // dark theme
        
        ImageIcon imc = new ImageIcon("src/Bookingpackage/Logo.png");
        ImageIcon imc2 = new ImageIcon("src/Bookingpackage/LogoAfterEnter.png");
        ImageIcon bg = new ImageIcon("src/Bookingpackage/minimal-mountains.jpg");
       
        JLabel ic = new JLabel(imc);
        JLabel lb = new JLabel(bg);
        
        lb.setSize(1920, 1080);  
        ic.setSize(imc.getIconWidth(), imc.getIconHeight());
        
        RoundedLabel lgn = new RoundedLabel();
        lgn.setLayout(null);
        lgn.setBounds(691, 322, 603, 408);
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(60, 30, 150, 30);
        usernameLabel.setFont(new Font("ROBOTO",Font.PLAIN,20));
        
        JTextField usernameField = new JTextField();
        usernameField.setBackground(Color.WHITE);
        usernameField.setForeground(Color.BLACK);
        usernameField.setFont(new Font("ROBOTO", Font.PLAIN, 18));
        usernameField.setBounds(60, 80, 460, 50);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(60, 145, 150, 30);
        passwordLabel.setFont(new Font("ROBOTO",Font.PLAIN,20));
        
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBackground(Color.WHITE);
        passwordField.setForeground(Color.BLACK);
        passwordField.setFont(new Font("ROBOTO", Font.PLAIN, 24));
        passwordField.setBounds(60, 195, 460, 50);

        // สร้างปุ่มล็อกอิน
        JButton loginButton = new JButton("Sign in");
        loginButton.setBounds(195, 302, 200, 50);
        loginButton.setFont(new Font("ROBOTO", Font.PLAIN, 24));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(0,153,81));
        
        JButton BookingButton = new JButton("Booking");
        BookingButton.setBounds(1440, 25, 210, 50);
        BookingButton.setFont(new Font("ROBOTO", Font.PLAIN, 24));
        BookingButton.setForeground(Color.WHITE);
        BookingButton.setBackground(new Color(20,18,24,150));
        
        JButton ReturnRoomButton = new JButton("ReturnRoom");
        ReturnRoomButton.setBounds(1680, 25, 210, 50);
        ReturnRoomButton.setFont(new Font("ROBOTO", Font.PLAIN, 24));
        ReturnRoomButton.setForeground(Color.WHITE);
        ReturnRoomButton.setBackground(new Color(20,18,24,150));
        
        
        // เพิ่มข้อความและฟิลด์อินพุตลงใน lgn
        lgn.add(usernameLabel);
        lgn.add(usernameField);
        lgn.add(passwordLabel);
        lgn.add(passwordField);
        lgn.add(loginButton);
        
        
        JFrame frame = new JFrame("Booking Library Room");
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(true);
        frame.setIconImage(imc.getImage());
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(frame.getWidth(), frame.getHeight());
        
        lb.setBounds(0, 0, frame.getWidth(), frame.getHeight());  // Background
        ic.setBounds(25, 25, imc.getIconWidth(), imc.getIconHeight());  // Icon
        layeredPane.add(lb, JLayeredPane.DEFAULT_LAYER);  // ชั้นพื้นหลัง
        layeredPane.add(ic, JLayeredPane.PALETTE_LAYER);  // ชั้นของไอคอน
        layeredPane.add(BookingButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(ReturnRoomButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(lgn, JLayeredPane.MODAL_LAYER);   // ชั้นของ login panel
        frame.add(layeredPane);
        frame.setVisible(true);
        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                lb.setSize(frame.getWidth(), frame.getHeight());  // ปรับขนาด background
                layeredPane.setSize(frame.getWidth(), frame.getHeight());  // ปรับขนาด JLayeredPane
                // คำนวณตำแหน่งเพื่อให้ lgn อยู่ตรงกลาง
                int x = (frame.getWidth() - lgn.getWidth()) / 2;
                int y = (frame.getHeight() - lgn.getHeight()) / 2;
                lgn.setBounds(x, y, lgn.getWidth(), lgn.getHeight()); // ตั้งค่าตำแหน่งตรงกลาง
            }
        });


        
        ic.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Icon clicked!"); //จะเอาไปทำไรรก็อีกเรื่องนะ
            }
            public void mouseEntered(MouseEvent e) {
            	ic.setIcon(imc2);
                ic.setBounds(ic.getX(), ic.getY(), imc.getIconWidth() + 4, imc.getIconHeight() + 4);
            }
            public void mouseExited(MouseEvent e) {
            	ic.setIcon(imc);
                ic.setBounds(ic.getX(), ic.getY(), imc.getIconWidth(), imc.getIconHeight());
            }
        });
        
        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                lb.setSize(frame.getWidth(), frame.getHeight());
                layeredPane.setSize(frame.getWidth(), frame.getHeight());
            }
        });
    }
}
