package com.example.lld_demo.domain.split;

import java.util.List;
import java.util.UUID;

public record SplitRequest(long amount, List<UUID> participants, List<Long> exactAmounts) {
   public static SplitRequest equal(long amount, List<UUID> participants) {
       return new SplitRequest(amount,participants, null);
}
}
