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

  @Column(name = "user_id", unique = true)
  private Integer userId;
  
  @Column(nullable = false, length = 50, unique = true)
  private String usernmae;

  @Column(nullable = false, length = 255)
  private String password;

  @Column(unique = true, nullable = false, length = 100)
  private String email;

  @Column(name = "phone_number", length = 20)
  private String phoneNumber;

  @Enumerated(EnumType.STRING)
  @Column(name = "user_type", nullable = false)
  private UserType userType; // admin, employee

  @Enumerated(EnumType.STRING)
  @Column(name = "employment_status", nullable = false)
  private EmploymentStatus employmentStatus; // employed, resigned, on_leave

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;
}
