package Pages;

import Assets.Styles;
import Cache.Root;
import Components.AccountCard;
import Components.CashFlowCard;
import Components.RecentRecordsCard;

import javax.swing.*;

public class Dashboard extends JPanel {
    public Dashboard(Root root){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.background);
        setSize(960, 576);

        AccountCard card1 = new AccountCard(0);
        add(card1);
        card1.setBounds(24, 24, 288, 80);

        AccountCard card2 = new AccountCard(1);
        add(card2);
        card2.setBounds(336, 24, 288, 80);

        AccountCard card3 = new AccountCard(2);
        add(card3);
        card3.setBounds(648, 24, 288, 80);

        CashFlowCard cashFlowCard = new CashFlowCard();
        add(cashFlowCard);
        cashFlowCard.setBounds(24, 128, 444, 296);

        RecentRecordsCard recentRecordsCard = new RecentRecordsCard();
        add(recentRecordsCard);
        recentRecordsCard.setBounds(492, 128, 444, 296);
    }
}
