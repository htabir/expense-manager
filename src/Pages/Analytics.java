package Pages;

import Assets.Styles;
import Cache.Root;
import Components.Analytics.SideCard;

import javax.swing.*;

public class Analytics extends JPanel {
    public Analytics parent;
    public SideCard sideCard;
    public Analytics(Root root){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.background);
        setSize(960, 576);
        parent = this;

        sideCard = new SideCard();
        add(sideCard);
        sideCard.setBounds(24, 24, 288, 266);
    }
}
