package HS_hrs.user_service.Entity;

import java.time.LocalDateTime;



import HS_hrs.user_service.Entity.Enum.EmploymentStatus;
import HS_hrs.user_service.Entity.Enum.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; 
  // 내부 식별자

  @Column(name = "user_id", unique = true)
  private Integer userId; 
  // MSA에서 사용하는 사용자 식별자(서비스 연동할 때 사용)
  
  @Column(nullable = true, length = 50, unique = true)
  private String username;

  @Column(nullable = true, length = 255)
  private String password;

  @Column(unique = true, nullable = true, length = 100)
  private String email;

  @Column(name = "phone_number", length = 20)
  private String phoneNumber;

  @Enumerated(EnumType.STRING)
  @Column(name = "user_type", nullable = true)
  private UserType userType; 
  // admin, employee

  @Enumerated(EnumType.STRING)
  @Column(name = "employment_status", nullable = true)
  private EmploymentStatus employmentStatus; 
  // employed, resigned, on_leave

  @Column(name = "created_at", nullable = true, updatable = false)
  private LocalDateTime createdAt;
  // 아이디 생성일

  @Column(name = "updated_at", nullable = true)
  private LocalDateTime updatedAt;


  public static User createWithUserId(Integer userId) {
    User user = new User();
    user.userId = userId;
    return user;
  }
}