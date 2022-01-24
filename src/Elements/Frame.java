package Elements;

import Assets.Styles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {
    private final Styles styles = new Styles();

    public Frame() {
        setSize(960, 640);
        setUndecorated(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(styles.background);
        setTitle("Expense Manager");
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\kodes\\Java\\New folder\\ExpenseManager\\src\\Assets\\image\\logo.png");
        setIconImage(icon);

        JButton close_button = new JButton("×");
        close_button.setBounds(930, 0, 30, 56);
        close_button.setMargin(new Insets(0, 0, 0, 0));
        close_button.setForeground(new Color(175, 175, 175));
        styles.transparentButton(close_button, styles.muted, styles.SEMIBOLD, 22);
        add(close_button);
        close_button.addActionListener(e -> System.exit(0));
        close_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close_button.setForeground(Color.RED);
//                close_button.setFont(new FontHelper(styles.SEMIBOLD, 26));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                close_button.setForeground(new Color(175, 175, 175));
//                close_button.setFont(new FontHelper(styles.SEMIBOLD, 22));
            }
        });

        JButton minimize_button = new JButton("-");
        minimize_button.setBounds(900, 0, 30, 56);
        minimize_button.setMargin(new Insets(0, 0, 0, 0));
        minimize_button.setForeground(new Color(175, 175, 175));
        styles.transparentButton(minimize_button, styles.muted, styles.SEMIBOLD, 22);
        add(minimize_button);
        minimize_button.addActionListener(e -> setState(Frame.ICONIFIED));
        minimize_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimize_button.setForeground(Color.BLACK);
//                minimize_button.setFont(new FontHelper(styles.BLACK, 26));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimize_button.setForeground(new Color(175, 175, 175));
//                minimize_button.setFont(new FontHelper(styles.BLACK, 22));
            }
        });
    }

    public void makeDraggable(){
        JPanel drag_bar = new JPanel();
        add(drag_bar);
        drag_bar.setBackground(new Color(0, 0, 0, 0));
        drag_bar.setBounds(0, 0, 960, 40);

        FrameDragListener frameDragListener = new FrameDragListener(this, drag_bar);
        drag_bar.addMouseListener(frameDragListener);
        drag_bar.addMouseMotionListener(frameDragListener);
    }

    public static class FrameDragListener extends MouseAdapter {

        private final JFrame frame;
        private final JPanel panel;
        private Point mouseDownCompCoords = null;

        public FrameDragListener(JFrame frame, JPanel panel) {
            this.frame = frame;
            this.panel = panel;
        }

        public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }

        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }

        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
    }

}
