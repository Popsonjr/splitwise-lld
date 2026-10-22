package com.example.lld_demo.domain.model;

import com.example.lld_demo.enums.SplitType;

import java.util.ArrayList;

public class Expense {
    private UUID id;

    private ExpenseGroup group;
    private User paidBy;
    private long amount;
    private String description;
    private ExpenseType type;
    private SplitType splittype;
    private String idempotencyKey;
    private List<ExpenseShare> shares = new ArrayList<>();
    private Instant createdAt;


    private void addShare(User user, long shareAmount) {
        shares.add(new ExpenseShare(this, user, shareAmount, shares.size()));
    }
}
