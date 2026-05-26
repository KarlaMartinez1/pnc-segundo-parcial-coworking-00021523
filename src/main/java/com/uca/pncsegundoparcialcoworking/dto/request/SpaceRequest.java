package com.uca.pncsegundoparcialcoworking.dto.request;

import com.uca.pncsegundoparcialcoworking.entities.SpaceType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpaceRequest {
    @NotBlank(message = "Space name cannot be empty.")
    private String name;

    private String description;

    @NotNull
    private SpaceType spaceType;

    @NotNull
    @Min(value = 0, message = "Capacity min = 1")
    private Integer capacity;

    @NotNull(message = "price cant be empty")
    @DecimalMin(value = "0.01", message = "Price cannot be 0.00")
    private BigDecimal pricePerHour;
    //avaiable segun ocupacion

    @NotNull
    @Min(value = 0 , message = "Floor should be upper than 0")
    private Integer floor;

    private String amenities;

}

