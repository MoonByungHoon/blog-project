package com.example.blog_project.Contoller;

import com.example.blog_project.Dto.UserInfoDto;
import com.example.blog_project.Dto.UserTotalDto;
import com.example.blog_project.Entity.UserEntity;
import com.example.blog_project.Entity.UserInfoEntity;
import com.example.blog_project.Service.UserInfoService;
import com.example.blog_project.Service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserInfoService userInfoService;


  //  회원가입
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@RequestBody @Valid UserTotalDto userTotalDto) {
    try {
      UserEntity userEntity = userService.create(
              UserEntity.builder()
                      .username(userTotalDto.getUsername())
                      .password(userTotalDto.getPassword())
                      .build()
      );

      if (userEntity != null) {
        UserInfoEntity userInfo = userInfoService.create(
                UserInfoEntity.builder()
                        .userEntity(userEntity)
                        .nickname(userTotalDto.getNickname())
                        .age(userTotalDto.getAge())
                        .email(userTotalDto.getEmail())
                        .greetings(userTotalDto.getGreetings())
                        .build()
        );
      }
    } catch () {

    }

    return null;
  }


  @GetMapping("/info/{id}")
  public ResponseEntity<?> userList(@PathVariable(value = "id") final Long id) {

    return ResponseEntity.ok().body(userService.findUser(id));
  }
}
