package Components.Dashboard;

import Assets.Styles;
import Cache.Root;
import Elements.BarChart;
import Elements.Line;

import javax.swing.*;

public class CashFlowCard extends JPanel {
    public CashFlowCard(Root root) {
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.white);

        int r_income = root.dash.income;
        int r_expense = root.dash.expense;

        JLabel header = new JLabel("Cash Flow");
        styles.labelStyling(header, styles.typo, styles.REGULAR, 16);
        add(header);
        header.setBounds(16, 8, 412, 20);

        Line line = new Line(412);
        add(line);
        line.setBounds(16, 36, 412, 1);

        JLabel label1 = new JLabel("Last 30 Days");
        styles.labelStyling(label1, styles.muted, styles.LIGHT, 16);
        add(label1);
        label1.setBounds(16, 48, 206, 20);

        JLabel label2 = new JLabel("vs Previous Period", SwingConstants.RIGHT);
        styles.labelStyling(label2, styles.muted, styles.LIGHT, 16);
        add(label2);
        label2.setBounds(222, 48, 206, 20);

        JLabel amount = new JLabel(String.valueOf(r_income - r_expense));
        styles.labelStyling(amount, styles.typo, styles.SEMIBOLD, 32);
        add(amount);
        amount.setBounds(16, 72, 206, 40);

        int p = root.dash.income_old - root.dash.expense_old == 0 ? r_income - r_expense : ((r_income - r_expense) / (root.dash.income_old - root.dash.expense_old));

        JLabel percentage = new JLabel((p>0? "+" : "") + String.valueOf(p) + "%", SwingConstants.RIGHT);
        styles.labelStyling(percentage, styles.typo, styles.MEDIUM, 16);
        add(percentage);
        percentage.setBounds(222, 72, 206, 40);

        JLabel label3 = new JLabel("Income");
        styles.labelStyling(label3, styles.muted, styles.LIGHT, 16);
        add(label3);
        label3.setBounds(16, 128, 206, 20);

        JLabel income = new JLabel(String.valueOf(r_income), SwingConstants.RIGHT);
        styles.labelStyling(income, styles.typo, styles.REGULAR, 16);
        add(income);
        income.setBounds(222, 128, 206, 20);


        BarChart incomeChart = new BarChart(412, styles.green, (r_income==0 && r_expense==0) ? 0 : r_income > r_expense ? 1 : (r_expense == 0 ? r_income : r_income / r_expense));
        add(incomeChart);
        incomeChart.setBounds(16, 156, 412, 32);

        JLabel label4 = new JLabel("Expense");
        styles.labelStyling(label4, styles.muted, styles.LIGHT, 16);
        add(label4);
        label4.setBounds(16, 204, 206, 20);

        JLabel expense = new JLabel(String.valueOf(r_expense), SwingConstants.RIGHT);
        styles.labelStyling(expense, styles.typo, styles.REGULAR, 16);
        add(expense);
        expense.setBounds(222, 204, 206, 20);

        BarChart expenseChart = new BarChart(412, styles.red, (r_income==0 && r_expense==0) ? 0 : r_income > r_expense ? (float) r_expense / r_income : 1);
        add(expenseChart);
        expenseChart.setBounds(16, 232, 412, 32);

    }
}
