package com.example.blog_project.Dto;

import com.example.blog_project.Entity.UserEntity;
import com.example.blog_project.Entity.UserProfileEntity;
import jakarta.validation.constraints.Email;
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
public class UserDto {

  private Long id;
  @NotBlank
  @Email(message = "이메일 형식이 아닙니다.")
  private String username;
  //회원가입의 username은 email형식으로 받기!.

  @NotBlank
  private String password;
  private UserProfileEntity userProfile;
  private LocalDateTime createdDate;
  private LocalDateTime modifiedDate;

  public UserDto(UserEntity user) {
    this.id = user.getId();
    this.username = user.getUsername();
  }

  public static UserEntity toEntity(final UserTotalDto userTotalDto) {

    log.info("dto 진입");

    return UserEntity.builder()
            .username(userTotalDto.getUsername())
            .password(userTotalDto.getPassword())
            .build();
  }

}
