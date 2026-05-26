package com.uca.pncsegundoparcialcoworking.service.impl;

import com.uca.pncsegundoparcialcoworking.common.mappers.SpaceMapper;
import com.uca.pncsegundoparcialcoworking.dto.request.SpaceRequest;
import com.uca.pncsegundoparcialcoworking.dto.request.UpdateSpaceRequest;
import com.uca.pncsegundoparcialcoworking.dto.response.SpaceResponse;
import com.uca.pncsegundoparcialcoworking.entities.Space;
import com.uca.pncsegundoparcialcoworking.entities.SpaceType;
import com.uca.pncsegundoparcialcoworking.exceptions.BusinessRuleException;
import com.uca.pncsegundoparcialcoworking.exceptions.ResourceNotFoundException;
import com.uca.pncsegundoparcialcoworking.repositories.SpaceRepository;
import com.uca.pncsegundoparcialcoworking.service.SpaceService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpaceServiceImpl implements SpaceService {
    private final SpaceRepository spaceRepository;
    private final SpaceMapper spaceMapper;

    @Override
    @Transactional
    public SpaceResponse createSpace(SpaceRequest request) {
        if (spaceRepository.existsByNameIgnoreCase(request.getName())) {
            throw new BusinessRuleException("Space already exists");
        }
        Space space = spaceMapper.toEntityCreate(request);
        return spaceMapper.toDto(spaceRepository.save(space));
    }

    @Override
    public List<SpaceResponse> getAllSpaces(SpaceType spaceType, Boolean available) {
        List<Space> spaces;

        if (spaceType != null && available != null) {
            spaces = spaceRepository.findByTypeAndAvailable(spaceType, available);
        } else {
            spaces = spaceRepository.findAll();
        }

        if (spaces.isEmpty()) {
            throw new ResourceNotFoundException("No Spaces found");
        }
        return spaces.stream()
                .map(spaceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SpaceResponse getSpaceById(Long id) {
        Space space = spaceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Space not found"));
        return SpaceMapper.toDto(space);
    }

    @Override
    @Transactional
    public SpaceResponse updateProduct(UpdateSpaceRequest request, Long id) {
        Space existingProduct = spaceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Espacio no encontrado en el inventario"));

        if (!existingProduct.getName().equalsIgnoreCase(request.getName()) &&
                spaceRepository.existsByNameIgnoreCase(request.getName())) {
            throw new BusinessRuleException("El nombre del producto ya está en uso: " + request.getName());
        }

        Space productToUpdate = spaceMapper.toEntityUpdate(request, id);

        if (productToUpdate.getCapacity() == 0) {
            productToUpdate.setAvailable(false);
        }

        return spaceMapper.toDto(spaceRepository.save(productToUpdate));
    }



}
