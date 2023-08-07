package com.practice.springpractice_banksystem;

import com.practice.springpractice_banksystem.model.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
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
    public String create(@ModelAttribute("Balance") FastBalance fastBalance){
        return "successPage";
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e){
        log.error(e.getMessage());
        return "Этого баланса пока не существует.";
    }

}
