package com.github.eomoff.wishhad.domain.user.repository;

import com.github.eomoff.wishhad.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);

  Optional<User> findByEmployeeNumber(String employeeNumber);

  boolean existsByEmail(String email);

  boolean existsByNickname(String nickname);

  boolean existsByEmployeeNumber(String employeeNumber);

  boolean existsByPhoneNumber(String phoneNumber);

}
