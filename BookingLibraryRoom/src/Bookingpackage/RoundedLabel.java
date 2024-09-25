package Bookingpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedLabel extends JLabel {
	private static final long serialVersionUID = 1L;
	private Color backgroundColor;

    public RoundedLabel() {
        setOpaque(false);
        this.backgroundColor = new Color(20,18,24,150); // สีพื้นหลังโปร่งใส
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(backgroundColor);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // วาดกรอบโค้ง
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40));

        // วาดข้อความ
        super.paintComponent(g);
    }
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);

    }
}