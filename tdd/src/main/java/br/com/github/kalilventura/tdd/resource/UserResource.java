package br.com.github.kalilventura.tdd.resource;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class UserResource {
    private Long userId;
    @NotNull
    private final String name;
    @NotNull
    private final String email;

    public UserResource(String name, String email) {
        this.email = email;
        this.name = name;
    }

    public UserResource(Long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
}
