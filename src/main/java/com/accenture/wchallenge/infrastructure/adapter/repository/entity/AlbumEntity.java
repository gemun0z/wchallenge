package com.accenture.wchallenge.infrastructure.adapter.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALBUMS")
public class AlbumEntity {

    @Id
    private String id;
    private String userId;
    private String title;

}
