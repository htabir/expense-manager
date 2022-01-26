package Components.Accounts;

import Assets.Styles;
import Cache.Root;

import javax.swing.*;
import java.awt.*;

public class AccountList extends JPanel {
    public AccountList(Root root){
        Styles styles = new Styles();
        setLayout(new BorderLayout());
        int pos = 0;
        int total_height = 0;
        int count = 0;

        final JPanel list = new JPanel();
        list.setLayout(null);
        list.setBackground(styles.background);


        try{
            while(root.accounts.list.next()){
                AccountItem item = new AccountItem(
                        root.accounts.list.getString(3),
                        root.accounts.list.getString(4),
                        root.accounts.list.getString(5)
                );
                list.add(item);
                item.setBounds(0, pos, 600, 48);
                pos += (48+16);
                total_height = (count * 16) + ((count + 1) * 48);
                count++;
            }
        } catch (Exception e) {

        }

        list.setPreferredSize(new Dimension(600, 528 > total_height ? 528 : total_height));

        final JScrollPane scroll = new JScrollPane(list, 22, 31);
        add(scroll, BorderLayout.CENTER);
        setSize(600, 528);

        styles.styleScrollPane(scroll);
    }

    class AccountItem extends JPanel{
        AccountItem(String ttl, String cat, String amnt){
            Styles styles = new Styles();
            setLayout(null);
            setBackground(styles.white);

            JLabel title = new JLabel(ttl);
            add(title);
            styles.labelStyling(title, styles.typo, styles.LIGHT, 16);
            title.setBounds(24, 14, 229, 20);

            String temp;
            if(cat.contains("cash")){
                temp = "Cash";
            }else if(cat.contains("bank")){
                temp = "Bank";
            }else{
                temp = "Mobile Banking";
            }

            JLabel category = new JLabel(temp);
            add(category);
            styles.labelStyling(category, styles.muted, styles.LIGHT, 16);
            category.setBounds(277, 14, 155, 20);

            JLabel amount = new JLabel(amnt);
            add(amount);
            styles.labelStyling(amount, styles.typo, styles.LIGHT, 16);
            amount.setBounds(448, 14, 128, 20);
        }
    }
}
