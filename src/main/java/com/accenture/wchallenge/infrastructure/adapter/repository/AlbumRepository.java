package com.accenture.wchallenge.infrastructure.adapter.repository;

import com.accenture.wchallenge.infrastructure.adapter.repository.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, String> {

    Optional<AlbumEntity> findAlbumByUserId(String userId);
}
