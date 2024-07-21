package com.yoandypv.cache.caffeine.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String userName;
    private String nombre;

    public static User newUser(String userName, String nombre) {
        return new User(UUID.randomUUID().toString(), userName, nombre);
    }
}
