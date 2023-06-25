package com.example.blog_project.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
//엔티티의 CRU 작업에 대해서 이를 감지하고 이벤트 처리를 하기 위한 어노테이션.
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

  @CreatedDate
  @Column(name = "created_date", nullable = false)
  private LocalDateTime createDate;

  @LastModifiedDate
  @Column(name = "modified_date", nullable = false)
  private LocalDateTime modifiedDate;
}
