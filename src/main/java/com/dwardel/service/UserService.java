package com.dwardel.service;

import com.dwardel.dto.UserDTO;
import com.dwardel.model.QUser;
import com.dwardel.model.QUserAddress;
import com.dwardel.model.User;
import com.dwardel.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users (converted to DTO)
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDTO(user.getId(), user.getEmail()))
                .collect(Collectors.toList());
    }

    // Get a single user by ID
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> new UserDTO(user.getId(), user.getEmail()))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Create a new user
    public UserDTO createUser(User user) {
        User savedUser = userRepository.save(user);
        return new UserDTO(savedUser.getId(), savedUser.getEmail());
    }

    public List<User> findUsersByEmail(String emailId) {
        JPAQuery<User> query = new JPAQuery<>(entityManager);
        QUser qUser = QUser.user;

        return query.select(qUser)
                .from(qUser)
                .where(qUser.email.eq(emailId))
                .fetch();
    }

    public List<User> fetchUsersWithAddresses() {
        QUser qUser = QUser.user;
        QUserAddress qUserAddress = QUserAddress.userAddress;

        return new JPAQuery<>(entityManager)
                .select(qUser)
                .from(qUser)
                .leftJoin(qUserAddress).on(qUserAddress.user.eq(qUser))
                .fetch();
    }
}
