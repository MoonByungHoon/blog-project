package com.example.blog_project.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_info")
public class UserInfoEntity extends BaseTimeEntity {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "nickname", nullable = false, length = 30, unique = true)
  private String nickname;

  @Column(name = "age", length = 3)
  private String age;

  @Column(name = "email", length = 50)
  private String email;

  @Column(name = "greetings", length = 300)
  private String greetings;

  @OneToOne
  @MapsId
  @JoinColumn(name = "id", referencedColumnName = "id")
  private UserEntity userEntity;
}
