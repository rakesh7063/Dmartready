package com.DMart.Services;

import com.DMart.Exception.StockException;
import com.DMart.Model.Stock;

import java.util.List;

public interface StockService {
    public Stock addStock(Stock stocks) throws StockException;

    public List<Stock> findByName(String name) throws StockException;

    public Stock updateQuantityById(int id, int quantity) throws StockException;

    public List<Stock> findByQuantityGreaterThanValue(int quantity) throws StockException;

    public Stock deleteById(int id) throws StockException;

    public List<Stock> getAllStocks() throws StockException;
}
