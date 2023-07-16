package com.DMart.Repository;

import com.DMart.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LocationDao extends JpaRepository<Location, Integer> {


    public Optional<Location> findByStoreName(String name);

    @Query("from com.DMart.Model.Location s where s.address = ?1 order by s.address ASC")
    public List<Location> findAllByAddress(String address);

}
