package com.example.blog_project.Dto;

import com.example.blog_project.Entity.UserEntity;
import com.example.blog_project.Entity.UserProfileEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class UserProfileDto {

  @NotBlank
  private Long id;
  private String nickname;
  private String age;
  private String greetings;
  private String rating;
  private LocalDateTime createdDate;
  private LocalDateTime modifiedDate;

  public static UserProfileEntity toEntity(final UserEntity userEntity, final UserTotalDto userTotalDto) {

    return UserProfileEntity.builder()
            .user(userEntity)
            .nickname(userTotalDto.getNickname())
            .age(userTotalDto.getAge())
            .greetings(userTotalDto.getGreetings())
            .rating(userTotalDto.getRating())
            .build();
  }
}
