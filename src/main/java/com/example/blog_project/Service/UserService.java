package com.example.blog_project.Service;

import com.example.blog_project.Entity.UserEntity;
import com.example.blog_project.Presistence.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public UserEntity create(final UserEntity userEntity) {

    return userRepository.save(userEntity);
  }

  public Optional<UserEntity> findUser(final Long id) {

    return userRepository.findById(id);
  }
}
