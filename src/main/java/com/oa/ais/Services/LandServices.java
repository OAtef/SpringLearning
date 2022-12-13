package com.oa.ais.Services;

import com.oa.ais.Models.Land;
import com.oa.ais.Models.Plot;
import com.oa.ais.Repository.LandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

//        List<Plot> assignedPlots = new ArrayList<>();

        for (Plot p : landReq.getPlots()) {
            p.setLand(land);
//            plotServices.savePlot(p);

//            Plot plot = new Plot(p.getPlotName(), land);
//            plot = plotServices.savePlot(plot);
//            assignedPlots.add(plot);
        }

        plotServices.saveAllPlots(landReq.getPlots());

//        landReq.setPlots(assignedPlots);
        landReq.setId(land.getId());
        return landReq;
    }


//    public void addPlot(Plot plot){
//        if (plots == null){
//            plots = new ArrayList<>();
//        }
//
//        plots.add(plot);
//    }


}
