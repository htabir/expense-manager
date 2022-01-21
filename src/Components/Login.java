package Components;

import Assets.Styles;
import Elements.Input;

import javax.swing.*;

public class Login extends JPanel {
    public Login(){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.background);

        JLabel panel_header = new JLabel("<html>Login To <br /> Expense Manager</html>");
        styles.labelStyling(panel_header, styles.typo, styles.SEMIBOLD, 24);
        add(panel_header);
        panel_header.setBounds(0, 0, 326, 70);

        Input email = new Input();
        email.setWidth(326);
        email.setLabel("Email");
        add(email);
        email.setBounds(0, 102);

        Input password = new Input();
        password.setWidth(326);
        password.setLabel("Password");
        password.setType("password");
        add(password);
        password.setBounds(0, 194);

        JButton login = new JButton("Login");
        styles.buttonStyling(login, styles.SEMIBOLD, 20);
        add(login);
        login.setBounds(0, 294, 326, 48);

        JButton sign_in = new JButton("Create New Account.");
        styles.transparentButton(sign_in, styles.LIGHT, 14);
        add(sign_in);
        sign_in.setBounds(81, 500, 200, 20);

        sign_in.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sign_in.setText("<html><u>Create New Account.</u></html>");
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                sign_in.setText("Create New Account.");
            }
        });
    }
}
