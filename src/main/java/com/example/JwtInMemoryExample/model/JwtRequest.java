package com.example.JwtInMemoryExample.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtRequest {

    private String email;
    private String password;
}
