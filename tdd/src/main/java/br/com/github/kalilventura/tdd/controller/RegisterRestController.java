package br.com.github.kalilventura.tdd.controller;

import br.com.github.kalilventura.tdd.resource.UserResource;
import br.com.github.kalilventura.tdd.model.User;
import br.com.github.kalilventura.tdd.usecase.user.RegisterUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class RegisterRestController {
    private final RegisterUseCase registerUseCase;

    @PostMapping("/forums/{forumId}/register")
    UserResource register(
            @PathVariable("forumId") Long forumId,
            @Valid @RequestBody UserResource userResource,
            @RequestParam("sendWelcomeMail") boolean sendWelcomeMail) {

        User user = new User(userResource.getName(), userResource.getEmail());

        Long userId = registerUseCase.registerUser(user, sendWelcomeMail);

        return new UserResource(
                userId,
                user.getName(),
                user.getEmail());
    }
}
