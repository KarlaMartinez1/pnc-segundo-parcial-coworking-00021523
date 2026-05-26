package com.uca.pncsegundoparcialcoworking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "Space")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SpaceType spaceType;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private BigDecimal pricePerHour;

    @Column(nullable = false)
    private Boolean available;

    @Column(nullable = false)
    private Integer floor;

    @Column(nullable = false)
    private String amenities;
}

