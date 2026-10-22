package com.example.lld_demo.domain.model;

import java.time.Instant;

public class User {

    @Id
    private UUID id;

    private String name;
    private String email;
    private Instant createdAt;

}
