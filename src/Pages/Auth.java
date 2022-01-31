package Pages;

import Assets.Styles;
import Cache.Root;
import Components.Login;
import Components.Register;
import Elements.Frame;
import Elements.ImagePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Auth {
    public Login loginPanel;
    public Register registerPanel;
    private Frame frame;
    private JButton login_signin;
    private int state;

    public Auth(Root root) {
        frame = new Frame();
        state = 1;
        Styles styles = new Styles();


        // Login

        loginPanel = new Login(root);
        loginPanel.setBounds(597, 80, 326, 460);
        frame.add(loginPanel);

        // register

        registerPanel = new Register(root);


        // Left Card Background
        ImagePanel img = new ImagePanel("D:\\kodes\\Java\\New folder\\ExpenseManager\\src\\Assets\\image\\auth.png", 560, 640);
        img.setBounds(0, 0, 560, 640);
        frame.add(img);

        login_signin = new JButton("Create an Account");
        styles.transparentButton(login_signin, styles.muted, styles.LIGHT, 14);
        login_signin.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(login_signin);
        login_signin.setBounds(597, 588, 326, 20);


        initActionListener(root);

        frame.makeDraggable();
        frame.setVisible(true);
    }

    public void initActionListener(Root root) {

        login_signin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (state == 1) {
                    login_signin.setText("<html><u>Create an Account</u></html>");
                } else {
                    login_signin.setText("<html><u>Already Have an Account? Login</u></html>");
                }

            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (state == 1) {
                    login_signin.setText("Create an Account");
                } else {
                    login_signin.setText("Already Have an Account? Login");
                }
            }
        });

        login_signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (state == 1) {
                    frame.remove(loginPanel);
                    registerPanel = new Register(root);
                    registerPanel.setBounds(597, 80, 326, 528);
                    frame.add(registerPanel);

                    registerPanel.sign_in.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("here");
                            registerPanel.tryRegister(root);
                            if (root.user.isAuthenticated()) {
                                new Base(root);
                                frame.dispose();
                            } else {
                                loginPanel.setDanger();
                            }
                        }
                    });

                    login_signin.setText("Already Have an Account? Login");
                } else {
                    frame.remove(registerPanel);
                    loginPanel = new Login(root);
                    loginPanel.setBounds(597, 80, 326, 528);
                    frame.add(loginPanel);
                    login_signin.setText("Create an Account");
                }
                state = (state + 1) % 2;
                frame.revalidate();
                frame.repaint();
            }
        });

        loginPanel.login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPanel.tryLogin(root);
                if (root.user.isAuthenticated()) {
                    new Base(root);
                    frame.dispose();
                } else {
                    loginPanel.setDanger();
                }
            }
        });
    }
}
