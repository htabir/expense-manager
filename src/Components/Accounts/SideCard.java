package Components.Accounts;

import Assets.Styles;

import javax.swing.*;

public class SideCard extends JPanel {
    public JButton cash, bank, mobile, add;
    public SideCard(){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.white);

        JLabel header = new JLabel("Accounts");
        styles.labelStyling(header, styles.typo, styles.MEDIUM, 32);
        add(header);
        header.setBounds(16, 8, 256, 40);

        add = new JButton("+ Add Account");
        styles.buttonStyling(add, styles.MEDIUM, 16);
        add(add);
        add.setBounds(16, 72, 256, 40);

        JLabel filter = new JLabel("Filters");
        styles.labelStyling(filter, styles.muted, styles.LIGHT, 16);
        add(filter);
        filter.setBounds(16, 144, 256, 20);

        cash = new JButton("Cash");
        styles.transparentButton(cash, styles.typo, styles.LIGHT, 16);
        add(cash);
        cash.setBounds(0, 182, 308, 20);

        bank = new JButton("Bank");
        styles.transparentButton(bank, styles.typo, styles.LIGHT, 16);
        add(bank);
        bank.setBounds(0, 222, 308, 20);

        mobile = new JButton("Mobile Banking");
        styles.transparentButton(mobile, styles.typo, styles.LIGHT, 16);
        add(mobile);
        mobile.setBounds(0, 262, 308, 20);

    }
}
