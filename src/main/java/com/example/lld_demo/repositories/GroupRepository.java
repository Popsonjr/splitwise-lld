package com.example.lld_demo.repositories;

import com.example.lld_demo.domain.model.ExpenseGroup;

import java.util.Optional;
import java.util.concurrent.locks.Lock;

public interface GroupRepository extends JpaRepository<ExpenseGroup, UUID> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("Select g from ExpenseGroup g where g.id = :id")
    Optional<ExpenseGroup> findByIdForUpdate(@Param("id") UUID id);
}
