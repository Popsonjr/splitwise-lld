package com.example.lld_demo.domain.model;

import java.util.UUID;

public class ExpenseShare {
    @Id
    private UUID id;
    private Expense expense;
    private User user;
    private long amount;
    private int position;

}
