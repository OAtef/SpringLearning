package com.oa.ais.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.ais.Models.TimeSlot;
import com.oa.ais.Repository.TimeSlotRepository;

@Service
public class TimeSlotServices {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    public List<TimeSlot> getAll() {
        return timeSlotRepository.findAll();
    }

    public Optional<TimeSlot> getById(Long id) {
        return timeSlotRepository.findById(id);
    }

    public TimeSlot saveTimeSlot(TimeSlot timeSlot) {
        return timeSlotRepository.save(timeSlot);
    }

    public List<TimeSlot> getAllByPlot(Long plotId) {
        return timeSlotRepository.findAllByPlotId(plotId);
    }
}
