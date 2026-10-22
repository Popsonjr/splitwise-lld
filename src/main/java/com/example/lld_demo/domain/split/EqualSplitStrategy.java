package com.example.lld_demo.domain.split;

import com.example.lld_demo.enums.SplitType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class EqualSplitStrategy implements SplitStrategy {

    @Override
    public SplitType type() {
        return SplitType.EQUAL;
    }

    @Override
    public List<ShareAllocation> split(SplitRequest request) {
        List<UUID> people = request.participants();
        if (people == null || people.isEmpty()) {
            throw new IllegalArgumentException("at least one participant is required");
        }
        int n = people.size();
        long base = request.amount() / n;
        long remainder = request.amount() % n;

        List<ShareAllocation> shares = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            shares.add(new ShareAllocation(people.get(i), base + (i < remainder ? 1 : 0)));
        }
        return List.copyOf(shares);
    }
}
