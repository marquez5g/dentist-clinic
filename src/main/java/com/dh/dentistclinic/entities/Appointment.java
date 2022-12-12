package com.dh.dentistclinic.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Appointment {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    private String dateAndTime;
    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Dentist dentist;
}
