package com.practice.springpractice_banksystem;

import com.practice.springpractice_banksystem.model.FastBalance;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController("/balance")
@AllArgsConstructor
public class BalanceController {

    private final BankService bankService;

    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId){
        return bankService.getBalance(accountId);
    }
    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody FastBalance fastBalance) {
        return bankService.addMoney(fastBalance.getTo(), fastBalance.getAmount());
    }
    @PostMapping("/transfer")
    public void transferMoney(@RequestBody FastBalance fastBalance) {
        bankService.transferMoney(fastBalance);
    }
 @PostMapping()
    public String create(@ModelAttribute("person") Person person){
        // здесь нужно будет добавлять данные в БД
        return "successPage";
    }
//я хз, что с этим делать, cкорее всего этот метод надо заебащить в transferMoney(его части)


}
