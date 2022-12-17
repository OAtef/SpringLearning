package com.oa.ais.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oa.ais.Models.Plot;
import com.oa.ais.Services.PlotServices;

@RestController
@RequestMapping("/Plot")
public class plotController {

    @Autowired
    private PlotServices plotServices;

    @GetMapping("/")
    public List<Plot> getAll() {
        return plotServices.getAll();
    }

    @GetMapping("/{plotID}")
    public Optional<Plot> getById(@PathVariable Long plotID) {
        return plotServices.getById(plotID);
    }

    @PostMapping("/")
    public Plot savePlot(Plot plot) {
        return plotServices.savePlot(plot);
    }
}
