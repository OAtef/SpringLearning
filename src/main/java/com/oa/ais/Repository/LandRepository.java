package com.oa.ais.Repository;

import com.oa.ais.Models.Land;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandRepository extends JpaRepository<Land, Long> {

//    public List<Land> findAll();
//    @Query("FROM Land l where l.name = :name")
//    public List<Land> findAllByNameOrderByName(String name);
}
