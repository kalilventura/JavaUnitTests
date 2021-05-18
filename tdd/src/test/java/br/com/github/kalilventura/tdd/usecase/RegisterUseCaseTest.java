package br.com.github.kalilventura.tdd.usecase;

import br.com.github.kalilventura.tdd.model.User;
import br.com.github.kalilventura.tdd.repository.UserRepository;
import br.com.github.kalilventura.tdd.usecase.user.RegisterUseCase;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.AdditionalAnswers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class RegisterUseCaseTest {
    @Mock
    private UserRepository userRepository; //= Mockito.mock(UserRepository.class);

    @InjectMocks
    private RegisterUseCase registerUseCase;

    @Test
    void saveUserHasRegistrationDate() {
        User user = new User("John", "john@mail.com");

        when(userRepository.save(any(User.class))).then(returnsFirstArg());

        User savedUser = registerUseCase.registerUser(user);
        assertThat(savedUser.getRegistrationDate()).isNotNull();
    }
}
