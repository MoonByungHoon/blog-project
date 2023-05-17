package com.example.blog_project.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column (name = "id")
  private Long id;

  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "password", nullable = false, length = 256)
  private String password;

  @Column(name = "nickname", nullable = false, length = 30, unique = true)
  private String nickname;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "user_info")
  private UserInfoEntity userInfo;
  //user와 userInfo의 1:1 단방향 관계를 형성.
  //양방향이 아닌 이유는 만들고 잇는 프로젝트에서는
  //userInfo의 필요는 유저의 개인정보 수정 외에는 따로 쓰일 일이 없다.
}
