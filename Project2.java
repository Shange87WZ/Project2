/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class POE2 {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        LoginRegistration app = new LoginRegistration();
        app.run();
    }
}

class LoginRegistration {
    private boolean loginValid = false;
    private final ArrayList<Task> tasks = new ArrayList<>();

    public void run() {
        while (true) {
            String choice = JOptionPane.showInputDialog("Option 1) Login\nOption 2) Register\nOption 3) Quit");
            if (choice.equals("1")) {
                login();
                if (loginValid) {
                    taskManagementLoop();
                }
            } else if (choice.equals("2")) {
                registerUser();
            } else if (choice.equals("3")) {
                System.exit(0);
            }
        }
    }

    private void login() {
        // Login with validation
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");

        if (validateUsername(username) && validatePassword(password)) {
            loginValid = true;
            JOptionPane.showMessageDialog(null, "Login successful!");
        } else {
            loginValid = false;
            JOptionPane.showMessageDialog(null, "Login failed. Please check your username and password format.");
        }
    }

    private void registerUser() {
        // Registration simulation
        JOptionPane.showMessageDialog(null, "Registration feature coming soon.");
    }

    private void taskManagementLoop() {
        while (loginValid) {
            String choice = JOptionPane.showInputDialog("""
                Option 1) Add tasks
                Option 2) Show report
                Option 3) Quit
            """);
            switch (choice) {
                case "1" -> addTasks();
                case "2" -> JOptionPane.showMessageDialog(null, "Coming Soon.");
                case "3" -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }

    private void addTasks() {
        int numOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to enter?"));
        for (int i = 0; i < numOfTasks; i++) {
            String name = JOptionPane.showInputDialog("Enter the name of task " + (i + 1));
            String description = JOptionPane.showInputDialog("Enter task description:");
            String developer = JOptionPane.showInputDialog("Enter developer name:");
            int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter duration of task in hours:"));
            String status = JOptionPane.showInputDialog("Enter status (e.g., To Do, In Progress, Done):");

            tasks.add(new Task(name, description, developer, duration, status));
            JOptionPane.showMessageDialog(null, "Task added: " + name);
        }
    }

    private boolean validateUsername(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return false;
        }
    }

    private boolean validatePassword(String password) {
        // Regex to check password complexity
        String passwordPattern = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        if (Pattern.matches(passwordPattern, password)) {
            JOptionPane.showMessageDialog(null, "Password successfully captured");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            return false;
        }
    }
}

class Task {
    private final String name;
    private final String description;
    private final String developer;
    private final int duration;
    private final String status;

    public Task(String name, String description, String developer, int duration, String status) {
        this.name = name;
        this.description = description;
        this.developer = developer;
        this.duration = duration;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", developer='" + developer + '\'' +
                ", duration=" + duration +
                ", status='" + status + '\'' +
                '}';
    }
}
