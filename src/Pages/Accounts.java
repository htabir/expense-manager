package Pages;

import Assets.Styles;
import Cache.Root;

import javax.swing.*;

public class Accounts extends JPanel {
    public Accounts(Root root){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.background);
        setSize(960, 576);
    }
}
