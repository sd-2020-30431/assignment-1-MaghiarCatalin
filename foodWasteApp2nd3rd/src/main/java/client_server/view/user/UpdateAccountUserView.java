package client_server.view.user;

import client_server.controller.UserController;
import client_server.data.user.UserData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateAccountUserView {
    private JPanel panel1;
    private JFrame jFrame;
    private JButton updateButton;
    private JButton backButton;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField phoneNumberTextField;
    private String email;
    private UserData userdata;

    public UpdateAccountUserView(String email) {
        this.email = email;
        userdata = new UserController().getByEmail(email);
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
        firstNameTextField.setText(userdata.getFirstName());
        lastNameTextField.setText(userdata.getLastName());
        phoneNumberTextField.setText(userdata.getPhoneNumber());

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateButtonMethod();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backMethod();
            }
        });
    }

    private void updateButtonMethod() {
        UserData userData1 = new UserData();
        userData1.setEmail(userdata.getEmail());
        userData1.setRole(userdata.getRole());
        userData1.setPassword(userdata.getPassword());
        userData1.setUserItemDataList(userdata.getUserItemDataList());
        userData1.setFirstName(firstNameTextField.getText());
        userData1.setLastName(lastNameTextField.getText());
        userData1.setPhoneNumber(phoneNumberTextField.getText());

        new UserController().update(userData1);
        backMethod();

    }

    private void backMethod() {
        jFrame.setVisible(false);
        UserMainPanel userMainPanel = new UserMainPanel(email);
        userMainPanel.start();
    }
}
