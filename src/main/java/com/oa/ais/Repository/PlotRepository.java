package com.oa.ais.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oa.ais.Models.Plot;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Long> {

    // public List<Plot> findAll();

}
