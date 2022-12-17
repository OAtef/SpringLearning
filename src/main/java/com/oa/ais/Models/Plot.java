package com.oa.ais.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Plot")
@NoArgsConstructor
@Setter
@Getter
public class Plot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "plot_name")
    private String plotName;

    @ManyToOne
    @JoinColumn(name = "land_id")
    private Land land;

    // @OneToMany(mappedBy = "plot", cascade = { CascadeType.ALL })
    // @Nullable
    // private List<TimeSlot> timeSlots;

    public Plot(String plotName) {
        this.plotName = plotName;
    }

    public Plot(String plotName, Land land) {
        this.plotName = plotName;
        this.land = land;
    }

}
