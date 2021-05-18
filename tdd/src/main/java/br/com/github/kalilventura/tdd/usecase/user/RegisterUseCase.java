package br.com.github.kalilventura.tdd.usecase.user;

import br.com.github.kalilventura.tdd.mail.Mailing;
import br.com.github.kalilventura.tdd.model.User;
import br.com.github.kalilventura.tdd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegisterUseCase {
    private final UserRepository userRepository;
    private final Mailing sendMail;


    public User registerUser(User user) {
        user.setRegistrationDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    public Long registerUser(User user, boolean sendWelcomeMail) {
        user.setRegistrationDate(LocalDateTime.now());

        if (sendWelcomeMail) {
            sendMail.sendMail("Welcome!", "Thanks for registering.");
        }

        return userRepository.save(user).getId();
    }

}
