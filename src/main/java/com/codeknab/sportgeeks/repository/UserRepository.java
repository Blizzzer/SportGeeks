package com.codeknab.sportgeeks.repository;

import com.codeknab.sportgeeks.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByUserUID(String uid);
}
