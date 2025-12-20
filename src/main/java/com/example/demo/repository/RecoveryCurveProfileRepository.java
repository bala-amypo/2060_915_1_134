package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;

public interface RecoveryCurveProfileRepository {
    List<RecoveryCurveProfile> findBySurgeryTypeOrderByDayNumberAsc(String type);
    List<RecoveryCurveProfile> findAll();
    RecoveryCurveProfile save(RecoveryCurveProfile r);

}
