package com.example.blog_project.Entity;

import com.example.blog_project.Dto.UserTotalDto;
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

//  @JoinColumn에서 name은 DB상에서 어떤 명칭으로 저장할지를 지시하는 것이다.
//  이후 referencedColumnName 으로 인해서 해당 필드가 참조할 대상의 이름을 지정하는 것이다.
//  여기서 referencedColumnName으로 속성값을 주게되면 해당 값을 참조한다.
//  디폴트 값은 대상의 PK이므로 정규화 관점에서는 직접 다른 대상을 참조하는 것은 비추한다.
  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private UserProfileEntity userProfile;

  public UserEntity(UserTotalDto userTotalDto) {
    this.username = userTotalDto.getUsername();
    this.password = userTotalDto.getPassword();
    this.userProfile = userTotalDto.getUserProfile();
  }

  public void convertUserProfile(final UserProfileEntity userProfile){
    this.userProfile = userProfile;
  }
}
