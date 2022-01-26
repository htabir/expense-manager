package Assets;

import Elements.FontHelper;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class Styles {

    // Fonts Style Variable

    public static final int THIN = -1;
    public static final int LIGHT = 0;
    public static final int REGULAR = 1;
    public static final int MEDIUM = 2;
    public static final int SEMIBOLD = 3;
    public static final int BLACK = 4;

    // Colors

    public static final Color primary = new Color(60, 57, 99);
    public static final Color main = new Color(255, 190, 46);
    public static final Color background = new Color(245, 247, 251);
    public static final Color muted = new Color(128, 140, 167);
    public static final Color typo = new Color(0, 0, 0);
    public static final Color grey = new Color(233, 233, 233);
    public static final Color white = new Color(255, 255, 255);
    public static final Color green = new Color(76, 187, 23);
    public static final Color red = new Color(255, 0, 56);

    // Labels

    public void labelStyling(JLabel label, Color color, int weight, int size) {
        label.setFont(new FontHelper(weight, size));
        label.setForeground(color);
    }

    // Buttons

    public void transparentButton(JButton button, Color foreground, int weight, int size) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setFont(new FontHelper(weight, size));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setForeground(foreground);
    }

    public void buttonStyling(JButton button, int weight, int size) {
        button.setFont(new FontHelper(weight, size));
        button.setBackground(this.main);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void setInactive(JButton button) {
        this.transparentButton(button, this.muted, this.LIGHT, 16);
    }

    public void setActive(JButton button) {
        this.transparentButton(button, this.typo, this.MEDIUM, 16);

    }

    // Input

    public void passwordFieldStyling(JPasswordField passwordField, Color foreground, Color background, int weight, int size) {
        passwordField.setFont(new FontHelper(weight, size));
        passwordField.setForeground(foreground);
        passwordField.setBackground(background);
        defaultInputField(passwordField);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                passwordField.getBorder(),
                BorderFactory.createEmptyBorder(0, 8, 0, 8)));
    }

    public void defaultInputField(JPasswordField passwordField) {
        passwordField.setBorder(new LineBorder(this.grey));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                passwordField.getBorder(),
                BorderFactory.createEmptyBorder(0, 8, 0, 8)));
    }

    public void dangerInputField(JPasswordField passwordField) {
        passwordField.setBorder(new LineBorder(new Color(255, 0, 0)));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                passwordField.getBorder(),
                BorderFactory.createEmptyBorder(0, 8, 0, 8)));
    }

    // Scroll Pane
    public void styleScrollPane(JScrollPane scroll){
        scroll.setBorder(BorderFactory.createEmptyBorder());

        scroll.setComponentZOrder(scroll.getVerticalScrollBar(), 0);
        scroll.setComponentZOrder(scroll.getViewport(), 1);
        scroll.getVerticalScrollBar().setOpaque(false);

        scroll.setLayout(new ScrollPaneLayout() {
            @Override
            public void layoutContainer(Container parent) {
                JScrollPane scrollPane = (JScrollPane)parent;

                Rectangle availR = scrollPane.getBounds();
                availR.x = availR.y = 0;

                Insets insets = parent.getInsets();
                availR.x = insets.left;
                availR.y = insets.top;
                availR.width  -= insets.left + insets.right;
                availR.height -= insets.top  + insets.bottom;

                Rectangle vsbR = new Rectangle();
                vsbR.width  = 12;
                vsbR.height = availR.height;
                vsbR.x = availR.x + availR.width - vsbR.width;
                vsbR.y = availR.y;

                if(viewport != null) {
                    viewport.setBounds(availR);
                }
                if(vsb != null) {
                    vsb.setVisible(true);
                    vsb.setBounds(vsbR);
                }
            }
        });
        scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            private final Dimension d = new Dimension();
            @Override protected JButton createDecreaseButton(int orientation) {
                return new JButton() {
                    @Override public Dimension getPreferredSize() {
                        return d;
                    }
                };
            }
            @Override protected JButton createIncreaseButton(int orientation) {
                return new JButton() {
                    @Override public Dimension getPreferredSize() {
                        return d;
                    }
                };
            }
            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle r) {}
            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
                Graphics2D g2 = (Graphics2D)g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                Color color = null;
                JScrollBar sb = (JScrollBar)c;
                if(!sb.isEnabled() || r.width>r.height) {
                    return;
                }else if(isDragging) {
                    color = new Color(255,190,46,255);
                }else if(isThumbRollover()) {
                    color = new Color(255,190,46,100);
                }else {
                    color = new Color(128,148,167,100);
                }
                g2.setPaint(color);
                g2.fillRoundRect(r.x,r.y,r.width,r.height,0,0);
                g2.setPaint(Color.WHITE);
                g2.drawRoundRect(r.x,r.y,r.width,r.height,0,0);
                g2.dispose();
            }
            @Override
            protected void setThumbBounds(int x, int y, int width, int height) {
                super.setThumbBounds(x, y, width, height);
                scrollbar.repaint();
            }
        });
    }

}
