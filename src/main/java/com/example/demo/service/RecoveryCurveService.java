package com.example.demo.service;

import com.example.demo.model.RecoveryCurveProfile;

import java.util.Optional;

public interface RecoveryCurveService {

    RecoveryCurveProfile createCurve(RecoveryCurveProfile profile);

    Optional<RecoveryCurveProfile> getCurveBySurgeryType(String surgeryType);
}
