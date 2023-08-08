package com.practice.springpractice_banksystem;

import com.practice.springpractice_banksystem.model.FastBalance;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    private BalanceRepository balanceRepository = new BalanceRepository();
    private BankService bankService = new BankService(balanceRepository);
    private FastBalance fastBalance = new FastBalance();
    @Test
    void getBalance() {
        BigDecimal balance = bankService.getBalance(1L);
        assertEquals(balance, BigDecimal.TEN);
    }
    @Test
    void addMoney() {
        BigDecimal balance = bankService.addMoney(2L, BigDecimal.valueOf(100));
        assertEquals(balance, BigDecimal.valueOf(100));
    }
    @Test
    void TransferMoney(){
        bankService.addMoney(2L,BigDecimal.valueOf(100));
        fastBalance.setFrom(2L);
        fastBalance.setTo(1L);
        fastBalance.setAmount(BigDecimal.valueOf(50));
        bankService.transferMoney(fastBalance);
        assertEquals(balanceRepository.getBalanceForId(1L), BigDecimal.valueOf(60));
        assertEquals(balanceRepository.getBalanceForId(2L), BigDecimal.valueOf(50));
    }
}
