package com.oa.ais.Controllers;

import com.oa.ais.Models.Land;
import com.oa.ais.Services.LandServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Land")
public class LandController {

    @Autowired
    private LandServices landServices;

    @GetMapping("/")
    public List<Land> getAll(){
        return landServices.getAll();
    }

    @GetMapping("/{land_id}")
    public Optional<Land> getById(@PathVariable Long land_id){
        return landServices.getById(land_id);
    }

    @PostMapping("/saveAll")
    public Land saveAll(@RequestBody Land land){
        if (land.getPlots().size() == 0){
            return landServices.saveLand(land);
        }else {
            return landServices.saveLandWithPlot(land);
        }
    }

    @PostMapping("/saveLandOnly/<id>")
    public Land saveLand(@RequestBody Land land){
        return landServices.saveLand(land);
    }

    @PostMapping("/saveWithPlots")
    public Land saveData(@RequestBody Land land){
        return landServices.saveLandWithPlot(land);
    }
}
