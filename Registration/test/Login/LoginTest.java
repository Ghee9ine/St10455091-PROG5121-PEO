/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Login;

import registration.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.Test;

/**
 *
 * @author lab_services_student
 */
public class LoginTest {
    
    public LoginTest() {
        // Mock user input
        MockInput.setMockInput("kyl_1", "Ch&&sec@ke99!");

        // Call loginUser method
        boolean result = Login.loginUser();

        // Check if login was successful
        assertEquals(result);
    }


    @Test
    public void testReturnLoginStatus() {
        // Call returnLoginStatus method with true (indicating successful login)
        String result = Login.returnLoginStatus(true);

        // Check if the returned status message is correct
        assertEquals("Login successful", result);
    }

    @Test
    public void testMain() {
        // Mock user input
        MockInput.setMockInput(null, "Ch&&sec@ke99!");

        // Call loginUser method
        boolean result = Login.loginUser();

        // Check if login failed due to null username
        assertFalse(result);
    }
    @Test
    public void testAddTask() {
        // Test data
        String[] inputs = {
            "1", // Number of tasks
            "Add Task Feature", // Task name
            "Create Add Task feature to add task users", // Task description
            "Mike Smith", // Developer details
            "10", // Task duration
            "Doing" // Task status
             
        };
         // Prepare mocked inputs
        when(JOptionPane.showInputDialog(anyString()))
                .thenReturn(inputs[0], inputs[1], inputs[2], inputs[3], inputs[4], inputs[5]);

        // Mock JOptionPane.showMessageDialog to do nothing
        doNothing().when(JOptionPane.class);
        JOptionPane.showMessageDialog(any(), anyString());

        // Call the method to test
        Login.addTask();

        // Verify that showInputDialog was called the correct number of times
        verify(JOptionPane, times(6)).showInputDialog(anyString());

        // Verify the correct task details are shown
        String expectedTaskID = "AD:0:TH";
        String expectedTaskDetails = "Task Status: Doing\nDeveloper Details: Mike Smith\nTask Number: 0\nTask Name: Add Task Feature\nTask Description: Create Add Task feature to add task users\nTask ID: AD:0:TH\nDuration: 10";

        verify(JOptionPane).showMessageDialog(null, expectedTaskDetails);
        verify(JOptionPane).showMessageDialog(null, "Total hours for all tasks: 10");
    }
}
    