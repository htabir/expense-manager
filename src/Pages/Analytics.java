package Pages;

import Assets.Styles;
import Cache.Root;
import Components.Analytics.AnalyticsList;
import Components.Analytics.SideCard;
import Controller.AnalyticsController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Analytics extends JPanel {
    public Analytics parent;
    public SideCard sideCard;
    public AnalyticsList analyticsList;
    public Analytics(Root root){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.background);
        setSize(960, 576);
        parent = this;

        root.analytics = new Cache.Analytics();
        new AnalyticsController(root);

        sideCard = new SideCard();
        add(sideCard);
        sideCard.setBounds(24, 24, 288, 266);

        analyticsList = new AnalyticsList(root);
        add(analyticsList);
        analyticsList.setBounds(336, 24, 600, 528);

        initActionListener(sideCard, root);

    }

    private void initActionListener(SideCard sideCard, Root root){
        sideCard.filters.comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] days = {1, 7, 30, 365};
                root.analytics.period = days[sideCard.filters.getIndex()];
                refresh(root);
            }
        });

        sideCard.expense.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                root.analytics.param = "expense";
                refresh(root);
            }
        });

        sideCard.income.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                root.analytics.param = "income";
                refresh(root);
            }
        });
    }

    public void refresh(Root root) {
        new AnalyticsController(root);
        parent.remove(analyticsList);
        analyticsList = new AnalyticsList(root);
        add(analyticsList);
        analyticsList.setBounds(336, 24, 600, 528);
        parent.revalidate();
        parent.repaint();
    }
}
