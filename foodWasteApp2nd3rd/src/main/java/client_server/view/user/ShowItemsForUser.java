package client_server.view.user;

import client_server.controller.UserController;
import client_server.data.user.UserItemData;
import client_server.view.common.HomeView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

public class ShowItemsForUser {
    private JFrame jFrame;
    private JPanel panel1;
    private JTable itemsTable;
    private JButton backButton;
    private JButton logOutButton;
    private JButton deleteItemButton;
    private JButton addItemButton;
    private int row;
    private String email;
    private List<UserItemData> userItemDataList;

    public ShowItemsForUser(String email) {
        this.email = email;
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
        userItemDataList = new UserController().getByEmail(email).getUserItemDataList();
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
        itemsTable.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent mouseEvent) {
                row = itemsTable.rowAtPoint(mouseEvent.getPoint());
            }
        });

        deleteItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Not implemented yet");
            }
        });

        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Not implemented yet");
            }
        });

    }

    private void createTable() {
        DefaultTableModel model = new DefaultTableModel();
        Vector<String> tableHeader = new Vector<>();
        tableHeader.add("Id");
        tableHeader.add("Name");
        tableHeader.add("Calories");
        tableHeader.add("Quantity");
        tableHeader.add("PurchaseDate");
        tableHeader.add("ExpirationDate");
        tableHeader.add("ConsumptionStatus");
        model.setColumnIdentifiers(tableHeader);

        for (UserItemData userItemData : userItemDataList) {
            Vector<String> dataTable = new Vector<>();
            dataTable.add(userItemData.getItemId().toString());
            dataTable.add(userItemData.getName());
            dataTable.add(userItemData.getQuantity().toString());
            dataTable.add(userItemData.getCalories().toString());
            dataTable.add(userItemData.getPurchaseDate());
            dataTable.add(userItemData.getExpirationDate());
            if(userItemData.isConsumptionStatus()){
                dataTable.add("consumed");
            } else {
                dataTable.add("not consumed");
            }
            model.addRow(dataTable);
        }

        itemsTable.setModel(model);

    }

    private void logoutMethod() {
        jFrame.setVisible(false);
        HomeView homeView = new HomeView();
        homeView.start();
    }

    private void backMethod() {
        jFrame.setVisible(false);
        UserMainPanel userMainPanel = new UserMainPanel(email);
        userMainPanel.start();
    }
}