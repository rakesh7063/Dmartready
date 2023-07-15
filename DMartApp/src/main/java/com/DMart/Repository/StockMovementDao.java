package com.DMart.Repository;

import com.DMart.Model.Stock;
import com.DMart.Model.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockMovementDao extends JpaRepository<StockMovement, Integer> {
    List<StockMovement> findByStocks(Stock stock);
}
