package client_server.view.common;

import client_server.controller.UserController;
import client_server.model.UserRole;
import client_server.view.admin.AdminMainPanel;
import client_server.view.user.UserMainPanel;
import client_server.view.user.UserSigninView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView {
    private JFrame jFrame;
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton;
    private JButton backButton;
    private JButton signInButton;
    private JPanel loginView;

    public LoginView() {
    }

    public void start() {
        this.jFrame = new JFrame("Main Page");
        jFrame.setContentPane(loginView);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        initializeButtons();


    }

    private void initializeButtons() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginMethod();
            }
        });
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                signInMethod();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backMethod();
            }
        });
    }

    private void loginMethod() {
        String username = this.username.getText();
        String password = this.password.getText();

        UserController userController = new UserController();
        UserRole userRole = userController.checkCredentials(username, password);

        if (userRole == null) {
            backMethod();
            JOptionPane.showMessageDialog(null, "Wrong input!");
        } else {
            if (userRole.equals(UserRole.ADMIN)) {
                AdminMainPanel adminMainPanel = new AdminMainPanel();
                jFrame.setVisible(false);
                adminMainPanel.start();
            } else {
                jFrame.setVisible(false);
                if (userRole.equals(UserRole.CUSTOMER)) {
                    String email = username;
                    UserMainPanel userMainPanel = new UserMainPanel(email);
                    userMainPanel.start();
                }
            }
        }
    }

    private void backMethod() {
        jFrame.setVisible(false);
        HomeView homeView = new HomeView();
        homeView.start();
    }

    private void signInMethod() {
        jFrame.setVisible(false);
        UserSigninView userSigninView = new UserSigninView();
        userSigninView.start();
    }
}
