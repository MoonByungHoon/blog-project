package com.example.blog_project.Service;

import com.example.blog_project.Dto.UserTotalDto;
import com.example.blog_project.Entity.UserEntity;
import com.example.blog_project.Entity.UserProfileEntity;
import com.example.blog_project.Presistence.UserProfileRepository;
import com.example.blog_project.Presistence.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

  //  스프링부트에서는 EntityManagerFactory가 없어도
//  자동으로 생성하고 관리해주기 때문에 별도로 생성할 필요가 없다.
  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserProfileRepository userProfileRepository;

  @Transactional
  public UserEntity registerUser(final UserTotalDto userTotalDto) {

//    EntityManagerFactory 생성. 데이터 베이스 연결 정보와 JPA설정을 가지고 있는 객체이다.
//    일반적으로 어플리케이션의 생명주기 동안 하나의 EntityManagerFactory를 생성한다.
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("your-persistence-unit");
//    하지만 스프링 부트에서는 팩토리 생성을 하지 않아도 별도로 관리를 해준다.

//    EntityManager를 생성. 실제로 데이터 베이스와의 작업을 수행하는 주요 인터페이스이다.
//    EntityManagerFactory를 이용하여 생성한다.
//    EntityManager em = emf.createEntityManager();
//    트랜잭션 시작. JPA를 사용하여 데이터베이스 작업을 수행하기 전에 트랜잭션을 필수로 시작하여아한다.
//    em.getTransaction().begin();

    UserEntity user = new UserEntity(userTotalDto);
    UserProfileEntity userProfile = new UserProfileEntity(user, userTotalDto);

    user.convertUserProfile(userProfile);

    entityManager.persist(user);

    return user;
  }


  public Optional<UserEntity> findUser(final Long id) {

    return userRepository.findById(id);
  }

  public boolean isUserExists(UserTotalDto userTotalDto) {

    return (userRepository.existsByUsername(userTotalDto.getUsername())
            || userProfileRepository.existsByNickname(userTotalDto.getNickname()));
  }
}
