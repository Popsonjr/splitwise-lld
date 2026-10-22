package com.example.lld_demo.domain.model;

public class PairBalance {
    @Id
    private UUID id;
    private ExpenseGroup group;
    private UUID lowUserId;
    private UUID highUserId;
    private long amount;
}
