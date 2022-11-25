package com.dh.dentistclinic.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class AppointmentDto {
    private LocalDateTime dateAndTime;
}
