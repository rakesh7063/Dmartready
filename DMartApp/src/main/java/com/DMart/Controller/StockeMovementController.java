package com.DMart.Controller;

import com.DMart.Model.Stock;
import com.DMart.Model.StockMovement;
import com.DMart.Services.StockMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DMart/movement")
public class StockeMovementController {

    @Autowired
    private StockMovementService movementService;


    @GetMapping("/all")
    public ResponseEntity<List<StockMovement>> getAllStockMovementsControllerHandle(@RequestBody Stock stock){

        List<StockMovement> stMovements = movementService.getByStock(stock);
        return new ResponseEntity<List<StockMovement>>(stMovements, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<StockMovement> addStockMovementControllerHandle(@RequestBody StockMovement stovkMovement){

        StockMovement stMovement = movementService.addStockMovement(stovkMovement);
        return new ResponseEntity<StockMovement>(stMovement,HttpStatus.OK);

    }
}
