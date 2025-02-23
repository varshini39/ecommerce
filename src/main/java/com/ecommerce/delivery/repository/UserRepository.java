package com.ecommerce.delivery.repository;

import com.ecommerce.delivery.dto.UserDTO;
import com.ecommerce.delivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT new com.ecommerce.delivery.dto.UserDTO(u.id, u.email) FROM User u WHERE u.id = :id")
    UserDTO findUserDTOById(@Param("id") Long id);
}
