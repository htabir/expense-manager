package Components.Analytics;

import Assets.Styles;
import Elements.ComboInput;

import javax.swing.*;

public class SideCard extends JPanel {
    public ComboInput filters;
    public JButton expense, income;
    public SideCard(){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.white);

        JLabel header = new JLabel("Analytics");
        styles.labelStyling(header, styles.typo, styles.MEDIUM, 32);
        add(header);
        header.setBounds(16, 8, 256, 40);

        String[] options = {"Today", "Last one Week", "Last Month", "Last Year"};
        filters = new ComboInput(options);
        filters.setWidth(256);
        filters.removeLevel();
        add(filters);
        filters.setBounds(16, 48);

        JLabel filter = new JLabel("Filters");
        styles.labelStyling(filter, styles.muted, styles.LIGHT, 16);
        add(filter);
        filter.setBounds(16, 144, 256, 20);

        expense = new JButton("Expense");
        styles.transparentButton(expense, styles.typo, styles.LIGHT, 16);
        add(expense);
        expense.setBounds(0, 182, 308, 20);

        income = new JButton("Income");
        styles.transparentButton(income, styles.typo, styles.LIGHT, 16);
        add(income);
        income.setBounds(0, 222, 308, 20);

    }
}
