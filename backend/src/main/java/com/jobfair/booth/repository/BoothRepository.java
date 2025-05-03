package com.jobfair.booth.repository;

import com.jobfair.booth.model.Booth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoothRepository extends JpaRepository<Booth, Long> {
}
