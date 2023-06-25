package com.example.blog_project.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "username", nullable = false, length = 20, unique = true)
  private String username;

  @Column(name = "password", nullable = false, length = 256)
  private String password;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserInfoEntity userInfo;

  public void convertUserInfo(final UserInfoEntity userInfo){
    this.userInfo = userInfo;
  }
}
