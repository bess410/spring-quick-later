package com.example.springquick.repository;

import com.example.springquick.mapping.AccountRowMapper;
import com.example.springquick.model.Account;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Data
@Repository
public class AccountRepository {

    private final JdbcTemplate jdbc;

    public Account findAccountById(long id) {
        String sql = "select * from account where id = ?";
        return jdbc.queryForObject(sql, new AccountRowMapper(), id);
    }

    public void changeAmount(long id, BigDecimal amount) {
        String sql = "update account set amount = ? where id = ?";
        jdbc.update(sql, amount, id);
    }

    public List<Account> findAllAccounts() {
        String sql = "select * from account";
        return jdbc.query(sql, new AccountRowMapper());
    }
}
