package Components.Dashboard;

import Assets.Styles;
import Cache.Root;

import javax.swing.*;

public class RecordList extends JPanel {
    Styles styles;

    public RecordList(Root root) {
        styles = new Styles();
        setLayout(null);
        setBackground(styles.white);
        int count = 0;
        try {
            while(root.dash.recordSet.next()){
                RecordItem recordItem = new RecordItem(count, root.dash.recordSet.getString(1), root.dash.recordSet.getString(3), root.dash.recordSet.getString(4));
                add(recordItem);
                recordItem.setBounds(0, count*52, 412, 52);
                count++;
            }
        } catch (Exception e) {

        }

        if(count == 0){
            JPanel emptyPanel = makeEmptyPanel();
            add(emptyPanel);
            emptyPanel.setBounds(0, 0, 412, 52);
        }

    }

    class RecordItem extends JPanel {
        RecordItem(int indx, String cat, String typ, String amnt) {
            Styles styles = new Styles();
            setLayout(null);
            if (indx % 2 == 0) {
                setBackground(styles.white);
            } else {
                setBackground(styles.background);
            }

            JLabel category = new JLabel(cat);
            add(category);
            styles.labelStyling(category, styles.typo, styles.LIGHT, 16);
            category.setBounds(24, 14, 205, 20);


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
            amount.setBounds(268, 16, 128, 20);
        }
    }

    public JPanel makeEmptyPanel() {
        JPanel emptyPanel = new JPanel();
        emptyPanel.setLayout(null);
        JLabel message = new JLabel("Nothing to show!!", SwingConstants.CENTER);
        styles.labelStyling(message, styles.typo, styles.REGULAR, 16);
        message.setBounds(0, 0, 412, 52);
        emptyPanel.add(message);
        emptyPanel.setBackground(styles.white);
        return emptyPanel;
    }
}
