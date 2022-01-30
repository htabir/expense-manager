package Components.Records;

import Assets.Styles;
import Cache.Root;
import Elements.ComboInput;
import Elements.ImagePanel;
import Elements.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RecordForm extends JPanel {
    public JButton addRecord;
    Input amount;
    ComboInput account, type, category, transferred_to;
    public ImagePanel back;

    public RecordForm(Root root) {
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.white);
        setSize(600, 520);

        JLabel header = new JLabel("Add new record");
        styles.labelStyling(header, styles.typo, styles.MEDIUM, 32);
        add(header);
        header.setBounds(60, 12, 520, 40);

        back = new ImagePanel("D:\\kodes\\Java\\New folder\\ExpenseManager\\src\\Assets\\image\\back.png", 24, 24);
        add(back);
        back.setBounds(24, 21, 24, 24);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        List <String> accountList = new ArrayList<String>();
        List <Integer> accountIndex = new ArrayList<Integer>();
        int size = 0;

        ResultSet rs = root.dbConnect.fetchAccounts(root);
        try{
            while(rs.next()){
                accountList.add(rs.getString(2));
                accountIndex.add(Integer.parseInt(rs.getString(1)));
                size++;
            }
        }catch(Exception e){
            accountIndex = null;
        }

        String[] accounts = new String[size];
        for(int i=0; i<size; i++){
            accounts[i] = accountList.get(i);
        }

        account = new ComboInput(accounts);
        account.setWidth(552);
        account.setLabel("Account");
        add(account);
        account.setBounds(24, 76);
//        category.required(69);

        String[] types = {"Expense", "Income", "Transfer"};
        type = new ComboInput(types);
        type.setWidth(552);
        type.setLabel("Type");
        add(type);
        type.setBounds(24, 168);

        type.comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(type.getText().contains("Transfer")){
                    category.setVisible(false);
                    transferred_to.setVisible(true);
                }else{
                    transferred_to.setVisible(false);
                    category.setVisible(true);
                }
            }
        });



        String[] categories = {"Food", "Shopping", "Transportation", "Entertainment", "Education", "Others"};
        category = new ComboInput(categories);
        category.setWidth(552);
        category.setLabel("Category");
        add(category);
        category.setBounds(24, 260);

        transferred_to = new ComboInput(accounts);
        transferred_to.setWidth(552);
        transferred_to.setLabel("Transferred To");
        transferred_to.setVisible(false);
        add(transferred_to);
        transferred_to.setBounds(24, 260);

        amount = new Input(styles.background);
        amount.setWidth(552);
        amount.setLabel("Amount");
        add(amount);
        amount.setValue("0");
        amount.setBounds(24, 352);

        addRecord = new JButton("+ Add record");
        styles.buttonStyling(addRecord, styles.MEDIUM, 16);
        add(addRecord);
        addRecord.setBounds(24, 452, 552, 48);
    }

//    public boolean addNewAccount(Root root) {
//        boolean flag = true;
//        root.dbConnect = new DbConnect();
//        if (title.isEmpty()) {
//            flag = false;
//            title.setDanger();
//        }else{
//            title.setDefault();
//        }
//        if (balance.isEmpty() || !Pattern.compile("^[0-9]*$").matcher(balance.getText()).find()) {
//            flag = false;
//            balance.setDanger();
//        }else{
//            balance.setDefault();
//        }
//
//        if (flag){
//            return root.dbConnect.addAccount(root, title.getText(), category.getText().split("\\s+")[0].toLowerCase(), bank.getText(), balance.getText());
//        }else{
//            return false;
//        }
//    }
}
