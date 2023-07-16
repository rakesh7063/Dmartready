package com.DMart.Services;

import com.DMart.Exception.StockMovementException;
import com.DMart.Model.Stock;
import com.DMart.Model.StockMovement;
import com.DMart.Repository.StockDao;
import com.DMart.Repository.StockMovementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockMovmentServiceImpl implements StockMovementService{

    @Autowired
    private StockMovementDao stockMovementRepo;

    @Autowired
    private StockDao stockRepo;
    @Override
    public List<StockMovement> getByStock(Stock stock) throws StockMovementException {
        Optional<Stock> stocks = stockRepo.findById(stock.getItemId());

        if(stocks.isEmpty()) {
            throw new StockMovementException("Stock movement does not exits...");
        }
        else {
            List<StockMovement> viewMovements = stocks.get().getStockMovements();
            return viewMovements;
        }
    }

    @Override
    public StockMovement addStockMovement(StockMovement stockMovement) throws StockMovementException {
        Optional<StockMovement> existingMovement = stockMovementRepo.findById(stockMovement.getMovementId());
        if(existingMovement.isPresent()) {
            throw new StockMovementException("Stock movement already register with the id :"+stockMovement.getMovementId());
        }else {
            StockMovement stm = stockMovementRepo.save(stockMovement);
            return stm;
        }
    }
}
