package Components;

import Assets.Styles;
import Cache.Root;
import Elements.Input;

import javax.swing.*;

public class Login extends JPanel {
    public JButton login;
    private Input email, password;
    Styles styles;

    public Login(Root root) {
        styles = new Styles();
        setLayout(null);
        setBackground(styles.background);

        JLabel panel_header = new JLabel("<html>Login To <br /> Expense Manager</html>");
        styles.labelStyling(panel_header, styles.typo, styles.SEMIBOLD, 24);
        add(panel_header);
        panel_header.setBounds(0, 0, 326, 70);

        email = new Input(styles.grey);
        email.setWidth(326);
        email.setLabel("Email");
        add(email);
        email.setBounds(0, 102);

        password = new Input(styles.grey);
        password.setWidth(326);
        password.setLabel("Password");
        password.setType("password");
        add(password);
        password.setBounds(0, 194);

        login = new JButton("Login");
        styles.buttonStyling(login, styles.SEMIBOLD, 20);
        add(login);
        login.setBounds(0, 294, 326, 48);

    }

    public void tryLogin(Root root) {
        root.dbConnect.login(root, email.getText(), password.getPassword());
    }

    public void setDanger() {
        email.setDanger();
        password.setDanger();

    }
}
