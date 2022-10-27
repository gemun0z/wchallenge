package com.accenture.wchallenge.infrastructure.adapter.repository;

import com.accenture.wchallenge.infrastructure.adapter.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Query(value = "SELECT * FROM USERS WHERE READ IS TRUE", nativeQuery = true)
    Optional<List<UserEntity>> getUsersByAccessRead();

    @Query(value = "SELECT * FROM USERS WHERE WRITE IS TRUE", nativeQuery = true)
    Optional<List<UserEntity>> getUsersByAccessWrite();

}
