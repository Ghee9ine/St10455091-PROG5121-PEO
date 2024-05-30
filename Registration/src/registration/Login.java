/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registration;

import javax.swing.JOptionPane;

/**
 *
 * @author lab_services_student
 */
public class Login {
    String name = JOptionPane.showInputDialog("Enter your name:");
    String surname = JOptionPane.showInputDialog("Enter your surname:");
    

    public static boolean loginUser() {
        String username = JOptionPane.showInputDialog("Enter your username:");
        if (username == null) {
            return false;
        }

        String password = JOptionPane.showInputDialog("Enter your password:");
        if (password == null) {
            return false;
        }

        boolean loginSuccessful = Registration.checkUserName(username) && Registration.checkPasswordComplexity(password);
        if (loginSuccessful) {
              JOptionPane.showMessageDialog(null, "Welcome back, " + username + " It is great to see you again.");
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again");
            return false;
        }
    }

    public static void addTask() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks you want to add:"));
        int totalHours = 0;

        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            String taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
            while (taskDescription.length() > 50) {
                taskDescription = JOptionPane.showInputDialog("Please enter a task description of less than 50 characters:");
            }
            String developer = JOptionPane.showInputDialog("Enter developer details:");
            int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));
            totalHours += duration;
            String taskID = createTaskID(taskName, i, developer);
            String taskStatus = JOptionPane.showInputDialog("Enter task status (To Do, Done, Doing):");

            String taskDetails = printTaskDetails(taskStatus, developer, i, taskName, taskDescription, taskID, duration);
            JOptionPane.showMessageDialog(null, taskDetails);
        }

        JOptionPane.showMessageDialog(null, "Total hours for all tasks: " + totalHours);
    }

    public static String createTaskID(String taskName, int taskNumber, String developer) {
        String firstTwoLetters = taskName.substring(0, 2);
        String lastThreeLetters = developer.substring(developer.length() - 3);
        return firstTwoLetters.toUpperCase() + ":" + taskNumber + ":" + lastThreeLetters.toUpperCase();
    }

    public static String printTaskDetails(String taskStatus, String developer, int taskNumber, String taskName, String taskDescription, String taskID, int duration) {
        return "Task Status: " + taskStatus + "\nDeveloper Details: " + developer +
                "\nTask Number: " + taskNumber + "\nTask Name: " + taskName +
                "\nTask Description: " + taskDescription + "\nTask ID: " + taskID +
                "\nDuration: " + duration;
    }

    public static int returnTotalHours() {
        // This method should return the total combined hours of all entered tasks
        return 0;
    }

    public static void main(String[] args) {
        String registrationStatus = Registration.registerUser();
        JOptionPane.showMessageDialog(null, registrationStatus);

        boolean loginSuccessful = loginUser();
        if (loginSuccessful) {
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban.");
            boolean exit = false;
            while (!exit) {
                int choice = Integer.parseInt(JOptionPane.showInputDialog("Choose an option:\n1 - Add task\n2 - Show report (Coming soon...)\n3 - Quit"));
                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Coming soon...");
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice, please try again.");
                }
            }
        }
    }
}