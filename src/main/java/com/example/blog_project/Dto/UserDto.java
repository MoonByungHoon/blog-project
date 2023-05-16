package com.example.blog_project.Dto;

import com.example.blog_project.Entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

  private Long id;
  private String username;
  private String password;
  private String nickname;
  private UserInfo userInfo;
  private LocalDateTime createdDate;
  private LocalDateTime modifiedDate;
}
