package Pages;

import Assets.Styles;
import Cache.Root;
import Components.Accounts.AccountForm;
import Components.Accounts.AccountList;
import Components.Accounts.SideCard;
import Controller.AccountsController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Accounts extends JPanel {
    Accounts parent;
    AccountList accountList;
    AccountForm accountForm;
    SideCard sideCard;

    public Accounts(Root root) {
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.background);
        setSize(960, 576);
        parent = this;

        new AccountsController(root);

        sideCard = new SideCard();
        add(sideCard);
        sideCard.setBounds(24, 24, 288, 308);

        accountList = new AccountList(root);
        add(accountList);
        accountList.setBounds(336, 24, 600, 528);

        accountForm = new AccountForm(root);

        initActionListener(sideCard, root);

    }

    public void initActionListener(SideCard sideCard, Root root) {
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

        sideCard.add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sideCard.setVisible(false);
                accountList.setVisible(false);
                accountForm = new AccountForm(root);
                parent.add(accountForm);
                accountForm.setBounds(180, 20, 600, 520);

                accountForm.addAccount.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        root.accounts.param = "*";
                        if(accountForm.addNewAccount(root)){
                            parent.remove(accountForm);
                            sideCard.setVisible(true);
                            parent.refresh(root);
                        }
                    }
                });

                accountForm.back.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        super.mousePressed(e);
                        parent.remove(accountForm);
                        sideCard.setVisible(true);
                        parent.refresh(root);
                    }
                });
            }
        });
    }

    public void refresh(Root root) {
        new AccountsController(root);
        parent.remove(accountList);
        accountList = new AccountList(root);
        add(accountList);
        accountList.setBounds(336, 24, 600, 528);
        parent.revalidate();
        parent.repaint();
    }
}
