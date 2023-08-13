package com.practice.springpractice_banksystem;

import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BalanceRepository {
    private static Connection connection;
    private HashMap<Long, BigDecimal> storage = new HashMap<>(Map.of(1L, BigDecimal.TEN));

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(Properties.URL, Properties.USERNAME, Properties.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<BigDecimal> index(){
        List<BigDecimal> balance = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Balance";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()){
                balance.add(resultSet.getInt("id"), resultSet.getBigDecimal("balance"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;
    }
    public BigDecimal getBalanceForId(Long accountId) {
        List<BigDecimal> balance = index();
        return balance.get(accountId.intValue());
    }
    public void save(Long to, BigDecimal amount) {

        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Balance VALUES (" + to.intValue() + ", " + amount + ")";
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
