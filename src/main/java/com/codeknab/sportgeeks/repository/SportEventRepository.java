package com.codeknab.sportgeeks.repository;

import com.codeknab.sportgeeks.domain.SportEvent;
import com.codeknab.sportgeeks.enums.SportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SportEventRepository extends JpaRepository<SportEvent, Long> {
    List<SportEvent> findAllBySportType(SportType sportType);
}
