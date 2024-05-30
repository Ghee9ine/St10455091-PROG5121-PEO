/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package registration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.Test;

/**
 *
 * @author lab_services_student
 */
public class RegistrationTest {
    
    public RegistrationTest() {
        assertTrue(Registration.checkUserName("user_"));
        assertTrue(Registration.checkUserName("usr1"));
        assertTrue(Registration.checkUserName("us3r_"));
    }

    @Test
    public void testCheckUserName() {
        assertFalse(Registration.checkUserName("user@"));
        assertFalse(Registration.checkUserName("username"));
        assertFalse(Registration.checkUserName("usr"));
        assertFalse(Registration.checkUserName("usr__"));
    }

    @Test
    public void testCheckPasswordComplexity() {
        assertTrue(Registration.checkPasswordComplexity("Password1!"));
        assertTrue(Registration.checkPasswordComplexity("Complex#2"));
        assertTrue(Registration.checkPasswordComplexity("ValidPass3$"));
    }

    @Test
    public void testRegisterUser() {
        String result = Registration.registerUser("John", "Doe", "user1", "Password1!");
        assertEquals("Registration successful", result);
    }
    
}
