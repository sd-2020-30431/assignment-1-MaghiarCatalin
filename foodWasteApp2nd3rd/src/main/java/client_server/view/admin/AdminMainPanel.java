package client_server.view.admin;

import client_server.view.common.HomeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainPanel {
    private JFrame jFrame;
    private JPanel panel1;
    private JButton usersButton;
    private JButton logOutButton;
    private JButton requests;
    private JButton documentTypesButton;

    public AdminMainPanel() {
    }

    public void start() {
        this.jFrame = new JFrame("Welcome ADMIN");
        jFrame.setContentPane(panel1);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        initializeButtons();

    }

    private void initializeButtons() {
        usersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usersButtonMethod();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backMethod();
            }
        });
    }

    private void usersButtonMethod() {
        jFrame.setVisible(false);
        ShowUserForAdminView showUserForAdminView = new ShowUserForAdminView();
        showUserForAdminView.start();
    }

    private void backMethod() {
        jFrame.setVisible(false);
        HomeView homeView = new HomeView();
        homeView.start();
    }
}
