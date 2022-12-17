package com.oa.ais.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.ais.Models.Land;
import com.oa.ais.Models.Plot;
import com.oa.ais.Repository.LandRepository;

@Service
public class LandServices {

    @Autowired
    private LandRepository landRepository;

    @Autowired
    private PlotServices plotServices;

    public List<Land> getAll() {
        return landRepository.findAll();
    }

    public Optional<Land> getById(Long id) {
        return landRepository.findById(id);
    }

    public Land saveLand(Land land) {
        return landRepository.save(land);
    }

    public Land saveLandWithPlot(Land landReq) {
        Land land = new Land(landReq.getName());
        land = landRepository.save(land);

        List<Plot> assignedPlots = new ArrayList<>();

        for (Plot p : landReq.getPlots()) {
            p.setLand(land);

            Plot plot = new Plot(p.getPlotName(), land);
            plot = plotServices.savePlot(plot);
            assignedPlots.add(plot);
        }

        landReq.setPlots(assignedPlots);
        landReq.setId(land.getId());
        return landReq;
    }

}
