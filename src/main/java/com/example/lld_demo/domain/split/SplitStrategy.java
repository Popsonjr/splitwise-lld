package com.example.lld_demo.domain.split;

import com.example.lld_demo.enums.SplitType;

public interface SplitStrategy {
    SplitType type();
    List<ShareAllocation> split(SplitRequest request);
}
