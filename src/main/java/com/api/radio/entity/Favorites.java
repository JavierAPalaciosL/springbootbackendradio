package com.api.radio.entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
public class Favorites {

    @Id
    private UUID id;

    @Column
    private Date date;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn(name = "userRelationShip")
    private Users userRelationShip;

}
