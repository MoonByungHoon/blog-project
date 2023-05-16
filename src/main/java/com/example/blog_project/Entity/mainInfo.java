package com.example.blog_project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "main_info")
public class mainInfo extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "visitant_ip")
  private String visitantIp;

  @Column(name = "day_unique_visitor")
  private Long dayUniqueVisitor;
}
