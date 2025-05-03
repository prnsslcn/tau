package com.jobfair.booth.repository;

import com.jobfair.booth.model.Application;
import com.jobfair.booth.model.Booth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    // 1. 같은 이름 + 연락처 + 부스 -> 중복 신청 방지
    boolean existsByNameAndPhoneAndBooth(String name, String phone, Booth booth);

    // 2. 같은 이름 + 연락처 + 같은 시간대 -> 다른 부스도 중복 신청 방지
    boolean existsByNameAndPhoneAndTimeSlot(String name, String phone, LocalTime timeSlot);
}
