/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registration;

/**
 *
 * @author lab_services_student
 */
                                
import javax.swing.JOptionPane;

public class Login {

    public static boolean loginUser() {
        String name = JOptionPane.showInputDialog("Enter your name:");
        if (name == null) {
            return false;
        }
        String surname = JOptionPane.showInputDialog("Enter your surname:");
        if (surname == null) {
            return false;
        }   
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
            JOptionPane.showMessageDialog(null, "Welcome " + name + ", " + surname + ". It is great to see you again.");
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again");
        }
        return loginSuccessful;
        
    }

    public static String returnLoginStatus(boolean loginSuccessful) {
        if (loginSuccessful) {
            return "Login successful";
        } else {
            return "Login failed: Invalid username or password";
        }
    }

    public static void main(String[] args) {
        boolean loginSuccessful = loginUser();
        JOptionPane.showMessageDialog(null, returnLoginStatus(loginSuccessful));
    }
}