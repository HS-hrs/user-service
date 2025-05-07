package HS_hrs.user_service.Entity;

import java.time.LocalDateTime;

import HS_hrs.user_service.Entity.Enum.Gender;
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
@Table(name = "user_profiles")
@Getter
public class UserProfile {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @Column(name = "user_id", nullable = false)
  private Integer userId;

  @Column(name = "birth_date", nullable = false)
  private LocalDateTime birthDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "gender", nullable = false)
  private Gender gender; // male, female  

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "profile_image_url")
  private String profileImageUrl;
  
  
  

} 
