package com.x3t.lalit.appointment.model;

import com.x3t.lalit.appointment.model.enums.Timeslot;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Appointment extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Engineer engineer1;

    @ManyToOne
    private Engineer engineer2;

    @Enumerated(EnumType.STRING)
    private Timeslot timeslot;

    @ManyToOne
    private AppointmentDate appointmentDate;
}
