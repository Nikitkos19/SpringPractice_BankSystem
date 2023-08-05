package com.practice.springpractice_banksystem;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BalanceRepository {
    private HashMap<Long, Long> storage = new HashMap<>(Map.of(1L,100L));


    public Long getBalanceForId(Long accountId) {
        return storage.get(accountId);
    }
}
