package Components;

import Assets.Styles;
import Cache.Root;
import Elements.ImagePanel;

import javax.swing.*;

public class Navbar extends JPanel {
    public JButton dashboard, accounts, records, analytics, add_record;
    public Navbar(Root root){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.white);

        ImagePanel logo = new ImagePanel("D:\\kodes\\Java\\New folder\\ExpenseManager\\src\\Assets\\image\\logo.png", 36, 28);
        add(logo);
        logo.setBounds(24, 18, 36, 28);
        logo.setBackground(styles.white);

        dashboard = new JButton("Dashboard");
        styles.transparentButton(dashboard, styles.typo, styles.MEDIUM, 16);
        add(dashboard);
        dashboard.setBounds(92, 0, 116, 64);

        accounts = new JButton("Accounts");
        styles.transparentButton(accounts, styles.muted, styles.LIGHT, 16);
        accounts.setForeground(styles.muted);
        add(accounts);
        accounts.setBounds(210, 0, 100, 64);

        records = new JButton("Records");
        styles.transparentButton(records, styles.muted, styles.LIGHT, 16);
        records.setForeground(styles.muted);
        add(records);
        records.setBounds(310, 0, 96, 64);

        analytics = new JButton("Analytics");
        styles.transparentButton(analytics, styles.muted,  styles.LIGHT, 16);
        analytics.setForeground(styles.muted);
        add(analytics);
        analytics.setBounds(310+96+2, 0, 100, 64);

        add_record = new JButton("+ Record");
        styles.buttonStyling(add_record, styles.MEDIUM, 16);
        add(add_record);
        add_record.setBounds(692, 16, 128, 32);

        ImagePanel user = new ImagePanel("D:\\kodes\\Java\\New folder\\ExpenseManager\\src\\Assets\\image\\user.png", 24, 24);
        user.setBounds(692+128+32, 20, 24, 24);
        user.setBackground(styles.white);
        add(user);

    }
}
