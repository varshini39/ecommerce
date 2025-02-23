package com.ecommerce.delivery.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;

    public UserDTO(Long id, String email) {
    }
}
