package com.example.lld_demo.domain.balance;

import java.util.UUID;

public record Debt(UUID from, UUID to, long amount) {
    public Debt {
        if (amount <= 0) throw new IllegalArgumentException("debt amount must be positive");
    }
}