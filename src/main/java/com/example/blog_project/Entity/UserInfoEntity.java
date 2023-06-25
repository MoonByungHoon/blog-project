package com.example.blog_project.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_info")
public class UserInfoEntity extends BaseTimeEntity {

  @Id
  @OneToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @Column(name = "nickname", nullable = false, length = 30, unique = true)
  private String nickname;

  @Column(name = "age", length = 3)
  private String age;

  @Column(name = "email", length = 50)
  private String email;

  @Column(name = "greetings", length = 300)
  private String greetings;

  @Column(name = "rating", length = 10)
  @ColumnDefault("1")
  private String rating;
}
