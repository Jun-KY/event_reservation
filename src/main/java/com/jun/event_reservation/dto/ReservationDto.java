package com.jun.event_reservation.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ReservationDto {
    @NotBlank(message = "Input reservation person name")
    private String attendeeName;

    @Min(1)
    @NotNull(message = "Input number of persons")
    private Integer seats;
}
