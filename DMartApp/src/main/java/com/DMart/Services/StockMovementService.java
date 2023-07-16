package com.DMart.Services;

import com.DMart.Exception.LocationException;
import com.DMart.Exception.StockException;
import com.DMart.Exception.StockMovementException;
import com.DMart.Model.Stock;
import com.DMart.Model.StockMovement;
import com.DMart.Model.StockMovementDTO;

import java.util.List;

public interface StockMovementService {

    public List<StockMovement> getByStockId(Integer id) throws StockMovementException;

    public StockMovement addStockMovement(StockMovementDTO stockMovementDTO) throws StockMovementException, StockException, LocationException;
    public List<StockMovement> getAllMovement() throws StockMovementException;

}
