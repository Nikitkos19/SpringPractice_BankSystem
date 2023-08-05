package com.practice.springpractice_banksystem;

import com.practice.springpractice_banksystem.model.FastBalance;
import com.practice.springpractice_banksystem.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class BankService {

    private BalanceRepository balanceRepository;
    public Long getBalance(Person person) {
       Long balance = balanceRepository.getBalanceForId(person.getAccountId());

       if(balance == null)
           throw new IllegalArgumentException();
       else
           return balance;
    }
    public BigDecimal addMoney(Long to, BigDecimal amount) {

        return null;
    }
    public void transferMoney(FastBalance fastBalance) {


    }
    public Person setup(Person person) {


        return person;
    }

}
