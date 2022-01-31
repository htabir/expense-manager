package Components.Analytics;

import Assets.Styles;
import Cache.Root;

import javax.swing.*;
import java.awt.*;

public class AnalyticsList extends JPanel {
    final JScrollPane scroll;
    private Styles styles = new Styles();
    private JPanel list;

    public AnalyticsList(Root root) {
        setLayout(new BorderLayout());

        list = makeList(root);

        if (root.analytics.total == 0) {
            JPanel emptyPanel = makeEmptyPanel();
            list.add(emptyPanel);
            emptyPanel.setBounds(0, 0, 600, 48);
        }

        scroll = new JScrollPane(list, 22, 31);
        add(scroll, BorderLayout.CENTER);
        setSize(600, 528);

        styles.styleScrollPane(scroll);
    }

    private JPanel makeList(Root root) {
        int pos = 0;
        int total_height = 0;
        int count = 0;
        root.analytics.total = 0;

        final JPanel list = new JPanel();
        list.setLayout(null);
        list.setBackground(styles.background);


        try {
            while (root.analytics.list.next()) {
                AnalyticsItem item = new AnalyticsItem(root.analytics.list.getString(1), root.analytics.list.getString(2), root.analytics.list.getString(3));
                list.add(item);
                item.setBounds(0, pos, 600, 48);
                pos += (48 + 16);
                total_height = (count * 16) + ((count + 1) * 48);
                count++;
                root.analytics.total++;
            }
        } catch (Exception e) {

        }

        list.setPreferredSize(new Dimension(600, 528 > total_height ? 528 : total_height));

        return list;
    }

    class AnalyticsItem extends JPanel {
        AnalyticsItem(String cat, String typ, String amnt) {
            Styles styles = new Styles();
            setLayout(null);
            setBackground(styles.white);

            JLabel title = new JLabel(cat);
            add(title);
            styles.labelStyling(title, styles.typo, styles.LIGHT, 16);
            title.setBounds(24, 14, 205, 20);

            JLabel amount;
            if (typ.contains("expense")) {
                amount = new JLabel("- " + amnt, SwingConstants.RIGHT);
                styles.labelStyling(amount, styles.red, styles.LIGHT, 16);
            } else if (typ.contains("income") && (Integer.parseInt(amnt) != 0)) {
                amount = new JLabel("+ " + amnt, SwingConstants.RIGHT);
                styles.labelStyling(amount, styles.green, styles.LIGHT, 16);
            } else {
                amount = new JLabel(amnt, SwingConstants.RIGHT);
                styles.labelStyling(amount, styles.typo, styles.LIGHT, 16);
            }

            add(amount);
            amount.setBounds(448, 14, 152 - 24, 20);
        }
    }

    public JPanel makeEmptyPanel() {
        JPanel emptyPanel = new JPanel();
        emptyPanel.setLayout(null);
        JLabel message = new JLabel("Nothing to show!!", SwingConstants.CENTER);
        styles.labelStyling(message, styles.typo, styles.REGULAR, 16);
        message.setBounds(24, 14, 552, 20);
        emptyPanel.add(message);
        emptyPanel.setBackground(styles.background);

        return emptyPanel;
    }
}
