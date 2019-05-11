package com.codeknab.sportgeeks.repository;

import com.codeknab.sportgeeks.domain.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalisationRepository extends JpaRepository<Localisation, Long> {
}
