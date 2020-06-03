package client_server.view.user;

import client_server.view.common.HomeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMainPanel {
    private JPanel panel1;
    private JFrame jFrame;
    private JButton requestButton;
    private JButton personalItemsButton;
    private JButton updateAccountButton;
    private JButton logOutButton1;
    private final String username;

    public UserMainPanel(String username) {
        this.username = username;
    }

    public void start() {
        this.jFrame = new JFrame("Welcome Customer");
        jFrame.setContentPane(panel1);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        initializeButtons();

    }

    private void initializeButtons() {
        updateAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateButtonMethod();
            }
        });
        personalItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personalItemsButtonMethod();
            }
        });
        logOutButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backMethod();
            }
        });
    }

    private void updateButtonMethod() {
        jFrame.setVisible(false);
        UpdateAccountUserView updateAccountUserView = new UpdateAccountUserView(username);
        updateAccountUserView.start();
    }

    private void personalItemsButtonMethod() {
        jFrame.setVisible(false);
        ShowItemsForUser showHousesForUser = new ShowItemsForUser(username);
        showHousesForUser.start();
    }


    private void backMethod() {
        jFrame.setVisible(false);
        HomeView homeView = new HomeView();
        homeView.start();
    }


}
