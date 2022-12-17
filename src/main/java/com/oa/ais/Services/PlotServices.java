package com.oa.ais.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.ais.Models.Plot;
import com.oa.ais.Models.TimeSlot;
import com.oa.ais.Repository.PlotRepository;

@Service
public class PlotServices {

    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private TimeSlotServices timeSlotService;

    public List<Plot> getAll() {
        return plotRepository.findAll();
    }

    public Optional<Plot> getById(Long id) {
        return plotRepository.findById(id);
    }

    public Plot savePlot(Plot plot) {
        return plotRepository.save(plot);
    }

    public List<Plot> saveAllPlots(List<Plot> plots) {
        return plotRepository.saveAll(plots);
    }

    public void irregatePlot(Plot plot) {
        List<TimeSlot> plotSlots = timeSlotService.getAllByPlot(plot.getId());

        for (TimeSlot slot : plotSlots) {
            // System.out.println("Checking Irrigation for slot with last checked: " + slot.getLastChecked() + " - " + LocalDateTime.now());
            // System.out.println("Checking Irrigation for slot with last checked: " + slot.getLastChecked().plusHours(slot.getIrregationFrequency()) + " - " + LocalDateTime.now());
            // System.out.println(slot.getLastChecked().plusHours(slot.getIrregationFrequency()).isBefore(LocalDateTime.now()));
            if (slot.getLastChecked().plusHours(slot.getIrregationFrequency()).isEqual(LocalDateTime.now())
                    || slot.getLastChecked().plusHours(slot.getIrregationFrequency()).isBefore(LocalDateTime.now())) {
                // should irregate with required water amount
                slot.setLastChecked(LocalDateTime.now());
                timeSlotService.saveTimeSlot(slot);
            }
        }
    }

    // public Plot saveLandWithPlot(Plot plotReq) {
    // Plot plot = new Plot(plotReq.getPlotName());
    // plot = plotRepository.save(plot);

    // List<TimeSlot> assignedTimeSlots = new ArrayList<>();

    // for (TimeSlot ts : plotReq.getTimeSlots()) {
    // ts.setPlot(plot);
    // // plotServices.savePlot(p);

    // TimeSlot timeSlot = new TimeSlot(ts.getStartTime(), ts.getEndTime(), plot);
    // timeSlot = timeSlotService.savePlot(plot);
    // assignedTimeSlots.add(plot);
    // }
    // // plotServices.saveAllPlots(landReq.getPlots());

    // plotReq.setPlots(assignedTimeSlots);
    // plotReq.setId(plot.getId());
    // return plotReq;
    // }
}
