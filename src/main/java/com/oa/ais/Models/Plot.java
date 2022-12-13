package com.oa.ais.Models;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="Plot")
//@Data
//@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Plot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

//    @Column(name="creation_time")
//    @Nullable
//    private LocalDateTime creationTime;
//
////    @Column(name="update_time")
//    @Nullable
//    private LocalDateTime updateTime;
//    @Column(name="plot_name")
    private String plotName;

    @ManyToOne
    @JoinColumn(name = "land_id")
    private Land land;

    public Plot(String plotName, Land land) {
        this.plotName = plotName;
        this.land = land;
    }

    //    bi-directional which means i could get the slots using plot and get the plot using slots
//    @OneToMany(mappedBy = "plot", cascade = {CascadeType.ALL})
//    @Nullable
//    private List<TimeSlot> timeSlots;

//    @OneToMany()
//    @JoinColumn(name = "plot_id")
//    @Nullable
//    private List<TimeSlot> timeSlots;
//
//    public void addTimeSlot(TimeSlot timeSlot){
//
//        if (timeSlots == null){
//            timeSlots = new ArrayList<>();
//        }
//
//        timeSlots.add(timeSlot);
//    }
}
