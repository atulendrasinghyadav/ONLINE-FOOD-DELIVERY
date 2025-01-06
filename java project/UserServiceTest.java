import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    @Test
    public void testRegisterUser() {
        UserService service = new UserService();
        service.registerUser("John Doe", "john@example.com");
        User user = service.getUserProfile("john@example.com");
        assertEquals("John Doe", user.getName());
    }
}
