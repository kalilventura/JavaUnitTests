package br.com.github.kalilventura.tdd.controller;

import br.com.github.kalilventura.tdd.model.User;
import br.com.github.kalilventura.tdd.resource.UserResource;
import br.com.github.kalilventura.tdd.usecase.user.RegisterUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RegisterRestController.class)
public class RegisterRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RegisterUseCase registerUseCase;

    @Test
    void whenValidInput_thenReturns200() throws Exception {
        UserResource userResource = new UserResource("John", "john@gmail.com");

        User addUserResponse = new User(userResource.getName(), userResource.getEmail());

        //mocking the bean for any object of AddUserRequest.class
        Mockito.when(registerUseCase.registerUser(ArgumentMatchers.any(User.class))).thenReturn(addUserResponse);

        mockMvc.perform(post("/forums/{forumId}/register", 42L)
                .contentType("application/json")
                .param("sendWelcomeMail", "true")
                .content(objectMapper.writeValueAsString(userResource)))
                .andExpect(status().isOk());
    }

}
