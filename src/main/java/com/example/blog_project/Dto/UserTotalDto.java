package com.example.blog_project.Dto;

import com.example.blog_project.Entity.UserEntity;
import com.example.blog_project.Entity.UserInfoEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserTotalDto {

  //user
  private Long id;
  @NotBlank
  private String username;
  @NotBlank
  private String password;
  private UserEntity user;

  //userInfo
  @NotBlank
  private String nickname;
  private String age;
  private String greetings;
  private String rating;
  private UserInfoEntity userInfo;

  //dateTime
  private LocalDateTime createdDate;
  private LocalDateTime modifiedDate;

  public UserTotalDto(final UserEntity userEntity, final UserInfoEntity userInfo) {
    this.id = userEntity.getId();
    this.username = userEntity.getUsername();
    this.password = userEntity.getPassword();
    this.nickname = userInfo.getNickname();
    this.age = userInfo.getAge();
    this.greetings = userInfo.getGreetings();
    this.rating = userInfo.getRating();
    this.createdDate = userEntity.getCreateDate();

    if (userEntity.getModifiedDate().isAfter(userInfo.getModifiedDate())) {
      this.modifiedDate = userEntity.getModifiedDate();
    } else {
      this.modifiedDate = userInfo.getModifiedDate();
    }
  }
}
