package com.example.blog_project.Contoller;

import com.example.blog_project.Dto.UserTotalDto;
import com.example.blog_project.Entity.UserEntity;
import com.example.blog_project.Service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("auth")
public class UserController {

  @Autowired
  private UserService userService;

  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  //  회원가입
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@RequestBody @Valid final UserTotalDto userTotalDto) {

    userTotalDto.setPassword(passwordEncoder.encode(userTotalDto.getPassword()));

    if(userService.isUserExists(userTotalDto)) {

      return ResponseEntity.badRequest().body("중복된 가입시도로 회원가입 실패");
    } else {
      UserEntity user = userService.registerUser(userTotalDto);

      UserTotalDto totalDto = new UserTotalDto(user);

      return ResponseEntity.ok().body(totalDto);
    }
  }

  @GetMapping("/info/{id}")
  public ResponseEntity<?> userList(@PathVariable(value = "id") final Long id) {

    return ResponseEntity.ok().body(userService.findUser(id));
  }
}
