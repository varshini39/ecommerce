package com.dwardel.repository;

import com.dwardel.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

    // Find all addresses within a given radius (e.g., 5km)
    @Query(value = "SELECT * FROM user_address WHERE ST_DWithin(location, ST_SetSRID(ST_MakePoint(?1, ?2), 4326), ?3)", nativeQuery = true)
    List<UserAddress> findAddressesWithinRadius(double longitude, double latitude, double radius);
}
