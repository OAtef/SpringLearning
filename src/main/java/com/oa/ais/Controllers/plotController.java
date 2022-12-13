package com.oa.ais.Controllers;

import com.oa.ais.Models.Plot;
import com.oa.ais.Services.PlotServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Plot")
public class plotController {

    @Autowired
    private PlotServices plotServices;

    @GetMapping("/")
    public List<Plot> getAll(){
        return plotServices.getAll();
    }

    @GetMapping("/{land_id}")
    public Optional<Plot> getById(Long id){
        return plotServices.getById(id);
    }

    @PostMapping("/")
    public Plot savePlot(Plot plot){
        return plotServices.savePlot(plot);
    }
}
