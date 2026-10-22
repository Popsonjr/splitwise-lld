package com.example.lld_demo.domain.balance;

import java.util.*;

/**
 * Greedy debt simplification from net balances (+ = is owed money, - = owes money).
 * Repeatedly matches the largest debtor with the largest creditor.
 * Produces at most n - 1 transfers in O(n log n). Not always the theoretical minimum
 * (that problem is NP-hard), but the standard practical choice.
 */
public final class DebtSimplifier {

    private record Party(UUID userId, long remaining) {}

    private static final Comparator<Party> LARGEST_FIRST =
            Comparator.comparingLong((Party p) -> p.remaining).reversed()
                      .thenComparing(Party::userId);          // deterministic tie-break

    public List<Debt> simplify(Map<UUID, Long> netBalances) {
        long total = 0;
        PriorityQueue<Party> creditors = new PriorityQueue<>(LARGEST_FIRST);
        PriorityQueue<Party> debtors = new PriorityQueue<>(LARGEST_FIRST);   // stores |balance|

        for (var e : netBalances.entrySet()) {
            long v = e.getValue();
            total = Math.addExact(total, v);
            if (v > 0) creditors.add(new Party(e.getKey(), v));
            else if (v < 0) debtors.add(new Party(e.getKey(), -v));
        }
        if (total != 0) {
            throw new IllegalStateException("net balances must sum to zero, got " + total);
        }

        List<Debt> transfers = new ArrayList<>();
        while (!creditors.isEmpty() && !debtors.isEmpty()) {
            Party c = creditors.poll();
            Party d = debtors.poll();
            long pay = Math.min(c.remaining, d.remaining);
            transfers.add(new Debt(d.userId, c.userId, pay));
            if (c.remaining > pay) creditors.add(new Party(c.userId, c.remaining - pay));
            if (d.remaining > pay) debtors.add(new Party(d.userId, d.remaining - pay));
        }
        return transfers;
    }
}
