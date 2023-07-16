package com.DMart.Controller;

import com.DMart.Model.Stock;
import com.DMart.Model.StockMovement;
import com.DMart.Model.StockMovementDTO;
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


    @GetMapping("/{id}")
    public ResponseEntity<List<StockMovement>> getAllStockMovementsControllerHandle(@PathVariable("id") Integer id ){

        List<StockMovement> stMovements = movementService.getByStockId(id);
            return new ResponseEntity<>(stMovements,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<StockMovement> addStockMovementControllerHandle(@RequestBody StockMovementDTO movementDTO){

        StockMovement stMovement = movementService.addStockMovement(movementDTO);
        return new ResponseEntity<StockMovement>(stMovement,HttpStatus.CREATED);

    }
    @GetMapping("/all")
    public ResponseEntity<List<StockMovement>> findAllStockMovement(){
        List<StockMovement> movementList = movementService.getAllMovement();
        return  new ResponseEntity<>(movementList,HttpStatus.OK);
    }
}
