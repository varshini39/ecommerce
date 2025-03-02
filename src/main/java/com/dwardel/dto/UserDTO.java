package com.dwardel.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String address;

    public UserDTO(Long id, String email) {
    }
}
