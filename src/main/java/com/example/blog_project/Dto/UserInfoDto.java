package com.example.blog_project.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {

  private Long id;
  private String age;
  private String email;
  private String greetings;
  private LocalDateTime createdDate;
  private LocalDateTime modifiedDate;
}
