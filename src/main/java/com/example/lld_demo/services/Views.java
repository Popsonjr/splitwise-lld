package com.example.lld_demo.services;


final class Views {

    private Views() { }

    static ExpenseView of(Expense e) {
        return new ExpenseView(
                e.getId(),
                e.getType().name(),
                e.getPaidBy().getId(),
                e.getPaidBy().getName(),
                e.getAmount(),
                e.getDescription(),
                e.getSplitType() == null ? null : e.getSplitType().name(),
                e.getShares().stream()
                        .map(s -> new ShareView(s.getUser().getId(), s.getUser().getName(), s.getAmount()))
                        .toList());
    }
}
