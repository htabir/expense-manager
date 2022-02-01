package Pages;

import Assets.Styles;
import Cache.Root;
import Components.Dashboard.AccountCard;
import Components.Dashboard.CashFlowCard;
import Components.Dashboard.RecentRecordsCard;
import Controller.DashboardController;

import javax.swing.*;

public class Dashboard extends JPanel {
    AccountCard card1, card2, card3;
    public Dashboard(Root root){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.background);
        setSize(960, 576);

        new DashboardController(root);

        card1 = new AccountCard(0, root.dash.cash);
        add(card1);
        card1.setBounds(24, 24, 288, 80);

        card2 = new AccountCard(1, root.dash.bank);
        add(card2);
        card2.setBounds(336, 24, 288, 80);

        card3 = new AccountCard(2, root.dash.mobile);
        add(card3);
        card3.setBounds(648, 24, 288, 80);


        CashFlowCard cashFlowCard = new CashFlowCard(root);
        add(cashFlowCard);
        cashFlowCard.setBounds(24, 128, 444, 296);

        RecentRecordsCard recentRecordsCard = new RecentRecordsCard(root);
        add(recentRecordsCard);
        recentRecordsCard.setBounds(492, 128, 444, 296);
    }

}
