package com.DMart.Services;

import com.DMart.Exception.LocationException;
import com.DMart.Exception.StockException;
import com.DMart.Exception.StockMovementException;
import com.DMart.Model.Location;
import com.DMart.Model.Stock;
import com.DMart.Model.StockMovement;
import com.DMart.Model.StockMovementDTO;
import com.DMart.Repository.LocationDao;
import com.DMart.Repository.StockDao;
import com.DMart.Repository.StockMovementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StockMovmentServiceImpl implements StockMovementService{

    @Autowired
    private StockMovementDao stockMovementRepo;
    @Autowired
    private StockDao stockRepo;
    @Autowired
    private LocationDao locationRepo;
    @Override
    public List<StockMovement> getByStockId(Integer id) throws StockMovementException {
        Optional<Stock> stocks = stockRepo.findById(id);

        if(stocks.isEmpty()) {
            throw new StockMovementException("Stock movement does not exits...");
        }
        else {
            List<StockMovement> viewMovements = stocks.get().getStockMovements();
            return viewMovements;
        }
    }

    @Override
    public StockMovement addStockMovement(StockMovementDTO stockMovementDTO) throws StockMovementException, StockException, LocationException {
        Stock stock = stockRepo.findById(stockMovementDTO.getStockId()).orElseThrow(()->new StockException("Stock not Exist with StockId "+ stockMovementDTO.getStockId()));
        Location sourceLocation = locationRepo.findByStoreName(stockMovementDTO.getSourceStoreName()).orElseThrow(()-> new LocationException("Store Name not available on this System"));
        Location destinationLocation = locationRepo.findByStoreName(stockMovementDTO.getDestinationStoreName()).orElseThrow(()-> new LocationException("Destination Store name not available"));

        if(stock.getQuantity()<stockMovementDTO.getQuantity()) throw new StockException("insufficient quantity..");
        else {
            stock.setQuantity(stock.getQuantity() - stockMovementDTO.getQuantity());
        StockMovement addNewMovement = new StockMovement();
        addNewMovement.setStocks(stock);
        addNewMovement.setSourceLocation(sourceLocation);
        addNewMovement.setDestinationLocation(destinationLocation);
        addNewMovement.setQuantity(stockMovementDTO.getQuantity());
        addNewMovement.setTimeStamp(LocalDateTime.now());

        return stockMovementRepo.save(addNewMovement);
    }}

    @Override
    public List<StockMovement> getAllMovement() throws StockMovementException {
        List<StockMovement> allStockMovement = stockMovementRepo.findAll();
        if(allStockMovement.isEmpty()) throw new StockMovementException("Stock Movement not exist..");
        else return allStockMovement;
    }


}
