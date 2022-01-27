package Pages;

import Assets.Styles;
import Cache.Root;
import Components.Records.RecordList;
import Components.Records.SideCard;
import Controller.RecordsController;

import javax.swing.*;

public class Records extends JPanel {
    SideCard sideCard;
    RecordList recordList;
    public Records(Root root){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.background);
        setSize(960, 576);

        new RecordsController(root);

        sideCard = new SideCard();
        recordList = new RecordList(root);


        if(root.records.state==1){
            add(sideCard);
            sideCard.setBounds(24, 24, 288, 266);

            add(recordList);
            recordList.setBounds(336, 24, 600, 528);
        }
    }
}
