package com.DMart.Controller;

import com.DMart.Model.Location;
import com.DMart.Services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DMart/Location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("")
    public ResponseEntity<List<Location>> getAllLocationHandle(){

        List<Location> locations = locationService.getAllLocation();
        return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<Location> addNewLocation(@RequestBody Location location){
        Location storeLocation = locationService.addLocation(location);
        return new ResponseEntity<Location>(storeLocation,HttpStatus.OK);

    }

    @GetMapping("/getByName")
    public ResponseEntity<List<Location>> getByName(@RequestParam(name = "name") String name){
        List<Location> storeLocations = locationService.findByName(name);
        return new ResponseEntity<List<Location>>(storeLocations,HttpStatus.OK);

    }

    @GetMapping("/getByAddress")
    public ResponseEntity<List<Location>> getByAddress(@RequestParam(name = "address") String address){
        List<Location> storeLocations = locationService.findByAddress(address);
        return new ResponseEntity<List<Location>>(storeLocations,HttpStatus.OK);

    }
}
