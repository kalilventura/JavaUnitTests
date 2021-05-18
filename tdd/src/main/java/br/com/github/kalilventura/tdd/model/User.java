package br.com.github.kalilventura.tdd.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime registrationDate;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
