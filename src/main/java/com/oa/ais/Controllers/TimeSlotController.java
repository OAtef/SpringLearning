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

import com.oa.ais.Models.TimeSlot;
import com.oa.ais.Services.TimeSlotServices;

@RestController
@RequestMapping("/timeSlot")
public class TimeSlotController {

    @Autowired
    private TimeSlotServices timeslotService;

    @GetMapping("/")
    public List<TimeSlot> getAll() {
        return timeslotService.getAll();
    }

    @GetMapping("/{timeSlotId}")
    public Optional<TimeSlot> getById(@PathVariable Long timeSlotId) {
        return timeslotService.getById(timeSlotId);
    }

    @PostMapping("/")
    public TimeSlot savePlot(@RequestBody TimeSlot timeSlot) {
        return timeslotService.saveTimeSlot(timeSlot);
    }

}
