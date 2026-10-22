package com.example.lld_demo.domain.model;

import java.time.Instant;

public class ExpenseGroup {

    @Id
    private UUID id;

    private String name;

    private long version;

    private Instant createdAt;


}
