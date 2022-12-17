package com.oa.ais.cron;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.oa.ais.Models.Plot;
import com.oa.ais.Services.PlotServices;

@Configuration
@EnableScheduling
public class IrregationScheduler {

    @Autowired
    private PlotServices plotServices;

    @Scheduled(fixedRate = 1000)
    public void checkIrrigation() {
        // System.out.println("Checking Irrigation");
        List<Plot> allPlots = plotServices.getAll();

        for (Plot plot : allPlots) {
            // System.out.println("Checking Irrigation for plot: " + plot.getPlotName());
            plotServices.irregatePlot(plot);
        }

    }
}
