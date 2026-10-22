package com.example.lld_demo.services;

import java.util.UUID;

public class ExpenseService {

    @Transactional
    public ExpenseView addExpense(UUID groupId, AddExpenseCommand cmd, String idempotencyKey) {
}
