package com.codeknab.sportgeeks.repository;

import com.codeknab.sportgeeks.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SportEventRepository extends JpaRepository<User, Long> {
}