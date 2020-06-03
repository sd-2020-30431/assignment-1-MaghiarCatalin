package client_server.view.user;

import client_server.controller.UserController;
import client_server.model.UserRole;
import client_server.view.common.HomeView;
import client_server.data.user.UserData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserSigninView {
    private JFrame jFrame;
    private JPanel panel1;
    private JButton signInButton;
    private JButton backButton;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField phoneNumberTextField;
    private JTextField eMailTextField;
    private JPasswordField repeatPasswordPasswordField;
    private JPasswordField passwordField1;

    public UserSigninView() {
    }

    public void start() {
        this.jFrame = new JFrame("Sign in");
        jFrame.setContentPane(panel1);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        initializeButtons();

    }

    private void initializeButtons() {

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signinMethod();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backMethod();
            }
        });
    }

    private void signinMethod() {
        UserData userData = new UserData();
        if (firstNameTextField.getText() == null || lastNameTextField.getText() == null || eMailTextField.getText() == null || passwordField1.getText() == null || repeatPasswordPasswordField.getText() == null || phoneNumberTextField.getText() == null || !passwordField1.getText().equals(repeatPasswordPasswordField.getText())) {
            JOptionPane.showMessageDialog(null, "The user cannot be created! Wrong input format");
            backMethod();
        } else {
            userData.setUserItemDataList(null);
            userData.setEmail(eMailTextField.getText());
            userData.setFirstName(firstNameTextField.getText());
            userData.setLastName(lastNameTextField.getText());
            userData.setPassword(passwordField1.getText());
            userData.setPhoneNumber(phoneNumberTextField.getText());
            userData.setRole(UserRole.CUSTOMER);
            new UserController().insert(userData);
            JOptionPane.showMessageDialog(null, "User successful created!");
            backMethod();
        }

    }

    private void backMethod() {
        jFrame.setVisible(false);
        HomeView homeView = new HomeView();
        homeView.start();
    }
}