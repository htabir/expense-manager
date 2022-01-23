package Pages;

import Cache.Root;
import Components.Navbar;
import Elements.Frame;

public class Base {
    public Base(Root root) {
        Frame frame = new Frame();

        Navbar navbar = new Navbar(root);
        frame.add(navbar);
        navbar.setBounds(0, 0, 960, 60);

        Dashboard dashboard = new Dashboard(root);
        frame.add(dashboard);
        dashboard.setBounds(0, 64, 960, 576);

        frame.makeDraggable();
        frame.setVisible(true);
    }
}
