package com.practice.springpractice_banksystem;

import com.practice.springpractice_banksystem.model.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController("/balance")
@AllArgsConstructor
public class BalanceController {

    private final BankService bankService;

    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId){
        return bankService.getBalance(accountId);
    }
    @GetMapping("/index")
    public List<BigDecimal> getIndex(){
        return bankService.getIndex();
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
    @PostMapping("/delete")
    public void delete(@RequestBody FastBalance fastBalance){
        bankService.delete(fastBalance.getTo());
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e){
        log.error(e.getMessage());
        return e.getMessage();
    }

}
