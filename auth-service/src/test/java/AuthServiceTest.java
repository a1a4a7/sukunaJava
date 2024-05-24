import com.domain.expansion.auth_service.service.AuthService;

import com.domain.expansion.auth_service.model.LoginRequest;
import com.domain.expansion.auth_service.model.User;
import com.domain.expansion.auth_service.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AuthService authService;

    private String secretKey = "mySecretKey";

    @BeforeEach
    public void setUp() {
        authService = new AuthService(userRepository);
        ReflectionTestUtils.setField(authService, "secretKey", secretKey);
    }

    @Test
    public void testLoginSuccess() {
        User mockUser = new User();
        mockUser.setUsername("user");
        mockUser.setPassword("password");

        when(userRepository.findByUsername("user")).thenReturn(mockUser);

        LoginRequest loginRequest = new LoginRequest("user", "password");
        String token = authService.login(loginRequest);

        assertNotNull(token);
        assertTrue(Jwts.parser().setSigningKey(secretKey).isSigned(token));
    }

    @Test
    public void testLoginFailure() {
        when(userRepository.findByUsername(anyString())).thenReturn(null);

        LoginRequest loginRequest = new LoginRequest("user", "wrongpassword");

        assertThrows(RuntimeException.class, () -> {
            authService.login(loginRequest);
        });
    }
}
