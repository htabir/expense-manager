package Components.Accounts;

import Assets.Styles;
import Cache.Root;
import Controller.DbConnect;
import Elements.ComboInput;
import Elements.ImagePanel;
import Elements.Input;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

public class AccountForm extends JPanel {
    public JButton addAccount;
    Input title, bank, balance;
    ComboInput category;
    public ImagePanel back;

    public AccountForm(Root root) {
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.white);
        setSize(600, 520);

        JLabel header = new JLabel("Add new account");
        styles.labelStyling(header, styles.typo, styles.MEDIUM, 32);
        add(header);
        header.setBounds(60, 12, 520, 40);

        back = new ImagePanel("D:\\kodes\\Java\\New folder\\ExpenseManager\\src\\Assets\\image\\back.png", 24, 24);
        add(back);
        back.setBounds(24, 21, 24, 24);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        title = new Input(styles.background);
        title.setWidth(552);
        title.setLabel("Account Title");
        add(title);
        title.setBounds(24, 76);
        title.required(95);


        String[] options = {"Cash", "Bank", "Mobile Banking"};
        category = new ComboInput(options);
        category.setWidth(552);
        category.setLabel("Category");
        add(category);
        category.setBounds(24, 168);
        category.required(69);


        bank = new Input(styles.background);
        bank.setWidth(552);
        bank.setLabel("Bank Name");
        add(bank);
        bank.setBounds(24, 260);

        balance = new Input(styles.background);
        balance.setWidth(552);
        balance.setLabel("Starting Balance");
        add(balance);
        balance.setValue("0");
        balance.setBounds(24, 352);

        addAccount = new JButton("+ Add Account");
        styles.buttonStyling(addAccount, styles.MEDIUM, 16);
        add(addAccount);
        addAccount.setBounds(24, 452, 552, 48);
    }

    public boolean addNewAccount(Root root) {
        boolean flag = true;
        root.dbConnect = new DbConnect();
        if (title.isEmpty()) {
            flag = false;
            title.setDanger();
        }else{
            title.setDefault();
        }
        if (balance.isEmpty() || !Pattern.compile("^[0-9]*$").matcher(balance.getText()).find()) {
            flag = false;
            balance.setDanger();
        }else{
            balance.setDefault();
        }

        if (flag){
            return root.dbConnect.addAccount(root, title.getText(), category.getText().split("\\s+")[0].toLowerCase(), bank.getText(), balance.getText());
        }else{
            return false;
        }
    }
}
