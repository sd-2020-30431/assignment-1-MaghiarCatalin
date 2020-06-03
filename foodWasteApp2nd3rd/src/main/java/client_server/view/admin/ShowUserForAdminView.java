package client_server.view.admin;

import client_server.controller.UserController;
import client_server.data.user.UserData;
import client_server.view.common.HomeView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

public class ShowUserForAdminView {

    private JFrame jFrame;
    private JTable userTable;
    private JButton backButton;
    private JButton logOutButton;
    private JPanel panel1;
    private JTextArea textArea1;
    private JButton deleteUserButton;
    private List<UserData> userDataList;
    private int row;

    public ShowUserForAdminView() {
    }

    public void start() {
        this.jFrame = new JFrame("User List");
        jFrame.setContentPane(panel1);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        initializeButtons();

    }

    private void initializeButtons() {
        userDataList = new UserController().listAllUsers();
        createTable();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backMethod();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logoutMethod();
            }
        });
        userTable.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent mouseEvent) {
                row = userTable.rowAtPoint(mouseEvent.getPoint());
                setInfo(row);
            }
        });

        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser();
            }
        });


    }

    private void deleteUser() {
        System.out.println(userDataList.get(row).getEmail());
        new UserController().deleteUser(userDataList.get(row).getEmail());
        jFrame.setVisible(false);
        this.start();
    }

    private void setInfo(int row) {
        userTable.getValueAt(row,1);
        textArea1.setText( new UserController().getInfo(userDataList.get(row)));
    }

    private void createTable() {
        DefaultTableModel model = new DefaultTableModel();
        Vector<String> tableHeader = new Vector<>();
        tableHeader.add("First Name");
        tableHeader.add("Last Name");
        tableHeader.add("E-Mail");
        tableHeader.add("Role");
        model.setColumnIdentifiers(tableHeader);

        for (UserData userData:userDataList ) {
            Vector<String> dataTable = new Vector<>();
            dataTable.add(userData.getFirstName());
            dataTable.add(userData.getLastName());
            dataTable.add(userData.getEmail());
            dataTable.add(userData.getRole().toString());
            model.addRow(dataTable);
        }

        userTable.setModel(model);

    }

    private void logoutMethod() {
        jFrame.setVisible(false);
        HomeView homeView = new HomeView();
        homeView.start();
    }

    private void backMethod(){
        jFrame.setVisible(false);
        AdminMainPanel adminMainPanel = new AdminMainPanel();
        adminMainPanel.start();
    }



}
