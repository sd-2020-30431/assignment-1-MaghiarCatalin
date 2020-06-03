package client_server.view.common;

import client_server.view.user.UserSigninView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView {
    private JFrame jFrame;
    private JButton login;
    private JPanel homePanel;
    private JButton signin;



    public HomeView() {

    }

    public void start(){
        this.jFrame= new JFrame("Main Page");
        jFrame.setContentPane(homePanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        initializeButtons();


    }

    private void initializeButtons() {
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginMethod();
                jFrame.setVisible(false);
            }
        });
        signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signinMethod();
                jFrame.setVisible(false);
            }
        });
    }

    private void signinMethod() {
        UserSigninView userSigninView = new UserSigninView();
        userSigninView.start();
    }

    private void loginMethod() {
        LoginView loginView = new LoginView();
        loginView.start();
    }
}
