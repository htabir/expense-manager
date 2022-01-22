package Pages;

import Cache.Root;
import Components.Navbar;
import Elements.Frame;

public class Base {
    public Base(Root root) {
        Frame frame = new Frame();

        Navbar navbar = new Navbar();
        frame.add(navbar);
        navbar.setBounds(0, 0, 960, 60);

        frame.makeDraggable();
        frame.setVisible(true);
    }
}
