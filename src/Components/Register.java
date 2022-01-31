package Components;

import Assets.Styles;
import Cache.Root;
import Elements.Input;

import javax.swing.*;
import java.util.regex.Pattern;

public class Register extends JPanel {
    public JButton sign_in;
    private Input name, email, password;
    Styles styles;

    public Register(Root root) {
        styles = new Styles();
        setLayout(null);
        setBackground(styles.background);

        JLabel panel_header = new JLabel("Join Expense Manager");
        styles.labelStyling(panel_header, styles.typo, styles.SEMIBOLD, 24);
        add(panel_header);
        panel_header.setBounds(0, 0, 326, 40);

        name = new Input(styles.grey);
        name.setWidth(326);
        name.setLabel("Full Name");
        add(name);
        name.setBounds(0, 72);

        email = new Input(styles.grey);
        email.setWidth(326);
        email.setLabel("Email");
        add(email);
        email.setBounds(0, 164);

        password = new Input(styles.grey);
        password.setWidth(326);
        password.setLabel("Password");
        password.setType("password");
        add(password);
        password.setBounds(0, 256);

        sign_in = new JButton("SignIn");
        styles.buttonStyling(sign_in, styles.SEMIBOLD, 20);
        add(sign_in);
        sign_in.setBounds(0, 356, 326, 48);

    }

    public void tryRegister(Root root) {
        if (validateForm()) {
            root.dbConnect.register(root, name.getText(), email.getText(), password.getText());
        }
    }

    public boolean validateForm() {
        boolean flag = true;
        if (name.isEmpty()) {
            name.setDanger();
            flag = false;
        } else {
            name.setDefault();
        }

        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        if (email.isEmpty() || !VALID_EMAIL_ADDRESS_REGEX.matcher(email.getText()).find()) {
            email.setDanger();
            flag = false;
        } else {
            email.setDefault();
        }

        if (password.getPassword().length() < 8) {
            password.setDanger();
            flag = false;
        } else {
            password.setDefault();
        }

        return flag;
    }

}
