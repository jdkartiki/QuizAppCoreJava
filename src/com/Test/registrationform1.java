package com.Test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class registrationform1 extends JFrame implements ActionListener {
    private JTextField usernameField, emailField, addressField;
    private JPasswordField passwordField;
    private JButton registerButton, displayButton, updateButton, deleteButton;

    // Define a simple data structure to store user information
    private List<User> userList;

    public registrationform1() {
        setTitle("Registration Form");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the user list
        userList = new ArrayList<>();

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 128));
        panel.setLayout(new GridLayout(6, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        usernameField.setBackground(new Color(255, 255, 128));
        panel.add(usernameLabel);
        panel.add(usernameField);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        emailField.setBackground(new Color(255, 255, 128));
        panel.add(emailLabel);
        panel.add(emailField);

        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField();
        addressField.setBackground(new Color(255, 255, 128));
        panel.add(addressLabel);
        panel.add(addressField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        passwordField.setBackground(new Color(255, 255, 128));
        panel.add(passwordLabel);
        panel.add(passwordField);

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        panel.add(registerButton);

        displayButton = new JButton("Display Users");
        displayButton.addActionListener(this);
        panel.add(displayButton);

        updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        panel.add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        panel.add(deleteButton);

        getContentPane().add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String username = usernameField.getText();
            String email = emailField.getText();
            String address = addressField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);

            // Create a new user
            User newUser = new User(username, email, address, password);
            userList.add(newUser);

            JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

            clearFields();
        } else if (e.getSource() == displayButton) {
            // Display all users
            StringBuilder usersInfo = new StringBuilder();
            for (User user : userList) {
                usersInfo.append(user.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(this, usersInfo.toString(), "Users", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == updateButton) {
            // Update user information
            String usernameToUpdate = usernameField.getText();
            Optional<User> optionalUser = userList.stream()
                    .filter(user -> user.getUsername().equals(usernameToUpdate))
                    .findFirst();

            if (optionalUser.isPresent()) {
                User userToUpdate = optionalUser.get();
                userToUpdate.setEmail(emailField.getText());
                userToUpdate.setAddress(addressField.getText());
                userToUpdate.setPassword(new String(passwordField.getPassword()));
                JOptionPane.showMessageDialog(this, "User information updated!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            clearFields();
        } else if (e.getSource() == deleteButton) {
            // Delete user
            String usernameToDelete = usernameField.getText();
            Optional<User> optionalUser = userList.stream()
                    .filter(user -> user.getUsername().equals(usernameToDelete))
                    .findFirst();

            if (optionalUser.isPresent()) {
                userList.remove(optionalUser.get());
                JOptionPane.showMessageDialog(this, "User deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            clearFields();
        }
    }

    private void clearFields() {
        usernameField.setText("");
        emailField.setText("");
        addressField.setText("");
        passwordField.setText("");
    }

    // Simple User class to hold user information
    private static class User {
        private String username;
        private String email;
        private String address;
        private String password;

        public User(String username, String email, String address, String password) {
            this.username = username;
            this.email = email;
            this.address = address;
            this.password = password;
        }

        // Getters and Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "Username: " + username + ", Email: " + email + ", Address: " + address;
        }
    }

    public static void main(String[] args) {
        new registrationform1();
    }
}
