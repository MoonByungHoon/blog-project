package com.example.blog_project.Service;

import com.example.blog_project.Entity.UserEntity;
import com.example.blog_project.Entity.UserProfileEntity;
import com.example.blog_project.Presistence.UserProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserProfileService {

  @Autowired
  private UserProfileRepository userProfileRepository;

  public UserProfileEntity create(final UserProfileEntity userProfile) {

    return userProfileRepository.save(userProfile);
  }

  public Optional<UserProfileEntity> findUser(final UserEntity userEntity) {

    return userProfileRepository.findById(userEntity.getId());
  }
}
