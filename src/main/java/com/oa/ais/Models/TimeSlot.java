package com.oa.ais.Models;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="start_datetime")
    @Nullable
    private LocalDateTime startDateTime;

    @Column(name="end_datetime")
    @Nullable
    private LocalDateTime endDateTime;

    @Column(name="water_required")
    private Double waterRequired;

//    in case of bi-directional we need to set this
//    @ManyToOne
//    @JoinColumn(name = "plot_id")
//    @Nullable
//    private Plot plot;

}
