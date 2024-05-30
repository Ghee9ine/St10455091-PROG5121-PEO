/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Registration;


     

import javax.swing.JOptionPane;                                
import java.util.regex.Matcher;                                                           
import java.util.regex.Pattern;

class Registration {
    
    public static boolean checkUserName(String username) {
        // Check if username contains an underscore and is no more than 5 characters long
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]{1,5}$");
        Matcher matcher = pattern.matcher(username);
        if (matcher.matches()) {
            JOptionPane.showMessageDialog(null, "Username successfully captured");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
            return false;
        }
    }

    public static boolean checkPasswordComplexity(String password) {
        // Check if password meets complexity rules
        if (password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\d.*") && // Updated from ".*//d.*"
                password.matches(".*[!@#$%^&()\\-_=+{};:,<.>].*")) {
 
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Password Successfully Captured.");
            return true;
        }
    }

    public static String registerUser() {
        String name = JOptionPane.showInputDialog("Enter your name:");
        String surname = JOptionPane.showInputDialog("Enter your surname:");
        String username = JOptionPane.showInputDialog("Enter your username:");
        if (username == null || !checkUserName(username)) {
        return "Registration failed: Invalid username format";
        }

        String password = JOptionPane.showInputDialog("Enter your password:");
        if (password == null || !checkPasswordComplexity(password)) {
            return "Registration failed: Password does not meet complexity requirements";
        }

        // store username and password in database or file
        return "Registration successful";
    }
}