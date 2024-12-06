import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoginManagerTest {

    //Que 3

    private AuthenticationService authenticationServiceMock;
    private LoginManager loginManager;

    @BeforeEach
    void setUp() {
        authenticationServiceMock = mock(AuthenticationService.class);
        loginManager = new LoginManager(authenticationServiceMock);
    }

    @Test
    @DisplayName("Valid name & pass")
    void testLogin_ValidCredentials() throws Exception {
        String validUsername = "niha_zafar";
        String validPassword = "244444";

        when(authenticationServiceMock.authenticate(validUsername, validPassword)).thenReturn(true);

        boolean result = loginManager.login(validUsername, validPassword);

        assertTrue(result, "Login should succeed for valid credentials");
        verify(authenticationServiceMock).authenticate(validUsername, validPassword);
    }

    @Test
    @DisplayName("Invalid name & pass")
    void testLogin_InvalidCredentials() throws Exception {
        
        String invalidUsername = "Niha$zafar";
        String invalidPassword = "******";

        when(authenticationServiceMock.authenticate(invalidUsername, invalidPassword)).thenReturn(false);

        boolean result = loginManager.login(invalidUsername, invalidPassword);

        assertFalse(result, "Login should fail for invalid credentials");
        verify(authenticationServiceMock).authenticate(invalidUsername, invalidPassword);
    }

    @Test
    void testLogin_NullUsernameOrPassword() {
        Exception exception1 = assertThrows(Exception.class,
                () -> loginManager.login(null, "password"),
                "Expected an exception when username is null");
        assertEquals("Username and password cannot be null", exception1.getMessage());

        Exception exception2 = assertThrows(Exception.class,
                () -> loginManager.login("username", null),
                "Expected an exception when password is null");
        assertEquals("Username and password cannot be null", exception2.getMessage());
    }
}
