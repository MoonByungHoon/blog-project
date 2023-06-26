package com.example.blog_project.Dto;

import com.example.blog_project.Entity.UserEntity;
import com.example.blog_project.Entity.UserProfileEntity;
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

  //userProfile
  @NotBlank
  private String nickname;
  private String age;
  private String greetings;
  private String rating;
  private UserProfileEntity userProfile;

  //dateTime
  private LocalDateTime createdDate;
  private LocalDateTime modifiedDate;

  public UserTotalDto(final UserEntity userEntity) {
    this.id = userEntity.getId();
    this.username = userEntity.getUsername();
    this.nickname = userEntity.getUserProfile().getNickname();
    this.age = userEntity.getUserProfile().getAge();
    this.greetings = userEntity.getUserProfile().getGreetings();
    this.rating = userEntity.getUserProfile().getRating();
    this.createdDate = userEntity.getCreateDate();

    if(userEntity.getModifiedDate().isAfter(userEntity.getUserProfile().getModifiedDate())){
      this.modifiedDate = userEntity.getModifiedDate();
    } else {
      this.modifiedDate = userEntity.getUserProfile().getModifiedDate();
    }
  }

//  public UserTotalDto(final UserEntity userEntity, final UserProfileEntity userProfile) {
//    this.id = userEntity.getId();
//    this.username = userEntity.getUsername();
//    this.password = userEntity.getPassword();
//    this.nickname = userProfile.getNickname();
//    this.age = userProfile.getAge();
//    this.greetings = userProfile.getGreetings();
//    this.rating = userProfile.getRating();
//    this.createdDate = userEntity.getCreateDate();
//
//    if (userEntity.getModifiedDate().isAfter(userProfile.getModifiedDate())) {
//      this.modifiedDate = userEntity.getModifiedDate();
//    } else {
//      this.modifiedDate = userProfile.getModifiedDate();
//    }
//  }
}
