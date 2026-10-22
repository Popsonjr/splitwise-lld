package com.example.lld_demo.domain.balance;

import java.util.UUID;

public record PairKey(UUID low, UUID high) {

    public PairKey {
        if (low.compareTo(high) >= 0) throw new IllegalArgumentException("low must be < high");
    }

    public static PairKey of(UUID a, UUID b) {
        if (a.equals(b)) throw new IllegalArgumentException("a pair needs two different users");
        return a.compareTo(b) < 0 ? new PairKey(a, b) : new PairKey(b, a);
    }

    public static long signedDelta(UUID debtor, UUID creditor, long amount) {
        return debtor.compareTo(creditor) < 0 ? amount : -amount;
    }

    public Debt toDebt(long storedAmount) {
        if (storedAmount == 0) return null;
        return storedAmount > 0 ? new Debt(low, high, storedAmount) : new Debt(high, low, -storedAmount);
    }

    public long owedBy(UUID debtor, long storedAmount) {
        boolean debtorIsLow = debtor.equals(low);
        return debtorIsLow ? Math.max(storedAmount, 0) : Math.max(-storedAmount, 0);
    }
}
