package com.example.blog_project.Entity;

import com.example.blog_project.Dto.UserTotalDto;
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
public class UserProfileEntity extends BaseTimeEntity {

  @Id
  private Long userid;

  @Column(name = "nickname", nullable = false, length = 30, unique = true)
  private String nickname;

  @Column(name = "age", length = 3)
  private String age;

  @Column(name = "greetings", length = 300)
  private String greetings;

  @Column(name = "rating", length = 10)
  private String rating;

//  @MapsId로 인해서 Id 필드를 아래 필드로 사용하겠다고 지정하는 것이다.
//  고로 DB상에는 위에 @Id로 지정한 id가 아닌 아래 지정된 user_id로 생성이 된다.
  @OneToOne
  @MapsId
  @JoinColumn(name = "user_id")
  private UserEntity user;


  public UserProfileEntity(UserEntity user, UserTotalDto userTotalDto) {
    this.user = user;
    this.nickname = userTotalDto.getNickname();
    this.age = userTotalDto.getAge();
    this.greetings = userTotalDto.getGreetings();
    this.rating = userTotalDto.getRating();
  }

//  persist로 저장을 시도시에 무조건 아래 어노테이션으로 인해서 해당 코드가 진행되게 되는데
//  EntityManager를 이용시에 Entity에 별도로 초기값을 지정해줘도 인지를 못한다.
//  그래서 해당 코드가 필요하다. 이런 용도 외에 별도로 if나 for문같은 조건이나 반복등을 넣어서
//  별도의 명령 수행이 가능하다.
  @PrePersist
  public void prePersist(){
    this.rating = "1";
  }
}
