package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.example.demo.repository.RecoveryCurveProfileRepository;
import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.service.RecoveryCurveService;

@Service
@RequiredArgsConstructor
public class RecoveryCurveServiceImpl implements RecoveryCurveService {

    private final RecoveryCurveProfileRepository repository;

    @Override
    public List<RecoveryCurveProfile> getCurveForSurgery(String surgeryType) {
        return repository.findBySurgeryTypeOrderByDayNumberAsc(surgeryType);
    }

    @Override
    public List<RecoveryCurveProfile> getAllCurves() {
        return repository.findAll();
    }
}
