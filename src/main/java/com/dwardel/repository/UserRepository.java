package com.dwardel.repository;

import com.dwardel.dto.UserDTO;
import com.dwardel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT new com.dwardel.dto.UserDTO(u.id, u.email) FROM User u WHERE u.id = :id")
    UserDTO findUserDTOById(@Param("id") Long id);

    @Query("SELECT u FROM User u JOIN FETCH u.userAddress WHERE u.id = :userId")
    User findUserWithAddress(@Param("userId") Long userId);
}
