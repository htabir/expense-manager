package Components;

import Assets.Styles;
import Elements.ImagePanel;

import javax.swing.*;

public class AccountCard extends JPanel {
    private String[] icons = {"cash.png", "bank.png", "mobile.png"};
    private String[] titles = {"Cash", "Bank", "Mobile Banking"};

    public AccountCard(int type){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.white);

        JLabel amount = new JLabel("5458");
        styles.labelStyling(amount, styles.typo, styles.SEMIBOLD, 32);
        add(amount);
        amount.setBounds(16, 8, 180, 40);

        JLabel title = new JLabel(titles[type%3]);
        styles.labelStyling(title, styles.muted, styles.LIGHT, 16);
        add(title);
        title.setBounds(16, 48, 180, 20);

        String path = "D:\\kodes\\Java\\New folder\\ExpenseManager\\src\\Assets\\image\\" + icons[type%3];
        ImagePanel icon = new ImagePanel(path, 64, 64);
        add(icon);
        icon.setBounds(212, 8, 64, 64);
    }
}
