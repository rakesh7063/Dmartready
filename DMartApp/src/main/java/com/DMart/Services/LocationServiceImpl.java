package com.DMart.Services;

import com.DMart.Exception.LocationException;
import com.DMart.Model.Location;
import com.DMart.Repository.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

  @Autowired
  private LocationDao locationRepo;

    @Override
    public Location findByName(String name) throws LocationException {
            Location storeLocation = locationRepo.findByStoreName(name).orElseThrow(()-> new LocationException(("Location does not exist..")));
          return  storeLocation;
    }

    @Override
    public List<Location> findByAddress(String address) throws LocationException {
        List<Location> listStoreLocation = locationRepo.findAllByAddress(address);
        if(listStoreLocation.isEmpty()) {
            throw new LocationException("Locations does not exist...");
        }else {
            return listStoreLocation;
        }
    }

    @Override
    public Location addLocation(Location location) throws LocationException {
        Optional<Location> existingLocation = locationRepo.findById(location.getLocationId());
        if(existingLocation.isPresent()) {
            throw new LocationException("Store location already exist...");
        }else {
            locationRepo.save(location);
            return location;
        }
    }

    @Override
    public List<Location> getAllLocation() throws LocationException {
        List<Location> listStoreLocation = locationRepo.findAll();
        if(listStoreLocation.isEmpty()) {
            throw new LocationException("Locations does not exist...");
        }else {
            return listStoreLocation;
        }
    }
}
