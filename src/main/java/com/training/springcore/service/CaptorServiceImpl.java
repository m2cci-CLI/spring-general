package com.training.springcore.service;

import com.training.springcore.model.Captor;
import com.training.springcore.model.Measure;
import com.training.springcore.service.measure.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("captorService")
public class CaptorServiceImpl implements CaptorService{

    @Autowired
    private MeasureService fixedMeasureService; //getter et setter sous_entendu

    @Autowired
    private MeasureService realMeasureService;

    @Autowired
    private MeasureService simulatedMeasureService;

    public CaptorServiceImpl(MeasureService fixedMeasureService, MeasureService realMeasureService, MeasureService simulatedMeasureService){
        this.fixedMeasureService = fixedMeasureService;
        this.realMeasureService = realMeasureService;
        this.simulatedMeasureService = simulatedMeasureService;
    }

    @Override
    public Set<Captor> findBySite(String siteId) {
        Set<Captor> captors = new HashSet<>();
        if (siteId == null) {
            return captors;
        }
        captors.add(new Captor("Capteur A"));
        return captors;
    }
}
