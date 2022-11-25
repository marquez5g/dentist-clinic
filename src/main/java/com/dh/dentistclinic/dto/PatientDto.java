package com.dh.dentistclinic.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class PatientDto {
    private String name;
    private String lastName;
    private String address;
    private String dni;
    private LocalDate dischargeDate;
}
