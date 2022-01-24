package Pages;

import Cache.Root;
import Components.Login;
import Elements.Frame;
import Elements.ImagePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Auth {
    public Auth(Root root) {
        Frame frame = new Frame();

        // Login

        Login loginPanel = new Login(root);
        loginPanel.setBounds(597, 80, 326, 528);
        frame.add(loginPanel);
        loginPanel.login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPanel.tryLogin(root);
                if(root.user.isAuthenticated()){
                    new Base(root);
                    frame.dispose();
                }else{
                    loginPanel.setDanger();
                }

            }
        });


        // Left Card Background
        ImagePanel img = new ImagePanel("D:\\kodes\\Java\\New folder\\ExpenseManager\\src\\Assets\\image\\auth.png", 560, 640);
        img.setBounds(0, 0, 560, 640);
        frame.add(img);

        frame.makeDraggable();
        frame.setVisible(true);
    }
}
