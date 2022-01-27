package Components.Records;

import Assets.Styles;

import javax.swing.*;

public class SideCard extends JPanel {
    public JButton add, expense, income;
    public SideCard(){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.white);

        JLabel header = new JLabel("Records");
        styles.labelStyling(header, styles.typo, styles.MEDIUM, 32);
        add(header);
        header.setBounds(16, 8, 256, 40);

        add = new JButton("+ Add Records");
        styles.buttonStyling(add, styles.MEDIUM, 16);
        add(add);
        add.setBounds(16, 72, 256, 40);

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
