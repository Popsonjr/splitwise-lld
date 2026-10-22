package com.example.lld_demo.domain.model;

public class GroupMember {
    @id
    private UUID id;

    private ExpenseGroup group;

    private User user;
    private long netBalance;
    private Instant joinedAt;
}
