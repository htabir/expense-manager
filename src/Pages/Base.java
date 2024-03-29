package Pages;

import Assets.Styles;
import Cache.Root;
import Components.Navbar;
import Elements.Frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Base {
    private int current;

    private Frame frame;
    private Styles styles;
    private Navbar navbar;

    private Dashboard dashboard;
    private Accounts accounts;
    private Records records;
    private Analytics analytics;

    public Base(Root root) {
        frame = new Frame();
        styles = new Styles();
        current = 0;

        navbar = new Navbar(root);
        frame.add(navbar);
        navbar.setBounds(0, 0, 960, 60);

        dashboard = new Dashboard(root);
        frame.add(dashboard);
        dashboard.setBounds(0, 64, 960, 576);

//        analytics = new Analytics(root);
//        frame.add(analytics);
//        analytics.setBounds(0, 64, 960, 576);

        initActionListener(root);

        frame.makeDraggable();
        frame.setVisible(true);
    }

    public void initActionListener(Root root) {
        navbar.dashboard.addActionListener(e -> navigate(0, root));
        navbar.accounts.addActionListener(e -> navigate(1, root));
        navbar.records.addActionListener(e -> navigate(2, root));
        navbar.analytics.addActionListener(e -> navigate(3, root));
        navbar.add_record.addActionListener(e-> navigate(4, root));
        navbar.logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                frame.dispose();
                new Auth(root);
            }
        });
    }


    public void navigate(int state, Root root) {
        if (current == 0) {
            styles.setInactive(navbar.dashboard);
            frame.remove(dashboard);
        } else if (current == 1) {
            styles.setInactive(navbar.accounts);
            frame.remove(accounts);
        } else if (current == 2) {
            styles.setInactive(navbar.records);
            frame.remove(records);
        } else if (current == 3) {
            styles.setInactive(navbar.analytics);
            frame.remove(analytics);
        }

        if (state == 0) {
            styles.setActive(navbar.dashboard);
            dashboard = new Dashboard(root);
            frame.add(dashboard);
            dashboard.setBounds(0, 64, 960, 576);
        } else if (state == 1) {
            styles.setActive(navbar.accounts);
            accounts = new Accounts(root);
            frame.add(accounts);
            accounts.setBounds(0, 64, 960, 576);
        } else if (state == 2) {
            styles.setActive(navbar.records);
            records= new Records(root);
            frame.add(records);
            records.setBounds(0, 64, 960, 576);
        } else if (state == 3) {
            styles.setActive(navbar.analytics);
            analytics = new Analytics(root);
            frame.add(analytics);
            analytics.setBounds(0, 64, 960, 576);
        } else if (state == 4){
            styles.setActive(navbar.records);
            root.records.state = 0;
            records= new Records(root);
            frame.add(records);
            records.setBounds(0, 64, 960, 576);
            state = 2;
        }

        current = state;
    }
}
