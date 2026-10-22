package com.example.lld_demo.domain.split;

import java.util.UUID;

public record ShareAllocation(UUID userId, long amount) {
    public ShareAllocation {
        if (userId == null) throw new IllegalArgumentException("userId is required");
        if (amount < 0) throw new IllegalArgumentException("Share cannot be negative");
    }
}
