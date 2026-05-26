package com.uca.pncsegundoparcialcoworking.repositories;

import com.uca.pncsegundoparcialcoworking.entities.Space;
import com.uca.pncsegundoparcialcoworking.entities.SpaceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpaceRepository extends JpaRepository<Space, Long> {
    boolean existsByNameIgnoreCase(String name);
    List<Space> findByTypeAndAvailable(SpaceType spaceType, Boolean available);
}
