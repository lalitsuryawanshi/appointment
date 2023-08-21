package com.x3t.lalit.appointment.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@ToString
public class AppointmentDate extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SharedCalendar calendarDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appointmentDate")
    private Set<Appointment> appointments = new HashSet<>();

}
