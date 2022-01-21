package Assets;

import Elements.FontHelper;

import javax.swing.*;
import javax.swing.border.LineBorder;
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

    // Labels

    public void labelStyling(JLabel label, Color color, int weight, int size) {
        label.setFont(new FontHelper(weight, size));
        label.setForeground(color);
    }

    // Buttons

    public void transparentButton(JButton button, int weight, int size) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setFont(new FontHelper(weight, size));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void buttonStyling(JButton button, int weight, int size) {
        button.setFont(new FontHelper(weight, size));
        button.setBackground(this.main);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    // Input

    public void passwordFieldStyling(JPasswordField passwordField, Color color, int weight, int size) {
        passwordField.setFont(new FontHelper(weight, size));
        passwordField.setForeground(color);
        passwordField.setBackground(this.grey );
        defaultInputField(passwordField);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                passwordField.getBorder(),
                BorderFactory.createEmptyBorder(0, 8, 0, 8)));
    }

    public void defaultInputField(JPasswordField passwordField){
        passwordField.setBorder(new LineBorder(this.grey));
    }

    public void dangerInputField(JPasswordField passwordField){
        passwordField.setBorder(new LineBorder(new Color(255, 0, 0)));
    }

}
