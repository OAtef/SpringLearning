package com.oa.ais.Services;

import com.oa.ais.Models.Plot;
import com.oa.ais.Repository.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlotServices {

    @Autowired
    private PlotRepository plotRepository;

    public List<Plot> getAll(){
        return plotRepository.findAll();
    }

    public Optional<Plot> getById(Long id){
        return plotRepository.findById(id);
    }

    public Plot savePlot(Plot plot){
        return plotRepository.save(plot);
    }

    public List<Plot> saveAllPlots(List<Plot> plots){
        return plotRepository.saveAll(plots);
    }
}
