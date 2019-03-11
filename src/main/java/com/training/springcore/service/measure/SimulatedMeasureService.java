package com.training.springcore.service.measure;

import com.training.springcore.model.Captor;
import com.training.springcore.model.Measure;
import com.training.springcore.model.MeasureStep;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service("simulatedMeasureService")
public class SimulatedMeasureService implements MeasureService {

    @Value("${bigcorp.measure.default-simulated}")
    private Integer defaultMeasure;

    @Override
    public List<Measure> readMeasures(Captor captor, Instant start, Instant end, MeasureStep step) {
        checkReadMeasuresAgrs(captor,start,end,step);
        List<Measure> measures = new ArrayList<>();
        Instant current = start;
        while(current.isBefore(end)){
            measures.add(new Measure(current, defaultMeasure, captor));
            current = current.plusSeconds(step.getDurationInSecondes());
        }
        return measures;
    }

}
