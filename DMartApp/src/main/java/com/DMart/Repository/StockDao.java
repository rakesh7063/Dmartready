package com.DMart.Repository;

import com.DMart.Exception.StockException;
import com.DMart.Model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockDao extends JpaRepository<Stock, Integer> {
    public List<Stock> findByName(String name) throws StockException;

    @Query("from com.DMart.Model.Stock st where st.quantity >= ?1")
    public List<Stock> findStocksByQuantity(int quantity) throws StockException;
}
