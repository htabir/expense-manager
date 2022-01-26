package Pages;

import Assets.Styles;
import Cache.Root;
import Components.Accounts.AccountList;
import Components.Accounts.SideCard;
import Controller.AccountsController;

import javax.swing.*;

public class Accounts extends JPanel {
    public Accounts(Root root){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.background);
        setSize(960, 576);

        new AccountsController(root);

        SideCard sideCard = new SideCard();
        add(sideCard);
        sideCard.setBounds(24, 24, 288, 308);

        AccountList accountList = new AccountList(root);
        add(accountList);
        accountList.setBounds(336, 24, 600, 528);
    }
}
