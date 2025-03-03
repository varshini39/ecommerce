package com.dwardel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private String address;

    public UserDTO(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
