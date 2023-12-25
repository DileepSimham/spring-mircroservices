package com.infosys.poolcarz.fare.repository;

import com.infosys.poolcarz.fare.entity.FareDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FareRepository extends JpaRepository<FareDetailsEntity, Integer> {
    public FareDetailsEntity findBySourceAndDestination(String source, String destination);
}
