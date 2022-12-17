package com.oa.ais.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.jetbrains.annotations.Nullable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Land")
@Setter
@Getter
@NoArgsConstructor
public class Land {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "land_name")
    private String name;

    @OneToMany(mappedBy = "land")
    @Nullable
    private List<Plot> plots;

    public Land(String name) {
        this.name = name;
    }
}
