package com.uca.pncsegundoparcialcoworking.service;


import com.uca.pncsegundoparcialcoworking.dto.request.SpaceRequest;
import com.uca.pncsegundoparcialcoworking.dto.request.UpdateSpaceRequest;
import com.uca.pncsegundoparcialcoworking.dto.response.SpaceResponse;
import com.uca.pncsegundoparcialcoworking.entities.SpaceType;

import java.util.List;

public interface SpaceService {
    SpaceResponse createSpace(SpaceRequest request);
    List<SpaceResponse> getAllSpaces(SpaceType spaceType, Boolean available);
    SpaceResponse getSpaceById(Long id);
    SpaceResponse updateSpace(UpdateSpaceRequest request, Long id);
    SpaceResponse deleteSpace(Long id);
}
