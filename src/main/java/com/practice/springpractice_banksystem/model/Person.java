package com.practice.springpractice_banksystem.model;

import lombok.Data;

import java.util.*;

@Data
public class Person {
    private FastBalance fastBalance;
    private String Name;
    private ArrayList<String> operations = new ArrayList<>();
    private Long accountId;
}
