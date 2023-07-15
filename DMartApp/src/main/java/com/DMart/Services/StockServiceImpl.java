package com.DMart.Services;

import com.DMart.Exception.StockException;
import com.DMart.Model.Stock;
import com.DMart.Model.StockMovement;
import com.DMart.Repository.StockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    private StockDao stockRepo;

    @Override
    public Stock addStock(Stock stocks) throws StockException {
        Optional<Stock> existingStock = stockRepo.findById(stocks.getItemId());
        if(existingStock.isEmpty()) {
            stockRepo.save(stocks);
            return stocks;
        }
        else throw new StockException("Stock already exist with id :"+stocks.getItemId());

    }


    @Override
    public List<Stock> findByName(String name) throws StockException {
        List<Stock> existingStock = stockRepo.findByName(name);
        if(existingStock.isEmpty()) throw new StockException("Invalid Name "+ name );
        else
        return existingStock;
    }

    @Override
    public Stock updateQuantityById(int id, int quantity) throws StockException {
        Optional<Stock> existingStock = stockRepo.findById(id);
        if(existingStock.isPresent()) {
            Stock stocks =existingStock.get();
            stocks.setQuantity(stocks.getQuantity()+(quantity));
            stockRepo.save(stocks);
            return stocks;
        }else {
            throw new StockException("Stock item does not exist with the id :"+id);
        }
    }

    @Override
    public List<Stock> findByQuantityGreaterThanValue(int quantity) throws StockException {
        List<Stock>  existingStockList = stockRepo.findStocksByQuantity(quantity);
        if( existingStockList.isEmpty()) throw new StockException("There have no Stock whose Stock quantity is greater than :"+quantity);
        else return  existingStockList;
    }

    @Override
    public Stock deleteById(int id) throws StockException {
        Optional<Stock> opt = stockRepo.findById(id);
        if(opt.isPresent()) {
            stockRepo.deleteById(id);
            return opt.get();
        }else
            throw new StockException("stock item does not exist with id :"+id);

    }

    @Override
    public List<Stock> getAllStocks() throws StockException {
        List<Stock> stockList = stockRepo.findAll();
        if(stockList.isEmpty()) {
            throw new StockException("Stocks does not exist...");
        }else {
            return stockList;
        }
    }
}
