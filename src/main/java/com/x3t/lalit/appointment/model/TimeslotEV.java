package com.x3t.lalit.appointment.model;

import com.x3t.lalit.appointment.model.enums.Timeslot;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class TimeslotEV extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Timeslot evening;

    private String fromTime;

    private String toTime;

    private String description;
}
