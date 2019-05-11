package com.codeknab.sportgeeks.repository;

import com.codeknab.sportgeeks.domain.SportEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SportEventRepository extends JpaRepository<SportEvent, Long> {
}
