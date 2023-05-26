package com.example.blog_project.Dto;

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
  @NotBlank
  private String nickname;
  private UserInfoEntity userInfo;

  //userInfo
  @NotBlank
  private String age;
  @NotBlank
  private String email;
  private String greetings;

  //dateTime
  private LocalDateTime createdDate;
  private LocalDateTime modifiedDate;

}
