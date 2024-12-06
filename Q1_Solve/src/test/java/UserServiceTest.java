import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    //Que 8

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    void findUserById() {

        int userId = 1;
        User expectedUser = new User(userId, "Zafriii");

        when(userRepository.findById(userId)).thenReturn(expectedUser);

        User actualUser = userService.findUserById(userId);

        assertNotNull(actualUser);
        assertEquals(expectedUser.getId(), actualUser.getId());
        assertEquals(expectedUser.getName(), actualUser.getName());

        verify(userRepository, times(1)).findById(userId);
    }
}