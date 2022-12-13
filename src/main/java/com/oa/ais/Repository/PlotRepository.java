package com.oa.ais.Repository;

import com.oa.ais.Models.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Long> {

//    public List<Plot> findAll();
}
