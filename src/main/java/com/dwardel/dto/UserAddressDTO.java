package com.dwardel.dto;

import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserAddressDTO {
    private Long id;
    private Long userId;
    private String address;
    private String placeId;
    private LocalDateTime placeGeneratedTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private double latitude;
    private double longitude;

    public UserAddressDTO(Long id, Long userId, String address, String placeId,
                          LocalDateTime placeGeneratedTime, LocalDateTime createdAt,
                          LocalDateTime updatedAt, Point location) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.placeId = placeId;
        this.placeGeneratedTime = placeGeneratedTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.latitude = location.getY();  // Extract latitude
        this.longitude = location.getX(); // Extract longitude
    }
}