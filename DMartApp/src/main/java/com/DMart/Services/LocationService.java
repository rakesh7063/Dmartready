package com.DMart.Services;

import com.DMart.Exception.LocationException;
import com.DMart.Model.Location;

import java.util.List;

public interface LocationService {
    public Location findByName(String name) throws LocationException;

    public List<Location>  findByAddress(String address) throws LocationException;

    public Location addLocation(Location location) throws LocationException;

    List<Location>  getAllLocation() throws LocationException;

}
