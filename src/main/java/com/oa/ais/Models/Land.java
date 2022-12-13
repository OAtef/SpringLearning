package com.oa.ais.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Land")
@Setter
@Getter
@NoArgsConstructor
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Land {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "land_name")
    private String name;

//    @Transient
//    @JsonIgnore
    @OneToMany(mappedBy = "land")
    private List<Plot> plots;

    public Land(String name) {
        this.name = name;
    }
}
