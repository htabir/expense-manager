package Pages;

import Assets.Styles;
import Cache.Root;
import Components.Records.RecordForm;
import Components.Records.RecordList;
import Components.Records.SideCard;
import Controller.RecordsController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Records extends JPanel {
    SideCard sideCard;
    RecordList recordList;
    RecordForm recordForm;
    Records parent;

    public Records(Root root) {
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.background);
        setSize(960, 576);
        parent = this;

        new RecordsController(root);

        sideCard = new SideCard();
        add(sideCard);
        sideCard.setBounds(24, 24, 288, 266);

        recordList = new RecordList(root);
        add(recordList);
        recordList.setBounds(336, 24, 600, 528);

        initActionListener(sideCard, root);

        if (root.records.state == 0) {
            root.records.state = 1;
            sideCard.add.doClick();
        }
    }

    public void initActionListener(SideCard sideCard, Root root) {
        sideCard.add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sideCard.setVisible(false);
                recordList.setVisible(false);
                recordForm = new RecordForm(root);
                parent.add(recordForm);
                recordForm.setBounds(180, 20, 600, 520);

//                accountForm.addAccount.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        root.accounts.param = "*";
//                        if(accountForm.addNewAccount(root)){
//                            parent.remove(accountForm);
//                            sideCard.setVisible(true);
//                            parent.refresh(root);
//                        }
//                    }
//                });

                recordForm.back.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        super.mousePressed(e);
                        parent.remove(recordForm);
                        sideCard.setVisible(true);
                        parent.refresh(root);
                    }
                });
            }
        });
    }

    public void refresh(Root root) {
        new RecordsController(root);
        parent.remove(recordList);
        recordList = new RecordList(root);
        add(recordList);
        recordList.setBounds(336, 24, 600, 528);
        parent.revalidate();
        parent.repaint();
    }
}
