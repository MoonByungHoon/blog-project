package com.example.blog_project.Contoller;

import com.example.blog_project.Dto.ResponseDTO;
import com.example.blog_project.Dto.UserDto;
import com.example.blog_project.Dto.UserInfoDto;
import com.example.blog_project.Dto.UserTotalDto;
import com.example.blog_project.Entity.UserEntity;
import com.example.blog_project.Entity.UserInfoEntity;
import com.example.blog_project.Service.UserInfoService;
import com.example.blog_project.Service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("auth")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserInfoService userInfoService;

  //  회원가입
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@RequestBody @Valid final UserTotalDto userTotalDto) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("user-persistence-unit");
    EntityManager em = emf.createEntityManager();

    log.info("회원 가입 접근 성공");
    try {
      em.getTransaction().begin();

      final UserEntity user = UserDto.toEntity(userTotalDto);
      final UserInfoEntity userInfo = UserInfoDto.toEntity(user, userTotalDto);

      user.convertUserInfo(userInfo);

      em.persist(userInfo);

      em.getTransaction().commit();

      final UserTotalDto totalDto = new UserTotalDto(user, userInfo);

      return ResponseEntity.ok().body(totalDto);
    } catch (Exception e) {
      em.getTransaction().rollback();

      ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();


      return ResponseEntity.badRequest().body(responseDTO);
    } finally {
      em.close();
      emf.close();
    }


    //userEntity 변환
//    @Valid
//    final UserEntity userEntity = userService.create(
//            UserDto.toEntity(userTotalDto)
//    );
//
//    log.info("userEntity 생성 성공");
//
//    //userInfoEntity 변환
//    final UserInfoEntity userInfo = userInfoService.create(
//            UserInfoDto.toEntity(userTotalDto)
//    );
//
//    log.info("userinfoEntity 생성 성공");
//
//    final UserTotalDto totalDto = new UserTotalDto(userEntity, userInfo);
//
//    log.info("회원가입 가입 완료");
  }

  @GetMapping("/info/{id}")
  public ResponseEntity<?> userList(@PathVariable(value = "id") final Long id) {

    return ResponseEntity.ok().body(userService.findUser(id));
  }
}
