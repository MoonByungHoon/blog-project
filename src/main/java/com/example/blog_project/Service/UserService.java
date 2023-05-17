package com.example.blog_project.Service;

import com.example.blog_project.Entity.UserEntity;
import com.example.blog_project.Presistence.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public UserEntity read(Long id) {
    UserEntity user = userRepository.findById(Long id);
  }
}
