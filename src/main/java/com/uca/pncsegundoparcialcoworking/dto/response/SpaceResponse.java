package com.uca.pncsegundoparcialcoworking.dto.response;

import com.uca.pncsegundoparcialcoworking.entities.SpaceType;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class SpaceResponse {
    private Long id;
    private String name;
    private String description;
    private SpaceType spaceType;
    private Integer capacity;
    private BigDecimal pricePerHour;
    private Boolean available;
    private Integer floor;
    private String amenities;
}
