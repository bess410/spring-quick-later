package com.example.springquick.repository;

import com.example.springquick.model.Purchase;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbc;

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase(product, price) VALUES (?, ?)";

        jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> findAllPurchases() {
        String sql = "Select * from purchase";

        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };

        return jdbc.query(sql, purchaseRowMapper);
    }
}
