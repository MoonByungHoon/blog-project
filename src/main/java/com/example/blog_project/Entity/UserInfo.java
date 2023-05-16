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
public class UserInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "age", length = 3)
  private String age;

  @Column(name = "email", length = 50)
  private String email;

  @Column(name = "greetings", length = 300)
  private String greetings;
}
