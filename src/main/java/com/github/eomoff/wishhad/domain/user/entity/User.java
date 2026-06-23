package com.github.eomoff.wishhad.domain.user.entity;

import com.github.eomoff.wishhad.domain.department.entity.Department;
import com.github.eomoff.wishhad.global.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 100)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, length = 50)
  private String name;

  @Column(nullable = false, unique = true, length = 50)
  private String nickname;

  @Column(nullable = false, unique = true, length = 20)
  private String employeeNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id")
  private Department department;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private UserStatus status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "approved_by_id")
  private User approvedBy;

  private Instant approvedAt;

  private User(String email, String password, String name, String nickname, String employeeNumber, Department department) {
    this.email = email;
    this.password = password;
    this.name = name;
    this.nickname = nickname;
    this.employeeNumber = employeeNumber;
    this.department = department;
    this.status = UserStatus.PENDING;
  }

  public static User register(String email, String password, String name, String nickname, String employeeNumber, Department department) {
    return new User(email, password, name, nickname, employeeNumber, department);
  }

  public void approve(User approver, Instant approvedAt) {
    this.status = UserStatus.ACTIVE;
    this.approvedBy = approver;
    this.approvedAt = approvedAt;
  }

  public void reject() {
    this.status = UserStatus.REJECTED;
  }
}
