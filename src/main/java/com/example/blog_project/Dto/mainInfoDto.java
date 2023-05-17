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
public class mainInfoDto {

  private Long id;
  private String visitantIp;
  private Long dayUniqueVisitor;
  private LocalDateTime createdDate;
  private LocalDateTime modifiedDate;
}
