package com.oa.ais.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oa.ais.Models.Land;
import com.oa.ais.Services.LandServices;

@RestController
@RequestMapping("/Land")
public class LandController {

    @Autowired
    private LandServices landServices;

    @GetMapping("/")
    public List<Land> getAll() {
        return landServices.getAll();
    }

    @GetMapping("/{landId}")
    public Optional<Land> getById(@PathVariable Long landId) {
        return landServices.getById(landId);
    }

    @PostMapping("/saveAll")
    public Land saveAll(@RequestBody Land land) {
        if (land.getPlots().isEmpty()) {
            return landServices.saveLand(land);
        } else {
            return landServices.saveLandWithPlot(land);
        }
    }

    @PostMapping("/saveLandOnly")
    public Land saveLand(@RequestBody Land land) {
        return landServices.saveLand(land);
    }

    @PostMapping("/saveWithPlots")
    public Land saveData(@RequestBody Land land) {
        return landServices.saveLandWithPlot(land);
    }
}
