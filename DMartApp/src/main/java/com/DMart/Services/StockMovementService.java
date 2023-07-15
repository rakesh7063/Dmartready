package com.DMart.Services;

import com.DMart.Exception.StockMovementException;
import com.DMart.Model.Stock;
import com.DMart.Model.StockMovement;

import java.util.List;

public interface StockMovementService {

    public List<StockMovement> getByStock(Stock stock) throws StockMovementException;

    public StockMovement addStockMovement(StockMovement stockMovement) throws StockMovementException;
}
