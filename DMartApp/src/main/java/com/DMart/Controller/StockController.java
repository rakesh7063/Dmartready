package com.DMart.Controller;

import com.DMart.Model.Stock;
import com.DMart.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DMart")
public class StockController {

    @Autowired
    private StockService stockService;


    @GetMapping("/all")
    public ResponseEntity<List<Stock>> getAllStocksHandle(){

        List<Stock> listOfStock = stockService.getAllStocks();
        return new ResponseEntity<List<Stock>>(listOfStock, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Stock> addStocksHandle(@RequestBody Stock  stock){

        Stock addstock = stockService.addStock(stock);
        return new ResponseEntity<Stock>(addstock,HttpStatus.OK);

    }

    @GetMapping("/find")
    public ResponseEntity<List<Stock>> findByNameController(@RequestParam("Name") String  name){

        List<Stock> stock = stockService.findByName(name);
        return new ResponseEntity<List<Stock>>(stock,HttpStatus.OK);

    }

    @GetMapping("/update")
    public ResponseEntity<Stock> updateQuantityControllerHandle(@RequestParam("id") int id, @RequestParam("quantity") int quantity){

        Stock stock = stockService.updateQuantityById(id, quantity);
        return new ResponseEntity<Stock>(stock,HttpStatus.OK);

    }

    @GetMapping("/greater")
    public ResponseEntity<List<Stock>> findBYQuantityGreaterThanValueHandle(@RequestParam(name = "quantity")int quantity){

        List<Stock> stock = stockService.findByQuantityGreaterThanValue(quantity);
        return new ResponseEntity<List<Stock>>(stock,HttpStatus.OK);

    }

    @GetMapping("/delete")
    public ResponseEntity<Stock> deleteByIdControllerHandle(@RequestParam("id") int id){

        Stock stock = stockService.deleteById(id);
        return new ResponseEntity<Stock>(stock,HttpStatus.OK);

    }
}
