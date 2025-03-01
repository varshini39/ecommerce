package com.dwardel.controller;

import com.dwardel.dto.UserAddressDTO;
import com.dwardel.model.UserAddress;
import com.dwardel.service.UserAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user-address")
@RequiredArgsConstructor
public class UserAddressController {

    private final UserAddressService userAddressService;

    @PostMapping("/save")
    public UserAddress saveAddress(
            @RequestParam Long userId,
            @RequestParam String address,
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam String placeId) {
        return userAddressService.saveUserAddress(userId, address, latitude, longitude, placeId);
    }

    @GetMapping("/nearby")
    public List<UserAddress> getNearbyAddresses(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam double radius) {
        return userAddressService.findNearbyAddresses(latitude, longitude, radius);
    }

    @GetMapping
    public List<UserAddressDTO> getAllUserAddresses() {
        return userAddressService.getAllUserAddresses();
    }
}
