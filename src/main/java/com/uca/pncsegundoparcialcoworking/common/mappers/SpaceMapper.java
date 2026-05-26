package com.uca.pncsegundoparcialcoworking.common.mappers;

import com.uca.pncsegundoparcialcoworking.dto.request.SpaceRequest;
import com.uca.pncsegundoparcialcoworking.dto.request.UpdateSpaceRequest;
import com.uca.pncsegundoparcialcoworking.dto.response.SpaceResponse;
import com.uca.pncsegundoparcialcoworking.entities.Space;
import org.springframework.stereotype.Component;

@Component
public class SpaceMapper {
    public Space toEntityCreate(SpaceRequest request){
        return Space.builder()
                .name(request.getName())
                .description(request.getDescription())
                .spaceType(request.getSpaceType())
                .capacity(request.getCapacity())
                .pricePerHour(request.getPricePerHour())
                .available(request.getCapacity() > 0)
                .floor(request.getFloor())
                .amenities(request.getAmenities())
                .build();
    }

    public Space toEntityUpdate(UpdateSpaceRequest request, Long id){
        return Space.builder()
                .id(id)
                .name(request.getName())
                .description(request.getDescription())
                .spaceType(request.getSpaceType())
                .capacity(request.getCapacity())
                .pricePerHour(request.getPricePerHour())
                .available(request.isAvailable())
                .floor(request.getFloor())
                .amenities(request.getAmenities())
                .build();
    }

    public SpaceResponse toDto(Space space){
        return SpaceResponse.builder()
                .id(space.getId())
                .name(space.getName())
                .description(space.getDescription())
                .spaceType(space.getSpaceType())
                .capacity(space.getCapacity())
                .pricePerHour(space.getPricePerHour())
                .available(space.getAvailable())
                .floor(space.getFloor())
                .amenities(space.getAmenities())
                .build();
    }

}

