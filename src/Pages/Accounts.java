package Pages;

import Assets.Styles;
import Cache.Root;
import Components.Accounts.AccountList;
import Components.Accounts.SideCard;
import Controller.AccountsController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Accounts extends JPanel {
    Accounts parent;
    AccountList accountList;
    public Accounts(Root root){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.background);
        setSize(960, 576);
        parent = this;

        new AccountsController(root);

        SideCard sideCard = new SideCard();
        add(sideCard);
        sideCard.setBounds(24, 24, 288, 308);

        accountList = new AccountList(root);
        add(accountList);
        accountList.setBounds(336, 24, 600, 528);

        initActionListener(sideCard, root);

    }

    public void initActionListener(SideCard sideCard, Root root){
        sideCard.cash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                root.accounts.param = "cash";
                refresh(root);
            }
        });

        sideCard.bank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                root.accounts.param = "bank";
                refresh(root);
            }
        });

        sideCard.mobile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                root.accounts.param = "mobile";
                refresh(root);
            }
        });
    }

    public void refresh(Root root){
        new AccountsController(root);
        parent.remove(accountList);
        accountList = new AccountList(root);
        add(accountList);
        accountList.setBounds(336, 24, 600, 528);
        parent.revalidate();
        parent.repaint();
    }
}
