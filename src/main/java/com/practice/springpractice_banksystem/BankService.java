package com.practice.springpractice_banksystem;

import com.practice.springpractice_banksystem.model.FastBalance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class BankService {

    private BalanceRepository balanceRepository;
    public BigDecimal getBalance(Long accountId) {
       BigDecimal balance = balanceRepository.getBalanceForId(accountId);

       if(balance == null)
           throw new IllegalArgumentException();
       else
           return balance;
    }
    public BigDecimal addMoney(Long to, BigDecimal amount) {
        int length = balanceRepository.getLengthOfRepos();
        if(to == length){
            balanceRepository.save(to,amount);
            return amount;
        }
        else if(to > length) throw new IllegalArgumentException("id слишком большой, используйте: " + balanceRepository.getLengthOfRepos());
        else{
            BigDecimal currentBalance = balanceRepository.getBalanceForId(to);
            BigDecimal updatedBalance = currentBalance.add(amount);
            balanceRepository.update(to, updatedBalance);
            return updatedBalance;
        }
    }
    public void transferMoney(FastBalance fastBalance) {
        BigDecimal fromBalance = balanceRepository.getBalanceForId(fastBalance.getFrom());
        BigDecimal toBalance = balanceRepository.getBalanceForId(fastBalance.getTo());

        if(fromBalance == null || toBalance == null) throw new IllegalArgumentException("Таких счетов пока не существует.");
        if(fastBalance.getAmount().compareTo(fromBalance) > 0) throw new IllegalArgumentException("Денег нет, но вы держитесь.");

        BigDecimal updatedFromBalance = fromBalance.subtract(fastBalance.getAmount());
        BigDecimal updatedToBalance = toBalance.add(fastBalance.getAmount());

        balanceRepository.update(fastBalance.getFrom(), updatedFromBalance);
        balanceRepository.update(fastBalance.getTo(), updatedToBalance);
    }
}
