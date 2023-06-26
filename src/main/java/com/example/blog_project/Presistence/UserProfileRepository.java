package com.example.blog_project.Presistence;

import com.example.blog_project.Entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
  boolean existsByNickname(String nickname);
}
