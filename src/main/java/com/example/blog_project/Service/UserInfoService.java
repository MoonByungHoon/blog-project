package com.example.blog_project.Service;

import com.example.blog_project.Entity.UserEntity;
import com.example.blog_project.Entity.UserInfoEntity;
import com.example.blog_project.Presistence.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserInfoService {

  @Autowired
  private UserInfoRepository userInfoRepository;

  public UserInfoEntity create(final UserInfoEntity userInfo) {

    return userInfoRepository.save(userInfo);
  }

  public Optional<UserInfoEntity> findUser(final UserEntity userEntity) {

    return userInfoRepository.findById(userEntity.getId());
  }
}
