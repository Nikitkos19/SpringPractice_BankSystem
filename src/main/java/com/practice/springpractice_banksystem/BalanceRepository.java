package com.practice.springpractice_banksystem;

import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BalanceRepository {
    private HashMap<Long, BigDecimal> storage = new HashMap<>(Map.of(1L, BigDecimal.TEN));
    private HashMap<Long, String> names = new HashMap<>(Map.of(1L, "Nikita"));

    public BigDecimal getBalanceForId(Long accountId) {
        return storage.get(accountId);
    }
    public void save(Long to, BigDecimal amount) {
        storage.put(to, mount);
    }
}
