package com.jun.event_reservation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class EventDto {
    @NotBlank(message = "Input Event")
    private String name;

    @NotNull(message = "Input Event Date")
    private LocalDateTime eventDate;

    private String location;
}
