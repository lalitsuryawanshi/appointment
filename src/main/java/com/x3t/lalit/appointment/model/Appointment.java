package com.x3t.lalit.appointment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.x3t.lalit.appointment.model.enums.Timeslot;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode(exclude = {"engineers"}, callSuper = false)
public class Appointment extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appointment")
    @JsonIgnore  // ignore to avoid recursive fetching
    private Set<Engineer> engineers = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Timeslot timeslot;

}
