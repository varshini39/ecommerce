package com.dwardel.service;

import com.dwardel.dto.UserAddressDTO;
import com.dwardel.model.User;
import com.dwardel.model.UserAddress;
import com.dwardel.repository.UserAddressRepository;
import com.dwardel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserAddressService {

    private final UserAddressRepository userAddressRepository;
    private final UserRepository userRepository;
    private final GeometryFactory geometryFactory = new GeometryFactory();

    public UserAddress saveUserAddress(Long userId, String address, double latitude, double longitude, String placeId) {
        Point point = geometryFactory.createPoint(new Coordinate(longitude, latitude));
        point.setSRID(4326); // Use WGS 84

        // Fetch the user entity
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        UserAddress userAddress = new UserAddress();
        userAddress.setUser(user);
        userAddress.setAddress(address);
        userAddress.setLocation(point);
        userAddress.setPlaceId(placeId);
        userAddress.setPlaceGeneratedTime(java.time.LocalDateTime.now());

        return userAddressRepository.save(userAddress);
    }

    public List<UserAddress> findNearbyAddresses(double latitude, double longitude, double radius) {
        return userAddressRepository.findAddressesWithinRadius(longitude, latitude, radius);
    }

    public List<UserAddressDTO> getAllUserAddresses() {
        List<UserAddress> addresses = userAddressRepository.findAll();
        return addresses.stream()
                .map(address -> new UserAddressDTO(
                        address.getId(),
                        address.getUser().getId(),
                        address.getAddress(),
                        address.getPlaceId(),
                        address.getPlaceGeneratedTime(),
                        address.getCreatedAt(),
                        address.getUpdatedAt(),
                        address.getLocation()
                ))
                .collect(Collectors.toList());
    }
}
