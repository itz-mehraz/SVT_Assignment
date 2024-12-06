import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    //Que 1

    private UserService userServiceMock;
    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        userServiceMock = mock(UserService.class);
        userManager = new UserManager(userServiceMock);
    }

    @Test
    @DisplayName("Should return true for a valid username and successful save")
    public void testRegisterUser_ValidUser() {
        String username = "nihazafar";
        String password = "password";

        when(userServiceMock.usernameExists(username)).thenReturn(false);
        when(userServiceMock.saveUser(username, password)).thenReturn(true);

        boolean result = userManager.registerUser(username, password);

        assertTrue(result, "Registration should succeed for a valid username and successful save");
        verify(userServiceMock).usernameExists(username);
        verify(userServiceMock).saveUser(username, password);
    }

    @Test
    @DisplayName("Should return false for an existing username")
    public void testRegisterUser_ExistingUser() {
        String username = "nihazafar";
        String password = "password";

        when(userServiceMock.usernameExists(username)).thenReturn(true);

        boolean result = userManager.registerUser(username, password);

        assertFalse(result, "Registration should fail for an existing username");
        verify(userServiceMock).usernameExists(username);
        verify(userServiceMock, never()).saveUser(anyString(), anyString());
    }

    @Test
    @DisplayName("Should return false if saving user fails")
    public void testRegisterUser_SaveFails() {
        String username = "nihazafar";
        String password = "password";

        when(userServiceMock.usernameExists(username)).thenReturn(false);
        when(userServiceMock.saveUser(username, password)).thenReturn(false);

        boolean result = userManager.registerUser(username, password);

        assertFalse(result, "Registration should fail if saving user fails");
        verify(userServiceMock).usernameExists(username);
        verify(userServiceMock).saveUser(username, password);
    }
}
