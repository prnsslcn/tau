package com.jobfair.booth.service;

import com.jobfair.booth.model.Application;
import com.jobfair.booth.model.Booth;
import com.jobfair.booth.repository.ApplicationRepository;
import com.jobfair.booth.repository.BoothRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final BoothRepository boothRepository;

    @Transactional
    public Application register(Application application, Long boothId) {
        Booth booth = boothRepository.findById(boothId)
                .orElseThrow(() -> new IllegalArgumentException("Booth not found"));

        application.setBooth(booth);

        // 중복 신청 1: 같은 부스 중복
        if (applicationRepository.existsByNameAndPhoneAndBooth(
                application.getName(),
                application.getPhone(),
                booth
        )) {
            throw new IllegalArgumentException("Booth already exists");
        }

        // 중복 신청 2: 같은 시간에 다른 부스 신청
        if (applicationRepository.existsByNameAndPhoneAndTimeSlot(
                application.getName(),
                application.getPhone(),
                application.getTimeSlot()
        )) {
            throw new IllegalArgumentException("TimeSlot already exists");
        }

        return applicationRepository.save(application);
    }

    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    public Optional<Booth> getBooth(Long id) {
        return boothRepository.findById(id);
    }

    public List<Booth> getAllBooths() {
        return boothRepository.findAll();
    }
}
